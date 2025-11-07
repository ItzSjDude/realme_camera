package com.oplus.compat.os;

/* loaded from: classes2.dex */
public class ServiceManagerNative {
    private static void addServiceCompat(java.lang.String str, android.os.IBinder iBinder) {
    }

    private static java.lang.Object getServiceQCompat(java.lang.String str) {
        return null;
    }

    private ServiceManagerNative() {
    }

    public static android.os.IBinder checkService(java.lang.String str) throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.g_renamed()) {
            return android.os.ServiceManager.checkService(str);
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed("not supported before O_renamed");
    }

    public static android.os.IBinder getService(java.lang.String str) throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.k_renamed()) {
            return android.os.ServiceManager.getService(str);
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed("not supported before L_renamed");
    }

    public static void addService(java.lang.String str, android.os.IBinder iBinder) throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.f_renamed()) {
            android.os.ServiceManager.addService(str, iBinder);
            return;
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed("not supported before P_renamed");
    }
}
