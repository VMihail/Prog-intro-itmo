package expression.operators;

import expression.interfaces.Expression;

public class Const implements Expression {
  private final int value;

  public Const(int value) {
    this.value = value;
  }

  @Override
  public int evaluate(int value) {
    return this.value;
  }

  @Override
  public String toString() {
    return Integer.toString(value);
  }
}
