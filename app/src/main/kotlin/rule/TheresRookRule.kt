package rule

import board.Board
import game.Game
import movement.Movement
import position.Position

class TheresRookRule: Rule {
    companion object{
        fun getRule(): Rule = theresRookRule
        private val theresRookRule: Rule = TheresRookRule()
    }
    override fun validate(game: Game, movement: Movement): Boolean {
        val board = game.getBoard()
        return (movement.to.x > movement.from.x && board.getSquare(Position(movement.to.x+1, movement.to.y)).hasPiece() && board.getSquare(Position(movement.to.x+1, movement.to.y)).getPiece().getName() == "Rook")
                ||
                (movement.to.x < movement.from.x && board.getSquare(Position(movement.to.x-1, movement.to.y)).hasPiece() && board.getSquare(Position(movement.to.x-1, movement.to.y)).getPiece().getName() == "Rook")
                ||
                (movement.to.x > movement.from.x && board.getSquare(Position(movement.to.x + 2, movement.to.y)).hasPiece() && board.getSquare(Position(movement.to.x+2,movement.to.y)).getPiece().getName() == "Rook" && !board.getSquare(Position(movement.to.x+1, movement.to.y)).hasPiece())
                ||
                (movement.to.x < movement.from.x && board.getSquare(Position(movement.to.x - 2, movement.to.y)).hasPiece() && board.getSquare(Position(movement.to.x-2,movement.to.y)).getPiece().getName() == "Rook" && !board.getSquare(Position(movement.to.x-1, movement.to.y)).hasPiece())

    }

}