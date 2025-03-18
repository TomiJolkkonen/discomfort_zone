import pandas as pd
import matplotlib.pyplot as plt
import seaborn as sns
import os

def load_data(filename):
    """Loads player statistics data from a CSV file."""
    return pd.read_csv(filename)

def analyze_correlations(df):
    """Generates a heatmap of correlations between numerical stats."""
    plt.figure(figsize=(12, 8))
    sns.heatmap(df.corr(numeric_only=True), annot=True, cmap='coolwarm', fmt='.2f')
    plt.title('Correlation Heatmap')
    plt.show()

def player_trends(df, player_name):
    """Plots trends in a specific player's performance over time."""
    player_data = df[df['Player'] == player_name]
    if player_data.empty:
        print(f"No data found for player: {player_name}")
        return
    
    plt.figure(figsize=(10, 5))
    for stat in ['Goals', 'Assists', 'Points']:
        if stat in player_data.columns:
            plt.plot(player_data['Season'], player_data[stat], marker='o', label=stat)
    
    plt.xlabel('Season')
    plt.ylabel('Stat Value')
    plt.title(f'Performance Trend for {player_name}')
    plt.legend()
    plt.xticks(rotation=45)
    plt.show()

def main():
    filename = 'Player Season Totals - Natural Stat Trick.csv'
    if not os.path.exists(filename):
        print(f"Error: {filename} not found in the directory.")
        return
    
    df = load_data(filename)
    
    print("Data Loaded. First few rows:")
    print(df.head())
    
    analyze_correlations(df)
    
    player_name = input("Enter player name to analyze trends: ")
    player_trends(df, player_name)
    
if __name__ == "__main__":
    main()