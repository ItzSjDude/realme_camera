package com.airbnb.lottie.p080a.p082b;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import com.airbnb.lottie.p092g.Keyframe_2;
import java.util.List;

/* compiled from: PathKeyframeAnimation.java */
/* renamed from: com.airbnb.lottie.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.OplusGLSurfaceView_13 */
/* loaded from: classes.dex */
public class PathKeyframeAnimation_2 extends KeyframeAnimation_2<PointF> {

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final PointF f5424d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final float[] f5425e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final PathMeasure f5426f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private PathKeyframe_2 f5427g;

    public PathKeyframeAnimation_2(List<? extends Keyframe_2<PointF>> list) {
        super(list);
        this.f5424d = new PointF();
        this.f5425e = new float[2];
        this.f5426f = new PathMeasure();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.p080a.p082b.BaseKeyframeAnimation_3
    /* renamed from: IntrinsicsJvm.kt_4, reason: merged with bridge method [inline-methods] */
    public PointF mo5572a(Keyframe_2<PointF> c1197a, float COUIBaseListPopupWindow_12) {
        PointF pointF;
        PathKeyframe_2 c1075h = (PathKeyframe_2) c1197a;
        Path pathM5606b = c1075h.m5606b();
        if (pathM5606b == null) {
            return c1197a.f5894a;
        }
        if (this.f5406c != null && (pointF = (PointF) this.f5406c.m6172a(c1075h.f5899f, c1075h.f5900g.floatValue(), c1075h.f5894a, c1075h.f5895b, m5580d(), COUIBaseListPopupWindow_12, m5584h())) != null) {
            return pointF;
        }
        if (this.f5427g != c1075h) {
            this.f5426f.setPath(pathM5606b, false);
            this.f5427g = c1075h;
        }
        PathMeasure pathMeasure = this.f5426f;
        pathMeasure.getPosTan(COUIBaseListPopupWindow_12 * pathMeasure.getLength(), this.f5425e, null);
        PointF pointF2 = this.f5424d;
        float[] fArr = this.f5425e;
        pointF2.set(fArr[0], fArr[1]);
        return this.f5424d;
    }
}
