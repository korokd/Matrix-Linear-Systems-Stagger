package matrizesesistemas;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Actions {
    private static List<Integer>
            globalX = new ArrayList<Integer>(),
            globalY = new ArrayList<Integer>();
    public static List<String[]> toMatrix(String matrixS) {

        List<String[]> matrix = new ArrayList<>();

        String[] pristineRow, row;

        pristineRow = matrixS.split(";");

        for (String wholeRow : pristineRow) {

            wholeRow = wholeRow.replaceAll("[^0-9|\\.|\\/|\\-|\\,|\\;]+", "~");

            StringBuilder sbWholeRow = new StringBuilder(wholeRow);

            sbWholeRow.deleteCharAt(0);

            wholeRow = sbWholeRow.toString();
            System.out.println(wholeRow);
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
        int x = matrix.length;
        int y = matrix[0].length;
        globalX.add(x);
        globalY.add(y);
        if(matrix[0].length >= 6){
            x =  99;
            y = 99;
        }
        double[][] matrixN = new double[x][y];

        int contRow = 0;
        int contCol = 0;

        for (String[] a : matrix) {
            contCol = 0;
            for (String b : a) {
                
                b = b.replaceAll(",", ".");
                b = b.replaceAll(";", ";\\s ");
                if (b.contains("/")) {

                    b = fractionToDecimal(b);

                }

                matrixN[contRow][contCol] = Double.parseDouble(b);

               
               
            }
            contRow++;
            contCol++;
            
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

    public static boolean verifyMatrix(String[][] matrix) {

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
            
            sb.append("\t|");
            
            for(String element : line) {
                
                sb.append(String.format("\t%s \t" ,element));
                
            }
            
            sb.append("\t|\n");
            
        }
        
        return sb.toString();

    }
    
    public static String printMatrix(String[][] matrix) {
        
        StringBuilder sb = new StringBuilder();
        
        for(String[] line : matrix) {
            
            sb.append("\t|");
            
            for(String element : line) {
                
                sb.append(String.format("\t%s \t" ,element));
                
            }
            
            sb.append("\t|\n");
            
        }
        
        return sb.toString();

    }

    public static double[][] matrixSum(Matrix matrix1, Matrix matrix2) throws NotMatchingSizesException {

        if (!(matrix1.getSize().equals(matrix2.getSize()))) {

            throw new NotMatchingSizesException("Sizes are different");

        }

        int rows = globalX.get(0);
        int cols = globalY.get(0);
       
        double[][] matrix = new double [rows][cols];

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {
                
                matrix[i][j] = Integer.parseInt(matrix1.getMatrix()[i][j]) + Integer.parseInt((matrix2.getMatrix()[i][j]));                
                
            }

        }

        return matrix;

    }

    public static double[][] matrixMinus(Matrix matrix1, Matrix matrix2) throws NotMatchingSizesException {

        if (!(matrix1.getSize().equals(matrix2.getSize()))) {

            throw new NotMatchingSizesException("Sizes are different");

        }

        int rows = globalX.get(0);
        int cols = globalY.get(0);
        
        double[][] matrix = new double[rows][cols];

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {
               
                matrix[i][j] = Double.parseDouble(matrix1.getMatrix()[i][j]) - Double.parseDouble((matrix2.getMatrix()[i][j]));                
                
            }

        }


        return matrix;
    }

    public static double[][] matrixProduct(Matrix matrix1, Matrix matrix2) throws NotMatchingSizesException {
        String[] aux = {null,null};       
        
        int rows1, cols1, rows2, cols2;
        
        aux [0]= Integer.toString(globalX.get(0));
        aux [1]= Integer.toString(globalY.get(0));
        rows1 = Integer.parseInt(aux[0]);
        cols1 = Integer.parseInt(aux[1]);
        aux [0]= Integer.toString(globalX.get(1));
        aux [1]= Integer.toString(globalY.get(1));
        rows2 = Integer.parseInt(aux[0]);
        cols2 = Integer.parseInt(aux[1]);

        if (!(rows1 == cols2)) {

            throw new NotMatchingSizesException("Sizes are different");

        }

        double[][] matrix = new double[cols1][rows2];

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    
                    matrix[i][j] =(Double.parseDouble(matrix1.getMatrix()[i][k]) * Double.parseDouble(matrix2.getMatrix()[k][j]));

                }

            }

        }

        return matrix;

    }

    public static double[][] matrixTrans(Matrix matrix) {
        
        int i = 0, j = 0;
        int row = matrix.getMatrixN().length;
        int col = matrix.getMatrixN()[0].length;
        double[][] matrixT = new double[col][row];

        while(i <= col - 1) {
            
            matrixT[i][j] = Double.parseDouble(matrix.getMatrix()[j][i]);
            j++;
            
            if(j > 0 && j/row == 1) {
                
                i++;
                j = 0;
                                
            }
            
        }
        
        /*for (int i = 0; i < col; i++) {

            for (int j = 0; j < row; j++) {

                matrixT[j][i] = matrix.getMatrixN()[i][j];

            }

        }*/

        return matrixT;

    }
    
 

}
