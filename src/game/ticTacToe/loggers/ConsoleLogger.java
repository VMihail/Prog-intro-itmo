package game.ticTacToe.loggers;

public class ConsoleLogger extends AbstractLogger {
  @Override
  protected void showInfoImpl(String info) {
    System.out.println(info);
  }
}
