package main.guia6;

import main.guia6.interfaces.Calculator;

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
        double[] vector = {6,9,6};


        exerciseOne.print(exerciseOne.exerciseD(matrix, vector, calculator));

    }
}
