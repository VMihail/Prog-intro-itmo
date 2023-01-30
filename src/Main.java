import Utils.SimpleFastScanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws FileNotFoundException {
    List<Integer> a = List.of(1, 2, 3);
    List<Integer> b = List.of(10, 20, 30, 40, 50, -50);
    List<Integer> c = List.of(1, 2, 3);
    System.out.println(Objects.deepEquals(a, c));
  }
}