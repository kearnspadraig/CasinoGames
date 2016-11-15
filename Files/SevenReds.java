package Files;

import java.util.Set;

/**
 * Created by kobold1 on 08/11/2016.
 */
public class SevenReds extends Martingale {
  int redCount = 7;

  public SevenReds(){
    super();
  }

  public SevenReds(Table inTable, int inStake){
    super(inTable, inStake);
  }

  public SevenReds(Table inTable, int inStake, int inRoundsToGo){
    super(inTable, inStake, inRoundsToGo);
  }

  public void placeBets(){
    if (redCount == 0){
      super.placeBets();
    }
  }

  public void winners(Set<Outcome> winners){
    if (winners.contains(table.wheel.getOutcome("Red Bet"))) {
      redCount--;
    }else{
      redCount = 7;
    }
  }

}
