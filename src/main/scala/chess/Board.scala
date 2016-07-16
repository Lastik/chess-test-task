package chess

import chess.piece.{Piece, PiecePosition}

import scala.annotation.tailrec

case class Board(size: BoardSize, pieces: Set[Piece] = Set.empty) {

  def placePiece(piece: Piece): Set[Board] = {

    val occupiedPositions = pieces.map(_.position).groupBy(_.x).mapValues(_.map(_.y))

    def isPositionVacant(position: PiecePosition) = {
      !(occupiedPositions.contains(position.x) && occupiedPositions(position.x).contains(position.y))
    }

    val pieceOnDifferentPositions = for {
      y <- 0 until size.height
      x <- 0 until size.width

      positioningPiece = piece.withPosition(newPosition = PiecePosition(x, y))

      if isPositionVacant(positioningPiece.position) &&
        !pieces.exists(_.canAttack(positioningPiece)) &&
        !pieces.exists(boardPiece => positioningPiece.canAttack(boardPiece))

    } yield positioningPiece

    pieceOnDifferentPositions.map(piece => this.copy(pieces = pieces + piece)).toSet
  }

  def calcDistinctBoardsVariantsToPlacePieces(pieces: List[Piece]): Int = {

    @tailrec
    def calcBoardsVariantsIteration(remainingPieces: List[Piece], allPieces: List[Piece], boardsVariants: Set[Board]): Int = {

      println(s"Pieces left: ${remainingPieces.length}, boards variants: ${boardsVariants.size}")

      remainingPieces match {
        case piece :: Nil =>
          if (!allPieces.dropRight(1).exists(f => f.name == piece.name))
            calcBoardsVariantsCountWithNonRepeatingPieceForBoards(boardsVariants, piece)
          else
            getBoardsVariantsWithPieceForBoards(boardsVariants, piece).size
        case piece :: newRemainingPieces =>
          calcBoardsVariantsIteration(newRemainingPieces, allPieces, getBoardsVariantsWithPieceForBoards(boardsVariants, piece))
        case Nil => boardsVariants.size
      }
    }

    def getBoardsVariantsWithPieceForBoards(boards: Set[Board], piece: Piece) = {
      boards.par.flatMap(board => board.placePiece(piece)).seq
    }

    def calcBoardsVariantsCountWithNonRepeatingPieceForBoards(boards: Set[Board], piece: Piece) = {
      boards.toList.par.map(board => board.placePiece(piece).size).seq.sum
    }

    def sortPiecesSoThatRepeatingGoFirst(pieces: List[Piece]) = {
      pieces.groupBy(_.name).values.toList.sortBy(-_.length).flatten
    }

    val sortedPieces = sortPiecesSoThatRepeatingGoFirst(pieces)

    calcBoardsVariantsIteration(sortedPieces, sortedPieces, Set(this))
  }

  override def toString = {
    (0 until size.height).reverse.map(row => {
      (0 until size.width).map(col => {
        pieces.find(_.position == PiecePosition(col, row)) match {
          case Some(piece) => piece.symbol
          case None => 'o'
        }
      }).mkString("")
    }).mkString("\n")
  }
}