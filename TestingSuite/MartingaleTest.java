package TestingSuite;

import Files.*;
import org.junit.Test;

import java.util.HashMap;
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

    HashMap<String, Integer> martinValues = martin.getVariables();

    @Test
    public void placeBets() throws Exception {
        table.removeAllBets();
        assertFalse(table.betsPlacedTotal() > 1);
        martin.placeBets();
        assertTrue(table.betsPlacedTotal() > 0);

        assertTrue(table.getBets().toString().contains("Black Bet"));
    }

    @Test
    public void playing() throws Exception {
        while (table.isValid(black)){
            martinValues = martin.getVariables();
            int martinBetMultiple = martinValues.get("betMultiple");
            System.out.println(String.format("Betting %d \n LossCount %d",
                    martinBetMultiple , martinValues.get("lossCount")));

            martin.lose(black);
            black = new Bet(martinBetMultiple , black.getOutcome());
            if (martinBetMultiple > table.getLimit()){
                System.out.println("Betting over limit");
            }
        }

        assertFalse(martin.playing());

        //ToDo
    }

    @Test
    public void win() throws Exception {
        int start = martin.getStake();
        martin.win(black);
        assertTrue(martin.getStake() == start + black.winAmount());
    }

    @Test
    public void lose() throws Exception {
        martinValues = martin.getVariables();
        int startCount = martinValues.get("lossCount");
        int startBet = martinValues.get("betMultiple");

        martin.lose(black);
        martinValues = martin.getVariables();
        assertTrue(startCount + 1 == martinValues.get("lossCount"));
        assertTrue(startBet * 2 == martinValues.get("betMultiple"));
    }



}