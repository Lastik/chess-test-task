package chess.piece.kind

import chess.piece._

case class Queen(positionOpt: Option[PiecePosition] = None) extends Piece {
  def name = Queen.Name

  def symbol = '♕'

  def movementSchemes = Queen.MovementSchemes

  def withPosition(newPosition: PiecePosition) = this.copy(positionOpt = Some(newPosition))
}

object Queen {

  val Name = "Queen"

  val MovementSchemes = List(
    new StraightLineMovementScheme {
      val maxDistance = Int.MaxValue
    },
    new DiagonalLineMovementScheme {
      val maxDistance = Int.MaxValue
    }
  )

  def apply(coords: (Int, Int)): Queen = Queen(positionOpt = Some(PiecePosition(coords._1, coords._2)))
}