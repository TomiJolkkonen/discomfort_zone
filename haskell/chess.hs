module Main where

import Data.List
import Data.Char

type Board = [[Char]]

emptyBoard :: Board
emptyBoard =
    [ "rnbqkbnr"
    , "pppppppp"
    , "........"
    , "........"
    , "........"
    , "........"
    , "PPPPPPPP"
    , "RNBQKBNR"
    ]

displayBoard :: Board -> IO ()
displayBoard = putStrLn . unlines

movePiece :: Board -> (Int, Int) -> (Int, Int) -> Board
movePiece board (x1, y1) (x2, y2) =
    let piece = board !! x1 !! y1
        row1 = take y1 (board !! x1) ++ "." ++ drop (y1 + 1) (board !! x1)
        row2 = take y2 (board !! x2) ++ [piece] ++ drop (y2 + 1) (board !! x2)
    in take x1 board ++ [row1] ++ drop (x1 + 1) (take x2 board) ++ [row2] ++ drop (x2 + 1) board

parseMove :: String -> Maybe ((Int, Int), (Int, Int))
parseMove [f1, r1, ' ', f2, r2] =
    Just ((8 - digitToInt r1, ord f1 - ord 'a'), (8 - digitToInt r2, ord f2 - ord 'a'))
parseMove _ = Nothing

playGame :: Board -> IO ()
playGame board = do
    displayBoard board
    putStrLn "Enter your move (e.g., 'e2 e4') or 'q' to quit:"
    move <- getLine
    if move == "q"
        then putStrLn "Game over!"
        else case parseMove move of
            Just (from, to) -> playGame (movePiece board from to)
            Nothing -> putStrLn "Invalid move!" >> playGame board

main :: IO ()
main = playGame emptyBoard
