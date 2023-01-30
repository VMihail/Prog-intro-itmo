package game.ticTacToe.interfaces;

import game.ticTacToe.models.Move;

public interface Player {
  Move move(Position position);
}
