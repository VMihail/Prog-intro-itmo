import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ReverseEven {
  public static void main(String[] args) {
    final Scanner in = new Scanner(System.in);
    List<List<Integer>> matrix = new ArrayList<>();
    while (in.hasNextLine()) {
      StringTokenizer tokenizer = new StringTokenizer(in.nextLine());
      List<Integer> line = new ArrayList<>();
      while (tokenizer.hasMoreTokens()) {
        int nextNumber = Integer.parseInt(tokenizer.nextToken());
        line.add(nextNumber);
      }
      matrix.add(line);
    }
    for (int row = matrix.size() - 1; row >= 0; row--) {
      for (int col = matrix.get(row).size() - 1; col >= 0; col--) {
        int nextNumber = matrix.get(row).get(col);
        if ((nextNumber & 1) == 0) {
          System.out.print(nextNumber + " ");
        }
      }
      System.out.println();
    }
  }
}
