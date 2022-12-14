package board

import factory.PieceFactory
import piece.Piece
import position.Position
import square.EmptySquare
import square.OccupiedSquare
import square.Square

class SquaredBoard(
    private val squares: Array<Array<Square>>
) : Board {
    private val deadPieces: MutableList<Piece> = mutableListOf()

    override fun getSquare(position: Position): Square {
        // Because arrays are 0-7
        return squares[position.y - 1][charToInt(position.x)]
    }

    private fun charToInt(char: Char): Int {
        return char.digitToInt(20) - 10
    }

    override fun changeWithPiece(piece: Piece, position: Position): Board {
        if (getSquare(position).hasPiece()) {
            deadPieces.add(getSquare(position).getPiece())
        }
        // Because arrays are 0-7
        val auxSquares = squares
        auxSquares[position.y - 1][charToInt(position.x)] = OccupiedSquare(piece)
        return SquaredBoard(auxSquares)
    }

    override fun changeToEmpty(position: Position): Board {
        // Because arrays are 0-7
        val auxSquares = squares.clone()
        auxSquares[position.y - 1][charToInt(position.x)] = EmptySquare()
        return SquaredBoard(auxSquares)
    }

    override fun changeToQueenWithMove(piece: Piece, position: Position): Board {
        val pf = PieceFactory()
        val auxSquares = squares
        auxSquares[position.y - 1][charToInt(position.x)] =
            OccupiedSquare(pf.queen(piece.getColor(), piece.getUniqueId()))
        return SquaredBoard(auxSquares)
    }

    override fun getPieces(): List<Piece> {
        val pieces = mutableListOf<Piece>()
        squares.forEach { c ->
            run {
                c.forEach { s ->
                    if (s.hasPiece()) {
                        pieces.add(s.getPiece())
                    }
                }
            }
        }
        return pieces
    }

    override fun getNumberOfRows(): Int {
        return squares[0].size
    }

    override fun getNumberOfColumns(): Int {
        return squares.size
    }

    override fun getLastRow(): Char {
        return (getNumberOfRows() + 9).digitToChar(20)
    }

    override fun getSquares(): Array<Array<Square>> {
        return squares
    }

    override fun getPositionFromPiece(piece: Piece): Position {
        for (y in 1 until getNumberOfColumns() + 1) {
            for (x in 'A' until getLastRow() + 1) {
                val pos = Position(x, y)
                if (getSquare(pos).hasPiece() && getSquare(pos).getPiece() == piece) {
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

    override fun clone(): Board {
        return SquaredBoard(squares.map { it.map { a -> a.clone() }.toTypedArray() }.toTypedArray())
    }
}
