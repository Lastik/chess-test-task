package chess.piece

case class PiecePosition(x: Int, y: Int) {

  def xAxisDistanceTo(other: PiecePosition) = {
    Math.abs(x - other.x)
  }

  def yAxisDistanceTo(other: PiecePosition) = {
    Math.abs(y - other.y)
  }
}