package Wspp;

public class IntList implements List {
  private static final int DEFAULT_CAPACITY = 10;
  private int capacity = DEFAULT_CAPACITY;
  private int[] array;
  private int pos;

  public IntList(int startCapacity) {
    if (startCapacity < 0) {
      throw new IllegalArgumentException("Illegal Capacity: " + startCapacity);
    }
    capacity = startCapacity;
    array = new int[capacity];
  }

  public IntList() {
    array = new int[capacity];
  }

  @Override
  public void add(int el) {
    if (isFill()) {
      ensureCapacity();
    }
    array[pos++] = el;
  }

  @Override
  public int get(int i) {
    if (i < 0 || i >= pos) {
      throw new IndexOutOfBoundsException(indexOutOfBoundsExceptionMessage(i, pos));
    }
    return array[i];
  }

  @Override
  public void set(int i, int value) {
    if (i < 0 || i >= pos) {
      throw new IndexOutOfBoundsException(indexOutOfBoundsExceptionMessage(i, pos));
    }
    array[i] = value;
  }

  @Override
  public int size() {
    return pos;
  }

  @Override
  public String toString() {
    if (size() == 0) {
      return "[]";
    }
    StringBuilder sb = new StringBuilder("[");
    for (int i = 0; i < pos - 1; i++) {
      sb.append(array[i]).append(", ");
    }
    return sb.append(array[pos - 1]).append("]").toString();
  }

  @Override
  public int getDefaultCapacity() {
    return DEFAULT_CAPACITY;
  }

  @Override
  public void clear() {
    capacity = DEFAULT_CAPACITY;
    array = new int[DEFAULT_CAPACITY];
  }

  private boolean isFill() {
    return pos == capacity;
  }

  private void ensureCapacity() {
    if (capacity == 0) {
      capacity = DEFAULT_CAPACITY;
      array = new int[capacity];
      return;
    }
    int[] newArray = new int[capacity <<= 1];
    if (pos >= 0) System.arraycopy(array, 0, newArray, 0, pos);
    array = newArray;
  }

  private String indexOutOfBoundsExceptionMessage(int index, int length) {
    return "Index " + index + " out of bounds for length " + length;
  }
}
