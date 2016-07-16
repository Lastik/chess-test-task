package chess.figure.kind

import chess.figure.FigurePosition
import org.scalatest.{FunSpec, Matchers}

class RookSpec extends FunSpec with Matchers {

  describe("Rook") {

    it("Not be able to attack figure on same diagonal") {

      val rook = Rook((5,5))

      rook.canAttack(FigurePosition(7, 7)) shouldEqual false

      rook.canAttack(FigurePosition(4, 4)) shouldEqual false

      rook.canAttack(FigurePosition(4, 6)) shouldEqual false

      rook.canAttack(FigurePosition(3, 7)) shouldEqual false

      rook.canAttack(FigurePosition(6, 4)) shouldEqual false

      rook.canAttack(FigurePosition(7, 3)) shouldEqual false

    }

    it("Be able to attack figure on same straight (hor/ver) line") {

      val rook = Rook((5,5))

      rook.canAttack(FigurePosition(2, 5)) shouldEqual true

      rook.canAttack(FigurePosition(5, 2)) shouldEqual true

      rook.canAttack(FigurePosition(10, 5)) shouldEqual true

      rook.canAttack(FigurePosition(5, 10)) shouldEqual true

    }

    it("Not be able to attack some random position") {

      val rook = Rook((5,5))

      rook.canAttack(FigurePosition(14, 1)) shouldEqual false

      rook.canAttack(FigurePosition(3, 22)) shouldEqual false

      rook.canAttack(FigurePosition(8, 3)) shouldEqual false

      rook.canAttack(FigurePosition(1, 10)) shouldEqual false

    }
  }
}