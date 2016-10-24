package Files;

/**
 * Created by Padraig on 21/10/2016.
 */

import java.util.Iterator;
import java.util.Vector;
import java.util.Random;

public class Wheel {
    private Vector<Bin> bins;
    private Random rng;

    public Wheel(Random givenRng){
        rng = givenRng;
        bins = new Vector<Bin>(37);
        BinBuilder builder = new BinBuilder();
        builder.buildBins(this);
        //ToDo populateBins
    }

    public void addOutcome(int bin, Outcome outcomeIn){
        Bin binAtIndex = bins.get(bin);
        binAtIndex.add(outcomeIn);
    }

    public Bin spin(){
        int winningBin = rng.nextInt(bins.size());
        return this.get(winningBin);
    }

    public Bin get(int bin){
        return bins.get(bin);
    }

    public Vector<Bin> getAll(){return bins;}

    public String toString(){
        String finalString = "";
        for (Object bin : bins) {
            finalString += bin.toString() + '\n';
        }
        return finalString;
    }
}
