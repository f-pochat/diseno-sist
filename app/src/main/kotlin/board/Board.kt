package board

import square.Square
import movement.Movement
import piece.Piece
import position.Position

interface Board{
    fun getSquare(position: Position): Square
    fun move(movement: Movement)

    fun getPositionFromPiece(piece: Piece): Position
    fun printBoard()
}
