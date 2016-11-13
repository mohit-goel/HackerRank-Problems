import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int numbers[]  = new int[n];
        String strings[] = new String[n];
        int individual[] = new int[100];
        int cumulative[] = new int[100];
        for(int i=0;i<n;i++)
            {
            numbers[i] = sc.nextInt();
            strings[i] = sc.next();
            
        }
         for(int i=0;i<n;i++)
            {
             individual[numbers[i]]++;
         }
        cumulative[0] = individual[0];
         for(int i=1;i<100;i++)
            {
             cumulative[i] =individual[i] + cumulative[i-1];
         }
        
        String result[] = new String[n];
        
        for(int i=n-1;i>=0;i--)
            {
            int position = cumulative[numbers[i]]-1;
            String str = strings[i];
            
            if(i < n/2)
                str = "-";
            
            result[position] = str;
             cumulative[numbers[i]]--;
        }
        StringBuilder build = new StringBuilder(n*2);
        for(int i=0;i<n;i++)
            {
            
         build.append(result[i]).append(" ");
        }
        
        System.out.println(build.toString());
        
        
        
    }
}
