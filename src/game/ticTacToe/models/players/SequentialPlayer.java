package game.ticTacToe.models.players;

import game.ticTacToe.interfaces.Player;
import game.ticTacToe.interfaces.Position;
import game.ticTacToe.models.Move;

public class SequentialPlayer implements Player {
  @Override
  public Move move(Position position) {
    for (int row = 0; row < 3; row++) {
      for (int col = 0; col < 3; col++) {
        final Move move = new Move(row, col, position.getCurrentCell());
        if (position.isValidMove(move)) {
          return move;
        }
      }
    }
    throw new IllegalStateException("No valid move");
  }
}
