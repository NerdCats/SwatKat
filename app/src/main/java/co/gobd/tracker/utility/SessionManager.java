package co.gobd.tracker.utility;

import java.util.HashMap;

import android.content.Intent;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import co.gobd.tracker.ui.LoginActivity;

/**
 * Created by fahad on 31-Mar-16.
 */

public class SessionManager {

    SharedPreferences sharedPreferences;
    Editor editor;
    Context context;

    int PRIVATE_MODE = 0;

    private static final String PREFERENCE_NAME = "GOFetch";
    private static final String LOGIN_STATE = "state";
    public static final String NAME = "uname";
    public static final String PASS = "upass";
    //public static final String CLIENT_KEY = "clientkey";

    public SessionManager(Context context){
        this.context = context;
        sharedPreferences = context.getSharedPreferences(PREFERENCE_NAME, PRIVATE_MODE);
        editor = sharedPreferences.edit();
    }

    public void createLoginSession(String name, String pass) {
        editor.putBoolean(LOGIN_STATE, true);
        editor.putString(NAME, name);
        editor.putString(PASS, pass);
        editor.commit();
    }

    public HashMap<String, String> getCredentials(){

        HashMap<String , String> user = new HashMap<String, String >();

        user.put(NAME, sharedPreferences.getString(NAME, null));
        user.put(PASS, sharedPreferences.getString(PASS, null));

        return user;
    }

    public boolean state(){
        return sharedPreferences.getBoolean(LOGIN_STATE, false);
    }

    public void checkLogin(){
        if(!this.state()){

            Intent intent = new Intent(context, LoginActivity.class);

            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            context.startActivity(intent);
        }
    }

    public void logout(){

        editor.clear();
        editor.commit();

        Intent intent = new Intent(context, LoginActivity.class);

        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        context.startActivity(intent);
    }


}