package chess.figure.kind

import chess.figure.FigurePosition
import org.scalatest.{FunSpec, Matchers}

class KnightSpec extends FunSpec with Matchers {

  describe("Knight") {

    it("Be able to attack figures by special knights attack") {

      val knight = Knight((5,5))

      knight.canAttack(FigurePosition(6, 7)) shouldEqual true

      knight.canAttack(FigurePosition(3, 4)) shouldEqual true

      knight.canAttack(FigurePosition(4, 3)) shouldEqual true

      knight.canAttack(FigurePosition(7, 6)) shouldEqual true

    }

    it("Not be able to attack figure on same diagonal") {

      val knight = Knight((5,5))

      knight.canAttack(FigurePosition(7, 7)) shouldEqual false

      knight.canAttack(FigurePosition(4, 4)) shouldEqual false

      knight.canAttack(FigurePosition(4, 6)) shouldEqual false

      knight.canAttack(FigurePosition(3, 7)) shouldEqual false

      knight.canAttack(FigurePosition(6, 4)) shouldEqual false

      knight.canAttack(FigurePosition(7, 3)) shouldEqual false

    }

    it("Not be able to attack figure on same straight (hor/ver) line") {

      val knight = Knight((5,5))

      knight.canAttack(FigurePosition(2, 5)) shouldEqual false

      knight.canAttack(FigurePosition(5, 2)) shouldEqual false

      knight.canAttack(FigurePosition(10, 5)) shouldEqual false

      knight.canAttack(FigurePosition(5, 10)) shouldEqual false

    }

    it("Not be able to attack some random position") {

      val knight = Knight((5,5))

      knight.canAttack(FigurePosition(14, 1)) shouldEqual false

      knight.canAttack(FigurePosition(3, 22)) shouldEqual false

      knight.canAttack(FigurePosition(8, 3)) shouldEqual false

      knight.canAttack(FigurePosition(1, 10)) shouldEqual false

    }
  }
}