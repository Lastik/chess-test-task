package chess.figure.kind

import chess.figure._

case class Knight(positionOpt: Option[FigurePosition] = None) extends Figure{
  def name = "Knight"

  def symbol = '♘'

  def movementSchemes = List(KnightMovementScheme)

  def withPosition(newPosition: FigurePosition) = this.copy(positionOpt = Some(newPosition))
}

object Knight {
  def apply(coords: (Int, Int)): Knight = Knight(positionOpt = Some(FigurePosition(coords._1, coords._2)))
}