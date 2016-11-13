import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

  
         static class Event{
    int month;
    int date;
    Integer actualNumber;

    public Event(Integer month, Integer date) {
      this.actualNumber = Integer.parseInt(date.toString(),month);
    }


    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof Event)) return false;

      Event event = (Event) o;

      return actualNumber.equals(event.actualNumber);

    }

    @Override
    public int hashCode() {
      return actualNumber.hashCode();
    }
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int month,date;
    HashMap<Event,Integer> map = new HashMap();
    for(int i=0;i<n;i++) {
      month = sc.nextInt();
      date = sc.nextInt();

      try {
        Event d = new Event(month, date);
        Integer current = map.get(d);
        if (current == null) {
          current = new Integer(0);
        }
        current = current + 1;
        map.put(d, current);

      } catch (Exception e) {

      }
    }

      Set<Map.Entry<Event, Integer>> set = map.entrySet();
      long count =0 ;
      for (Map.Entry<Event, Integer> entry :  set)
      {
        long tmp = entry.getValue();

        count = count + (tmp *(tmp-1)) /2;
      }
    System.out.println(count);
  
    }
}
