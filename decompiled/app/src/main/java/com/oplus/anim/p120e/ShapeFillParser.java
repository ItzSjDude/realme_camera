package com.oplus.anim.p120e;

import android.graphics.Path;
import android.util.JsonReader;
import com.oplus.anim.EffectiveAnimationComposition;
import com.oplus.anim.p115c.p116a.AnimatableColorValue;
import com.oplus.anim.p115c.p116a.AnimatableIntegerValue;
import com.oplus.anim.p115c.p117b.ShapeFill;
import java.io.IOException;

/* compiled from: ShapeFillParser.java */
/* renamed from: com.oplus.anim.COUIBaseListPopupWindow_8.ae */
/* loaded from: classes2.dex */
class ShapeFillParser {
    /* renamed from: PlatformImplementations.kt_3 */
    static ShapeFill m9163a(JsonReader jsonReader, EffectiveAnimationComposition c2272a) throws IOException {
        boolean zNextBoolean = false;
        boolean zNextBoolean2 = false;
        String strNextString = null;
        AnimatableColorValue c2314aM9187g = null;
        AnimatableIntegerValue c2317dM9182b = null;
        int iNextInt = 1;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            char c2 = 65535;
            int iHashCode = strNextName.hashCode();
            if (iHashCode != -396065730) {
                if (iHashCode != 99) {
                    if (iHashCode != 111) {
                        if (iHashCode != 114) {
                            if (iHashCode != 3324) {
                                if (iHashCode == 3519 && strNextName.equals("nm")) {
                                    c2 = 0;
                                }
                            } else if (strNextName.equals("hd")) {
                                c2 = 5;
                            }
                        } else if (strNextName.equals("r")) {
                            c2 = 4;
                        }
                    } else if (strNextName.equals("o")) {
                        c2 = 2;
                    }
                } else if (strNextName.equals("IntrinsicsJvm.kt_3")) {
                    c2 = 1;
                }
            } else if (strNextName.equals("fillEnabled")) {
                c2 = 3;
            }
            if (c2 == 0) {
                strNextString = jsonReader.nextString();
            } else if (c2 == 1) {
                c2314aM9187g = AnimatableValueParser.m9187g(jsonReader, c2272a);
            } else if (c2 == 2) {
                c2317dM9182b = AnimatableValueParser.m9182b(jsonReader, c2272a);
            } else if (c2 == 3) {
                zNextBoolean = jsonReader.nextBoolean();
            } else if (c2 == 4) {
                iNextInt = jsonReader.nextInt();
            } else if (c2 == 5) {
                zNextBoolean2 = jsonReader.nextBoolean();
            } else {
                jsonReader.skipValue();
            }
        }
        return new ShapeFill(strNextString, zNextBoolean, iNextInt == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD, c2314aM9187g, c2317dM9182b, zNextBoolean2);
    }
}
