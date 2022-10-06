package chess.rule

import chess.board.Board
import chess.movement.Movement

interface Rule {
    fun validate(board: Board, movement: Movement): Boolean
}