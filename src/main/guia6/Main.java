package main.guia6;

import main.guia6.interfaces.Calculator;

import java.util.Arrays;

/**
 * Created by matiasvenditti on 5/15/17.
 */
public class Main {

    public static void main(String[] args) {

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
        double[][] matrixB = {{1,1,1}, {2,2,2}, {3,3,3}};
        double[] vector = {3,6,9};

        System.out.println("-----------------Exercise A-----------------");
        double[][] matrix = {{3,4,3}, {2,3,1}, {1,2,2}};
        System.out.println(exerciseOne.exerciseA(matrix, calculator)); //8

        System.out.println("-----------------Exercise B-----------------");
//        System.out.println(exerciseOne.exerciseB(matrix, calculator)); //7

        System.out.println("-----------------Exercise C-----------------");
        System.out.println(Arrays.toString(exerciseOne.exerciseC(matrixA, calculator))); //{12, 15, 18}

        System.out.println("-----------------Exercise D-----------------");
        System.out.println(Arrays.toString(exerciseOne.exerciseD(matrixA, vector, calculator))); //{90, 108, 128}

        System.out.println("-----------------Exercise E-----------------");
        System.out.println(Arrays.deepToString(exerciseOne.exerciseE(matrixA, matrixB, calculator))); // {{2,3,4}, {6,7,8}, {10,11,12}}

        System.out.println("-----------------Exercise F-----------------");
        System.out.println(Arrays.deepToString(exerciseOne.exerciseF(matrixA, matrixB, calculator))); // {{8,15,18} {24,30,36} {36,45,54}}

        System.out.println("-----------------Exercise G-----------------");
        System.out.println(Arrays.deepToString(exerciseOne.exerciseG(matrixA, calculator))); // {{1,4,7} {2,5,8} {3,6,9}}


    }
}
