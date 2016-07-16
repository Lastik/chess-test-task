package chess.figure

trait MovementScheme {
  def canMove(from: FigurePosition, to: FigurePosition): Boolean
}

trait LineMovementScheme extends MovementScheme {
  def maxDistance: Int

  protected def onTheSameLine(first: FigurePosition, second: FigurePosition): Boolean

  protected def distanceBetween(first: FigurePosition, second: FigurePosition): Int

  def canMove(from: FigurePosition, to: FigurePosition) = {
    onTheSameLine(from, to) && distanceBetween(from, to) <= maxDistance
  }
}

trait StraightLineMovementScheme extends LineMovementScheme {
  def onTheSameLine(first: FigurePosition, second: FigurePosition) = {
    first.x == second.x || first.y == second.y
  }

  def distanceBetween(from: FigurePosition, to: FigurePosition) = {
    Math.max(from xAxisDistanceTo to, from yAxisDistanceTo to)
  }
}

trait DiagonalLineMovementScheme extends LineMovementScheme {
  def onTheSameLine(first: FigurePosition, second: FigurePosition) = {
    (first xAxisDistanceTo second) == (first yAxisDistanceTo second)
  }

  def distanceBetween(from: FigurePosition, to: FigurePosition) = {
    from xAxisDistanceTo to
  }
}

case object KnightMovementScheme extends MovementScheme {
  def canMove(from: FigurePosition, to: FigurePosition) = {
    (from xAxisDistanceTo to) == 1 && (from yAxisDistanceTo to) == 2 ||
    (from yAxisDistanceTo to) == 1 && (from xAxisDistanceTo to) == 2
  }
}