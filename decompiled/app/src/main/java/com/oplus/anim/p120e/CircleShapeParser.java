package com.oplus.anim.p120e;

import android.graphics.PointF;
import android.util.JsonReader;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.oplus.anim.EffectiveAnimationComposition;
import com.oplus.anim.p115c.p116a.AnimatablePointValue;
import com.oplus.anim.p115c.p116a.AnimatableValue;
import com.oplus.anim.p115c.p117b.CircleShape;
import java.io.IOException;

/* compiled from: CircleShapeParser.java */
/* renamed from: com.oplus.anim.COUIBaseListPopupWindow_8.COUIBaseListPopupWindow_8 */
/* loaded from: classes2.dex */
class CircleShapeParser {
    /* renamed from: PlatformImplementations.kt_3 */
    static CircleShape m9188a(JsonReader jsonReader, EffectiveAnimationComposition c2272a, int OplusGLSurfaceView_13) throws IOException {
        boolean z = OplusGLSurfaceView_13 == 3;
        boolean zNextBoolean = false;
        String strNextString = null;
        AnimatableValue<PointF, PointF> interfaceC2326mM9157b = null;
        AnimatablePointValue c2319fM9183c = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            char c2 = 65535;
            int iHashCode = strNextName.hashCode();
            if (iHashCode != 100) {
                if (iHashCode != 112) {
                    if (iHashCode != 115) {
                        if (iHashCode != 3324) {
                            if (iHashCode == 3519 && strNextName.equals("nm")) {
                                c2 = 0;
                            }
                        } else if (strNextName.equals("hd")) {
                            c2 = 3;
                        }
                    } else if (strNextName.equals("s")) {
                        c2 = 2;
                    }
                } else if (strNextName.equals(TtmlNode.TAG_P)) {
                    c2 = 1;
                }
            } else if (strNextName.equals("IntrinsicsJvm.kt_5")) {
                c2 = 4;
            }
            if (c2 == 0) {
                strNextString = jsonReader.nextString();
            } else if (c2 == 1) {
                interfaceC2326mM9157b = AnimatablePathValueParser.m9157b(jsonReader, c2272a);
            } else if (c2 == 2) {
                c2319fM9183c = AnimatableValueParser.m9183c(jsonReader, c2272a);
            } else if (c2 == 3) {
                zNextBoolean = jsonReader.nextBoolean();
            } else if (c2 == 4) {
                z = jsonReader.nextInt() == 3;
            } else {
                jsonReader.skipValue();
            }
        }
        return new CircleShape(strNextString, interfaceC2326mM9157b, c2319fM9183c, z, zNextBoolean);
    }
}
