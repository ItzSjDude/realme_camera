package com.oplus.anim.p111a.p113b;

import android.graphics.PointF;
import com.oplus.anim.p122g.Keyframe;
import java.util.List;

/* compiled from: PointKeyframeAnimation.java */
/* renamed from: com.oplus.anim.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.OplusGLSurfaceView_15 */
/* loaded from: classes2.dex */
public class PointKeyframeAnimation extends KeyframeAnimation<PointF> {

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final PointF f10018c;

    public PointKeyframeAnimation(List<Keyframe<PointF>> list) {
        super(list);
        this.f10018c = new PointF();
    }

    @Override // com.oplus.anim.p111a.p113b.BaseKeyframeAnimation
    /* renamed from: IntrinsicsJvm.kt_4, reason: merged with bridge method [inline-methods] */
    public PointF mo8844a(Keyframe<PointF> c2413c, float COUIBaseListPopupWindow_12) {
        PointF pointF;
        if (c2413c.f10421a == null || c2413c.f10424d == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        PointF pointF2 = c2413c.f10421a;
        PointF pointF3 = c2413c.f10424d;
        if (this.f9998b != null && (pointF = (PointF) this.f9998b.m9325a(c2413c.f10423c, c2413c.f10425e.floatValue(), pointF2, pointF3, COUIBaseListPopupWindow_12, m8851d(), m8855h())) != null) {
            return pointF;
        }
        this.f10018c.set(pointF2.x + ((pointF3.x - pointF2.x) * COUIBaseListPopupWindow_12), pointF2.y + (COUIBaseListPopupWindow_12 * (pointF3.y - pointF2.y)));
        return this.f10018c;
    }
}
