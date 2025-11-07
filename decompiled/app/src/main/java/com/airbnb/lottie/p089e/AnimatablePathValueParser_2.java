package com.airbnb.lottie.p089e;

import android.graphics.PointF;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.p084c.p085a.AnimatableFloatValue_2;
import com.airbnb.lottie.p084c.p085a.AnimatablePathValue_2;
import com.airbnb.lottie.p084c.p085a.AnimatableSplitDimensionPathValue_2;
import com.airbnb.lottie.p084c.p085a.AnimatableValue_2;
import com.airbnb.lottie.p089e.p090a.JsonReader;
import com.airbnb.lottie.p091f.Utils_4;
import com.airbnb.lottie.p092g.Keyframe_2;
import java.io.IOException;
import java.util.ArrayList;

/* compiled from: AnimatablePathValueParser.java */
/* renamed from: com.airbnb.lottie.COUIBaseListPopupWindow_8.PlatformImplementations.kt_3 */
/* loaded from: classes.dex */
public class AnimatablePathValueParser_2 {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final JsonReader.PlatformImplementations.kt_3 f5745a = JsonReader.PlatformImplementations.kt_3.m5929a("OplusGLSurfaceView_5", "x", "y");

    /* renamed from: PlatformImplementations.kt_3 */
    public static AnimatablePathValue_2 m5907a(JsonReader abstractC1149c, LottieComposition c1136d) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (abstractC1149c.mo5920f() == JsonReader.IntrinsicsJvm.kt_4.BEGIN_ARRAY) {
            abstractC1149c.mo5914a();
            while (abstractC1149c.mo5919e()) {
                arrayList.add(PathKeyframeParser_2.m6015a(abstractC1149c, c1136d));
            }
            abstractC1149c.mo5916b();
            KeyframesParser_2.m6004a(arrayList);
        } else {
            arrayList.add(new Keyframe_2(JsonUtils_3.m5991b(abstractC1149c, Utils_4.m6139a())));
        }
        return new AnimatablePathValue_2(arrayList);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    static AnimatableValue_2<PointF, PointF> m5908b(JsonReader abstractC1149c, LottieComposition c1136d) throws IOException {
        abstractC1149c.mo5917c();
        AnimatablePathValue_2 c1093eM5907a = null;
        boolean z = false;
        AnimatableFloatValue_2 c1090bM5964a = null;
        AnimatableFloatValue_2 c1090bM5964a2 = null;
        while (abstractC1149c.mo5920f() != JsonReader.IntrinsicsJvm.kt_4.END_OBJECT) {
            int iMo5912a = abstractC1149c.mo5912a(f5745a);
            if (iMo5912a == 0) {
                c1093eM5907a = m5907a(abstractC1149c, c1136d);
            } else if (iMo5912a != 1) {
                if (iMo5912a == 2) {
                    if (abstractC1149c.mo5920f() == JsonReader.IntrinsicsJvm.kt_4.STRING) {
                        abstractC1149c.mo5927m();
                        z = true;
                    } else {
                        c1090bM5964a2 = AnimatableValueParser_2.m5964a(abstractC1149c, c1136d);
                    }
                } else {
                    abstractC1149c.mo5922h();
                    abstractC1149c.mo5927m();
                }
            } else if (abstractC1149c.mo5920f() == JsonReader.IntrinsicsJvm.kt_4.STRING) {
                abstractC1149c.mo5927m();
                z = true;
            } else {
                c1090bM5964a = AnimatableValueParser_2.m5964a(abstractC1149c, c1136d);
            }
        }
        abstractC1149c.mo5918d();
        if (z) {
            c1136d.m5843a("Lottie doesn't support expressions.");
        }
        return c1093eM5907a != null ? c1093eM5907a : new AnimatableSplitDimensionPathValue_2(c1090bM5964a, c1090bM5964a2);
    }
}
