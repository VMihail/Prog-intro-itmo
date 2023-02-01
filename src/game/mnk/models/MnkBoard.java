package game.mnk.models;

import game.ticTacToe.enums.Cell;
import game.ticTacToe.enums.Result;
import game.ticTacToe.interfaces.Board;
import game.ticTacToe.interfaces.Position;
import game.ticTacToe.models.Move;

import java.util.Arrays;

public class MnkBoard implements Board, Position {
  private final Cell[][] field;
  private final int m, n, k;
  private Cell currentCell;

  public MnkBoard(int m, int n, int k) {
    this.m = m;
    this.n = n;
    this.k = k;
    field = new Cell[m][n];
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
    if (isWin(move.getRow(), move.getCol())) {
      return Result.WIN;
    }
    long emptyCount = 0;
    for (Cell[] row : field) {
      for (Cell cell : row) {
        if (cell == Cell.E) {
          ++emptyCount;
        }
      }
    }
    if (emptyCount == 0L) {
      return Result.DRAW;
    }
    currentCell = currentCell == Cell.X ? Cell.O : Cell.X;
    return Result.UNKNOWN;
  }

  private boolean isWin(int row, int col) {
    return kInRowOrCol(row, col) || kInDiagonal(row, col);
  }

  private boolean kInRowOrCol(int row, int col) {
    int count = 0;
    for (int i = row; i >= 0; i--) {
      if (field[i][col] == currentCell) {
        ++count;
      } else {
        break;
      }
    }
    for (int i = row + 1; i < n; i++) {
      if (field[row][i] == currentCell) {
        ++count;
      } else {
        break;
      }
    }
    if (count >= k) {
      return true;
    }
    count = 0;
    for (int i = row; i >= 0; i--) {
      if (field[row][i] == currentCell) {
        ++count;
      } else {
        break;
      }
    }
    for (int i = row + 1; i < m; i++) {
      if (field[row][i] == currentCell) {
        ++count;
      } else {
        break;
      }
    }
    return count >= k;
  }

  private boolean kInDiagonal(int row, int col) {
    final int rowSave = row, colSave = col;
    int count = 0;
    while (row >= 0 && col >= 0) {
      if (field[row][col] == currentCell) {
        ++count;
      } else {
        break;
      }
      --row;
      --col;
    }
    row = rowSave + 1;
    col = colSave + 1;
    while (row < m && col < n) {
      if (field[row][col] == currentCell) {
        ++count;
      } else {
        break;
      }
      ++row;
      ++col;
    }
    if (count >= k) {
      return true;
    }
    count = 0;
    row = rowSave + 1;
    col = colSave - 1;
    while (row < m && col >= 0) {
      if (field[row][col] == currentCell) {
        ++count;
      } else {
        break;
      }
      ++row;
      --col;
    }
    row = rowSave - 1;
    col = colSave + 1;
    while (row >= 0 && col < n) {
      if (field[row][col] == currentCell) {
        ++count;
      } else {
        break;
      }
      --row;
      ++col;
    }
    return count >= k;
  }

  @Override
  public Cell getCell(int row, int col) {
    if (row < 0 || row >= n || col < 0 || col >= m) {
      throw new IndexOutOfBoundsException();
    }
    return field[row][col];
  }

  @Override
  public int getRowSize() {
    return m;
  }

  @Override
  public int getColSize() {
    return n;
  }

  @Override
  public boolean isValidMove(Move move) {
    return move.getRow() >= 0 && move.getRow() < n &&
           move.getCol() >= 0 && move.getCol() < m &&
           field[move.getRow()][move.getCol()] == Cell.E &&
           currentCell == move.getCell();
  }

  @Override
  public Cell getCurrentCell() {
    return currentCell;
  }
}
