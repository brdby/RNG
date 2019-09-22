import rng.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Табличный метод");
        tableRNG ud = new tableRNG("UD.txt");
        ud.output();

        System.out.println("Линейный конгруэнтный метод");
        LCG lcg = new LCG(100);
        System.out.println("M - " + lcg.M + " A - " + lcg.A + " C - " + lcg.C + " X0 - " + lcg.X0);
        lcg.output();

        System.out.println("Метод Неймана");
        Neumann nu = new Neumann(100, 1, 10, 10);
        nu.output();


        System.out.println("Центральная предельная теорема");
        Gauss ga = new Gauss(100, 12, 10, 5);
        ga.output();

        System.out.println("Метод Мюллера");
        Muller mu = new Muller(100, 10, 5);
        mu.output();

    }
}
