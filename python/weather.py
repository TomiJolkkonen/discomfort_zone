import numpy as np
import pandas as pd
a=pd.read_csv("https://raw.githubusercontent.com/csmastersUH/data_analysis_with_python_2020/master/kumpula-weather-2017.csv")['Air temperature (degC)'].values

print("Number of days with the temperature below zero", np.sum(a < 0))
