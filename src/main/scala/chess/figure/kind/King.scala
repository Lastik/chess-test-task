package chess.figure.kind

import chess.figure.{DiagonalLineMovementScheme, Figure, FigurePosition, StraightLineMovementScheme}

case class King(positionOpt: Option[FigurePosition] = None) extends Figure {
  def name = "King"

  def symbol = '♔'

  def movementSchemes = King.MovementSchemes

  def withPosition(newPosition: FigurePosition) = this.copy(positionOpt = Some(newPosition))
}

object King {
  val MovementSchemes = List(
    new StraightLineMovementScheme {
      val maxDistance = 1
    },
    new DiagonalLineMovementScheme {
      val maxDistance = 1
    }
  )

  def apply(coords: (Int, Int)): King = King(positionOpt = Some(FigurePosition(coords._1, coords._2)))
}