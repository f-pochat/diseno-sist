package rule

import game.Game
import movement.Movement

class IsLastSquareRule : Rule {
    companion object {
        fun getRule(): Rule = isLastSquareRule
        private val isLastSquareRule: Rule = IsLastSquareRule()
    }

    override fun validate(game: Game, movement: Movement): Boolean {
        val board = game.getBoard()
        return (movement.to.y < movement.from.y && movement.to.y == 1) ||
            (movement.to.y > movement.from.y && movement.to.y == board.getNumberOfRows() + 1)
    }
}
