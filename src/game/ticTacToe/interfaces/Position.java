package game.ticTacToe.interfaces;

import game.ticTacToe.enums.Cell;
import game.ticTacToe.models.Move;

public interface Position {
  boolean isValidMove(Move move);
  Cell getCurrentCell();
}
