package main.ParcialMatias;


/**
 * Created by matiasvenditti on 6/13/17.
 */
public class Exercise2 {

    public boolean isSimmetric(double[][] matrix){
        for (int i = 0; i < matrix.length-1; i++) {
            if (matrix[i][i+1] != matrix[i+1][i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Exercise2 exercise2 = new Exercise2();

        double[][] matrix = {{1,8,0,0,0},{8,2,9,0,0},{0,9,3,10,0},{0,0,10,4,11},{0,0,0,56,5}};
        System.out.println(exercise2.isSimmetric(matrix));
    }

}
