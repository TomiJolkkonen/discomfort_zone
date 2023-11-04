import pandas as pd
import numpy as np

wh = pd.read_csv("https://raw.githubusercontent.com/csmastersUH/data_analysis_with_python_2020/master/kumpula-weather-2017.csv")
wh.head()

wh2 = pd.read_csv("https://raw.githubusercontent.com/csmastersUH/data_analysis_with_python_2020/master/kumpula-weather-2017.csv")

wh3 = wh2.drop(["Year", "m", "d"], axis=1)  # taking averages over these is not very interesting
wh3.mean()

wh2.describe()