import pandas as pd
import sqlite3

# Simulating a baseball dataset
data = {
    "player": ["Player A", "Player B", "Player C", "Player D"],
    "team": ["Team X", "Team X", "Team Y", "Team Y"],
    "batting_avg": [0.310, 0.275, 0.290, 0.305],
    "home_runs": [25, 18, 20, 27],
    "rbis": [80, 70, 75, 85]
}

df = pd.DataFrame(data)

# Save to SQLite
conn = sqlite3.connect("sports_data.db")
df.to_sql("baseball_players", conn, if_exists="replace", index=False)
conn.close()

print("Baseball data saved to database.")
