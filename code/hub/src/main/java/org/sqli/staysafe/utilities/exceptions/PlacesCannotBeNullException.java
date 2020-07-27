package org.sqli.staysafe.utilities.exceptions;

import org.sqli.staysafe.utilities.constants.CodeMessages;

public class PlacesCannotBeNullException extends BusinessException {

    private final static int CODE = 4;

    public PlacesCannotBeNullException() {
        super(CodeMessages.getMessage(CODE), CODE);
    }
}
