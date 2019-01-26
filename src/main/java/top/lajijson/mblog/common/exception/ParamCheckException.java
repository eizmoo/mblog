package top.lajijson.mblog.common.exception;

public class ParamCheckException extends RuntimeException {

    public ParamCheckException() {
    }

    public ParamCheckException(String message) {
        super(message);
    }

    public ParamCheckException(Throwable cause) {
        super(cause);
    }

    public ParamCheckException(String message, Throwable cause) {
        super(message, cause, true, false);
    }
}
