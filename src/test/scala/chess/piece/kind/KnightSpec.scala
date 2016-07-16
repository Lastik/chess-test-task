package chess.piece.kind

import chess.piece.PiecePosition
import org.scalatest.{FunSpec, Matchers}

class KnightSpec extends FunSpec with Matchers {

  describe("Knight") {

    it("Be able to attack pieces by special knights attack") {

      val knight = Knight((5,5))

      knight.canAttack(PiecePosition(6, 7)) shouldEqual true

      knight.canAttack(PiecePosition(3, 4)) shouldEqual true

      knight.canAttack(PiecePosition(4, 3)) shouldEqual true

      knight.canAttack(PiecePosition(7, 6)) shouldEqual true

    }

    it("Not be able to attack piece on same diagonal") {

      val knight = Knight((5,5))

      knight.canAttack(PiecePosition(7, 7)) shouldEqual false

      knight.canAttack(PiecePosition(4, 4)) shouldEqual false

      knight.canAttack(PiecePosition(4, 6)) shouldEqual false

      knight.canAttack(PiecePosition(3, 7)) shouldEqual false

      knight.canAttack(PiecePosition(6, 4)) shouldEqual false

      knight.canAttack(PiecePosition(7, 3)) shouldEqual false

    }

    it("Not be able to attack piece on same straight (hor/ver) line") {

      val knight = Knight((5,5))

      knight.canAttack(PiecePosition(2, 5)) shouldEqual false

      knight.canAttack(PiecePosition(5, 2)) shouldEqual false

      knight.canAttack(PiecePosition(10, 5)) shouldEqual false

      knight.canAttack(PiecePosition(5, 10)) shouldEqual false

    }

    it("Not be able to attack pieces on some random positions") {

      val knight = Knight((5,5))

      knight.canAttack(PiecePosition(14, 1)) shouldEqual false

      knight.canAttack(PiecePosition(3, 22)) shouldEqual false

      knight.canAttack(PiecePosition(8, 3)) shouldEqual false

      knight.canAttack(PiecePosition(1, 10)) shouldEqual false

    }
  }
}