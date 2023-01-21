public class Sum {
  public static void main(String[] args) {
    StringBuilder sb = new StringBuilder();
    for (String s : args) {
      sb.append(s).append(" ");
    }
    int sum = 0;
    StringBuilder nextNumber = new StringBuilder();
    for (int i = 0; i < sb.length(); i++) {
      char nextChar = sb.charAt(i);
      if (nextChar == '-' && nextNumber.length() == 0 || Character.isDigit(nextChar)) {
        nextNumber.append(nextChar);
      } else if (nextNumber.length() > 0) {
        sum += Integer.parseInt(nextNumber.toString());
        nextNumber.setLength(0);
      }
    }
    System.out.println(sum);
  }
}
