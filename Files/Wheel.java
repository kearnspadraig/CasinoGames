package Files;

/**
 * Created by Padraig on 21/10/2016.
 */

import java.util.Hashtable;
import java.util.Map;
import java.util.Vector;
import java.util.Random;

class Wheel {
    private Vector<Bin> bins;
    private Random rng;

    private Map<String, Outcome> outcomeMap;

    public Wheel(){
        bins = new Vector<Bin>(37);
        outcomeMap = new Hashtable();
        BinBuilder builder = new BinBuilder();
        builder.buildBins(this);
        rng = new Random();
    }

    public Wheel(Random givenRng){
        this();
        rng = givenRng;
    }

    public void addOutcome(int bin, Outcome outcomeIn){
        outcomeMap.put(outcomeIn.getName(), outcomeIn);
        Bin binAtIndex = bins.get(bin);
        binAtIndex.add(outcomeIn);
    }

    public Outcome getOutcome(String name){
        return outcomeMap.get(name);
    }

    public Map getAllOutcomes(){
        return outcomeMap;
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
