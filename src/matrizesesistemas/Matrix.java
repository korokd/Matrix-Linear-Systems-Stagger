package matrizesesistemas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    //build from a file
    public Matrix(File file) throws InvalidMatrixException {
        
        if(!(Actions.verifyMatrix(Actions.stringListToBi(Actions.toMatrix(fileToString(file)))))){
            throw new InvalidMatrixException("Matriz Invalida");
        } else {
            //String fileString = Actions.toMatrix((fileToString(file)));
            matrix = Actions.stringListToBi(Actions.toMatrix(fileToString(file)));
            matrixN = Actions.matrixStringToDouble(matrix);
            size = String.format("%sx%s", matrix.length, matrix[0].length);
        }
        
    }

    //build from a sum, minus, product operation
    public Matrix(double[][] matrixN, File file1, File file2, String operation) throws InvalidMatrixException {
        
        if(!(Actions.verifyMatrix(Actions.matrixDoubleToString(matrixN)))) {
            throw new InvalidMatrixException("Matriz Invalida");
        } else {
            matrix = Actions.matrixDoubleToString(matrixN);
            this.matrixN = matrixN;
            size = String.format("%sx%s", matrix.length, matrix[0].length);
        }
        
    }

    //build from a transposition operation
    public Matrix(double[][] matrixN) throws InvalidMatrixException {
        
        if(!(Actions.verifyMatrix(Actions.matrixDoubleToString(matrixN)))) {
            throw new InvalidMatrixException("Matriz Invalida");
        } else {
            matrix = Actions.matrixDoubleToString(matrixN);
            this.matrixN = matrixN;
            size = String.format("%sx%s", matrix.length, matrix[0].length);
        }
        
    }

    private String fileToString(File file) {

        try {

            
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            StringBuilder sb = new StringBuilder();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }

            String matrixS = sb.toString();

            return matrixS;

        } catch (FileNotFoundException ex) {

            Logger.getLogger(Matrix.class.getName()).log(Level.SEVERE, null, ex);

        } catch (IOException ex) {

            Logger.getLogger(Matrix.class.getName()).log(Level.SEVERE, null, ex);

        }

        return null;

    }

}
