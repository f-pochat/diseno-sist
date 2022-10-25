package mover

import board.Board
import game.Game
import movement.Movement
import rule.Rule

interface Mover {
    val validators: List<Rule>
    fun canMove(game: Game, movement: Movement): Boolean
    fun move(board: Board, movement: Movement): Board
}