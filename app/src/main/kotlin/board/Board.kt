package board

import piece.Piece
import position.Position
import square.Square

interface Board {
    fun getSquare(position: Position): Square

    fun getPositionFromPiece(piece: Piece): Position

    fun changeWithPiece(piece: Piece, position: Position): Board

    fun changeToEmpty(position: Position): Board

    fun changeToQueenWithMove(piece: Piece, position: Position): Board

    fun getPieces(): List<Piece>

    fun getNumberOfRows(): Int

    fun getNumberOfColumns(): Int

    fun getLastRow(): Char
    fun printBoard()

    fun getSquares(): Array<Array<Square>>

    fun clone(): Board
}
