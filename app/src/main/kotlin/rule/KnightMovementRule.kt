package rule

import board.Board
import movement.Movement

class KnightMovementRule: Rule {

    companion object{
        fun getRule(): Rule = knightMovementRule
        private val knightMovementRule: Rule = KnightMovementRule()
    }

    override fun validate(board: Board, movement: Movement): Boolean {
        return (movement.from.x == movement.to.x + 1 || movement.from.x == movement.to.x - 1) &&
                (movement.from.y == movement.to.y + 2 || movement.from.y == movement.to.y - 2) ||
                (movement.from.x == movement.to.x + 2 || movement.from.x == movement.to.x - 2) &&
                (movement.from.y == movement.to.y + 1 || movement.from.y == movement.to.y - 1)
    }
}