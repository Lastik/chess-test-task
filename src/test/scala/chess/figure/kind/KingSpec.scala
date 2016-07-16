package chess.figure.kind

import chess.figure.FigurePosition
import org.scalatest.{FunSpec, Matchers}

class KingSpec extends FunSpec with Matchers {

  describe("King") {

    it("Be able to attack figure on same diagonal distanced by 1") {

      val king = King((5,5))

      king.canAttack(FigurePosition(4, 4)) shouldEqual true

      king.canAttack(FigurePosition(4, 6)) shouldEqual true

      king.canAttack(FigurePosition(6, 4)) shouldEqual true

    }

    it("Not be able to attack figure on same diagonal distanced farther than by 1") {

      val king = King((5,5))

      king.canAttack(FigurePosition(7, 7)) shouldEqual false

      king.canAttack(FigurePosition(3, 7)) shouldEqual false

      king.canAttack(FigurePosition(7, 3)) shouldEqual false

    }

    it("Be able to attack figure on same straight (horizontal/vertical) line distanced by 1") {

      val king = King((5,5))

      king.canAttack(FigurePosition(5, 6)) shouldEqual true

      king.canAttack(FigurePosition(6, 5)) shouldEqual true

      king.canAttack(FigurePosition(4, 5)) shouldEqual true

      king.canAttack(FigurePosition(5, 4)) shouldEqual true

    }

    it("Be able to attack figure on same straight (horizontal/vertical) line distanced farther than 1") {

      val king = King((5,5))

      king.canAttack(FigurePosition(5, 7)) shouldEqual false

      king.canAttack(FigurePosition(10, 5)) shouldEqual false

      king.canAttack(FigurePosition(3, 5)) shouldEqual false

      king.canAttack(FigurePosition(7, 5)) shouldEqual false

    }

  }
}