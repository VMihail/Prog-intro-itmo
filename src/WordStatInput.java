import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class WordStatInput {
  private static void addWord(final Map<String, Integer> dictionary, String word) {
    if (dictionary.containsKey(word)) {
      dictionary.put(word, dictionary.get(word) + 1);
    } else {
      dictionary.put(word, 1);
    }
  }

  public static void main(String[] args) {
    if (args.length != 2) {
      throw new InvalidNumberOfArguments(2);
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
      dictionary =  new LinkedHashMap<>();
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

  public static class InvalidNumberOfArguments extends RuntimeException {
    public InvalidNumberOfArguments(int count) {
      super("Invalid number of arguments, expected " + count);
    }
  }
}
