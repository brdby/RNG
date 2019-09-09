package rng;

import java.util.ArrayList;
import java.util.Random;

public class LCG extends numSequence{
    public final int M;
    public final int A;
    public final int C;
    public final int X0;

    public LCG(int size){
        ArrayList<Double> lcg = new ArrayList<>(size);

        Random r = new Random();
        M = r.nextInt((100 - 2) + 1) + 2;
        A = r.nextInt(M + 1);
        C = r.nextInt(M + 1);
        X0 = r.nextInt(M + 1);

        lcg.add((double) X0);
        for (int i = 1; i < size; i++){
            lcg.add((A*lcg.get(i-1)+ C)%M);
        }
        setList(lcg);
    }
}
