package game.ticTacToe;

import game.ticTacToe.interfaces.Player;
import game.ticTacToe.models.Game;
import game.ticTacToe.models.TicTacToeBoard;
import game.ticTacToe.models.players.CheatingPlayer;
import game.ticTacToe.models.players.HumanPlayer;
import game.ticTacToe.models.players.RandomPlayer;
import game.ticTacToe.models.players.SequentialPlayer;

public class Main {
  public static void main(String[] args) {
    Player first = new HumanPlayer();
    Player second = new CheatingPlayer();
    int result = (new Game(first, second, false)).play(new TicTacToeBoard());
    System.out.println(result);
  }
}
