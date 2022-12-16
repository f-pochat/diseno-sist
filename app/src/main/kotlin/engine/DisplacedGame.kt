package engine

import board.Board
import board.SquaredBoard
import edu.austral.dissis.chess.gui.ChessPiece
import edu.austral.dissis.chess.gui.Move
import edu.austral.dissis.chess.gui.PlayerColor
import factory.PieceFactory
import game.Game
import movement.Movement
import piece.Piece
import position.Position
import square.EmptySquare
import square.OccupiedSquare
import square.Square
import edu.austral.dissis.chess.gui.Position as Pos

class DisplacedGame : GameMode {
    override fun getBoard(): Board {
        return board
    }

    private val pf = PieceFactory()
    private val firstRow: Array<Square> = arrayOf(
        OccupiedSquare(pf.rook("Black")),
        OccupiedSquare(pf.bishop("Black")),
        OccupiedSquare(pf.bishop("Black")),
        OccupiedSquare(pf.queen("Black")),
        OccupiedSquare(pf.king("Black")),
        OccupiedSquare(pf.knight("Black")),
        OccupiedSquare(pf.knight("Black")),
        OccupiedSquare(pf.rook("Black"))
    )

    private val secondRow: Array<Square> = Array(8) { OccupiedSquare(pf.pawn("Black", 6)) }
    private val seventhRow: Array<Square> = Array(8) { OccupiedSquare(pf.pawn("White", 1)) }

    private val eighthRow: Array<Square> = arrayOf(
        OccupiedSquare(pf.rook("White")),
        OccupiedSquare(pf.bishop("White")),
        OccupiedSquare(pf.bishop("White")),
        OccupiedSquare(pf.queen("White")),
        OccupiedSquare(pf.king("White")),
        OccupiedSquare(pf.knight("White")),
        OccupiedSquare(pf.knight("White")),
        OccupiedSquare(pf.rook("White"))
    )

    private var board: Board = SquaredBoard(
        arrayOf(
            firstRow,
            secondRow,
            Array(8) { EmptySquare() },
            Array(8) { EmptySquare() },
            Array(8) { EmptySquare() },
            Array(8) { EmptySquare() },
            seventhRow,
            eighthRow
        )
    )

    private val game = Game(board)

    override fun pieces(): List<ChessPiece> {
        val newPieces = mutableListOf<ChessPiece>()
        val pieces = board.getPieces()
        pieces.map { newPieces.add(pieceToUIPiece(it)) }
        return newPieces
    }

    private fun pieceToUIPiece(piece: Piece): ChessPiece {
        return ChessPiece(
            piece.getUniqueId(),
            if (piece.getColor() == "Black") {
                PlayerColor.BLACK
            } else {
                PlayerColor.WHITE
            },
            Pos(board.getPositionFromPiece(piece).y, charToInt(board.getPositionFromPiece(piece).x) + 1),
            piece.getName().lowercase()
        )
    }

    private fun charToInt(char: Char): Int {
        return char.digitToInt(18) - 10
    }

    private fun intToChar(i: Int): Char {
        return (i + 10).digitToChar(18)
    }

    override fun move(move: Move) {
        val from = Position(intToChar(move.from.column - 1), move.from.row)
        val to = Position(intToChar(move.to.column - 1), move.to.row)
        board = game.playerMove(Movement(from, to))
    }

    override fun nextMove(): PlayerColor {
        return if (game.getLastMove() == "Black") {
            PlayerColor.WHITE
        } else {
            PlayerColor.BLACK
        }
    }

    override fun hasWinner(): String {
        return game.getWinner()
    }

    override fun getWinner(): PlayerColor {
        val winner = hasWinner()
        return if (winner == "Black") {
            PlayerColor.BLACK
        } else {
            PlayerColor.WHITE
        }
    }
}
