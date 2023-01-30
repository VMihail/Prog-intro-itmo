package game.ticTacToe.models.players;

import game.ticTacToe.interfaces.Board;
import game.ticTacToe.interfaces.Player;
import game.ticTacToe.interfaces.Position;
import game.ticTacToe.models.Move;

public class CheatingPlayer implements Player {
  @Override
  public Move move(Position position) {
    Board board = (Board) position;
    Move result = null;
    for (int row = 0; row < 3; row++) {
      for (int col = 0; col < 3; col++) {
        final Move move = new Move(row, col, position.getCurrentCell());
        if (position.isValidMove(move)) {
          board.makeMove(move);
          result = move;
        }
      }
    }
    if (result != null) {
      return result;
    }
    throw new IllegalStateException("No valid move");
  }
}
