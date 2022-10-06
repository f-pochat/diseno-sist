package chess.square

import chess.piece.Piece

class EmptySquare : Square {
    override fun hasPiece(): Boolean {
        return false
    }

    override fun getPiece(): Piece {
        throw Exception("No piece found!")
    }
}