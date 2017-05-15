package main.guia6;

import main.guia6.interfaces.Calculator;
import main.guia6.interfaces.Exercise1;

/**
 * Created by matiasvenditti on 5/15/17.
 */
public class ExerciseOne implements Exercise1 {
    @Override
    public double exerciseA(double[][] matrix, Calculator calculator) {
        return 0;
    }

    @Override
    public double exerciseB(double[][] matrix, Calculator calculator) {
        return 0;
    }

    @Override
    public double[] exerciseC(double[][] matrix, Calculator calculator) {
        return new double[0];
    }

    @Override
    public double[] exerciseD(double[][] matrix, double[] vector, Calculator calculator) {
        return new double[0];
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
}
