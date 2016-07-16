package chess.piece.kind

import chess.piece.PiecePosition
import org.scalatest.{FunSpec, Matchers}

class QueenSpec extends FunSpec with Matchers {

  describe("Queen") {

    it("Be able to attack piece on same diagonal") {

      val queen = Queen((5,5))

      queen.canAttack(PiecePosition(7, 7)) shouldEqual true

      queen.canAttack(PiecePosition(4, 4)) shouldEqual true

      queen.canAttack(PiecePosition(4, 6)) shouldEqual true

      queen.canAttack(PiecePosition(3, 7)) shouldEqual true

      queen.canAttack(PiecePosition(6, 4)) shouldEqual true

      queen.canAttack(PiecePosition(7, 3)) shouldEqual true

    }

    it("Be able to attack piece on same straight (hor/ver) line") {

      val queen = Queen((5,5))

      queen.canAttack(PiecePosition(2, 5)) shouldEqual true

      queen.canAttack(PiecePosition(5, 2)) shouldEqual true

      queen.canAttack(PiecePosition(10, 5)) shouldEqual true

      queen.canAttack(PiecePosition(5, 10)) shouldEqual true

    }

    it("Not be able to attack pieces on some random positions") {

      val queen = Queen((5,5))

      queen.canAttack(PiecePosition(14, 1)) shouldEqual false

      queen.canAttack(PiecePosition(3, 22)) shouldEqual false

      queen.canAttack(PiecePosition(8, 3)) shouldEqual false

      queen.canAttack(PiecePosition(1, 10)) shouldEqual false

    }
  }
}