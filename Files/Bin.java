package Files;

import java.util.*;

/**
 * Created by Padraig on 13/10/2016.
 */
public class Bin {
    private Set outcomes;

    public Bin(){
        outcomes = new TreeSet();
    }

    public Bin(Outcome [] outcomesIn){
        this();
        for(Outcome o: outcomesIn){
            outcomes.add(o);
        }
    }

    public Bin(Collection<Outcome> outcomesIn){
        this();
        Iterator i = outcomesIn.iterator();
        for(Outcome o: i){
            outcomes.add(o);
        }
    }


    public void add(Outcome outcome){
        outcomes.add(outcome);
    }

    public String toString(){
        String readable = "";
        for(Outcome o: outcomes){
            readable = readable + o.toString() + "\n";
        }
        return readable;
    }

}
