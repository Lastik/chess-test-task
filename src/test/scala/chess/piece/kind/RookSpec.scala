package chess.piece.kind

import chess.piece.PiecePosition
import org.scalatest.{FunSpec, Matchers}

class RookSpec extends FunSpec with Matchers {

  describe("Rook") {

    it("Not be able to attack piece on same diagonal") {

      val rook = Rook((5,5))

      rook.canAttack(PiecePosition(7, 7)) shouldEqual false

      rook.canAttack(PiecePosition(4, 4)) shouldEqual false

      rook.canAttack(PiecePosition(4, 6)) shouldEqual false

      rook.canAttack(PiecePosition(3, 7)) shouldEqual false

      rook.canAttack(PiecePosition(6, 4)) shouldEqual false

      rook.canAttack(PiecePosition(7, 3)) shouldEqual false

    }

    it("Be able to attack piece on same straight (hor/ver) line") {

      val rook = Rook((5,5))

      rook.canAttack(PiecePosition(2, 5)) shouldEqual true

      rook.canAttack(PiecePosition(5, 2)) shouldEqual true

      rook.canAttack(PiecePosition(10, 5)) shouldEqual true

      rook.canAttack(PiecePosition(5, 10)) shouldEqual true

    }

    it("Not be able to attack pieces on some random positions") {

      val rook = Rook((5,5))

      rook.canAttack(PiecePosition(14, 1)) shouldEqual false

      rook.canAttack(PiecePosition(3, 22)) shouldEqual false

      rook.canAttack(PiecePosition(8, 3)) shouldEqual false

      rook.canAttack(PiecePosition(1, 10)) shouldEqual false

    }
  }
}