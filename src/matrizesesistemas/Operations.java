package matrizesesistemas;

public class Operations {

    public static double[][] matrixSum(Matrix matrix1, Matrix matrix2) throws NotMatchingSizesExpcetion {

        if (!(matrix1.getSize().equals(matrix2.getSize()))) {

            throw new NotMatchingSizesExpcetion("Sizes are different");

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

    public static double[][] matrixProduct(Matrix matrix1, Matrix matrix2) throws NotMatchingSizesExpcetion {

        int rows1, cols1, rows2, cols2;
        String[] aux;
        aux = matrix1.getSize().split("x");
        rows1 = Integer.parseInt(aux[1]);
        cols1 = Integer.parseInt(aux[2]);
        aux = matrix2.getSize().split("x");
        rows2 = Integer.parseInt(aux[1]);
        cols2 = Integer.parseInt(aux[2]);

        if (!(rows1 == cols2)) {

            throw new NotMatchingSizesExpcetion("Sizes are different");

        }

        double[][] matrix = new double[cols1][rows2];

        for (int i = 0; i < rows1; i++) {

            for (int j = 0; j < rows2; j++) {

                for (int k = 0; k < cols1; k++) {

                    int a;

                }

            }

        }

        return null;

    }

}
