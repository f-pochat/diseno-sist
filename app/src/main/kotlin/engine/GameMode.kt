package engine

import board.Board
import edu.austral.dissis.chess.gui.ChessPiece
import edu.austral.dissis.chess.gui.Move
import edu.austral.dissis.chess.gui.PlayerColor

interface GameMode {
    fun move(move: Move)
    fun hasWinner(): String
    fun getWinner(): PlayerColor
    fun pieces(): List<ChessPiece>
    fun nextMove(): PlayerColor
    fun getBoard(): Board
}
