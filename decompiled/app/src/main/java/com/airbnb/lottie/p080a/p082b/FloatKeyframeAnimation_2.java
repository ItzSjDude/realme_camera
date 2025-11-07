package com.airbnb.lottie.p080a.p082b;

import com.airbnb.lottie.p091f.MiscUtils_2;
import com.airbnb.lottie.p092g.Keyframe_2;
import java.util.List;

/* compiled from: FloatKeyframeAnimation.java */
/* renamed from: com.airbnb.lottie.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_3 */
/* loaded from: classes.dex */
public class FloatKeyframeAnimation_2 extends KeyframeAnimation_2<Float> {
    public FloatKeyframeAnimation_2(List<Keyframe_2<Float>> list) {
        super(list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.p080a.p082b.BaseKeyframeAnimation_3
    /* renamed from: IntrinsicsJvm.kt_4, reason: merged with bridge method [inline-methods] */
    public Float mo5572a(Keyframe_2<Float> c1197a, float COUIBaseListPopupWindow_12) {
        return Float.valueOf(m5596c(c1197a, COUIBaseListPopupWindow_12));
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    float m5596c(Keyframe_2<Float> c1197a, float COUIBaseListPopupWindow_12) {
        Float f2;
        if (c1197a.f5894a == null || c1197a.f5895b == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        if (this.f5406c != null && (f2 = (Float) this.f5406c.m6172a(c1197a.f5899f, c1197a.f5900g.floatValue(), c1197a.f5894a, c1197a.f5895b, COUIBaseListPopupWindow_12, m5580d(), m5584h())) != null) {
            return f2.floatValue();
        }
        return MiscUtils_2.m6127a(c1197a.m6167f(), c1197a.m6168g(), COUIBaseListPopupWindow_12);
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public float m5597i() {
        return m5596c(m5579c(), m5581e());
    }
}
