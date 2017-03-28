package main.guia2;

/**
 * Created by Tomas on 3/21/17.
 */
public class Main {

    public static void main(String[] args) {

        /**
         * Constantes utilizadas por los métodos
         */

        final int m = 2;
        final int n = 4;
        final int r = 4;
        final int s = 8;
        final int x = 10;

        System.out.println("Ejercicio 8.\t" + ej8(m, n));
        System.out.println("Ejercicio 9.\t" + ej9(m, n, r, s));
        System.out.println("Ejercicio 10.\t" + ej10(n));
        System.out.println("Ejercicio 11 a.\t" + ej11a(n, x));
        System.out.println("Ejercicio 11 b.\t" + ej11b(n, x));

    }


    public static long ej8(int m, int n){
        long result = 0;
        for (int i = m; i <= n; i++)
            result += i;
        return result;
    }

    public static long ej9(int m, int n, int r, int s){
        return ej8(m, n) * ej8(r, s);
    }

    public static long ej10(int n){
        long result = 0;
        for (int i = 1; i <= n; i++)
            result += i * Math.pow(2, i);
        return result;
    }

    /**
     * Los resultados del 11a y el 11b deberían ser iguales
     */

    public static long ej11a(int n, int x){
        long result = 0;
        for (int i = 0; i <= n; i++) {
            result += i * Math.pow(x, i);
        }
        return result;
    }

    public static long ej11b(int n, int x){
        return (n * ((long)Math.pow(x, n+2)) - ((n + 1) * ((long)Math.pow(x, n+1))) + x)/((long)Math.pow(x-1, 2));
    }
}
