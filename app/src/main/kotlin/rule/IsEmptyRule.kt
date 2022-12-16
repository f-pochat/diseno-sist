package rule

import game.Game
import movement.Movement

class IsEmptyRule : Rule {
    companion object {
        fun getRule(): Rule = isEmptyRule
        private val isEmptyRule: Rule = IsEmptyRule()
    }

    override fun validate(game: Game, movement: Movement): Boolean {
        val board = game.getBoard()
        return !board.getSquare(movement.to).hasPiece()
    }
}
