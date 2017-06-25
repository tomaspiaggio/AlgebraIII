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
        final int k1 = (k1A > k1B)? k1A : k1B;
        final int k2 = (k2A > k2B)? k2A : k2B;
        for (int i = 0; i < matrixA.length; i++) {
            for (int j = (i > k2)? i - k2 : 0; j < ((i + k1 + 1 > matrixA.length)? matrixA.length : i + k1 + 1); j++)
                matrixB[i][j] = calculator.sum(matrixB[i][j], matrixA[i][j]);
        }
        return matrixB;
    }

    @Override
    public double[][] exerciseDIII(double[][] matrixA, int k1A, int k2A, double[][] matrixB, int k1B, int k2B, Calculator calculator) {
        double[][] result = new double[matrixA.length][matrixA.length];
        final int k1 = (k2A < k1B)? k2A: k1B;
        final int k2 = (k1A < k2B)? k1A : k2B;
        for (int i = 0; i < matrixA.length; i++) {
            int length = ((i - k1) + k2 + 1 > matrixA[i].length - 1)? matrixA.length - 1 : (i - k1) + k2 + 1;
            for (int j = 0; j < matrixA.length; j++){
                double sum = 0;
                for (int k = (i > k2)? i - k2 : 0; k < ((i + k1 + 1 > matrixA.length)? matrixA.length : i + k1 + 1); k++)
                    sum = calculator.sum(sum, calculator.multiplication(matrixA[i][k], matrixB[k][j]));
                result[i][j] = sum;
            }
        }
        return result;
    }

    @Override
    public double[][] exerciseE(double[][] matrixA, double[][] matrixB, Calculator calculator) {
        return exerciseDIII(matrixA, 0, matrixA.length - 1, matrixB, matrixB.length - 1, 0, calculator);
    }
}