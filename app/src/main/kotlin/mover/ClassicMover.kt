package mover

import board.Board
import movement.Movement
import rule.Rule

class ClassicMover(override val validators: List<Rule>) : Mover {
    override fun canMove(board: Board, movement: Movement): Boolean {
        return validators.all { it.validate(board, movement) }
    }

    override fun move(board: Board, movement: Movement): Board {
        val newBoard = board.changeWithPiece(board.getSquare(movement.from).getPiece(), movement.to)
        return newBoard.changeToEmpty(movement.from)
    }
}