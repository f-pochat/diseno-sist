package finish_rule

import game.Game
import movement.Movement
import position.Position

class CheckmateRule : FinishRule {
    override fun check(gameState: Game): FinishResult {
        val colorToCheck = if (gameState.getLastMove() == "White") {
            "Black"
        } else {
            "White"
        }
        val board = gameState.getBoard()
        val pieces = board.getPieces().filter { it.getColor() === colorToCheck }
        for (piece in pieces) {
            val piecePosition = board.getPositionFromPiece(piece)
            for (i in 'A' until board.getLastRow()) {
                for (j in 1 until board.getNumberOfColumns() + 1) {
                    val toPosition = Position(i, j)
                    if (piece.canMove(gameState, Movement(piecePosition, toPosition))) {
                        return NoWinnerResult()
                    }
                }
            }
        }
        return WinnerResult(gameState.getLastMove())
    }
}
