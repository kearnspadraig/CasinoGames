package TestingSuite;

import Files.*;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by Padraig on 05/11/2016.
 */
public class SimulatorTest {
    Random rng = new Random();
    Wheel wheel = new Wheel(rng);
    Table table = new Table(wheel);
    Player martin = new SevenReds(table, 200, 1000);
    RouletteGame game = new RouletteGame(wheel, table);
    Simulator sim = new Simulator(martin, game, 200, 1000, 50);
    int sessionCalled = 0;

    @Test
    public void session() throws Exception {
        System.out.println(String.format("Session Called : %d", ++sessionCalled));
        LinkedList<Integer> stakes = sim.session();
        System.out.println(table.getLimit() + '\n' + martin.toString());
        assertTrue(stakes.size() > 0);
        System.out.println("\n");
        for (Integer i: stakes
             ) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    @Test
    public void gather() throws Exception {
        //ToDo False test
        HashMap values = sim.gather();
        System.out.println(values.get("maxima"));
        System.out.println(values.get("durations"));
    }

}