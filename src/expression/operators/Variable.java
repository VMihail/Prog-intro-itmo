package expression.operators;

import expression.interfaces.Expression;

public class Variable implements Expression {
  private final String variableName;

  public Variable(String variableName) {
    this.variableName = variableName;
  }

  @Override
  public int evaluate(int value) {
    return value;
  }

  @Override
  public String toString() {
    return variableName;
  }
}
