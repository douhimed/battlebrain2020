package org.sqli.staysafe.utilities.exceptions;

import org.sqli.staysafe.utilities.constants.CodeMessages;

public class DonneeRechercheeNexistePas extends BusinessException{


    private final static int CODE = 1;

    public DonneeRechercheeNexistePas() {
        super(CodeMessages.getMessage(CODE), CODE);
    }
}
