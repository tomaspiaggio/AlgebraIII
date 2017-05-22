package main.guia6;

import main.guia6.interfaces.Calculator;
import main.guia6.interfaces.Exercise1;

/**
 * Created by matiasvenditti on 5/15/17.
 */
public class ExerciseOne implements Exercise1 {
    @Override
    public double exerciseA(double[][] matrix, Calculator calculator) {
        double sum = 0;
        for (int i = 0; i < matrix.length; i++){
            sum = calculator.sum(sum, matrix[i][i]);
        }
        return sum;
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
        for (int i = 0; i < matrix.length; i++) {
            double sum = 0;
            for (int j = 0; j < matrix[i].length; j++)
                sum = calculator.sum(sum, calculator.multiplication(matrix[j][i], vector[j]));
            result[i] = sum;
        }
        return result;


    }

    @Override
    public double[][] exerciseE(double[][] matrixA, double[][] matrixB, Calculator calculator) {
        if (matrixA.length == matrixB.length && matrixA[0].length == matrixB[0].length){
            double[][] result = new double[matrixA.length][matrixA[0].length];
            for (int i = 0; i < matrixA.length; i++) {
                for (int j = 0; j < matrixA[i].length; j++) {
                    result[i][j] = calculator.sum(matrixA[i][j], matrixB[i][j]);
                }
            }
            return result;
        }
        else{
            throw new RuntimeException("Cannot complete operation with the given values");
        }
    }


    @Override
    public double[][] exerciseF(double[][] matrixA, double[][] matrixB, Calculator calculator) {
        if (matrixA[0].length == matrixB.length){
            double[][] result = new double[matrixA.length][matrixA.length];
            for (int i = 0; i < matrixA.length; i++)
                for (int j = 0; j < matrixA[i].length; j++){
                    double sum = 0;
                    for (int k = 0; k < matrixA.length; k++)
                        sum = calculator.sum(sum, calculator.multiplication(matrixA[k][i], matrixB[j][k]));
                    result[j][i] = sum;
                }
            return result;
        }
        else{
            throw new RuntimeException("Cannot multiply.");
        }
    }

    @Override
    public double[][] exerciseG(double[][] matrix, Calculator calculator) {
        double[][] result = new double[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++) {
                result[i][j] = matrix[j][i];
            }
        }
        return result;
    }


    public void print(double[] a){
        for (int i = 0; i < a.length; i++) {
            System.out.println("[" + a[i] + "]");
        }
    }
}
