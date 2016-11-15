package Files;

import java.util.Random;


/**
 * Created by kobold1 on 15/11/2016.
 */
public class RouletteMain {
  Player player;
  public static void main(String [] args){
    Random rng = new Random();
    Wheel wheel = new Wheel(rng);
    Table table = new Table(wheel, 2);
    RouletteGame game = new RouletteGame(wheel, table);

    //runMartingale(table, game);
    playPlayer(new Martingale(table, 500, 500), table, game);
    //playPlayer(new Passenger57(table, 500, 500), table, game);
    playPlayer(new SevenReds(table, 500, 500), table, game);



  }

  static void playPlayer(Player player, Table table, RouletteGame game){
    Simulator sim = new Simulator(player, game, 500, 500, 20);
    sim.gather();
    System.out.println(String.format("Maxima\n%s\nMean: %f\nStandard Deviattion: %f\n\n" +
                    "Durations\n%s\nMean: %f\nStandard Deviattion: %f\n\n",
            sim.maxima.toString(), IntegerStatistics.mean(sim.maxima),
            IntegerStatistics.stdev(sim.maxima), sim.durations.toString(), IntegerStatistics.mean(sim.durations),
            IntegerStatistics.stdev(sim.durations)));
  }

  static void runMartingale(Table table, RouletteGame game){
    Simulator sim = new Simulator(new Martingale(table, 500, 500), game, 500, 500, 20);
    sim.gather();
    System.out.println(String.format("Maxima\n%s\nMean: %f\nStandard Deviattion: %f\n\n" +
                    "Durations\n%s\nMean: %f\nStandard Deviattion: %f\n\n",
            sim.maxima.toString(), IntegerStatistics.mean(sim.maxima),
            IntegerStatistics.stdev(sim.maxima), sim.durations.toString(), IntegerStatistics.mean(sim.durations),
            IntegerStatistics.stdev(sim.durations)));
  }
}
