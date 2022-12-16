package finish_rule

import game.Game

interface FinishRule {
    fun check(gameState: Game): FinishResult
}
