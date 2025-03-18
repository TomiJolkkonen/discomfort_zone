-- Variables and Data Types
x :: Int
x = 10
y :: Float
y = 3.14
str :: String
str = "Hello"

-- Functions
add :: Int -> Int -> Int
add a b = a + b

-- Lists
numbers = [1, 2, 3, 4]
first = head numbers
rest = tail numbers

-- Pattern Matching
factorial :: Int -> Int
factorial 0 = 1
factorial n = n * factorial (n - 1)

-- Higher-Order Functions
mapExample = map (*2) [1, 2, 3, 4]
filterExample = filter even [1..10]

-- Recursion
sumList :: [Int] -> Int
sumList [] = 0
sumList (x:xs) = x + sumList xs
