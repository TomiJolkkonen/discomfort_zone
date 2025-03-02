import requests

# Initialize an empty list to store the cat facts
cat_facts = []

# Fetch data from the API five times
for _ in range(5):
    response = requests.get("https://catfact.ninja/fact")
    if response.status_code == 200:
        data = response.json()
        cat_facts.append(data["fact"])
    else:
        print(f"Failed to fetch data. Status code: {response.status_code}")

# Print the list of cat facts
print("\nList of Cat Facts:")
for fact in cat_facts:
    print(fact)