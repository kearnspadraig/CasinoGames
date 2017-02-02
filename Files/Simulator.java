package Files;

import sun.awt.image.ImageWatched;

import java.util.HashMap;
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

    public Simulator(Player inPlayer, RouletteGame inGame, int inInitStake, int inInitDuration, int inSamples){
        this(inPlayer, inGame);
        initState = inInitStake;
        initDuration = inInitDuration;
        samples = inSamples;

    }

    public LinkedList session(){
        if (player.equals(null)) {
            System.out.println("No Player Given");
            player = new Martingale(game.table, initState, initDuration);
        }
        try{
            player = player.getClass().newInstance();
        }catch(Exception e){
            System.out.println(e.toString());
        }
        player.setStake(initState);
        player.setRoundsToGo(initDuration);
        player.setTable(game.table);
        //}
        LinkedList<Integer> stakes = new LinkedList<Integer>();
        while (player.playing()){
            game.cycle(player);
            stakes.add(player.stake);
        }
        return stakes;
    }

    public HashMap gather(){
        LinkedList<Integer> stakesInSample;
        maxima = new LinkedList();
        durations = new LinkedList();
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
        HashMap<String, List> gatheredValues = new HashMap<>(2);
        gatheredValues.put("maxima", maxima);
        gatheredValues.put("durations", durations);
        return gatheredValues;
    }
}
