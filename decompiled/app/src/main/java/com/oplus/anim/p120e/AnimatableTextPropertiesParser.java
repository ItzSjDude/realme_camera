package com.oplus.anim.p120e;

import android.util.JsonReader;
import com.oplus.anim.EffectiveAnimationComposition;
import com.oplus.anim.p115c.p116a.AnimatableColorValue;
import com.oplus.anim.p115c.p116a.AnimatableFloatValue;
import com.oplus.anim.p115c.p116a.AnimatableTextProperties;
import java.io.IOException;

/* compiled from: AnimatableTextPropertiesParser.java */
/* renamed from: com.oplus.anim.COUIBaseListPopupWindow_8.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public class AnimatableTextPropertiesParser {
    /* renamed from: PlatformImplementations.kt_3 */
    public static AnimatableTextProperties m9168a(JsonReader jsonReader, EffectiveAnimationComposition c2272a) throws IOException {
        jsonReader.beginObject();
        AnimatableTextProperties c2324kM9169b = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            char c2 = 65535;
            if (strNextName.hashCode() == 97 && strNextName.equals("PlatformImplementations.kt_3")) {
                c2 = 0;
            }
            if (c2 == 0) {
                c2324kM9169b = m9169b(jsonReader, c2272a);
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return c2324kM9169b == null ? new AnimatableTextProperties(null, null, null, null) : c2324kM9169b;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static AnimatableTextProperties m9169b(JsonReader jsonReader, EffectiveAnimationComposition c2272a) throws IOException {
        jsonReader.beginObject();
        AnimatableColorValue c2314aM9187g = null;
        AnimatableColorValue c2314aM9187g2 = null;
        AnimatableFloatValue c2315bM9177a = null;
        AnimatableFloatValue c2315bM9177a2 = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            char c2 = 65535;
            int iHashCode = strNextName.hashCode();
            if (iHashCode != 116) {
                if (iHashCode != 3261) {
                    if (iHashCode != 3664) {
                        if (iHashCode == 3684 && strNextName.equals("sw")) {
                            c2 = 2;
                        }
                    } else if (strNextName.equals("sc")) {
                        c2 = 1;
                    }
                } else if (strNextName.equals("fc")) {
                    c2 = 0;
                }
            } else if (strNextName.equals("t")) {
                c2 = 3;
            }
            if (c2 == 0) {
                c2314aM9187g = AnimatableValueParser.m9187g(jsonReader, c2272a);
            } else if (c2 == 1) {
                c2314aM9187g2 = AnimatableValueParser.m9187g(jsonReader, c2272a);
            } else if (c2 == 2) {
                c2315bM9177a = AnimatableValueParser.m9177a(jsonReader, c2272a);
            } else if (c2 == 3) {
                c2315bM9177a2 = AnimatableValueParser.m9177a(jsonReader, c2272a);
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return new AnimatableTextProperties(c2314aM9187g, c2314aM9187g2, c2315bM9177a, c2315bM9177a2);
    }
}
