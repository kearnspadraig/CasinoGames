package Files;

/**
 * Created by Padraig on 26/10/2016.
 */
public class Bet {
    private int amount;
    private Outcome outcome;

    Bet(int amountT, Outcome outcomeT){
        amount = amountT;
        outcome = outcomeT;
    }

    int winAmount(){
        return outcome.winAmount(amount) + amount;
    }

    int loseAmount(){
        return amount;
    }

    public String toString(){
        return String.format("Bet of %d on %s", amount, outcome.toString());
    }
}
