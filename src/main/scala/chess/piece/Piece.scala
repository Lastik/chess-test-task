package chess.piece

trait Piece {
  def name: String

  def symbol: Char

  def positionOpt: Option[PiecePosition]

  def position = positionOpt.getOrElse(throw new IllegalStateException("Piece position not set"))

  def movementSchemes: List[MovementScheme]

  def canAttack(otherPosition: PiecePosition): Boolean = {
    movementSchemes.exists(_.canMove(position, otherPosition))
  }

  def canAttack(otherFigure: Piece): Boolean = {
    canAttack(otherFigure.position)
  }

  def withPosition(newPosition: PiecePosition): Piece

  override def toString = name
}