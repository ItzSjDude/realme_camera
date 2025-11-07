package com.oplus.anim.p122g;

import com.oplus.anim.p111a.p113b.BaseKeyframeAnimation;

/* compiled from: EffectiveValueCallback.java */
/* renamed from: com.oplus.anim.COUIBaseListPopupWindow_11.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public class EffectiveValueCallback<T> {

    /* renamed from: PlatformImplementations.kt_3 */
    private final EffectiveFrameInfo<T> f10418a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected T f10419b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private BaseKeyframeAnimation<?, ?> f10420c;

    public EffectiveValueCallback() {
        this.f10418a = new EffectiveFrameInfo<>();
        this.f10419b = null;
    }

    public EffectiveValueCallback(T t) {
        this.f10418a = new EffectiveFrameInfo<>();
        this.f10419b = null;
        this.f10419b = t;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public T mo8778a(EffectiveFrameInfo<T> c2411a) {
        return this.f10419b;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final T m9325a(float COUIBaseListPopupWindow_12, float f2, T t, T t2, float f3, float f4, float f5) {
        return mo8778a(this.f10418a.m9324a(COUIBaseListPopupWindow_12, f2, t, t2, f3, f4, f5));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final void m9326a(BaseKeyframeAnimation<?, ?> abstractC2293a) {
        this.f10420c = abstractC2293a;
    }
}
