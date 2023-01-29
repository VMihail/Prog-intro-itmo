import Utils.FastScanner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReverseAbc {
  public static void main(String[] args) {
    FastScanner in = new FastScanner(System.in);
    List<String> lines = new ArrayList<>();
    while (in.hasNextLine()) {
      lines.add(in.nextLine());
    }
    Collections.reverse(lines);
    StringBuilder sb = new StringBuilder();
    for (final String line : lines) {
      char[] symbols = line.toCharArray();
      List<String> numbers = new ArrayList<>();
      for (char symbol : symbols) {
        if (Character.isLetter(symbol) || symbol == '-') {
          sb.append(symbol);
        } else if (sb.length() > 0) {
          String word = sb.toString().toLowerCase();
          numbers.add(word);
          sb.setLength(0);
        }
      }
      if (sb.length() > 0 && !sb.toString().equals("-")) {
        numbers.add(sb.toString());
      }
      for (int i = numbers.size() - 1; i >= 0; i--) {
        System.out.print(numbers.get(i) + " ");
      }
      System.out.println();
      sb.setLength(0);
    }
  }
}
