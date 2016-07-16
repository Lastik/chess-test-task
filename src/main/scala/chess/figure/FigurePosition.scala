package chess.figure

case class FigurePosition(x: Int, y: Int) {

  def xAxisDistanceTo(other: FigurePosition) = {
    Math.abs(x - other.x)
  }

  def yAxisDistanceTo(other: FigurePosition) = {
    Math.abs(y - other.y)
  }
}