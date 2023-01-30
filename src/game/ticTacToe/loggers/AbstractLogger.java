package game.ticTacToe.loggers;

import java.io.IOException;
import java.util.Objects;

public abstract class AbstractLogger implements Logger {
  @Override
  public void showInfo(String info) {
    Objects.requireNonNull(info);
    showInfoImpl(info);
  }

  protected abstract void showInfoImpl(String info);
}
