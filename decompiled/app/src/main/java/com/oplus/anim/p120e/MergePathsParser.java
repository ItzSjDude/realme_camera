package com.oplus.anim.p120e;

import android.util.JsonReader;
import com.oplus.anim.p115c.p117b.MergePaths;
import java.io.IOException;

/* compiled from: MergePathsParser.java */
/* renamed from: com.oplus.anim.COUIBaseListPopupWindow_8.v */
/* loaded from: classes2.dex */
class MergePathsParser {
    /* renamed from: PlatformImplementations.kt_3 */
    static MergePaths m9225a(JsonReader jsonReader) throws IOException {
        String strNextString = null;
        boolean zNextBoolean = false;
        MergePaths.PlatformImplementations.kt_3 aVarForId = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            char c2 = 65535;
            int iHashCode = strNextName.hashCode();
            if (iHashCode != 3324) {
                if (iHashCode != 3488) {
                    if (iHashCode == 3519 && strNextName.equals("nm")) {
                        c2 = 0;
                    }
                } else if (strNextName.equals("mm")) {
                    c2 = 1;
                }
            } else if (strNextName.equals("hd")) {
                c2 = 2;
            }
            if (c2 == 0) {
                strNextString = jsonReader.nextString();
            } else if (c2 == 1) {
                aVarForId = MergePaths.PlatformImplementations.kt_3.forId(jsonReader.nextInt());
            } else if (c2 == 2) {
                zNextBoolean = jsonReader.nextBoolean();
            } else {
                jsonReader.skipValue();
            }
        }
        return new MergePaths(strNextString, aVarForId, zNextBoolean);
    }
}
