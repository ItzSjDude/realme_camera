package com.airbnb.lottie.p084c.p085a;

import com.airbnb.lottie.p080a.p082b.BaseKeyframeAnimation_3;
import com.airbnb.lottie.p080a.p082b.ScaleKeyframeAnimation_2;
import com.airbnb.lottie.p092g.Keyframe_2;
import com.airbnb.lottie.p092g.ScaleXY_2;
import java.util.List;

/* compiled from: AnimatableScaleValue.java */
/* renamed from: com.airbnb.lottie.IntrinsicsJvm.kt_3.PlatformImplementations.kt_3.COUIBaseListPopupWindow_11 */
/* loaded from: classes.dex */
public class AnimatableScaleValue_2 extends BaseAnimatableValue_2<ScaleXY_2, ScaleXY_2> {
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

    AnimatableScaleValue_2() {
        this(new ScaleXY_2(1.0f, 1.0f));
    }

    public AnimatableScaleValue_2(ScaleXY_2 c1200d) {
        super(c1200d);
    }

    public AnimatableScaleValue_2(List<Keyframe_2<ScaleXY_2>> list) {
        super((List) list);
    }

    @Override // com.airbnb.lottie.p084c.p085a.AnimatableValue_2
    /* renamed from: PlatformImplementations.kt_3 */
    public BaseKeyframeAnimation_3<ScaleXY_2, ScaleXY_2> mo5647a() {
        return new ScaleKeyframeAnimation_2(this.f5495a);
    }
}
