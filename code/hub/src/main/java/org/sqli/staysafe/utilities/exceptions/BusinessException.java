package org.sqli.staysafe.utilities.exceptions;

public class BusinessException extends RuntimeException{

    protected final int code;

    public BusinessException(String message, int code) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

}
