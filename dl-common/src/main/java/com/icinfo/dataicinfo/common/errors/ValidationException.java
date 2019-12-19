package com.icinfo.dataicinfo.common.errors;

/**
 * 描述:  <br>
 *
 * @author jkk
 * @date 2019年12月17
 */
public class ValidationException extends DatalinkException {
    public ValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ValidationException(String message) {
        super(message);
    }

    public ValidationException(Throwable cause) {
        super(cause);
    }

    public ValidationException() {
    }
}
