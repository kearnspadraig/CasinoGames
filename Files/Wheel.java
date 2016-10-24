package Files;

/**
 * Created by Padraig on 21/10/2016.
 */

import java.util.Iterator;
import java.util.Vector;
import java.util.Random;

public class Wheel {
    Vector<Bin> bins;
    Random rng;

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

    public Bin next(){
        int winningBin = rng.nextInt(bins.size());
        return this.get(winningBin);
    }

    public Bin get(int bin){
        return bins.get(bin);
    }

    public String toString(){
        String finalString = "";
        Iterator binprinter = bins.iterator();
        while(binprinter.hasNext()){
            finalString+= binprinter.next().toString() + '\n';
        }
        return finalString;
    }
}
