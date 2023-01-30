package game.ticTacToe.models;

import game.ticTacToe.enums.Result;
import game.ticTacToe.interfaces.Board;
import game.ticTacToe.interfaces.Player;

public class Game {
  private final Player firstPlayer;
  private final Player secondPlayer;
  private final boolean log;


  public Game(final Player firstPlayer, final Player secondPlayer, final boolean log) {
    this.firstPlayer = firstPlayer;
    this.secondPlayer = secondPlayer;
    this.log = log;
  }

  public int play(final Board board) {
    while (true) {
      final int firstPlayerResult = makeMove(board, firstPlayer, 1);
      if (firstPlayerResult != -1) {
        return firstPlayerResult;
      }
      final int secondPlayerResult = makeMove(board, secondPlayer, 2);
      if (secondPlayerResult != -1) {
        return secondPlayerResult;
      }
      System.out.println(board);
    }
  }

  private int makeMove(final Board board, final Player player, final int number) {
    Move move = player.move(board.getPosition());
    Result result = board.makeMove(move);
    if (result == Result.WIN) {
      return number;
    } else if (result == Result.DRAW) {
      return 0;
    } else if (result == Result.LOSE) {
      return 3 - number;
    }
    return -1;
  }
}
