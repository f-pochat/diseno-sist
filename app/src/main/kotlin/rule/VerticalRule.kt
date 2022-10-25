package rule

import board.Board
import game.Game
import movement.Movement

class VerticalRule: Rule {
    companion object {
        fun getRule(): Rule = verticalRule
        private val verticalRule: Rule = VerticalRule()
    }

    override fun validate(game: Game, movement: Movement): Boolean {
        return movement.from.x == movement.to.x
    }
}