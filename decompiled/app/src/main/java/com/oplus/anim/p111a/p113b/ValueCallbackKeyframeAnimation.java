package com.oplus.anim.p111a.p113b;

import com.oplus.anim.p122g.EffectiveFrameInfo;
import com.oplus.anim.p122g.EffectiveValueCallback;
import com.oplus.anim.p122g.Keyframe;
import java.util.Collections;

/* compiled from: ValueCallbackKeyframeAnimation.java */
/* renamed from: com.oplus.anim.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.p */
/* loaded from: classes2.dex */
public class ValueCallbackKeyframeAnimation<K, A> extends BaseKeyframeAnimation<K, A> {

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final EffectiveFrameInfo<A> f10039c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final A f10040d;

    @Override // com.oplus.anim.p111a.p113b.BaseKeyframeAnimation
    /* renamed from: COUIBaseListPopupWindow_12 */
    float mo8853f() {
        return 1.0f;
    }

    public ValueCallbackKeyframeAnimation(EffectiveValueCallback<A> c2412b) {
        this(c2412b, null);
    }

    public ValueCallbackKeyframeAnimation(EffectiveValueCallback<A> c2412b, A a2) {
        super(Collections.emptyList());
        this.f10039c = new EffectiveFrameInfo<>();
        m8848a(c2412b);
        this.f10040d = a2;
    }

    @Override // com.oplus.anim.p111a.p113b.BaseKeyframeAnimation
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo8849b() {
        if (this.f9998b != null) {
            super.mo8849b();
        }
    }

    @Override // com.oplus.anim.p111a.p113b.BaseKeyframeAnimation
    /* renamed from: COUIBaseListPopupWindow_11 */
    public A mo8854g() {
        EffectiveValueCallback<A> c2412b = this.f9998b;
        A a2 = this.f10040d;
        return c2412b.m9325a(0.0f, 0.0f, a2, a2, m8855h(), m8855h(), m8855h());
    }

    @Override // com.oplus.anim.p111a.p113b.BaseKeyframeAnimation
    /* renamed from: PlatformImplementations.kt_3 */
    A mo8844a(Keyframe<K> c2413c, float COUIBaseListPopupWindow_12) {
        return mo8854g();
    }
}
