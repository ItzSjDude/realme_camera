package com.oplus.d_renamed.b_renamed;

/* compiled from: OplusVersionUtils.java */
/* loaded from: classes2.dex */
public class a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static final boolean f7501a = a_renamed();

    private static boolean a_renamed() throws java.lang.ClassNotFoundException {
        java.lang.Class<?> cls;
        try {
            cls = java.lang.Class.forName("com.oplus.os.OplusBuild");
        } catch (java.lang.Exception e_renamed) {
            android.util.Log.w_renamed("OplusVersionUtils", "isOsVersion_11_3: " + e_renamed.toString());
        }
        return ((java.lang.Integer) cls.getMethod("getOplusOSVERSION", new java.lang.Class[0]).invoke(null, new java.lang.Object[0])).intValue() >= ((java.lang.Integer) cls.getField("OplusOS_11_3").get(null)).intValue();
    }
}
