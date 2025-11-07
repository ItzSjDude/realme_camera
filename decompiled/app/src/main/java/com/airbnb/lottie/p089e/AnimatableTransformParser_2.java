package com.airbnb.lottie.p089e;

import android.graphics.PointF;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.p084c.p085a.AnimatableFloatValue_2;
import com.airbnb.lottie.p084c.p085a.AnimatableIntegerValue_2;
import com.airbnb.lottie.p084c.p085a.AnimatablePathValue_2;
import com.airbnb.lottie.p084c.p085a.AnimatableScaleValue_2;
import com.airbnb.lottie.p084c.p085a.AnimatableSplitDimensionPathValue_2;
import com.airbnb.lottie.p084c.p085a.AnimatableTransform_2;
import com.airbnb.lottie.p084c.p085a.AnimatableValue_2;
import com.airbnb.lottie.p089e.p090a.JsonReader;
import com.airbnb.lottie.p092g.Keyframe_2;
import com.airbnb.lottie.p092g.ScaleXY_2;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.io.IOException;

/* compiled from: AnimatableTransformParser.java */
/* renamed from: com.airbnb.lottie.COUIBaseListPopupWindow_8.IntrinsicsJvm.kt_3 */
/* loaded from: classes.dex */
public class AnimatableTransformParser_2 {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final JsonReader.PlatformImplementations.kt_3 f5779a = JsonReader.PlatformImplementations.kt_3.m5929a("PlatformImplementations.kt_3", TtmlNode.TAG_P, "s", "rz", "r", "o", "so", "eo", "sk", "sa");

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static final JsonReader.PlatformImplementations.kt_3 f5780b = JsonReader.PlatformImplementations.kt_3.m5929a("OplusGLSurfaceView_5");

    /* renamed from: PlatformImplementations.kt_3 */
    public static AnimatableTransform_2 m5957a(JsonReader abstractC1149c, LottieComposition c1136d) throws IOException {
        boolean z;
        boolean z2 = false;
        boolean z3 = abstractC1149c.mo5920f() == JsonReader.IntrinsicsJvm.kt_4.BEGIN_OBJECT;
        if (z3) {
            abstractC1149c.mo5917c();
        }
        AnimatableFloatValue_2 c1090b = null;
        AnimatablePathValue_2 c1093eM5907a = null;
        AnimatableValue_2<PointF, PointF> interfaceC1101mM5908b = null;
        AnimatableScaleValue_2 c1095gM5971d = null;
        AnimatableFloatValue_2 c1090bM5965a = null;
        AnimatableFloatValue_2 c1090bM5965a2 = null;
        AnimatableIntegerValue_2 c1092dM5969b = null;
        AnimatableFloatValue_2 c1090bM5965a3 = null;
        AnimatableFloatValue_2 c1090bM5965a4 = null;
        while (abstractC1149c.mo5919e()) {
            switch (abstractC1149c.mo5912a(f5779a)) {
                case 0:
                    boolean z4 = z2;
                    abstractC1149c.mo5917c();
                    while (abstractC1149c.mo5919e()) {
                        if (abstractC1149c.mo5912a(f5780b) == 0) {
                            c1093eM5907a = AnimatablePathValueParser_2.m5907a(abstractC1149c, c1136d);
                        } else {
                            abstractC1149c.mo5922h();
                            abstractC1149c.mo5927m();
                        }
                    }
                    abstractC1149c.mo5918d();
                    z2 = z4;
                    continue;
                case 1:
                    interfaceC1101mM5908b = AnimatablePathValueParser_2.m5908b(abstractC1149c, c1136d);
                    continue;
                case 2:
                    c1095gM5971d = AnimatableValueParser_2.m5971d(abstractC1149c, c1136d);
                    continue;
                case 3:
                    c1136d.m5843a("Lottie doesn't support 3D layers.");
                    break;
                case 4:
                    break;
                case 5:
                    c1092dM5969b = AnimatableValueParser_2.m5969b(abstractC1149c, c1136d);
                    continue;
                case 6:
                    c1090bM5965a3 = AnimatableValueParser_2.m5965a(abstractC1149c, c1136d, z2);
                    continue;
                case 7:
                    c1090bM5965a4 = AnimatableValueParser_2.m5965a(abstractC1149c, c1136d, z2);
                    continue;
                case 8:
                    c1090bM5965a = AnimatableValueParser_2.m5965a(abstractC1149c, c1136d, z2);
                    continue;
                case 9:
                    c1090bM5965a2 = AnimatableValueParser_2.m5965a(abstractC1149c, c1136d, z2);
                    continue;
                default:
                    abstractC1149c.mo5922h();
                    abstractC1149c.mo5927m();
                    continue;
            }
            AnimatableFloatValue_2 c1090bM5965a5 = AnimatableValueParser_2.m5965a(abstractC1149c, c1136d, z2);
            if (c1090bM5965a5.mo5649c().isEmpty()) {
                c1090bM5965a5.mo5649c().add(new Keyframe_2(c1136d, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(c1136d.m5854g())));
            } else {
                if (((Keyframe_2) c1090bM5965a5.mo5649c().get(0)).f5894a == 0) {
                    z = false;
                    c1090bM5965a5.mo5649c().set(0, new Keyframe_2(c1136d, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(c1136d.m5854g())));
                }
                z2 = z;
                c1090b = c1090bM5965a5;
            }
            z = false;
            z2 = z;
            c1090b = c1090bM5965a5;
        }
        if (z3) {
            abstractC1149c.mo5918d();
        }
        AnimatablePathValue_2 c1093e = m5959a(c1093eM5907a) ? null : c1093eM5907a;
        AnimatableValue_2<PointF, PointF> interfaceC1101m = m5961a(interfaceC1101mM5908b) ? null : interfaceC1101mM5908b;
        AnimatableFloatValue_2 c1090b2 = m5958a(c1090b) ? null : c1090b;
        if (m5960a(c1095gM5971d)) {
            c1095gM5971d = null;
        }
        return new AnimatableTransform_2(c1093e, interfaceC1101m, c1095gM5971d, c1090b2, c1092dM5969b, c1090bM5965a3, c1090bM5965a4, m5962b(c1090bM5965a) ? null : c1090bM5965a, m5963c(c1090bM5965a2) ? null : c1090bM5965a2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static boolean m5959a(AnimatablePathValue_2 c1093e) {
        return c1093e == null || (c1093e.mo5648b() && c1093e.mo5649c().get(0).f5894a.equals(0.0f, 0.0f));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static boolean m5961a(AnimatableValue_2<PointF, PointF> interfaceC1101m) {
        return interfaceC1101m == null || (!(interfaceC1101m instanceof AnimatableSplitDimensionPathValue_2) && interfaceC1101m.mo5648b() && interfaceC1101m.mo5649c().get(0).f5894a.equals(0.0f, 0.0f));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: PlatformImplementations.kt_3 */
    private static boolean m5958a(AnimatableFloatValue_2 c1090b) {
        return c1090b == null || (c1090b.mo5648b() && ((Float) ((Keyframe_2) c1090b.mo5649c().get(0)).f5894a).floatValue() == 0.0f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: PlatformImplementations.kt_3 */
    private static boolean m5960a(AnimatableScaleValue_2 c1095g) {
        return c1095g == null || (c1095g.mo5648b() && ((ScaleXY_2) ((Keyframe_2) c1095g.mo5649c().get(0)).f5894a).m6178b(1.0f, 1.0f));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: IntrinsicsJvm.kt_4 */
    private static boolean m5962b(AnimatableFloatValue_2 c1090b) {
        return c1090b == null || (c1090b.mo5648b() && ((Float) ((Keyframe_2) c1090b.mo5649c().get(0)).f5894a).floatValue() == 0.0f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: IntrinsicsJvm.kt_3 */
    private static boolean m5963c(AnimatableFloatValue_2 c1090b) {
        return c1090b == null || (c1090b.mo5648b() && ((Float) ((Keyframe_2) c1090b.mo5649c().get(0)).f5894a).floatValue() == 0.0f);
    }
}
