package rule

import game.Game
import movement.Movement

class IsEatingRule : Rule {
    companion object {
        fun getRule(): Rule = isEatingRule
        private val isEatingRule: Rule = IsEatingRule()
    }

    override fun validate(game: Game, movement: Movement): Boolean {
        val board = game.getBoard()
        return board.getSquare(movement.to).hasPiece() &&
            board.getSquare(movement.to).getPiece().getColor() != board.getSquare(movement.from).getPiece()
            .getColor()
    }
}
