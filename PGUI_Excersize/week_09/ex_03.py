binary_file = open("/Users/thanatos/Documents/school/transfer/PGUI_Excersize/week_09/document.BIN", "wb+")
text = "This is good."
binary_file.write(text.encode("utf-8"))
binary_file.seek(0)
data = binary_file.read()
decoded_data = data.decode("utf-8")
print(decoded_data)
binary_file.close()