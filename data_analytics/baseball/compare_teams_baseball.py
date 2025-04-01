import sqlite3
import pandas as pd

def get_team_stats(team_name):
    conn = sqlite3.connect("sports_data.db")
    query = f"SELECT * FROM baseball_players WHERE team = '{team_name}'"
    df = pd.read_sql(query, conn)
    conn.close()
    
    if df.empty:
        return None

    # Aggregate player stats
    team_stats = {
        "Team": team_name,
        "Avg Batting Avg": df["batting_avg"].mean(),
        "Total Home Runs": df["home_runs"].sum(),
        "Total RBIs": df["rbis"].sum()
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
