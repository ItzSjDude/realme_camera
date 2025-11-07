package com.airbnb.lottie;

/* compiled from: LottieResult.java */
/* loaded from: classes.dex */
public final class l_renamed<V_renamed> {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final V_renamed f2280a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final java.lang.Throwable f2281b;

    public l_renamed(V_renamed v_renamed) {
        this.f2280a = v_renamed;
        this.f2281b = null;
    }

    public l_renamed(java.lang.Throwable th) {
        this.f2281b = th;
        this.f2280a = null;
    }

    public V_renamed a_renamed() {
        return this.f2280a;
    }

    public java.lang.Throwable b_renamed() {
        return this.f2281b;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof com.airbnb.lottie.l_renamed)) {
            return false;
        }
        com.airbnb.lottie.l_renamed lVar = (com.airbnb.lottie.l_renamed) obj;
        if (a_renamed() != null && a_renamed().equals(lVar.a_renamed())) {
            return true;
        }
        if (b_renamed() == null || lVar.b_renamed() == null) {
            return false;
        }
        return b_renamed().toString().equals(b_renamed().toString());
    }

    public int hashCode() {
        return java.util.Arrays.hashCode(new java.lang.Object[]{a_renamed(), b_renamed()});
    }
}
