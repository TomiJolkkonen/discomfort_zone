module Main where

import System.IO
import System.Directory

filename :: FilePath
filename = "recipes.txt"

addRecipe :: IO ()
addRecipe = do
    putStrLn "Enter recipe name:"
    name <- getLine
    putStrLn "Enter ingredients (comma separated):"
    ingredients <- getLine
    appendFile filename (name ++ ":" ++ ingredients ++ "\n")
    putStrLn "Recipe added!"

viewRecipes :: IO ()
viewRecipes = do
    exists <- doesFileExist filename
    if exists
        then do
            content <- readFile filename
            putStrLn "Recipes:"
            putStrLn content
        else putStrLn "No recipes found."

deleteRecipes :: IO ()
deleteRecipes = do
    exists <- doesFileExist filename
    if exists
        then removeFile filename >> putStrLn "All recipes deleted!"
        else putStrLn "No recipes to delete."

main :: IO ()
main = do
    putStrLn "Recipe Manager"
    putStrLn "1. Add Recipe"
    putStrLn "2. View Recipes"
    putStrLn "3. Delete All Recipes"
    putStrLn "4. Quit"
    putStr "Choose an option: "
    option <- getLine
    case option of
        "1" -> addRecipe >> main
        "2" -> viewRecipes >> main
        "3" -> deleteRecipes >> main
        "4" -> putStrLn "Goodbye!"
        _   -> putStrLn "Invalid choice!" >> main
