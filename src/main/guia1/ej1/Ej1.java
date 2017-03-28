package main.guia1.ej1;

/**
 * Created by matiasvenditti on 3/7/17.
 */
public class Ej1 {

    /**
     * Ejercicio 1
     */

    public static long a1iterative(int n){
        return sumIterative(n, 1);
    }

    public static long a1recursive(int n) {
        return sumRecursive(n, 1);
    }

    public static long b1iterative(int n) {
        return sumIterative(n, 2);
    }

    public static long b1recursive(int n){
        return sumRecursive(n, 2);
    }

    public static long c1iterative(int n, int p) {
        long sum = 0;
        for (int i = 0; i <= n; i++)
            sum += Math.pow(p, i);
        return sum;
    }

    public static long c1recursive(int n, int p){
        return (n==0)? 1 : (long)(Math.pow(p, n) + c1recursive(n-1, p));
    }

    public static long d1iterative(int n){
        long sum = 1;
        int current = 1;
        for (int i = 1; i < n; i++) {
            current += 2;
            sum += current;
        }
        return sum;
    }

    public static long d1recursive(int n){
        return d1auxiliary((2*n)-1, 0);
    }

    public static long e1iterative(int n){
        long sum = 0;
        for (int i = 1; i <= n; i++)
            sum += i*(i+1);
        return sum;
    }

    public static long e1recursive(int n){
        return (n==1)? 2 : n*(n+1) + e1recursive(n-1);
    }

    public static long f1iterative(int n){
        return sumIterative(n, 3);
    }

    public static long f1recursive(int n){
        return sumRecursive(n, 3);
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

}
