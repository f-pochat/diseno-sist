package game

import board.Board
import finish_rule.EatenKingFinishRule
import finish_rule.FinishRule
import movement.Movement

class Game(
    private val board: Board,
){
    private val movements = mutableListOf<Movement>()
    private val finishRule: List<FinishRule> = listOf(EatenKingFinishRule())
    private var winner = "";

    fun getBoard(): Board = board

    fun getMovements(): List<Movement> = movements

    fun getWinner() = winner

    fun playerMove(movement: Movement): Board{
        if (!board.getSquare(movement.from).hasPiece())
            throw Exception("There is no piece there")
        if (movements.isNotEmpty() && board.getSquare(movements[movements.size-1].to).getPiece().getColor() == board.getSquare(movement.from).getPiece().getColor())
            throw Exception("It is the other player turn!")
        val newBoard = board.getSquare(movement.from).getPiece().move(this, movement)
        if (newBoard !== board){
            movements.add(movement)
        } else {
            throw Exception("Movement not valid")
        }
        finishRule.forEach{
            val winnerRule = it.checkFinish(board)
            if (winnerRule != "") winner = winnerRule
        }
        return newBoard
    }

    fun getLastMove(): String {
        return board.getSquare(movements[movements.size-1].to).getPiece().getColor()
    }
}
