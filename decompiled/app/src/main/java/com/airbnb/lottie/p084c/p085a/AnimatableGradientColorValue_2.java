package com.airbnb.lottie.p084c.p085a;

import com.airbnb.lottie.p080a.p082b.BaseKeyframeAnimation_3;
import com.airbnb.lottie.p080a.p082b.GradientColorKeyframeAnimation_2;
import com.airbnb.lottie.p084c.p086b.GradientColor_2;
import com.airbnb.lottie.p092g.Keyframe_2;
import java.util.List;

/* compiled from: AnimatableGradientColorValue.java */
/* renamed from: com.airbnb.lottie.IntrinsicsJvm.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3 */
/* loaded from: classes.dex */
public class AnimatableGradientColorValue_2 extends BaseAnimatableValue_2<GradientColor_2, GradientColor_2> {
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

    public AnimatableGradientColorValue_2(List<Keyframe_2<GradientColor_2>> list) {
        super((List) list);
    }

    @Override // com.airbnb.lottie.p084c.p085a.AnimatableValue_2
    /* renamed from: PlatformImplementations.kt_3 */
    public BaseKeyframeAnimation_3<GradientColor_2, GradientColor_2> mo5647a() {
        return new GradientColorKeyframeAnimation_2(this.f5495a);
    }
}
