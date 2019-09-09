package rng;

import java.util.ArrayList;
import java.util.Random;

public class Gauss extends numSequence{
    public Gauss(int size, double n, double q, double m){
        ArrayList<Double> list = new ArrayList<>(size);
        Random r = new Random();
        for (int i = 0; i < size; i++){
            double sum = 0;
            for (int j = 0; j < n; j++){
                sum += r.nextDouble();
            }
            double z = (sum - n/2)/Math.sqrt(n/12);
            double x = z*q + m;
            list.add(x);
        }
        setList(list);
    }
}
