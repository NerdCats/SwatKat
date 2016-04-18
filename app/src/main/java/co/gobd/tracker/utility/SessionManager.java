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

    private SharedPreferences sharedPreferences;
    private static String PREFERENCE_NAME = "GOFetchAsset";

    public SessionManager(){

    }


    private SharedPreferences getPrefs(Context context){
        return context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
    }

    public String getUsername(Context context){
        return getPrefs(context).getString(SharedPreferenceConstant.USERNAME, "default_username");
    }

    public void setUsername(Context context, String input){
        SharedPreferences.Editor editor = getPrefs(context).edit();

        editor.putString(SharedPreferenceConstant.USERNAME, input);
        editor.apply();
    }

    public String getPassword(Context context){
        return getPrefs(context).getString(SharedPreferenceConstant.PASSWORD, "default_password");
    }

    public void setPassword(Context context, String input) {
        SharedPreferences.Editor editor = getPrefs(context).edit();

        editor.putString(SharedPreferenceConstant.PASSWORD, input);
        editor.apply();
    }

    public String getToken(Context context){
        return getPrefs(context).getString(SharedPreferenceConstant.TOKEN, "default_token");
    }

    public void setToken(Context context, String input) {
        SharedPreferences.Editor editor = getPrefs(context).edit();

        editor.putString(SharedPreferenceConstant.TOKEN, input);
        editor.apply();
    }

    public String getBearer(Context context){
        return getPrefs(context).getString(SharedPreferenceConstant.BEARER, "default_bearer");
    }

    public void setBearer(Context context, String input) {
        SharedPreferences.Editor editor = getPrefs(context).edit();

        editor.putString(SharedPreferenceConstant.BEARER, input);
        editor.apply();
    }

    public String getRefreshToken(Context context){
        return getPrefs(context).getString(SharedPreferenceConstant.REFRESH_TOKEN,
                "default_refresh_token");
    }

    public void setRefreshToken(Context context, String input) {
        SharedPreferences.Editor editor = getPrefs(context).edit();

        editor.putString(SharedPreferenceConstant.REFRESH_TOKEN, input);
        editor.apply();
    }

    public String getAssetId(Context context){
        return getPrefs(context).getString(SharedPreferenceConstant.ASSET_ID, "default_asset_id");
    }

    public void setAssetId(Context context, String input) {
        SharedPreferences.Editor editor = getPrefs(context).edit();

        editor.putString(SharedPreferenceConstant.ASSET_ID, input);
        editor.apply();
    }
}