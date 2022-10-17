package rule

import board.Board
import movement.Movement

class IsEatingRule: Rule {
    companion object{
        fun getRule(): Rule = isEatingRule
        private val isEatingRule: Rule = IsEatingRule()
    }
    override fun validate(board: Board, movement: Movement): Boolean {
        return board.getSquare(movement.to).hasPiece()
                && board.getSquare(movement.to).getPiece().getColor() != board.getSquare(movement.from).getPiece().getColor()
    }

}