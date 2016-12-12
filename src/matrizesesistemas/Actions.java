package matrizesesistemas;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Actions {

    public static List<String[]> toMatrix(String matrixS) {

        List<String[]> matrix = new ArrayList<>();

        String[] pristineRow, row;

        pristineRow = matrixS.split(";");

        for (String wholeRow : pristineRow) {

            wholeRow = wholeRow.replaceAll("[^0-9|\\.|\\/|\\-|\\,]+", "~");

            StringBuilder sbWholeRow = new StringBuilder(wholeRow);

            sbWholeRow.deleteCharAt(0);

            wholeRow = sbWholeRow.toString();

            row = wholeRow.split("~");

            matrix.add(row);

        }

        return matrix;

    }

    public static String[][] stringListToBi(List<String[]> matrixL) {

        String[][] matrix = new String[matrixL.size()][matrixL.get(0).length];

        for (int i = 0; i < matrixL.size(); i++) {

            for (int j = 0; j < matrixL.get(0).length; j++) {

                matrix[i][j] = matrixL.get(i)[j];

            }

        }

        return matrix;

    }

    public static double[][] matrixStringToDouble(String[][] matrix) {

        double[][] matrixN = new double[matrix.length][matrix[0].length];

        int contRow = 0;
        int contCol = 0;

        for (String[] a : matrix) {

            for (String b : a) {

                b.replace(",", ".");

                if (b.contains("/")) {

                    b = fractionToDecimal(b);

                }

                matrixN[contRow][contCol] = Double.parseDouble(b);

                contCol++;

            }

            contRow++;

        }

        return matrixN;

    }

    public static String[][] matrixDoubleToString(double[][] matrixN) {

        String[][] matrix = new String[matrixN.length][matrixN[0].length];

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[0].length; j++) {

                matrix[i][j] = String.valueOf(matrixN[i][j]);

            }

        }

        return matrix;

    }

    public static String fractionToDecimal(String a) {

        String[] b = a.split("/");

        double num, den;
        num = Double.parseDouble(b[0]);
        den = Double.parseDouble(b[1]);

        return String.valueOf(num / den);

    }

    public static boolean verifyMatrix(List<String[]> matrix) {

        boolean doesAnyRowContainsNull = true;

        for (String[] a : matrix) {

            for (String b : a) {

                if (b == null) {
                    doesAnyRowContainsNull = false;
                }

            }

        }

        List<Integer> lengthsValues = new ArrayList<>();
        for (String[] row : matrix) {

            lengthsValues.add(row.length);

        }

        for (int i = 0; i < lengthsValues.size(); i++) {

            for (int j = 0; j < lengthsValues.size(); j++) {

                if (lengthsValues.get(i) != lengthsValues.get(j)) {

                    doesAnyRowContainsNull = false;

                }

            }

        }

        return doesAnyRowContainsNull;

    }

    public static String printMatrix(Matrix matrix) {
        
        StringBuilder sb = new StringBuilder();
        
        for(String[] line : matrix.getMatrix()) {
            
            sb.append("\t| ");
            
            for(String element : line) {
                
                sb.append(String.format("%s " ,element));
                
            }
            
            sb.append("|\n");
            
        }
        
        return sb.toString();
        
        /*int contador = 0;

        String print = "";

        for (String[] line : matrix.getMatrix()) {

            print = String.format("\t%s%s", print, "|");

            for (String element : line) {

                print = String.format("\t%s%s", print, "|");

            }

            System.out.printf("\t%s", "|");

            contador++;

            if (contador == matrix.getMatrix().length) {

                System.out.printf(" %s", matrix.getSize());

            }

            System.out.println();

        }*/

    }

    public static double[][] matrixSum(Matrix matrix1, Matrix matrix2) throws NotMatchingSizesException {

        if (!(matrix1.getSize().equals(matrix2.getSize()))) {

            throw new NotMatchingSizesException("Sizes are different");

        }

        int rows = matrix1.getMatrixN().length;
        int cols = matrix1.getMatrixN()[0].length;

        double[][] matrix = new double[rows][cols];

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                matrix[i][j] = matrix1.getMatrixN()[i][j] + matrix2.getMatrixN()[i][j];

            }

        }

        return matrix;

    }

    public static double[][] matrixMinus(Matrix matrix1, Matrix matrix2) throws NotMatchingSizesException {

        if (!(matrix1.getSize().equals(matrix2.getSize()))) {

            throw new NotMatchingSizesException("Sizes are different");

        }

        int rows = matrix1.getMatrixN().length;
        int cols = matrix1.getMatrixN()[0].length;

        double[][] matrix = new double[rows][cols];

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                matrix[i][j] = matrix1.getMatrixN()[i][j] - matrix2.getMatrixN()[i][j];

            }

        }

        return matrix;
    }

    public static double[][] matrixProduct(Matrix matrix1, Matrix matrix2) throws NotMatchingSizesException {

        int rows1, cols1, rows2, cols2;
        String[] aux;
        aux = matrix1.getSize().split("x");
        rows1 = Integer.parseInt(aux[1]);
        cols1 = Integer.parseInt(aux[2]);
        aux = matrix2.getSize().split("x");
        rows2 = Integer.parseInt(aux[1]);
        cols2 = Integer.parseInt(aux[2]);

        if (!(rows1 == cols2)) {

            throw new NotMatchingSizesException("Sizes are different");

        }

        double[][] matrix = new double[cols1][rows2];

        for (int i = 0; i < rows1; i++) {

            for (int j = 0; j < cols2; j++) {

                matrix[i][j] = 0;

                for (int k = 0; k < cols1; k++) {

                    matrix[i][j] = matrix[i][j] + (matrix1.getMatrixN()[i][k] * matrix2.getMatrixN()[k][j]);

                }

            }

        }

        return matrix;

    }

    public static double[][] matrixTrans(Matrix matrix) {

        int row = matrix.getMatrixN().length;
        int col = matrix.getMatrixN()[0].length;
        double[][] matrixR = new double[col][row];

        for (int i = 0; i < row; i++) {

            for (int j = 0; j < col; j++) {

                matrixR[j][i] = matrix.getMatrixN()[i][j];

            }

        }

        return matrixR;

    }

}
