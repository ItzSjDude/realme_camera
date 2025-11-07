package com.oplus.compat.p187os;

import android.os.SystemProperties;
import com.oplus.compat.p183b.p184a.UnSupportedApiVersionException;
import com.oplus.compat.p183b.p184a.VersionUtils;
import com.oplus.epona.Epona;
import com.oplus.epona.Request;
import com.oplus.epona.Response;

/* loaded from: classes2.dex */
public class OplusSystemPropertiesNative {
    private static final String COMPONENT_NAME = "android.os.OplusSystemProperties";
    private static final String RESULT = "result";

    public static String get(String str) throws UnSupportedApiVersionException {
        return get(str, "");
    }

    public static String get(String str, String str2) throws Throwable {
        if (VersionUtils.m24888d()) {
            Response responseExecute = Epona.newCall(new Request.Builder().setComponentName(COMPONENT_NAME).setActionName("get").withString("key", str).withString("def", str2).build()).execute();
            if (responseExecute.isSuccessful()) {
                return responseExecute.getBundle().getString(RESULT);
            }
            responseExecute.checkThrowable(IllegalArgumentException.class);
            return str2;
        }
        if (VersionUtils.m24889e()) {
            return SystemProperties.get(str, str2);
        }
        throw new UnSupportedApiVersionException("not supported before Q");
    }

    public static int getInt(String str, int OplusGLSurfaceView_13) throws Throwable {
        if (VersionUtils.m24888d()) {
            Response responseExecute = Epona.newCall(new Request.Builder().setComponentName(COMPONENT_NAME).setActionName("getInt").withString("key", str).withInt("def", OplusGLSurfaceView_13).build()).execute();
            if (responseExecute.isSuccessful()) {
                return responseExecute.getBundle().getInt(RESULT);
            }
            responseExecute.checkThrowable(IllegalArgumentException.class);
            return OplusGLSurfaceView_13;
        }
        if (VersionUtils.m24889e()) {
            return SystemProperties.getInt(str, OplusGLSurfaceView_13);
        }
        throw new UnSupportedApiVersionException("not supported before Q");
    }

    public static long getLong(String str, long OplusGLSurfaceView_15) throws Throwable {
        if (VersionUtils.m24888d()) {
            Response responseExecute = Epona.newCall(new Request.Builder().setComponentName(COMPONENT_NAME).setActionName("getLong").withString("key", str).withLong("def", OplusGLSurfaceView_15).build()).execute();
            if (responseExecute.isSuccessful()) {
                return responseExecute.getBundle().getLong(RESULT);
            }
            responseExecute.checkThrowable(IllegalArgumentException.class);
            return OplusGLSurfaceView_15;
        }
        if (VersionUtils.m24889e()) {
            return SystemProperties.getLong(str, OplusGLSurfaceView_15);
        }
        throw new UnSupportedApiVersionException("not supported before Q");
    }

    public static boolean getBoolean(String str, Boolean bool) throws Throwable {
        if (VersionUtils.m24888d()) {
            Response responseExecute = Epona.newCall(new Request.Builder().setComponentName(COMPONENT_NAME).setActionName("getBoolean").withString("key", str).withBoolean("def", bool.booleanValue()).build()).execute();
            if (responseExecute.isSuccessful()) {
                return responseExecute.getBundle().getBoolean(RESULT);
            }
            responseExecute.checkThrowable(IllegalArgumentException.class);
            return bool.booleanValue();
        }
        if (VersionUtils.m24889e()) {
            return SystemProperties.getBoolean(str, bool.booleanValue());
        }
        throw new UnSupportedApiVersionException("not supported before Q");
    }

    public static void notifyInitCotaDownloaded() throws Throwable {
        if (VersionUtils.m24888d()) {
            Response responseExecute = Epona.newCall(new Request.Builder().setComponentName(COMPONENT_NAME).setActionName("notifyInitCotaDownloaded").build()).execute();
            if (responseExecute.isSuccessful()) {
                return;
            }
            responseExecute.checkThrowable(IllegalArgumentException.class);
            return;
        }
        throw new UnSupportedApiVersionException("not supported before R");
    }
}
