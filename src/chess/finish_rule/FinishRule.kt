package chess.finish_rule

import chess.board.Board

interface FinishRule {
    fun checkFinish(board: Board): String
}