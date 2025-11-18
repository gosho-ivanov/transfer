import random
import json

dict = {}
for i in range(10):
    dict[i+1] = random.randint(1, 100)

json_object = json.dumps(dict, indent=4)
print(json_object)
