package com.airbnb.lottie.p089e;

import com.airbnb.lottie.p084c.Font_2;
import com.airbnb.lottie.p089e.p090a.JsonReader;
import java.io.IOException;

/* compiled from: FontParser.java */
/* renamed from: com.airbnb.lottie.COUIBaseListPopupWindow_8.OplusGLSurfaceView_5 */
/* loaded from: classes.dex */
class FontParser_2 {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final JsonReader.PlatformImplementations.kt_3 f5789a = JsonReader.PlatformImplementations.kt_3.m5929a("fFamily", "fName", "fStyle", "ascent");

    /* renamed from: PlatformImplementations.kt_3 */
    static Font_2 m5981a(JsonReader abstractC1149c) throws IOException {
        abstractC1149c.mo5917c();
        String strMo5923i = null;
        String strMo5923i2 = null;
        float fMo5925k = 0.0f;
        String strMo5923i3 = null;
        while (abstractC1149c.mo5919e()) {
            int iMo5912a = abstractC1149c.mo5912a(f5789a);
            if (iMo5912a == 0) {
                strMo5923i = abstractC1149c.mo5923i();
            } else if (iMo5912a == 1) {
                strMo5923i3 = abstractC1149c.mo5923i();
            } else if (iMo5912a == 2) {
                strMo5923i2 = abstractC1149c.mo5923i();
            } else if (iMo5912a == 3) {
                fMo5925k = (float) abstractC1149c.mo5925k();
            } else {
                abstractC1149c.mo5922h();
                abstractC1149c.mo5927m();
            }
        }
        abstractC1149c.mo5918d();
        return new Font_2(strMo5923i, strMo5923i3, strMo5923i2, fMo5925k);
    }
}
