import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    String genes = sc.next();
    char[] genesArr = genes.toCharArray();
   HashMap<Character,Integer> map = new HashMap<>();
   char max = ' ';
    int maxvalue = Integer.MIN_VALUE;
    for(int i=0;i<n;i++)
    {
     Integer current = map.get(genesArr[i]);
      if(current == null)
      {
        current = new Integer(0);
      }
      current = current + 1;
      if(current > maxvalue)
      {
        max = genesArr[i];
        maxvalue = current;
      }

      map.put(genesArr[i],current);
    }
int tmp[] = new int[n];
    for(int i=0;i<n;i++)
    {
      if(max == genesArr[i])
      {
        tmp[i]++;
      }
      if(i !=0)
      tmp[i]+= tmp[i-1];
    }
    int difference  = map.get(max) - (n/4);
    int minresult=Integer.MAX_VALUE;
    for(int i =0 ;i<n;i++)
    {

      for(int j=i+difference-1;j<n;j++)
      {
        if(tmp[j] - tmp[i] == difference)
        {
              if(minresult > (j-i))
                minresult = j-i;
        }
      }
    }
    System.out.println(minresult);


    }
}
