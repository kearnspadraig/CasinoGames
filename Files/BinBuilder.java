package Files;

import java.util.Vector;

/**
 * Created by Padraig on 24/10/2016.
 */
public class BinBuilder {
    public BinBuilder(){

    }

    public void buildBins(Wheel wheel){
        generateBins(wheel);
        generateStraightBets(wheel);
    }

    private void generateStraightBets(Wheel wheel){
        int odds = RouletteGame.StraightBet;
        for(int i = 0; i <= 36; i++){
            Outcome straightBet = new Outcome("Number "+i, odds);
            wheel.addOutcome(i, straightBet);
        }
        wheel.addOutcome(37, new Outcome("Number 00", odds));

    }

    private void generateBins(Wheel wheel){
        Vector<Bin> bins = wheel.bins;
        for (int i = 0; i <= 37; i++){
            bins.add(i, new Bin());
        }
    }
}
