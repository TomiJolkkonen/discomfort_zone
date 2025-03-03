
# Haskell Practical Cheat Sheet

Quick reference of practical Haskell programming patterns and syntax from *Haskell Programming from First Principles*.

---

## 🛠 Basic Syntax

```haskell
-- Define a function
add :: Int -> Int -> Int
add x y = x + y

-- If expressions
absolute x = if x < 0 then -x else x

-- Let binding
let x = 5 in x * 2

-- Where clause
square x = y * y
  where y = x
```

---

## 🔢 Data Types

```haskell
-- Tuples
pair = (1, "Hello")

-- Lists
list = [1, 2, 3, 4]

-- Algebraic Data Types
data Color = Red | Green | Blue

-- Records
data Person = Person { name :: String, age :: Int }
```

---

## 🔄 Pattern Matching

```haskell
describeColor :: Color -> String
describeColor Red = "It's red!"
describeColor Green = "It's green!"
describeColor Blue = "It's blue!"
```

---

## 🔁 Recursion

```haskell
factorial :: Integer -> Integer
factorial 0 = 1
factorial n = n * factorial (n - 1)
```

---

## 🎲 Higher-Order Functions

```haskell
-- Map over a list
map (+1) [1, 2, 3]

-- Filter a list
filter even [1..10]

-- Fold a list
foldl (+) 0 [1, 2, 3, 4]
```

---

## 🔧 Anonymous Functions (Lambdas)

```haskell
map (\x -> x * 2) [1, 2, 3]
```

---

## 🔐 Typeclasses

```haskell
instance Eq Person where
  (Person n1 a1) == (Person n2 a2) = n1 == n2 && a1 == a2
```

---

## 📦 Functors and Monads

```haskell
-- Functor (fmap)
fmap (*2) (Just 3)

-- Monad (>>=)
Just 3 >>= (\x -> Just (x + 1))
```

---

## ⏩ Function Composition

```haskell
-- Compose two functions
(f . g) x

-- Example
double = (*2)
increment = (+1)
result = (double . increment) 3  -- Result is 8
```

---

## 🛠 IO Actions

```haskell
main :: IO ()
main = do
  putStrLn "What's your name?"
  name <- getLine
  putStrLn ("Hello, " ++ name ++ "!")
```

---

## 🧰 Useful Functions

```haskell
length [1, 2, 3]         -- 3
reverse [1, 2, 3]        -- [3, 2, 1]
take 2 [1, 2, 3, 4]      -- [1, 2]
drop 2 [1, 2, 3, 4]      -- [3, 4]
```

---

## 🏗 Common Libraries

- **Data.List** – Advanced list manipulation
- **Control.Monad** – Monad utilities
- **Text.Parsec** – Parsing text
- **QuickCheck** – Property-based testing
- **System.IO** – Input/Output utilities

---

## ✅ Tips

- Favor pure functions.
- Use recursion and higher-order functions over loops.
- Leverage type inference but provide type signatures for clarity.
- Practice immutability – data doesn't change, new data is created.
- Embrace laziness – computations are deferred until needed.

---

Happy Haskelling! 🌿
