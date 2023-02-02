package game.mnk.models;

import game.ticTacToe.interfaces.Board;
import game.ticTacToe.interfaces.Match;
import game.ticTacToe.interfaces.Player;
import game.ticTacToe.loggers.Logger;

public class MatchTwoPlayers implements Match {
  private final int numberOfWins;
  private final Board board;
  private final Player firstPlayer;
  private final Player secondPlayer;
  private final Logger logger;

  private int firstPlayerNumberOfWins;
  private int secondPlayerNumberOfWins;

  public MatchTwoPlayers(int numberOfWins, Board board, Player firstPlayer, Player secondPlayer, Logger logger) {
    this.numberOfWins = numberOfWins;
    this.board = board;
    this.firstPlayer = firstPlayer;
    this.secondPlayer = secondPlayer;
    this.logger = logger;
  }

  @Override
  public int startTheMatch() {
    while (true) {
      int result = new MnkGame(firstPlayer, secondPlayer, logger).play(board);
      if (result == 1) {
        ++firstPlayerNumberOfWins;
      } else if (result == 2) {
        ++secondPlayerNumberOfWins;
      }
      if (firstPlayerNumberOfWins == numberOfWins) {
        return 1;
      } else if (secondPlayerNumberOfWins == numberOfWins) {
        return 2;
      }
    }
  }
}
