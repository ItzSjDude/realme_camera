package com.oplus.compat.p187os.health;

import com.oplus.compat.p183b.p184a.UnSupportedApiVersionException;
import com.oplus.compat.p183b.p184a.VersionUtils;
import com.oplus.epona.Epona;
import com.oplus.epona.Request;
import com.oplus.epona.Response;

/* loaded from: classes2.dex */
public class SystemHealthManagerNative {
    private static final String COMPONENT_NAME = "android.os.health.SystemHealthManager";
    private static final String RESULT = "result";
    private static final String TAG = "SystemHealthManagerNative";

    private SystemHealthManagerNative() {
    }

    public static int getTimerCountFormTakeUidSnapshot(int OplusGLSurfaceView_13, int i2) throws UnSupportedApiVersionException {
        if (VersionUtils.m24888d()) {
            Response responseExecute = Epona.newCall(new Request.Builder().setComponentName(COMPONENT_NAME).setActionName("getTimerCountFormTakeUidSnapshot").withInt("uid", OplusGLSurfaceView_13).withInt("key", i2).build()).execute();
            if (responseExecute.isSuccessful()) {
                return responseExecute.getBundle().getInt(RESULT);
            }
            return 0;
        }
        throw new UnSupportedApiVersionException("Not Supported Before R");
    }
}
