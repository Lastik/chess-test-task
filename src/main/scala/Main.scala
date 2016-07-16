import chess.{Board, BoardSize}
import chess.figure.kind._

object Main extends App {

  val figures = List(
    King(), King(), Queen(), Rook(), Bishop(), Knight()
  )

  println(s"Figures: ${figures.mkString(", ")}")

  val board = Board(size = BoardSize(width = 6, height = 9))
  println(s"Board size: ${board.size}")

  println(s"Calculating distinct boards variants...")
  val boardsVariantsCount = board.calcDistinctBoardsVariantsToPlaceFigures(figures)

  println(s"Amount of boards variants: $boardsVariantsCount")

}