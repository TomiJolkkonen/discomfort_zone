import pandas as pd
import numpy as np
from faker import Faker
from datetime import datetime, timedelta

# Initialize Faker instance
fake = Faker()

# Part 1: Data generation

# 1. User data generation
num_users = 100
user_ids = np.arange(1, num_users + 1)
names = [fake.name() for _ in range(num_users)]
emails = [fake.email() for _ in range(num_users)]
signup_dates = [fake.date_between(start_date='-2y', end_date='today') for _ in range(num_users)]

users = pd.DataFrame({
    'user_id': user_ids,
    'name': names,
    'email': emails,
    'signup_date': signup_dates
})

# 2. Product catalogue
data = {
    'product_id': [1, 2, 3, 4, 5],
    'product_name': ['Laptop', 'Headphones', 'Coffee Mug', 'Notebook', 'Backpack'],
    'category': ['Electronics', 'Electronics', 'Kitchen', 'Stationery', 'Accessories'],
    'price': [999.99, 49.99, 12.99, 5.99, 29.99]
}

products = pd.DataFrame(data)

# 3. Transactions data
num_transactions = 500
transaction_ids = np.arange(1, num_transactions + 1)
user_id_choices = np.random.choice(user_ids, num_transactions)
product_id_choices = np.random.choice(products['product_id'], num_transactions)
quantities = np.random.randint(1, 5, size=num_transactions)  # Random quantities between 1 and 4
transaction_dates = [
    fake.date_between(start_date='-1y', end_date='today') for _ in range(num_transactions)
]

transactions = pd.DataFrame({
    'transaction_id': transaction_ids,
    'user_id': user_id_choices,
    'product_id': product_id_choices,
    'quantity': quantities,
    'transaction_date': transaction_dates
})

# Display generated data
print("Users:\n", users.head())
print("\nProducts:\n", products)
print("\nTransactions:\n", transactions.head())

# Save data to JSON format for later use
users.to_json('users.json', orient='records', date_format='iso')
products.to_json('products.json', orient='records', date_format='iso')
transactions.to_json('transactions.json', orient='records', date_format='iso')