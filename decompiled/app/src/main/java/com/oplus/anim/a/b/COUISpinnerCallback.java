package com.oplus.anim.a_renamed.b_renamed;

/* compiled from: ValueCallbackKeyframeAnimation.java */
/* loaded from: classes2.dex */
public class p_renamed<K_renamed, A_renamed> extends com.oplus.anim.a_renamed.b_renamed.a_renamed<K_renamed, A_renamed> {

    /* renamed from: c_renamed, reason: collision with root package name */
    private final com.oplus.anim.g_renamed.a_renamed<A_renamed> f3513c;
    private final A_renamed d_renamed;

    @Override // com.oplus.anim.a_renamed.b_renamed.a_renamed
    float f_renamed() {
        return 1.0f;
    }

    public p_renamed(com.oplus.anim.g_renamed.b_renamed<A_renamed> bVar) {
        this(bVar, null);
    }

    public p_renamed(com.oplus.anim.g_renamed.b_renamed<A_renamed> bVar, A_renamed a2) {
        super(java.util.Collections.emptyList());
        this.f3513c = new com.oplus.anim.g_renamed.a_renamed<>();
        a_renamed(bVar);
        this.d_renamed = a2;
    }

    @Override // com.oplus.anim.a_renamed.b_renamed.a_renamed
    public void b_renamed() {
        if (this.f3499b != null) {
            super.b_renamed();
        }
    }

    @Override // com.oplus.anim.a_renamed.b_renamed.a_renamed
    public A_renamed g_renamed() {
        com.oplus.anim.g_renamed.b_renamed<A_renamed> bVar = this.f3499b;
        A_renamed a2 = this.d_renamed;
        return bVar.a_renamed(0.0f, 0.0f, a2, a2, h_renamed(), h_renamed(), h_renamed());
    }

    @Override // com.oplus.anim.a_renamed.b_renamed.a_renamed
    A_renamed a_renamed(com.oplus.anim.g_renamed.c_renamed<K_renamed> cVar, float f_renamed) {
        return g_renamed();
    }
}
