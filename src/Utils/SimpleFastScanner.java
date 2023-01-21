package Utils;

import java.io.*;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class SimpleFastScanner implements Closeable, Iterator<String> {
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
    read();
    return tokenizer.hasMoreTokens();
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

  private void read() {
    while (tokenizer == null || !tokenizer.hasMoreTokens()) {
      try {
        tokenizer = new StringTokenizer(reader.readLine());
      } catch (IOException e) {
        System.out.println("I/O error " + e.getMessage());
      }
    }
  }
}
