package main.guia6;

import main.guia6.interfaces.Calculator;
import main.guia6.interfaces.Exercise1;

/**
 * Created by matiasvenditti on 5/15/17.
 */
public class ExerciseOne implements Exercise1 {
    @Override
    public double exerciseA(double[][] matrix, Calculator calculator) {
        double result = matrix[0][0];
        for (int i = 1; i < matrix.length; i++){
            result = calculator.sum(result, matrix[i][i]);
        }
        return result;
    }

    /*
        Arreglar.
     */
    @Override
    public double exerciseB(double[][] matrix, Calculator calculator) {
        double result = matrix[matrix.length-1][0];
        for(int i = matrix.length-1; i >= 0; i--){
            result = calculator.sum(result, matrix[i][(matrix.length )-i ]);
        }
        return result;
    }

    @Override
    public double[] exerciseC(double[][] matrix, Calculator calculator) {
        double[] result = new double[matrix[0].length];
        for (int j = 0; j < matrix.length; j++){
            for (int i = 0; i < matrix[j].length; i++) {
                result[i] = calculator.sum(result[i], matrix[j][i]);
            }
        }
        return result;
    }

    @Override
    public double[] exerciseD(double[][] matrix, double[] vector, Calculator calculator) {
        double[] result = new double[vector.length];
        for(int j = 0; j < matrix.length; j++){
            for (int i = 0; i < matrix[j].length; i++) {
                result[i] = calculator.sum(result[i], calculator.multiplication(matrix[j][i], vector[i]));
            }
        }
        return result;
    }

    @Override
    public double[][] exerciseE(double[][] matrixA, double[][] matrixB, Calculator calculator) {
        return new double[0][];
    }

    @Override
    public double[][] exerciseF(double[][] matrixA, double[][] matrixB, Calculator calculator) {
        return new double[0][];
    }

    @Override
    public double[][] exerciseG(double[][] matrix, Calculator calculator) {
        return new double[0][];
    }

    public void print(double[] a){
        for (int i = 0; i < a.length; i++) {
            System.out.println("[" + a[i] + "]");
        }
    }
}
