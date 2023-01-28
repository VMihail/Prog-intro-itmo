package Utils;

import java.io.*;
import java.util.Scanner;

public class SimpleScannerAdapter implements ISimpleScanner {
  private final Scanner scanner;

  public SimpleScannerAdapter(InputStream inputStream) {
    scanner = new Scanner(new InputStreamReader(inputStream));
  }

  public SimpleScannerAdapter(File file) throws FileNotFoundException {
    scanner = new Scanner(file);
  }

  public SimpleScannerAdapter(String string) {
    scanner = new Scanner(string);
  }

  @Override
  public boolean hasNext() {
    return scanner.hasNext();
  }

  @Override
  public String next() {
    return scanner.next();
  }

  @Override
  public int nextInt() {
    return scanner.nextInt();
  }

  @Override
  public long nextLong() {
    return scanner.nextLong();
  }

  @Override
  public float nextFloat() {
    return scanner.nextFloat();
  }

  @Override
  public double nextDouble() {
    return scanner.nextDouble();
  }

  @Override
  public void close() throws IOException {
    scanner.close();
  }
}
