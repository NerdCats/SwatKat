package co.gobd.tracker.utility;

import android.content.Context;
import android.telephony.TelephonyManager;

/**
 * Created by fahad on 24-Mar-16.
 */

public class DeviceUtility {

    private static final String TAG = "DeviceUtility";

    public static String getDeviceIMEI(Context context){

        TelephonyManager telephonyManager = (TelephonyManager)context.getSystemService(context.TELEPHONY_SERVICE);
        return telephonyManager.getDeviceId();

    }


}
