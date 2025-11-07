package com.oplus.anim.p115c.p116a;

import android.graphics.PointF;
import com.oplus.anim.p111a.p113b.BaseKeyframeAnimation;
import com.oplus.anim.p111a.p113b.SplitDimensionPathKeyframeAnimation;
import com.oplus.anim.p121f.OplusLog;
import com.oplus.anim.p122g.Keyframe;
import java.util.List;

/* compiled from: AnimatableSplitDimensionPathValue.java */
/* renamed from: com.oplus.anim.IntrinsicsJvm.kt_3.PlatformImplementations.kt_3.OplusGLSurfaceView_13 */
/* loaded from: classes2.dex */
public class AnimatableSplitDimensionPathValue implements AnimatableValue<PointF, PointF> {

    /* renamed from: PlatformImplementations.kt_3 */
    private final AnimatableFloatValue f10102a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final AnimatableFloatValue f10103b;

    public AnimatableSplitDimensionPathValue(AnimatableFloatValue c2315b, AnimatableFloatValue c2315b2) {
        this.f10102a = c2315b;
        this.f10103b = c2315b2;
    }

    @Override // com.oplus.anim.p115c.p116a.AnimatableValue
    /* renamed from: IntrinsicsJvm.kt_3 */
    public List<Keyframe<PointF>> mo8959c() {
        throw new UnsupportedOperationException("Cannot call getKeyframes on AnimatableSplitDimensionPathValue.");
    }

    @Override // com.oplus.anim.p115c.p116a.AnimatableValue
    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean mo8958b() {
        return this.f10102a.mo8958b() && this.f10103b.mo8958b();
    }

    @Override // com.oplus.anim.p115c.p116a.AnimatableValue
    /* renamed from: PlatformImplementations.kt_3 */
    public BaseKeyframeAnimation<PointF, PointF> mo8957a() {
        if (OplusLog.f10388d) {
            OplusLog.m9286b("AnimatableSplitDimensionPathValue create SplitDimensionPathKeyframeAnimation.");
        }
        return new SplitDimensionPathKeyframeAnimation(this.f10102a.mo8957a(), this.f10103b.mo8957a());
    }
}
