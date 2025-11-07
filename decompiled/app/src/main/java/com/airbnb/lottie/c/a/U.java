package com.airbnb.lottie.c_renamed.a_renamed;

/* compiled from: BaseAnimatableValue.java */
/* loaded from: classes.dex */
abstract class n_renamed<V_renamed, O_renamed> implements com.airbnb.lottie.c_renamed.a_renamed.m_renamed<V_renamed, O_renamed> {

    /* renamed from: a_renamed, reason: collision with root package name */
    final java.util.List<com.airbnb.lottie.g_renamed.a_renamed<V_renamed>> f2064a;

    n_renamed(V_renamed v_renamed) {
        this(java.util.Collections.singletonList(new com.airbnb.lottie.g_renamed.a_renamed(v_renamed)));
    }

    n_renamed(java.util.List<com.airbnb.lottie.g_renamed.a_renamed<V_renamed>> list) {
        this.f2064a = list;
    }

    @Override // com.airbnb.lottie.c_renamed.a_renamed.m_renamed
    public java.util.List<com.airbnb.lottie.g_renamed.a_renamed<V_renamed>> c_renamed() {
        return this.f2064a;
    }

    @Override // com.airbnb.lottie.c_renamed.a_renamed.m_renamed
    public boolean b_renamed() {
        return this.f2064a.isEmpty() || (this.f2064a.size() == 1 && this.f2064a.get(0).e_renamed());
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (!this.f2064a.isEmpty()) {
            sb.append("values=");
            sb.append(java.util.Arrays.toString(this.f2064a.toArray()));
        }
        return sb.toString();
    }
}
