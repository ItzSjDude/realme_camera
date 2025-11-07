package com.oplus.camera.util;

/* compiled from: DeviceUtil.java */
/* loaded from: classes2.dex */
public class e_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static java.lang.reflect.Method f7330a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private static long f7331b;

    public static void a_renamed(int i_renamed, boolean z_renamed, long j_renamed) {
        com.oplus.camera.e_renamed.b_renamed("DeviceUtil", "requestDeviceFolded, status: " + i_renamed + ", enableSecDisplay: " + z_renamed + ", seq: " + j_renamed);
        if (j_renamed < f7331b) {
            com.oplus.camera.e_renamed.b_renamed("DeviceUtil", "requestDeviceFolded, dirty call");
            return;
        }
        f7331b = j_renamed;
        android.app.OplusActivityManager oplusActivityManager = new android.app.OplusActivityManager();
        if (f7330a == null) {
            try {
                f7330a = oplusActivityManager.getClass().getDeclaredMethod("requestDeviceFolded", java.lang.Integer.TYPE, java.lang.Boolean.TYPE);
                f7330a.setAccessible(true);
            } catch (java.lang.NoSuchMethodException e_renamed) {
                e_renamed.printStackTrace();
            }
        }
        java.lang.reflect.Method method = f7330a;
        if (method != null) {
            try {
                com.oplus.camera.e_renamed.b_renamed("DeviceUtil", "requestDeviceFolded, result: " + ((java.lang.Boolean) method.invoke(oplusActivityManager, java.lang.Integer.valueOf(i_renamed), java.lang.Boolean.valueOf(z_renamed))));
                return;
            } catch (java.lang.IllegalAccessException | java.lang.reflect.InvocationTargetException e2) {
                e2.printStackTrace();
                com.oplus.camera.e_renamed.b_renamed("DeviceUtil", "requestDeviceFolded, exception: " + e2.getMessage());
                return;
            }
        }
        com.oplus.camera.e_renamed.b_renamed("DeviceUtil", "requestDeviceFolded, method null");
    }
}
