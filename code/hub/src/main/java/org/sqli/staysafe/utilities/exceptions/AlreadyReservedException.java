package org.sqli.staysafe.utilities.exceptions;

import org.sqli.staysafe.utilities.constants.CodeMessages;

public class AlreadyReservedException extends BusinessException {

    private final static int CODE = 3;

    public AlreadyReservedException() {
        super(CodeMessages.getMessage(CODE), CODE);
    }
}
