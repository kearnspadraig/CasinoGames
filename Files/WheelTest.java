package Files;

import org.junit.Test;

import java.util.Iterator;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by Padraig on 21/10/2016.
 */
public class WheelTest {
    Random rng = new NonRandom();
    Wheel wheel = new Wheel(rng);

    @Test
    public void addOutcome() throws Exception {
        wheel.addOutcome(0,new Outcome("Test",5));

//ToDo Fill in tests
    }

    @Test
    public void next() throws Exception {

    }

    @Test
    public void get() throws Exception {
        Bin bin6 = wheel.get(7);
        Iterator<Outcome> outcomeIter = bin6.outcomeIter();
        while(outcomeIter.hasNext()){
            assertFalse(outcomeIter.next().toString() == "");
        }
    }

    @Test
    public void toStringTest() throws Exception {
        String test = wheel.toString();
        assertNotNull(test);
        System.out.print(test);
    }
}