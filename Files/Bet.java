package Files;

/**
 * Created by Padraig on 26/10/2016.
 */
public class Bet {
    private int amount;
    private Outcome outcome;

    public Bet(int amountT, Outcome outcomeT){
        amount = amountT;
        outcome = outcomeT;
    }

    public Outcome getOutcome(){return outcome;}

    public int winAmount(){
        return outcome.winAmount(amount) + amount;
    }

    public int loseAmount(){
        return amount;
    }

    public String toString(){
        return String.format("Bet of %d on %s", amount, outcome.toString());
    }
}
