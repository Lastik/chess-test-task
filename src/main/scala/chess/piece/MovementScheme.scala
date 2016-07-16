package chess.piece

trait MovementScheme {
  def canMove(from: PiecePosition, to: PiecePosition): Boolean
}

trait LineMovementScheme extends MovementScheme {
  def maxDistance: Int

  protected def onTheSameLine(first: PiecePosition, second: PiecePosition): Boolean

  protected def distanceBetween(first: PiecePosition, second: PiecePosition): Int

  def canMove(from: PiecePosition, to: PiecePosition) = {
    onTheSameLine(from, to) && distanceBetween(from, to) <= maxDistance
  }
}

trait StraightLineMovementScheme extends LineMovementScheme {
  def onTheSameLine(first: PiecePosition, second: PiecePosition) = {
    first.x == second.x || first.y == second.y
  }

  def distanceBetween(from: PiecePosition, to: PiecePosition) = {
    Math.max(from xAxisDistanceTo to, from yAxisDistanceTo to)
  }
}

trait DiagonalLineMovementScheme extends LineMovementScheme {
  def onTheSameLine(first: PiecePosition, second: PiecePosition) = {
    (first xAxisDistanceTo second) == (first yAxisDistanceTo second)
  }

  def distanceBetween(from: PiecePosition, to: PiecePosition) = {
    from xAxisDistanceTo to
  }
}

case object KnightMovementScheme extends MovementScheme {
  def canMove(from: PiecePosition, to: PiecePosition) = {
    (from xAxisDistanceTo to) == 1 && (from yAxisDistanceTo to) == 2 ||
    (from yAxisDistanceTo to) == 1 && (from xAxisDistanceTo to) == 2
  }
}