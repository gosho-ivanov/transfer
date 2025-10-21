const display = document.getElementById("display");
const themeSelector = document.getElementById("themeSelector");
const modeToggle = document.getElementById("modeToggle");
const historyList = document.getElementById("historyList");
const normalKeys = document.getElementById("normal-keys");
const scientificKeys = document.getElementById("scientific-keys");
const angleToggle = document.getElementById("angleToggle");


let history = JSON.parse(localStorage.getItem("calcHistory")) || [];
let inputs = [];

// --- Apply saved theme and mode ---
const savedTheme = localStorage.getItem("theme") || "light";
const savedMode = localStorage.getItem("mode") || "normal";
applyTheme(savedTheme);
themeSelector.value = savedTheme;
modeToggle.value = savedMode;
toggleMode(savedMode);
updateHistory();
const savedAngleMode = localStorage.getItem("angleMode") || "deg";
angleToggle.value = savedAngleMode;


// --- Event listeners ---
themeSelector.addEventListener("change", () => {
  const theme = themeSelector.value;
  applyTheme(theme);
  localStorage.setItem("theme", theme);
});

modeToggle.addEventListener("change", () => {
  const mode = modeToggle.value;
  toggleMode(mode);
  localStorage.setItem("mode", mode);
});

angleToggle.addEventListener("change", () => {
  const mode = angleToggle.value;
  localStorage.setItem("angleMode", mode);
});


document.querySelectorAll(".btn").forEach((button) => {
  button.addEventListener("click", () => {
    const value = button.textContent;

    if (button.id === "clearHistoryBtn") return;

    else if (button.classList.contains("clear")) {
      // CE: erase last input
      if (inputs.length > 0) {
        inputs.pop();
        display.value = inputs.join('');
      }

    } else if (button.classList.contains("clear-all")) {
      // C: full clear
      display.value = "";
      inputs = [];

    } else if (button.classList.contains("equal")) {
      try {
        let expr = display.value;

        // Replace constants
        expr = expr.replace(/π/g, Math.PI);
        expr = expr.replace(/e/g, Math.E);

        // Replace functions with Math equivalents
        expr = expr.replace(/√\(/g, "Math.sqrt(");
        expr = expr.replace(/log\(/g, "Math.log10(");
        expr = expr.replace(/ln\(/g, "Math.log(");

        // Factorial (n!)
        expr = expr.replace(/(\d+)!/g, (_, n) => factorial(parseFloat(n)));

        // Trig functions (handle DEG/RAD)
        const angleMode = angleToggle.value;
        if (angleMode === "deg") {
          expr = expr
            .replace(/sin\(([^)]+)\)/g, (_, angle) => `Math.sin((${angle})*Math.PI/180)`)
            .replace(/cos\(([^)]+)\)/g, (_, angle) => `Math.cos((${angle})*Math.PI/180)`)
            .replace(/tan\(([^)]+)\)/g, (_, angle) => `Math.tan((${angle})*Math.PI/180)`);
        } else {
          expr = expr
            .replace(/sin\(([^)]+)\)/g, (_, angle) => `Math.sin(${angle})`)
            .replace(/cos\(([^)]+)\)/g, (_, angle) => `Math.cos(${angle})`)
            .replace(/tan\(([^)]+)\)/g, (_, angle) => `Math.tan(${angle})`);
        }

        const result = eval(expr);
        addToHistory(`${display.value} = ${result}`);
        display.value = result;
        inputs = [result.toString()];
      } catch (err) {
        display.value = "Error";
        inputs = [];
        console.error(err);
      }
    } else if (button.classList.contains("func")) {
      applyFunction(value);

    } else if (button.classList.contains("const")) {
      // Handle constants
      if (value === "π") {
        display.value += Math.PI;
        inputs.push(Math.PI.toString());
      } else if (value === "e") {
        display.value += Math.E;
        inputs.push(Math.E.toString());
      }

    } else {
      // append character (numbers, operators, parentheses)
      display.value += value;
      inputs.push(value);
    }
  });
});


// --- Functions ---
function applyTheme(theme) {
  document.body.className = ""; // remove previous
  if (theme !== "light") document.body.classList.add(theme);
}

function toggleMode(mode) {
  if (mode === "scientific") {
    scientificKeys.classList.remove("hidden");
  } else {
    scientificKeys.classList.add("hidden");
  }
}

// Factorial helper
function factorial(n) {
  if (n < 0) return NaN;
  if (n === 0 || n === 1) return 1;
  let res = 1;
  for (let i = 2; i <= n; i++) res *= i;
  return res;
}

function applyFunction(func) {
  // Insert function text into display instead of evaluating immediately
  switch (func) {
    case "sin":
    case "cos":
    case "tan":
    case "log":
    case "ln":
      display.value += func + "(";
      inputs.push(func + "(");
      break;

    case "√":
      display.value += "√(";
      inputs.push("√(");
      break;

    case "x²":
      display.value += "**2";
      inputs.push("**2");
      break;

    case "x³":
      display.value += "**3";
      inputs.push("**3");
      break;

    case "xʸ":
      display.value += "**";
      inputs.push("**");
      break;

    case "n!":
      display.value += "!";
      inputs.push("!");
      break;
  }
}


function addToHistory(entry) {
  history.unshift(entry);
  if (history.length > 10) history.pop();
  localStorage.setItem("calcHistory", JSON.stringify(history));
  updateHistory();
}

function updateHistory() {
  historyList.innerHTML = history.map((h) => `<li>${h}</li>`).join("");
}

function clearHistory() {
  history = [];
  localStorage.removeItem("calcHistory");
  updateHistory();
}

document.getElementById("clearHistoryBtn").addEventListener("click", clearHistory);
