package main.guia6;

import main.guia6.interfaces.Calculator;
import main.guia6.interfaces.Exercise4;
import main.guia6.interfaces.Node;

/**
 * Created by Tomas on 5/22/17.
 */
public class ExerciseFour implements Exercise4 {


    /**
     * ASSUMING THE MATRICES ARE IN ORDER
     * @param matrixA
     * @param matrixB
     * @param calculator
     * @return The sum of the two matrices
     */
    @Override
    public Node[] summation(Node[] matrixA, Node[] matrixB, Calculator calculator) {
        final Nodo<Double>[] result = new Nodo[matrixA.length];
        for (int i = 0; i < matrixA.length; i++)
            result[i] = new Nodo<>(matrixA[i].getRow(),
                                   matrixA[i].getColumn(),
                                   calculator.sum((double)matrixA[i].getValue(), (double)matrixB[i].getValue()));
        return result;
    }

    /**
     * ASSUMING THE MATRICES ARE NOT IN ORDER
     * @param matrixA
     * @param matrixB
     * @param calculator
     * @return The sum of the two matrices
     */
//    @Override
//    public Node[] summation(Node[] matrixA, Node[] matrixB, Calculator calculator) {
//        final Nodo<Double>[] result = new Nodo[matrixA.length];
//        for (int i = 0; i < matrixA.length; i++)
//            for (int j = 0; j < matrixB.length; j++)
//                if(matrixB[j].getColumn() == matrixA[i].getColumn() && matrixB[j].getRow() == matrixA[i].getRow()){
//                    result[i] = new Nodo<>(matrixA[i].getRow(),
//                            matrixA[i].getColumn(),
//                            calculator.sum((double) matrixA[i].getValue(), (double) matrixB[j].getValue()));
//                    break;
//                }
//        return result;
//    }
}
