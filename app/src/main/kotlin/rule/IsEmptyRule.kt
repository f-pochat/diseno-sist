package rule

import board.Board
import movement.Movement

class IsEmptyRule: Rule {
    companion object{
        fun getRule(): Rule = isEmptyRule
        private val isEmptyRule: Rule = IsEmptyRule()
    }
    override fun validate(board: Board, movement: Movement): Boolean {
        return !board.getSquare(movement.to).hasPiece()
    }

}