package game.ticTacToe.loggers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileLogger extends AbstractLogger {
  private final FileWriter out;

  public FileLogger(FileWriter out) {
    this.out = out;
  }

  @Override
  protected void showInfoImpl(String info) {
    try {
      out.write(info + "\n");
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }
}
