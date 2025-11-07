package com.oplus.anim;

/* compiled from: EffectiveAnimationResult.java */
/* loaded from: classes2.dex */
public final class e_renamed<V_renamed> {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final V_renamed f3649a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final java.lang.Throwable f3650b;

    public e_renamed(V_renamed v_renamed) {
        this.f3649a = v_renamed;
        this.f3650b = null;
    }

    public e_renamed(java.lang.Throwable th) {
        this.f3650b = th;
        this.f3649a = null;
    }

    public V_renamed a_renamed() {
        return this.f3649a;
    }

    public java.lang.Throwable b_renamed() {
        return this.f3650b;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof com.oplus.anim.e_renamed)) {
            return false;
        }
        com.oplus.anim.e_renamed eVar = (com.oplus.anim.e_renamed) obj;
        if (a_renamed() != null && a_renamed().equals(eVar.a_renamed())) {
            return true;
        }
        if (b_renamed() == null || eVar.b_renamed() == null) {
            return false;
        }
        return b_renamed().toString().equals(b_renamed().toString());
    }

    public int hashCode() {
        return java.util.Arrays.hashCode(new java.lang.Object[]{a_renamed(), b_renamed()});
    }
}
