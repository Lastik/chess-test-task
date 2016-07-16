package chess.figure.kind

import chess.figure._

case class Rook(positionOpt: Option[FigurePosition] = None) extends Figure{
  def name = "Rook"

  def symbol = '♖'

  def movementSchemes = Rook.MovementSchemes

  def withPosition(newPosition: FigurePosition) = this.copy(positionOpt = Some(newPosition))
}

object Rook {
  val MovementSchemes = List(
    new StraightLineMovementScheme {
      val maxDistance = Int.MaxValue
    }
  )

  def apply(coords: (Int, Int)): Rook = Rook(positionOpt = Some(FigurePosition(coords._1, coords._2)))
}