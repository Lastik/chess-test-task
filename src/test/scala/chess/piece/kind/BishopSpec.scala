package chess.piece.kind

import chess.piece.PiecePosition
import org.scalatest.{FunSpec, Matchers}

class BishopSpec extends FunSpec with Matchers {

  describe("Bishop") {

    it("Be able to attack piece on same diagonal") {

      val bishop = Bishop((5,5))

      bishop.canAttack(PiecePosition(7, 7)) shouldEqual true

      bishop.canAttack(PiecePosition(4, 4)) shouldEqual true

      bishop.canAttack(PiecePosition(4, 6)) shouldEqual true

      bishop.canAttack(PiecePosition(3, 7)) shouldEqual true

      bishop.canAttack(PiecePosition(6, 4)) shouldEqual true

      bishop.canAttack(PiecePosition(7, 3)) shouldEqual true

    }

    it("Not able to attack piece not on same diagonal") {

      val bishop = Bishop((5,5))

      bishop.canAttack(PiecePosition(5, 0)) shouldEqual false

      bishop.canAttack(PiecePosition(0, 5)) shouldEqual false

      bishop.canAttack(PiecePosition(5, 6)) shouldEqual false

      bishop.canAttack(PiecePosition(6, 5)) shouldEqual false

    }

  }
}