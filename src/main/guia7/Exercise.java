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
        double[] original = new double[coefficients.length];
        // Bubble sorting keeping track of changes with original
        for (int k = 0; k < coefficients.length; k++) {
            for (int i = k; i < coefficients.length; i++)
                for (int j = i; j < coefficients.length - 1; j++) {
                    if (coefficients[k][j] < coefficients[k][j + 1]) {
                        swapRows(coefficients, j, j + 1);
                        swap(independentTerms, j, j + 1);
                        swap(original, j, j + 1);
                    }
                }
        }
        return exercise5WithoutPivoteo(coefficients, independentTerms);
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
        return new double[0];
    }

    private void swap(double[] vector, int index1, int index2){
        double aux = vector[index1];
        vector[index1] = vector[index2];
        vector[index2] = aux;
    }

    private void swapColumns(double[][] coefficients, int column1, int column2){
        double[] aux = coefficients[column1];
        coefficients[column1] = coefficients[column2];
        coefficients[column2] = aux;
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
        double[][] coefficients = {{1, 2, 1},{2, 3, 1},{3, 2, 2}};
        double[] victor = {6, 6, 3};
        print2(a.exercise8(coefficients));
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
