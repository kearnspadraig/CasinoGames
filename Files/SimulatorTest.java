package Files;

import org.junit.Test;

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
    Player martin = new Martingale(table, 200, 1000);
    RouletteGame game = new RouletteGame(wheel, table);
    Simulator sim = new Simulator(martin, game);

    @Test
    public void session() throws Exception {
        LinkedList<Integer> stakes = sim.session();
        //System.out.println(table.getLimit() + '\n' + martin.toString());
        assertTrue(stakes.size() > 0);
        System.out.println("\n");
        for (Integer i: stakes
             ) {
            System.out.print(i + " ");
        }
    }

    @Test
    public void gather() throws Exception {
        //ToDo False test
        for (int i = 0; i < 100; i++){
            session();
        }
    }

}