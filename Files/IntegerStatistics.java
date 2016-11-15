package Files;

/**
 * Created by kobold1 on 10/11/2016.
 */

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


public class IntegerStatistics {
  public static double mean(List<Integer> list){
    int sum = 0;
    for(Iterator<Integer> i = list.iterator(); i.hasNext();){
      sum += i.next();
    }
    return (double)sum / (double)list.size();
  }

  public static double stdev(List<Integer> list){
    double mean = mean(list);
    double sum = 0;
    double variance = 0;
    for(Iterator<Integer> i = list.iterator(); i.hasNext();){
      double diff = mean - i.next();
      sum += diff * diff;
    }
    variance = sum / (list.size() -1);
    return Math.sqrt(variance);
  }
}
