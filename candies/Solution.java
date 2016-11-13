import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int arr_i=0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int result[] = new int[n];
        result[0]=1;
        for(int i=1;i<n;i++)
            {
            if(arr[i]>arr[i-1])
                {
                result[i] = result[i-1] +1;
            }
            else
                {
                result[i]=1;
            }
        }
        int sum=result[n-1];
        for(int i= n-2;i>=0;i--)
            {
            if(arr[i] > arr[i+1])
                {
                result[i] = Math.max(result[i],result[i+1] +1);
            }
            sum +=result[i];
        }
        System.out.println(sum);
    }
}
