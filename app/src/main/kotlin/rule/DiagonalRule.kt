package rule

import board.Board
import game.Game
import movement.Movement
import kotlin.math.abs

class DiagonalRule: Rule {

    companion object{
        fun getRule(): Rule = diagonalRule
        private val diagonalRule: Rule = DiagonalRule()
    }

    override fun validate(game: Game, movement: Movement): Boolean {
        return abs(movement.from.x - movement.to.x) == abs(movement.from.y - movement.to.y)
    }

}