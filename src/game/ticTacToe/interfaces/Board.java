package game.ticTacToe.interfaces;

import game.ticTacToe.enums.Result;
import game.ticTacToe.models.Move;

public interface Board {
  Position getPosition();
  Result makeMove(Move move);
}
