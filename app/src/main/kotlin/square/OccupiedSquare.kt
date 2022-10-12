package chess.square

import piece.Piece
import square.Square

class OccupiedSquare(private val pieceOn: Piece) : Square {

    override fun hasPiece(): Boolean {
        return true
    }

    override fun getPiece(): Piece {
        return pieceOn
    }
}
