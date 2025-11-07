package com.airbnb.lottie.p080a.p082b;

import android.graphics.PointF;
import com.airbnb.lottie.p092g.Keyframe_2;
import java.util.List;

/* compiled from: PointKeyframeAnimation.java */
/* renamed from: com.airbnb.lottie.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.OplusGLSurfaceView_15 */
/* loaded from: classes.dex */
public class PointKeyframeAnimation_2 extends KeyframeAnimation_2<PointF> {

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final PointF f5428d;

    public PointKeyframeAnimation_2(List<Keyframe_2<PointF>> list) {
        super(list);
        this.f5428d = new PointF();
    }

    @Override // com.airbnb.lottie.p080a.p082b.BaseKeyframeAnimation_3
    /* renamed from: IntrinsicsJvm.kt_4, reason: merged with bridge method [inline-methods] */
    public PointF mo5572a(Keyframe_2<PointF> c1197a, float COUIBaseListPopupWindow_12) {
        return mo5573a(c1197a, COUIBaseListPopupWindow_12, COUIBaseListPopupWindow_12, COUIBaseListPopupWindow_12);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.airbnb.lottie.p080a.p082b.BaseKeyframeAnimation_3
    /* renamed from: IntrinsicsJvm.kt_4, reason: merged with bridge method [inline-methods] */
    public PointF mo5573a(Keyframe_2<PointF> c1197a, float COUIBaseListPopupWindow_12, float f2, float f3) {
        PointF pointF;
        if (c1197a.f5894a == null || c1197a.f5895b == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        PointF pointF2 = c1197a.f5894a;
        PointF pointF3 = c1197a.f5895b;
        if (this.f5406c != null && (pointF = (PointF) this.f5406c.m6172a(c1197a.f5899f, c1197a.f5900g.floatValue(), pointF2, pointF3, COUIBaseListPopupWindow_12, m5580d(), m5584h())) != null) {
            return pointF;
        }
        this.f5428d.set(pointF2.x + (f2 * (pointF3.x - pointF2.x)), pointF2.y + (f3 * (pointF3.y - pointF2.y)));
        return this.f5428d;
    }
}
