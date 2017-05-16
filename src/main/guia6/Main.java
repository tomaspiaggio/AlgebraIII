package main.guia6;

import main.guia6.interfaces.Calculator;

/**
 * Created by matiasvenditti on 5/15/17.
 */
public class Main {

    public static void main(String[] args) {
        double[][] matrix = {{-1,12,2,15}, {7,-3,9,6}, {0,8,3,1}, {17,6,-4,0}};
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
        System.out.println(exerciseOne.exerciseA(matrix,calculator));
        System.out.println(exerciseOne.exerciseB(matrix, calculator));

    }
}
