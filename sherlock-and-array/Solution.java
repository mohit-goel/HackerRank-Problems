import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t--!=0)
            {
            int n = sc.nextInt();
            long arr[] = new long[n];
            long leftsum[] = new long[n];
            long rightsum[] = new long[n];
            leftsum[0]=0;
            rightsum[n-1]=0;
            for(int i=0;i<n;i++)
                {
                arr[i] = sc.nextInt();
            }
           for(int i=1;i<n;i++)
                {
                leftsum[i] = leftsum[i-1] + arr[i-1];
            }
            for(int i=n-2;i>=0;i--)
                {
                rightsum[i] = rightsum[i+1] + arr[i+1];
            }
            boolean flag=false;
            
            for(int i=0;i<n;i++)
                {
                if(leftsum[i] == rightsum[i])
                {
                    flag =true;
                    break;
                }
                
            }
            
            if(flag){
                System.out.println("YES");
            }
                else{
                    System.out.println("NO");
                    
                }
            
        }
    }
}
