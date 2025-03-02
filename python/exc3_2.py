import json

# Create a Python dictionary
item = {
    "name": "Book of the knowledge",
    "rarity": "common",
    "durability": 100
}

# Add a key-value pair to the Python object
item["price"] = 25.99

# Add a new array to the Python object
item["authors"] = ["John", "Peter", "Mary"]

# Add a new object to the Python object
item["seller"] = {
    "name": "BookStore",
    "contact": 555
}

# Print out the updated item variable
print("Updated Python object:")
print(item)

# Print out price from the object
print("\nPrice:", item["price"])

# Print out Peter from the array
print("\nAuthor from array:", item["authors"][1])

# Print out 555 from the Python object
print("\nSeller contact:", item["seller"]["contact"])

# Remove price, seller, and description from the Python object
item.pop("price", None)
item.pop("seller", None)
item.pop("description", None)  # Assuming description was added at some point

# Print out the final item variable
print("\nFinal Python object after removals:")
print(item)

# Encode Python dictionary to JSON string
json_string = json.dumps(item)
print("\nEncoded JSON string:")
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
