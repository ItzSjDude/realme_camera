package com.oplus.anim.g_renamed;

/* compiled from: EffectiveValueCallback.java */
/* loaded from: classes2.dex */
public class b_renamed<T_renamed> {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final com.oplus.anim.g_renamed.a_renamed<T_renamed> f3701a;

    /* renamed from: b_renamed, reason: collision with root package name */
    protected T_renamed f3702b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private com.oplus.anim.a_renamed.b_renamed.a_renamed<?, ?> f3703c;

    public b_renamed() {
        this.f3701a = new com.oplus.anim.g_renamed.a_renamed<>();
        this.f3702b = null;
    }

    public b_renamed(T_renamed t_renamed) {
        this.f3701a = new com.oplus.anim.g_renamed.a_renamed<>();
        this.f3702b = null;
        this.f3702b = t_renamed;
    }

    public T_renamed a_renamed(com.oplus.anim.g_renamed.a_renamed<T_renamed> aVar) {
        return this.f3702b;
    }

    public final T_renamed a_renamed(float f_renamed, float f2, T_renamed t_renamed, T_renamed t2, float f3, float f4, float f5) {
        return a_renamed(this.f3701a.a_renamed(f_renamed, f2, t_renamed, t2, f3, f4, f5));
    }

    public final void a_renamed(com.oplus.anim.a_renamed.b_renamed.a_renamed<?, ?> aVar) {
        this.f3703c = aVar;
    }
}
