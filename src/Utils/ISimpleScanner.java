package Utils;

import java.io.Closeable;
import java.util.Iterator;

public interface ISimpleScanner extends Closeable, Iterator<String> {
  boolean hasNext();
  String next();

  int nextInt();
  long nextLong();
  float nextFloat();
  double nextDouble();
}
