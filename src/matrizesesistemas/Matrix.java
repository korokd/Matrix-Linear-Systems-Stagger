package matrizesesistemas;

import java.util.ArrayList;
import java.util.List;

public class Matrix {

    private String[][] matrix;
    private double[][] matrixN;
    private String size;

    public String[][] getMatrix() {
        return matrix;
    }

    public double[][] getMatrixN() {
        return matrixN;
    }

    public String getSize() {
        return size;
    }

    public Matrix(String matrixS) {

        matrix = Actions.stringListToBi(Actions.toMatrix(matrixS));
        matrixN = Actions.matrixStringToDouble(matrix);
        size = String.format("%sx%s", matrix.length, matrix[0].length);

    }

}
