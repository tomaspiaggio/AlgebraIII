package main.parciales;

/**
 * Created by Tomas on 6/13/17.
 */
public class ParcialTomas {

    /**
     * @param coefficients el arreglo de dos dimensiones a analizar
     * @return true si coefficients es simetrico y false si no lo es
     */
    private static boolean isSymmetric(double[][] coefficients){
        for (int i = 0; i < coefficients.length - 1; i++)
            if(coefficients[i][i + 1] != coefficients[i + 1][i]) return false;
        return true;
    }
    
    private static double[] ejercicio3A(double[][] coefficients, double[] values){
        for (int i = coefficients.length - 1; i >= 0; i--) {
            double pivot = coefficients[i][i];
            if(pivot != 0){
                for (int j = 0; j < coefficients.length; j++) coefficients[j][i] /= pivot;
                values[i] /= pivot;
            }
            for (int j = i - 1; j >= 0; j--) {
                double mult = coefficients[i][j];
                for (int k = 0; k < coefficients.length; k++)
                    coefficients[k][j] -= coefficients[k][i] * mult;
                values[j] -= values[i] * mult;
            }
        }
        return triangulate(coefficients, values);
    }

    private static double[] triangulate(double[][] coefficients, double[] values){
        double[] result = new double[coefficients.length];
        for (int i = 0; i < coefficients.length; i++) {
            double sum = 0;
            for (int j = 0; j <= i; j++)
                sum += coefficients[j][i] * result[j];
            result[i] = values[i] - sum;
        }
        return result;
    }

    public static void main(String[] args) {
        /**
         * EJERCICIO 2
         */
        // Matriz no simétrica
        double[][] coefficientsNotSymmetric = {{1, 4, 0, 0},
                                               {4, 2, 2, 0},
                                               {0, 3, 3, 3},
                                               {0, 0, 3, 4}};
        // Matriz simétrica
        double[][] coefficientsSymmetric = {{1, 4, 0, 0},
                                            {4, 2, 2, 0},
                                            {0, 2, 3, 3},
                                            {0, 0, 3, 4}};

        System.out.println("Matriz no simetrica isSymmetric?: " + isSymmetric(coefficientsNotSymmetric));
        System.out.println("Matriz simetrica isSymmetric?: " + isSymmetric(coefficientsSymmetric) + "\n\n");


        /**
         * EJERCICIO 3B
         * Los valores de abajo son columnas es decir el vector resultante sería:
         * 0.5 | 1.5 | 0.7 | -0.3
         * 1.0 | 0.0 | 2.0 | 3.0
         * 2.0 | 1.2 | -0.3| 0.5
         */
        double[][] coef = {{0.5, 1, 2},{1.5, 0, 1.2},{0.7, 2, 0.5}};
        double[] vector = {-0.3, 3, 0.5};


        /**
         * ADICIONAL PARA VER EL FUNCIONAMIENTO
         */
//        double[][] coef = {{1, 4},{2, 6}};
//        double[] vector = {2, 3};


        /**
         * NO MODIFICAR PARA QUE FUNCIONE EL PROGRAMA
         */

        print(ejercicio3A(coef, vector));
        System.out.println("\n");
        System.out.println("Triangulado Quedaría: ");
        print1(coef, vector);
    }

    private static void print(double[] a){
        for (int i = 0; i < a.length; i++) {
            System.out.print("[x" + (i + 1) + ":" + roundDecimalPlaces(a[i], 4) + "]");
        }
    }

    private static void print1(double[][] a, double[] ind){
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++)
                System.out.print("[" + roundDecimalPlaces(a[j][i], 2) + "]");
            System.out.println("[" + roundDecimalPlaces(ind[i], 2) + "]");
        }
    }

    private static double roundDecimalPlaces(double input, int decimalPlaces){
        double multiplier = Math.pow(10, decimalPlaces);
        int aux = (int)(multiplier * input);
        double result = ((double)aux) / multiplier;
        return result;
    }

}
