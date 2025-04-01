import sqlite3
import pandas as pd

def get_team_stats(team_name):
    conn = sqlite3.connect("sports_data.db")
    query = f"SELECT * FROM soccer_players WHERE team = '{team_name}'"
    df = pd.read_sql(query, conn)
    conn.close()
    
    if df.empty:
        return None

    # Aggregate stats
    team_stats = {
        "Team": team_name,
        "Total Goals": df["goals"].sum(),
        "Total Assists": df["assists"].sum(),
        "Avg Pass Accuracy": df["pass_accuracy"].mean()
    }
    return team_stats

def compare_teams(team1, team2):
    stats1 = get_team_stats(team1)
    stats2 = get_team_stats(team2)

    if not stats1 or not stats2:
        print("One or both teams not found in the database.")
        return

    print("\n--- Team Comparison ---")
    for key in stats1:
        if key != "Team":
            print(f"{key}: {team1} - {stats1[key]} | {team2} - {stats2[key]}")

# User Input
team1 = input("Enter first team: ")
team2 = input("Enter second team: ")
compare_teams(team1, team2)
