package chess.piece.kind

import chess.piece._

case class Bishop(positionOpt: Option[PiecePosition] = None) extends Piece {
  def name = "Bishop"

  def symbol = '♗'

  def movementSchemes = Bishop.MovementSchemes

  def withPosition(newPosition: PiecePosition) = this.copy(positionOpt = Some(newPosition))
}

object Bishop {
  val MovementSchemes = List(
    new DiagonalLineMovementScheme {
      val maxDistance = Int.MaxValue
    }
  )

  def apply(coords: (Int, Int)): Bishop = Bishop(positionOpt = Some(PiecePosition(coords._1, coords._2)))
}