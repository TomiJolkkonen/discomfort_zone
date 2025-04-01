import pandas as pd
import sqlite3

# Simulated soccer dataset (can be replaced with real data)
data = {
    "player": ["Player A", "Player B", "Player C", "Player D"],
    "team": ["Team X", "Team X", "Team Y", "Team Y"],
    "goals": [10, 8, 12, 9],
    "assists": [7, 5, 6, 8],
    "pass_accuracy": [85, 78, 80, 88]
}

df = pd.DataFrame(data)

# Save to SQLite
conn = sqlite3.connect("sports_data.db")
df.to_sql("soccer_players", conn, if_exists="replace", index=False)
conn.close()

print("Soccer data saved to database.")
