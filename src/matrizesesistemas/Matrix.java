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

        matrix = stringListToBi(toMatrix(matrixS));
        matrixN = matrixStringToDouble(matrix);
        size = String.format("%sx%s", matrix.length, matrix[0].length);

    }

    private List<String[]> toMatrix(String matrixS) {

        //cria a matriz que armazena tudo
        List<String[]> matrix = new ArrayList<>();

        //splitedsrow armazena linha separada
        //contentOfRow armazera o conteudo de cada linha 
        String[] pristineRow, row;

        //separa todo o arquivo por ',' entendendo que a cada ',' tera¡
        //uma linha da matriz.
        pristineRow = matrixS.split(";");

        for (String wholeRow : pristineRow) {

            //[^0-9|\\.|\\/]+", "-" = substitui TUDO menos os numeros de 
            //0-9 OU o . (para numeros Double) OU o / (para numeros
            //fracionados)
            wholeRow = wholeRow.replaceAll("[^0-9|\\.|\\/|\\-|\\,]+", "~");

            //StringBuilder utilizado para poder retirar o primeiro caractere (-)
            //da String wholeRow, de forma a evitar um null no index 0
            StringBuilder sbWholeRow = new StringBuilder(wholeRow);

            sbWholeRow.deleteCharAt(0);
            //atribui para wholeRow a String sem o primeiro caractere
            wholeRow = sbWholeRow.toString();

            //agora a LINHA se parecera com isso: 2-3-4 
            //entao separaremos apenas os numeros, removendo o -
            row = wholeRow.split("~");

            //adiciona a array (linha) na list que contem todas as linhas
            matrix.add(row);

        }

        return matrix;

    }

    private double[][] matrixStringToDouble(String[][] matrix) {

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

        return null;

    }

    private String[][] stringListToBi(List<String[]> matrixL) {

        String[][] matrix = new String[matrixL.size()][matrixL.get(0).length];

        for (int i = 0; i < matrixL.size(); i++) {

            for (int j = 0; j < matrixL.get(0).length; j++) {

                matrix[i][j] = matrixL.get(i)[j];

            }

        }

        return matrix;

    }

    private String fractionToDecimal(String a) {

        String[] b = a.split("/");

        double num, den;
        num = Double.parseDouble(b[1]);
        den = Double.parseDouble(b[2]);

        return String.valueOf(num / den);

    }

}
