package chess.figure

trait Figure {
  def name: String

  def symbol: Char

  def positionOpt: Option[FigurePosition]

  def position = positionOpt.getOrElse(throw new IllegalStateException("Figure position not set"))

  def movementSchemes: List[MovementScheme]

  def canAttack(otherPosition: FigurePosition): Boolean = {
    movementSchemes.exists(_.canMove(position, otherPosition))
  }

  def canAttack(otherFigure: Figure): Boolean = {
    canAttack(otherFigure.position)
  }

  def withPosition(newPosition: FigurePosition): Figure

  override def toString = name
}