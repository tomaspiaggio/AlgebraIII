package main.guia1.ej4;

/**
 * Created by matiasvenditti on 3/14/17.
 */
public class Ej4 {


    /**
     * Ejercicio 4
     * Se asume que es solo para números enteros por los ejercicios anteriores
     * No hace falta chquear que sea par o impar porque si es impar y es capicua el del medio no afecta
     */

    public static boolean orderedIterative(int[] a){
        for (int i = 0; i < a.length/2; i++)
            if(a[i] != a[a.length - 1 - i]) return false;
        return true;
    }

    public static boolean orderedRecursive(int[] a){
        return orderedAuxiliary(a, 0, a.length-1);
    }

    /**
     * Auxiliares
     */
    private static boolean orderedAuxiliary(int[] a, int lo, int hi){
        if(lo >= hi) return true;
        if(a[lo] != a[hi]) return false;
        return orderedAuxiliary(a, ++lo, --hi);
    }
}
