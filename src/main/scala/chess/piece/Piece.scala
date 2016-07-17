package chess.piece

import chess.piece.kind._

trait Piece {
  def name: String

  def symbol: Char

  def positionOpt: Option[PiecePosition]

  def position = positionOpt.getOrElse(throw new IllegalStateException("Piece position not set"))

  def movementSchemes: List[MovementScheme]

  def canAttack(otherPosition: PiecePosition): Boolean = {
    movementSchemes.exists(_.canMove(position, otherPosition))
  }

  def canAttack(otherPiece: Piece): Boolean = {
    canAttack(otherPiece.position)
  }

  def withPosition(newPosition: PiecePosition): Piece

  override def toString = name
}

object Piece {
  def parsePiecesFromString(piecesStr: String): List[Piece] = {
    piecesStr.split(" ").toList.map {
      case Bishop.Name => Bishop()
      case King.Name => King()
      case Knight.Name => Knight()
      case Queen.Name => Queen()
      case Rook.Name => Rook()
    }
  }
}