package square

import piece.Piece
import square.Square

class EmptySquare : Square {
    override fun hasPiece(): Boolean {
        return false
    }

    override fun getPiece(): Piece {
        throw Exception("No piece found!")
    }
}
