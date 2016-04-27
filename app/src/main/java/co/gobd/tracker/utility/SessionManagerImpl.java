package co.gobd.tracker.utility;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by fahad on 31-Mar-16.
 */

public class SessionManagerImpl implements SessionManager {

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    //Constructed by DAGGER

    public SessionManagerImpl(SharedPreferences prefs){
        this.sharedPreferences = prefs;

    }

    @Override
    public void clearAll(){
        sharedPreferences.edit().clear().commit();
    }


    @Override
    public String getUsername(){
        return sharedPreferences.getString(Constant.SharedPrefs.KEY_USERNAME,
                Constant.SharedPrefs.VALUE_DEFAULT_USERNAME);
    }
    @Override
    public void setUsername(String input){
        editor = sharedPreferences.edit();

        editor.putString(Constant.SharedPrefs.KEY_USERNAME, input);
        editor.apply();
    }

    @Override
    public String getPassword(){
        return sharedPreferences.getString(Constant.SharedPrefs.KEY_PASSWORD,
                Constant.SharedPrefs.VALUE_DEFAULT_PASSWORD);
    }

    @Override
    public void setPassword(String input) {
        editor = sharedPreferences.edit();

        editor.putString(Constant.SharedPrefs.KEY_PASSWORD, input);
        editor.apply();
    }

    @Override
    public String getToken(){
        return sharedPreferences.getString(Constant.SharedPrefs.KEY_TOKEN,
                Constant.SharedPrefs.VALUE_DEFAULT_TOKEN);
    }

    @Override
    public void setToken(String input) {
        editor = sharedPreferences.edit();

        editor.putString(Constant.SharedPrefs.KEY_TOKEN, input);
        editor.apply();
    }

    @Override
    public String getBearer(){
        return sharedPreferences.getString(Constant.SharedPrefs.KEY_BEARER,
                Constant.SharedPrefs.VALUE_DEFAULT_BEARER);
    }

    @Override
    public void setBearer(String input) {
        editor = sharedPreferences.edit();

        editor.putString(Constant.SharedPrefs.KEY_BEARER, input);
        editor.apply();
    }

    @Override
    public String getRefreshToken(){
        return sharedPreferences.getString(Constant.SharedPrefs.KEY_REFRESH_TOKEN,
                "default_refresh_token");
    }

    @Override
    public void setRefreshToken(String input) {
        editor = sharedPreferences.edit();

        editor.putString(Constant.SharedPrefs.KEY_REFRESH_TOKEN, input);
        editor.apply();
    }

    @Override
    public String getAssetId(){
        return sharedPreferences.getString(Constant.SharedPrefs.KEY_ASSET_ID,
                Constant.SharedPrefs.VALUE_DEFAULT_ASSET_ID);
    }

    @Override
    public void setAssetId(String input) {
        editor = sharedPreferences.edit();

        editor.putString(Constant.SharedPrefs.KEY_ASSET_ID, input);
        editor.apply();
    }
}