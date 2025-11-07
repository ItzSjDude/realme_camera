package com.oplus.anim.p120e;

import android.util.JsonReader;
import com.oplus.anim.EffectiveAnimationComposition;
import com.oplus.anim.p115c.p116a.AnimatableColorValue;
import com.oplus.anim.p115c.p116a.AnimatableFloatValue;
import com.oplus.anim.p115c.p116a.AnimatableGradientColorValue;
import com.oplus.anim.p115c.p116a.AnimatableIntegerValue;
import com.oplus.anim.p115c.p116a.AnimatablePointValue;
import com.oplus.anim.p115c.p116a.AnimatableScaleValue;
import com.oplus.anim.p115c.p116a.AnimatableShapeValue;
import com.oplus.anim.p115c.p116a.AnimatableTextFrame;
import com.oplus.anim.p121f.Utils_2;
import com.oplus.anim.p122g.Keyframe;
import com.oplus.anim.p122g.ScaleXY;
import java.io.IOException;
import java.util.List;

/* compiled from: AnimatableValueParser.java */
/* renamed from: com.oplus.anim.COUIBaseListPopupWindow_8.IntrinsicsJvm.kt_5 */
/* loaded from: classes2.dex */
public class AnimatableValueParser {
    /* renamed from: PlatformImplementations.kt_3 */
    public static AnimatableFloatValue m9177a(JsonReader jsonReader, EffectiveAnimationComposition c2272a) throws IOException {
        return m9178a(jsonReader, c2272a, true);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static AnimatableFloatValue m9178a(JsonReader jsonReader, EffectiveAnimationComposition c2272a, boolean z) throws IOException {
        return new AnimatableFloatValue(m9180a(jsonReader, z ? Utils_2.m9288a() : 1.0f, c2272a, FloatParser.f10356a));
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    static AnimatableIntegerValue m9182b(JsonReader jsonReader, EffectiveAnimationComposition c2272a) throws IOException {
        return new AnimatableIntegerValue(m9181a(jsonReader, c2272a, IntegerParser.f10358a));
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    static AnimatablePointValue m9183c(JsonReader jsonReader, EffectiveAnimationComposition c2272a) throws IOException {
        return new AnimatablePointValue(m9180a(jsonReader, Utils_2.m9288a(), c2272a, PointFParser.f10363a));
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    static AnimatableScaleValue m9184d(JsonReader jsonReader, EffectiveAnimationComposition c2272a) throws IOException {
        return new AnimatableScaleValue((List<Keyframe<ScaleXY>>) m9181a(jsonReader, c2272a, ScaleXYParser.f10352a));
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    static AnimatableShapeValue m9185e(JsonReader jsonReader, EffectiveAnimationComposition c2272a) throws IOException {
        return new AnimatableShapeValue(m9180a(jsonReader, Utils_2.m9288a(), c2272a, ShapeDataParser.f10353a));
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    static AnimatableTextFrame m9186f(JsonReader jsonReader, EffectiveAnimationComposition c2272a) throws IOException {
        return new AnimatableTextFrame(m9181a(jsonReader, c2272a, DocumentDataParser.f10355a));
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    static AnimatableColorValue m9187g(JsonReader jsonReader, EffectiveAnimationComposition c2272a) throws IOException {
        return new AnimatableColorValue(m9181a(jsonReader, c2272a, ColorParser.f10354a));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static AnimatableGradientColorValue m9179a(JsonReader jsonReader, EffectiveAnimationComposition c2272a, int OplusGLSurfaceView_13) throws IOException {
        return new AnimatableGradientColorValue(m9181a(jsonReader, c2272a, new GradientColorParser(OplusGLSurfaceView_13)));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static <T> List<Keyframe<T>> m9181a(JsonReader jsonReader, EffectiveAnimationComposition c2272a, ValueParser<T> interfaceC2376aj) throws IOException {
        return KeyframesParser.m9220a(jsonReader, c2272a, 1.0f, interfaceC2376aj);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static <T> List<Keyframe<T>> m9180a(JsonReader jsonReader, float COUIBaseListPopupWindow_12, EffectiveAnimationComposition c2272a, ValueParser<T> interfaceC2376aj) throws IOException {
        return KeyframesParser.m9220a(jsonReader, c2272a, COUIBaseListPopupWindow_12, interfaceC2376aj);
    }
}
