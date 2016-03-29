package co.gobd.tracker;

import android.telephony.TelephonyManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import co.gobd.tracker.utility.DeviceUtility;

import static org.mockito.Matchers.notNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by tonmoy on 26-Mar-16.
 */
@RunWith(MockitoJUnitRunner.class)
public class DeviceUtilityTest {

    @Mock
    DeviceUtility deviceUtility;

    @Mock
    TelephonyManager telephonyManager;

    @Test
    public void testGetImei() {
        if (when(deviceUtility.getImei(telephonyManager)) != null) {

        }

    }

}