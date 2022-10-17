class ClassicPlayTest {
//    private val horizontalAndRule: AndRule = HorizontalAndRule.Companion.getRule()
//    private val verticalRule: AndRule = VerticalRule.Companion.getRule()
//    private val diagonalAndRule: AndRule = DiagonalAndRule.Companion.getRule()
//    private val knightAndRule: AndRule = KnightAndRule.Companion.getRule()
//    private val limitOneAndRule: AndRule = LimitAndRule.Companion.getLimitOneRule()
//    private val noSameSquareRule: AndRule = NoSameSquareRule.Companion.getRule()
//    private val pawnAndRule: AndRule = PawnAndRule.Companion.getRule()
//
//    private val towerRules = listOf(horizontalAndRule, verticalRule, noSameSquareRule)
//    private val bishopRules = listOf(diagonalAndRule, noSameSquareRule)
//    private val knightRules = listOf(knightAndRule, noSameSquareRule)
//    private val kingRules = listOf(horizontalAndRule, verticalRule, diagonalAndRule, limitOneAndRule,noSameSquareRule)
//    private val queenRules = listOf(horizontalAndRule, verticalRule, diagonalAndRule,noSameSquareRule)
//    private val pawnRules = listOf(noSameSquareRule, pawnAndRule)
//
//    private val firstRow: Array<Square> = arrayOf(
//        OccupiedSquare(Piece("Tower", "Black", towerRules)),
//        OccupiedSquare(Piece("Knight", "Black", knightRules)),
//        OccupiedSquare(Piece("Bishop", "Black", bishopRules)),
//        OccupiedSquare(Piece("King", "Black", kingRules)),
//        OccupiedSquare(Piece("Queen", "Black", queenRules)),
//        OccupiedSquare(Piece("Bishop", "Black", bishopRules)),
//        OccupiedSquare(Piece("Knight", "Black", knightRules)),
//        OccupiedSquare(Piece("Tower", "Black", towerRules)),
//        )
//
//    private val secondRow: Array<Square> = Array(8) { OccupiedSquare(Piece("Pawn", "Black", pawnRules))}
//    private val seventhRow: Array<Square> = Array(8) { OccupiedSquare(Piece("Pawn", "White", pawnRules))}
//    private val eighthRow: Array<Square> = arrayOf(
//        OccupiedSquare(Piece("Tower", "White", towerRules)),
//        OccupiedSquare(Piece("Knight", "White", knightRules)),
//        OccupiedSquare(Piece("Bishop", "White", bishopRules)),
//        OccupiedSquare(Piece("Queen", "White", kingRules)),
//        OccupiedSquare(Piece("King", "White", queenRules)),
//        OccupiedSquare(Piece("Bishop", "White", bishopRules)),
//        OccupiedSquare(Piece("Knight", "White", knightRules)),
//        OccupiedSquare(Piece("Tower", "White", towerRules)),
//    )
//
//    private val board: Board = SquaredBoard(arrayOf(
//        firstRow,
//        secondRow,
//        Array(8){EmptySquare()},
//        Array(8){EmptySquare()},
//        Array(8){EmptySquare()},
//        Array(8){EmptySquare()},
//        seventhRow,
//        eighthRow
//    ))
//
//    private val game: Game = Game(board, listOf())
//    @Test
//    fun whenMovePawnOneForward_PawnMoves_Test() {
//        board.printBoard()
//        val movingPawn:Piece = board.getSquare(Position('D',2)).getPiece()
//        game.playerMove(Movement(Position('D',2), Position('D',3)))
//        assertEquals(movingPawn, board.getSquare(Position('D',3)).getPiece())
//    }
//
//    @Test
//    fun whenTriedToMovePieceFromSamePlayer_ThrowException_Test() {
//        game.playerMove(Movement(Position('D',2), Position('D',3)))
//        try{
//            game.playerMove(Movement(Position('A',2),Position('A',4)))
//        }catch (e: Exception){
//            assertEquals("It is the other player turn!", e.message)
//        }
//    }
//
//    @Test
//    fun whenTriedToMovePawnToSameSquare_ThrowException_Test(){
//        try{
//            game.playerMove(Movement(Position('D', 7), Position('D', 7)))
//
//        }catch (e: Exception){
//            assertEquals("There is a piece of your team there",e.message)
//        }
//    }
}