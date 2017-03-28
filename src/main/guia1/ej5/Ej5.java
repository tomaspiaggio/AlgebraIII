package main.guia1.ej5;

/**
 * Created by matiasvenditti on 3/14/17.
 */
public class Ej5 {

    /**
     * Ejercicio 5
     */

    public static boolean containsIterative(int[] a, int value){
        for (int i = 0; i < a.length; i++)
            if(value == a[i]) return true;
        return false;
    }

    public static boolean containsRecursive(int[] a, int value){
        return containsAuxiliary(a, value, 0);
    }

    /**
     * Auxiliares
     */

    private static boolean containsAuxiliary(int[] a, int value, int lo){
        if(lo >= a.length) return false;
        if(value == a[lo]) return true;
        return containsAuxiliary(a, value, ++lo);
    }
}
