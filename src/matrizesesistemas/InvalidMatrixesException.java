package matrizesesistemas;

public class InvalidMatrixesException extends Exception {

    public InvalidMatrixesException() {

    }

    public InvalidMatrixesException(String message) {

        super(message);

    }

    public InvalidMatrixesException(Throwable clause) {

        super(clause);

    }

    public InvalidMatrixesException(String message, Throwable clause) {

        super(message, clause);

    }

}
