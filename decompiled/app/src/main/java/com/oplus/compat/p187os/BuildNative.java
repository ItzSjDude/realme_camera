package com.oplus.compat.p187os;

import com.oplus.compat.p183b.p184a.UnSupportedApiVersionException;
import com.oplus.compat.p183b.p184a.VersionUtils;
import com.oplus.epona.Epona;
import com.oplus.epona.Request;
import com.oplus.epona.Response;

/* loaded from: classes2.dex */
public class BuildNative {
    private static final String COMPONENT_NAME = "android.os.Build";

    private BuildNative() {
    }

    public static String getSerial() throws UnSupportedApiVersionException {
        if (VersionUtils.m24888d()) {
            Response responseExecute = Epona.newCall(new Request.Builder().setComponentName(COMPONENT_NAME).setActionName("getSerial").build()).execute();
            if (responseExecute.isSuccessful()) {
                return responseExecute.getBundle().getString("result");
            }
            return null;
        }
        throw new UnSupportedApiVersionException();
    }
}
