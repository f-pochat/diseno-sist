package chess.square

import chess.piece.Piece

interface Square {
    fun hasPiece(): Boolean
    fun getPiece(): Piece
}