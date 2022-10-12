package rule

import board.Board
import movement.Movement

class ClearPathRule: Rule {
    companion object{
        fun getRule(): Rule = clearPathRule
        private val clearPathRule: Rule = ClearPathRule()
    }
    override fun validate(board: Board, movement: Movement): Boolean {
        val distX = movement.to.x - movement.from.x
        val distY = movement.to.y - movement.from.y
        TODO("Implemtn")
    }
}