
# Data Analytics with Python & SQL Cheat Sheet

Quick reference for practical data analytics using Python, Pandas, and SQL.

---

## 🐍 Python Basics for Data Analytics

```python
# Import libraries
import pandas as pd
import numpy as np
import sqlite3
```

---

## 📊 Pandas Essentials

### Load Data
```python
df = pd.read_csv('data.csv')
df = pd.read_excel('data.xlsx')
```

### Inspect Data
```python
df.head()
df.info()
df.describe()
df.shape
```

### Select Columns & Rows
```python
df['column_name']
df[['col1', 'col2']]
df.iloc[0]  # First row
df.loc[df['col'] > 10]
```

### Filtering Data
```python
df[df['column'] == 'Value']
df[(df['col1'] > 10) & (df['col2'] < 5)]
```

### GroupBy & Aggregation
```python
df.groupby('category').mean()
df.groupby('category').agg({'sales': 'sum', 'profit': 'mean'})
```

### Sorting
```python
df.sort_values(by='column', ascending=False)
```

### Merging & Joining
```python
pd.merge(df1, df2, on='key')
pd.concat([df1, df2])
```

### Handling Missing Data
```python
df.isnull().sum()
df.fillna(0)
df.dropna()
```

### Export Data
```python
df.to_csv('output.csv', index=False)
```

---

## 🔄 SQL with Python

### Connect to SQLite Database
```python
conn = sqlite3.connect('database.db')
cursor = conn.cursor()
```

### Execute SQL Queries
```python
# Read SQL query into DataFrame
df = pd.read_sql_query("SELECT * FROM sales", conn)

# Insert data
cursor.execute("INSERT INTO sales (date, amount) VALUES (?, ?)", ('2023-01-01', 100))

# Commit and close
conn.commit()
conn.close()
```

### Example SQL Queries
```sql
SELECT * FROM sales;
SELECT date, SUM(amount) FROM sales GROUP BY date;
SELECT * FROM sales WHERE amount > 100;
```

---

## 🔄 Pandas + SQLAlchemy (Alternative)
```python
from sqlalchemy import create_engine
engine = create_engine('sqlite:///database.db')
df = pd.read_sql("SELECT * FROM sales", engine)
```

---

## 📈 Visualization Basics
```python
import matplotlib.pyplot as plt
import seaborn as sns

# Line plot
df.plot(x='date', y='sales', kind='line')

# Bar plot
df['category'].value_counts().plot(kind='bar')

# Heatmap
sns.heatmap(df.corr(), annot=True)
```

---

## ✅ Tips

- Use `.apply()` for custom functions on DataFrames.
- Optimize memory with `.astype()` and by selecting dtypes carefully.
- Profile your data with `pandas_profiling` or `ydata-profiling`.
- For large datasets, consider `dask` or `modin` for parallelized operations.

---

Happy Analyzing! 📊
