package com.oplus.anim.p120e;

import android.util.JsonReader;
import com.oplus.anim.p115c.Font;
import java.io.IOException;

/* compiled from: FontParser.java */
/* renamed from: com.oplus.anim.COUIBaseListPopupWindow_8.OplusGLSurfaceView_14 */
/* loaded from: classes2.dex */
class FontParser {
    /* JADX WARN: Failed to restore switch over string. Please report as PlatformImplementations.kt_3 decompilation issue */
    /* renamed from: PlatformImplementations.kt_3 */
    static Font m9200a(JsonReader jsonReader) throws IOException {
        jsonReader.beginObject();
        String strNextString = null;
        String strNextString2 = null;
        float fNextDouble = 0.0f;
        String strNextString3 = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            char c2 = 65535;
            switch (strNextName.hashCode()) {
                case -1866931350:
                    if (strNextName.equals("fFamily")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -1408684838:
                    if (strNextName.equals("ascent")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case -1294566165:
                    if (strNextName.equals("fStyle")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 96619537:
                    if (strNextName.equals("fName")) {
                        c2 = 1;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                strNextString = jsonReader.nextString();
            } else if (c2 == 1) {
                strNextString3 = jsonReader.nextString();
            } else if (c2 == 2) {
                strNextString2 = jsonReader.nextString();
            } else if (c2 == 3) {
                fNextDouble = (float) jsonReader.nextDouble();
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return new Font(strNextString, strNextString3, strNextString2, fNextDouble);
    }
}
