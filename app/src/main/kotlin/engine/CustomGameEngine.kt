package engine

import edu.austral.dissis.chess.gui.*
import engine.ClassicGame.*

class CustomGameEngine(gameNumber: Int) : GameEngine {

    private val classicGame: GameMode = when (gameNumber) {
        1 -> ClassicGame()
        2 -> Classic5Game()
        3 -> FischerGame()
        4 -> DisplacedGame()
        5 -> TrascendentalGame()
        6 -> RetiredGame()
        7 -> ButterflyGame()
        8 -> JediGame()
        9 -> BerlinGame()
        10 -> CapablancaGame()
        11 -> RandomCapablancaGame()
        12 -> GreatGame()
        13 -> Classic4Game()
        14 -> Demi4Game()
        else -> {
            throw Exception("Game not found!")
        }
    }

    override fun applyMove(move: Move): MoveResult {
        return try {
            classicGame.move(move)
            val winner = classicGame.hasWinner()
            if (won(winner)) {
                return GameOver(classicGame.getWinner())
            }
            NewGameState(classicGame.pieces(), classicGame.nextMove())
        } catch (e: Exception) {
            InvalidMove(e.message!!)
        }
//        classicGame.move(move)
//        val winner = classicGame.hasWinner()
//        println(winner)
//        if (winner != "") {
//            return GameOver(classicGame.getWinner())
//        }
//        return NewGameState(classicGame.pieces(), classicGame.nextMove())
    }

    private fun won(winner: String) = winner != ""

    override fun init(): InitialState {
        return InitialState(
            BoardSize(
                classicGame.getBoard().getNumberOfRows(),
                classicGame.getBoard().getNumberOfColumns()
            ),
            classicGame.pieces(),
            PlayerColor.WHITE
        )
    }
}
