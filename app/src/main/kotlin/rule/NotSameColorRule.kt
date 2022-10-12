package rule

import board.Board
import movement.Movement

class NotSameColorRule: Rule {
    companion object{
        fun getRule(): Rule = notSameColorRule
        private val notSameColorRule: Rule = NotSameColorRule()
    }
    override fun validate(board: Board, movement: Movement): Boolean {
        TODO("Implement")
    }

}