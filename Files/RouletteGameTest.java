package Files;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by Padraig on 04/11/2016.
 */
public class RouletteGameTest {
    Random rnd = new NonRandom();
    Wheel wheel = new Wheel(rnd);
    Table table = new Table(wheel);
    Player player = new Passenger57(table);

    RouletteGame game = new RouletteGame(wheel, table);

    @Test
    public void cycle() throws Exception {
        for (int i = 0; i < 5; i++) {
            System.out.println("Cycle x 3\n");
            game.cycle(player);
            game.cycle(player);
            game.cycle(player);
        }
    }

}