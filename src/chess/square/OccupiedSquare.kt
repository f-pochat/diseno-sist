package chess.square

import chess.piece.Piece

class OccupiedSquare(private val pieceOn: Piece): Square {

    override fun hasPiece(): Boolean {
        return true
    }

    override fun getPiece(): Piece {
        return pieceOn
    }
}