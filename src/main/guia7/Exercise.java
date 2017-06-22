package main.guia7;

import main.guia7.interfaces.Calculator;
import main.guia7.interfaces.TP4;
import sun.java2d.xr.MutableInteger;

import java.util.ArrayList;
import java.util.List;

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
        return resolve(coefficients, independentTerms);
    }

    @Override
    public double[] exercise5PartialPivoteo(double[][] coefficients, double[] independentTerms) {
        for (int k = 0; k < coefficients.length -1; k++) {
            double pivot = coefficients[k][k];
            int max = getMaxIndex(coefficients, k);
            swapRows(coefficients, k, max);
            swap(independentTerms, k, max);
            for (int i = k + 1; i < coefficients.length; i++) {
                int j = 0;
                while (coefficients[i][j] == 0) j++;
                double mult = coefficients[k][i]/pivot;
                while (j < coefficients[i].length) {
                    coefficients[j][i] -= coefficients[j][k] * mult;
                    j++;
                }
                independentTerms[i] -= independentTerms[k] * mult;
                pivot = coefficients[k][k];
            }
        }
        return resolve(coefficients, independentTerms);


    }


    public double[] exercise6(double[][] coefficients, double[] independentTerms, Calculator calculator) {
        for (int k = 0; k < coefficients.length-1; k++){
            double pivot = coefficients[k][k];
            for (int i = k; i < coefficients.length; i++)
                coefficients[i][k] = calculator.division(coefficients[i][k], pivot);
            independentTerms[k] = calculator.division(independentTerms[k], pivot);
            double value = coefficients[k][k+1];
            for (int j = k; j < coefficients.length; j++){
                double multiplication = calculator.multiplication(coefficients[j][k], value);
                coefficients[j][k+1] = calculator.subtraction(coefficients[j][k+1], multiplication);
            }
            independentTerms[k+1] = calculator.subtraction(independentTerms[k+1],calculator.multiplication(independentTerms[k], value));
        }
        print2(coefficients);
        return resolve(coefficients, independentTerms);
    }

    @Override
    public double[] exercise7(double[][] coefficients, double[] independentTerms, Calculator calculator) {
        for (int i = 0; i < coefficients.length-1; i++){
            double pivot = coefficients[i][i];
            independentTerms[i] = calculator.division(independentTerms[i], pivot);
            if (i == 0){
                coefficients[0][0] = calculator.division(coefficients[0][0], pivot);
                coefficients[1][0] = calculator.division(coefficients[1][0], pivot);
            }
            else{
                for (int m = i-1; m < i+2; m++){
                    coefficients[m][i] = calculator.division(coefficients[m][i], pivot);
                }
            }
            double value = coefficients[i][i+1];
            for (int j = 0; j < coefficients.length; j++){
                coefficients[j][i+1] = calculator.subtraction(coefficients[j][i+1], calculator.multiplication(coefficients[j][i], value));
            }
            independentTerms[i+1] = calculator.subtraction(independentTerms[i+1], calculator.multiplication(independentTerms[i], value));
        }
        calculator.division(coefficients[coefficients.length-2][coefficients.length-1], coefficients[coefficients.length-1][coefficients.length-1]);
        calculator.division(coefficients[coefficients.length-1][coefficients.length-1], coefficients[coefficients.length-1][coefficients.length-1]);
        calculator.division(independentTerms[coefficients.length-1], coefficients[coefficients.length-1][coefficients.length-1]);

        return resolve(coefficients, independentTerms);
    }

    @Override
    public double[][] exercise8(double[][] coefficients) {
        double[][] identity = new double[coefficients.length][coefficients.length];
        double[][] result = new double[coefficients.length][coefficients.length];
        double[][] copy = new double[coefficients.length][coefficients.length];

        // Because of pointer problem. When passed coefficients one time to exercise5WithoutPivoteo, then the next time it will spit out wrong values
        copy(coefficients, copy);

        for (int i = 0; i < coefficients.length; i++)
            identity[i][i] = 1;
        for (int i = 0; i < coefficients.length; i++) {
            result[i] = exercise5WithoutPivoteo(coefficients.clone(), identity[i]);
            copy(copy, coefficients);
        }
        return result;
    }

    @Override
    public double[] exercise9(double[][] coefficients, double[] independentTerms) {
        double[][] matrixL = new double[coefficients.length][coefficients.length];
        double[][] matrixU = new double[coefficients.length][coefficients.length];
        for (int k = 0; k < coefficients.length; k++){
            for (int j = 0; j < coefficients.length; j++) {
                double sum1 = 0;
                for (int p = 0; p < k; p++) {
                    sum1 += matrixL[p][k] * matrixU[j][p];
                }
                matrixU[j][k] = coefficients[j][k] - sum1;
                double sum2 = 0;
                for (int p = 0; p < k; p++){
                    sum2 += matrixL[p][j] * matrixU[k][p];
                }
                matrixL[k][j] = (matrixU[k][k] == 0) ? 0 : ((coefficients[k][j] - sum2)/matrixU[k][k]);
            }
        }
        return new double[0];
    }


    private void swapRows(double[][] coefficients, int row1, int row2){
        double aux;
        for (int i = 0; i < coefficients.length; i++) {
            aux = coefficients[i][row1];
            coefficients[i][row1] = coefficients[i][row2];
            coefficients[i][row2] = aux;
        }
    }

    private void copy(double[][] from, double[][] to){
        for (int i = 0; i < from.length; i++)
            for (int j = 0; j < from[i].length; j++)
                to[i][j] = from[i][j];
    }

    private int getMaxIndex(double[][] coefficients, int column){
        int value = 0;
        for (int i = column; i < coefficients.length; i++){
            if (Math.abs(coefficients[column][i]) > Math.abs(coefficients[column][value])){
                value = i;
            }
        }
        return value;
    }

    private void swap(double[] independentTerms, int i1, int i2){
        double aux = independentTerms[i1];
        independentTerms[i1] = independentTerms[i2];
        independentTerms[i2] = aux;
    }

    private double[] resolve(double[][] coefficients, double[] independentTerms){
        double[] result = new double[coefficients.length];
        for (int i = coefficients.length - 1; i >= 0; i--) {
            double sum = 0;
            for (int j = i; j < coefficients[i].length; j++)
                sum += coefficients[j][i] * result[j];
            result[i] = (independentTerms[i] - sum) / coefficients[i][i];
        }
        return result;
    }


    /**
     * PARA BORRAR ANTES DE ENTREGAR
     *
     *
     */

    public static void main(String[] args) {
        Exercise a = new Exercise();
        double[][] coefficients = {{1, 2, 1},
                                   {2, 3, 1},
                                   {3, 2, 2}};

        double[][] matrix = {{1,3,0,0},{4,4,2,0},{2,1,3,1},{3,7,4,3}};
        double[] vector = {1,-1,2,8};
        Calculator calculator = new Calculator() {
            @Override
            public double sum(double a, double b) {
                return a + b;
            }

            @Override
            public double subtraction(double a, double b) {
                return a - b;
            }

            @Override
            public double multiplication(double a, double b) {
                return a * b;
            }

            @Override
            public double division(double a, double b) {
                return a/b;
            }
        };

        double[][] newMatrix = {{1,2,3}, {2,3,4}, {3,4,5}};

        a.exercise9(newMatrix, vector);
//        print1(result);

        double[] victor = {6, 6, 3};
//        print2(a.exercise8(coefficients));
    }

    private static void print(double[][] victor, double independentTerms[]){
        for (int i = 0; i < victor.length; i++) {
            for (int j = 0; j < victor.length; j++)
                System.out.print("[" + victor[j][i] + "]");
            System.out.print("[" + independentTerms[i] + "]\n");
        }
    }

    private static void print1(double[] victor){
        for (int i = 0; i < victor.length; i++)
            System.out.print("[" + victor[i] + "]");
    }

    private static void print2(double[][] victor){
        for (int i = 0; i < victor.length; i++) {
            for (int j = 0; j < victor[i].length; j++)
                System.out.print("[" + victor[j][i] + "]");
            System.out.println();
        }
    }
}
