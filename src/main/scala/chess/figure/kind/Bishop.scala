package chess.figure.kind

import chess.figure._

case class Bishop(positionOpt: Option[FigurePosition] = None) extends Figure {
  def name = "Bishop"

  def symbol = '♗'

  def movementSchemes = Bishop.MovementSchemes

  def withPosition(newPosition: FigurePosition) = this.copy(positionOpt = Some(newPosition))
}

object Bishop {
  val MovementSchemes = List(
    new DiagonalLineMovementScheme {
      val maxDistance = Int.MaxValue
    }
  )

  def apply(coords: (Int, Int)): Bishop = Bishop(positionOpt = Some(FigurePosition(coords._1, coords._2)))
}