package Utils.tests;

import Utils.ISimpleScanner;
import Utils.SimpleFastScanner;
import Utils.SimpleScannerAdapter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SimpleFastScannerTest {
  private ISimpleScanner firstScanner;
  private ISimpleScanner secondScanner;

  public SimpleFastScannerTest() {
    final String string = "hello world 123 -123    yeh    \n hello \t \t \n \r null";
    firstScanner = new SimpleFastScanner(string);
    secondScanner = new SimpleScannerAdapter(string);
  }

  @Test
  public void testNext() {
    List<String> firstTokens = readAll(firstScanner);
    List<String> secondTokens = readAll(secondScanner);
    Assertions.assertTrue(Objects.deepEquals(firstTokens, secondTokens));
  }

  @Test
  public void testNextInt() {
    final String string = "1 2 3 10 20 30 \n-1\n -2 -123";
    firstScanner = new SimpleFastScanner(string);
    secondScanner = new SimpleScannerAdapter(string);
    List<Integer> firstInts = readAllInts(firstScanner);
    List<Integer> secondInts = readAllInts(secondScanner);
    Assertions.assertTrue(Objects.deepEquals(firstInts, secondInts));
  }

  private List<String> readAll(final ISimpleScanner scanner) {
    List<String> result = new ArrayList<>();
    while (scanner.hasNext()) {
      result.add(scanner.next());
    }
    return result;
  }

  private List<Integer> readAllInts(final ISimpleScanner scanner) {
    List<String> tokens = readAll(scanner);
    List<Integer> result = new ArrayList<>(tokens.size());
    for (String string : tokens) {
      result.add(Integer.parseInt(string));
    }
    return result;
  }
}