package cmh.excecise.exception;

public class ApplicationError extends RuntimeException {
    public ApplicationError() {
    }

    public ApplicationError(String message) {
        super(message);
    }

    public ApplicationError(String message, Throwable cause) {
        super(message, cause);
    }

    public ApplicationError(Throwable cause) {
        super(cause);
    }

    public ApplicationError(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
