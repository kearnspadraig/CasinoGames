package Files;

import java.util.Vector;

/**
 * Created by Padraig on 24/10/2016.
 */
class BinBuilder {
    BinBuilder(){

    }

    void buildBins(Wheel wheel){
        generateBins(wheel);
        generateStraightBets(wheel);
        generateSplitBets(wheel);
        generateStreetBets(wheel);
        generateCornerBets(wheel);
        generateLineBets(wheel);
        generateDozenBets(wheel);
        generateColumnBets(wheel);
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

    private void generateLineBets(Wheel wheel){
        int num1,num2,num3,num4,num5,num6;
        int odds = RouletteGame.LineBet;
        for (int i = 0; i <= 10; i++){
            num1 = i * 3 + 1;
            num2 = num1 + 1;
            num3 = num1 + 2;
            num4 = num1 + 3;
            num5 = num1 + 4;
            num6 = num1 + 5;

            String betName = String.format(
                    "Line Bet %d - %d - %d - %d - %d - %d ",
                    num1,num2,num3,num4,num5,num6
            );
            Outcome outcome = new Outcome(betName, odds);
            for (int j = num1; j <num1+6; j++)
                wheel.addOutcome(j, outcome);

        }
    }

    private void generateDozenBets(Wheel wheel){
        int num1;
        int odds = RouletteGame.DozenBet;

        for (int i = 0; i < 3; i++){
            num1 = 12 * i + 1;
            String betname = String.format(
                    "Dozen Bet %d-%d",
                    num1, num1 + 11);
            Outcome outcome = new Outcome(betname, odds);
            for (int j = num1; j < num1+12; j++){
                wheel.addOutcome(j, outcome);
            }
        }
    }

    private void generateColumnBets(Wheel wheel){
        int odds = RouletteGame.ColumnBet;
        for (int i = 0; i < 3; i++){
            String betName = String.format("Column Bet %d", i+1);
            Outcome outcome = new Outcome(betName,odds);
            for (int j = 0; j<12; j++){
                int binNum = j * 3 + 1 + i;
                wheel.addOutcome(binNum, outcome);
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
