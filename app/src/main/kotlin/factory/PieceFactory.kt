package factory

import mover.CastlingMover
import mover.ClassicMover
import piece.Piece
import rule.*

class PieceFactory {

    companion object {
        private val factory = PieceFactory()
        fun get() = factory
    }

    private val commonForAllRules = listOf(NoSameSquareRule.getRule(), NotSameColorRule.getRule(), CheckRule.getRule())
    fun pawn(color: String, startingPos: Int): Piece {
        return Piece(
            "Pawn",
            color,
            listOf(
                ClassicMover(
                    listOf(
                        VerticalRule.getRule(),
                        LimitRule.getLimitOneRule(),
                        IsEmptyRule.getRule(),
                        IsForwardRule(startingPos)
                    ) + commonForAllRules
                ),
                ClassicMover(
                    listOf(
                        VerticalRule.getRule(),
                        LimitRule.getLimitTwoRule(),
                        HasntMovedRule.getRule(),
                        ClearPathRule.getRule(),
                        IsEmptyRule.getRule(),
                        IsForwardRule(startingPos)
                    ) + commonForAllRules
                ),
                ClassicMover(
                    listOf(
                        DiagonalRule.getRule(),
                        LimitRule.getLimitOneRule(),
                        IsEatingRule.getRule(),
                        IsForwardRule(startingPos)
                    ) + commonForAllRules
                )
            )
        )
    }

    fun berlinPawn(color: String, startingPos: Int): Piece {
        return Piece(
            "Pawn",
            color,
            listOf(
                ClassicMover(
                    listOf(
                        VerticalRule.getRule(),
                        LimitRule.getLimitOneRule(),
                        IsEmptyRule.getRule(),
                        IsForwardRule(startingPos)
                    ) + commonForAllRules
                ),
                ClassicMover(
                    listOf(
                        DiagonalRule.getRule(),
                        LimitRule.getLimitTwoRule(),
                        HasntMovedRule.getRule(),
                        ClearPathRule.getRule(),
                        IsEmptyRule.getRule(),
                        IsForwardRule(startingPos)
                    ) + commonForAllRules
                ),
                ClassicMover(
                    listOf(
                        DiagonalRule.getRule(),
                        LimitRule.getLimitOneRule(),
                        IsEatingRule.getRule(),
                        IsForwardRule(startingPos)
                    ) + commonForAllRules
                )
            )
        )
    }

    fun rook(color: String): Piece {
        return Piece(
            "Rook",
            color,

            listOf(
                ClassicMover(listOf(VerticalRule.getRule(), ClearPathRule.getRule()) + commonForAllRules),
                ClassicMover(listOf(HorizontalRule.getRule(), ClearPathRule.getRule()) + commonForAllRules)
            )
        )
    }

    fun chancellor(color: String): Piece {
        return Piece(
            "Chancellor",
            color,

            listOf(
                ClassicMover(listOf(VerticalRule.getRule(), ClearPathRule.getRule()) + commonForAllRules),
                ClassicMover(listOf(HorizontalRule.getRule(), ClearPathRule.getRule()) + commonForAllRules),
                ClassicMover(listOf(KnightMovementRule.getRule()) + commonForAllRules)
            )
        )
    }

    fun bishop(color: String): Piece {
        return Piece(
            "Bishop",
            color,

            listOf(
                ClassicMover(listOf(DiagonalRule.getRule(), ClearPathRule.getRule()) + commonForAllRules)
            )
        )
    }

    fun archbishop(color: String): Piece {
        return Piece(
            "Archbishop",
            color,

            listOf(
                ClassicMover(listOf(KnightMovementRule.getRule()) + commonForAllRules),
                ClassicMover(listOf(DiagonalRule.getRule(), ClearPathRule.getRule()) + commonForAllRules)
            )
        )
    }

    fun knight(color: String): Piece {
        return Piece(
            "Knight",
            color,

            listOf(
                ClassicMover(listOf(KnightMovementRule.getRule()) + commonForAllRules)
            )
        )
    }

    fun jediKnight(color: String): Piece {
        return Piece(
            "Knight",
            color,

            listOf(
                ClassicMover(listOf(KnightMovementRule.getRule()) + commonForAllRules),
                ClassicMover(listOf(DiagonalRule.getRule(), LimitRule.getLimitThreeRule()) + commonForAllRules)
            )
        )
    }

    fun king(color: String): Piece {
        return Piece(
            "King",
            color,

            listOf(
                CastlingMover(
                    listOf(
                        ClearPathRule.getRule(),
                        HorizontalRule.getRule(),
                        LimitRule.getLimitTwoRule(),
                        TheresRookRule.getRule(),
                        HasntMovedRule.getRule()
                    )
                ),
                ClassicMover(listOf(VerticalRule.getRule(), LimitRule.getLimitOneRule()) + commonForAllRules),
                ClassicMover(listOf(HorizontalRule.getRule(), LimitRule.getLimitOneRule()) + commonForAllRules),
                ClassicMover(listOf(DiagonalRule.getRule(), LimitRule.getLimitOneRule()) + commonForAllRules)
            )
        )
    }

    fun queen(color: String, id: String? = null): Piece {
        return Piece(
            "Queen",
            color,

            listOf(
                ClassicMover(listOf(VerticalRule.getRule(), ClearPathRule.getRule()) + commonForAllRules),
                ClassicMover(listOf(HorizontalRule.getRule(), ClearPathRule.getRule()) + commonForAllRules),
                ClassicMover(listOf(DiagonalRule.getRule(), ClearPathRule.getRule()) + commonForAllRules)
            ),
            id
        )
    }
}
