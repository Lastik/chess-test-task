package chess.figure.kind

import chess.figure.FigurePosition
import org.scalatest.{FunSpec, Matchers}

class QueenSpec extends FunSpec with Matchers {

  describe("Queen") {

    it("Be able to attack figure on same diagonal") {

      val queen = Queen((5,5))

      queen.canAttack(FigurePosition(7, 7)) shouldEqual true

      queen.canAttack(FigurePosition(4, 4)) shouldEqual true

      queen.canAttack(FigurePosition(4, 6)) shouldEqual true

      queen.canAttack(FigurePosition(3, 7)) shouldEqual true

      queen.canAttack(FigurePosition(6, 4)) shouldEqual true

      queen.canAttack(FigurePosition(7, 3)) shouldEqual true

    }

    it("Be able to attack figure on same straight (hor/ver) line") {

      val queen = Queen((5,5))

      queen.canAttack(FigurePosition(2, 5)) shouldEqual true

      queen.canAttack(FigurePosition(5, 2)) shouldEqual true

      queen.canAttack(FigurePosition(10, 5)) shouldEqual true

      queen.canAttack(FigurePosition(5, 10)) shouldEqual true

    }

    it("Not be able to attack some random position") {

      val queen = Queen((5,5))

      queen.canAttack(FigurePosition(14, 1)) shouldEqual false

      queen.canAttack(FigurePosition(3, 22)) shouldEqual false

      queen.canAttack(FigurePosition(8, 3)) shouldEqual false

      queen.canAttack(FigurePosition(1, 10)) shouldEqual false

    }
  }
}