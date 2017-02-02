package TestingSuite;

import Files.Bet;
import Files.Outcome;
import Files.Table;
import Files.Wheel;
import org.junit.Test;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by kobold1 on 28/10/2016.
 */
//Todo Fill in
public class TableTest {
  Outcome testOutcome = new Outcome("TestOutcome", 10);
  Bet testBet1 = new Bet(5, testOutcome);
  Wheel wheel = new Wheel(new Random(37));
  Table table = new Table(wheel, 2);

  @Test
  public void placeBet() throws Exception {
    table.placeBet(testBet1);
    Collection<Bet> allBets = table.getBets();
    boolean found = false;
    for (Bet b: allBets
         ) {
      if(b.equals(testBet1)){
        found = true;
      }
    }
    assertTrue(found);
  }

  @Test
  public void removeBet() throws Exception {
    table.placeBet(testBet1);
    table.removeBet(testBet1);
    Collection<Bet> allBets = table.getBets();
    boolean found = false;
    for (Bet b: allBets
            ) {
      if(b.equals(testBet1)){
        found = true;
      }
    }
    assertFalse(found);
  }

  @Test
  public void isValid() throws Exception {
    int limit = table.getLimit();
    assertFalse(table.isValid(new Bet(limit + 1, testOutcome)));
    assertTrue(table.isValid(new Bet(limit - 1, testOutcome)));
  }

  @Test
  public void betsPlacedTotal() throws Exception {
    int total = 0;
    table.placeBet(testBet1);
    table.placeBet(new Bet(50, testOutcome));

    Collection<Bet> allBets = table.getBets();
    for (Bet b: allBets
            ) {
      total += b.loseAmount();
    }

    assertTrue(table.betsPlacedTotal() == total);
  }

  @Test
  public void iterator() throws Exception {
    table.placeBet(testBet1);
    System.out.println(table.iterator().next().toString());
    assertTrue(table.iterator().hasNext());
  }

  @Test
  public void toStringTest() throws Exception {
    table.placeBet(testBet1);
    System.out.println(table.toString());
  }

}