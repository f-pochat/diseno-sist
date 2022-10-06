package chess.piece

import chess.rule.Rule

class PieceMover(
        private val piece: Piece,
        private val rules: List<Rule>,
) {
    val hasMoved: Boolean = false;
}