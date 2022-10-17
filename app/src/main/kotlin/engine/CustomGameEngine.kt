package engine

import edu.austral.dissis.chess.gui.*

class CustomGameEngine: GameEngine {
    private val classicGame = ClassicGame()
    override fun applyMove(move: Move): MoveResult {
        return try {
            classicGame.move(move)
            NewGameState(classicGame.pieces(),classicGame.nextMove())
        }catch (e: Exception){
            InvalidMove(e.message!!)
        }
    }

    override fun init(): InitialState {
        return InitialState(BoardSize(8,8), classicGame.pieces(), PlayerColor.WHITE)
    }




}