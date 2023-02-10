package expression.operators;

import expression.interfaces.Expression;

public class Divide extends AbstractOperator {
  public Divide(Expression left, Expression right) {
    super(left, right, "/");
  }

  @Override
  public int evaluate(int value) {
    return left.evaluate(value) / right.evaluate(value);
  }
}
