package rng;

import java.util.ArrayList;
import java.util.Random;

public class Muller extends numSequence {
    public Muller(int size, double q, double m){
        ArrayList<Double> list = new ArrayList<>(size);
        Random r = new Random();
        for (int i = 0; i < size; i++){
            double r1 = r.nextDouble();
            double r2 = r.nextDouble();
            double z = q * Math.sqrt(-2 * Math.log(r1)) * Math.cos(2*Math.PI*r2) + m;
            list.add(z);
        }
        setList(list);
    }
}
