#ifndef CHESS_H_INCLUDED
#define CHESS_H_INCLUDED

#include <string>
#include <iostream>

struct chessPiece{
   bool          isWhite;
   std::string   piece;
};

struct chessBoard{
   chessPiece square[8][8];
};



std::string validMoves(chessBoard board, char column, short int row);

void chessDriver();

#endif // CHESS_H_INCLUDED
