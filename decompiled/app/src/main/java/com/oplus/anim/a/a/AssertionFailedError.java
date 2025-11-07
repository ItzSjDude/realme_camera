package com.oplus.anim.a_renamed.a_renamed;

/* compiled from: CompoundTrimPathContent.java */
/* loaded from: classes2.dex */
public class b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private java.util.List<com.oplus.anim.a_renamed.a_renamed.s_renamed> f3461a = new java.util.ArrayList();

    void a_renamed(com.oplus.anim.a_renamed.a_renamed.s_renamed sVar) {
        this.f3461a.add(sVar);
    }

    public void a_renamed(android.graphics.Path path) {
        for (int size = this.f3461a.size() - 1; size >= 0; size--) {
            com.oplus.anim.f_renamed.g_renamed.a_renamed(path, this.f3461a.get(size));
        }
    }
}
