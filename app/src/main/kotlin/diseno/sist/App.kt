package diseno.sist

import edu.austral.dissis.chess.gui.CachedImageResolver
import edu.austral.dissis.chess.gui.DefaultImageResolver
import edu.austral.dissis.chess.gui.GameView
import engine.CustomGameEngine
import javafx.application.Application
import javafx.application.Application.launch
import javafx.scene.Scene
import javafx.stage.Stage

fun main() {
    println("---- CHESS -------")
    println("Pick your game mode:")
    println("1 - Classic")
    println("2 - Classic 5x5")
    println("3 - Fischer")
    println("4 - Displaced")
    println("5 - Trascendental")
    println("6 - Retired")
    println("7 - Butterfly")
    println("8 - JediKnight")
    println("9 - Berlin")
    println("10 - Capablanca")
    println("11 - Random Capablanca")
    println("12 - Great")
    println("13 - Classic 4x4")
    println("14 - Demi-Chess")
    input = Integer.parseInt(readLine()!!)
    launch(ChessGameApplication::class.java)
}

var input = 0

class ChessGameApplication : Application() {
    private val gameEngine = CustomGameEngine(input)
    private val imageResolver = CachedImageResolver(DefaultImageResolver())

    companion object {
        const val GameTitle = "Chess"
    }

    override fun start(primaryStage: Stage) {
        primaryStage.title = GameTitle

        val root = GameView(gameEngine, imageResolver)
        primaryStage.scene = Scene(root)

        primaryStage.show()
    }
}
