package com.oplus.anim.p111a.p113b;

import com.oplus.anim.p121f.GammaEvaluator;
import com.oplus.anim.p121f.MiscUtils;
import com.oplus.anim.p122g.Keyframe;
import java.util.List;

/* compiled from: ColorKeyframeAnimation.java */
/* renamed from: com.oplus.anim.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public class ColorKeyframeAnimation extends KeyframeAnimation<Integer> {
    public ColorKeyframeAnimation(List<Keyframe<Integer>> list) {
        super(list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.oplus.anim.p111a.p113b.BaseKeyframeAnimation
    /* renamed from: IntrinsicsJvm.kt_4, reason: merged with bridge method [inline-methods] */
    public Integer mo8844a(Keyframe<Integer> c2413c, float COUIBaseListPopupWindow_12) {
        return Integer.valueOf(m8857c(c2413c, COUIBaseListPopupWindow_12));
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public int m8857c(Keyframe<Integer> c2413c, float COUIBaseListPopupWindow_12) {
        Integer num;
        if (c2413c.f10421a == null || c2413c.f10424d == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        int iIntValue = c2413c.f10421a.intValue();
        int iIntValue2 = c2413c.f10424d.intValue();
        if (this.f9998b != null && (num = (Integer) this.f9998b.m9325a(c2413c.f10423c, c2413c.f10425e.floatValue(), Integer.valueOf(iIntValue), Integer.valueOf(iIntValue2), COUIBaseListPopupWindow_12, m8851d(), m8855h())) != null) {
            return num.intValue();
        }
        return GammaEvaluator.m9270a(MiscUtils.m9282b(COUIBaseListPopupWindow_12, 0.0f, 1.0f), iIntValue, iIntValue2);
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public int m8858i() {
        return m8857c(m8850c(), m8852e());
    }
}
