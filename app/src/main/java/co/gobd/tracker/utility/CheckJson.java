package co.gobd.tracker.utility;

import com.google.gson.JsonObject;

/**
 * Created by fahad on 10/25/16.
 */

public class CheckJson {

    public static boolean checkJsonKey(JsonObject jsonObject, String key){

        boolean exists = jsonObject.has(key);
        return exists;
    }
}
