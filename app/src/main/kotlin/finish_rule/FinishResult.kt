package finish_rule

interface FinishResult {
    fun hasWinner(): Boolean
    fun getWinnerColor(): String
}
