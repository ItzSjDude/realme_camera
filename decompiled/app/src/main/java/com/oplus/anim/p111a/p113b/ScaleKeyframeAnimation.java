package com.oplus.anim.p111a.p113b;

import com.oplus.anim.p121f.MiscUtils;
import com.oplus.anim.p122g.Keyframe;
import com.oplus.anim.p122g.ScaleXY;
import java.util.List;

/* compiled from: ScaleKeyframeAnimation.java */
/* renamed from: com.oplus.anim.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.OplusGLSurfaceView_5 */
/* loaded from: classes2.dex */
public class ScaleKeyframeAnimation extends KeyframeAnimation<ScaleXY> {

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final ScaleXY f10019c;

    public ScaleKeyframeAnimation(List<Keyframe<ScaleXY>> list) {
        super(list);
        this.f10019c = new ScaleXY();
    }

    @Override // com.oplus.anim.p111a.p113b.BaseKeyframeAnimation
    /* renamed from: IntrinsicsJvm.kt_4, reason: merged with bridge method [inline-methods] */
    public ScaleXY mo8844a(Keyframe<ScaleXY> c2413c, float COUIBaseListPopupWindow_12) {
        ScaleXY c2414d;
        if (c2413c.f10421a == null || c2413c.f10424d == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        ScaleXY c2414d2 = c2413c.f10421a;
        ScaleXY c2414d3 = c2413c.f10424d;
        if (this.f9998b != null && (c2414d = (ScaleXY) this.f9998b.m9325a(c2413c.f10423c, c2413c.f10425e.floatValue(), c2414d2, c2414d3, COUIBaseListPopupWindow_12, m8851d(), m8855h())) != null) {
            return c2414d;
        }
        this.f10019c.m9336a(MiscUtils.m9274a(c2414d2.m9335a(), c2414d3.m9335a(), COUIBaseListPopupWindow_12), MiscUtils.m9274a(c2414d2.m9337b(), c2414d3.m9337b(), COUIBaseListPopupWindow_12));
        return this.f10019c;
    }
}
