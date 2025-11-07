package com.airbnb.lottie.p089e;

import android.graphics.PointF;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.p084c.p085a.AnimatableFloatValue_2;
import com.airbnb.lottie.p084c.p085a.AnimatablePointValue_2;
import com.airbnb.lottie.p084c.p085a.AnimatableValue_2;
import com.airbnb.lottie.p084c.p086b.RectangleShape_2;
import com.airbnb.lottie.p089e.p090a.JsonReader;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.io.IOException;

/* compiled from: RectangleShapeParser.java */
/* renamed from: com.airbnb.lottie.COUIBaseListPopupWindow_8.aa */
/* loaded from: classes.dex */
class RectangleShapeParser_2 {

    /* renamed from: PlatformImplementations.kt_3 */
    private static JsonReader.PlatformImplementations.kt_3 f5766a = JsonReader.PlatformImplementations.kt_3.m5929a("nm", TtmlNode.TAG_P, "s", "r", "hd");

    /* renamed from: PlatformImplementations.kt_3 */
    static RectangleShape_2 m5945a(JsonReader abstractC1149c, LottieComposition c1136d) throws IOException {
        String strMo5923i = null;
        AnimatableValue_2<PointF, PointF> interfaceC1101mM5908b = null;
        AnimatablePointValue_2 c1094fM5970c = null;
        AnimatableFloatValue_2 c1090bM5964a = null;
        boolean zMo5924j = false;
        while (abstractC1149c.mo5919e()) {
            int iMo5912a = abstractC1149c.mo5912a(f5766a);
            if (iMo5912a == 0) {
                strMo5923i = abstractC1149c.mo5923i();
            } else if (iMo5912a == 1) {
                interfaceC1101mM5908b = AnimatablePathValueParser_2.m5908b(abstractC1149c, c1136d);
            } else if (iMo5912a == 2) {
                c1094fM5970c = AnimatableValueParser_2.m5970c(abstractC1149c, c1136d);
            } else if (iMo5912a == 3) {
                c1090bM5964a = AnimatableValueParser_2.m5964a(abstractC1149c, c1136d);
            } else if (iMo5912a == 4) {
                zMo5924j = abstractC1149c.mo5924j();
            } else {
                abstractC1149c.mo5927m();
            }
        }
        return new RectangleShape_2(strMo5923i, interfaceC1101mM5908b, c1094fM5970c, c1090bM5964a, zMo5924j);
    }
}
