package TestingSuite;

import Files.IntegerStatistics;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by kobold1 on 10/11/2016.
 */
public class IntegerStatisticsTest {
  @Test
  public void mean() throws Exception {
    int [] intList = {9, 8, 5, 9, 9, 4, 5, 8, 10, 7, 8, 8};
    LinkedList<Integer> list = new LinkedList<Integer>();
    for (int i: intList
         ) {
      list.add(i);
    }
    Assert.assertEquals(IntegerStatistics.mean(list), 7.5, .00001);

  }

  @Test
  public void stdev() throws Exception {
    int [] intList = {9, 8, 5, 9, 9, 4, 5, 8, 10, 7, 8, 8};
    LinkedList<Integer> list = new LinkedList<Integer>();
    for (int i: intList
            ) {
      list.add(i);
    }

    System.out.println(IntegerStatistics.stdev(list));
    assertEquals(IntegerStatistics.stdev(list), 1.88293, .00001);
  }

}