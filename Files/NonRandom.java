package Files;

import java.util.Random;

/**
 * Created by Padraig on 21/10/2016.
 */
public class NonRandom extends Random {
    private int current = 0;
    private int max;

    NonRandom(){
        current = 0;
        max = 37;
    }

    public NonRandom(int tmax){
        max = tmax;
    }

    public NonRandom(int tmax, int start){
        current = start;
        max = tmax;
    }

    int next(){
        if( current > max){
            current = 0;
        }
        int temp = current;
        current++;
        return temp;
    }

    public int nextInt(int newMax){
        max = newMax -1;
        return this.next();
    }
}
