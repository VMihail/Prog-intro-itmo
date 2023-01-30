package game.ticTacToe.models;

import game.ticTacToe.enums.Cell;
import game.ticTacToe.enums.Result;
import game.ticTacToe.interfaces.Board;
import game.ticTacToe.interfaces.Position;

import java.util.Arrays;

public class TicTacToeBoard implements Board, Position {
  private final Cell[][] field = new Cell[3][3];
  private Cell currentCell;

  public TicTacToeBoard() {
    for (Cell[] row : field) {
      Arrays.fill(row, Cell.E);
    }
    currentCell = Cell.X;
  }

  @Override
  public Position getPosition() {
    return this;
  }

  @Override
  public Result makeMove(Move move) {
    if (!isValidMove(move)) {
      return Result.LOSE;
    }
    field[move.getRow()][move.getCol()] = move.getCell();
    currentCell = currentCell == Cell.X ? Cell.O : Cell.X;
    int emptyCount = 0;
    for (Cell[] row : field) {
      for (Cell cell : row) {
        if (cell == Cell.E) {
          ++emptyCount;
        }
      }
    }
    if (emptyCount == 0) {
      return Result.DRAW;
    }
    for (int i = 0; i < field.length; i++) {
      if (
        field[i][0] == currentCell && field[i][1] == currentCell && field[i][2] == currentCell ||
        field[0][i] == currentCell && field[1][i] == currentCell && field[2][i] == currentCell
      ) {
        return Result.WIN;
      }
    }
    return field[0][0] == currentCell && field[1][1] == currentCell && field[2][2] == currentCell ||
           field[0][2] == currentCell && field[1][1] == currentCell && field[2][0] == currentCell ? Result.WIN : Result.UNKNOWN;
  }

  @Override
  public boolean isValidMove(Move move) {
    return move.getRow() >= 0 && move.getRow() <= 2 &&
      move.getCol() >= 0 && move.getCol() <= 2 &&
      field[move.getRow()][move.getCol()] == Cell.E &&
      currentCell == move.getCell();
  }

  @Override
  public Cell getCurrentCell() {
    return currentCell;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (Cell[] row : field) {
      for (Cell cell : row) {
        sb.append(cell).append(" ");
      }
      sb.append("\n");
    }
    return sb.toString();
  }
}
