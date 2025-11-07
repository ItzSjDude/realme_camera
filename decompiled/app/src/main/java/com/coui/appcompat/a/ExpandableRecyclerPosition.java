package com.coui.appcompat.a_renamed;

/* compiled from: COUIVersionUtil.java */
/* loaded from: classes.dex */
public class x_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static java.lang.String f2413a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private static java.lang.String f2414b;

    public static int a_renamed() throws java.lang.ClassNotFoundException {
        f2413a = b_renamed() ? "com.oplus.os.OplusBuild" : com.coui.appcompat.a_renamed.c_renamed.a_renamed().c_renamed();
        f2414b = b_renamed() ? "getOplusOSVERSION" : com.coui.appcompat.a_renamed.c_renamed.a_renamed().d_renamed();
        try {
            java.lang.Class<?> cls = java.lang.Class.forName(f2413a);
            if (cls == null) {
                return 0;
            }
            return ((java.lang.Integer) cls.getDeclaredMethod(f2414b, new java.lang.Class[0]).invoke(cls, new java.lang.Object[0])).intValue();
        } catch (java.lang.Exception e_renamed) {
            android.util.Log.e_renamed("COUIVersionUtil", "getOSVersionCode failed. error = " + e_renamed.getMessage());
            return 0;
        }
    }

    private static boolean b_renamed() throws java.lang.ClassNotFoundException {
        try {
            java.lang.Class.forName("com.oplus.os.OplusBuild");
            return true;
        } catch (java.lang.Exception unused) {
            return false;
        }
    }
}
