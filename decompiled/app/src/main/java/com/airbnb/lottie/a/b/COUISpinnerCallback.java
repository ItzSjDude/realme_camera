package com.airbnb.lottie.a_renamed.b_renamed;

/* compiled from: ValueCallbackKeyframeAnimation.java */
/* loaded from: classes.dex */
public class p_renamed<K_renamed, A_renamed> extends com.airbnb.lottie.a_renamed.b_renamed.a_renamed<K_renamed, A_renamed> {
    private final com.airbnb.lottie.g_renamed.b_renamed<A_renamed> d_renamed;
    private final A_renamed e_renamed;

    @Override // com.airbnb.lottie.a_renamed.b_renamed.a_renamed
    float f_renamed() {
        return 1.0f;
    }

    public p_renamed(com.airbnb.lottie.g_renamed.c_renamed<A_renamed> cVar) {
        this(cVar, null);
    }

    public p_renamed(com.airbnb.lottie.g_renamed.c_renamed<A_renamed> cVar, A_renamed a2) {
        super(java.util.Collections.emptyList());
        this.d_renamed = new com.airbnb.lottie.g_renamed.b_renamed<>();
        a_renamed(cVar);
        this.e_renamed = a2;
    }

    @Override // com.airbnb.lottie.a_renamed.b_renamed.a_renamed
    public void a_renamed(float f_renamed) {
        this.f2029b = f_renamed;
    }

    @Override // com.airbnb.lottie.a_renamed.b_renamed.a_renamed
    public void b_renamed() {
        if (this.f2030c != null) {
            super.b_renamed();
        }
    }

    @Override // com.airbnb.lottie.a_renamed.b_renamed.a_renamed
    public A_renamed g_renamed() {
        com.airbnb.lottie.g_renamed.c_renamed<A_renamed> cVar = this.f2030c;
        A_renamed a2 = this.e_renamed;
        return cVar.a_renamed(0.0f, 0.0f, a2, a2, h_renamed(), h_renamed(), h_renamed());
    }

    @Override // com.airbnb.lottie.a_renamed.b_renamed.a_renamed
    A_renamed a_renamed(com.airbnb.lottie.g_renamed.a_renamed<K_renamed> aVar, float f_renamed) {
        return g_renamed();
    }
}
