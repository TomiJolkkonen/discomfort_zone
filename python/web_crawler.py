import requests
from bs4 import BeautifulSoup
from urllib.parse import urljoin, urlparse
import time

# Configuration
START_URL = "https://example.com"
MAX_DEPTH = 2
VISITED = set()

def crawl(url, depth=0):
    if depth > MAX_DEPTH or url in VISITED:
        return
    
    try:
        response = requests.get(url, timeout=5)
        if response.status_code != 200:
            return
    except requests.RequestException as e:
        print(f"Failed to fetch {url}: {e}")
        return
    
    print(f"{'  ' * depth}Crawling: {url}")
    VISITED.add(url)
    
    soup = BeautifulSoup(response.text, 'html.parser')
    for link in soup.find_all('a', href=True):
        href = link['href']
        full_url = urljoin(url, href)
        
        # Keep it within the same domain
        if urlparse(full_url).netloc == urlparse(START_URL).netloc:
            crawl(full_url, depth + 1)
    
    time.sleep(1)  # Be nice to the server!

if __name__ == "__main__":
    crawl(START_URL)
