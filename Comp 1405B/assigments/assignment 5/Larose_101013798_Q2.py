def InputBoard():
    board = []
    for row in range(0, 3):
        board.append([])
        string = input("What is the next row? ")
        for piece in string:
            board[row].append(piece)
    return board

def CalculateScore(board, values):
    black = 0
    white = 0
    for row in board:
        for piece in row:
            if piece!="k" and piece!="K" and piece!="-":
                if piece.isupper():
                    black += values[piece]
                elif piece.islower():
                    white += values[piece]
    print("black:", end = "")
    print(black)
    print("white:", end  = "")
    print(white)
    if black>white:
        print("Black is winning")
    elif white>black:
        print("White is winning")
    else:
        print("They are tied")
def Main():
    values = {"p": 1, "P": 1, "r": 5, "R": 5, "n": 3, "N": 3, "b": 3, "B": 3, "q": 10, "Q": 10}
    board = InputBoard()
    CalculateScore(board, values)

Main()