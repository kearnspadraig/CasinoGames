package Files;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by Padraig on 04/11/2016.
 */
public class MartingaleTest {
    Random rng = new NonRandom(37,0);
    Wheel wheel = new Wheel(rng);
    Table table = new Table(wheel, 1);
    Martingale martin = new Martingale(table, 100);

    Bet black = new Bet(1, wheel.getOutcome("Black Bet"));

    @Test
    public void placeBets() throws Exception {
        table.removeAllBets();
        assertFalse(table.betsPlacedTotal() > 1);
        martin.placeBets();
        assertTrue(table.betsPlacedTotal() > 0);

        assertTrue(table.bets.toString().contains("Black Bet"));
    }

    @Test
    public void playing() throws Exception {
        while (table.isValid(black)){
            System.out.println(String.format("Betting %d \n LossCount %d", martin.betMultiple, martin.lossCount));

            martin.lose(black);
            black = new Bet(martin.betMultiple, black.getOutcome());
            if (martin.betMultiple > table.getLimit()){
                System.out.println("Betting over limit");
            }
        }

        assertFalse(martin.playing());

        //ToDo
    }

    @Test
    public void win() throws Exception {
        int start = martin.stake;
        martin.win(black);
        assertTrue(martin.stake == start + black.winAmount());
    }

    @Test
    public void lose() throws Exception {
        int startCount = martin.lossCount;
        int startBet = martin.betMultiple;

        martin.lose(black);
        assertTrue(startCount + 1 == martin.lossCount);
        assertTrue(startBet * 2 == martin.betMultiple);
    }



}