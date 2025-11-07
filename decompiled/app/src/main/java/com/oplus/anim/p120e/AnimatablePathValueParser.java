package com.oplus.anim.p120e;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import com.oplus.anim.EffectiveAnimationComposition;
import com.oplus.anim.p115c.p116a.AnimatableFloatValue;
import com.oplus.anim.p115c.p116a.AnimatablePathValue;
import com.oplus.anim.p115c.p116a.AnimatableSplitDimensionPathValue;
import com.oplus.anim.p115c.p116a.AnimatableValue;
import com.oplus.anim.p121f.Utils_2;
import com.oplus.anim.p122g.Keyframe;
import java.io.IOException;
import java.util.ArrayList;

/* compiled from: AnimatablePathValueParser.java */
/* renamed from: com.oplus.anim.COUIBaseListPopupWindow_8.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class AnimatablePathValueParser {
    /* renamed from: PlatformImplementations.kt_3 */
    public static AnimatablePathValue m9156a(JsonReader jsonReader, EffectiveAnimationComposition c2272a) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                arrayList.add(PathKeyframeParser.m9226a(jsonReader, c2272a));
            }
            jsonReader.endArray();
            KeyframesParser.m9221a(arrayList);
        } else {
            arrayList.add(new Keyframe(JsonUtils.m9210b(jsonReader, Utils_2.m9288a())));
        }
        return new AnimatablePathValue(arrayList);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    static AnimatableValue<PointF, PointF> m9157b(JsonReader jsonReader, EffectiveAnimationComposition c2272a) throws IOException {
        jsonReader.beginObject();
        AnimatablePathValue c2318eM9156a = null;
        AnimatableFloatValue c2315bM9177a = null;
        AnimatableFloatValue c2315bM9177a2 = null;
        boolean z = false;
        while (jsonReader.peek() != JsonToken.END_OBJECT) {
            String strNextName = jsonReader.nextName();
            char c2 = 65535;
            int iHashCode = strNextName.hashCode();
            if (iHashCode != 107) {
                if (iHashCode != 120) {
                    if (iHashCode == 121 && strNextName.equals("y")) {
                        c2 = 2;
                    }
                } else if (strNextName.equals("x")) {
                    c2 = 1;
                }
            } else if (strNextName.equals("OplusGLSurfaceView_5")) {
                c2 = 0;
            }
            if (c2 == 0) {
                c2318eM9156a = m9156a(jsonReader, c2272a);
            } else if (c2 != 1) {
                if (c2 == 2) {
                    if (jsonReader.peek() == JsonToken.STRING) {
                        jsonReader.skipValue();
                        z = true;
                    } else {
                        c2315bM9177a2 = AnimatableValueParser.m9177a(jsonReader, c2272a);
                    }
                } else {
                    jsonReader.skipValue();
                }
            } else if (jsonReader.peek() == JsonToken.STRING) {
                jsonReader.skipValue();
                z = true;
            } else {
                c2315bM9177a = AnimatableValueParser.m9177a(jsonReader, c2272a);
            }
        }
        jsonReader.endObject();
        if (z) {
            c2272a.m8785a("EffectiveAnimation doesn't support expressions.");
        }
        return c2318eM9156a != null ? c2318eM9156a : new AnimatableSplitDimensionPathValue(c2315bM9177a, c2315bM9177a2);
    }
}
