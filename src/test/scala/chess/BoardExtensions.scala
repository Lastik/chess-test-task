package chess

import chess.piece.Piece

import scala.annotation.tailrec

object BoardExtensions {

  implicit class ExtendedBoard(board: Board) {

    def placePieces(pieces: List[Piece]): Set[Board] = {

      @tailrec
      def placePiecesIteration(remainingPieces: List[Piece], boardsVariants: Set[Board] = Set.empty): Set[Board] = {
        remainingPieces match {
          case piece :: newRemainingPieces =>
            placePiecesIteration(newRemainingPieces, boardsVariants.par.flatMap(board => board.placePiece(piece)).seq)
          case Nil => boardsVariants
        }
      }

      placePiecesIteration(pieces, Set(board))
    }
  }

}
