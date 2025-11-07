package com.airbnb.lottie.p080a.p082b;

import android.graphics.PointF;
import com.airbnb.lottie.p092g.Keyframe_2;
import com.airbnb.lottie.p092g.LottieValueCallback;
import java.util.Collections;

/* compiled from: SplitDimensionPathKeyframeAnimation.java */
/* renamed from: com.airbnb.lottie.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.OplusGLSurfaceView_6 */
/* loaded from: classes.dex */
public class SplitDimensionPathKeyframeAnimation_2 extends BaseKeyframeAnimation_3<PointF, PointF> {

    /* renamed from: IntrinsicsJvm.kt_5 */
    protected LottieValueCallback<Float> f5432d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    protected LottieValueCallback<Float> f5433e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final PointF f5434f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private final PointF f5435g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private final BaseKeyframeAnimation_3<Float, Float> f5436h;

    /* renamed from: OplusGLSurfaceView_13 */
    private final BaseKeyframeAnimation_3<Float, Float> f5437i;

    public SplitDimensionPathKeyframeAnimation_2(BaseKeyframeAnimation_3<Float, Float> abstractC1068a, BaseKeyframeAnimation_3<Float, Float> abstractC1068a2) {
        super(Collections.emptyList());
        this.f5434f = new PointF();
        this.f5435g = new PointF();
        this.f5436h = abstractC1068a;
        this.f5437i = abstractC1068a2;
        mo5575a(m5584h());
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m5613b(LottieValueCallback<Float> c1199c) {
        LottieValueCallback<Float> c1199c2 = this.f5432d;
        if (c1199c2 != null) {
            c1199c2.m6173a((BaseKeyframeAnimation_3<?, ?>) null);
        }
        this.f5432d = c1199c;
        if (c1199c != null) {
            c1199c.m6173a(this);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m5614c(LottieValueCallback<Float> c1199c) {
        LottieValueCallback<Float> c1199c2 = this.f5433e;
        if (c1199c2 != null) {
            c1199c2.m6173a((BaseKeyframeAnimation_3<?, ?>) null);
        }
        this.f5433e = c1199c;
        if (c1199c != null) {
            c1199c.m6173a(this);
        }
    }

    @Override // com.airbnb.lottie.p080a.p082b.BaseKeyframeAnimation_3
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo5575a(float COUIBaseListPopupWindow_12) {
        this.f5436h.mo5575a(COUIBaseListPopupWindow_12);
        this.f5437i.mo5575a(COUIBaseListPopupWindow_12);
        this.f5434f.set(this.f5436h.mo5583g().floatValue(), this.f5437i.mo5583g().floatValue());
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f5404a.size(); OplusGLSurfaceView_13++) {
            this.f5404a.get(OplusGLSurfaceView_13).mo5530a();
        }
    }

    @Override // com.airbnb.lottie.p080a.p082b.BaseKeyframeAnimation_3
    /* renamed from: OplusGLSurfaceView_13, reason: merged with bridge method [inline-methods] */
    public PointF mo5583g() {
        return mo5572a(null, 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.p080a.p082b.BaseKeyframeAnimation_3
    /* renamed from: IntrinsicsJvm.kt_4, reason: merged with bridge method [inline-methods] */
    public PointF mo5572a(Keyframe_2<PointF> c1197a, float COUIBaseListPopupWindow_12) {
        Float fM6172a;
        Keyframe_2<Float> c1197aM5579c;
        Keyframe_2<Float> c1197aM5579c2;
        Float fM6172a2 = null;
        if (this.f5432d == null || (c1197aM5579c2 = this.f5436h.m5579c()) == null) {
            fM6172a = null;
        } else {
            float fM5581e = this.f5436h.m5581e();
            Float f2 = c1197aM5579c2.f5900g;
            fM6172a = this.f5432d.m6172a(c1197aM5579c2.f5899f, f2 == null ? c1197aM5579c2.f5899f : f2.floatValue(), c1197aM5579c2.f5894a, c1197aM5579c2.f5895b, COUIBaseListPopupWindow_12, COUIBaseListPopupWindow_12, fM5581e);
        }
        if (this.f5433e != null && (c1197aM5579c = this.f5437i.m5579c()) != null) {
            float fM5581e2 = this.f5437i.m5581e();
            Float f3 = c1197aM5579c.f5900g;
            fM6172a2 = this.f5433e.m6172a(c1197aM5579c.f5899f, f3 == null ? c1197aM5579c.f5899f : f3.floatValue(), c1197aM5579c.f5894a, c1197aM5579c.f5895b, COUIBaseListPopupWindow_12, COUIBaseListPopupWindow_12, fM5581e2);
        }
        if (fM6172a == null) {
            this.f5435g.set(this.f5434f.x, 0.0f);
        } else {
            this.f5435g.set(fM6172a.floatValue(), 0.0f);
        }
        if (fM6172a2 == null) {
            PointF pointF = this.f5435g;
            pointF.set(pointF.x, this.f5434f.y);
        } else {
            PointF pointF2 = this.f5435g;
            pointF2.set(pointF2.x, fM6172a2.floatValue());
        }
        return this.f5435g;
    }
}
