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
                sum += coefficients[i][j] * result[j];
            result[i] = independentTerms[i] - sum;
        }
        return result;
    }

    @Override
    public double[] exercise2(double[][] coefficients, double[] independentTerms) {
        for (int k = 0; k < coefficients.length; k++){
            double pivot = coefficients[k][k];
            independentTerms[k] /= pivot;
            for (int i = 0; i < coefficients.length; i++){
                coefficients[k][i] /= pivot;
            }
        }
        return resolve(coefficients, independentTerms);
    }

    @Override
    public double[] exercise5WithoutPivoteo(double[][] coefficients, double[] independentTerms) {
        double copy[][] = new double[coefficients.length][coefficients.length];
        double independentCopy[] = new double[independentTerms.length];
        copy(coefficients, copy);
        copy(independentTerms, independentCopy);
        for (int k = 0; k < coefficients.length - 1; k++) {
            double value = copy[k][k];
            for (int i = k + 1; i < coefficients.length; i++) {
                int j = 0;
                while (copy[j][i] == 0) j++;
                double mult = copy[i][k]/value;
                while (j < coefficients[i].length) {
                    copy[i][j] -= copy[k][j] * mult;
                    j++;
                }
                independentCopy[i] -= independentCopy[k] * mult;
                value = copy[k][k];
            }
        }
        return resolve(copy, independentCopy);
    }

    @Override
    public double[] exercise5PartialPivoteo(double[][] coefficients, double[] independentTerms) {
        for (int k = 0; k < coefficients.length -1; k++) {
            int max = getMaxIndex(coefficients, k);
            swapRows(coefficients, k, max);
            swap(independentTerms, k, max);
            double pivot = coefficients[k][k];
            for (int i = k + 1; i < coefficients.length; i++) {
                int j = 0;
                while (coefficients[i][j] == 0) j++;
                double mult = coefficients[i][k]/pivot;
                while (j < coefficients[i].length) {
                    coefficients[i][j] -= coefficients[k][j] * mult;
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
                coefficients[k][i] = calculator.division(coefficients[k][i], pivot);
            independentTerms[k] = calculator.division(independentTerms[k], pivot);
            double value = coefficients[k+1][k];
            for (int j = k; j < coefficients.length; j++){
                double multiplication = calculator.multiplication(coefficients[k][j], value);
                coefficients[k+1][j] = calculator.subtraction(coefficients[k+1][j], multiplication);
            }
            independentTerms[k+1] = calculator.subtraction(independentTerms[k+1],calculator.multiplication(independentTerms[k], value));
        }
        return exercise1(coefficients, independentTerms);
    }

    @Override
    public double[] exercise7(double[][] coefficients, double[] independentTerms, Calculator calculator) {
        for (int i = 0; i < coefficients.length-1; i++){
            double pivot = coefficients[i][i];
            independentTerms[i] = calculator.division(independentTerms[i], pivot);
            if (i == 0){
                coefficients[0][0] = calculator.division(coefficients[0][0], pivot);
                coefficients[0][1] = calculator.division(coefficients[0][1], pivot);
            }
            else{
                for (int m = i-1; m < i+2; m++){
                    coefficients[i][m] = calculator.division(coefficients[i][m], pivot);
                }
            }
            double value = coefficients[i+1][i];
            for (int j = 0; j < coefficients.length; j++){
                coefficients[i+1][j] = calculator.subtraction(coefficients[i+1][j], calculator.multiplication(coefficients[i][j], value));
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
//        double[][] identity = new double[coefficients.length][coefficients.length];
//        double[][] result = new double[coefficients.length][coefficients.length];
//        double[][] copy = new double[coefficients.length][coefficients.length];
//
//        // Because of pointer problem. When passed coefficients one time to exercise5WithoutPivoteo, then the next time it will spit out wrong values
//        copy(coefficients, copy);
//
//        for (int i = 0; i < coefficients.length; i++)
//            identity[i][i] = 1;
//        for (int i = 0; i < coefficients.length; i++) {
//            result[i] = exercise5WithoutPivoteo(coefficients.clone(), identity[i]);
//            copy(copy, coefficients);
//        }
//        return result;
        double[][] identity = new double[coefficients.length][coefficients.length];
        for(int i = 0; i < identity.length; i++){
            identity[i][i] = 1;
        }
        double[][] copy = new double[coefficients.length][coefficients.length];
        copy(coefficients, copy);
        for (int k = 0; k < coefficients.length; k++){
            if (copy[k][k] == 0){
                int max = getMaxIndex(copy, k);
                swapRows(copy, k, max);
                swapRows(identity, k, max);
            }
            double pivot = copy[k][k];

            for (int j = 0; j < copy.length; j++){
                copy[k][j] /= pivot;
                identity[k][j] /= pivot;
            }
            for (int i = 0; i < copy.length; i++){
                if (i != k){
                    double value = copy[i][k];
                    for (int j = 0; j < copy.length; j++){
                        copy[i][j] -= copy[k][j]*value;
                        identity[i][j] -= identity[k][j]*value;
                    }
                }
            }

        }
        return identity;
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
        independentTerms = matrixMultiplication(matrixU, independentTerms);
        return invertedSolve(matrixL, independentTerms);
    }


    private void swapRows(double[][] coefficients, int row1, int row2){
        double aux;
        for (int i = 0; i < coefficients.length; i++) {
            aux = coefficients[row1][i];
            coefficients[row1][i] = coefficients[row2][i];
            coefficients[row2][i] = aux;
        }
    }

    private void copy(double[][] from, double[][] to){
        for (int i = 0; i < from.length; i++)
            for (int j = 0; j < from[i].length; j++)
                to[i][j] = from[i][j];
    }

    private void copy(double[] from, double[] to){
        for(int i = 0; i < from.length; i++)
            to[i] = from[i];
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
                sum += coefficients[i][j] * result[j];
            result[i] = (independentTerms[i] - sum) / coefficients[i][i];
        }
        return result;
    }

    public double[] invertedSolve(double[][] matrix, double[] independentTerms) {
        double result[] = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            double sum = 0;
            for (int j = 0; j < i; j++)
                sum += matrix[j][i] * result[j];
            result[i] = independentTerms[i] - sum;
        }
        return result;
    }

    private double[] matrixMultiplication(double[][] matrix, double[] vector) {
        double[] result = new double[vector.length];
        for (int i = 0; i < matrix.length; i++) {
            double sum = 0;
            for (int j = 0; j < matrix[i].length; j++)
                sum += matrix[j][i] * vector[j];
            result[i] = sum;
        }
        return result;
    }


    /**
     * PARA BORRAR ANTES DE ENTREGAR
     *
     *
     */

    public static void main(String[] args) {
        final Exercise a = new Exercise();
        double[][] coefficients = {{1,2,3}, {2,2,2}, {3,6,1}};
        double[] independentTerms = {1,2,3};
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

        System.out.println("Exercise 1\n");
        double e1[][] = {{1,3,2}, {0,1,4}, {0,0,1}};
        double ind1[] = {4,3,2};
        print(a.exercise1(e1, ind1));
        System.out.println("");

        System.out.println("\nExercise 2\n");
        double e2[][] = {{2,4,1}, {0,3,5}, {0,0,4}};
        double ind2[] = {1,6,5};
        print(a.exercise2(e2, ind2));
        System.out.println("");

        System.out.println("\nExercise 5 without pivot\n");
        double e5[][] = {{1,2,3}, {2,2,2}, {3,6,1}};
        double ind5[] = {1,2,3};
        print(a.exercise5WithoutPivoteo(e5, ind5));
        System.out.println("");

        System.out.println("\nExercise 5 partial pivot\n");
        print(a.exercise5PartialPivoteo(e5, ind5));
        System.out.println("");

        System.out.println("\nExercise 6\n");
        double e6[][] = {{1,7,4,5}, {6,2,4,2}, {0,1,3,1}, {0,0,2,4}};
        double ind6[] = {4,3,2,1};
        print(a.exercise6(e6, ind6, calculator));
        System.out.println("");

        System.out.println("\nExercise 7\n");
        double e7[][] = {{1,6,0,0}, {6,2,7,0}, {0,7,3,8}, {0,0,8,4}};
        double ind7[] = {1,2,3,4};
        print(a.exercise7(e7, ind7, calculator));
        System.out.println("");

        System.out.println("\nExercise 8\n");
        double e8[][] = {{1,4,3}, {2,8,1}, {2,2,2}};
        print(a.exercise8(e8));
        System.out.println("");

        System.out.println("\nExercise 9\n");




    }

    private static void print(double[][] victor, double independentTerms[]){
        for (int i = 0; i < victor.length; i++) {
            for (int j = 0; j < victor.length; j++)
                System.out.print("[" + victor[j][i] + "]");
            System.out.print("[" + independentTerms[i] + "]\n");
        }
    }

    private static void print(double[] victor){
        for (int i = 0; i < victor.length; i++)
            System.out.print("[" + victor[i] + "]");
    }

    private static void print(double[][] victor){
        for (int i = 0; i < victor.length; i++) {
            for (int j = 0; j < victor[i].length; j++)
                System.out.print("[" + victor[i][j] + "]");
            System.out.println();
        }
    }
}
