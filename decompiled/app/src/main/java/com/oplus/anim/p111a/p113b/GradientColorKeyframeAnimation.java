package com.oplus.anim.p111a.p113b;

import com.oplus.anim.p115c.p117b.GradientColor;
import com.oplus.anim.p122g.Keyframe;
import java.util.List;

/* compiled from: GradientColorKeyframeAnimation.java */
/* renamed from: com.oplus.anim.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_5 */
/* loaded from: classes2.dex */
public class GradientColorKeyframeAnimation extends KeyframeAnimation<GradientColor> {

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final GradientColor f10008c;

    public GradientColorKeyframeAnimation(List<Keyframe<GradientColor>> list) {
        super(list);
        GradientColor c2331c = list.get(0).f10421a;
        int iM8981c = c2331c != null ? c2331c.m8981c() : 0;
        this.f10008c = new GradientColor(new float[iM8981c], new int[iM8981c]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.oplus.anim.p111a.p113b.BaseKeyframeAnimation
    /* renamed from: IntrinsicsJvm.kt_4, reason: merged with bridge method [inline-methods] */
    public GradientColor mo8844a(Keyframe<GradientColor> c2413c, float COUIBaseListPopupWindow_12) {
        this.f10008c.m8978a(c2413c.f10421a, c2413c.f10424d, COUIBaseListPopupWindow_12);
        return this.f10008c;
    }
}
