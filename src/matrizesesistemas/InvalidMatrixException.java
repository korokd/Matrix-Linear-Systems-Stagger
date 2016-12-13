package matrizesesistemas;

public class InvalidMatrixException extends Exception {

    public InvalidMatrixException() {

    }

    public InvalidMatrixException(String message) {

        super(message);

    }

    public InvalidMatrixException(Throwable clause) {

        super(clause);

    }

    public InvalidMatrixException(String message, Throwable clause) {

        super(message, clause);

    }

}
