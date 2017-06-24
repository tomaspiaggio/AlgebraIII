package main.parciales.recuperatorio;

/**
 * Created by Tomas on 6/21/17.
 */
public class RecuperatorioTomasPiaggio {

    private static boolean checkUpperTriangular(double[][] matrix){
        for (int j = 1; j < matrix.length; j++)
            for (int i = 0; i < j; i++)
                if(matrix[i][j] != 0) return false;
        return true;
    }

    private static double[][] multiplyUpperTriangular(double[][] matA, double[][] matB, OperationsListener operations){
        double[][] result = new double[matA.length][matA.length];
        for (int i = 0; i < matA.length; i++)
            for (int j = i; j < matA[i].length; j++){
                double sum = 0;
                for (int k = i; k < matA.length; k++) {
                    sum += matA[k][i] * matB[j][k];
                    operations.operations++;
                }
                result[j][i] = sum;
            }
        return result;
    }

    public static void main(String[] args) {


        /**
         * Imprime lo siguiente:
         * Ejercicio 2

         * Es triangular superior?: true

         * [1.0][2.0][1.0]
         * [0.0][1.0][1.0]
         * [0.0][0.0][1.0]

         * Es triangular superior?: false

         * [1.0][2.0][1.0]
         * [0.0][1.0][1.0]
         * [1.0][1.0][1.0]

         * Ejercicio 3

         * [1.0][3.0]
         * [0.0][3.0]

         * Performed 5 operations.
         */

        System.out.println("Ejercicio 2");
        /**
         * La matriz de abajo corresponde a la siguiente matriz
         *
         * 1 | 2 | 1
         * 0 | 1 | 1
         * 0 | 0 | 1
         */
        double[][] matrix = {{1, 0, 0}, {2, 1, 0}, {1, 1, 1}};
        System.out.println("\nEs triangular superior?: " + checkUpperTriangular(matrix) + "\n");
        print(matrix);

        /**
         * La matriz de abajo corresponde a la siguiente matriz
         *
         * 1 | 2 | 1
         * 0 | 1 | 1
         * 1 | 1 | 1
         */
        double[][] matrix1 = {{1, 0, 1}, {2, 1, 1}, {1, 1, 1}};
        System.out.println("\nEs triangular superior?: " + checkUpperTriangular(matrix1) + "\n");
        print(matrix1);


        System.out.println("\nEjercicio 3\n");

        /**
         * La multiplicacion de abajo corresponde a la siguiente
         *
         * 1 | 2  *  1 | 1
         * 0 | 3     0 | 1
         */
        double[][] matA = {{1, 0, 0, 0},
                           {2, 3, 0, 0},
                           {3, 2, 1, 0},
                           {5, 4, 5, 1}};
        double[][] matB = {{1, 0, 0, 0},
                           {1, 1, 0, 0},
                           {1, 2, 3, 0},
                           {4, 3, 5, 1}};
        OperationsListener operations = new OperationsListener();
        print(multiplyUpperTriangular(matA, matB, operations));

        System.out.println("\nPerformed " + operations.operations + " operations.");


    }

    private static void print(double[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++)
                System.out.print("[" + matrix[j][i] + "]");
            System.out.println();
        }
    }
}

class OperationsListener {
    int operations;
}
