package rule

import game.Game
import movement.Movement

interface Rule {
    fun validate(game: Game, movement: Movement): Boolean
}
