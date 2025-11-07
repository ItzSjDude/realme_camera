package com.airbnb.lottie.p089e;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.p084c.p086b.ShapeGroup_2;
import com.airbnb.lottie.p084c.p086b.ContentModel_2;
import com.airbnb.lottie.p089e.p090a.JsonReader;
import java.io.IOException;
import java.util.ArrayList;

/* compiled from: ShapeGroupParser.java */
/* renamed from: com.airbnb.lottie.COUIBaseListPopupWindow_8.af */
/* loaded from: classes.dex */
class ShapeGroupParser_2 {

    /* renamed from: PlatformImplementations.kt_3 */
    private static JsonReader.PlatformImplementations.kt_3 f5772a = JsonReader.PlatformImplementations.kt_3.m5929a("nm", "hd", "it");

    /* renamed from: PlatformImplementations.kt_3 */
    static ShapeGroup_2 m5951a(JsonReader abstractC1149c, LottieComposition c1136d) throws IOException {
        ArrayList arrayList = new ArrayList();
        String strMo5923i = null;
        boolean zMo5924j = false;
        while (abstractC1149c.mo5919e()) {
            int iMo5912a = abstractC1149c.mo5912a(f5772a);
            if (iMo5912a == 0) {
                strMo5923i = abstractC1149c.mo5923i();
            } else if (iMo5912a == 1) {
                zMo5924j = abstractC1149c.mo5924j();
            } else if (iMo5912a == 2) {
                abstractC1149c.mo5914a();
                while (abstractC1149c.mo5919e()) {
                    ContentModel_2 interfaceC1105bM5977a = ContentModelParser_2.m5977a(abstractC1149c, c1136d);
                    if (interfaceC1105bM5977a != null) {
                        arrayList.add(interfaceC1105bM5977a);
                    }
                }
                abstractC1149c.mo5916b();
            } else {
                abstractC1149c.mo5927m();
            }
        }
        return new ShapeGroup_2(strMo5923i, arrayList, zMo5924j);
    }
}
