package com.airbnb.lottie.p089e;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.p084c.p085a.AnimatableColorValue_2;
import com.airbnb.lottie.p084c.p085a.AnimatableFloatValue_2;
import com.airbnb.lottie.p084c.p085a.AnimatableTextProperties_2;
import com.airbnb.lottie.p089e.p090a.JsonReader;
import java.io.IOException;

/* compiled from: AnimatableTextPropertiesParser.java */
/* renamed from: com.airbnb.lottie.COUIBaseListPopupWindow_8.IntrinsicsJvm.kt_4 */
/* loaded from: classes.dex */
public class AnimatableTextPropertiesParser_2 {

    /* renamed from: PlatformImplementations.kt_3 */
    private static JsonReader.PlatformImplementations.kt_3 f5777a = JsonReader.PlatformImplementations.kt_3.m5929a("PlatformImplementations.kt_3");

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static JsonReader.PlatformImplementations.kt_3 f5778b = JsonReader.PlatformImplementations.kt_3.m5929a("fc", "sc", "sw", "t");

    /* renamed from: PlatformImplementations.kt_3 */
    public static AnimatableTextProperties_2 m5955a(JsonReader abstractC1149c, LottieComposition c1136d) throws IOException {
        abstractC1149c.mo5917c();
        AnimatableTextProperties_2 c1099kM5956b = null;
        while (abstractC1149c.mo5919e()) {
            if (abstractC1149c.mo5912a(f5777a) == 0) {
                c1099kM5956b = m5956b(abstractC1149c, c1136d);
            } else {
                abstractC1149c.mo5922h();
                abstractC1149c.mo5927m();
            }
        }
        abstractC1149c.mo5918d();
        return c1099kM5956b == null ? new AnimatableTextProperties_2(null, null, null, null) : c1099kM5956b;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static AnimatableTextProperties_2 m5956b(JsonReader abstractC1149c, LottieComposition c1136d) throws IOException {
        abstractC1149c.mo5917c();
        AnimatableColorValue_2 c1089aM5974g = null;
        AnimatableColorValue_2 c1089aM5974g2 = null;
        AnimatableFloatValue_2 c1090bM5964a = null;
        AnimatableFloatValue_2 c1090bM5964a2 = null;
        while (abstractC1149c.mo5919e()) {
            int iMo5912a = abstractC1149c.mo5912a(f5778b);
            if (iMo5912a == 0) {
                c1089aM5974g = AnimatableValueParser_2.m5974g(abstractC1149c, c1136d);
            } else if (iMo5912a == 1) {
                c1089aM5974g2 = AnimatableValueParser_2.m5974g(abstractC1149c, c1136d);
            } else if (iMo5912a == 2) {
                c1090bM5964a = AnimatableValueParser_2.m5964a(abstractC1149c, c1136d);
            } else if (iMo5912a == 3) {
                c1090bM5964a2 = AnimatableValueParser_2.m5964a(abstractC1149c, c1136d);
            } else {
                abstractC1149c.mo5922h();
                abstractC1149c.mo5927m();
            }
        }
        abstractC1149c.mo5918d();
        return new AnimatableTextProperties_2(c1089aM5974g, c1089aM5974g2, c1090bM5964a, c1090bM5964a2);
    }
}
