import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
static class Model{
      int[] arr;
      int level;

      public Model(int[] arr, int level) {
        this.arr = arr;
        this.level = level;
      }

      public int[] getArr() {
        return arr;
      }

      public void setArr(int[] arr) {
        this.arr = arr;
      }

      public int getLevel() {
        return level;
      }

      public void setLevel(int level) {
        this.level = level;
      }
    }
    public static void main(String[] args) {

      Scanner scanner = new Scanner(System.in);

      int t = scanner.nextInt();
      while(t--!=0)
      {
        int dimension = scanner.nextInt();

        int steps = scanner.nextInt();

        int[] startPoint = new int[dimension+1];
        int level=1;
        Model startModel = new Model(startPoint,level);
        for(int i=1;i<=dimension;i++)
        {
          startPoint[i] = scanner.nextInt();
        }

        int[] dimensions = new int[dimension+1];
        for(int i=1;i<=dimension;i++)
        {
          dimensions[i] = scanner.nextInt();
        }

        Queue<Model> queue = new LinkedList<>();

        HashMap<int[],List<int[]>> map = new HashMap<>();

        queue.add(startModel);
        int m = steps;
        long sum =0;
        int lastlevel=1;
        while(!queue.isEmpty()) {

          Model start = queue.remove();
          int[] startarr = start.getArr();
          level = start.getLevel();

          if (lastlevel != level) {

            m--;
            lastlevel = level;
            if (m == 0)
              break;
            sum = 0;
          }
          List<int[]> listOFNeighbours = new ArrayList<>();
          if (map.containsKey(startarr)) {
            List<int[]> list = map.get(startarr);
            sum +=list.size();

            for(int[] neig : list)
            {
              queue.add(new Model(neig, level + 1));
            }

          } else {
            for (int i = 1; i <= dimension; i++) {
              int tmp = startarr[i];

              if (neighboursOfPoint(tmp + 1, dimensions[i])) {
                sum += 1;
                int[] newNeighbour = Arrays.copyOf(startarr, startarr.length);
                newNeighbour[i] += 1;
                listOFNeighbours.add(newNeighbour);

                queue.add(new Model(newNeighbour, level + 1));

              }

              if (neighboursOfPoint(tmp - 1, dimensions[i])) {
                sum += 1;
                int[] newNeighbour = Arrays.copyOf(startarr, startarr.length);
                newNeighbour[i] -= 1;
                listOFNeighbours.add(newNeighbour);

                queue.add(new Model(newNeighbour, level + 1));

              }

            }

            map.put(startarr, listOFNeighbours);


          }
        }

        System.out.println(sum%1000000007);




      }

    }

  private static boolean neighboursOfPoint(int i, int dimension) {

    if( i <=0 || i > dimension)
      return false;
    else
      return true;

  }
}
