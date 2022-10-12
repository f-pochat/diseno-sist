package rule

import board.Board
import movement.Movement

class NoSameSquareRule: Rule {
    companion object{
        fun getRule(): Rule = noSameSquareRule
        private val noSameSquareRule: Rule = NoSameSquareRule()
    }
    override fun validate(board: Board, movement: Movement): Boolean {
        return movement.to !== movement.from
    }

}