import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

   public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();

    while (t-- > 0) {
      int n = in.nextInt();
      int result[] = new int[n + 1];
      result[1] = 1;
      result[0] = 1;

      for (int i = 2; i <= n; i++) {
        int tmp = 0;
        tmp += result[i - 1];

        if (i >= 4)
          tmp += result[i - 4];

        result[i] = tmp;

      }
      int m = result[n];

        boolean prime[] = new boolean[m+1];
        for(int i=0;i<= m;i++)
          prime[i] = true;

        for (int p=2; p*p<=m; p++)
        {
          // If prime[p] is not changed, then it is a prime
          if (prime[p] == true)
          {
            // Update all multiples of p
            for (int i=p*2; i<=m; i += p)
              prime[i] = false;
          }
        }
int primeCount=0;
        // Print all prime numbers
        for (int p=2; p<=m; p++)
          if (prime[p])
            primeCount++;
      System.out.println(primeCount);

    

  

  }
   }
}
