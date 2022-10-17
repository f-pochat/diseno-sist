package board

import square.Square
import movement.Movement
import piece.Piece
import position.Position

interface Board{
    fun getSquare(position: Position): Square

    fun getPositionFromPiece(piece: Piece): Position

    fun changeWithPiece(piece: Piece, position: Position): Board

    fun changeToEmpty(position: Position): Board

    fun getPieces(): List<Piece>

    fun printBoard()
}
