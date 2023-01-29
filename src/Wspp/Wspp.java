package Wspp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Wspp {
  private static int nextPosition = 1;
  private static void addWord(final Map<String, Node> dictionary, final String word) {
    if (dictionary.containsKey(word)) {
      dictionary.get(word).addPosition(nextPosition++);
    } else {
      dictionary.put(word, new Node(nextPosition++));
    }
  }

  public static void main(String[] args) {
    final String inputFileName = args[0];
    final String outputFileName = args[1];
    Scanner in = null;
    try {
      in = new Scanner(new File(inputFileName));
    } catch (FileNotFoundException e) {
      System.out.println("input file not found " + e.getMessage());
    }
    assert in != null;
    Map<String, Node> dictionary = new LinkedHashMap<>();
    try {
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
      in.close();
    }
    PrintWriter out = null;
    try {
      out = new PrintWriter(outputFileName);
    } catch (FileNotFoundException e) {
      System.out.println("Output file not found " + e.getMessage());
    }
    assert out != null;
    try {
      for (Map.Entry<String, Node> entry : dictionary.entrySet()) {
        out.println(entry.getKey() + " " + entry.getValue().getInfo());
      }
    } finally {
      out.close();
    }
  }

  private static class Node {
    private final List positions;

    public Node(int position) {
      positions = new IntList();
      positions.add(position);
    }

    public void addPosition(int pos) {
      positions.add(pos);
    }

    public String getInfo() {
      StringBuilder sb = new StringBuilder();
      sb.append(positions.size()).append(" ");
      for (int i = 0; i < positions.size(); i++) {
        sb.append(positions.get(i));
        if (i != positions.size() - 1) {
          sb.append(" ");
        }
      }
      return sb.toString();
    }
  }
}
