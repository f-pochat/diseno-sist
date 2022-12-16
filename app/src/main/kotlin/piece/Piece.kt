package piece

import board.Board
import game.Game
import movement.Movement
import mover.Mover

data class Piece(
    private var name: String,
    private val color: String,
    private var movers: List<Mover>,
    private var uniqueId: String? = null
) {
    private val id: String = name.lowercase() + color.lowercase()
    fun getName(): String = name
    fun getColor(): String = color

    fun getUniqueId(): String {
        if (uniqueId.isNullOrBlank()) {
            uniqueId = this.hashCode().toString()
        }
        return uniqueId!!
    }

    fun getId(): String = id

    fun move(game: Game, movement: Movement): Board {
        val board = game.getBoard()
        for (m in movers) {
            if (m.canMove(game, movement)) {
                return m.move(board, movement)
            }
        }
        return board
    }

    fun canMove(game: Game, movement: Movement): Boolean =
        movers.any { m ->
            m.canMove(game, movement)
        }

    fun clone(): Piece = copy()
}
