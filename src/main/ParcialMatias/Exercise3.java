package main.ParcialMatias;

/**
 * Created by matiasvenditti on 6/13/17.
 */
public class Exercise3 {

    public void invertedGauss(double[][] matrix, double[] independentTerms){
        for (int k = matrix.length-1; k >= 0; k--){
            double pivot = matrix[k][k];
            for (int m = 0; m < matrix.length; m++){
                matrix[m][k] /= pivot;
            }
            independentTerms[k] /= pivot;
            for (int j = k-1; j >= 0; j--){
                independentTerms[j] -= independentTerms[k] * matrix[k][j];
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][j] -= matrix[k][j] * matrix[i][k];
                }
            }

        }

        print(solve(matrix,independentTerms));

    }

    public double[] solve(double[][] matrix, double[] independentTerms) {
        double result[] = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            double sum = 0;
            for (int j = 0; j < i; j++)
                sum += matrix[j][i] * result[j];
            result[i] = independentTerms[i] - sum;
        }
        return result;
    }

    private static void print(double[] vector){
        for(int i = 0; i < vector.length; i++){
            System.out.println("[" + vector[i] + "]");
        }
    }

    public static void main(String[] args) {
        Exercise3 exercise3 = new Exercise3();

        double[][] matrix = {{0.5, 1, 2}, {1.5, 0, 1.2}, {0.7, 2, -0.3}};
        double[] independentTerms = {-0.3, 3, 0.5};
        exercise3.invertedGauss(matrix, independentTerms);


    }
}
