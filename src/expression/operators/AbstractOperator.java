package expression.operators;

import expression.interfaces.Expression;

public abstract class AbstractOperator implements Expression {
  protected final Expression left;
  protected final Expression right;
  protected final String operator;

  public AbstractOperator(Expression left, Expression right, String operator) {
    this.left = left;
    this.right = right;
    this.operator = operator;
  }

  @Override
  public String toString() {
    return "(" + left + " " + operator + " " + right + ")";
  }
}
