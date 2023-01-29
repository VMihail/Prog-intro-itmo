package Wspp;

public interface List {
  void add(int el);
  int get(int i);
  void set(int i, int value);
  int size();
  int getDefaultCapacity();
  void clear();
}
