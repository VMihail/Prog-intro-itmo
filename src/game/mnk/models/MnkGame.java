package game.mnk.models;

import game.ticTacToe.enums.Cell;
import game.ticTacToe.interfaces.Board;
import game.ticTacToe.interfaces.Player;
import game.ticTacToe.loggers.Logger;
import game.ticTacToe.models.TicTacToeGame;

public class MnkGame extends TicTacToeGame {
  public MnkGame(Player firstPlayer, Player secondPlayer, Logger logger) {
    super(firstPlayer, secondPlayer, logger);
  }

  @Override
  protected void showBoard(final Board board) {
    StringBuilder sb = new StringBuilder();
    for (int row = 0; row < board.getRowSize(); row++) {
      for (int col = 0; col < board.getColSize(); col++) {
        Cell cell = board.getCell(row, col);
        sb.append(cell == Cell.E ? "." : cell).append(" ");
      }
      sb.append("\n");
    }
    log(sb.toString());
  }
}
