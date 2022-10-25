package rule

import board.Board
import game.Game
import movement.Movement

class NotSameColorRule: Rule {
    companion object{
        fun getRule(): Rule = notSameColorRule
        private val notSameColorRule: Rule = NotSameColorRule()
    }
    override fun validate(game: Game, movement: Movement): Boolean {
        val board = game.getBoard()
        return !board.getSquare(movement.to).hasPiece() ||
                board.getSquare(movement.to).getPiece().getColor() != board.getSquare(movement.from).getPiece().getColor()
    }

}