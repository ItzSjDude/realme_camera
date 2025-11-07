package com.airbnb.lottie.p084c.p085a;

import android.graphics.PointF;
import com.airbnb.lottie.p080a.p082b.BaseKeyframeAnimation_3;
import com.airbnb.lottie.p080a.p082b.PointKeyframeAnimation_2;
import com.airbnb.lottie.p092g.Keyframe_2;
import java.util.List;

/* compiled from: AnimatablePointValue.java */
/* renamed from: com.airbnb.lottie.IntrinsicsJvm.kt_3.PlatformImplementations.kt_3.COUIBaseListPopupWindow_12 */
/* loaded from: classes.dex */
public class AnimatablePointValue_2 extends BaseAnimatableValue_2<PointF, PointF> {
    @Override // com.airbnb.lottie.p084c.p085a.BaseAnimatableValue_2, com.airbnb.lottie.p084c.p085a.AnimatableValue_2
    /* renamed from: IntrinsicsJvm.kt_4 */
    public /* bridge */ /* synthetic */ boolean mo5648b() {
        return super.mo5648b();
    }

    @Override // com.airbnb.lottie.p084c.p085a.BaseAnimatableValue_2, com.airbnb.lottie.p084c.p085a.AnimatableValue_2
    /* renamed from: IntrinsicsJvm.kt_3 */
    public /* bridge */ /* synthetic */ List mo5649c() {
        return super.mo5649c();
    }

    @Override // com.airbnb.lottie.p084c.p085a.BaseAnimatableValue_2
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public AnimatablePointValue_2(List<Keyframe_2<PointF>> list) {
        super((List) list);
    }

    @Override // com.airbnb.lottie.p084c.p085a.AnimatableValue_2
    /* renamed from: PlatformImplementations.kt_3 */
    public BaseKeyframeAnimation_3<PointF, PointF> mo5647a() {
        return new PointKeyframeAnimation_2(this.f5495a);
    }
}
