package rule

import board.Board
import game.Game
import movement.Movement

class IsForwardRule: Rule {
    companion object{
        fun getRule(): Rule = isForwardRule
        private val isForwardRule: Rule = IsForwardRule()
    }
    override fun validate(game: Game, movement: Movement): Boolean {
        return (movement.to.y < movement.from.y  )
                ||
                (movement.to.y > movement.from.y )
    }

}