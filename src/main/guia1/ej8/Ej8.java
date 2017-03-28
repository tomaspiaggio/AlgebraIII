package main.guia1.ej8;

/**
 * Created by matiasvenditti on 3/23/17.
 */
public class Ej8 {

    /**
     * Ejercicio 8
     */

    public static float[] hornerIterative(float[] coefficients, float x){
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

    public static float[] hornerRecursive(float[] coefficients, float x){
        float[] result = {coefficients[0]*x + coefficients[1], 1, 1};
        return hornerAuxiliary(coefficients, x, result, 2);
    }

    /**
     * Auxiliares
     */

    private static float[] hornerAuxiliary(float[] coefficients, float x, float[] result, int n){
        if(n == coefficients.length) return result;
        result[0] = result[0] * x + coefficients[n];
        result[1]++;
        result[2]++;
        return hornerAuxiliary(coefficients, x, result, ++n);
    }
}
