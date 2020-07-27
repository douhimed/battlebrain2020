package org.sqli.staysafe.utilities.constants;

import java.util.HashMap;
import java.util.Map;

public final class CodeMessages {

    private static final Map<Integer, String> Messages;

    static {
        Messages = new HashMap<>();
        Messages.put(1, "Information does not exist");
        Messages.put(2,"No reservation exist via your team" );
        Messages.put(3, "Already reserved");
        Messages.put(4, "Space must have a number of seats");
        Messages.put(5, "Space must have a number of rows");
        Messages.put(6, "Space can support a team under {%d} members");
        Messages.put(7, "You already have a reservation");
        Messages.put(8, "All seats are reserved for space id : {%d}");
        Messages.put(9, "Seat not eligible");
        Messages.put(404, "Information does not existe");
    }
    
    public static String getMessage(int code){
        return Messages.containsKey(code) ? Messages.get(code) : "Server error, contact administration";
    }

}
