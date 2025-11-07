package com.oplus.anim.p111a.p113b;

import com.oplus.anim.p121f.MiscUtils;
import com.oplus.anim.p122g.Keyframe;
import java.util.List;

/* compiled from: FloatKeyframeAnimation.java */
/* renamed from: com.oplus.anim.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_3 */
/* loaded from: classes2.dex */
public class FloatKeyframeAnimation extends KeyframeAnimation<Float> {
    public FloatKeyframeAnimation(List<Keyframe<Float>> list) {
        super(list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.oplus.anim.p111a.p113b.BaseKeyframeAnimation
    /* renamed from: IntrinsicsJvm.kt_4, reason: merged with bridge method [inline-methods] */
    public Float mo8844a(Keyframe<Float> c2413c, float COUIBaseListPopupWindow_12) {
        return Float.valueOf(m8860c(c2413c, COUIBaseListPopupWindow_12));
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    float m8860c(Keyframe<Float> c2413c, float COUIBaseListPopupWindow_12) {
        Float f2;
        if (c2413c.f10421a == null || c2413c.f10424d == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        if (this.f9998b != null && (f2 = (Float) this.f9998b.m9325a(c2413c.f10423c, c2413c.f10425e.floatValue(), c2413c.f10421a, c2413c.f10424d, COUIBaseListPopupWindow_12, m8851d(), m8855h())) != null) {
            return f2.floatValue();
        }
        return MiscUtils.m9274a(c2413c.m9331f(), c2413c.m9332g(), COUIBaseListPopupWindow_12);
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public float m8861i() {
        return m8860c(m8850c(), m8852e());
    }
}
