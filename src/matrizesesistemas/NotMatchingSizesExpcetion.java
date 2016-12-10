package matrizesesistemas;

public class NotMatchingSizesExpcetion extends InvalidMatrixesException {

    public NotMatchingSizesExpcetion() {

    }

    public NotMatchingSizesExpcetion(String message) {

        super(message);

    }

    public NotMatchingSizesExpcetion(Throwable clause) {

        super(clause);

    }

    public NotMatchingSizesExpcetion(String message, Throwable clause) {

        super(message, clause);

    }

}
