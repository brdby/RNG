package rng;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class tableRNG extends numSequence {

    public tableRNG(String file){
        ArrayList<Double> ud = new ArrayList<>();
        try(FileReader reader = new FileReader(file))
        {
            // читаем посимвольно
            int i = 0;
            int c;
            String cont = "0.";
            while((c=reader.read())!=-1){
                if (!(c < 48 || c > 57)) {
                    i++;
                    cont += (char) c;
                    if (i == 3){
                        ud.add(Double.valueOf(cont));
                        cont = "0.";
                        i = 0;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        setList(ud);
    }
}
