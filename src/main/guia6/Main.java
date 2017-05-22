package main.guia6;

import main.guia6.interfaces.Calculator;

import java.util.Arrays;

/**
 * Created by matiasvenditti on 5/15/17.
 */
public class Main {

    public static void main(String[] args) {
        double[][] matrix = {{3,4,3}, {2,3,1}, {1,2,2}};
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
                return a*b;
            }

            @Override
            public double division(double a, double b) {
                return a/b;
            }
        };

        ExerciseOne exerciseOne = new ExerciseOne();

        double[][] matrixA = {{1,2,3}, {4,5,6}, {7,8,9}};

        double[][] result = exerciseOne.exerciseG(matrixA, calculator);
        System.out.println(Arrays.deepToString(result));


    }
}
