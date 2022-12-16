package square

import piece.Piece

class OccupiedSquare(private val pieceOn: Piece) : Square {

    override fun hasPiece(): Boolean {
        return true
    }

    override fun getPiece(): Piece {
        return pieceOn
    }

    override fun clone(): Square {
        return OccupiedSquare(pieceOn.clone())
    }
}
