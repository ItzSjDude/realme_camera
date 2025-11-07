package com.airbnb.lottie.p089e;

import android.graphics.PointF;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.p084c.p085a.AnimatableFloatValue_2;
import com.airbnb.lottie.p084c.p085a.AnimatableValue_2;
import com.airbnb.lottie.p084c.p086b.PolystarShape_3;
import com.airbnb.lottie.p089e.p090a.JsonReader;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.io.IOException;

/* compiled from: PolystarShapeParser.java */
/* renamed from: com.airbnb.lottie.COUIBaseListPopupWindow_8.z */
/* loaded from: classes.dex */
class PolystarShapeParser_2 {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final JsonReader.PlatformImplementations.kt_3 f5815a = JsonReader.PlatformImplementations.kt_3.m5929a("nm", "sy", "pt", TtmlNode.TAG_P, "r", "or", "os", "ir", "is", "hd");

    /* renamed from: PlatformImplementations.kt_3 */
    static PolystarShape_3 m6018a(JsonReader abstractC1149c, LottieComposition c1136d) throws IOException {
        boolean zMo5924j = false;
        String strMo5923i = null;
        PolystarShape_3.PlatformImplementations.kt_3 aVarForValue = null;
        AnimatableFloatValue_2 c1090bM5965a = null;
        AnimatableValue_2<PointF, PointF> interfaceC1101mM5908b = null;
        AnimatableFloatValue_2 c1090bM5965a2 = null;
        AnimatableFloatValue_2 c1090bM5964a = null;
        AnimatableFloatValue_2 c1090bM5964a2 = null;
        AnimatableFloatValue_2 c1090bM5965a3 = null;
        AnimatableFloatValue_2 c1090bM5965a4 = null;
        while (abstractC1149c.mo5919e()) {
            switch (abstractC1149c.mo5912a(f5815a)) {
                case 0:
                    strMo5923i = abstractC1149c.mo5923i();
                    break;
                case 1:
                    aVarForValue = PolystarShape_3.PlatformImplementations.kt_3.forValue(abstractC1149c.mo5926l());
                    break;
                case 2:
                    c1090bM5965a = AnimatableValueParser_2.m5965a(abstractC1149c, c1136d, false);
                    break;
                case 3:
                    interfaceC1101mM5908b = AnimatablePathValueParser_2.m5908b(abstractC1149c, c1136d);
                    break;
                case 4:
                    c1090bM5965a2 = AnimatableValueParser_2.m5965a(abstractC1149c, c1136d, false);
                    break;
                case 5:
                    c1090bM5964a2 = AnimatableValueParser_2.m5964a(abstractC1149c, c1136d);
                    break;
                case 6:
                    c1090bM5965a4 = AnimatableValueParser_2.m5965a(abstractC1149c, c1136d, false);
                    break;
                case 7:
                    c1090bM5964a = AnimatableValueParser_2.m5964a(abstractC1149c, c1136d);
                    break;
                case 8:
                    c1090bM5965a3 = AnimatableValueParser_2.m5965a(abstractC1149c, c1136d, false);
                    break;
                case 9:
                    zMo5924j = abstractC1149c.mo5924j();
                    break;
                default:
                    abstractC1149c.mo5922h();
                    abstractC1149c.mo5927m();
                    break;
            }
        }
        return new PolystarShape_3(strMo5923i, aVarForValue, c1090bM5965a, interfaceC1101mM5908b, c1090bM5965a2, c1090bM5964a, c1090bM5964a2, c1090bM5965a3, c1090bM5965a4, zMo5924j);
    }
}
