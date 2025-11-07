package com.airbnb.lottie.p080a.p082b;

import com.airbnb.lottie.p092g.Keyframe_2;
import com.airbnb.lottie.p092g.LottieFrameInfo;
import com.airbnb.lottie.p092g.LottieValueCallback;
import java.util.Collections;

/* compiled from: ValueCallbackKeyframeAnimation.java */
/* renamed from: com.airbnb.lottie.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.p */
/* loaded from: classes.dex */
public class ValueCallbackKeyframeAnimation_2<K, A> extends BaseKeyframeAnimation_3<K, A> {

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final LottieFrameInfo<A> f5452d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final A f5453e;

    @Override // com.airbnb.lottie.p080a.p082b.BaseKeyframeAnimation_3
    /* renamed from: COUIBaseListPopupWindow_12 */
    float mo5582f() {
        return 1.0f;
    }

    public ValueCallbackKeyframeAnimation_2(LottieValueCallback<A> c1199c) {
        this(c1199c, null);
    }

    public ValueCallbackKeyframeAnimation_2(LottieValueCallback<A> c1199c, A a2) {
        super(Collections.emptyList());
        this.f5452d = new LottieFrameInfo<>();
        m5577a(c1199c);
        this.f5453e = a2;
    }

    @Override // com.airbnb.lottie.p080a.p082b.BaseKeyframeAnimation_3
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo5575a(float COUIBaseListPopupWindow_12) {
        this.f5405b = COUIBaseListPopupWindow_12;
    }

    @Override // com.airbnb.lottie.p080a.p082b.BaseKeyframeAnimation_3
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo5578b() {
        if (this.f5406c != null) {
            super.mo5578b();
        }
    }

    @Override // com.airbnb.lottie.p080a.p082b.BaseKeyframeAnimation_3
    /* renamed from: COUIBaseListPopupWindow_11 */
    public A mo5583g() {
        LottieValueCallback<A> c1199c = this.f5406c;
        A a2 = this.f5453e;
        return c1199c.m6172a(0.0f, 0.0f, a2, a2, m5584h(), m5584h(), m5584h());
    }

    @Override // com.airbnb.lottie.p080a.p082b.BaseKeyframeAnimation_3
    /* renamed from: PlatformImplementations.kt_3 */
    A mo5572a(Keyframe_2<K> c1197a, float COUIBaseListPopupWindow_12) {
        return mo5583g();
    }
}
