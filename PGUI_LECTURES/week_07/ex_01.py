import tkinter as tk

def convert():
    try:
        bgn_amount = float(bgn_input_amount.get())
        eur_amount = round(bgn_amount / 1.95583, 2)
        eur_output_amount.config(state='normal')
        eur_output_amount.delete(0, tk.END)
        eur_output_amount.insert(0, str(eur_amount))
        eur_output_amount.config(state='readonly')
    except ValueError:
        print("Invalid input. Please enter a numeric value.")

def clear(event):
    eur_output_amount.config(state='normal')
    eur_output_amount.delete(0, tk.END)
    eur_output_amount.config(state='readonly')
    
window = tk.Tk()
window.title("BGN TO EUR CONVERTER")
window.minsize(width=500, height=100)
window.resizable(width=False, height=False)

bgn_input_label = tk.Label(text="Enter the amount of money in BGN:")
bgn_input_label.grid(row=0, column=0,padx=10, pady=10)
eur_output_label = tk.Label(text="The amount of money in EUR is:")
eur_output_label.grid(row=1, column=0,padx=10, pady=10)

bgn_input_amount = tk.Entry()
bgn_input_amount.grid(row=0, column=1,padx=10, pady=10)
eur_output_amount = tk.Entry(state='readonly')
eur_output_amount.grid(row=1, column=1,padx=10, pady=10)

bgn_input_btn = tk.Button(text="Convert",command=convert)
bgn_input_btn.grid(row=0, column=2,padx=10, pady=10)

bgn_input_amount.focus()
bgn_input_amount.bind("<Return>", lambda event: bgn_input_btn.invoke())
bgn_input_amount.bind("<Key>", clear)

window.mainloop()