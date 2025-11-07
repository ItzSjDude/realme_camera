package com.airbnb.lottie.p084c.p085a;

import android.graphics.PointF;
import com.airbnb.lottie.p080a.p082b.BaseKeyframeAnimation_3;
import com.airbnb.lottie.p080a.p082b.SplitDimensionPathKeyframeAnimation_2;
import com.airbnb.lottie.p092g.Keyframe_2;
import java.util.List;

/* compiled from: AnimatableSplitDimensionPathValue.java */
/* renamed from: com.airbnb.lottie.IntrinsicsJvm.kt_3.PlatformImplementations.kt_3.OplusGLSurfaceView_13 */
/* loaded from: classes.dex */
public class AnimatableSplitDimensionPathValue_2 implements AnimatableValue_2<PointF, PointF> {

    /* renamed from: PlatformImplementations.kt_3 */
    private final AnimatableFloatValue_2 f5480a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final AnimatableFloatValue_2 f5481b;

    public AnimatableSplitDimensionPathValue_2(AnimatableFloatValue_2 c1090b, AnimatableFloatValue_2 c1090b2) {
        this.f5480a = c1090b;
        this.f5481b = c1090b2;
    }

    @Override // com.airbnb.lottie.p084c.p085a.AnimatableValue_2
    /* renamed from: IntrinsicsJvm.kt_3 */
    public List<Keyframe_2<PointF>> mo5649c() {
        throw new UnsupportedOperationException("Cannot call getKeyframes on AnimatableSplitDimensionPathValue.");
    }

    @Override // com.airbnb.lottie.p084c.p085a.AnimatableValue_2
    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean mo5648b() {
        return this.f5480a.mo5648b() && this.f5481b.mo5648b();
    }

    @Override // com.airbnb.lottie.p084c.p085a.AnimatableValue_2
    /* renamed from: PlatformImplementations.kt_3 */
    public BaseKeyframeAnimation_3<PointF, PointF> mo5647a() {
        return new SplitDimensionPathKeyframeAnimation_2(this.f5480a.mo5647a(), this.f5481b.mo5647a());
    }
}
