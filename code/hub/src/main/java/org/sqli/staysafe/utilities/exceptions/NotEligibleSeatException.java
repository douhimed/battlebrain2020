package org.sqli.staysafe.utilities.exceptions;

import org.sqli.staysafe.utilities.constants.CodeMessages;

public class NotEligibleSeatException extends BusinessException {


    private final static int CODE = 9;

    public NotEligibleSeatException() {
        super(CodeMessages.getMessage(CODE), CODE);
    }
}
