package game.ticTacToe.models.players;

import game.ticTacToe.interfaces.Player;
import game.ticTacToe.interfaces.Position;
import game.ticTacToe.models.Move;

import java.io.PrintStream;
import java.util.Scanner;

public class HumanPlayer implements Player {
  private final Scanner in;
  private final PrintStream out;

  public HumanPlayer(Scanner in, PrintStream out) {
    this.in = in;
    this.out = out;
  }

  public HumanPlayer() {
    this(new Scanner(System.in), System.out);
  }

  @Override
  public Move move(Position position) {
    while (true) {
      out.println("Enter row and col");
      Move move = new Move(in.nextInt() - 1, in.nextInt() - 1, position.getCurrentCell());
      if (position.isValidMove(move)) {
        return move;
      }
      out.println("is invalid move");
    }
  }
}
