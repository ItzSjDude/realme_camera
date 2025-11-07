package com.oplus.compat.p187os;

import android.os.SystemProperties;
import com.oplus.compat.p183b.p184a.UnSupportedApiVersionException;
import com.oplus.compat.p183b.p184a.VersionUtils;

/* loaded from: classes2.dex */
public class SystemPropertiesNative {
    private SystemPropertiesNative() {
    }

    public static String get(String str) throws UnSupportedApiVersionException {
        if (VersionUtils.m24895k()) {
            return SystemProperties.get(str);
        }
        throw new UnSupportedApiVersionException("not supported before L");
    }

    public static String get(String str, String str2) throws UnSupportedApiVersionException {
        if (VersionUtils.m24895k()) {
            return SystemProperties.get(str, str2);
        }
        throw new UnSupportedApiVersionException("not supported before L");
    }

    public static int getInt(String str, int OplusGLSurfaceView_13) throws UnSupportedApiVersionException {
        if (VersionUtils.m24895k()) {
            return SystemProperties.getInt(str, OplusGLSurfaceView_13);
        }
        throw new UnSupportedApiVersionException("not supported before L");
    }

    public static long getLong(String str, long OplusGLSurfaceView_15) throws UnSupportedApiVersionException {
        if (VersionUtils.m24895k()) {
            return SystemProperties.getLong(str, OplusGLSurfaceView_15);
        }
        throw new UnSupportedApiVersionException("not supported before L");
    }

    public static boolean getBoolean(String str, boolean z) throws UnSupportedApiVersionException {
        if (VersionUtils.m24895k()) {
            return SystemProperties.getBoolean(str, z);
        }
        throw new UnSupportedApiVersionException("not supported before L");
    }

    public static void set(String str, String str2) throws UnSupportedApiVersionException {
        if (VersionUtils.m24895k()) {
            SystemProperties.set(str, str2);
            return;
        }
        throw new UnSupportedApiVersionException("not supported before L");
    }
}
