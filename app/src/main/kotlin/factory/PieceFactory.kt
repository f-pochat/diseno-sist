package factory

import mover.CastlingMover
import mover.ClassicMover
import mover.CoronationMover
import piece.Piece
import rule.*

class PieceFactory {

    companion object {
        private val factory = PieceFactory()
        fun get() = factory
    }

    private val commonForAllRules = listOf(NoSameSquareRule.getRule(), NotSameColorRule.getRule())
    fun pawn(color: String): Piece {
        return Piece("Pawn" , color, commonForAllRules, listOf(
            CoronationMover(listOf(VerticalRule.getRule(), LimitRule.getLimitOneRule(), IsEmptyRule.getRule(), IsLastSquareRule.getRule(), IsForwardRule.getRule())),
            ClassicMover(listOf(VerticalRule.getRule(), LimitRule.getLimitOneRule(), IsEmptyRule.getRule(), IsForwardRule.getRule())),
            ClassicMover(listOf(VerticalRule.getRule(), LimitRule.getLimitTwoRule(), HasntMovedRule.getRule(), ClearPathRule.getRule(),  IsEmptyRule.getRule(), IsForwardRule.getRule())),
            ClassicMover(listOf(DiagonalRule.getRule(), LimitRule.getLimitOneRule(), IsEatingRule.getRule(), IsForwardRule.getRule()))
        ))
    }

    fun rook(color: String): Piece {
        return Piece("Rook" , color, commonForAllRules, listOf(
            ClassicMover(listOf(VerticalRule.getRule(), ClearPathRule.getRule())),
            ClassicMover(listOf(HorizontalRule.getRule(), ClearPathRule.getRule())))
        )
    }

    fun bishop(color: String): Piece {
        return Piece("Bishop" , color, commonForAllRules, listOf(
            ClassicMover(listOf(DiagonalRule.getRule(), ClearPathRule.getRule()))
        ))
    }

    fun knight(color: String): Piece {
        return Piece("Knight" , color, commonForAllRules, listOf(
            ClassicMover( listOf(KnightMovementRule.getRule()))
        ))
    }

    fun king(color: String): Piece {
        return Piece("King" , color, commonForAllRules, listOf(
            CastlingMover(listOf(ClearPathRule.getRule(), HorizontalRule.getRule(), LimitRule.getLimitTwoRule(), TheresRookRule.getRule(), HasntMovedRule.getRule())),
            ClassicMover(listOf(VerticalRule.getRule(), LimitRule.getLimitOneRule())),
            ClassicMover(listOf(HorizontalRule.getRule(), LimitRule.getLimitOneRule())),
            ClassicMover(listOf(DiagonalRule.getRule(), LimitRule.getLimitOneRule()))
        ))
    }

    fun queen(color: String, id: String? = null): Piece {
        return Piece("Queen" , color, commonForAllRules, listOf(
            ClassicMover(listOf(VerticalRule.getRule(), ClearPathRule.getRule())),
            ClassicMover(listOf(HorizontalRule.getRule(), ClearPathRule.getRule())),
            ClassicMover(listOf(DiagonalRule.getRule(), ClearPathRule.getRule())),
        ), id)
    }
}