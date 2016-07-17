package chess

case class BoardSize(width: Int, height: Int) {
  require(width > 0 && height > 0, "Wrong board size specified")

  override def toString = s"${width}x${height}"
}

object BoardSize {
  def parse(stringRepr: String): Option[BoardSize] = {

    def toIntOpt(s: String): Option[Int] = {
      try {
        Some(s.toInt)
      } catch {
        case e: Exception => None
      }
    }

    val boardSizeParts = stringRepr.split("x").toList

    boardSizeParts match {
      case widthStr :: heightStr :: Nil =>
        (toIntOpt(widthStr), toIntOpt(heightStr)) match {
          case (Some(width), Some(height)) =>
            Some(BoardSize(width, height))
          case _ => None
        }
      case _ => None
    }
  }
}