package finish_rule

class WinnerResult(private val winnerColor: String) : FinishResult {
    override fun hasWinner(): Boolean = true

    override fun getWinnerColor(): String = winnerColor
}
