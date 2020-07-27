package org.sqli.staysafe.utilities.exceptions;

import org.sqli.staysafe.utilities.constants.CodeMessages;

public class SpaceMustHaveRowsException extends BusinessException {

    private final static int CODE = 5;

    public SpaceMustHaveRowsException() {
        super(CodeMessages.getMessage(CODE), CODE);
    }
}
