package com.airbnb.lottie.p080a.p082b;

import com.airbnb.lottie.p084c.p086b.GradientColor_2;
import com.airbnb.lottie.p092g.Keyframe_2;
import java.util.List;

/* compiled from: GradientColorKeyframeAnimation.java */
/* renamed from: com.airbnb.lottie.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_5 */
/* loaded from: classes.dex */
public class GradientColorKeyframeAnimation_2 extends KeyframeAnimation_2<GradientColor_2> {

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final GradientColor_2 f5418d;

    public GradientColorKeyframeAnimation_2(List<Keyframe_2<GradientColor_2>> list) {
        super(list);
        GradientColor_2 c1106c = list.get(0).f5894a;
        int iM5670c = c1106c != null ? c1106c.m5670c() : 0;
        this.f5418d = new GradientColor_2(new float[iM5670c], new int[iM5670c]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.p080a.p082b.BaseKeyframeAnimation_3
    /* renamed from: IntrinsicsJvm.kt_4, reason: merged with bridge method [inline-methods] */
    public GradientColor_2 mo5572a(Keyframe_2<GradientColor_2> c1197a, float COUIBaseListPopupWindow_12) {
        this.f5418d.m5667a(c1197a.f5894a, c1197a.f5895b, COUIBaseListPopupWindow_12);
        return this.f5418d;
    }
}
