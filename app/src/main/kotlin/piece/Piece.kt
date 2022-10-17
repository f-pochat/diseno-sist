package piece

import board.Board
import movement.Movement
import mover.Mover
import rule.Rule

class Piece(
    private val name: String,
    private val color: String,
    private val commonRules: List<Rule>,
    private val movers: List<Mover>
){
    private var hasMoved: Boolean = false
    private val id: String = name.lowercase() + color.lowercase()
    fun getName(): String = name
    fun getColor(): String = color
    fun getHasMoved(): Boolean = hasMoved

    fun getId(): String = id

    fun move(board: Board, movement: Movement): Board {
        if (commonRules.any { !it.validate(board, movement) }) return board
        for (m in movers){
            if (m.canMove(board, movement)){
                hasMoved = true
                return m.move(board, movement)
            }
        }
        return board
    }
}
