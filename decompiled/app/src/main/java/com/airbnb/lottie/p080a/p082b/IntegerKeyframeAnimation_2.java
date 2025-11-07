package com.airbnb.lottie.p080a.p082b;

import com.airbnb.lottie.p091f.MiscUtils_2;
import com.airbnb.lottie.p092g.Keyframe_2;
import java.util.List;

/* compiled from: IntegerKeyframeAnimation.java */
/* renamed from: com.airbnb.lottie.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_8 */
/* loaded from: classes.dex */
public class IntegerKeyframeAnimation_2 extends KeyframeAnimation_2<Integer> {
    public IntegerKeyframeAnimation_2(List<Keyframe_2<Integer>> list) {
        super(list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.p080a.p082b.BaseKeyframeAnimation_3
    /* renamed from: IntrinsicsJvm.kt_4, reason: merged with bridge method [inline-methods] */
    public Integer mo5572a(Keyframe_2<Integer> c1197a, float COUIBaseListPopupWindow_12) {
        return Integer.valueOf(m5600c(c1197a, COUIBaseListPopupWindow_12));
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    int m5600c(Keyframe_2<Integer> c1197a, float COUIBaseListPopupWindow_12) {
        Integer num;
        if (c1197a.f5894a == null || c1197a.f5895b == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        if (this.f5406c != null && (num = (Integer) this.f5406c.m6172a(c1197a.f5899f, c1197a.f5900g.floatValue(), c1197a.f5894a, c1197a.f5895b, COUIBaseListPopupWindow_12, m5580d(), m5584h())) != null) {
            return num.intValue();
        }
        return MiscUtils_2.m6130a(c1197a.m6169h(), c1197a.m6170i(), COUIBaseListPopupWindow_12);
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public int m5601i() {
        return m5600c(m5579c(), m5581e());
    }
}
