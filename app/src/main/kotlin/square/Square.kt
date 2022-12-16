package square

import piece.Piece

interface Square {
    fun hasPiece(): Boolean
    fun getPiece(): Piece

    fun clone(): Square
}
