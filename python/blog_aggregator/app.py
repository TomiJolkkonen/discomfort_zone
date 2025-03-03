from flask import Flask, render_template
from aggregator import load_feeds, fetch_articles

app = Flask(__name__)

@app.route('/')
def home():
    feeds = load_feeds()
    articles = fetch_articles(feeds)
    return render_template('index.html', articles=articles)

if __name__ == '__main__':
    app.run(debug=True)
