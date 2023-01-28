package Utils;

import java.io.*;
import java.util.NoSuchElementException;

public class FastScanner {
  private final static int STATE_OPEN = 0;
  private final static int STATE_CLOSED = 1;
  private final static int STATE_EOF = 2;

  private int state = STATE_OPEN;
  private final Reader reader;
  private final int bufferSize = 1024;
  private final char[] buffer = new char[bufferSize];
  private int start = 0;
  private int end = 0;

  public FastScanner(String string) {
    reader = new StringReader(string);
  }

  public FastScanner(InputStream input) {
    reader = new InputStreamReader(input);
  }

  public boolean hasNext() {
    if (state == STATE_CLOSED) {
      throw new IllegalStateException("Scanner is closed");
    }
    skipWhitespaces();
    if (start < end) {
      return true;
    }
    if (state == STATE_EOF) {
      return false;
    }
    do {
      readToBuffer();
      skipWhitespaces();
    } while (state != STATE_EOF && start == end);
    return start < end;
  }

  public String next() {
    if (!hasNext()) {
      throw new NoSuchElementException("There is no next token");
    }
    StringBuilder tokenBuilder = new StringBuilder();
    do {
      while (start < end) {
        char ch = buffer[start];
        if (Character.isWhitespace(ch)) {
          return tokenBuilder.toString();
        } else {
          tokenBuilder.append(ch);
          ++start;
        }
      }
      readToBuffer();
    } while (state != STATE_EOF);
    return tokenBuilder.toString();
  }

  public boolean hasNextLine() {
    if (state == STATE_CLOSED) {
      throw new IllegalStateException("Scanner is closed");
    }
    if (start < end) {
      return true;
    }
    if (state == STATE_EOF) {
      return false;
    }
    do {
      readToBuffer();
    } while (state != STATE_EOF && start == end);
    return start < end;
  }

  public String nextLine() {
    if (!hasNextLine()) {
      throw new NoSuchElementException("There is no next line");
    }
    StringBuilder sb = new StringBuilder();
    do {
      while (start < end) {
        char ch = buffer[start];
        if (ch == '\n') {
          ++start;
          return sb.toString();
        } else {
          sb.append(ch);
          ++start;
        }
      }
      readToBuffer();
    } while (state != STATE_EOF);
    return sb.toString();
  }

  private int parsedInt = 0;
  private int parsedIntEnd = 0;

  public boolean hasNextInt() {
    if (!hasNext()) {
      return false;
    }
    final byte intLen = 11;
    while (start + intLen >= end && state != STATE_EOF) {
      readToBuffer();
    }
    int i = start;
    for (; i < end; i++) {
      char ch = buffer[i];
      if (Character.isWhitespace(ch)) {
        break;
      }
      if (ch != '-' && ch != '+' && !Character.isDigit(ch)) {
        return false;
      }
      if (i - start > intLen) {
        return false;
      }
    }
    try {
      String part = new String(buffer, start, i - start);
      parsedInt = Integer.parseInt(part);
    } catch (NumberFormatException error) {
      return false;
    }
    parsedIntEnd = i;
    return true;
  }

  public int nextInt() {
    if (!hasNextInt()) {
      throw new NoSuchElementException("There is no next int");
    }
    start = parsedIntEnd;
    return parsedInt;
  }

  public void close() {
    state = STATE_CLOSED;
    try {
      reader.close();
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }

  private void skipWhitespaces() {
    while (start < end && Character.isWhitespace(buffer[start])) {
      ++start;
    }
  }

  private void readToBuffer() {
    if (start < end) {
      System.arraycopy(buffer, start, buffer, 0, end - start);
    }
    end -= start;
    start = 0;
    try {
      int count = reader.read(buffer, end, buffer.length - end);
      if (count == -1) {
        state = STATE_EOF;
      } else {
        end += count;
      }
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }
}
