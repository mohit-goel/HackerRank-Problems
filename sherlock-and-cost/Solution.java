import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        int t = scanner.nextInt();
        while(t-- >0)
            {
            
            int n = scanner.nextInt();
            
            int input[] = new int[n];
            
            for(int i =0;i<n;i++)
                input[i] = scanner.nextInt();
            
           
            
            int result = calculate(input,n);
            
            System.out.println(result);
                
        }
       
    }
    
    private static int calculate(int input[],int n)
        {
         if( n ==1)
                return 0;
        
        int[][] tmp = new int[2][n];
        
       tmp[0][0]=0;
        tmp[1][0]=0;
        
        for(int i =1;i<n;i++){
            
            tmp[0][i] = Math.max(tmp[0][i-1], Math.abs(1- input[i-1]) + tmp[1][i-1]);
            
            tmp[1][i] = Math.max(Math.abs(input[i]-1) + tmp[0][i-1] , Math.abs(input[i]-input[i-1]) + tmp[1][i-1] );
            
        }
        
        return Math.max(tmp[0][n-1],tmp[1][n-1]);
        
        
    }
}
