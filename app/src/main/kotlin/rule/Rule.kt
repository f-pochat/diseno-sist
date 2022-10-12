package rule

import board.Board
import movement.Movement

interface Rule {
    fun validate(board: Board, movement: Movement): Boolean
}