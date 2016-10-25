package TestingSuite;

import Files.Outcome;
import Files.Bin;
import org.junit.Test;

/**
 * Created by Padraig on 19/10/2016.
 */
public class BinTest {

    private final Outcome five = new Outcome("00-0-1-2-3", 6);
    private final Outcome zero = new Outcome("0", 35);
    private final Outcome zeroZero = new Outcome("00", 35);

    private Bin zeroBin = new Bin();

    private final Outcome[] ocZeroZero= {zeroZero, five};
    private Bin zeroZeroBin = new Bin(ocZeroZero);

    @Test
    public void add() throws Exception {
        zeroBin.add(five);
        zeroBin.add(zero);
    }

    @Test
    public void toStringTest() throws Exception {
        String zeroBinString = zeroBin.toString();
        String zeroZeroBinString = zeroZeroBin.toString();

        //assertSame("", zeroBinString);
        //assertSame("", zeroZeroBinString);
    }

}