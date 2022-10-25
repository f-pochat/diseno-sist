package finish_rule

import board.Board

class EatenKingFinishRule: FinishRule {
    override fun checkFinish(board: Board): String {
        val kings = board.getPieces().filter { it.getName() === "King" }
        if (kings.size == 2) return ""
        return if ((kings[0].getColor() == "Black")){
            "Black"
        }else{
            "White"
        }
    }
}