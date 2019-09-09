package rng;

import java.util.ArrayList;
import java.util.Random;

public class Neumann extends numSequence {
    private double a;
    private double b;

    public Neumann(int size, double a, double b, double m0){
        this.a = a;
        this.b = b;

        ArrayList<Double> list = new ArrayList<>(size);
        double m = (a+b)/2;
        double c = (12+Math.pow(b-a, 3))/12*(b-a);
        for (int i = 0; i < size; i++){
            Random r =  new Random();
            double beta, alf, f;
            do {
                beta = r.nextDouble() * m0;
                alf = a + r.nextDouble()*(b-a);
                f = c - (alf - m)*(alf-m);
            }while (beta >= f);
            list.add(alf);
        }
        setList(list);
    }

    public void compare(){
        System.out.println("----Сравнить----");
        System.out.println("");
    }
}
