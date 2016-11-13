import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t--!=0)
            {
            int size = sc.nextInt();
            long M = sc.nextLong();
            long arr[] = new long[size];
           
            
            for(int i=0;i<size;i++)
                {
                arr[i] = sc.nextLong()%M;
            }
            long prefix[] = new long[size];
            long curr = 0;
            long max =Long.MIN_VALUE;
            long tmp=Long.MIN_VALUE;
            TreeSet<Long> set = new  TreeSet<Long>();
                for(int i = 0; i < size; i++) {
                    curr = (arr[i] % M + curr) % M;
                    prefix[i] = curr;
                    
                    set.add(curr);
                    
                    Long nextHighest = set.higher(curr);
                    tmp = curr;
                    if(nextHighest != null)
                        tmp = Math.max(curr,(curr - nextHighest + M)%M);
                    
                    max = Math.max(max,tmp);
                    
                }
            
           
          
            
            System.out.println(max);
    }
}
}
