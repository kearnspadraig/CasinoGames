package Files;

/**
 * Created by Padraig on 04/11/2016.
 */
public class Passenger57 extends Player {
    Outcome black ;
    Table table;

    Passenger57(Table activeTable){
        table = activeTable;
        System.out.println("Table.wheel = " + table.wheel.toString());
        black = activeTable.wheel.getOutcome("Black Bet");
    }

    public void placeBets(){
        try {
            table.placeBet(new Bet(5, black));
        }catch (InvalidBet e){
            System.out.print("Passenger 57 Failed to bet");
        }
    }

    public void win(Bet winningBet){
        System.out.println(String.format("Winning Bet! %s \n Won %d", winningBet.toString(), winningBet.winAmount()));
    }

    public void lose(Bet winningBet){
        System.out.println(String.format("Losing Bet! %s \n lost %d", winningBet.toString(), winningBet.loseAmount()));
    }
}
