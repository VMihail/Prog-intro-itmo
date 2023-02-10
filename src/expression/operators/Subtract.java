package expression.operators;

import expression.interfaces.Expression;

public class Subtract extends AbstractOperator {
  public Subtract(Expression left, Expression right) {
    super(left, right, "-");
  }

  @Override
  public int evaluate(int value) {
    return left.evaluate(value) - right.evaluate(value);
  }
}
