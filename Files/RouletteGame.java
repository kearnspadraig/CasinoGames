package Files;

import java.util.Iterator;

/**
 * Created by Padraig on 24/10/2016.
 */
class RouletteGame {
    static final int StraightBet = 35;
    static final int SplitBet = 17;
    static final int StreetBet = 11;
    static final int CornerBet = 8;
    static final int LineBet = 5;
    static final int DozenBet = 2;
    static final int ColumnBet = 2;
    static final int EvenBet = 1;
    static final int OddBet = 1;
    static final int RedBet = 1;
    static final int BlackBet = 1;
    static final int HighBet = 1;
    static final int LowBet = 1;

    Wheel wheel;
    Table table;
    Player player;

    RouletteGame(Wheel inWheel, Table inTable){
        wheel = inWheel;
        table = inTable;
    }

    public void cycle(Player inPlayer){
        player = inPlayer;
        player.placeBets();
        Bin winningBin = wheel.spin();

        Iterator<Bet> tableBets = table.iterator();
        while(tableBets.hasNext()){
            Bet currentBet = tableBets.next();
            if(winningBin.hasOutcome(currentBet.getOutcome())){
                player.win(currentBet);
            }else{
                player.lose(currentBet);
            }
        }
        table.removeAllBets();
    }
}
