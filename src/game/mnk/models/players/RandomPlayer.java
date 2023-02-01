package game.mnk.models.players;

import game.ticTacToe.interfaces.Position;
import game.ticTacToe.models.Move;

public class RandomPlayer extends game.ticTacToe.models.players.RandomPlayer {
  private final int rowSize;
  private final int colSize;


  public RandomPlayer(int rowSize, int colSize) {
    this.rowSize = rowSize;
    this.colSize = colSize;
  }

  @Override
  public Move move(Position position) {
    while (true) { // mathematical expectation in rowSize * colSize moves
      int row = random.nextInt(rowSize);
      int col = random.nextInt(colSize);
      final Move move = new Move(row, col, position.getCurrentCell());
      if (position.isValidMove(move)) {
        return move;
      }
    }
  }
}
