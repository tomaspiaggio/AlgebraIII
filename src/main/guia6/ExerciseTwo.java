package main.guia6;

import main.guia6.interfaces.Calculator;
import main.guia6.interfaces.Exercise2;

/**
 * Created by Tomas on 5/15/17.
 */
public class ExerciseTwo implements Exercise2 {

    @Override
    public boolean exerciseA(double[][] matrix, Calculator calculator) {
        for (int i = 0; i < matrix.length; i++)
            for (int j = i; j < matrix[i].length; j++)
                if(matrix[i][j] != matrix[j][i]) return false;
        return true;
    }

    @Override
    public boolean exerciseB(double[][] matrix, Calculator calculator) {
        for (int i = 0; i < matrix.length; i++) {
            double sum = 0;
            for (int j = 0; j < matrix[i].length; j++)
                if(i != j) sum = calculator.sum(sum, matrix[i][j]);
            if(sum > matrix[i][i]) return false;
        }
        return true;
    }
}
