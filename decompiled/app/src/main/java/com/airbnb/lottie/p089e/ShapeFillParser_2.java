package com.airbnb.lottie.p089e;

import android.graphics.Path;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.p084c.p085a.AnimatableColorValue_2;
import com.airbnb.lottie.p084c.p085a.AnimatableIntegerValue_2;
import com.airbnb.lottie.p084c.p086b.ShapeFill_2;
import com.airbnb.lottie.p089e.p090a.JsonReader;
import com.airbnb.lottie.p092g.Keyframe_2;
import java.io.IOException;
import java.util.Collections;

/* compiled from: ShapeFillParser.java */
/* renamed from: com.airbnb.lottie.COUIBaseListPopupWindow_8.ae */
/* loaded from: classes.dex */
class ShapeFillParser_2 {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final JsonReader.PlatformImplementations.kt_3 f5771a = JsonReader.PlatformImplementations.kt_3.m5929a("nm", "IntrinsicsJvm.kt_3", "o", "fillEnabled", "r", "hd");

    /* renamed from: PlatformImplementations.kt_3 */
    static ShapeFill_2 m5950a(JsonReader abstractC1149c, LottieComposition c1136d) throws IOException {
        AnimatableIntegerValue_2 c1092d = null;
        boolean zMo5924j = false;
        boolean zMo5924j2 = false;
        int iMo5926l = 1;
        String strMo5923i = null;
        AnimatableColorValue_2 c1089aM5974g = null;
        while (abstractC1149c.mo5919e()) {
            int iMo5912a = abstractC1149c.mo5912a(f5771a);
            if (iMo5912a == 0) {
                strMo5923i = abstractC1149c.mo5923i();
            } else if (iMo5912a == 1) {
                c1089aM5974g = AnimatableValueParser_2.m5974g(abstractC1149c, c1136d);
            } else if (iMo5912a == 2) {
                c1092d = AnimatableValueParser_2.m5969b(abstractC1149c, c1136d);
            } else if (iMo5912a == 3) {
                zMo5924j = abstractC1149c.mo5924j();
            } else if (iMo5912a == 4) {
                iMo5926l = abstractC1149c.mo5926l();
            } else if (iMo5912a == 5) {
                zMo5924j2 = abstractC1149c.mo5924j();
            } else {
                abstractC1149c.mo5922h();
                abstractC1149c.mo5927m();
            }
        }
        if (c1092d == null) {
            c1092d = new AnimatableIntegerValue_2(Collections.singletonList(new Keyframe_2(100)));
        }
        return new ShapeFill_2(strMo5923i, zMo5924j, iMo5926l == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD, c1089aM5974g, c1092d, zMo5924j2);
    }
}
