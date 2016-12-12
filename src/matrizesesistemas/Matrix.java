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
    private String size, name;

    public String[][] getMatrix() {
        return matrix;
    }

    public double[][] getMatrixN() {
        return matrixN;
    }

    public String getSize() {
        return size;
    }

    public String getName() {
        return name;
    }

    //build from a file
    public Matrix(File file) {

        matrix = Actions.stringListToBi(Actions.toMatrix(fileToString(file)));
        matrixN = Actions.matrixStringToDouble(matrix);
        size = String.format("%sx%s", matrix.length, matrix[0].length);
        name = file.getName();

    }

    //build from a sum, minus, product operation
    public Matrix(double[][] matrixN, File file1, File file2, String operation) {

        matrix = Actions.matrixDoubleToString(matrixN);
        this.matrixN = matrixN;
        size = String.format("%sx%s", matrix.length, matrix[0].length);
        name = String.format("%s%s%s", file1.getName(), operation, file2.getName());

    }

    //build from a transposition operation
    public Matrix(double[][] matrixN, File file) {

        matrix = Actions.matrixDoubleToString(matrixN);
        this.matrixN = matrixN;
        size = String.format("%sx%s", matrix.length, matrix[0].length);
        name = String.format("%s -t", file.getName());

    }

    private String fileToString(File file) {

        try {

            String line = null;
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
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
