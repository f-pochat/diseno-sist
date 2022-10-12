package rule

import board.Board
import movement.Movement

class LimitRule(private val limit: Int): Rule {

    companion object{
        fun getLimitOneRule(): Rule = limitOneRule
        private val limitOneRule: Rule = LimitRule(1)
        fun getLimitTwoRule(): Rule = limitTwoRule
        private val limitTwoRule: Rule = LimitRule(2)
    }

    override fun validate(board: Board, movement: Movement): Boolean {
        if (movement.from.x != movement.to.x + limit &&  movement.from.x != movement.to.x - limit &&
        movement.from.y != movement.to.y + limit &&  movement.from.y != movement.to.y - limit) throw Exception("Didnt move $limit time")
        return true
    }
}