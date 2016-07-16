import chess.{Board, BoardSize}
import chess.piece.kind._

object Main extends App {

  val pieces = List(
    King(), King(), Queen(), Rook(), Bishop(), Knight()
  )

  println(s"Pieces: ${pieces.mkString(", ")}")

  val board = Board(size = BoardSize(width = 6, height = 9))
  println(s"Board size: ${board.size}")

  println(s"Calculating distinct boards variants...")
  val boardsVariantsCount = board.calcDistinctBoardsVariantsToPlacePieces(pieces)

  println(s"Amount of boards variants: $boardsVariantsCount")

}