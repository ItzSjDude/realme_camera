package com.airbnb.lottie.p089e;

import android.graphics.PointF;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.p084c.p085a.AnimatablePointValue_2;
import com.airbnb.lottie.p084c.p085a.AnimatableValue_2;
import com.airbnb.lottie.p084c.p086b.CircleShape_2;
import com.airbnb.lottie.p089e.p090a.JsonReader;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.io.IOException;

/* compiled from: CircleShapeParser.java */
/* renamed from: com.airbnb.lottie.COUIBaseListPopupWindow_8.COUIBaseListPopupWindow_8 */
/* loaded from: classes.dex */
class CircleShapeParser_2 {

    /* renamed from: PlatformImplementations.kt_3 */
    private static JsonReader.PlatformImplementations.kt_3 f5781a = JsonReader.PlatformImplementations.kt_3.m5929a("nm", TtmlNode.TAG_P, "s", "hd", "IntrinsicsJvm.kt_5");

    /* renamed from: PlatformImplementations.kt_3 */
    static CircleShape_2 m5975a(JsonReader abstractC1149c, LottieComposition c1136d, int OplusGLSurfaceView_13) throws IOException {
        boolean z = OplusGLSurfaceView_13 == 3;
        boolean zMo5924j = false;
        String strMo5923i = null;
        AnimatableValue_2<PointF, PointF> interfaceC1101mM5908b = null;
        AnimatablePointValue_2 c1094fM5970c = null;
        while (abstractC1149c.mo5919e()) {
            int iMo5912a = abstractC1149c.mo5912a(f5781a);
            if (iMo5912a == 0) {
                strMo5923i = abstractC1149c.mo5923i();
            } else if (iMo5912a == 1) {
                interfaceC1101mM5908b = AnimatablePathValueParser_2.m5908b(abstractC1149c, c1136d);
            } else if (iMo5912a == 2) {
                c1094fM5970c = AnimatableValueParser_2.m5970c(abstractC1149c, c1136d);
            } else if (iMo5912a == 3) {
                zMo5924j = abstractC1149c.mo5924j();
            } else if (iMo5912a == 4) {
                z = abstractC1149c.mo5926l() == 3;
            } else {
                abstractC1149c.mo5922h();
                abstractC1149c.mo5927m();
            }
        }
        return new CircleShape_2(strMo5923i, interfaceC1101mM5908b, c1094fM5970c, z, zMo5924j);
    }
}
