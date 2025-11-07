package com.oplus.anim.p120e;

import android.graphics.PointF;
import android.util.JsonReader;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.oplus.anim.EffectiveAnimationComposition;
import com.oplus.anim.p115c.p116a.AnimatableFloatValue;
import com.oplus.anim.p115c.p116a.AnimatablePointValue;
import com.oplus.anim.p115c.p116a.AnimatableValue;
import com.oplus.anim.p115c.p117b.RectangleShape;
import java.io.IOException;

/* compiled from: RectangleShapeParser.java */
/* renamed from: com.oplus.anim.COUIBaseListPopupWindow_8.aa */
/* loaded from: classes2.dex */
class RectangleShapeParser {
    /* renamed from: PlatformImplementations.kt_3 */
    static RectangleShape m9158a(JsonReader jsonReader, EffectiveAnimationComposition c2272a) throws IOException {
        boolean zNextBoolean = false;
        String strNextString = null;
        AnimatableValue<PointF, PointF> interfaceC2326mM9157b = null;
        AnimatablePointValue c2319fM9183c = null;
        AnimatableFloatValue c2315bM9177a = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            char c2 = 65535;
            int iHashCode = strNextName.hashCode();
            if (iHashCode != 112) {
                if (iHashCode != 3324) {
                    if (iHashCode != 3519) {
                        if (iHashCode != 114) {
                            if (iHashCode == 115 && strNextName.equals("s")) {
                                c2 = 2;
                            }
                        } else if (strNextName.equals("r")) {
                            c2 = 3;
                        }
                    } else if (strNextName.equals("nm")) {
                        c2 = 0;
                    }
                } else if (strNextName.equals("hd")) {
                    c2 = 4;
                }
            } else if (strNextName.equals(TtmlNode.TAG_P)) {
                c2 = 1;
            }
            if (c2 == 0) {
                strNextString = jsonReader.nextString();
            } else if (c2 == 1) {
                interfaceC2326mM9157b = AnimatablePathValueParser.m9157b(jsonReader, c2272a);
            } else if (c2 == 2) {
                c2319fM9183c = AnimatableValueParser.m9183c(jsonReader, c2272a);
            } else if (c2 == 3) {
                c2315bM9177a = AnimatableValueParser.m9177a(jsonReader, c2272a);
            } else if (c2 == 4) {
                zNextBoolean = jsonReader.nextBoolean();
            } else {
                jsonReader.skipValue();
            }
        }
        return new RectangleShape(strNextString, interfaceC2326mM9157b, c2319fM9183c, c2315bM9177a, zNextBoolean);
    }
}
