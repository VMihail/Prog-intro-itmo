package game.ticTacToe.interfaces;

import game.ticTacToe.enums.Cell;
import game.ticTacToe.enums.Result;
import game.ticTacToe.models.Move;

public interface Board {
  Position getPosition();
  Result makeMove(Move move);
  Cell getCell(int row, int col);
}
