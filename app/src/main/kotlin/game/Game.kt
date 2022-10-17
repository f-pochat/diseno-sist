package game

import board.Board
import chess.finish_rule.FinishRule
import movement.Movement
import java.util.*

class Game(
    private val board: Board,
){
    private val movements: Stack<Movement> = Stack()
    private val finishRule: List<FinishRule> = emptyList()

    fun playerMove(movement: Movement): Board{
        if (!board.getSquare(movement.from).hasPiece())
            throw Exception("There is no piece there")
        if (!movements.empty() && board.getSquare(movements.peek().to).getPiece().getColor() == board.getSquare(movement.from).getPiece().getColor())
            throw Exception("It is the other player turn!")
        val newBoard = board.getSquare(movement.from).getPiece().move(board, movement)
        if (newBoard !== board){
            movements.push(movement)
        } else {
            throw Exception("Movement not valid")
        }
        return newBoard
    }

    fun getLastMove(): String {
        return board.getSquare(movements.peek().to).getPiece().getColor()
    }
}
