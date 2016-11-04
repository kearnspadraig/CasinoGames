package Files;

/**
 * Created by Padraig on 04/11/2016.
 */
public abstract class Player {
    int stake;
    int roundsToGo;
    Table table;

    Player(){
        stake = 500;
        roundsToGo = 10000;
    }

    Player(Table activeTable, int inStake){
        stake = stake;
        table = activeTable;
    }

    Player(Table activeTable, int inStake, int inRoundsToGo){
        this(activeTable, inStake);
        roundsToGo = inRoundsToGo;
    }

    public abstract void placeBets();
    public abstract boolean playing();

    public void win(Bet winningBet){
        stake = stake + winningBet.winAmount();
    }

    public void lose(Bet losingBet){
        System.out.println("Lose");
    }
        //ToDo
}
