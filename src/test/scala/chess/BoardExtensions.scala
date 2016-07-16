package chess

import chess.piece.Piece

import scala.annotation.tailrec

object BoardExtensions {

  implicit class ExtendedBoard(board: Board) {

    def placePieces(pieces: List[Piece]): Set[Board] = {

      @tailrec
      def placePiecesIteration(remainingFigures: List[Piece], boardsVariants: Set[Board] = Set.empty): Set[Board] = {
        remainingFigures match {
          case figure :: newRemainingFigures =>
            placePiecesIteration(newRemainingFigures, boardsVariants.par.flatMap(board => board.placePiece(figure)).seq)
          case Nil => boardsVariants
        }
      }

      placePiecesIteration(pieces, Set(board))
    }
  }

}
