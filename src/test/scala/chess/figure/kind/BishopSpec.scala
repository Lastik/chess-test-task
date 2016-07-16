package chess.figure.kind

import chess.figure.FigurePosition
import org.scalatest.{FunSpec, Matchers}

class BishopSpec extends FunSpec with Matchers {

  describe("Bishop") {

    it("Be able to attack figure on same diagonal") {

      val bishop = Bishop((5,5))

      bishop.canAttack(FigurePosition(7, 7)) shouldEqual true

      bishop.canAttack(FigurePosition(4, 4)) shouldEqual true

      bishop.canAttack(FigurePosition(4, 6)) shouldEqual true

      bishop.canAttack(FigurePosition(3, 7)) shouldEqual true

      bishop.canAttack(FigurePosition(6, 4)) shouldEqual true

      bishop.canAttack(FigurePosition(7, 3)) shouldEqual true

    }

    it("Not able to attack figure not on same diagonal") {

      val bishop = Bishop((5,5))

      bishop.canAttack(FigurePosition(5, 0)) shouldEqual false

      bishop.canAttack(FigurePosition(0, 5)) shouldEqual false

      bishop.canAttack(FigurePosition(5, 6)) shouldEqual false

      bishop.canAttack(FigurePosition(6, 5)) shouldEqual false

    }

  }
}