package com.airbnb.lottie.p089e;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.p084c.p085a.AnimatableShapeValue_2;
import com.airbnb.lottie.p084c.p086b.ShapePath_2;
import com.airbnb.lottie.p089e.p090a.JsonReader;
import java.io.IOException;

/* compiled from: ShapePathParser.java */
/* renamed from: com.airbnb.lottie.COUIBaseListPopupWindow_8.ag */
/* loaded from: classes.dex */
class ShapePathParser_2 {

    /* renamed from: PlatformImplementations.kt_3 */
    static JsonReader.PlatformImplementations.kt_3 f5773a = JsonReader.PlatformImplementations.kt_3.m5929a("nm", "ind", "ks", "hd");

    /* renamed from: PlatformImplementations.kt_3 */
    static ShapePath_2 m5952a(JsonReader abstractC1149c, LottieComposition c1136d) throws IOException {
        int iMo5926l = 0;
        String strMo5923i = null;
        boolean zMo5924j = false;
        AnimatableShapeValue_2 c1096hM5972e = null;
        while (abstractC1149c.mo5919e()) {
            int iMo5912a = abstractC1149c.mo5912a(f5773a);
            if (iMo5912a == 0) {
                strMo5923i = abstractC1149c.mo5923i();
            } else if (iMo5912a == 1) {
                iMo5926l = abstractC1149c.mo5926l();
            } else if (iMo5912a == 2) {
                c1096hM5972e = AnimatableValueParser_2.m5972e(abstractC1149c, c1136d);
            } else if (iMo5912a == 3) {
                zMo5924j = abstractC1149c.mo5924j();
            } else {
                abstractC1149c.mo5927m();
            }
        }
        return new ShapePath_2(strMo5923i, iMo5926l, c1096hM5972e, zMo5924j);
    }
}
