package com.oplus.anim.p111a.p113b;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import com.oplus.anim.p122g.Keyframe;
import java.util.List;

/* compiled from: PathKeyframeAnimation.java */
/* renamed from: com.oplus.anim.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.OplusGLSurfaceView_13 */
/* loaded from: classes2.dex */
public class PathKeyframeAnimation extends KeyframeAnimation<PointF> {

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final PointF f10014c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final float[] f10015d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private PathKeyframe f10016e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private PathMeasure f10017f;

    public PathKeyframeAnimation(List<? extends Keyframe<PointF>> list) {
        super(list);
        this.f10014c = new PointF();
        this.f10015d = new float[2];
        this.f10017f = new PathMeasure();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.oplus.anim.p111a.p113b.BaseKeyframeAnimation
    /* renamed from: IntrinsicsJvm.kt_4, reason: merged with bridge method [inline-methods] */
    public PointF mo8844a(Keyframe<PointF> c2413c, float COUIBaseListPopupWindow_12) {
        PointF pointF;
        PathKeyframe c2300h = (PathKeyframe) c2413c;
        Path pathM8870b = c2300h.m8870b();
        if (pathM8870b == null) {
            return c2413c.f10421a;
        }
        if (this.f9998b != null && (pointF = (PointF) this.f9998b.m9325a(c2300h.f10423c, c2300h.f10425e.floatValue(), c2300h.f10421a, c2300h.f10424d, m8851d(), COUIBaseListPopupWindow_12, m8855h())) != null) {
            return pointF;
        }
        if (this.f10016e != c2300h) {
            this.f10017f.setPath(pathM8870b, false);
            this.f10016e = c2300h;
        }
        PathMeasure pathMeasure = this.f10017f;
        pathMeasure.getPosTan(COUIBaseListPopupWindow_12 * pathMeasure.getLength(), this.f10015d, null);
        PointF pointF2 = this.f10014c;
        float[] fArr = this.f10015d;
        pointF2.set(fArr[0], fArr[1]);
        return this.f10014c;
    }
}
