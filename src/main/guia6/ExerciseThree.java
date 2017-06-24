package main.guia6;

import main.guia6.interfaces.Calculator;
import main.guia6.interfaces.Exercise3;

import java.util.Arrays;

/**
 * Created by Tomas on 5/15/17.
 */
public class ExerciseThree implements Exercise3 {

    @Override
    public double[] exerciseAI(double[][] matrixA, double[] vectorX, Calculator calculator) {
        double[] result = new double[vectorX.length];
        for (int i = 0; i < matrixA.length; i++) {
            double sum = 0;
            for (int j = i; j < matrixA.length; j++)
                sum = calculator.sum(sum, calculator.multiplication(matrixA[i][j], vectorX[j]));
            result[i] = sum;
        }
        return result;
    }

    @Override
    public double[][] exerciseAII(double[][] matrixA, double[][] matrixB, Calculator calculator) {
        for (int i = 0; i < matrixA.length; i++)
            for (int j = i; j < matrixA.length; j++)
                matrixB[j][i] = calculator.sum(matrixB[i][j], matrixA[i][j]);
        return matrixB;
    }

    @Override
    public double[][] exerciseAIII(double[][] matrixA, double[][] matrixB, Calculator calculator) {
        double[][] result = new double[matrixA.length][matrixA.length];
        for (int i = 0; i < matrixA.length; i++)
            for (int j = i; j < matrixA.length; j++){
                double sum = 0;
                for (int k = 0; k < matrixA.length; k++)
                    sum = calculator.sum(sum, calculator.multiplication(matrixA[i][k], matrixB[k][j]));
                result[j][i] = sum;
            }
        return result;
    }

    @Override
    public double[] exerciseBI(double[][] matrixA, double[] vectorX, Calculator calculator) {
        double[] result = new double[vectorX.length];
        for (int i = 0; i < matrixA.length; i++) {
            double sum = 0;
            for (int j = (i == 0)? 0 : i - 1; j < matrixA[i].length; j++)
                sum = calculator.sum(sum, calculator.multiplication(matrixA[i][j], vectorX[j]));
            result[i] = sum;
        }
        return result;
    }

    @Override
    public double[][] exerciseBII(double[][] matrixA, double[][] matrixB, Calculator calculator) {
        for (int i = 0; i < matrixA.length; i++)
            for (int j = (i - 1 < 0)? 0 : i - 1; j < matrixA.length; j++)
                matrixB[i][j] = calculator.sum(matrixB[i][j], matrixA[i][j]);
        return matrixB;
    }

    @Override
    public double[][] exerciseBIII(double[][] matrixA, double[][] matrixB, Calculator calculator) {
        double[][] result = new double[matrixA.length][matrixA.length];
        for (int i = 0; i < matrixA.length; i++)
            for (int j = (i - 1 < 0)? 0 : i - 1; j < matrixA[i].length; j++){
                double sum = 0;
                for (int k = 0; k < matrixA.length; k++)
                    sum = calculator.sum(sum, calculator.multiplication(matrixA[i][k], matrixB[k][j]));
                result[i][j] = sum;
            }
        return result;
    }

    @Override
    public double[] exerciseCI(double[][] matrixA, double[] vectorX, Calculator calculator) {
        return exerciseDI(matrixA, 1, 1, vectorX, calculator);
    }

    @Override
    public double[][] exerciseCII(double[][] matrixA, double[][] matrixB, Calculator calculator) {
        return exerciseDII(matrixA, 1, 1, matrixB, 1, 1, calculator);
    }

    @Override
    public double[][] exerciseCIII(double[][] matrixA, double[][] matrixB, Calculator calculator) {
        return exerciseDIII(matrixA, 1, 1, matrixB, 1, 1, calculator);
    }

    @Override
    public double[] exerciseDI(double[][] matrixA, int k1A, int k2A, double[] vectorX, Calculator calculator) {
        double[] result = new double[vectorX.length];
        for (int i = 0; i < matrixA.length; i++) {
            int length = ((i - k1A) + k2A + 1 > matrixA[i].length - 1)? matrixA.length - 1 : (i - k1A) + k2A + 1;
            double sum = 0;
            for (int j = (i <= k1A)? 0 : i - k1A; j <= length; j++)
                sum = calculator.sum(sum, calculator.multiplication(matrixA[i][j], vectorX[j]));
            result[i] = sum;
        }
        return result;
    }

    @Override
    public double[][] exerciseDII(double[][] matrixA, int k1A, int k2A, double[][] matrixB, int k1B, int k2B, Calculator calculator) {
        for (int i = 0; i < matrixA.length; i++) {
            int length = ((i - k1A) + k2A + 1 > matrixA[i].length - 1)? matrixA.length - 1 : (i - k1A) + k2A + 1;
            for (int j = (i <= k1A)? 0 : i - k1A; j <= length; j++)
                matrixB[j][i] = calculator.sum(matrixB[i][j], matrixA[i][j]);
        }
        return matrixB;
    }

    @Override
    public double[][] exerciseDIII(double[][] matrixA, int k1A, int k2A, double[][] matrixB, int k1B, int k2B, Calculator calculator) {
        double[][] result = new double[matrixA.length][matrixA.length];
        final int k1 = (k2A < k1B)? k1B : k2A;
        final int k2 = (k1A < k2B)? k2B : k1A;
        for (int i = 0; i < matrixA.length; i++) {
            int length = ((i - k1) + k2 + 1 > matrixA[i].length - 1)? matrixA.length - 1 : (i - k1) + k2 + 1;
            for (int j = (i <= k1)? 0 : i - k1; j <= length; j++){
                double sum = 0;
                for (int k = 0; k < matrixA.length; k++)
                    sum = calculator.sum(sum, calculator.multiplication(matrixA[k][i], matrixB[j][k]));
                result[j][i] = sum;
            }
        }
        return result;
    }

    @Override
    public double[][] exerciseE(double[][] matrixA, double[][] matrixB, Calculator calculator) {
        double[][] result = new double[matrixA.length][matrixA.length];
        for (int i = 0; i < matrixA.length; i++)
            result[i][i] = calculator.sum(matrixA[i][i], matrixB[i][i]);
        return result;
    }

    public static void main(String[] args) {
        final ExerciseThree et = new ExerciseThree();
        double[][] matA = {{1,6,1,0,0},
                           {3,2,7,4,0},
                           {0,4,3,8,5},
                           {0,0,2,5,9},
                           {0,0,0,1,5}};

        double[][] matB = {{1,6,0,0,0},
                           {3,2,7,0,0},
                           {0,3,3,8,0},
                           {0,0,1,4,9},
                           {0,0,0,2,5}};
        double[] vector = {1,2,3,4,5};
        final Calculator calculator = new Listener();

        print(et.exerciseDII(matB, 1, 1, matA, 2, 1, calculator));
        System.out.println("\nOperations made:\nSum: " + ((Listener) calculator).sum + "\nSubtraction: " + ((Listener) calculator).subtraction + "\nMultiplication: " + ((Listener) calculator).multiplication + "\nDivision: " + ((Listener) calculator).division + "\n");
    }

    private static void print(double[][] mat){
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++)
                System.out.print("[" + mat[i][j] + "]");
            System.out.println();
        }
    }

    private static void print(double[] vector){
        for (int i = 0; i < vector.length; i++)
            System.out.print("[" + vector[i] + "]");
    }

}

class Listener implements Calculator {

    int sum = 0;
    int subtraction = 0;
    int multiplication = 0;
    int division = 0;

    @Override public double sum(double a, double b) {
        sum++;
        return a+b;
    }
    @Override public double subtraction(double a, double b) {
        subtraction++;
        return a-b;
    }
    @Override public double multiplication(double a, double b) {
        multiplication++;
        return a*b;
    }
    @Override public double division(double a, double b) {
        division++;
        return a/b;
    }
}