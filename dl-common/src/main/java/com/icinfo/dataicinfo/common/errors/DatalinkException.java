package com.icinfo.dataicinfo.common.errors;

/**
 * 描述:  <br>
 *
 * @author jkk
 * @date 2019年12月13
 */
public class DatalinkException extends RuntimeException {

    private static final long serialVersionUID = -1456559700866315686L;

    public DatalinkException(String message, Throwable cause) {
        super(message, cause);
    }

    public DatalinkException(String message) {
        super(message);
    }

    public DatalinkException(Throwable cause) {
        super(cause);
    }

    public DatalinkException() {
        super();
    }
}
