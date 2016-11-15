package Files;

import java.util.*;

/**
 * Created by Padraig on 13/10/2016.
 */
public class Bin {
    private Set<Outcome> outcomes;

    // **Constructors**
    public Bin(){
        outcomes = new TreeSet();
    }

    public Bin(Outcome [] outcomesIn){
        this();
        outcomes.addAll(Arrays.asList(outcomesIn));
    }

    public Bin(Collection<Outcome> outcomesIn){
        this();
        outcomes.addAll(outcomesIn);
    }

    // **Methods**
    public void add(Outcome outcome){
        outcomes.add(outcome);
    }

    public boolean hasOutcome(Outcome check){
        return outcomes.contains(check);
    }

    public Iterator<Outcome> outcomeIter(){
        return outcomes.iterator();
    }

    public Set<Outcome> getOutcomes(){
        return outcomes;
    }

    public String toString(){
        String readable = "";
        for(Outcome o: outcomes){
            readable = readable + o.toString() + "\n";
        }
        return readable;
    }

}
