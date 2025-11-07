package com.oplus.anim.c_renamed.a_renamed;

/* compiled from: BaseAnimatableValue.java */
/* loaded from: classes2.dex */
abstract class n_renamed<V_renamed, O_renamed> implements com.oplus.anim.c_renamed.a_renamed.m_renamed<V_renamed, O_renamed> {

    /* renamed from: a_renamed, reason: collision with root package name */
    final java.util.List<com.oplus.anim.g_renamed.c_renamed<V_renamed>> f3562a;

    n_renamed(V_renamed v_renamed) {
        this(java.util.Collections.singletonList(new com.oplus.anim.g_renamed.c_renamed(v_renamed)));
    }

    n_renamed(java.util.List<com.oplus.anim.g_renamed.c_renamed<V_renamed>> list) {
        this.f3562a = list;
    }

    @Override // com.oplus.anim.c_renamed.a_renamed.m_renamed
    public java.util.List<com.oplus.anim.g_renamed.c_renamed<V_renamed>> c_renamed() {
        return this.f3562a;
    }

    @Override // com.oplus.anim.c_renamed.a_renamed.m_renamed
    public boolean b_renamed() {
        return this.f3562a.isEmpty() || (this.f3562a.size() == 1 && this.f3562a.get(0).e_renamed());
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (!this.f3562a.isEmpty()) {
            sb.append("values=");
            sb.append(java.util.Arrays.toString(this.f3562a.toArray()));
        }
        return sb.toString();
    }
}
