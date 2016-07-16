package chess.piece.kind

import chess.piece._

case class Knight(positionOpt: Option[PiecePosition] = None) extends Piece{
  def name = "Knight"

  def symbol = '♘'

  def movementSchemes = List(KnightMovementScheme)

  def withPosition(newPosition: PiecePosition) = this.copy(positionOpt = Some(newPosition))
}

object Knight {
  def apply(coords: (Int, Int)): Knight = Knight(positionOpt = Some(PiecePosition(coords._1, coords._2)))
}