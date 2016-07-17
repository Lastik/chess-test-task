import chess.piece.Piece
import chess.{Board, BoardSize}
import chess.piece.kind._

import scala.io.StdIn

object Main extends App {

  val defaultPieces = List(King(), King(), Queen(), Rook(), Bishop(), Knight())

  println(s"Enter pieces list use, or press enter to use default list of pieces:")

  val piecesStr = StdIn.readLine()

  val pieces = {
    if (piecesStr.isEmpty) {
      println(s"Using default pieces.")
      defaultPieces
    }
    else {
      Piece.parsePiecesFromString(piecesStr)
    }
  }

  println(s"Pieces: ${pieces.mkString(", ")}")

  val defaultBoardSize = BoardSize(width = 6, height = 9)

  println(s"Enter board size, or press enter to use default board size:")

  val boardSizeStr = StdIn.readLine()

  val boardSize = {
    if (boardSizeStr.isEmpty) {
      println(s"Using default board size.")
      defaultBoardSize
    }
    else {
      BoardSize.parse(boardSizeStr) match {
        case Some(parsedBoardSize) =>
          parsedBoardSize
        case None =>
          println(s"Failed to parse board size. Exiting...")
          sys.exit(1)
      }
    }
  }

  println(s"Board size: $boardSize")

  val board = Board(size = boardSize)

  println(s"Calculating distinct boards variants...")
  val boardsVariantsCount = board.calcDistinctBoardsVariantsToPlacePieces(pieces)

  println(s"Amount of boards variants: $boardsVariantsCount")

}