package rule

import game.Game
import movement.Movement

class HasntMovedRule : Rule {
    companion object {
        fun getRule(): Rule = hasMovedRule
        private val hasMovedRule: Rule = HasntMovedRule()
    }

    override fun validate(game: Game, movement: Movement): Boolean {
        return !game.getMovements().any {
            game.getBoard().getSquare(it.to).hasPiece() && game.getBoard().getSquare(it.to)
                .getPiece() == game.getBoard().getSquare(movement.from).getPiece()
        }
    }
}
