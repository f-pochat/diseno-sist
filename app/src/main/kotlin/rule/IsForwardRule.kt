package rule

import game.Game
import movement.Movement

class IsForwardRule(private val startingSideX: Int) : Rule {

    override fun validate(game: Game, movement: Movement): Boolean {
        return if (startingSideX == 1) {
            movement.to.y < movement.from.y
        } else {
            movement.to.y > movement.from.y
        }
    }
}
