package chess.board

import chess.piece.Piece
import chess.position.Position

interface Board {
    fun getPiece(position: Position): Piece
}