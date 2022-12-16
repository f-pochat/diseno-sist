import board.Board
import board.SquaredBoard
import factory.PieceFactory
import piece.Piece
import position.Position
import square.EmptySquare
import square.OccupiedSquare
import square.Square
import java.io.File
import java.util.stream.IntStream

class ChessTests {

    data class TestBoard(
        val validSquares: MutableList<Position>,
        val invalidSquares: MutableList<Position>,
        val mainPiece: Piece,
        val board: Board
    )

    private fun parseBoard(pathName: String): TestBoard {
        val validSquares = mutableListOf<Position>()
        val invalidSquares = mutableListOf<Position>()
        var mainPiece: Piece? = null
        val lines = mutableListOf<Array<Square>>()
        File(pathName).forEachLine {
            val x = mutableListOf<Square>()
            val line = it.split("|")
            val y = line[0].toInt()
            IntStream.range(1, line.size - 1).forEach { i ->
                if (line[i] == "XX") {
                    invalidSquares.add(Position(intToChar(i), y))
                    x.add(EmptySquare())
                } else if (line[i] == "OO") {
                    validSquares.add(Position(intToChar(i), y))
                    x.add(EmptySquare())
                } else if (line[i] == "  ") {
                    x.add(EmptySquare())
                } else if (line[i].length == 3) {
                    validSquares.add(Position(intToChar(i), y))
                    x.add(OccupiedSquare(toPiece(line[i].substring(1))))
                } else if (line[i].all { c -> c.isUpperCase() }) {
                    if (mainPiece == null) {
                        val piece = toPiece(line[i])
                        mainPiece = piece
                        x.add(OccupiedSquare(piece))
                    } else {
                        throw Exception("Can only have one main piece!")
                    }
                } else {
                    x.add(OccupiedSquare(toPiece(line[i])))
                }
            }
            lines.add(x.toTypedArray())
        }
        if (mainPiece == null) throw Exception("No main piece found")
        return TestBoard(
            validSquares,
            invalidSquares,
            mainPiece!!,
            SquaredBoard(lines.toTypedArray())
        )
    }

    private fun intToChar(num: Int): Char {
        return (num + 9).toString(18)[0].uppercaseChar()
    }

    private fun toPiece(str: String): Piece {
        val factory = PieceFactory.get()
        val color: String = if (str[1].lowercaseChar() == 'w') {
            "White"
        } else if (str[1].lowercaseChar() == 'b') {
            "Black"
        } else {
            throw Exception("Color not found")
        }

        return when (str[0].lowercaseChar()) {
            'p' -> factory.pawn(color, 0)
            'r' -> factory.rook(color)
            'h' -> factory.knight(color)
            'b' -> factory.bishop(color)
            'q' -> factory.queen(color)
            'k' -> factory.king(color)
            else -> {
                throw Exception("Piece not valid")
            }
        }
    }

//    @Test
//    fun checkValidMovements(){
//        val file = "/home/fedepochat/faculty/diseno-sist/app/src/test/resources/board.txt"
//        val testBoard = parseBoard(file)
//        val board = testBoard.board
//        testBoard.validSquares.forEach { s ->
//            println(testBoard.board.getPositionFromPiece(testBoard.mainPiece).x)
//            println(testBoard.board.getPositionFromPiece(testBoard.mainPiece).y)
//            println("Testing" + s.x + s.y)
//            assertTrue { testBoard.mainPiece.move(board, Movement(board.getPositionFromPiece(testBoard.mainPiece),s)).getSquare(s).getPiece() == testBoard.mainPiece }
//        }
//    }
//
//    @Test
//    fun checkInvalidMovements(){
//        val file = "/home/fedepochat/faculty/diseno-sist/app/src/test/resources/board.txt"
//        val testBoard = parseBoard(file)
//        testBoard.invalidSquares.forEach { s ->
//            println(testBoard.board.getPositionFromPiece(testBoard.mainPiece).x)
//            println(testBoard.board.getPositionFromPiece(testBoard.mainPiece).y)
//            println("Testing" + s.x + s.y)
//            assertFalse { testBoard.mainPiece.move(testBoard.board, Movement(testBoard.board.getPositionFromPiece(testBoard.mainPiece),s)).getSquare(s).hasPiece() }
//        }
//    }
}
