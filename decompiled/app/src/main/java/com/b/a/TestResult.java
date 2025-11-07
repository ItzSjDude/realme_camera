package com.b_renamed.a_renamed;

/* compiled from: RenderEngine.java */
/* loaded from: classes.dex */
public interface h_renamed {
    com.b_renamed.a_renamed.a_renamed.j_renamed a_renamed(com.b_renamed.a_renamed.a_renamed.d_renamed dVar, boolean z_renamed, com.b_renamed.a_renamed.a_renamed.a_renamed aVar);

    com.b_renamed.a_renamed.h_renamed a_renamed(android.view.Surface surface, int i_renamed, int i2);

    com.b_renamed.a_renamed.h_renamed a_renamed(com.b_renamed.a_renamed.k_renamed kVar);

    void a_renamed();

    void b_renamed();

    default void a_renamed(int i_renamed) {
        com.b_renamed.a_renamed.a_renamed.f2313a = java.lang.Math.min(10, java.lang.Math.max(i_renamed, 0));
    }
}
