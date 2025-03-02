import json

# Create a Python dictionary
item = {
    "name": "Book of the knowledge",
    "rarity": "common",
    "durability": 100
}

# Encode Python dictionary to JSON string
json_string = json.dumps(item)
print("Encoded JSON string:")
print(json_string)

# Decode JSON string to Python dictionary
decoded_item = json.loads(json_string)
print("\nDecoded Python dictionary:")
print(decoded_item)

# Write JSON to a file
with open("item.json", "w") as json_file:
    json.dump(item, json_file)
    print("\nJSON data written to file 'item.json'.")

# Read JSON from a file
with open("item.json", "r") as json_file:
    loaded_item = json.load(json_file)
    print("\nJSON data read from file:")
    print(loaded_item)