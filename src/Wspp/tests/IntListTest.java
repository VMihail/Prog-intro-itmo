package Wspp.tests;

import Wspp.IntList;
import Wspp.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IntListTest {
  private final List list = new IntList();

  @Test
  public void testAdd() {
    final int len = list.getDefaultCapacity() + 5;
    int count = 0;
    for (int i = 0; i < len; i++) {
      list.add(i);
      Assertions.assertEquals(++count, list.size());
    }
    for (int i = 0; i < len << 1; i++) {
      list.add(i);
      Assertions.assertEquals(++count, list.size());
    }
  }

  @Test
  public void testGetSet() {
    list.clear();
    for (int i = 0; i < 100; i++) {
      list.add(i);
    }
    Assertions.assertEquals(list.get(0), 0);
    list.set(0, Integer.MAX_VALUE);
    Assertions.assertEquals(list.get(0), Integer.MAX_VALUE);
    list.set(1, Integer.MIN_VALUE);
    Assertions.assertEquals(list.get(1), Integer.MIN_VALUE);
  }
}
