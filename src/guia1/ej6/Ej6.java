package guia1.ej6;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by matiasvenditti on 3/23/17.
 */
public class Ej6 {

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
     * Auxiliares
     */

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
