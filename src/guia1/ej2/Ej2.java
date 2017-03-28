package guia1.ej2;


import static guia1.ej1.Ej1.c1iterative;
import static guia1.ej1.Ej1.c1recursive;

/**
 * Created by matiasvenditti on 3/9/17.
 */
public class Ej2 {


    /**
     * Ejercicio 2
     */
    public static long factorialIterative(int n){
        long sum = 1;
        for (int i = 1; i <= n; i++)
            sum*=i;
        return sum;
    }

    public static long factorialRecursive(int n){
        return (n==1 || n==0)? 1 : n * factorialRecursive(n-1);
    }

    public static long powerIterative(int n){
        return c1iterative(n, 2);
    }

    public static long powerRecursive(int n){
        return c1recursive(n, 2);
    }

    public static int fibonacciIterative(int n){
        int current = 1;
        int previous = 1;
        for (int i = 2; i <= n; i++) {
            int aux = current;
            current = current + previous;
            previous = aux;
        }
        return current;
    }

    public static int fibonacciRecursive(int n){
        return fibonacciAux(n, 1, 1);
    }


    /**
     * Auxiliares
     */

    private static int fibonacciAux(int n, int current, int previous){
        return (n==1 || n==0)? current : fibonacciAux(n-1, current + previous, current);
    }
}
