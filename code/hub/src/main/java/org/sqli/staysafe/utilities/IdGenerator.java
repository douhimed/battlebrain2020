package org.sqli.staysafe.utilities;

import java.util.HashMap;
import java.util.Map;

public final class IdGenerator {

    private static Map<String, Long> ids = new HashMap<>();

    public static long generate(String key){
        if(!IdGenerator.ids.containsKey(key))
            IdGenerator.ids.put(key, 0L);
        long id = IdGenerator.ids.get(key);
        IdGenerator.ids.put(key, ++id);
        return id;
    }

}
