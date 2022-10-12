package rule

import board.Board
import movement.Movement

class VerticalRule: Rule {
    companion object {
        fun getRule(): Rule = verticalRule
        private val verticalRule: Rule = VerticalRule()
    }

    override fun validate(board: Board, movement: Movement): Boolean {
        return movement.from.x == movement.to.x
    }
}