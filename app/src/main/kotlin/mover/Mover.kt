package mover

import board.Board
import movement.Movement
import rule.Rule

interface Mover {
    val validators: List<Rule>
    fun canMove(board: Board, movement: Movement): Boolean
    fun move(board: Board, movement: Movement): Board
}