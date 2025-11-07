package com.oplus.anim.p111a.p113b;

import com.oplus.anim.p121f.MiscUtils;
import com.oplus.anim.p122g.Keyframe;
import java.util.List;

/* compiled from: IntegerKeyframeAnimation.java */
/* renamed from: com.oplus.anim.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_8 */
/* loaded from: classes2.dex */
public class IntegerKeyframeAnimation extends KeyframeAnimation<Integer> {
    public IntegerKeyframeAnimation(List<Keyframe<Integer>> list) {
        super(list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.oplus.anim.p111a.p113b.BaseKeyframeAnimation
    /* renamed from: IntrinsicsJvm.kt_4, reason: merged with bridge method [inline-methods] */
    public Integer mo8844a(Keyframe<Integer> c2413c, float COUIBaseListPopupWindow_12) {
        return Integer.valueOf(m8864c(c2413c, COUIBaseListPopupWindow_12));
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    int m8864c(Keyframe<Integer> c2413c, float COUIBaseListPopupWindow_12) {
        Integer num;
        if (c2413c.f10421a == null || c2413c.f10424d == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        if (this.f9998b != null && (num = (Integer) this.f9998b.m9325a(c2413c.f10423c, c2413c.f10425e.floatValue(), c2413c.f10421a, c2413c.f10424d, COUIBaseListPopupWindow_12, m8851d(), m8855h())) != null) {
            return num.intValue();
        }
        return MiscUtils.m9277a(c2413c.m9333h(), c2413c.m9334i(), COUIBaseListPopupWindow_12);
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public int m8865i() {
        return m8864c(m8850c(), m8852e());
    }
}
