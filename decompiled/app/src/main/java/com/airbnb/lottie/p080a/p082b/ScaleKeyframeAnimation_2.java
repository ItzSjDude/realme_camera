package com.airbnb.lottie.p080a.p082b;

import com.airbnb.lottie.p091f.MiscUtils_2;
import com.airbnb.lottie.p092g.Keyframe_2;
import com.airbnb.lottie.p092g.ScaleXY_2;
import java.util.List;

/* compiled from: ScaleKeyframeAnimation.java */
/* renamed from: com.airbnb.lottie.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.OplusGLSurfaceView_5 */
/* loaded from: classes.dex */
public class ScaleKeyframeAnimation_2 extends KeyframeAnimation_2<ScaleXY_2> {

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final ScaleXY_2 f5429d;

    public ScaleKeyframeAnimation_2(List<Keyframe_2<ScaleXY_2>> list) {
        super(list);
        this.f5429d = new ScaleXY_2();
    }

    @Override // com.airbnb.lottie.p080a.p082b.BaseKeyframeAnimation_3
    /* renamed from: IntrinsicsJvm.kt_4, reason: merged with bridge method [inline-methods] */
    public ScaleXY_2 mo5572a(Keyframe_2<ScaleXY_2> c1197a, float COUIBaseListPopupWindow_12) {
        ScaleXY_2 c1200d;
        if (c1197a.f5894a == null || c1197a.f5895b == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        ScaleXY_2 c1200d2 = c1197a.f5894a;
        ScaleXY_2 c1200d3 = c1197a.f5895b;
        if (this.f5406c != null && (c1200d = (ScaleXY_2) this.f5406c.m6172a(c1197a.f5899f, c1197a.f5900g.floatValue(), c1200d2, c1200d3, COUIBaseListPopupWindow_12, m5580d(), m5584h())) != null) {
            return c1200d;
        }
        this.f5429d.m6176a(MiscUtils_2.m6127a(c1200d2.m6175a(), c1200d3.m6175a(), COUIBaseListPopupWindow_12), MiscUtils_2.m6127a(c1200d2.m6177b(), c1200d3.m6177b(), COUIBaseListPopupWindow_12));
        return this.f5429d;
    }
}
