package Files;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by kobold1 on 28/10/2016.
 */
public class Table {
  private int minimumBet;
  private int limit;
  private int maxRatio = 50;
  Collection<Bet> bets;
  Wheel wheel;


  Table(Wheel inWheel){
    minimumBet = 1;
    limit = getLimit(minimumBet);
    bets = new LinkedList<>();
    wheel = inWheel;
  }

  Table(Wheel inWheel, int minimumBetT){
    bets = new LinkedList<>();
    minimumBet = minimumBetT;
    limit = getLimit(minimumBet);
    wheel = inWheel;
  }

  int getLimit(int minimum){
    return minimum * maxRatio;
  }

  public void placeBet(Bet bet) throws InvalidBet{
    if(isValid(bet)) {
      bets.add(bet);
    }
  }

  public void removeAllBets(){
    bets.clear();
  }

  public void removeBet(Bet bet){
    bets.remove(bet);
  }

  public boolean isValid(Bet checkBet) throws InvalidBet{
    if (betsPlacedTotal() + checkBet.loseAmount() > limit){
      throw new InvalidBet();
    }
    return true;
  }

  public int betsPlacedTotal(){
    int totalBets = 0;
    for (Bet b: bets
            ) {
      totalBets += b.loseAmount();
    }
    return totalBets;
  }

  public Iterator iterator(){
    return bets.iterator();
  }

  public String toString(){
    String returnString = "Bet List:\n";
    for (Bet b: bets){
      returnString = returnString + b.toString() + '\n';
    }
    return returnString;
  }
}

class InvalidBet extends Exception{}