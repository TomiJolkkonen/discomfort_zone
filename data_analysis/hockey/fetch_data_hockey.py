import pandas as pd
import sqlite3

# Simulated hockey dataset (replace with real data if available)
data = {
    "player": ["Player A", "Player B", "Player C", "Player D"],
    "team": ["Team X", "Team X", "Team Y", "Team Y"],
    "goals": [20, 15, 18, 22],
    "assists": [25, 20, 23, 30],
    "hits": [50, 45, 60, 55]
}

df = pd.DataFrame(data)

# Save to SQLite
conn = sqlite3.connect("sports_data.db")
df.to_sql("hockey_players", conn, if_exists="replace", index=False)
conn.close()

print("Hockey data saved to database.")
