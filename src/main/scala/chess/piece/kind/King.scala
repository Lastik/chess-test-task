package chess.piece.kind

import chess.piece.{DiagonalLineMovementScheme, Piece, PiecePosition, StraightLineMovementScheme}

case class King(positionOpt: Option[PiecePosition] = None) extends Piece {
  def name = King.Name

  def symbol = '♔'

  def movementSchemes = King.MovementSchemes

  def withPosition(newPosition: PiecePosition) = this.copy(positionOpt = Some(newPosition))
}

object King {

  val Name = "King"

  val MovementSchemes = List(
    new StraightLineMovementScheme {
      val maxDistance = 1
    },
    new DiagonalLineMovementScheme {
      val maxDistance = 1
    }
  )

  def apply(coords: (Int, Int)): King = King(positionOpt = Some(PiecePosition(coords._1, coords._2)))
}