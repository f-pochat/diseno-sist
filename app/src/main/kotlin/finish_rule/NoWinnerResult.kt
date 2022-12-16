package finish_rule

class NoWinnerResult : FinishResult {
    override fun hasWinner(): Boolean = false

    override fun getWinnerColor(): String = throw Exception("No winner!")
}
