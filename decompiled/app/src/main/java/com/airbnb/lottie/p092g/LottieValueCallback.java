package com.airbnb.lottie.p092g;

import com.airbnb.lottie.p080a.p082b.BaseKeyframeAnimation_3;

/* compiled from: LottieValueCallback.java */
/* renamed from: com.airbnb.lottie.COUIBaseListPopupWindow_11.IntrinsicsJvm.kt_3 */
/* loaded from: classes.dex */
public class LottieValueCallback<T> {

    /* renamed from: PlatformImplementations.kt_3 */
    private final LottieFrameInfo<T> f5917a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private BaseKeyframeAnimation_3<?, ?> f5918b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected T f5919c;

    public LottieValueCallback() {
        this.f5917a = new LottieFrameInfo<>();
        this.f5919c = null;
    }

    public LottieValueCallback(T t) {
        this.f5917a = new LottieFrameInfo<>();
        this.f5919c = null;
        this.f5919c = t;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public T mo5523a(LottieFrameInfo<T> c1198b) {
        return this.f5919c;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final void m6174a(T t) {
        this.f5919c = t;
        BaseKeyframeAnimation_3<?, ?> abstractC1068a = this.f5918b;
        if (abstractC1068a != null) {
            abstractC1068a.mo5578b();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final T m6172a(float COUIBaseListPopupWindow_12, float f2, T t, T t2, float f3, float f4, float f5) {
        return mo5523a((LottieFrameInfo) this.f5917a.m6171a(COUIBaseListPopupWindow_12, f2, t, t2, f3, f4, f5));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final void m6173a(BaseKeyframeAnimation_3<?, ?> abstractC1068a) {
        this.f5918b = abstractC1068a;
    }
}
