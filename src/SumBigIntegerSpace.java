import java.math.BigInteger;

public class SumBigIntegerSpace {
  public static void main(String[] args) {
    StringBuilder sb = new StringBuilder();
    for (String arg : args) {
      sb.append(arg).append(" ");
    }
    BigInteger sum = BigInteger.valueOf(0);
    StringBuilder nextNumber = new StringBuilder();
    for (int i = 0; i < sb.length(); i++) {
      char nextChar = sb.charAt(i);
      if ((Character.getType(nextChar) == Character.SPACE_SEPARATOR)) {
        continue;
      }
      if (nextChar == '-' && nextNumber.length() == 0 || Character.isDigit(nextChar)) {
        nextNumber.append(nextChar);
      } else if (nextNumber.length() > 0) {
        sum = sum.add(new BigInteger(nextNumber.toString()));
        nextNumber.setLength(0);
      }
    }
    System.out.println(sum);
  }
}