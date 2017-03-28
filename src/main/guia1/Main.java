package main.guia1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tomas Piaggio on 3/7/17.
 */
public class Main {
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
        System.out.println("a) iterative: " + a1iterative(n));
        System.out.println("a) recursive: " + a1recursive(n));
        System.out.println("b) iterative: " + b1iterative(n));
        System.out.println("b) recursive: " + b1recursive(n));
        System.out.println("c) iterative: " + c1iterative(n, p));
        System.out.println("c) recursive: " + c1recursive(n, p));
        System.out.println("d) iterative: " + d1iterative(n));
        System.out.println("d) recursive: " + d1recursive(n));
        System.out.println("e) iterative: " + e1iterative(n));
        System.out.println("e) recursive: " + e1recursive(n));
        System.out.println("f) iterative: " + f1iterative(n));
        System.out.println("f) recursive: " + f1recursive(n));


        /**
         * Ejercicio 2
         */


        System.out.println("\nEjercicio 2.\n");
        System.out.println("a) iterative: " + factorialIterative(n));
        System.out.println("a) recursive: " + factorialRecursive(n));
        System.out.println("b) iterative: " + powerIterative(n));
        System.out.println("b) recursive: " + powerRecursive(n));
        System.out.println("c) iterative: " + fibonacciIterative(n));
        System.out.println("c) recursive: " + fibonacciRecursive(n));
        System.out.println("d) iterative: " + euclidesIterative(a, b));
        System.out.println("d) recursive: " + euclidesRecursive(a, b));


        /**
         * Ejercicio 3
         */

        System.out.println("\nEjercicio 3.\n");
        System.out.println("Zeros Iterative: " + zerosIterative(zeros));
        System.out.println("Zeros Recursive: " + zerosRecursive(zeros));


        /**
         * Ejercicio 4
         */

        System.out.println("\nEjercicio 4.\n");
        System.out.println("Capicua Iterative: " + orderedIterative(capicua));
        System.out.println("Capicua Recursive: " + orderedRecursive(capicua));
        System.out.println("No Capicua Iterative: " + orderedIterative(noCapicua));
        System.out.println("No Capicua Recursive: " + orderedRecursive(noCapicua));


        /**
         * Ejercicio 5
         */

        System.out.println("\nEjercicio 5.\n");
        System.out.println("Contains Iterative: " + containsIterative(contains, 10));
        System.out.println("Contains Recursive: " + containsRecursive(contains, 10));
        System.out.println("No Contains Iterative: " + containsIterative(noContains, 10));
        System.out.println("No Contains Recursive: " + containsRecursive(noContains, 10));


        /**
         * Ejercicio 6
         */

        System.out.println("\nEjercicio 6.\n");
        System.out.println("i)\t\tIterative: " + isItPrimeIterative(prime));
        System.out.println("i)\t\tRecursive: " + isItPrimeRecursive(prime));
        System.out.println("ii)\t\tIterative: " + nextPrimeIterative(prime));
        System.out.println("ii)\t\tRecursive: " + nextPrimeRecursive(prime));
        System.out.println("iii)\tIterative: " + howManyPrimesIterative(prime));
        System.out.println("iii)\tRecursive: " + howManyPrimesRecursive(prime));
        System.out.println("iv)\t\tIterative: " + primesIterative(prime).toString());
        System.out.println("iv)\t\tRecursive: " + primesRecursive(prime).toString());

        /**
         * Ejercicio 7
         */

        System.out.println("\nEjercicio 7.\n");
        System.out.println("i) Iterative: " + euclidesIterative(277,123));
        System.out.println("i) Recursive: " + euclidesIterative(277,123));
        System.out.println("ii) Iterative: " + euclidesIterative(201,111));
        System.out.println("ii) Recursive: " + euclidesIterative(201,111));
        System.out.println("iii) Iterative: " + euclidesIterative(14039,1529));
        System.out.println("iii) Recursive: " + euclidesIterative(14039,1529));

        /**
         * Ejercicio 8
         */

        float[] result = hornerIterative(coefficients, x);
        System.out.println("\nEjercicio 8.\n");
        System.out.println("Horner Iterative With x = " + x + ". Result: " + result[0] + "\tMultiplications: " + (int)result[1] + "\tSums: " + (int)result[2]);
        result = hornerRecursive(coefficients, x);
        System.out.println("Horner Recursive With x = " + x + ". Result: " + result[0] + "\tMultiplications: " + (int)result[1] + "\tSums: " + (int)result[2]);




    }
    /**
     * Ejercicio 1
     */

    private static long a1iterative(int n){
        return sumIterative(n, 1);
    }

    private static long a1recursive(int n) {
        return sumRecursive(n, 1);
    }

    private static long b1iterative(int n) {
        return sumIterative(n, 2);
    }

    private static long b1recursive(int n){
        return sumRecursive(n, 2);
    }

    private static long c1iterative(int n, int p) {
        long sum = 0;
        for (int i = 0; i <= n; i++)
            sum += Math.pow(p, i);
        return sum;
    }

    private static long c1recursive(int n, int p){
        return (n==0)? 1 : (long)(Math.pow(p, n) + c1recursive(n-1, p));
    }

    private static long d1iterative(int n){
        long sum = 1;
        int current = 1;
        for (int i = 1; i < n; i++) {
            current += 2;
            sum += current;
        }
        return sum;
    }

    private static long d1recursive(int n){
        return d1auxiliary((2*n)-1, 0);
    }

    private static long e1iterative(int n){
        long sum = 0;
        for (int i = 1; i <= n; i++)
            sum += i*(i+1);
        return sum;
    }

    private static long e1recursive(int n){
        return (n==1)? 2 : n*(n+1) + e1recursive(n-1);
    }

    private static long f1iterative(int n){
        return sumIterative(n, 3);
    }

    private static long f1recursive(int n){
        return sumRecursive(n, 3);
    }

    /**
     * Ejercicio 2
     */

    private static long factorialIterative(int n){
        long sum = 1;
        for (int i = 1; i <= n; i++)
            sum*=i;
        return sum;
    }

    private static long factorialRecursive(int n){
        return (n==1 || n==0)? 1 : n * factorialRecursive(n-1);
    }

    private static long powerIterative(int n){
        return c1iterative(n, 2);
    }

    private static long powerRecursive(int n){
        return c1recursive(n, 2);
    }

    private static int fibonacciIterative(int n){
        int current = 1;
        int previous = 1;
        for (int i = 2; i <= n; i++) {
            int aux = current;
            current = current + previous;
            previous = aux;
        }
        return current;
    }

    private static int fibonacciRecursive(int n){
        return fibonacciAux(n, 1, 1);
    }

    /**
     * No esta bien todavia los de abajo
     */

    private static int euclidesIterative(int bigger, int smaller){
        int result = 0;
        while(bigger % smaller != 0){
            result = bigger % smaller;
            bigger = smaller;
            smaller = result;
        }
        return result;
    }

    private static int euclidesRecursive(int bigger, int smaller){
        return (bigger % smaller == 0)? smaller : euclidesRecursive(smaller, bigger % smaller);
    }

    /**
     * Ejercicio 3
     */

    private static int zerosIterative(int number){
        int result = 0;
        while(number > 0){
            if(number % 10 == 0) result++;
            number/=10;
        }
        return result;
    }

    private static int zerosRecursive(int number) {
        return zerosAuxiliary(number, 0);
    }

    /**
     * Ejercicio 4
     * Se asume que es solo para números enteros por los ejercicios anteriores
     * No hace falta chquear que sea par o impar porque si es impar y es capicua el del medio no afecta
     */

    private static boolean orderedIterative(int[] a){
        for (int i = 0; i < a.length/2; i++)
            if(a[i] != a[a.length - 1 - i]) return false;
        return true;
    }

    private static boolean orderedRecursive(int[] a){
        return orderedAuxiliary(a, 0, a.length-1);
    }

    /**
     * Ejercicio 5
     */

    private static boolean containsIterative(int[] a, int value){
        for (int i = 0; i < a.length; i++)
            if(value == a[i]) return true;
        return false;
    }

    private static boolean containsRecursive(int[] a, int value){
        return containsAuxiliary(a, value, 0);
    }


    /**
     * Ejercicio 6
     */

    public static boolean isItPrimeIterative(int n){
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) return false;
        }
        return true;
    }

    public static boolean isItPrimeRecursive(int n){
        return isItPrimeAuxiliary(n, 2);
    }

    public static int nextPrimeIterative(int n){
        int current = (n % 2 != 0 || n == 2)? n : n+1; // para ahorrar tiempo y no sumar de a uno
        while(!isItPrimeIterative(current)){
            current += 2; //porque los pares no son primos
        }
        return current;
    }

    public static int nextPrimeRecursive(int n){
        if(n == 2) return n;
        int current = (n % 2 != 0)? n : n+1;
        return nextPrimeAuxiliary(current);
    }

    public static int howManyPrimesIterative(int n){
        return primesIterative(n).size();
    }

    public static int howManyPrimesRecursive(int n){
        return primesRecursive(n).size();
    }

    public static List<Integer> primesIterative(int n){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        for (int i = 3; i < Math.sqrt(n); i+=2)
            if(n % i == 0 && isItPrimeIterative(i)) list.add(i);
        return list;
    }

    public static List<Integer> primesRecursive(int n){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        primesAuxiliary(n, 3, list);
        return list;
    }




    /**
     * Ejercicio 8
     */

    private static float[] hornerIterative(float[] coefficients, float x){
        float aux = coefficients[0]*x + coefficients[1];
        float multiplications = 1;
        float sums = 1;
        for (int i = 2; i < coefficients.length; i++) {
            aux = aux*x + coefficients[i];
            multiplications++;
            sums++;
        }
        float[] result = {aux, multiplications, sums};
        return result;
    }

    private static float[] hornerRecursive(float[] coefficients, float x){
        float[] result = {coefficients[0]*x + coefficients[1], 1, 1};
        return hornerAuxiliary(coefficients, x, result, 2);
    }


    /**
     * Auxiliares
     */

    private static long sumIterative(int n, int pow){
        long sum = 0;
        for (int i = 0; i <= n; i++)
            sum += Math.pow(i, pow);
        return sum;
    }

    private static long sumRecursive(int n, int pow){
        return (n==1)? 1 : (long)(Math.pow(n, pow) + sumRecursive(n-1, pow));
    }

    private static long d1auxiliary(int aux, int sum){
        return (aux == 1)? sum + 1 : d1auxiliary(aux-2, sum + aux);
    }

    private static int fibonacciAux(int n, int current, int previous){
        return (n==1 || n==0)? current : fibonacciAux(n-1, current + previous, current);
    }

    private static int zerosAuxiliary(int number, int counter){
        if(number <= 0) return counter;
        else if(number%10 == 0)
            return zerosAuxiliary(number/10, ++counter);
        return zerosAuxiliary(number/10, counter);
    }

    private static boolean orderedAuxiliary(int[] a, int lo, int hi){
        if(lo >= hi) return true;
        if(a[lo] != a[hi]) return false;
        return orderedAuxiliary(a, ++lo, --hi);
    }

    private static boolean containsAuxiliary(int[] a, int value, int lo){
        if(lo >= a.length) return false;
        if(value == a[lo]) return true;
        return containsAuxiliary(a, value, ++lo);
    }

    private static float[] hornerAuxiliary(float[] coefficients, float x, float[] result, int n){
        if(n == coefficients.length) return result;
        result[0] = result[0] * x + coefficients[n];
        result[1]++;
        result[2]++;
        return hornerAuxiliary(coefficients, x, result, ++n);
    }

    private static boolean isItPrimeAuxiliary(int n, int i){
        if(n % i == 0) return false;
        if(i >= Math.sqrt(n)) return true;
        return isItPrimeAuxiliary(n, ++i);
    }

    private static int nextPrimeAuxiliary(int n){
        return (isItPrimeRecursive(n))? n : nextPrimeAuxiliary(n+2);
    }

    public static void primesAuxiliary(int n, int i, List<Integer> list){
        if(i >= Math.sqrt(n)) return;
        if(n % i == 0 && isItPrimeRecursive(i)) list.add(i);
        primesAuxiliary(n, i+2, list);
    }
}