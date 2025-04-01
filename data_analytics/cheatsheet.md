# Python Data Analytics Cheat Sheet

## 1. **Basic Syntax**

### Variables
```python
x = 10       # Assign value 10 to x
y = 5        # Assign value 5 to y


x = 42       # Integer
y = "Hello"  # String
z = True     # Boolean


# This is a comment


lst = [1, 2, 3]   # List
lst[0]             # Access first element
lst[-1]            # Access last element


tup = (1, 2, 3)    # Tuple
tup[0]             # Access first element


d = {'key': 'value', 'name': 'John'}
d['key']           # Access value by key


s = {1, 2, 3}      # Set
s.add(4)           # Add element


import numpy as np


arr = np.array([1, 2, 3])     # 1D array
arr_2d = np.array([[1, 2], [3, 4]])  # 2D array


arr + 5                  # Add 5 to each element
arr * 2                  # Multiply each element by 2
arr.mean()               # Calculate mean
arr.sum()                # Calculate sum
arr.std()                # Standard deviation


arr_reshaped = arr_2d.reshape(4, 1)  # Reshape to 4x1


arr_2d[0, 1]        # Access element at row 0, column 1
arr_2d[1, :]        # Select second row


import pandas as pd


df = pd.DataFrame({
    'Name': ['John', 'Jane', 'Tom'],
    'Age': [25, 28, 22]
})


df.head()       # View first 5 rows
df.tail()       # View last 5 rows
df.info()       # DataFrame info
df.describe()   # Summary statistics


df['Name']      # Access 'Name' column
df['Age'].mean()  # Mean of 'Age' column


df[df['Age'] > 25]  # Filter rows where Age > 25


df.isnull().sum()   # Count missing values
df = df.dropna()    # Drop rows with missing values
df = df.fillna(0)   # Fill missing values with 0


df['AgeGroup'] = ['Young', 'Adult', 'Young']  # Add a new column
df.drop('AgeGroup', axis=1, inplace=True)  # Remove a column


df.groupby('Age')['Name'].count()  # Count names by Age group
df.groupby('Age').agg({'Age': ['mean', 'std']})  # Aggregate Age stats


import matplotlib.pyplot as plt
import seaborn as sns


plt.plot([1, 2, 3, 4], [10, 20, 25, 30])  # Line plot
plt.xlabel('X Axis')
plt.ylabel('Y Axis')
plt.title('Line Plot')
plt.show()


plt.hist(df['Age'], bins=5, color='blue', edgecolor='black')
plt.title('Age Distribution')
plt.xlabel('Age')
plt.ylabel('Frequency')
plt.show()


plt.scatter(df['Age'], df['Name'])
plt.xlabel('Age')
plt.ylabel('Name')
plt.title('Scatter Plot')
plt.show()


sns.barplot(x='Age', y='Name', data=df)  # Bar plot
sns.boxplot(x='Age', y='Name', data=df)  # Box plot


df['Age'].mean()    # Mean of Age
df['Age'].median()  # Median of Age
df['Age'].mode()    # Mode of Age


df['Age'].std()     # Standard deviation
df['Age'].var()     # Variance


df.corr()           # Correlation matrix


from scipy import stats
stats.ttest_ind(df['Age'], df['Name'])  # T-test between two variables


from sklearn.linear_model import LinearRegression


model = LinearRegression()
model.fit(df[['Age']], df['Name'])


predictions = model.predict([[30]])  # Predict for Age = 30


df.to_csv('output.csv', index=False)  # Save to CSV


df = pd.read_csv('data.csv')  # Load CSV


df.sort_values(by='Age', ascending=False)  # Sort by Age in descending order


df['Age'].unique()  # Unique values in 'Age' column


df['Age'].apply(lambda x: x + 5)  # Apply function to each element in 'Age'


# To install a package
!pip install numpy

# Importing the package
import numpy as np


# To install a package
!pip install numpy

# Importing the package
import numpy as np
