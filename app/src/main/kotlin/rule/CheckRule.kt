package rule

import game.Game
import movement.Movement

class CheckRule : Rule {

    companion object {
        fun getRule(): Rule = checkRule
        private val checkRule: Rule = CheckRule()
    }

    override fun validate(game: Game, movement: Movement): Boolean {
        val board = game.getBoard().clone()

        val oldFromSquare = board.getSquare(movement.from)
        val oldToSquare = board.getSquare(movement.to)

        val playerColor = board.getSquare(movement.from).getPiece().getColor()

        // if not it throws error when it looks for the king
        if (oldToSquare.hasPiece() && oldToSquare.getPiece().getColor() == playerColor && oldToSquare.getPiece()
            .getName() == "King"
        ) {
            return false
        }

        board.changeWithPiece(oldFromSquare.getPiece(), movement.to)
        board.changeToEmpty(movement.from)

        val playerPieces = board.getPieces().filter { it.getColor() == playerColor }

        val playerKing = playerPieces.find { piece -> piece.getName() == "King" } ?: throw Error("King not found")

        val oppositePieces = if (playerColor == "White") {
            board.getPieces().filter { it.getColor() == "Black" }
        } else {
            board.getPieces().filter { it.getColor() == "White" }
        }

        val playerKingPosition = board.getPositionFromPiece(playerKing)

        for (piece in oppositePieces) {
            val toKingMovement = Movement(game.getBoard().getPositionFromPiece(piece), playerKingPosition)
            if (piece.canMove(game, toKingMovement)) {
                return false
            }
        }
        return true
    }
}
