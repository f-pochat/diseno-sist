package chess.game

import chess.board.Board
import chess.finish_rule.FinishRule
import chess.movement.Movement
import chess.piece.Piece
import java.util.*

class Game(
        private val board: Board,
        private val deadPieces: Array<Piece>,
        private val movements: Stack<Movement>,
        private val finishRule: List<FinishRule>
) {
}