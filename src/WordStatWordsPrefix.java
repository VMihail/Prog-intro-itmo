import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class WordStatWordsPrefix {
  private static final int prefixLen = 3;

  private static void addWord(final Map<String, Integer> dictionary, String word) {
    if (word.length() < prefixLen) {
      return;
    }
    String prefix = word.substring(0, prefixLen);
    if (dictionary.containsKey(prefix)) {
      dictionary.put(prefix, dictionary.get(prefix) + 1);
    } else {
      dictionary.put(prefix, 1);
    }
  }

  public static void main(String[] args) {
    if (args.length != 2) {
      throw new WordStatInput.InvalidNumberOfArguments(2);
    }
    String inputFileName = args[0];
    String outputFileName = args[1];
    Scanner in = null;
    try {
      in = new Scanner(new File(inputFileName));
    } catch (FileNotFoundException e) {
      System.out.println("input file not found " + e.getMessage());
    }
    Map<String, Integer> dictionary;
    try {
      assert in != null;
      dictionary =  new TreeMap<>();
      while (in.hasNextLine()) {
        String nextLine = in.nextLine().toLowerCase();
        StringBuilder nextWord = new StringBuilder();
        for (int i = 0; i < nextLine.length(); i++) {
          char nextChar = nextLine.charAt(i);
          if (Character.isLetter(nextChar) || nextChar == '\'' || Character.getType(nextChar) == Character.DASH_PUNCTUATION) {
            nextWord.append(nextChar);
          } else if (nextWord.length() > 0) {
            String word = nextWord.toString();
            nextWord.setLength(0);
            addWord(dictionary, word);
          }
        }
      }
    } finally {
      assert in != null;
      in.close();
    }
    PrintWriter out = null;
    try {
      out = new PrintWriter(outputFileName);
    } catch (IOException e) {
      System.out.println("Output file not found " + e.getMessage());
    }
    try {
      assert out != null;
      for (Map.Entry<String, Integer> entry : dictionary.entrySet()) {
        out.println(entry.getKey() + " " + entry.getValue());
      }
    } finally {
      assert out != null;
      out.close();
    }
  }
}
