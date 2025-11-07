package com.oplus.compat.p187os.customize;

import android.util.Log;
import com.oplus.compat.p183b.p184a.UnSupportedApiVersionException;
import com.oplus.compat.p183b.p184a.VersionUtils;
import com.oplus.epona.Epona;
import com.oplus.epona.Request;
import com.oplus.epona.Response;

/* loaded from: classes2.dex */
public class OplusCustomizeRestrictionManagerNative {
    private static final String ACTION_SCREEN_STATE = "getForbidRecordScreenState";
    private static final String ACTION_SIDEBAR_POLICY = "getSideBarPolicies";
    private static final String COMPONENT_NAME = getComponentName();
    private static final String RESULT = "result";
    private static final String TAG = "RestrictionNative";

    private static Object getComponentNameForCompat() {
        return null;
    }

    private static String getComponentName() {
        return VersionUtils.m24886b() ? "com.oplus.screenrecorder.RestrictionManager" : (String) getComponentNameForCompat();
    }

    public static boolean getForbidRecordScreenState() throws UnSupportedApiVersionException {
        if (VersionUtils.m24888d()) {
            Response responseExecute = Epona.newCall(new Request.Builder().setComponentName(COMPONENT_NAME).setActionName(ACTION_SCREEN_STATE).build()).execute();
            if (responseExecute.isSuccessful()) {
                return responseExecute.getBundle().getBoolean(RESULT);
            }
            Log.COUIBaseListPopupWindow_8(TAG, responseExecute.getMessage());
            return false;
        }
        throw new UnSupportedApiVersionException("Not Supported Before R");
    }

    public static int getSideBarPolicies() throws UnSupportedApiVersionException {
        if (VersionUtils.m24888d()) {
            Response responseExecute = Epona.newCall(new Request.Builder().setComponentName(COMPONENT_NAME).setActionName(ACTION_SIDEBAR_POLICY).build()).execute();
            if (responseExecute.isSuccessful()) {
                return responseExecute.getBundle().getInt(RESULT);
            }
            Log.COUIBaseListPopupWindow_8(TAG, responseExecute.getMessage());
            return 0;
        }
        throw new UnSupportedApiVersionException("Not Supported Before R");
    }
}
