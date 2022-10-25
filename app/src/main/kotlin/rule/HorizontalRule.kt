package rule

import board.Board
import game.Game
import movement.Movement


class HorizontalRule: Rule {

    companion object {
        fun getRule(): Rule = horizontalRule
        private val horizontalRule: Rule = HorizontalRule()
    }

    override fun validate(game: Game, movement: Movement): Boolean {
        return movement.to.y == movement.from.y
    }
}

