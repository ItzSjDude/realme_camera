package com.oplus.shield.b_renamed;

/* compiled from: DebugUtils.java */
/* loaded from: classes2.dex */
public class c_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static volatile com.oplus.shield.b_renamed.c_renamed f7631a = null;

    /* renamed from: c_renamed, reason: collision with root package name */
    private static boolean f7632c = true;
    private static boolean d_renamed;

    /* renamed from: b_renamed, reason: collision with root package name */
    private boolean f7633b = false;

    private c_renamed() {
    }

    public boolean a_renamed() {
        return !f7632c && d_renamed;
    }

    public static com.oplus.shield.b_renamed.c_renamed b_renamed() {
        if (f7631a == null) {
            synchronized (com.oplus.shield.b_renamed.c_renamed.class) {
                if (f7631a == null) {
                    f7631a = new com.oplus.shield.b_renamed.c_renamed();
                }
            }
        }
        return f7631a;
    }
}
