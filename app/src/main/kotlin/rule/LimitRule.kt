package rule

import game.Game
import movement.Movement

class LimitRule(private val limit: Int) : Rule {

    companion object {
        fun getLimitOneRule(): Rule = limitOneRule
        private val limitOneRule: Rule = LimitRule(1)
        fun getLimitTwoRule(): Rule = limitTwoRule
        private val limitTwoRule: Rule = LimitRule(2)

        fun getLimitThreeRule(): Rule = limitThreeRule
        private val limitThreeRule: Rule = LimitRule(3)
    }

    override fun validate(game: Game, movement: Movement): Boolean {
        return if (movement.from.x == movement.to.x) {
            movement.from.y == movement.to.y + limit || movement.from.y == movement.to.y - limit
        } else if (movement.from.y == movement.to.y) {
            movement.from.x == movement.to.x + limit || movement.from.x == movement.to.x - limit
        } else {
            (movement.from.x == movement.to.x + limit || movement.from.x == movement.to.x - limit) &&
                (movement.from.y == movement.to.y + limit || movement.from.y == movement.to.y - limit)
        }
    }
}
