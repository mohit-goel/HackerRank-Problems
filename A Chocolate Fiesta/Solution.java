import java.io.*;
import java.util.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

   public static void main(String[] args) {


     Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int set[] = new int[n];

    for (int i = 0; i < n; i++)
      set[i] = scanner.nextInt();


    Map<Boolean, Integer> evenOrOdd = Arrays.stream(set).boxed().collect(Collectors.partitioningBy(t -> t % 2 == 0, Collectors.summingInt(t -> 1)));

    int even = evenOrOdd.get(true);
    int odd = evenOrOdd.get(false);
    long oddcount =0;
    long evenCount = pow(even) -1 ;
    if(odd > 0)
     oddcount = pow(odd-1) -1;



    System.out.println( (evenCount + oddcount + evenCount *oddcount) % 1000000007);


  }
    private static long pow(long m){
long ans = 1;
while(m-->0) ans = (ans*2)%(1000000007);
return ans;
}
}
