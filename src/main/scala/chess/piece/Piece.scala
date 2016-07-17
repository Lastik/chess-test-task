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
  def parsePiecesFromString(piecesStr: String): Option[List[Piece]] = {
    val piecesOpts = piecesStr.split(" ").toList.map {
      case Bishop.Name => Some(Bishop())
      case King.Name => Some(King())
      case Knight.Name => Some(Knight())
      case Queen.Name => Some(Queen())
      case Rook.Name => Some(Rook())
      case _ => None
    }

    if (piecesOpts.contains(None))
      None
    else
      Some(piecesOpts.map(_.get))
  }
}