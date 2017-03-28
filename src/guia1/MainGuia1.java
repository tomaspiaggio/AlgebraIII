package guia1;

import guia1.ej1.Ej1;
import guia1.ej2.Ej2;
import guia1.ej3.Ej3;
import guia1.ej4.Ej4;
import guia1.ej5.Ej5;
import guia1.ej6.Ej6;
import guia1.ej7.Ej7;
import guia1.ej8.Ej8;

/**
 * Created by matiasvenditti on 3/23/17.
 */
public class MainGuia1 {

    public static void main(String[] args) {

        /**
         * Constantes generales utilizadas para los ejercicios
         */

        final int n = 10; //stackOverflowException with n > 9970 with default configuration
        final int p = 3;
        final int a = 72; //euclides
        final int b = 16;
        final int x = 1;
        final int prime = 30030;
        final int zeros = 93020;
        final int[] capicua = {1, 2, 3, 4, 3, 2, 1};
        final int[] noCapicua = {3, 2, 1, 3, 2, 1, 3};
        final int[] contains = {1, 2, 3, 10, 3, 2, 1};
        final int[] noContains = {1, 2, 3, 3, 2, 1};
        final float[] coefficients = {10.0f, 5.0f, 8.0f, 1.0f}; //10x^3 + 5x^2 + 8x + 1



        /**
         Ejercicio 1
         */

            System.out.println("\nEjercicio 1.\n");
            System.out.println("a) iterative: " + Ej1.a1iterative(n));
            System.out.println("a) recursive: " + Ej1.a1recursive(n));
            System.out.println("b) iterative: " + Ej1.b1iterative(n));
            System.out.println("b) recursive: " + Ej1.b1recursive(n));
            System.out.println("c) iterative: " + Ej1.c1iterative(n, p));
            System.out.println("c) recursive: " + Ej1.c1recursive(n, p));
            System.out.println("d) iterative: " + Ej1.d1iterative(n));
            System.out.println("d) recursive: " + Ej1.d1recursive(n));
            System.out.println("e) iterative: " + Ej1.e1iterative(n));
            System.out.println("e) recursive: " + Ej1.e1recursive(n));
            System.out.println("f) iterative: " + Ej1.f1iterative(n));
            System.out.println("f) recursive: " + Ej1.f1recursive(n));


        /**
         * Ejercicio 2
         */


            System.out.println("\nEjercicio 2.\n");
            System.out.println("a) iterative: " + Ej2.factorialIterative(n));
            System.out.println("a) recursive: " + Ej2.factorialRecursive(n));
            System.out.println("b) iterative: " + Ej2.powerIterative(n));
            System.out.println("b) recursive: " + Ej2.powerRecursive(n));
            System.out.println("c) iterative: " + Ej2.fibonacciIterative(n));
            System.out.println("c) recursive: " + Ej2.fibonacciRecursive(n));
            System.out.println("d) iterative: " + Ej7.euclidesIterative(a, b));
            System.out.println("d) recursive: " + Ej7.euclidesRecursive(a, b));


        /**
         * Ejercicio 3
         */

            System.out.println("\nEjercicio 3.\n");
            System.out.println("Zeros Iterative: " + Ej3.zerosIterative(zeros));
            System.out.println("Zeros Recursive: " + Ej3.zerosRecursive(zeros));


        /**
         * Ejercicio 4
         */

            System.out.println("\nEjercicio 4.\n");
            System.out.println("Capicua Iterative: " + Ej4.orderedIterative(capicua));
            System.out.println("Capicua Recursive: " + Ej4.orderedRecursive(capicua));
            System.out.println("No Capicua Iterative: " + Ej4.orderedIterative(noCapicua));
            System.out.println("No Capicua Recursive: " + Ej4.orderedRecursive(noCapicua));


        /**
         * Ejercicio 5
         */

            System.out.println("\nEjercicio 5.\n");
            System.out.println("Contains Iterative: " + Ej5.containsIterative(contains, 10));
            System.out.println("Contains Recursive: " + Ej5.containsRecursive(contains, 10));
            System.out.println("No Contains Iterative: " + Ej5.containsIterative(noContains, 10));
            System.out.println("No Contains Recursive: " + Ej5.containsRecursive(noContains, 10));


        /**
         * Ejercicio 6
         */

            System.out.println("\nEjercicio 6.\n");
            System.out.println("i)\t\tIterative: " + Ej6.isItPrimeIterative(prime));
            System.out.println("i)\t\tRecursive: " + Ej6.isItPrimeRecursive(prime));
            System.out.println("ii)\t\tIterative: " + Ej6.nextPrimeIterative(prime));
            System.out.println("ii)\t\tRecursive: " + Ej6.nextPrimeRecursive(prime));
            System.out.println("iii)\tIterative: " + Ej6.howManyPrimesIterative(prime));
            System.out.println("iii)\tRecursive: " + Ej6.howManyPrimesRecursive(prime));
            System.out.println("iv)\t\tIterative: " + Ej6.primesIterative(prime).toString());
            System.out.println("iv)\t\tRecursive: " + Ej6.primesRecursive(prime).toString());

        /**
         * Ejercicio 7
         */

            System.out.println("\nEjercicio 7.\n");
            System.out.println("i) Iterative: " + Ej7.euclidesIterative(277,123));
            System.out.println("i) Recursive: " + Ej7.euclidesIterative(277,123));
            System.out.println("ii) Iterative: " + Ej7.euclidesIterative(201,111));
            System.out.println("ii) Recursive: " + Ej7.euclidesIterative(201,111));
            System.out.println("iii) Iterative: " + Ej7.euclidesIterative(14039,1529));
            System.out.println("iii) Recursive: " + Ej7.euclidesIterative(14039,1529));

        /**
         * Ejercicio 8
         */

        float[] result = Ej8.hornerIterative(coefficients, x);
            System.out.println("\nEjercicio 8.\n");
            System.out.println("Horner Iterative With x = " + x + ". Result: " + result[0] + "\tMultiplications: " + (int)result[1] + "\tSums: " + (int)result[2]);
        result = Ej8.hornerRecursive(coefficients, x);
            System.out.println("Horner Recursive With x = " + x + ". Result: " + result[0] + "\tMultiplications: " + (int)result[1] + "\tSums: " + (int)result[2]);
    }

}
