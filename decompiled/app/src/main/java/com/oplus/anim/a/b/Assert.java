package com.oplus.anim.a_renamed.b_renamed;

/* compiled from: BaseKeyframeAnimation.java */
/* loaded from: classes2.dex */
public abstract class a_renamed<K_renamed, A_renamed> {

    /* renamed from: b_renamed, reason: collision with root package name */
    protected com.oplus.anim.g_renamed.b_renamed<A_renamed> f3499b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final java.util.List<? extends com.oplus.anim.g_renamed.c_renamed<K_renamed>> f3500c;
    private com.oplus.anim.g_renamed.c_renamed<K_renamed> f_renamed;
    private com.oplus.anim.g_renamed.c_renamed<K_renamed> g_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    final java.util.List<com.oplus.anim.a_renamed.b_renamed.a_renamed.BaseKeyframeAnimation_2> f3498a = new java.util.ArrayList(1);
    private boolean d_renamed = false;
    private float e_renamed = 0.0f;
    private float h_renamed = -1.0f;
    private A_renamed i_renamed = null;
    private float j_renamed = -1.0f;
    private float k_renamed = -1.0f;

    /* compiled from: BaseKeyframeAnimation.java */
    /* renamed from: com.oplus.anim.a_renamed.b_renamed.a_renamed$a_renamed, reason: collision with other inner class name */
    public interface BaseKeyframeAnimation_2 {
        void a_renamed();
    }

    abstract A_renamed a_renamed(com.oplus.anim.g_renamed.c_renamed<K_renamed> cVar, float f_renamed);

    a_renamed(java.util.List<? extends com.oplus.anim.g_renamed.c_renamed<K_renamed>> list) {
        this.f3500c = list;
    }

    public void a_renamed() {
        this.d_renamed = true;
    }

    public void a_renamed(com.oplus.anim.a_renamed.b_renamed.a_renamed.BaseKeyframeAnimation_2 interfaceC0077a) {
        this.f3498a.add(interfaceC0077a);
    }

    public void b_renamed() {
        for (int i_renamed = 0; i_renamed < this.f3498a.size(); i_renamed++) {
            this.f3498a.get(i_renamed).a_renamed();
        }
    }

    protected com.oplus.anim.g_renamed.c_renamed<K_renamed> c_renamed() {
        com.oplus.anim.g_renamed.c_renamed<K_renamed> cVar = this.f_renamed;
        if (cVar != null && cVar.a_renamed(this.e_renamed)) {
            return this.f_renamed;
        }
        com.oplus.anim.g_renamed.c_renamed<K_renamed> cVar2 = this.f3500c.get(r0.size() - 1);
        if (this.e_renamed < cVar2.c_renamed()) {
            for (int size = this.f3500c.size() - 1; size >= 0; size--) {
                cVar2 = this.f3500c.get(size);
                if (cVar2.a_renamed(this.e_renamed)) {
                    break;
                }
            }
        }
        this.f_renamed = cVar2;
        return cVar2;
    }

    float d_renamed() {
        if (this.d_renamed) {
            return 0.0f;
        }
        com.oplus.anim.g_renamed.c_renamed<K_renamed> cVarC = c_renamed();
        if (cVarC.e_renamed()) {
            return 0.0f;
        }
        return (this.e_renamed - cVarC.c_renamed()) / (cVarC.d_renamed() - cVarC.c_renamed());
    }

    protected float e_renamed() {
        com.oplus.anim.g_renamed.c_renamed<K_renamed> cVarC = c_renamed();
        if (cVarC.e_renamed()) {
            return 0.0f;
        }
        return cVarC.f3705b.getInterpolation(d_renamed());
    }

    private float i_renamed() {
        if (this.j_renamed == -1.0f) {
            this.j_renamed = this.f3500c.isEmpty() ? 0.0f : this.f3500c.get(0).c_renamed();
        }
        return this.j_renamed;
    }

    float f_renamed() {
        float fD_renamed;
        if (this.k_renamed == -1.0f) {
            if (this.f3500c.isEmpty()) {
                fD_renamed = 1.0f;
            } else {
                fD_renamed = this.f3500c.get(r0.size() - 1).d_renamed();
            }
            this.k_renamed = fD_renamed;
        }
        return this.k_renamed;
    }

    public A_renamed g_renamed() {
        com.oplus.anim.g_renamed.c_renamed<K_renamed> cVarC = c_renamed();
        float fE_renamed = e_renamed();
        if (this.f3499b == null && cVarC == this.g_renamed && this.h_renamed == fE_renamed) {
            return this.i_renamed;
        }
        this.g_renamed = cVarC;
        this.h_renamed = fE_renamed;
        A_renamed a2 = a_renamed(cVarC, fE_renamed);
        this.i_renamed = a2;
        return a2;
    }

    public float h_renamed() {
        return this.e_renamed;
    }

    public void a_renamed(float f_renamed) {
        if (this.f3500c.isEmpty()) {
            return;
        }
        com.oplus.anim.g_renamed.c_renamed<K_renamed> cVarC = c_renamed();
        if (f_renamed < i_renamed()) {
            f_renamed = i_renamed();
        } else if (f_renamed > f_renamed()) {
            f_renamed = f_renamed();
        }
        if (f_renamed == this.e_renamed) {
            return;
        }
        this.e_renamed = f_renamed;
        com.oplus.anim.g_renamed.c_renamed<K_renamed> cVarC2 = c_renamed();
        if (cVarC == cVarC2 && cVarC2.e_renamed()) {
            return;
        }
        b_renamed();
    }

    public void a_renamed(com.oplus.anim.g_renamed.b_renamed<A_renamed> bVar) {
        com.oplus.anim.g_renamed.b_renamed<A_renamed> bVar2 = this.f3499b;
        if (bVar2 != null) {
            bVar2.a_renamed((com.oplus.anim.a_renamed.b_renamed.a_renamed<?, ?>) null);
        }
        this.f3499b = bVar;
        if (bVar != null) {
            bVar.a_renamed((com.oplus.anim.a_renamed.b_renamed.a_renamed<?, ?>) this);
        }
    }
}
