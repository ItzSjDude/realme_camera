package com.airbnb.lottie.p089e;

import com.airbnb.lottie.p084c.p086b.MergePaths_3;
import com.airbnb.lottie.p089e.p090a.JsonReader;
import java.io.IOException;

/* compiled from: MergePathsParser.java */
/* renamed from: com.airbnb.lottie.COUIBaseListPopupWindow_8.v */
/* loaded from: classes.dex */
class MergePathsParser_2 {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final JsonReader.PlatformImplementations.kt_3 f5812a = JsonReader.PlatformImplementations.kt_3.m5929a("nm", "mm", "hd");

    /* renamed from: PlatformImplementations.kt_3 */
    static MergePaths_3 m6014a(JsonReader abstractC1149c) throws IOException {
        String strMo5923i = null;
        boolean zMo5924j = false;
        MergePaths_3.PlatformImplementations.kt_3 aVarForId = null;
        while (abstractC1149c.mo5919e()) {
            int iMo5912a = abstractC1149c.mo5912a(f5812a);
            if (iMo5912a == 0) {
                strMo5923i = abstractC1149c.mo5923i();
            } else if (iMo5912a == 1) {
                aVarForId = MergePaths_3.PlatformImplementations.kt_3.forId(abstractC1149c.mo5926l());
            } else if (iMo5912a == 2) {
                zMo5924j = abstractC1149c.mo5924j();
            } else {
                abstractC1149c.mo5922h();
                abstractC1149c.mo5927m();
            }
        }
        return new MergePaths_3(strMo5923i, aVarForId, zMo5924j);
    }
}
