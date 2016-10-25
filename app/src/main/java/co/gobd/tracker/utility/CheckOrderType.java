package co.gobd.tracker.utility;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;

/**
 * Created by fahad on 10/25/16.
 */

public class CheckOrderType {
    public boolean keyExists(JSONObject  object, String searchKey) throws JSONException {
        boolean exists = object.has(searchKey);
        if(!exists) {
            Iterator<?> keys = object.keys();
            while( keys.hasNext() ) {
                String key = (String)keys.next();
                if ( object.get(key) instanceof JSONObject) {
                    exists = keyExists((JSONObject) object.get(key), searchKey);
                }
            }
        }
        return exists;
    }
}
