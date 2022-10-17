package mover

import board.Board
import movement.Movement
import position.Position
import rule.Rule

class CastlingMover(override val validators: List<Rule>) : Mover {

    override fun canMove(board: Board, movement: Movement): Boolean {
        return validators.all { it.validate(board, movement) }
    }

    override fun move(board: Board, movement: Movement): Board {
        var newBoard = board.changeWithPiece(board.getSquare(movement.from).getPiece(), movement.to)
        newBoard = newBoard.changeToEmpty(movement.from)
        return if(movement.to.x < movement.from.x && board.getSquare(Position(movement.to.x+1, movement.to.y)).hasPiece() && board.getSquare(
            Position(movement.to.x+1, movement.to.y)
        ).getPiece() .getName() === "Rook"){
            newBoard.changeWithPiece(board.getSquare(Position(movement.to.x+1, movement.to.y)).getPiece(), Position(movement.to.x-1, movement.to.y))
        }else{
            newBoard.changeWithPiece(board.getSquare(Position(movement.to.x-1, movement.to.y)).getPiece(), Position(movement.to.x+1, movement.to.y))
        }
    }
}