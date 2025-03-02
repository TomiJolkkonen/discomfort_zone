import requests

# Fetch Python repositories from GitHub API
response = requests.get("https://api.github.com/search/repositories?q=language:python")

if response.status_code == 200:
    # Parse the JSON data
    data = response.json()
    repositories = data.get("items", [])

    # Sort the repositories by "forks" in descending order
    sorted_repositories = sorted(repositories, key=lambda repo: repo["forks"], reverse=True)

    # Print the data line by line in the specified format
    print("Python Repositories:")
    for repo in sorted_repositories:
        forks = repo.get("forks", "N/A")
        name = repo.get("name", "N/A")
        description = repo.get("description", "N/A")
        print(f"Forks: {forks}. Name: {name}. Description: {description}")
else:
    print(f"Failed to fetch data. Status code: {response.status_code}")
