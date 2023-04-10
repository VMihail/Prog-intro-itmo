package game.ticTacToe.models.players;

import game.ticTacToe.interfaces.Player;
import game.ticTacToe.interfaces.Position;
import game.ticTacToe.models.Move;

import java.util.Random;

public class RandomPlayer implements Player {
  /**
  * Оказалось, что этот класс устарел, вместо него лучше использовать ThreadLocalRandom
  */
  protected final Random random;

  public RandomPlayer(Random random) {
    this.random = random;
  }

  public RandomPlayer() {
    this(new Random());
  }

  @Override
  public Move move(Position position) {
    while (true) { // mathematical expectation in 9 moves
      int row = random.nextInt(3);
      int col = random.nextInt(3);
      final Move move = new Move(row, col, position.getCurrentCell());
      if (position.isValidMove(move)) {
        return move;
      }
    }
  }
}
