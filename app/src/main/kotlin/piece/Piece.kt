package piece

import board.Board
import factory.PieceFactory
import game.Game
import movement.Movement
import mover.Mover
import rule.Rule

class Piece(
    private var name: String,
    private val color: String,
    private val commonRules: List<Rule>,
    private var movers: List<Mover>,
    private var uniqueId: String? = null
){
    private val id: String = name.lowercase() + color.lowercase()
    fun getName(): String = name
    fun getColor(): String = color

    fun getUniqueId(): String {
        if (uniqueId.isNullOrBlank()){
            uniqueId = this.hashCode().toString()
        }
        return uniqueId!!
    }

    fun getId(): String = id

    fun move(game: Game, movement: Movement): Board {
        val board = game.getBoard()
        if (commonRules.any { !it.validate(game, movement) }) return board
        for (m in movers){
            if (m.canMove(game, movement)){
                return m.move(board, movement)
            }
        }
        return board
    }
}
