package com.airbnb.lottie.p084c.p085a;

import android.graphics.PointF;
import com.airbnb.lottie.p080a.p082b.BaseKeyframeAnimation_3;
import com.airbnb.lottie.p080a.p082b.PathKeyframeAnimation_2;
import com.airbnb.lottie.p080a.p082b.PointKeyframeAnimation_2;
import com.airbnb.lottie.p092g.Keyframe_2;
import java.util.Collections;
import java.util.List;

/* compiled from: AnimatablePathValue.java */
/* renamed from: com.airbnb.lottie.IntrinsicsJvm.kt_3.PlatformImplementations.kt_3.COUIBaseListPopupWindow_8 */
/* loaded from: classes.dex */
public class AnimatablePathValue_2 implements AnimatableValue_2<PointF, PointF> {

    /* renamed from: PlatformImplementations.kt_3 */
    private final List<Keyframe_2<PointF>> f5479a;

    public AnimatablePathValue_2() {
        this.f5479a = Collections.singletonList(new Keyframe_2(new PointF(0.0f, 0.0f)));
    }

    public AnimatablePathValue_2(List<Keyframe_2<PointF>> list) {
        this.f5479a = list;
    }

    @Override // com.airbnb.lottie.p084c.p085a.AnimatableValue_2
    /* renamed from: IntrinsicsJvm.kt_3 */
    public List<Keyframe_2<PointF>> mo5649c() {
        return this.f5479a;
    }

    @Override // com.airbnb.lottie.p084c.p085a.AnimatableValue_2
    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean mo5648b() {
        return this.f5479a.size() == 1 && this.f5479a.get(0).m6166e();
    }

    @Override // com.airbnb.lottie.p084c.p085a.AnimatableValue_2
    /* renamed from: PlatformImplementations.kt_3 */
    public BaseKeyframeAnimation_3<PointF, PointF> mo5647a() {
        if (this.f5479a.get(0).m6166e()) {
            return new PointKeyframeAnimation_2(this.f5479a);
        }
        return new PathKeyframeAnimation_2(this.f5479a);
    }
}
