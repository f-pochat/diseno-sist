package mover

import board.Board
import game.Game
import movement.Movement
import position.Position
import rule.Rule

class CastlingMover(override val validators: List<Rule>) : Mover {

    override fun canMove(game: Game, movement: Movement): Boolean {
        return validators.all { it.validate(game, movement) }
    }

    override fun move(board: Board, movement: Movement): Board {
        var newBoard = board.changeWithPiece(board.getSquare(movement.from).getPiece(), movement.to)
        newBoard = newBoard.changeToEmpty(movement.from)

        val whiteShortCastling = movement.to.x > movement.from.x && movement.to.y == board.getNumberOfRows() + 1
        val blackShortCastling = movement.to.x < movement.from.x && movement.to.y == 1
        val blackLongCastling = movement.to.x > movement.from.x && movement.to.y == 1
        return if(blackShortCastling){
            val rookBoard = newBoard.changeWithPiece(board.getSquare(Position(movement.to.x-1, movement.to.y)).getPiece(), Position(movement.to.x+1, movement.to.y))
            rookBoard.changeToEmpty(Position(movement.to.x-1, movement.to.y))
        }else if (whiteShortCastling){
            val rookBoard = newBoard.changeWithPiece(board.getSquare(Position(movement.to.x+1, movement.to.y)).getPiece(), Position(movement.to.x-1, movement.to.y))
            rookBoard.changeToEmpty(Position(movement.to.x+1, movement.to.y))
        }else if(blackLongCastling) {
            val rookBoard = newBoard.changeWithPiece(board.getSquare(Position(movement.to.x+2, movement.to.y)).getPiece(), Position(movement.to.x-1, movement.to.y))
            rookBoard.changeToEmpty(Position(movement.to.x+2, movement.to.y))
        }else{
            val rookBoard = newBoard.changeWithPiece(board.getSquare(Position(movement.to.x-2, movement.to.y)).getPiece(), Position(movement.to.x+1, movement.to.y))
            rookBoard.changeToEmpty(Position(movement.to.x-2, movement.to.y))
        }
    }
}