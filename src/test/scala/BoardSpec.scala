import chess.figure.kind.{King, Knight, Queen, Rook}
import chess.{Board, BoardSize}
import org.scalatest.{FunSpec, Matchers}

class BoardSpec extends FunSpec with Matchers {

  describe("Board"){

    it("Be able correctly place four kings on 3x3 board") {

      import chess.BoardExtensions._

      val board = Board(size = BoardSize(3, 3))

      val boardsWithKings = board.placeFigures(List(King(), King(), King(), King()))

      boardsWithKings.size shouldEqual 1

      val boardWithKins = boardsWithKings.head

      boardWithKins.toString shouldEqual "♔o♔\nooo\n♔o♔"

    }

    it("Be able correctly solve famous 8 queens problem on 8x8 board") {

      import chess.BoardExtensions._

      val board = Board(size = BoardSize(8, 8))

      val boardsWithQueens = board.placeFigures(List.fill(8)(Queen()))

      boardsWithQueens.size shouldEqual 92

      val boardsStringReprs = boardsWithQueens.map(_.toString)

      boardsStringReprs.contains("ooo♕oooo\noooooo♕o\noo♕ooooo\nooooooo♕\no♕oooooo\noooo♕ooo\n♕ooooooo\nooooo♕oo") shouldEqual true

    }

    it("Be able correctly calculate amount of different variations of boards for 2 kings and 3x3 board") {

      val board = Board(size = BoardSize(3, 3))

      val boardsWithKingsCount = board.calcDistinctBoardsVariantsToPlaceFigures(List.fill(3)(King()))

      boardsWithKingsCount shouldEqual 8

    }

    it("Be able correctly calculate amount of different variations of boards for 3 rooks and 3x3 board") {

      val board = Board(size = BoardSize(3, 3))

      val boardsWithRooksCount = board.calcDistinctBoardsVariantsToPlaceFigures(List.fill(3)(Rook()))

      boardsWithRooksCount shouldEqual 6

    }

    it("Be able correctly place 2 kings, 1 queen and 3x3 board") {

      import chess.BoardExtensions._

      val board = Board(size = BoardSize(3, 3))

      val boardsVariations = board.placeFigures(Queen() :: List.fill(3)(King()))

      boardsVariations.size shouldEqual 0

    }

    it("Be able correctly calculate amount of different variations of boards for 2 kings, 1 queen and 3x3 board") {

      val board = Board(size = BoardSize(3, 3))

      val boardsVariationsCount = board.calcDistinctBoardsVariantsToPlaceFigures(Queen() :: List.fill(3)(King()))

      boardsVariationsCount shouldEqual 0

    }

    it("Be able correctly place 2 knights and 2 king and 3x3 board") {

      import chess.BoardExtensions._

      val board = Board(size = BoardSize(3, 3))

      val boardsVariations = board.placeFigures(Knight() :: Knight() :: King() :: King() :: Nil)

      boardsVariations.size shouldEqual 6

    }

    it("Be able correctly calculate amount of different variations of boards for empty list of figures") {

      val board = Board(size = BoardSize(3, 3))

      val boardsVariationsCount = board.calcDistinctBoardsVariantsToPlaceFigures(Nil)

      boardsVariationsCount shouldEqual 1

    }

  }

}
