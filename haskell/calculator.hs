module Main where

import Text.Read (readMaybe)

-- Define the main function
main :: IO ()
main = do
  putStrLn "Welcome to the Haskell Calculator!"
  putStrLn "Enter an expression (e.g., 2 + 3), or 'quit' to exit: "
  calculateLoop

-- Define the main loop for the calculator
calculateLoop :: IO ()
calculateLoop = do
  input <- getLine
  if input == "quit"
    then putStrLn "Goodbye!"
    else do
      let result = evaluateExpression input
      case result of
        Just r -> putStrLn $ "Result: " ++ show r
        Nothing -> putStrLn "Invalid expression"
      calculateLoop

-- Evaluate the expression
evaluateExpression :: String -> Maybe Double
evaluateExpression expr = do
  let tokens = words expr
  case tokens of
    [num1, op, num2] -> do
      x <- readMaybe num1
      y <- readMaybe num2
      case op of
        "+" -> Just (x + y)
        "-" -> Just (x - y)
        "*" -> Just (x * y)
        "/" -> if y == 0
               then Nothing
               else Just (x / y)
        _   -> Nothing
    _ -> Nothing
