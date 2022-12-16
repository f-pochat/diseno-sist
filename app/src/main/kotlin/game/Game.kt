package game

import board.Board
import finish_rule.CheckmateRule
import finish_rule.FinishRule
import movement.Movement

class Game(
    private val board: Board
) {
    private val movements = mutableListOf<Movement>()
    private val finishRule: List<FinishRule> = listOf(CheckmateRule())
    private var winner = ""

    fun getBoard(): Board = board

    fun getMovements(): List<Movement> = movements

    fun getWinner() = winner

    fun playerMove(movement: Movement): Board {
        if (!board.getSquare(movement.from).hasPiece()) {
            throw Exception("There is no piece there")
        }
        if (isNotCurrentPlayersTurn(movement)
        ) {
            throw Exception("It is the other player turn!")
        }
        val newBoard = board.getSquare(movement.from).getPiece().move(this, movement)
        if (newBoard !== board) {
            movements.add(movement)
        } else {
            throw Exception("Movement not valid")
        }
        finishRule.forEach {
            val winnerRule = it.check(this)
            if (winnerRule.hasWinner()) {
                winner = winnerRule.getWinnerColor()
            }
        }
        return newBoard
    }

    private fun isNotCurrentPlayersTurn(movement: Movement) =
        movements.isEmpty() && board.getSquare(movement.from).getPiece()
            .getColor() == "Black" || movements.isNotEmpty() && board.getSquare(movements[movements.size - 1].to)
            .getPiece()
            .getColor() == board.getSquare(movement.from).getPiece().getColor()

    fun getLastMove(n: Int = 0): String {
        if (movements.size < 1) {
            return "Black"
        }
        return board.getSquare(movements[movements.size - n - 1].to).getPiece().getColor()
    }
}
