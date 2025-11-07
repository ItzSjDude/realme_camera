package com.airbnb.lottie.p089e;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.p084c.p085a.AnimatableColorValue_2;
import com.airbnb.lottie.p084c.p085a.AnimatableFloatValue_2;
import com.airbnb.lottie.p084c.p085a.AnimatableGradientColorValue_2;
import com.airbnb.lottie.p084c.p085a.AnimatableIntegerValue_2;
import com.airbnb.lottie.p084c.p085a.AnimatablePointValue_2;
import com.airbnb.lottie.p084c.p085a.AnimatableScaleValue_2;
import com.airbnb.lottie.p084c.p085a.AnimatableShapeValue_2;
import com.airbnb.lottie.p084c.p085a.AnimatableTextFrame_2;
import com.airbnb.lottie.p089e.p090a.JsonReader;
import com.airbnb.lottie.p091f.Utils_4;
import com.airbnb.lottie.p092g.Keyframe_2;
import com.airbnb.lottie.p092g.ScaleXY_2;
import java.io.IOException;
import java.util.List;

/* compiled from: AnimatableValueParser.java */
/* renamed from: com.airbnb.lottie.COUIBaseListPopupWindow_8.IntrinsicsJvm.kt_5 */
/* loaded from: classes.dex */
public class AnimatableValueParser_2 {
    /* renamed from: PlatformImplementations.kt_3 */
    public static AnimatableFloatValue_2 m5964a(JsonReader abstractC1149c, LottieComposition c1136d) throws IOException {
        return m5965a(abstractC1149c, c1136d, true);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static AnimatableFloatValue_2 m5965a(JsonReader abstractC1149c, LottieComposition c1136d, boolean z) throws IOException {
        return new AnimatableFloatValue_2(m5967a(abstractC1149c, z ? Utils_4.m6139a() : 1.0f, c1136d, FloatParser_2.f5786a));
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    static AnimatableIntegerValue_2 m5969b(JsonReader abstractC1149c, LottieComposition c1136d) throws IOException {
        return new AnimatableIntegerValue_2(m5968a(abstractC1149c, c1136d, IntegerParser_2.f5796a));
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    static AnimatablePointValue_2 m5970c(JsonReader abstractC1149c, LottieComposition c1136d) throws IOException {
        return new AnimatablePointValue_2(KeyframesParser_2.m6003a(abstractC1149c, c1136d, Utils_4.m6139a(), PointFParser_2.f5814a, true));
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    static AnimatableScaleValue_2 m5971d(JsonReader abstractC1149c, LottieComposition c1136d) throws IOException {
        return new AnimatableScaleValue_2((List<Keyframe_2<ScaleXY_2>>) m5968a(abstractC1149c, c1136d, ScaleXYParser_2.f5768a));
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    static AnimatableShapeValue_2 m5972e(JsonReader abstractC1149c, LottieComposition c1136d) throws IOException {
        return new AnimatableShapeValue_2(m5967a(abstractC1149c, Utils_4.m6139a(), c1136d, ShapeDataParser_2.f5769a));
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    static AnimatableTextFrame_2 m5973f(JsonReader abstractC1149c, LottieComposition c1136d) throws IOException {
        return new AnimatableTextFrame_2(m5968a(abstractC1149c, c1136d, DocumentDataParser_2.f5784a));
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    static AnimatableColorValue_2 m5974g(JsonReader abstractC1149c, LottieComposition c1136d) throws IOException {
        return new AnimatableColorValue_2(m5968a(abstractC1149c, c1136d, ColorParser_2.f5782a));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static AnimatableGradientColorValue_2 m5966a(JsonReader abstractC1149c, LottieComposition c1136d, int OplusGLSurfaceView_13) throws IOException {
        return new AnimatableGradientColorValue_2(m5968a(abstractC1149c, c1136d, new GradientColorParser_2(OplusGLSurfaceView_13)));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static <T> List<Keyframe_2<T>> m5968a(JsonReader abstractC1149c, LottieComposition c1136d, ValueParser_2<T> interfaceC1161aj) throws IOException {
        return KeyframesParser_2.m6003a(abstractC1149c, c1136d, 1.0f, interfaceC1161aj, false);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static <T> List<Keyframe_2<T>> m5967a(JsonReader abstractC1149c, float COUIBaseListPopupWindow_12, LottieComposition c1136d, ValueParser_2<T> interfaceC1161aj) throws IOException {
        return KeyframesParser_2.m6003a(abstractC1149c, c1136d, COUIBaseListPopupWindow_12, interfaceC1161aj, false);
    }
}
