package rng;

import java.math.BigDecimal;
import java.util.ArrayList;

public abstract class numSequence {
    private ArrayList<Double> list;

    private Double sampleMeanVar;
    private Double sampleVarianceVar;
    private Double sampleRefinedVarianceVar;
    private Double sampleStandardDeviationVar;

    public double sampleMean(){
        if (sampleMeanVar == null){
            double result = list.stream().mapToDouble(el -> el).sum();
            result = result/list.size();
            sampleMeanVar = result;
            return result;
        }
        else return sampleMeanVar;
    }

    public double sampleVariance(){
        if (sampleVarianceVar == null){
            double result = list.stream().mapToDouble(el -> el*el).sum();
            double mean = sampleMean();
            result = (result/list.size()) - mean*mean;
            sampleVarianceVar = result;
            return result;
        }
        else return sampleVarianceVar;
    }

    public double sampleRefinedVariance() {
        if (sampleRefinedVarianceVar == null){
            Double var = sampleVariance();
            double result = (list.size()/(list.size()-1))*var;
            sampleRefinedVarianceVar = result;
            return result;
        }
        else return sampleRefinedVarianceVar;
    }

    public double sampleStandardDeviation(){
        if (sampleStandardDeviationVar == null){
            Double result = Math.sqrt(sampleRefinedVariance());
            sampleStandardDeviationVar = result;
            return result;
        }
        else return sampleStandardDeviationVar;
    }


    public void setList(ArrayList<Double> list) {
        this.list = list;
    }


    @Override
    public String toString() {
        return list.toString();
    }

    public void output(){
        System.out.println("Последовательность - \n" + toString());
        System.out.println("Среднее выборочное - " + sampleMean());
        System.out.println("Выборочная дисперсия - " + sampleVariance());
        System.out.println("Смещенная выборочная дисперсия - " + sampleRefinedVariance());
        System.out.println("Выборочное среднеквадратическое отклонение - "  + sampleStandardDeviation());
        System.out.println("---------------------------------------\n");
    }
}
