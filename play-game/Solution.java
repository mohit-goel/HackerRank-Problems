import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
         Scanner scanner = new Scanner(System.in);

    int t = scanner.nextInt();
    while(t-- >0){

      int n = scanner.nextInt();
      long[] arr = new long[n];

      for(int i=0;i<n;i++)
      {
        arr[i] = scanner.nextLong();
      }
      long sum =0;
      if(n <=3)
      {
        for(int i=0;i<n;i++)
        {
          sum += arr[i];

        }
        System.out.println(sum);
      }
      else
      {
        long tmp[] = new long[n];
        long result[] = new long[n];
        tmp[0] = arr[n-1];
        for(int i = n-2;i >=0;i--)
          tmp[n - i - 1 ] = arr[i] + tmp[n - i -2];


        for(int i=0;i<3;i++)
          result[i] = tmp[i];


        for(int i =3;i<n;i++)
        {

          result[i] = tmp[i] - Math.min(result[i-1],Math.min(result[i-2],result[i-3]));
        }

        System.out.println(result[n-1]);
      }













    }


    }
}
