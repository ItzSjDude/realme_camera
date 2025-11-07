package com.oplus.anim.p111a.p113b;

import android.graphics.PointF;
import com.oplus.anim.p122g.Keyframe;
import java.util.Collections;

/* compiled from: SplitDimensionPathKeyframeAnimation.java */
/* renamed from: com.oplus.anim.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.OplusGLSurfaceView_6 */
/* loaded from: classes2.dex */
public class SplitDimensionPathKeyframeAnimation extends BaseKeyframeAnimation<PointF, PointF> {

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final PointF f10022c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final BaseKeyframeAnimation<Float, Float> f10023d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final BaseKeyframeAnimation<Float, Float> f10024e;

    public SplitDimensionPathKeyframeAnimation(BaseKeyframeAnimation<Float, Float> abstractC2293a, BaseKeyframeAnimation<Float, Float> abstractC2293a2) {
        super(Collections.emptyList());
        this.f10022c = new PointF();
        this.f10023d = abstractC2293a;
        this.f10024e = abstractC2293a2;
        mo8846a(m8855h());
    }

    @Override // com.oplus.anim.p111a.p113b.BaseKeyframeAnimation
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo8846a(float COUIBaseListPopupWindow_12) {
        this.f10023d.mo8846a(COUIBaseListPopupWindow_12);
        this.f10024e.mo8846a(COUIBaseListPopupWindow_12);
        this.f10022c.set(this.f10023d.mo8854g().floatValue(), this.f10024e.mo8854g().floatValue());
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f9997a.size(); OplusGLSurfaceView_13++) {
            this.f9997a.get(OplusGLSurfaceView_13).mo8806a();
        }
    }

    @Override // com.oplus.anim.p111a.p113b.BaseKeyframeAnimation
    /* renamed from: OplusGLSurfaceView_13, reason: merged with bridge method [inline-methods] */
    public PointF mo8854g() {
        return mo8844a(null, 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.oplus.anim.p111a.p113b.BaseKeyframeAnimation
    /* renamed from: IntrinsicsJvm.kt_4, reason: merged with bridge method [inline-methods] */
    public PointF mo8844a(Keyframe<PointF> c2413c, float COUIBaseListPopupWindow_12) {
        return this.f10022c;
    }
}
