import feedparser
import json

def load_feeds(file_path='feeds.json'):
    with open(file_path, 'r') as f:
        return json.load(f)['feeds']

def fetch_articles(feeds):
    articles = []
    for feed_url in feeds:
        feed = feedparser.parse(feed_url)
        for entry in feed.entries:
            articles.append({
                'title': entry.title,
                'link': entry.link,
                'published': entry.get('published', 'N/A'),
                'source': feed.feed.get('title', 'Unknown')
            })
    return sorted(articles, key=lambda x: x['published'], reverse=True)

if __name__ == "__main__":
    feeds = load_feeds()
    articles = fetch_articles(feeds)
    for article in articles[:10]:
        print(f"{article['published']} - {article['title']} ({article['source']})\n{article['link']}\n")
