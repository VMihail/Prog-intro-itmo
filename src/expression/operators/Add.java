package expression.operators;

import expression.interfaces.Expression;

public class Add extends AbstractOperator {
  public Add(Expression left, Expression right) {
    super(left, right, "+");
  }

  @Override
  public int evaluate(int value) {
    return left.evaluate(value) + right.evaluate(value);
  }
}
