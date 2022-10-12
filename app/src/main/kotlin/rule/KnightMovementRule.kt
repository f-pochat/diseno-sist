package rule

import board.Board
import movement.Movement

class KnightMovementRule: Rule {

    companion object{
        fun getRule(): Rule = knightMovementRule
        private val knightMovementRule: Rule = KnightMovementRule()
    }

    override fun validate(board: Board, movement: Movement): Boolean {
        TODO("Not yet implemented")
    }
}