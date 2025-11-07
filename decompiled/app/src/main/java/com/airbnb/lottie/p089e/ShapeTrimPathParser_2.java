package com.airbnb.lottie.p089e;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.p084c.p085a.AnimatableFloatValue_2;
import com.airbnb.lottie.p084c.p086b.ShapeTrimPath_3;
import com.airbnb.lottie.p089e.p090a.JsonReader;
import java.io.IOException;

/* compiled from: ShapeTrimPathParser.java */
/* renamed from: com.airbnb.lottie.COUIBaseListPopupWindow_8.ai */
/* loaded from: classes.dex */
class ShapeTrimPathParser_2 {

    /* renamed from: PlatformImplementations.kt_3 */
    private static JsonReader.PlatformImplementations.kt_3 f5776a = JsonReader.PlatformImplementations.kt_3.m5929a("s", "COUIBaseListPopupWindow_8", "o", "nm", "OplusGLSurfaceView_6", "hd");

    /* renamed from: PlatformImplementations.kt_3 */
    static ShapeTrimPath_3 m5954a(JsonReader abstractC1149c, LottieComposition c1136d) throws IOException {
        boolean zMo5924j = false;
        String strMo5923i = null;
        ShapeTrimPath_3.PlatformImplementations.kt_3 aVarForId = null;
        AnimatableFloatValue_2 c1090bM5965a = null;
        AnimatableFloatValue_2 c1090bM5965a2 = null;
        AnimatableFloatValue_2 c1090bM5965a3 = null;
        while (abstractC1149c.mo5919e()) {
            int iMo5912a = abstractC1149c.mo5912a(f5776a);
            if (iMo5912a == 0) {
                c1090bM5965a = AnimatableValueParser_2.m5965a(abstractC1149c, c1136d, false);
            } else if (iMo5912a == 1) {
                c1090bM5965a2 = AnimatableValueParser_2.m5965a(abstractC1149c, c1136d, false);
            } else if (iMo5912a == 2) {
                c1090bM5965a3 = AnimatableValueParser_2.m5965a(abstractC1149c, c1136d, false);
            } else if (iMo5912a == 3) {
                strMo5923i = abstractC1149c.mo5923i();
            } else if (iMo5912a == 4) {
                aVarForId = ShapeTrimPath_3.PlatformImplementations.kt_3.forId(abstractC1149c.mo5926l());
            } else if (iMo5912a == 5) {
                zMo5924j = abstractC1149c.mo5924j();
            } else {
                abstractC1149c.mo5927m();
            }
        }
        return new ShapeTrimPath_3(strMo5923i, aVarForId, c1090bM5965a, c1090bM5965a2, c1090bM5965a3, zMo5924j);
    }
}
