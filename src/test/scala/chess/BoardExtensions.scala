package chess

import chess.figure.Figure

import scala.annotation.tailrec

object BoardExtensions {

  implicit class ExtendedBoard(board: Board) {

    def placeFigures(figures: List[Figure]): Set[Board] = {

      @tailrec
      def placeFiguresIteration(remainingFigures: List[Figure], boardsVariants: Set[Board] = Set.empty): Set[Board] = {
        remainingFigures match {
          case figure :: newRemainingFigures =>
            placeFiguresIteration(newRemainingFigures, boardsVariants.par.map(board => board.placeFigure(figure)).seq.flatten)
          case Nil => boardsVariants
        }
      }

      placeFiguresIteration(figures, Set(board))
    }
  }

}
