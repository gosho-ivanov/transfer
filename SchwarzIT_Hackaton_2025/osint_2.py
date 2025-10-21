"""
auto_submit_extract.py
- Requires: selenium, webdriver-manager
- pip install selenium webdriver-manager
- Usage: python auto_submit_extract.py
"""

import csv
import time
from pathlib import Path

from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.chrome.service import Service as ChromeService
from selenium.common.exceptions import (
    TimeoutException,
    NoSuchElementException,
    StaleElementReferenceException,
)
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from webdriver_manager.chrome import ChromeDriverManager


# ----- USER CONFIG -----
URL = "https://example.com/verify"      # <<< replace with the real page URL
INPUT_FILE = "input.txt"                # one answer per line
OUTPUT_CSV = "results.csv"
# timeout values
PAGE_LOAD_TIMEOUT = 15
RESPONSE_WAIT = 10
# -----------------------


def start_driver(headless=False):
    options = webdriver.ChromeOptions()
    if headless:
        options.add_argument("--headless=new")
        options.add_argument("--window-size=1200,900")
    # recommended flags for stability:
    options.add_argument("--no-sandbox")
    options.add_argument("--disable-dev-shm-usage")

    service = ChromeService(ChromeDriverManager().install())
    driver = webdriver.Chrome(service=service, options=options)
    driver.set_page_load_timeout(PAGE_LOAD_TIMEOUT)
    return driver


def find_submit_button(form):
    """
    Heuristics to find the submit button inside the form.
    """
    # try <button type="submit"> first
    try:
        return form.find_element(By.CSS_SELECTOR, 'button[type="submit"], input[type="submit"]')
    except NoSuchElementException:
        # fallback: first button
        try:
            return form.find_element(By.TAG_NAME, "button")
        except NoSuchElementException:
            return None


def capture_response(driver, form):
    """
    Tries a few strategies to capture the response that appears after submit.
    Returns a string (possibly empty).
    """

    # Strategy A: if there's a visible element with class "error" or "response" etc.
    candidates = [
        "div.error",
        "div.response",
        "div.result",
        "#response", "#result",
        "p.response", ".message", ".notice"
    ]
    for sel in candidates:
        try:
            el = driver.find_element(By.CSS_SELECTOR, sel)
            text = el.text.strip()
            if text:
                return text
        except NoSuchElementException:
            pass

    # Strategy B: element immediately after the form in DOM
    try:
        # locate the form then try to get the next sibling text
        # note: selenium doesn't have direct next-sibling so use XPath
        sibling_xpath = ".//following-sibling::*[1]"
        sibling = form.find_element(By.XPATH, sibling_xpath)
        text = sibling.text.strip()
        if text:
            return text
    except Exception:
        pass

    # Strategy C: the page might have reloaded and replaced main content - dump body text (short)
    try:
        body_text = driver.find_element(By.TAG_NAME, "body").text.strip()
        # return the first 800 characters so file doesn't explode
        return body_text[:800]
    except Exception:
        return ""


def wait_for_response_change(driver, form, old_text, timeout=RESPONSE_WAIT):
    """
    Wait until captured response differs from old_text OR until timeout.
    """
    end_time = time.time() + timeout
    while time.time() < end_time:
        try:
            new_text = capture_response(driver, form)
            if new_text != old_text:
                return new_text
        except StaleElementReferenceException:
            # DOM changed — try to capture again
            try:
                new_text = capture_response(driver, driver.find_element(By.TAG_NAME, "form"))
                if new_text != old_text:
                    return new_text
            except Exception:
                pass
        time.sleep(0.5)
    # timed out — return whatever we can capture now
    try:
        return capture_response(driver, form)
    except Exception:
        return ""


def main():
    inp = Path(INPUT_FILE)
    if not inp.exists():
        print(f"Input file {INPUT_FILE} not found.")
        return

    lines = [l.strip() for l in inp.read_text(encoding="utf-8").splitlines() if l.strip()]
    if not lines:
        print("No non-empty lines in input file.")
        return

    driver = start_driver(headless=False)  # set headless=True if you don't need to see the browser
    results = []

    try:
        for i, answer in enumerate(lines, start=1):
            print(f"[{i}/{len(lines)}] Submitting: {answer!r}")
            # Always load the page fresh to ensure form state is consistent
            try:
                driver.get(URL)
            except Exception as e:
                print("Warning: page load exception:", e)
                # try continuing; driver may still be usable

            # find the form and input field
            try:
                form = driver.find_element(By.TAG_NAME, "form")
            except NoSuchElementException:
                print("Error: could not find a <form> on the page.")
                results.append((answer, "ERROR: no form found"))
                continue

            # capture current response (so we can detect changes)
            try:
                initial_response = capture_response(driver, form)
            except Exception:
                initial_response = ""

            # fill the input; page shows <input id="answer" name="answer">
            try:
                input_el = form.find_element(By.CSS_SELECTOR, '#answer, input[name="answer"], input[type="text"]')
                input_el.clear()
                input_el.send_keys(answer)
            except NoSuchElementException:
                print("Warning: input element not found by expected selectors. Trying global lookup.")
                try:
                    input_el = driver.find_element(By.ID, "answer")
                    input_el.clear()
                    input_el.send_keys(answer)
                except Exception:
                    print("Error: couldn't find the input field to type the answer.")
                    results.append((answer, "ERROR: no input field"))
                    continue

            # find & click submit
            submit_btn = find_submit_button(form)
            if submit_btn is None:
                print("Warning: submit button not found. Trying to submit via Enter key on input.")
                try:
                    input_el.send_keys(Keys.ENTER)
                except Exception:
                    results.append((answer, "ERROR: no submit button / could not press Enter"))
                    continue
            else:
                try:
                    submit_btn.click()
                except Exception:
                    # fallback: send Enter
                    try:
                        input_el.send_keys(Keys.ENTER)
                    except Exception:
                        print("Error: couldn't submit.")
                        results.append((answer, "ERROR: couldn't submit"))
                        continue

            # Wait for response (tries to detect change)
            response_text = ""
            try:
                response_text = wait_for_response_change(driver, form, initial_response, timeout=RESPONSE_WAIT)
            except Exception as e:
                print("Warning while waiting for response:", e)
                # attempt to capture something anyway
                try:
                    response_text = capture_response(driver, form)
                except Exception:
                    response_text = ""

            print(f" => Response captured (len {len(response_text)}): {response_text[:200]!r}")
            results.append((answer, response_text))

            # optional short pause to be polite/avoid rate limits
            time.sleep(0.5)

    finally:
        driver.quit()

    # save to CSV
    with open(OUTPUT_CSV, "w", newline="", encoding="utf-8") as f:
        w = csv.writer(f)
        w.writerow(["input", "response"])
        for r in results:
            w.writerow(r)

    print(f"Done. Results saved to {OUTPUT_CSV}")


if __name__ == "__main__":
    main()
