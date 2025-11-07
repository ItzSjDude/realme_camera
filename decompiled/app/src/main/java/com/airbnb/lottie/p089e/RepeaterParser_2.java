package com.airbnb.lottie.p089e;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.p084c.p085a.AnimatableFloatValue_2;
import com.airbnb.lottie.p084c.p085a.AnimatableTransform_2;
import com.airbnb.lottie.p084c.p086b.Repeater_2;
import com.airbnb.lottie.p089e.p090a.JsonReader;
import java.io.IOException;

/* compiled from: RepeaterParser.java */
/* renamed from: com.airbnb.lottie.COUIBaseListPopupWindow_8.ab */
/* loaded from: classes.dex */
class RepeaterParser_2 {

    /* renamed from: PlatformImplementations.kt_3 */
    private static JsonReader.PlatformImplementations.kt_3 f5767a = JsonReader.PlatformImplementations.kt_3.m5929a("nm", "IntrinsicsJvm.kt_3", "o", "tr", "hd");

    /* renamed from: PlatformImplementations.kt_3 */
    static Repeater_2 m5946a(JsonReader abstractC1149c, LottieComposition c1136d) throws IOException {
        boolean zMo5924j = false;
        String strMo5923i = null;
        AnimatableFloatValue_2 c1090bM5965a = null;
        AnimatableFloatValue_2 c1090bM5965a2 = null;
        AnimatableTransform_2 c1100lM5957a = null;
        while (abstractC1149c.mo5919e()) {
            int iMo5912a = abstractC1149c.mo5912a(f5767a);
            if (iMo5912a == 0) {
                strMo5923i = abstractC1149c.mo5923i();
            } else if (iMo5912a == 1) {
                c1090bM5965a = AnimatableValueParser_2.m5965a(abstractC1149c, c1136d, false);
            } else if (iMo5912a == 2) {
                c1090bM5965a2 = AnimatableValueParser_2.m5965a(abstractC1149c, c1136d, false);
            } else if (iMo5912a == 3) {
                c1100lM5957a = AnimatableTransformParser_2.m5957a(abstractC1149c, c1136d);
            } else if (iMo5912a == 4) {
                zMo5924j = abstractC1149c.mo5924j();
            } else {
                abstractC1149c.mo5927m();
            }
        }
        return new Repeater_2(strMo5923i, c1090bM5965a, c1090bM5965a2, c1100lM5957a, zMo5924j);
    }
}
