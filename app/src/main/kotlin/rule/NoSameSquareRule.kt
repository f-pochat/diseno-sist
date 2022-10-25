package rule

import board.Board
import game.Game
import movement.Movement

class NoSameSquareRule: Rule {
    companion object{
        fun getRule(): Rule = noSameSquareRule
        private val noSameSquareRule: Rule = NoSameSquareRule()
    }
    override fun validate(game: Game, movement: Movement): Boolean {
        return movement.to !== movement.from
    }

}