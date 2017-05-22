package main.guia6;

import main.guia6.interfaces.Calculator;
import main.guia6.interfaces.Exercise3;

/**
 * Created by Tomas on 5/15/17.
 */
public class ExerciseThree implements Exercise3 {

    @Override
    public double[] exerciseAI(double[][] matrixA, double[] vectorX, Calculator calculator) {
        double[] result = new double[vectorX.length];
        for (int i = 0; i < matrixA.length; i++)
            for (int j = 0; j < matrixA[i].length; j++)
                result[j] = calculator.sum(result[j], calculator.multiplication(matrixA[i][j], vectorX[j]));
        return result;
    }

    @Override
    public double[][] exerciseAII(double[][] matrixA, double[][] matrixB, Calculator calculator) {
        for (int i = 0; i < matrixA.length; i++)
            for (int j = 0; j < matrixA[i].length; j++)
                matrixB[i][j] = calculator.sum(matrixB[i][j], matrixA[i][j]);
        return matrixB;
    }

    @Override
    public double[][] exerciseAIII(double[][] matrixA, double[][] matrixB, Calculator calculator) {
        double[][] result = new double[matrixA.length][matrixA.length];
        for (int i = 0; i < matrixA.length; i++)
            for (int j = 0; j < matrixA[i].length; j++) {
                double sum = 0;
                for (int k = 0; k < matrixA.length; k++)
                    sum = calculator.sum(sum, calculator.multiplication(matrixA[i][k], matrixB[k][j]));
                result[i][j] = sum;
            }
        return result;
    }

    @Override
    public double[] exerciseBI(double[][] matrixA, double[] vectorX, Calculator calculator) {
        return new double[0];
    }

    @Override
    public double[][] exerciseBII(double[][] matrixA, double[][] matrixB, Calculator calculator) {
        return new double[0][];
    }

    @Override
    public double[][] exerciseBIII(double[][] matrixA, double[][] matrixB, Calculator calculator) {
        return new double[0][];
    }

    @Override
    public double[] exerciseCI(double[][] matrixA, double[] vectorX, Calculator calculator) {
        return new double[0];
    }

    @Override
    public double[][] exerciseCII(double[][] matrixA, double[][] matrixB, Calculator calculator) {
        return new double[0][];
    }

    @Override
    public double[][] exerciseCIII(double[][] matrixA, double[][] matrixB, Calculator calculator) {
        return new double[0][];
    }

    @Override
    public double[] exerciseDI(double[][] matrixA, int k1A, int k2A, double[] vectorX, Calculator calculator) {
        return new double[0];
    }

    @Override
    public double[][] exerciseDII(double[][] matrixA, int k1A, int k2A, double[][] matrixB, int k1B, int k2B, Calculator calculator) {
        return new double[0][];
    }

    @Override
    public double[][] exerciseDIII(double[][] matrixA, int k1A, int k2A, double[][] matrixB, int k1B, int k2B, Calculator calculator) {
        return new double[0][];
    }

    // Matik argentino.
    @Override
    public double[][] exerciseE(double[][] matrixA, double[][] matrixB, Calculator calculator) {
        return new double[0][];
    }
}
