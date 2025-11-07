package com.airbnb.lottie.p089e;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.p084c.FontCharacter_2;
import com.airbnb.lottie.p084c.p086b.ShapeGroup_2;
import com.airbnb.lottie.p089e.p090a.JsonReader;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.oplus.ocs.camera.CameraParameter;
import java.io.IOException;
import java.util.ArrayList;

/* compiled from: FontCharacterParser.java */
/* renamed from: com.airbnb.lottie.COUIBaseListPopupWindow_8.OplusGLSurfaceView_15 */
/* loaded from: classes.dex */
class FontCharacterParser_2 {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final JsonReader.PlatformImplementations.kt_3 f5787a = JsonReader.PlatformImplementations.kt_3.m5929a("ch", CameraParameter.WaterMarkParamKeys.SIZE, "w", TtmlNode.TAG_STYLE, "fFamily", "data");

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static final JsonReader.PlatformImplementations.kt_3 f5788b = JsonReader.PlatformImplementations.kt_3.m5929a("shapes");

    /* renamed from: PlatformImplementations.kt_3 */
    static FontCharacter_2 m5980a(JsonReader abstractC1149c, LottieComposition c1136d) throws IOException {
        ArrayList arrayList = new ArrayList();
        abstractC1149c.mo5917c();
        String strMo5923i = null;
        String strMo5923i2 = null;
        double dMo5925k = 0.0d;
        double dMo5925k2 = 0.0d;
        char cCharAt = 0;
        while (abstractC1149c.mo5919e()) {
            int iMo5912a = abstractC1149c.mo5912a(f5787a);
            if (iMo5912a == 0) {
                cCharAt = abstractC1149c.mo5923i().charAt(0);
            } else if (iMo5912a == 1) {
                dMo5925k = abstractC1149c.mo5925k();
            } else if (iMo5912a == 2) {
                dMo5925k2 = abstractC1149c.mo5925k();
            } else if (iMo5912a == 3) {
                strMo5923i = abstractC1149c.mo5923i();
            } else if (iMo5912a == 4) {
                strMo5923i2 = abstractC1149c.mo5923i();
            } else if (iMo5912a == 5) {
                abstractC1149c.mo5917c();
                while (abstractC1149c.mo5919e()) {
                    if (abstractC1149c.mo5912a(f5788b) == 0) {
                        abstractC1149c.mo5914a();
                        while (abstractC1149c.mo5919e()) {
                            arrayList.add((ShapeGroup_2) ContentModelParser_2.m5977a(abstractC1149c, c1136d));
                        }
                        abstractC1149c.mo5916b();
                    } else {
                        abstractC1149c.mo5922h();
                        abstractC1149c.mo5927m();
                    }
                }
                abstractC1149c.mo5918d();
            } else {
                abstractC1149c.mo5922h();
                abstractC1149c.mo5927m();
            }
        }
        abstractC1149c.mo5918d();
        return new FontCharacter_2(arrayList, cCharAt, dMo5925k, dMo5925k2, strMo5923i, strMo5923i2);
    }
}
