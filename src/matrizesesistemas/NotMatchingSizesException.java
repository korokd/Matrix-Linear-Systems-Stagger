package matrizesesistemas;

public class NotMatchingSizesException extends InvalidMatrixException {

    public NotMatchingSizesException() {

    }

    public NotMatchingSizesException(String message) {

        super(message);

    }

    public NotMatchingSizesException(Throwable clause) {

        super(clause);

    }

    public NotMatchingSizesException(String message, Throwable clause) {

        super(message, clause);

    }

}
