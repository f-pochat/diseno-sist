package rule

import board.Board
import movement.Movement
import position.Position

class TheresRookRule: Rule {
    companion object{
        fun getRule(): Rule = theresRookRule
        private val theresRookRule: Rule = TheresRookRule()
    }
    override fun validate(board: Board, movement: Movement): Boolean {
        return (movement.to.x > movement.from.x && board.getSquare(Position(movement.to.x+1, movement.to.y)).hasPiece() && board.getSquare(Position(movement.to.x+1, movement.to.y)).getPiece().getName() == "Rook")
                ||
                (movement.to.x < movement.from.x && board.getSquare(Position(movement.to.x-1, movement.to.y)).hasPiece() && board.getSquare(Position(movement.to.x-1, movement.to.y)).getPiece().getName() == "Rook")

    }

}