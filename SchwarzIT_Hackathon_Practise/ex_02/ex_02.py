with open("/Users/thanatos/Documents/school/transfer/SchwarzIT_Hackathon_Practise/ex_02/Message.txt", "r") as file:
    text = file.read()

message = "".join([ch for ch in text if ch.isupper()])

print(message)