package chess.piece.kind

import chess.piece.PiecePosition
import org.scalatest.{FunSpec, Matchers}

class KingSpec extends FunSpec with Matchers {

  describe("King") {

    it("Be able to attack piece on same diagonal distanced by 1") {

      val king = King((5,5))

      king.canAttack(PiecePosition(4, 4)) shouldEqual true

      king.canAttack(PiecePosition(4, 6)) shouldEqual true

      king.canAttack(PiecePosition(6, 4)) shouldEqual true

    }

    it("Not be able to attack piece on same diagonal distanced farther than by 1") {

      val king = King((5,5))

      king.canAttack(PiecePosition(7, 7)) shouldEqual false

      king.canAttack(PiecePosition(3, 7)) shouldEqual false

      king.canAttack(PiecePosition(7, 3)) shouldEqual false

    }

    it("Be able to attack piece on same straight (horizontal/vertical) line distanced by 1") {

      val king = King((5,5))

      king.canAttack(PiecePosition(5, 6)) shouldEqual true

      king.canAttack(PiecePosition(6, 5)) shouldEqual true

      king.canAttack(PiecePosition(4, 5)) shouldEqual true

      king.canAttack(PiecePosition(5, 4)) shouldEqual true

    }

    it("Be able to attack piece on same straight (horizontal/vertical) line distanced farther than 1") {

      val king = King((5,5))

      king.canAttack(PiecePosition(5, 7)) shouldEqual false

      king.canAttack(PiecePosition(10, 5)) shouldEqual false

      king.canAttack(PiecePosition(3, 5)) shouldEqual false

      king.canAttack(PiecePosition(7, 5)) shouldEqual false

    }

  }
}