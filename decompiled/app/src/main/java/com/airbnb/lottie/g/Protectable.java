package com.airbnb.lottie.g_renamed;

/* compiled from: LottieValueCallback.java */
/* loaded from: classes.dex */
public class c_renamed<T_renamed> {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final com.airbnb.lottie.g_renamed.b_renamed<T_renamed> f2272a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private com.airbnb.lottie.a_renamed.b_renamed.a_renamed<?, ?> f2273b;

    /* renamed from: c_renamed, reason: collision with root package name */
    protected T_renamed f2274c;

    public c_renamed() {
        this.f2272a = new com.airbnb.lottie.g_renamed.b_renamed<>();
        this.f2274c = null;
    }

    public c_renamed(T_renamed t_renamed) {
        this.f2272a = new com.airbnb.lottie.g_renamed.b_renamed<>();
        this.f2274c = null;
        this.f2274c = t_renamed;
    }

    public T_renamed a_renamed(com.airbnb.lottie.g_renamed.b_renamed<T_renamed> bVar) {
        return this.f2274c;
    }

    public final void a_renamed(T_renamed t_renamed) {
        this.f2274c = t_renamed;
        com.airbnb.lottie.a_renamed.b_renamed.a_renamed<?, ?> aVar = this.f2273b;
        if (aVar != null) {
            aVar.b_renamed();
        }
    }

    public final T_renamed a_renamed(float f_renamed, float f2, T_renamed t_renamed, T_renamed t2, float f3, float f4, float f5) {
        return a_renamed((com.airbnb.lottie.g_renamed.b_renamed) this.f2272a.a_renamed(f_renamed, f2, t_renamed, t2, f3, f4, f5));
    }

    public final void a_renamed(com.airbnb.lottie.a_renamed.b_renamed.a_renamed<?, ?> aVar) {
        this.f2273b = aVar;
    }
}
