package Files;

import java.util.Vector;

/**
 * Created by Padraig on 24/10/2016.
 */
public class BinBuilder {
    public BinBuilder(){

    }

    public void buildBins(Wheel wheel){
        generateBins(wheel);
        generateStraightBets(wheel);
        generateSplitBets(wheel);
        generateStreetBets(wheel);
        generateCornerBets(wheel);
    }

    private void generateBins(Wheel wheel){
        Vector<Bin> bins = wheel.getAll();
        for (int i = 0; i <= 37; i++){
            bins.add(i, new Bin());
        }
    }


    private void generateStraightBets(Wheel wheel){
        int odds = RouletteGame.StraightBet;
        for(int i = 0; i <= 36; i++){
            Outcome straightBet = new Outcome("Number "+i, odds);
            wheel.addOutcome(i, straightBet);
        }
        wheel.addOutcome(37, new Outcome("Number 00", odds));

    }

    private void generateSplitBets(Wheel wheel){
        int odds = RouletteGame.SplitBet;
        int num1;
        int num2;

        for(num1 = 1; num1 < 36; num1++){
            if(num1 % 3 == 0){
                continue;
            }
            num2 = num1 + 1;

            if(validSplitBet(num1,num2)){
                Outcome splitBet = new Outcome(
                        "Split Bet " + num1 + " - " + num2, odds);
                wheel.addOutcome(num1, splitBet);
                wheel.addOutcome(num2, splitBet);
            }
        }

        for(num1 = 1; num1 < 34; num1++){
            num2 = num1 + 3;

            if(validSplitBet(num1,num2)){
                Outcome splitBet = new Outcome(
                        "Split Bet " + num1 + " - " + num2, odds);
                wheel.addOutcome(num1, splitBet);
                wheel.addOutcome(num2, splitBet);
            }
        }

    }

    private void generateStreetBets(Wheel wheel){
        int odds = RouletteGame.StreetBet;
        int num1, num2, num3;

        for(int i = 0; i < 12; i++){
            num1 = 1 + i * 3;
            num2 = num1 + 1;
            num3 = num1 + 2;

            String betName = String.format(
                    "Street Bet %d - %d - %d", num1,num2,num3
            );
            Outcome streetBet = new Outcome(betName, odds);
            wheel.addOutcome(num1,streetBet);
            wheel.addOutcome(num2,streetBet);
            wheel.addOutcome(num3,streetBet);

        }

    }

    private void generateCornerBets(Wheel wheel){
        int num1, num2, num3, num4;
        int odds = RouletteGame.CornerBet;
        for (int j = 1; j<=2; j++){
            for (int i = 0; i < 11; i++) {
                num1 = i * 3 + j;
                num2 = num1 + 1;
                num3 = num1 + 3;
                num4 = num1 + 4;

                String betName = String.format(
                        "Corner Bet %d - %d - %d - %d",
                        num1, num2, num3, num4
                );
                Outcome outcome = new Outcome(betName, odds);
                wheel.addOutcome(num1, outcome);
                wheel.addOutcome(num2, outcome);
                wheel.addOutcome(num3, outcome);
                wheel.addOutcome(num4, outcome);
            }
        }
    }

    private boolean validSplitBet(int num1, int num2){
        if(Math.abs(num1 - num2) != 1 && Math.abs(num1 - num2) != 3){
            System.out.print("Not a split bet");
            return false;
        }
        if(num1 >36 || num1 < 0 || num2 > 36 || num2 < 0){
            System.out.print("Number out of range");
            return false;
        }

        return true;
    }

}
