package Files;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by kobold1 on 28/10/2016.
 */
public class BetTest {
  Outcome testOutcome = new Outcome("Test", 5);
  int testAmount = 10;
  Bet testBet = new Bet(testAmount, testOutcome);

  @Test
  public void winAmount() throws Exception {
    int winnings = testBet.winAmount();

    assertTrue(winnings == 60);
  }

  @Test
  public void loseAmount() throws Exception {
    assertTrue(testBet.loseAmount() == testAmount);
  }

  @Test
  public void toStringTest() throws Exception {
    assertTrue(testBet.toString().equals(
            String.format("Bet of %d on %s", testAmount, testOutcome.toString())
    ));
    System.out.print(testBet.toString());
  }

}