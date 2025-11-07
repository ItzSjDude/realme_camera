package com.oplus.anim.p120e;

import android.graphics.PointF;
import com.oplus.anim.p115c.p116a.AnimatableFloatValue;
import com.oplus.anim.p115c.p116a.AnimatablePathValue;
import com.oplus.anim.p115c.p116a.AnimatableScaleValue;
import com.oplus.anim.p115c.p116a.AnimatableSplitDimensionPathValue;
import com.oplus.anim.p115c.p116a.AnimatableValue;
import com.oplus.anim.p122g.Keyframe;
import com.oplus.anim.p122g.ScaleXY;

/* compiled from: AnimatableTransformParser.java */
/* renamed from: com.oplus.anim.COUIBaseListPopupWindow_8.IntrinsicsJvm.kt_3 */
/* loaded from: classes2.dex */
public class AnimatableTransformParser {
    /* JADX WARN: Removed duplicated region for block: B:62:0x00c2  */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.oplus.anim.p115c.p116a.AnimatableTransform m9170a(android.util.JsonReader r28, com.oplus.anim.EffectiveAnimationComposition r29) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 508
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.anim.p120e.AnimatableTransformParser.m9170a(android.util.JsonReader, com.oplus.anim.PlatformImplementations.kt_3):com.oplus.anim.IntrinsicsJvm.kt_3.PlatformImplementations.kt_3.OplusGLSurfaceView_14");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static boolean m9172a(AnimatablePathValue c2318e) {
        return c2318e == null || (c2318e.mo8958b() && c2318e.mo8959c().get(0).f10421a.equals(0.0f, 0.0f));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static boolean m9174a(AnimatableValue<PointF, PointF> interfaceC2326m) {
        return interfaceC2326m == null || (!(interfaceC2326m instanceof AnimatableSplitDimensionPathValue) && interfaceC2326m.mo8958b() && interfaceC2326m.mo8959c().get(0).f10421a.equals(0.0f, 0.0f));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: PlatformImplementations.kt_3 */
    private static boolean m9171a(AnimatableFloatValue c2315b) {
        return c2315b == null || (c2315b.mo8958b() && ((Float) ((Keyframe) c2315b.mo8959c().get(0)).f10421a).floatValue() == 0.0f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: PlatformImplementations.kt_3 */
    private static boolean m9173a(AnimatableScaleValue c2320g) {
        return c2320g == null || (c2320g.mo8958b() && ((ScaleXY) ((Keyframe) c2320g.mo8959c().get(0)).f10421a).m9338b(1.0f, 1.0f));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: IntrinsicsJvm.kt_4 */
    private static boolean m9175b(AnimatableFloatValue c2315b) {
        return c2315b == null || (c2315b.mo8958b() && ((Float) ((Keyframe) c2315b.mo8959c().get(0)).f10421a).floatValue() == 0.0f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: IntrinsicsJvm.kt_3 */
    private static boolean m9176c(AnimatableFloatValue c2315b) {
        return c2315b == null || (c2315b.mo8958b() && ((Float) ((Keyframe) c2315b.mo8959c().get(0)).f10421a).floatValue() == 0.0f);
    }
}
