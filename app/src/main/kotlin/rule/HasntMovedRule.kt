package rule

import board.Board
import movement.Movement

class HasntMovedRule: Rule {
    companion object{
        fun getRule(): Rule = hasMovedRule
        private val hasMovedRule: Rule = HasntMovedRule()
    }
    override fun validate(board: Board, movement: Movement): Boolean {
        return !board.getSquare(movement.from).getPiece().getHasMoved()
    }

}