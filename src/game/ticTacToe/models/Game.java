package game.ticTacToe.models;

import game.ticTacToe.enums.Cell;
import game.ticTacToe.enums.Result;
import game.ticTacToe.interfaces.Board;
import game.ticTacToe.interfaces.Player;
import game.ticTacToe.loggers.Logger;

public class Game {
  private final Player firstPlayer;
  private final Player secondPlayer;
  private final Logger logger;

  public Game(final Player firstPlayer, final Player secondPlayer, final Logger logger) {
    this.firstPlayer = firstPlayer;
    this.secondPlayer = secondPlayer;
    this.logger = logger;
  }

  protected void showBoard(final Board board) {
    StringBuilder sb = new StringBuilder();
    for (int row = 0; row < 3; row++) {
      for (int col = 0; col < 3; col++) {
        Cell cell = board.getCell(row, col);
        sb.append(cell == Cell.E ? "." : cell).append(" ");
      }
      sb.append("\n");
    }
    log(sb.toString());
  }

  protected void showMove(final Move move) {
    log("move - " + "(" + (move.getRow() + 1) + ", " + (move.getCol() + 1) + ")");
  }

  public int play(final Board board) {
    log("The game started");
    while (true) {
      log("makes a move " + board.getPosition().getCurrentCell());
      final int firstPlayerResult = makeMove(board, firstPlayer, 1);
      showBoard(board);
      if (firstPlayerResult != -1) {
        return firstPlayerResult;
      }
      log("makes a move " + board.getPosition().getCurrentCell());
      final int secondPlayerResult = makeMove(board, secondPlayer, 2);
      showBoard(board);
      if (secondPlayerResult != -1) {
        return secondPlayerResult;
      }
    }
  }

  private int makeMove(final Board board, final Player player, final int number) {
    Move move = player.move(board.getPosition());
    Result result = board.makeMove(move);
    showMove(move);
    if (result == Result.WIN) {
      return number;
    } else if (result == Result.DRAW) {
      return 0;
    } else if (result == Result.LOSE) {
      return 3 - number;
    }
    return -1;
  }

  protected void log(String info) {
    logger.showInfo(info);
  }
}
