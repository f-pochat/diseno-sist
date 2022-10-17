package rule

import board.Board
import movement.Movement
import position.Position

class ClearPathRule: Rule {
    companion object{
        fun getRule(): Rule = clearPathRule
        private val clearPathRule: Rule = ClearPathRule()
    }
    override fun validate(board: Board, movement: Movement): Boolean {
        val distX = movement.to.x - movement.from.x
        val distY = movement.to.y - movement.from.y
        if (distX == 0 && distY > 0) {
            for (y in 1 until distY) {
                if (board.getSquare(Position(movement.from.x, movement.from.y + y)).hasPiece()) {
                    return false
                }
            }
        }else if(distX == 0 && distY < 0){
            for (y in distY+1..-1) {
                if (board.getSquare(Position(movement.from.x, movement.from.y + y)).hasPiece()) {
                    return false
                }
            }
        }else if (distY == 0 && distX > 0) {
            for (x in 1 until distX) {
                if (board.getSquare(Position(movement.from.x + x, movement.from.y)).hasPiece()) {
                    return false
                }
            }
        }else if(distY == 0 && distX < 0){
            for (x in distX+1..-1) {
                if (board.getSquare(Position(movement.from.x + x, movement.from.y)).hasPiece()) {
                    return false
                }
            }
        }else if (distY > 0 && distX > 0){
            for (x in 1 until distX){
                if (board.getSquare(Position(movement.from.x + x, movement.from.y + x)).hasPiece()){
                    return false
                }
            }
        }else if (distY < 0 && distX > 0){
            for (x in 1 until distX){
                if (board.getSquare(Position(movement.from.x + x, movement.from.y - x)).hasPiece()){
                    return false
                }
            }
        }else if (distY < 0){
            for (x in distX+1..-1){
                if (board.getSquare(Position(movement.from.x + x, movement.from.y + x)).hasPiece()){
                    return false
                }
            }
        }else {
            for (x in distX+1..-1){
                if (board.getSquare(Position(movement.from.x + x, movement.from.y - x)).hasPiece()){
                    return false
                }
            }
        }
        return true
    }
}