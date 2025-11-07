package com.oplus.compat.p187os;

import android.os.PowerSaveState;
import com.oplus.compat.p183b.p184a.UnSupportedApiVersionException;
import com.oplus.compat.p183b.p184a.VersionUtils;
import com.oplus.epona.Epona;
import com.oplus.epona.Request;
import com.oplus.epona.Response;

/* loaded from: classes2.dex */
public class PowerSaveStateNative {
    private static final String COMPONENT_NAME = "android.os.PowerSaveState";
    private static final String RESULT = "result";
    private static final String TAG = "PowerSaveStateNative";

    private PowerSaveStateNative() {
    }

    public static boolean getBatterySaverEnabled(PowerSaveState powerSaveState) throws UnSupportedApiVersionException {
        if (VersionUtils.m24888d()) {
            Response responseExecute = Epona.newCall(new Request.Builder().setComponentName(COMPONENT_NAME).setActionName("batterySaverEnabled").withParcelable("powerSaveState", powerSaveState).build()).execute();
            if (responseExecute.isSuccessful()) {
                return responseExecute.getBundle().getBoolean(RESULT);
            }
            return false;
        }
        throw new UnSupportedApiVersionException("Not Supported Before R");
    }
}
