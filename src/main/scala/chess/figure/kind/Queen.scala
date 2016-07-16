package chess.figure.kind

import chess.figure._

case class Queen(positionOpt: Option[FigurePosition] = None) extends Figure {
  def name = "Queen"

  def symbol = '♕'

  def movementSchemes = Queen.MovementSchemes

  def withPosition(newPosition: FigurePosition) = this.copy(positionOpt = Some(newPosition))
}

object Queen {
  val MovementSchemes = List(
    new StraightLineMovementScheme {
      val maxDistance = Int.MaxValue
    },
    new DiagonalLineMovementScheme {
      val maxDistance = Int.MaxValue
    }
  )

  def apply(coords: (Int, Int)): Queen = Queen(positionOpt = Some(FigurePosition(coords._1, coords._2)))
}