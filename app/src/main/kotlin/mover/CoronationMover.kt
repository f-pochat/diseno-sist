package mover

import board.Board
import game.Game
import movement.Movement
import position.Position
import rule.Rule

class CoronationMover(override val validators: List<Rule>) : Mover {

    override fun canMove(game: Game, movement: Movement): Boolean {
        return validators.all { it.validate(game, movement) }
    }

    override fun move(board: Board, movement: Movement): Board {
        val newBoard = board.changeToQueenWithMove(board.getSquare(movement.from).getPiece(), movement.to)
        return newBoard.changeToEmpty(movement.from)
    }
}