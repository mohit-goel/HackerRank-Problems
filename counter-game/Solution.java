import java.io.*;
import java.util.*;
import java.math.BigInteger;
public class Solution {
public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int t = scanner.nextInt();

    while(t--!=0) {
      boolean turn = true;   // true: Louise  false:Richard

      BigInteger n  = scanner.nextBigInteger();



      while (!n.equals(BigInteger.ONE)) {
        if (!isPowerOfTwo(n)) {

          int pow1 = n.bitLength()-1;
          BigInteger result = BigInteger.ZERO.setBit(pow1);
          n = n.subtract(result);
        } else {
          n = n.shiftRight(1);
        }

        turn = !turn;
        if (n.equals(BigInteger.ONE)) {
          System.out.println(turn ? "Richard" : "Louise");
          break;

        }
      }

    }}



  public static boolean isPowerOfTwo(BigInteger n)
  {
    BigInteger tmp = n.subtract(BigInteger.ONE);
       return n.and(tmp).equals(BigInteger.ZERO);
  }
}
