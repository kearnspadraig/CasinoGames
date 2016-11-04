package Files;

import org.junit.Test;

import java.util.Iterator;
import java.util.Map;
import java.util.Random;

import static org.junit.Assert.*;


public class WheelTest {
    private Random rng = new NonRandom();
    private final Wheel wheel = new Wheel(rng);

    @Test
    public void addOutcome() throws Exception {
        String outcomeName = "Test";
        int testIndex = 0;
        wheel.addOutcome(testIndex,new Outcome(outcomeName,5));

        Bin testBin = wheel.get(testIndex);
        assertTrue(testBin.toString().contains(outcomeName));

    }

    @Test
    public void getOutcome() throws Exception{
        assertNotNull(wheel.getAllOutcomes());

        wheel.addOutcome(5, new Outcome("TestOutcome", 20));
        assertNotNull(wheel.getOutcome("TestOutcome"));

        assertNotNull(wheel.getOutcome("Black Bet"));
    }

    @Test
    public void spinTest() throws Exception {
        Bin winningBin = wheel.spin();

        assertTrue(!winningBin.equals(wheel.spin())||
                !winningBin.equals(wheel.spin())||
                !winningBin.equals(wheel.spin())||
                !winningBin.equals(wheel.spin()));

        assertTrue(winningBin.getClass().equals(Bin.class));


    }

    @Test
    public void get() throws Exception {
        Bin bin6 = wheel.get(6);
        Iterator<Outcome> outcomeIter = bin6.outcomeIter();

        while(outcomeIter.hasNext()){
            String bin6String = outcomeIter.next().toString();
            //System.out.print(bin6String);
            assertFalse(bin6String.equals(""));
        }
    }

    @Test
    public void mapTest() throws Exception {
        Map testMap = wheel.getAllOutcomes();
        for (Object o: testMap.values()
             ) {
            if(o.getClass().equals(Outcome.class)){
                System.out.println(o.toString());
            }else{
                fail();
            }
        }
    }

    @Test
    public void toStringTest() throws Exception {
        String test = wheel.toString();
        assertNotNull(test);
        System.out.print(test);
    }
}