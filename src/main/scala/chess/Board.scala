package chess

import chess.figure.{Figure, FigurePosition}

import scala.annotation.tailrec

case class Board(size: BoardSize, figures: Set[Figure] = Set.empty) {

  def isPositionVacant(position: FigurePosition) = {
    !figures.map(_.position).contains(position)
  }

  def placeFigure(figure: Figure): Set[Board] = {

    val figureOnDifferentPositions = for {
      y <- 0 until size.height
      x <- 0 until size.width

      positioningFigure = figure.withPosition(newPosition = FigurePosition(x, y))

      if isPositionVacant(positioningFigure.position) &&
        !figures.exists(_.canAttack(positioningFigure)) &&
        !figures.exists(boardFigure => positioningFigure.canAttack(boardFigure))

    } yield positioningFigure

    figureOnDifferentPositions.map(figure => this.copy(figures = figures + figure)).toSet
  }

  def calcDistinctBoardsVariantsToPlaceFigures(figures: List[Figure]): Int = {

    @tailrec
    def calcBoardsVariantsIteration(remainingFigures: List[Figure], allFigures: List[Figure], boardsVariants: Set[Board]): Int = {

      println(s"Figures left: ${remainingFigures.length}, boards variants: ${boardsVariants.size}")

      remainingFigures match {
        case figure :: Nil =>
          if (!allFigures.dropRight(1).exists(f => f.name == figure.name))
            calcBoardsVariantsCountWithNonRepeatingFigureForBoards(boardsVariants, figure)
          else
            getBoardsVariantsWithFigureForBoards(boardsVariants, figure).size
        case figure :: newRemainingFigures =>
          calcBoardsVariantsIteration(newRemainingFigures, allFigures, getBoardsVariantsWithFigureForBoards(boardsVariants, figure))
        case Nil => boardsVariants.size
      }
    }

    def getBoardsVariantsWithFigureForBoards(boards: Set[Board], figure: Figure) = {
      boards.par.map(board => board.placeFigure(figure)).seq.flatten
    }

    def calcBoardsVariantsCountWithNonRepeatingFigureForBoards(boards: Set[Board], figure: Figure) = {
      boards.toList.par.map(board => board.placeFigure(figure).size).seq.sum
    }

    def sortFiguresSoThatRepeatingGoFirst(figures: List[Figure]) = {
      figures.groupBy(_.name).values.toList.sortBy(-_.length).flatten
    }

    val sortedFigures = sortFiguresSoThatRepeatingGoFirst(figures)

    calcBoardsVariantsIteration(sortedFigures, sortedFigures, Set(this))
  }

  override def toString = {
    (0 until size.height).reverse.map(row => {
      (0 until size.width).map(col => {
        figures.find(_.position == FigurePosition(col, row)) match {
          case Some(figure) => figure.symbol
          case None => 'o'
        }
      }).mkString("")
    }).mkString("\n")
  }
}