package org.sqli.staysafe.utilities.exceptions;

import org.sqli.staysafe.utilities.constants.CodeMessages;

public class SpaceIsFullException extends BusinessException {

    private final static int CODE = 8;

    public SpaceIsFullException() {
        super(CodeMessages.getMessage(CODE), CODE);
    }
}
