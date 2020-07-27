package org.sqli.staysafe.utilities.exceptions;

import org.sqli.staysafe.utilities.constants.CodeMessages;

public class YouAlreadyHaveAReservation extends BusinessException {

    private final static int CODE = 7;

    public YouAlreadyHaveAReservation() {
        super(CodeMessages.getMessage(CODE), CODE);
    }

}
