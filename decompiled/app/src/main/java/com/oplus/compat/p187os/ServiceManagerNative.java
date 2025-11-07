package com.oplus.compat.p187os;

import android.os.IBinder;
import android.os.ServiceManager;
import com.oplus.compat.p183b.p184a.UnSupportedApiVersionException;
import com.oplus.compat.p183b.p184a.VersionUtils;

/* loaded from: classes2.dex */
public class ServiceManagerNative {
    private static void addServiceCompat(String str, IBinder iBinder) {
    }

    private static Object getServiceQCompat(String str) {
        return null;
    }

    private ServiceManagerNative() {
    }

    public static IBinder checkService(String str) throws UnSupportedApiVersionException {
        if (VersionUtils.m24891g()) {
            return ServiceManager.checkService(str);
        }
        throw new UnSupportedApiVersionException("not supported before O");
    }

    public static IBinder getService(String str) throws UnSupportedApiVersionException {
        if (VersionUtils.m24895k()) {
            return ServiceManager.getService(str);
        }
        throw new UnSupportedApiVersionException("not supported before L");
    }

    public static void addService(String str, IBinder iBinder) throws UnSupportedApiVersionException {
        if (VersionUtils.m24890f()) {
            ServiceManager.addService(str, iBinder);
            return;
        }
        throw new UnSupportedApiVersionException("not supported before P");
    }
}
