package org.sqli.staysafe.utilities.exceptions;

import org.sqli.staysafe.utilities.constants.CodeMessages;

public class OnlySeatsDisponibleException extends BusinessException {

    private final static int CODE = 6;


    public OnlySeatsDisponibleException(int number) {
        super(String.format(CodeMessages.getMessage(CODE), number), CODE);    }

}
