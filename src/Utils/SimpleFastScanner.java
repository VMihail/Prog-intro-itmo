package Utils;

import java.io.*;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class SimpleFastScanner implements ISimpleScanner {
  private final BufferedReader reader;
  private StringTokenizer tokenizer;

  public SimpleFastScanner(InputStream inputStream) {
    reader = new BufferedReader(new InputStreamReader(inputStream));
  }

  public SimpleFastScanner(File file) throws FileNotFoundException {
    reader = new BufferedReader(new FileReader(file));
  }

  public SimpleFastScanner(String string) {
    reader = new BufferedReader(new StringReader(string));
  }

  @Override
  public void close() throws IOException {
    reader.close();
  }

  @Override
  public boolean hasNext() {
    boolean result = read();
    return result && tokenizer.hasMoreTokens();
  }

  @Override
  public String next() {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
    return tokenizer.nextToken();
  }

  public int nextInt() {
    return Integer.parseInt(next());
  }

  public long nextLong() {
    return Long.parseLong(next());
  }

  public float nextFloat() {
    return Float.parseFloat(next());
  }

  public double nextDouble() {
    return Double.parseDouble(next());
  }

  private boolean read() {
    while (tokenizer == null || !tokenizer.hasMoreTokens()) {
      try {
        String nextLine = reader.readLine();
        if (nextLine == null) {
          return false;
        }
        tokenizer = new StringTokenizer(nextLine);
      } catch (IOException e) {
        System.out.println("I/O error " + e.getMessage());
      }
    }
    return true;
  }
}
