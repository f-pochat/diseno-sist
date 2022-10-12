package game

import board.Board
import chess.finish_rule.FinishRule
import movement.Movement
import java.util.*

class Game(
    private val board: Board,
    private val finishRule: List<FinishRule>
){
    private val movements: Stack<Movement> = Stack()

    fun playerMove(movement: Movement){
        if (!board.getSquare(movement.from).hasPiece())
            throw Exception("There is no piece there")
        if (!movements.empty() && board.getSquare(movements.peek().to).getPiece().getColor() == board.getSquare(movement.from).getPiece().getColor())
            throw Exception("It is the other player turn!")
        val movementDone = board.move(movement)
        if (movementDone) movements.push(movement)
    }
}
