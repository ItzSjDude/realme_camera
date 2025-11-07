package com.oplus.anim.p120e;

import android.util.JsonReader;
import com.oplus.anim.EffectiveAnimationComposition;
import com.oplus.anim.p115c.p116a.AnimatableFloatValue;
import com.oplus.anim.p115c.p116a.AnimatableTransform;
import com.oplus.anim.p115c.p117b.Repeater;
import java.io.IOException;

/* compiled from: RepeaterParser.java */
/* renamed from: com.oplus.anim.COUIBaseListPopupWindow_8.ab */
/* loaded from: classes2.dex */
class RepeaterParser {
    /* renamed from: PlatformImplementations.kt_3 */
    static Repeater m9159a(JsonReader jsonReader, EffectiveAnimationComposition c2272a) throws IOException {
        boolean zNextBoolean = false;
        String strNextString = null;
        AnimatableFloatValue c2315bM9178a = null;
        AnimatableFloatValue c2315bM9178a2 = null;
        AnimatableTransform c2325lM9170a = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            char c2 = 65535;
            int iHashCode = strNextName.hashCode();
            if (iHashCode != 99) {
                if (iHashCode != 111) {
                    if (iHashCode != 3324) {
                        if (iHashCode != 3519) {
                            if (iHashCode == 3710 && strNextName.equals("tr")) {
                                c2 = 3;
                            }
                        } else if (strNextName.equals("nm")) {
                            c2 = 0;
                        }
                    } else if (strNextName.equals("hd")) {
                        c2 = 4;
                    }
                } else if (strNextName.equals("o")) {
                    c2 = 2;
                }
            } else if (strNextName.equals("IntrinsicsJvm.kt_3")) {
                c2 = 1;
            }
            if (c2 == 0) {
                strNextString = jsonReader.nextString();
            } else if (c2 == 1) {
                c2315bM9178a = AnimatableValueParser.m9178a(jsonReader, c2272a, false);
            } else if (c2 == 2) {
                c2315bM9178a2 = AnimatableValueParser.m9178a(jsonReader, c2272a, false);
            } else if (c2 == 3) {
                c2325lM9170a = AnimatableTransformParser.m9170a(jsonReader, c2272a);
            } else if (c2 == 4) {
                zNextBoolean = jsonReader.nextBoolean();
            } else {
                jsonReader.skipValue();
            }
        }
        return new Repeater(strNextString, c2315bM9178a, c2315bM9178a2, c2325lM9170a, zNextBoolean);
    }
}
