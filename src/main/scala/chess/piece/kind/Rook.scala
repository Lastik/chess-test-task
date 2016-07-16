package chess.piece.kind

import chess.piece._

case class Rook(positionOpt: Option[PiecePosition] = None) extends Piece{
  def name = "Rook"

  def symbol = '♖'

  def movementSchemes = Rook.MovementSchemes

  def withPosition(newPosition: PiecePosition) = this.copy(positionOpt = Some(newPosition))
}

object Rook {
  val MovementSchemes = List(
    new StraightLineMovementScheme {
      val maxDistance = Int.MaxValue
    }
  )

  def apply(coords: (Int, Int)): Rook = Rook(positionOpt = Some(PiecePosition(coords._1, coords._2)))
}