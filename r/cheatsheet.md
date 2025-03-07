# R Cheat Sheet

## 1. **Basic Syntax**

### Variables
```r
x <- 10        # Assign value 10 to x
y = 5          # Alternative assignment

x <- 42        # Numeric
y <- "Hello"   # Character
z <- TRUE      # Logical


# This is a comment


v <- c(1, 2, 3)     # Numeric vector
v_char <- c("a", "b", "c") # Character vector


v[1]   # First element
v[2:3] # Slice from 2 to 3
v[length(v)] # Last element


df <- data.frame(
  Name = c("John", "Jane", "Tom"),
  Age = c(25, 28, 22)
)


df$Name   # Access Name column
df[["Age"]] # Access Age column
df[1, 2]  # Access row 1, column 2


my_function <- function(x, y) {
  return(x + y)
}
my_function(3, 4) # Returns 7


x <- 10
if (x > 5) {
  print("x is greater than 5")
} else {
  print("x is less than or equal to 5")
}


for (i in 1:5) {
  print(i)
}


x <- 1
while (x <= 5) {
  print(x)
  x <- x + 1
}


matrix_data <- matrix(1:9, nrow = 3)
apply(matrix_data, 1, sum)  # Sum of rows
apply(matrix_data, 2, sum)  # Sum of columns


list_data <- list(a = 1, b = 2, c = 3)
lapply(list_data, function(x) x * 2)  # Applies function to each element

sapply(list_data, function(x) x * 2)  # Returns simplified result (vector)


x <- 1:10
y <- x^2
plot(x, y, type = "b", col = "blue")  # Basic scatter plot with lines


data <- rnorm(100)  # Generate 100 random normal values
hist(data, main = "Histogram", col = "skyblue", border = "white")


install.packages("ggplot2")  # Install a package
library(ggplot2)             # Load a package

Commonly Used Packages
ggplot2 - For advanced plotting
dplyr - Data manipulation
tidyr - Data tidying
data.table - Fast data manipulation
9. Useful Functions
head() - View first few rows of data
tail() - View last few rows of data
summary() - Summary statistics of data
str() - Structure of an object
mean() - Calculate mean
sd() - Calculate standard deviation
sum() - Sum of elements
unique() - Unique values in a vector

date <- as.Date("2025-03-07")  # Convert string to Date
Sys.Date()                    # Current date
date + 5                       # Add 5 days


time <- as.POSIXct("2025-03-07 12:00:00")
time + 3600  # Add one hour


x <- c(1, 2, NA, 4, 5)
is.na(x)      # Check for NA values
na.omit(x)    # Remove NA values


df <- read.csv("data.csv")    # Read CSV file
df <- read.table("data.txt")  # Read text file


write.csv(df, "output.csv")   # Write to CSV
write.table(df, "output.txt") # Write to text file


?sum    # Help on the sum function
help(sum)  # Alternative method


ls()    # List all objects in the workspace


rm(list = ls())   # Remove all objects





