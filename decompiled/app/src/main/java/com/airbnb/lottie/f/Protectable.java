package com.airbnb.lottie.f_renamed;

/* compiled from: LogcatLogger.java */
/* loaded from: classes.dex */
public class c_renamed implements com.airbnb.lottie.i_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final java.util.Set<java.lang.String> f2252a = new java.util.HashSet();

    @Override // com.airbnb.lottie.i_renamed
    public void a_renamed(java.lang.String str) {
        c_renamed(str, null);
    }

    public void c_renamed(java.lang.String str, java.lang.Throwable th) {
        if (com.airbnb.lottie.c_renamed.f2048a) {
            android.util.Log.d_renamed("LOTTIE", str, th);
        }
    }

    @Override // com.airbnb.lottie.i_renamed
    public void b_renamed(java.lang.String str) {
        a_renamed(str, null);
    }

    @Override // com.airbnb.lottie.i_renamed
    public void a_renamed(java.lang.String str, java.lang.Throwable th) {
        if (f2252a.contains(str)) {
            return;
        }
        android.util.Log.w_renamed("LOTTIE", str, th);
        f2252a.add(str);
    }

    @Override // com.airbnb.lottie.i_renamed
    public void b_renamed(java.lang.String str, java.lang.Throwable th) {
        if (com.airbnb.lottie.c_renamed.f2048a) {
            android.util.Log.d_renamed("LOTTIE", str, th);
        }
    }
}
