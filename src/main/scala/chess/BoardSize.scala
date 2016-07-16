package chess

case class BoardSize(width: Int, height: Int) {
  require(width > 0 && height > 0, "Wrong board size specified")

  override def toString = s"${width}x${height}"
}
