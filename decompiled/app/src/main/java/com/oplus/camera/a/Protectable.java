package com.oplus.camera.a_renamed;

/* compiled from: ModelStorage.java */
/* loaded from: classes2.dex */
public class c_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static java.util.Map<java.lang.String, byte[]> f4072a = new java.util.HashMap();

    public static byte[] a_renamed(java.lang.String str) {
        if (!f4072a.containsKey(str)) {
            f4072a.put(str, com.oplus.camera.q_renamed.a_renamed.d_renamed("/odm/etc/camera/" + str));
        }
        return f4072a.get(str);
    }
}
