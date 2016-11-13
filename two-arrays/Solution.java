import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
       
    Scanner scanner = new Scanner(System.in);

    int t = scanner.nextInt();
int n;
    long k;
    while(t--!=0)
    {
n = scanner.nextInt();
      k = scanner.nextLong();

      long A[] = new long[n];

      Long B[] = new Long[n];

      for(int i =0;i<n;i++)
      {
        A[i] = scanner.nextLong();
      }

      for(int i =0;i<n;i++)
      {
        B[i] = scanner.nextLong();
      }

      Arrays.sort(A);

      Arrays.sort(B,Collections.reverseOrder());

      boolean flag = true;
      for(int i =0;i<n;i++)
      {
        if(!(A[i] + B[i] >= k))
          flag = false;

      }

      if(flag)
        System.out.println("YES");
      else
        System.out.println("NO");


    }
}
}
