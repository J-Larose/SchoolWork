#include "Chess.h"
//"I did not use any reference material in developing this assignment."
//Jacob Larose, 101013798, COMP 1406B, assignment 2

std::string validMoves(chessBoard board, char column, short int row){
    std::string moves = "{";
    std::string taken = "{";
    int Icolumn = int(column)-97;
    row -= 1;
    chessPiece choosenPiece = board.square[row][Icolumn];
    bool white = choosenPiece.isWhite;
    char pieceChar = choosenPiece.piece[0];
    switch (pieceChar){
        int j;
        case 'R' :
            //rook, check starting from given piece, left, right, up and down untill it can move no further
            for(int i=Icolumn+1; i<8; i++){
                if(board.square[row][i].piece==""){
                    moves += char(i+97);
                    moves += char(row+49);
                    moves += ", ";
                }
                else if(board.square[row][i].isWhite != white){
                    taken += char(i+97);
                    taken += char(row+49);
                    taken += ", ";
                    break;
                }
                else{
                    break;
                }
            }
            for(int i=Icolumn-1; i>=0; i--){
                if(board.square[row][i].piece==""){
                    moves += char(i+97);
                    moves += char(row+49);
                    moves += ", ";
                }
                else if(board.square[row][i].isWhite != white){
                    taken += char(i+97);
                    taken += char(row+49);
                    taken += ", ";
                    break;
                }
                else{
                    break;
                }
            }
            for(int i=row+1; i<8; i++){
                if(board.square[i][Icolumn].piece==""){
                    moves += char(Icolumn+97);
                    moves += char(i+49);
                    moves += ", ";
                }
                else if(board.square[i][Icolumn].isWhite != white){
                    taken += char(Icolumn+97);
                    taken += char(i+49);
                    taken += ", ";
                    break;
                }
                else{
                    break;
                }
            }
            for(int i=row-1; i>=0; i--){
                if(board.square[i][Icolumn].piece==""){
                    moves += char(Icolumn+97);
                    moves += char(i+49);
                    moves += ", ";
                }
                else if(board.square[i][Icolumn].isWhite != white){
                    taken += char(Icolumn+97);
                    taken += char(i+49);
                    taken += ", ";
                    break;
                }
                else{
                    break;
                }
            }
            break;
        case 'B' :
            //bishop, check starting from given piece, all the diagonals until it can move no further
            j = row+1;
            for(int i=Icolumn+1; i<8&&j<8; i++){
                if(board.square[j][i].piece==""){
                    moves += char(i+97);
                    moves += char(j+49);
                    moves += ", ";
                }
                else if(board.square[j][i].isWhite != white){
                    taken += char(i+97);
                    taken += char(j+49);
                    taken += ", ";
                    break;
                }
                else{
                    break;
                }
                j++;
            }
            j = row-1;
            for(int i=Icolumn-1; i>=0&&j>=0; i--){
                if(board.square[j][i].piece==""){
                    moves += char(i+97);
                    moves += char(j+49);
                    moves += ", ";
                }
                else if(board.square[j][i].isWhite != white){
                    taken += char(i+97);
                    taken += char(j+49);
                    taken += ", ";
                    break;
                }
                else{
                    break;
                }
                j--;
            }
            j = Icolumn-1;
            for(int i=row+1; i<8&&j>=0; i++){
                if(board.square[i][j].piece==""){
                    moves += char(j+97);
                    moves += char(i+49);
                    moves += ", ";
                }
                else if(board.square[i][j].isWhite != white){
                    taken += char(j+97);
                    taken += char(i+49);
                    taken += ", ";
                    break;
                }
                else{
                    break;
                }
                j--;
            }
            j = Icolumn+1;
            for(int i=row-1; i>=0&&j<8; i--){
                if(board.square[i][j].piece==""){
                    moves += char(j+97);
                    moves += char(i+49);
                    moves += ", ";
                }
                else if(board.square[i][j].isWhite != white){
                    taken += char(j+97);
                    taken += char(i+49);
                    taken += ", ";
                    break;
                }
                else{
                    break;
                }
                j++;
            }
            break;
        case 'Q' :
            //queen combines both rook and bishop
            j = row+1;
            for(int i=Icolumn+1; i<8&&j<8; i++){
                if(board.square[j][i].piece==""){
                    moves += char(i+97);
                    moves += char(j+49);
                    moves += ", ";
                }
                else if(board.square[j][i].isWhite != white){
                    taken += char(i+97);
                    taken += char(j+49);
                    taken += ", ";
                    break;
                }
                else{
                    break;
                }
                j++;
            }
            j = row-1;
            for(int i=Icolumn-1; i>=0&&j>=0; i--){
                if(board.square[j][i].piece==""){
                    moves += char(i+97);
                    moves += char(j+49);
                    moves += ", ";
                }
                else if(board.square[j][i].isWhite != white){
                    taken += char(i+97);
                    taken += char(j+49);
                    taken += ", ";
                    break;
                }
                else{
                    break;
                }
                j--;
            }
            j = Icolumn-1;
            for(int i=row+1; i<8&&j>=0; i++){
                if(board.square[i][j].piece==""){
                    moves += char(j+97);
                    moves += char(i+49);
                    moves += ", ";
                }
                else if(board.square[i][j].isWhite != white){
                    taken += char(j+97);
                    taken += char(i+49);
                    taken += ", ";
                    break;
                }
                else{
                    break;
                }
                j--;
            }
            j = Icolumn+1;
            for(int i=row-1; i>=0&&j<8; i--){
                if(board.square[i][j].piece==""){
                    moves += char(j+97);
                    moves += char(i+49);
                    moves += ", ";
                }
                else if(board.square[i][j].isWhite != white){
                    taken += char(j+97);
                    taken += char(i+49);
                    taken += ", ";
                    break;
                }
                else{
                    break;
                }
                j++;
            }
            for(int i=Icolumn+1; i<8; i++){
                if(board.square[row][i].piece==""){
                    moves += char(i+97);
                    moves += char(row+49);
                    moves += ", ";
                }
                else if(board.square[row][i].isWhite != white){
                    taken += char(i+97);
                    taken += char(row+49);
                    taken += ", ";
                    break;
                }
                else{
                    break;
                }
            }
            for(int i=Icolumn-1; i>=0; i--){
                if(board.square[row][i].piece==""){
                    moves += char(i+97);
                    moves += char(row+49);
                    moves += ", ";
                }
                else if(board.square[row][i].isWhite != white){
                    taken += char(i+97);
                    taken += char(row+49);
                    taken += ", ";
                    break;
                }
                else{
                    break;
                }
            }
            for(int i=row+1; i<8; i++){
                if(board.square[i][Icolumn].piece==""){
                    moves += char(Icolumn+97);
                    moves += char(i+49);
                    moves += ", ";
                }
                else if(board.square[i][Icolumn].isWhite != white){
                    taken += char(Icolumn+97);
                    taken += char(i+49);
                    taken += ", ";
                    break;
                }
                else{
                    break;
                }
            }
            for(int i=row-1; i>=0; i--){
                if(board.square[i][Icolumn].piece==""){
                    moves += char(Icolumn+97);
                    moves += char(i+49);
                    moves += ", ";
                }
                else if(board.square[i][Icolumn].isWhite != white){
                    taken += char(Icolumn+97);
                    taken += char(i+49);
                    taken += ", ";
                    break;
                }
                else{
                    break;
                }
            }
            break;
        case '/0' :
            return "no piece here nullchr";
            break;
        default :
            return "no piece here blnk";
            break;
    }
    moves += "}\n";
    taken += "}";
    moves += taken;
    return moves;
}















/** setup up the chess board as in the assignment specification */



void chessDriver(){

    chessBoard board;

    for(int row=0; row<8; row++){
        for(int col=0; col<8; col++){
            board.square[row][col].piece = "";
        }
    }

    board.square[7][0].piece = "Rook";
    board.square[7][0].isWhite = false;

    board.square[7][1].piece = "Knight";
    board.square[7][1].isWhite = false;

    board.square[7][2].piece = "Bishop";
    board.square[7][2].isWhite = false;

    board.square[7][3].piece = "Queen";
    board.square[7][3].isWhite = false;

    board.square[7][4].piece = "King";
    board.square[7][4].isWhite = false;

    board.square[7][5].piece = "Bishop";
    board.square[7][5].isWhite = false;

    board.square[7][6].piece = "Knight";
    board.square[7][6].isWhite = false;

    board.square[7][7].piece = "Rook";
    board.square[7][7].isWhite = false;

    for(int col = 0; col<8; col++){
        board.square[6][col].piece = "Pawn";
        board.square[6][col].isWhite = false;
    }
    board.square[6][3].piece = "";       // remove the pawn in d7
    board.square[6][6].isWhite = true;   // pawn in g7 is white

    board.square[5][5].piece = "Queen";
    board.square[5][5].isWhite = true;

    std::cout << validMoves(board, 'a', 8) << std::endl;
    std::cout << validMoves(board, 'f', 6) << std::endl;
    std::cout << validMoves(board, 'd', 2) << std::endl;

    std::cout << validMoves(board, 'f', 8) << std::endl;


}
