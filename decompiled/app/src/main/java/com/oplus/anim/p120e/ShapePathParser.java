package com.oplus.anim.p120e;

import android.util.JsonReader;
import com.oplus.anim.EffectiveAnimationComposition;
import com.oplus.anim.p115c.p116a.AnimatableShapeValue;
import com.oplus.anim.p115c.p117b.ShapePath;
import java.io.IOException;

/* compiled from: ShapePathParser.java */
/* renamed from: com.oplus.anim.COUIBaseListPopupWindow_8.ag */
/* loaded from: classes2.dex */
class ShapePathParser {
    /* renamed from: PlatformImplementations.kt_3 */
    static ShapePath m9165a(JsonReader jsonReader, EffectiveAnimationComposition c2272a) throws IOException {
        String strNextString = null;
        AnimatableShapeValue c2321hM9185e = null;
        int iNextInt = 0;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            char c2 = 65535;
            int iHashCode = strNextName.hashCode();
            if (iHashCode != 3324) {
                if (iHashCode != 3432) {
                    if (iHashCode != 3519) {
                        if (iHashCode == 104415 && strNextName.equals("ind")) {
                            c2 = 1;
                        }
                    } else if (strNextName.equals("nm")) {
                        c2 = 0;
                    }
                } else if (strNextName.equals("ks")) {
                    c2 = 2;
                }
            } else if (strNextName.equals("hd")) {
                c2 = 3;
            }
            if (c2 == 0) {
                strNextString = jsonReader.nextString();
            } else if (c2 == 1) {
                iNextInt = jsonReader.nextInt();
            } else if (c2 == 2) {
                c2321hM9185e = AnimatableValueParser.m9185e(jsonReader, c2272a);
            } else if (c2 == 3) {
                zNextBoolean = jsonReader.nextBoolean();
            } else {
                jsonReader.skipValue();
            }
        }
        return new ShapePath(strNextString, iNextInt, c2321hM9185e, zNextBoolean);
    }
}
