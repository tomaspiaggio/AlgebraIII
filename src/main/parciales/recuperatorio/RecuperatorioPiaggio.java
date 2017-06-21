package main.parciales.recuperatorio;

/**
 * Created by Tomas on 6/21/17.
 */
public class RecuperatorioPiaggio {

    private static double[] solvePartialPivot(double[][] coefficients, double[] values) {
        for (int k = 0; k < coefficients.length; k++){
            int max = k;
            for (int i = k; i < coefficients.length; i++) if (coefficients[k][i] > coefficients[k][max]) max = i;
            swap(k, max, coefficients, values);
            double pivot = coefficients[k][k];
            for (int i = 0; i < coefficients.length; i++) coefficients[i][k] /= pivot;
            values[k] /= pivot;
            for (int i = k + 1; i < coefficients.length; i++) {
//                double[] aux = new double[coefficients.length];
//                for (int j = 0; j < coefficients.length; j++) {
//                    aux[i] = coefficients[j][k] * coefficients[]
//                }
                values[i] -= values[k] * coefficients[k][i];
                for (int j = coefficients.length - 1; j >= k; j--) {
                    coefficients[j][i] -= coefficients[j][k] * coefficients[k][i];
                }
            }
        }
        return solve(coefficients, values);
    }

    private static void swap(int from, int to, double[][] coefficients, double[] values){
        double aux = values[from];
        values[from] = values[to];
        values[to] = aux;
        for (int i = 0; i < coefficients.length; i++) {
            aux = coefficients[i][from];
            coefficients[i][from] = coefficients[i][to];
            coefficients[i][to] = aux;
        }
    }

    private static double[] solve(double[][] coefficients, double[] values){
        double[] result = new double[coefficients.length];
        for (int i = coefficients.length - 1; i >= 0; i--) {
            double sum = 0;
            for (int j = i; j < coefficients[i].length; j++)
                sum += coefficients[j][i] * result[j];
            result[i] = (values[i] - sum);
        }
        return result;
    }

    public static void main(String[] args) {
//        double[][] coefficients = {{1, 2}, {2, 3}};
//        double[] value = {1, 4};
        double[][] coefficients = {{0.0007, 1}, {1, 1}};
        double[] value = {1, 2};
        print(solvePartialPivot(coefficients, value));
//        print(coefficients, value);
//        swap(0, 1, coefficients, value);
//        print(coefficients, value);

//        System.out.println(redondeoSimetrico());
    }

    private static void print(double[][] coefficients, double[] values){
        System.out.println();
        for (int i = 0; i < coefficients.length; i++) {
            for (int j = 0; j < coefficients.length; j++)
                System.out.print("[" + coefficients[j][i] + "]");
            System.out.println("[" + values[i] + "]");
        }
    }

    private static void print(double[] values){
        System.out.println();
        for (int i = 0; i < values.length; i++) {
            System.out.print("[x" + (i + 1) + ":" + redondeoSimetrico(values[i], 3) + "]");
        }
    }

    private static double redondeoSimetrico(double value, int significantDigits){
        double amount = Math.pow(10, significantDigits);
        value *= amount;
        int aux = (int) value;
        return (double) aux / amount;
    }

}
