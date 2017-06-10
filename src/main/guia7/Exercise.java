package main.guia7;

import main.guia7.interfaces.Calculator;
import main.guia7.interfaces.TP4;

/**
 * Created by Tomas on 5/23/17.
 */
public class Exercise implements TP4 {

    @Override
    public double[] exercise1(double[][] coefficients, double[] independentTerms) {
        double result[] = new double[coefficients.length];
        for (int i = coefficients.length - 1; i >= 0; i--) {
            double sum = 0;
            for (int j = i; j < coefficients.length; j++)
                sum += coefficients[j][i] * result[j];
            result[i] = independentTerms[i] - sum;
        }
        return result;
    }

    @Override
    public double[] exercise2(double[][] coefficients, double[] independentTerms) {
        double result[] = new double[coefficients.length];
        for (int i = 0; i < coefficients.length; i++) {
            double sum = 0;
            for (int j = 0; j <= i; j++)
                sum += coefficients[j][i] * result[j];
            result[i] = (independentTerms[i] - sum)/coefficients[i][i];
        }
        return result;
    }

    @Override
    public double[] exercise5WithoutPivoteo(double[][] coefficients, double[] independentTerms) {
        for (int k = 0; k < coefficients.length - 1; k++) {
            double value = coefficients[k][k];
            for (int i = k + 1; i < coefficients.length; i++) {
                int j = 0;
                while (coefficients[i][j] == 0) j++;
                double mult = coefficients[k][i]/value;
                while (j < coefficients[i].length) {
                    coefficients[j][i] -= coefficients[j][k] * mult;
                    j++;
                }
                independentTerms[i] -= independentTerms[k] * mult;
                value = coefficients[k][k];
            }
        }
        print(coefficients, independentTerms);
        return exercise2(coefficients, independentTerms);
    }

    @Override
    public double[] exercise5PartialPivoteo(double[][] coefficients, double[] independentTerms) {
        return new double[0];
    }

    @Override
    public double[] exercise6(double[][] coefficients, double[] independentTerms, Calculator calculator) {
        return new double[0];
    }

    @Override
    public double[] exercise7(double[][] coefficients, double[] independentTerms, Calculator calculator) {
        return new double[0];
    }

    @Override
    public double[][] exercise8(double[][] coefficients) {
        return new double[0][];
    }

    @Override
    public double[] exercise9(double[][] coefficients, double[] independentTerms) {
        return new double[0];
    }

    public static void main(String[] args) {
        Exercise a = new Exercise();
        double[][] coefficients = {{1, 2, 1},{2, 3, 1},{3, 2, 2}};
        double[] victor = {6, 6, 3};
//        print(a.exercise5WithoutPivoteo(coefficients, victor));
        a.exercise5WithoutPivoteo(coefficients, victor);
    }

    private static void print(double[][] victor, double independentTerms[]){
        for (int i = 0; i < victor.length; i++) {
            for (int j = 0; j < victor.length; j++)
                System.out.print("[" + victor[j][i] + "]");
            System.out.print("[" + independentTerms[i] + "]\n");
        }
    }
}
