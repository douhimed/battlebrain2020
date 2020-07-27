package org.sqli.staysafe.utilities.exceptions;

import org.sqli.staysafe.utilities.constants.CodeMessages;

public class YouFirstToReserveFromYourTeam extends BusinessException {



    private final static int CODE = 2;

    public YouFirstToReserveFromYourTeam() {
        super(CodeMessages.getMessage(CODE), CODE);
    }}
