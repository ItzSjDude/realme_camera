package com.oplus.compat.os.customize;

/* loaded from: classes2.dex */
public class OplusCustomizeRestrictionManagerNative {
    private static final java.lang.String ACTION_SCREEN_STATE = "getForbidRecordScreenState";
    private static final java.lang.String ACTION_SIDEBAR_POLICY = "getSideBarPolicies";
    private static final java.lang.String COMPONENT_NAME = getComponentName();
    private static final java.lang.String RESULT = "result";
    private static final java.lang.String TAG = "RestrictionNative";

    private static java.lang.Object getComponentNameForCompat() {
        return null;
    }

    private static java.lang.String getComponentName() {
        return com.oplus.compat.b_renamed.a_renamed.c_renamed.b_renamed() ? "com.oplus.screenrecorder.RestrictionManager" : (java.lang.String) getComponentNameForCompat();
    }

    public static boolean getForbidRecordScreenState() throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.d_renamed()) {
            com.oplus.epona.Response responseExecute = com.oplus.epona.Epona.newCall(new com.oplus.epona.Request.Builder().setComponentName(COMPONENT_NAME).setActionName(ACTION_SCREEN_STATE).build()).execute();
            if (responseExecute.isSuccessful()) {
                return responseExecute.getBundle().getBoolean(RESULT);
            }
            android.util.Log.e_renamed(TAG, responseExecute.getMessage());
            return false;
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed("Not Supported Before R_renamed");
    }

    public static int getSideBarPolicies() throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.d_renamed()) {
            com.oplus.epona.Response responseExecute = com.oplus.epona.Epona.newCall(new com.oplus.epona.Request.Builder().setComponentName(COMPONENT_NAME).setActionName(ACTION_SIDEBAR_POLICY).build()).execute();
            if (responseExecute.isSuccessful()) {
                return responseExecute.getBundle().getInt(RESULT);
            }
            android.util.Log.e_renamed(TAG, responseExecute.getMessage());
            return 0;
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed("Not Supported Before R_renamed");
    }
}
