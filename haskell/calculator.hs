module Main where

import Text.Read (readMaybe)

calculate :: String -> Maybe Double
calculate expr = case words expr of
    [x, "+", y] -> (+) <$> readMaybe x <*> readMaybe y
    [x, "-", y] -> (-) <$> readMaybe x <*> readMaybe y
    [x, "*", y] -> (*) <$> readMaybe x <*> readMaybe y
    [x, "/", y] -> case readMaybe y of
                     Just 0 -> Nothing
                     Just n -> (/) <$> readMaybe x <*> Just n
                     _ -> Nothing
    _ -> Nothing

main :: IO ()
main = do
    putStrLn "Simple Calculator: Enter expressions like '3 + 4' or '5 * 6'. Type 'q' to quit."
    loop
  where
    loop = do
        putStr "> "
        expr <- getLine
        if expr == "q"
            then putStrLn "Goodbye!"
            else case calculate expr of
                Just result -> print result >> loop
                Nothing -> putStrLn "Invalid expression!" >> loop
