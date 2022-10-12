package board

import piece.Piece
import chess.square.EmptySquare
import chess.square.OccupiedSquare
import position.Position
import square.Square
import movement.Movement

class SquaredBoard(
    private val squares: Array<Array<Square>>
) : Board {
    private val deadPieces: MutableList<Piece> = mutableListOf();
    override fun getSquare(position: Position): Square {
        //Because arrays are 0-7
        return squares[position.y - 1][charToInt(position.x)]
    }

    private fun charToInt(char: Char): Int {
        return char.digitToInt(18)-10
    }
    private fun changeWithPiece(piece: Piece, position: Position) {
        if (getSquare(position).hasPiece()){
            deadPieces.add(getSquare(position).getPiece())
        }
        //Because arrays are 0-7
        squares[position.y - 1][charToInt(position.x)] = OccupiedSquare(piece)
    }
    private fun changeToEmpty(position: Position) {
        //Because arrays are 0-7
        squares[position.y - 1][charToInt(position.x)] = EmptySquare()
    }

    override fun move(movement: Movement) {
        val piece = getSquare(movement.from).getPiece()
        if (getSquare(movement.to).hasPiece() && getSquare(movement.to).getPiece().getColor() == piece.getColor()) throw Exception("There is a piece of your team there") //TODO validator
        if (!piece.validate(this, movement)) throw Exception("Cant move ${piece.getName()} there")
        changeToEmpty(movement.from)
        changeWithPiece(piece, movement.to)
    }

    override fun getPositionFromPiece(piece: Piece): Position {
        for (y in 1..8){
            for (x in 'A'..'H'){
                val pos = Position(x, y)
                if (getSquare(pos).hasPiece() && getSquare(pos).getPiece() == piece){
                    return pos
                }
            }
        }
        throw Exception("Piece not found")
    }

    override fun printBoard() {
        squares.forEach { c ->
            run {
                println()
                c.forEach { s ->
                    if (s.hasPiece()) {
                        print(s.getPiece().getColor() + " " + s.getPiece().getName() + " | ")
                    } else {
                        print("X | ")
                    }
                }
            }
        }
    }
}
