package Files;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Padraig on 05/11/2016.
 */
public class Simulator {

    int initDuration = 250;
    int initState = 100;
    int samples = 50;
    List durations;
    List maxima;
    Player player;
    RouletteGame game;

    public Simulator(Player inPlayer, RouletteGame inGame){
        player = inPlayer;
        game = inGame;
    }

    public LinkedList session(){
        player = new Martingale(game.table, initState, initDuration);
        player.setStake(initState);
        player.setRoundsToGo(initDuration);
        LinkedList<Integer> stakes = new LinkedList<Integer>();
        while (player.playing()){
            game.cycle(player);
            stakes.add(player.stake);
        }
        return stakes;
    }

    public void gather(){
        LinkedList<Integer> stakesInSample;
        for (int i = 0; i < samples; i++){
            stakesInSample = session();
            durations.add(stakesInSample.size());
            int max = 0;
            for (Integer stake: stakesInSample
                 ) {
                if (stake > max){
                    max = stake;
                }
            }
            maxima.add(max);
        }
    }
}
