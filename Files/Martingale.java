package Files;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Set;
import java.util.Hashtable;

/**
 * Created by Padraig on 04/11/2016.
 */
public class Martingale extends Player {
    int lossCount = 0;
    int betMultiple = 1;

    public Martingale(){
        super();
    }

    public Martingale(Table table, int inStake){
        super(table, inStake);
    }

    public Martingale(Table table, int inStake, int inRoundsToGo){
        super(table, inStake, inRoundsToGo);
    }

    public void placeBets(){
        Bet black = new Bet(betMultiple, table.wheel.getOutcome("Black Bet"));
        try{
            table.placeBet(black);
            this.stake -= black.loseAmount();
            roundsToGo--;
        }catch(InvalidBet e){
            System.out.print("Failure to bet from Martingale Class");
        }
    }

    public void winners(Set<Outcome> winners){
        roundsToGo--;
    }

    public boolean playing(){
        if(betMultiple > stake || roundsToGo < 1 || betMultiple > table.getLimit()){
            return false;
        }
        return true;
    }

    public void win(Bet winningBet){
        super.win(winningBet);
        lossCount = 0;
        betMultiple = 1;
    }

    public void lose(Bet losingBet){
        super.lose(losingBet);
        lossCount++;
        betMultiple = betMultiple * 2;
    }

    private void setBetMultiple(){
        betMultiple = 1;
        for (int i = 0; i < lossCount; i++){
            betMultiple = betMultiple * 2;
        }
    }

    public HashMap<String, Integer> getVariables(){
        HashMap<String, Integer> values = new HashMap<String, Integer>(2);
        values.put("lossCount", lossCount);
        values.put("betMultiple", betMultiple);
        return values;
    }
    public String toString(){
        return String.format("Player: \nStake %d \nLossCount %d\nbetMultiple %d\nRoundsToGo %d",
                stake, lossCount, betMultiple, roundsToGo);
    }
}
