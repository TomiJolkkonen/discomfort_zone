# Apache Spark (PySpark) Cheat Sheet for Azure Synapse Analytics

## 1. **Basic Syntax**

### Variables
```python
x = 10       # Assign value 10 to x
y = 5        # Assign value 5 to y


x = 42       # Integer
y = "Hello"  # String
z = True     # Boolean


# This is a comment


from pyspark.sql import SparkSession
from pyspark.sql.functions import col, avg, sum, count


spark = SparkSession.builder.appName("SparkCheatSheet").getOrCreate()


df = spark.read.csv("path_to_file.csv", header=True, inferSchema=True)
df.show(5)  # Show the first 5 rows


df_json = spark.read.json("path_to_file.json")
df_json.show(5)


df.printSchema()  # Print the schema of the DataFrame


df.show(10)  # Show top 10 rows


df.count()  # Count number of rows in the DataFrame


df.select("Name", "Age").show()  # Select 'Name' and 'Age' columns


df = df.withColumn("AgePlusTen", df["Age"] + 10)  # Create a new column


df.filter(df["Age"] > 25).show()  # Filter rows where Age > 25


df.groupBy("Age").agg(avg("Salary")).show()  # Group by 'Age' and calculate average 'Salary'


df.groupBy("Age").count().show()  # Count the number of groups for each Age


df.groupBy("Age").agg(
    avg("Salary").alias("avg_salary"),
    sum("Salary").alias("sum_salary")
).show()  # Multiple aggregations on 'Salary'


df1.join(df2, df1["id"] == df2["id"]).show()  # Inner join on 'id'


df1.join(df2, df1["id"] == df2["id"], "left").show()  # Left join on 'id'


df1.join(df2, df1["id"] == df2["id"], "right").show()  # Right join on 'id'


df = df.withColumnRenamed("old_name", "new_name")  # Rename a column


df = df.drop("column_name")  # Drop a column


df = df.withColumn("Age", df["Age"].cast("integer"))  # Change column type to integer


from pyspark.sql.window import Window


windowSpec = Window.partitionBy("Age").orderBy("Salary")  # Define window by Age, ordered by Salary


from pyspark.sql.functions import rank

df = df.withColumn("Rank", rank().over(windowSpec))  # Rank within each partition
df.show()


df.write.csv("output_path.csv", header=True)  # Save DataFrame to CSV


df.write.parquet("output_path.parquet")  # Save DataFrame to Parquet format


df.write.format("delta").save("output_path.delta")  # Save DataFrame to Delta format


df.write.saveAsTable("table_name")  # Save as a managed table


df.createOrReplaceTempView("my_table")  # Register DataFrame as a temporary SQL table


spark.sql("SELECT Age, SUM(Salary) FROM my_table GROUP BY Age").show()  # Run SQL query


result_df = spark.sql("SELECT Age, COUNT(*) FROM my_table GROUP BY Age")  # Run query and store result


df_json = spark.read.json("path_to_json_file.json")
df_json.show()


df_json.select("person.name", "person.age").show()  # Extract nested fields


df.fillna(0).show()  # Replace missing values with 0


df.dropna().show()  # Drop rows with missing values


df.dropna(how="all").show()  # Drop rows where all values are null


from pyspark.sql.functions import to_date
df = df.withColumn("Date", to_date(df["Date_String"], "yyyy-MM-dd"))  # Convert string to date


from pyspark.sql.functions import year, month, dayofmonth
df = df.withColumn("Year", year(df["Date"]))
df = df.withColumn("Month", month(df["Date"]))
df = df.withColumn("Day", dayofmonth(df["Date"]))


from pyspark.sql.functions import datediff
df = df.withColumn("DateDiff", datediff(df["EndDate"], df["StartDate"]))


from pyspark.sql.functions import udf
from pyspark.sql.types import StringType

def upper_case(value):
    return value.upper()

upper_case_udf = udf(upper_case, StringType())
df = df.withColumn("UpperName", upper_case_udf(df["Name"]))  # Apply UDF to column


spark.udf.register("upper_case", upper_case, StringType())  # Register UDF


spark.sql("SELECT upper_case(Name) FROM my_table").show()  # Use UDF in SQL query


df.cache()  # Cache the DataFrame in memory for faster queries


df.unpersist()  # Uncache DataFrame from memory


df = df.repartition(4)  # Repartition the DataFrame into 4 partitions


df = df.coalesce(1)  # Reduce to a single partition


df.describe().show()  # Summary statistics
df.select("Age").distinct().show()  # Get unique values in a column


df.dropDuplicates().show()  # Remove duplicate rows

df_pandas = df.toPandas()  # Convert Spark DataFrame to Pandas DataFrame
