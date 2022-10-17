package board

import piece.Piece
import square.EmptySquare
import chess.square.OccupiedSquare
import position.Position
import square.Square

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

    override fun changeWithPiece(piece: Piece, position: Position): Board {
        if (getSquare(position).hasPiece()){
            deadPieces.add(getSquare(position).getPiece())
        }
        //Because arrays are 0-7
        val auxSquares = squares
        auxSquares[position.y - 1][charToInt(position.x)] = OccupiedSquare(piece)
        println(squares[position.y - 1][charToInt(position.x)].getPiece().getName())
        return SquaredBoard(auxSquares)
    }
    override fun changeToEmpty(position: Position): Board {
        //Because arrays are 0-7
        val auxSquares = squares.clone()
        auxSquares[position.y - 1][charToInt(position.x)] = EmptySquare()
        return SquaredBoard(auxSquares)
    }

    override fun getPieces(): List<Piece> {
        val pieces = mutableListOf<Piece>()
        squares.forEach { c ->
            run {
                println()
                c.forEach { s ->
                    if (s.hasPiece()) {
                        pieces.add(s.getPiece())
                    }
                }
            }
        }
        return pieces
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
