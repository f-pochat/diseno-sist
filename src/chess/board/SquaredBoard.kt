package chess.board

import chess.piece.Piece
import chess.position.Position
import chess.square.Square

class SquaredBoard(
        private val squares: Array<Array<Square>>): Board {
    override fun getPiece(position: Position): Piece {
        return squares[position.x][position.y].getPiece()
    }
}