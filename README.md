# Battleship Solver
This is the starting point of the BattleshipCode game. The game is based on the battleship game. (https://en.wikipedia.org/wiki/Battleship_(game)).

You fire shots against a grid in order to sink all five ship. The grid has 20X20 cells. The targets are five ships of different size and shape. Each ship can be rotated (also apper diagnal)

## Carrier

|0  |1  |2  |3  |4  |5  |
|:-:|:-:|:-:|:-:|:-:|:-:|
| x |  x| x |   |   |   |
|   |  x| x | x |   |   |

## Battleship

|0  |1  |2  |3  |4  |5  |
|:-:|:-:|:-:|:-:|:-:|:-:|
| x |  x| x | x |x  | x |
|   |   |   |   |   |   |

## Submarine

|0  |1  |2  |3  |4  |5  |
|:-:|:-:|:-:|:-:|:-:|:-:|
|   |   | x |   |   |   |
|   |  x| x | x |   |   |

## Destroyer

|0  |1  |2  |3  |4  |5  |
|:-:|:-:|:-:|:-:|:-:|:-:|
| x |  x| x |   |   |   |
|   |   |   |   |   |   |

## Minesweeper

|0  |1  |2  |3  |4  |5  |
|:-:|:-:|:-:|:-:|:-:|:-:|
|   |  x| x |   |   |   |
|   |   |   |   |   |   |

# Example board


|   |0  |1  |2  |3  |4  |5  |6  |7  |8  |9  |10 |11 |12 |13 |14 |15 |16 |17 |18 |19 | 
|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|
| 0	|   | x |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |
| 1	|   | x | x |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |
| 2	|   | x | x |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |
| 3	|   |   | x |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |
| 4	|   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |
| 5	|   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |
| 6	|   |   |   |  x|   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |
| 7	|   |   |   |   | x |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |
| 8	|   |   |   |   |   | x |   |   |   |   |   |   |   |   |   |   |   |   |   |   |
| 9	|   |   |   |   |   |   |x  |   |   |   |   |   |   |   |   |   |   |   |   |   |
|10	|   |   |   |   |   |   |   | x |   |   |   |   |   |   |   |   |   |   |   |   |
|11	|   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |
|12	|   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |
|13	|   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   | x |   |
|14 |   |   |   |   |   |   |   |   |   |   | x |   |   |   |   |   |   |   | x |   |
| 15|   |   |   |   |   |   |   |   |   |  x| x |   |   |   |   |   |   |   | x |   |
| 16|   |   |   |   |   |   |   |   |   |   | x |   |   |   |   |   |   |   |   |   |
| 17|   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |
| 18|   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |
| 19|   |   |   |   |   |   |x  |  x|   |   |   |   |   |   |   |   |   |   |   |   |

## How to play
First you register as a player on the website. You will then be given a player id. For the first round you will have 20 shots. In order to shots you do a http post against the address (server-adress)/game/shoot. The content of the post will be an json array containing coordinates. So if you want to fire on x=1,y=3 and x=4,y=8 you will post 
```json
[[1 3][4 8]]
```

The result of the post will be a json:
```json
{"hits":[[8,3],[9,3],[10,3],[17,3]],"shotsNextRound":11,"roundsCompleted":5,"gameFinished":false}
```

You will receive any coordinates of hits. If you have hit all target the gameFinished will be true. You will then start again with a new board and 20 shots next round.