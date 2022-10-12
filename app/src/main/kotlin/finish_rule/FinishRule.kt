package chess.finish_rule

import board.Board

interface FinishRule {
    fun checkFinish(board: Board): String
}
