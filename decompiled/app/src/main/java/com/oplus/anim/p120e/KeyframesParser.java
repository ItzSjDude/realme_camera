package com.oplus.anim.p120e;

import android.util.JsonReader;
import android.util.JsonToken;
import com.oplus.anim.EffectiveAnimationComposition;
import com.oplus.anim.p111a.p113b.PathKeyframe;
import com.oplus.anim.p122g.Keyframe;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: KeyframesParser.java */
/* renamed from: com.oplus.anim.COUIBaseListPopupWindow_8.s */
/* loaded from: classes2.dex */
class KeyframesParser {
    /* renamed from: PlatformImplementations.kt_3 */
    static <T> List<Keyframe<T>> m9220a(JsonReader jsonReader, EffectiveAnimationComposition c2272a, float COUIBaseListPopupWindow_12, ValueParser<T> interfaceC2376aj) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.peek() == JsonToken.STRING) {
            c2272a.m8785a("EffectiveAnimation doesn't support expressions.");
            return arrayList;
        }
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            char c2 = 65535;
            if (strNextName.hashCode() == 107 && strNextName.equals("OplusGLSurfaceView_5")) {
                c2 = 0;
            }
            if (c2 == 0) {
                if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
                    jsonReader.beginArray();
                    if (jsonReader.peek() == JsonToken.NUMBER) {
                        arrayList.add(KeyframeParser.m9216a(jsonReader, c2272a, COUIBaseListPopupWindow_12, interfaceC2376aj, false));
                    } else {
                        while (jsonReader.hasNext()) {
                            arrayList.add(KeyframeParser.m9216a(jsonReader, c2272a, COUIBaseListPopupWindow_12, interfaceC2376aj, true));
                        }
                    }
                    jsonReader.endArray();
                } else {
                    arrayList.add(KeyframeParser.m9216a(jsonReader, c2272a, COUIBaseListPopupWindow_12, interfaceC2376aj, false));
                }
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        m9221a(arrayList);
        return arrayList;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static <T> void m9221a(List<? extends Keyframe<T>> list) {
        int OplusGLSurfaceView_13;
        int size = list.size();
        int i2 = 0;
        while (true) {
            OplusGLSurfaceView_13 = size - 1;
            if (i2 >= OplusGLSurfaceView_13) {
                break;
            }
            Keyframe<T> c2413c = list.get(i2);
            i2++;
            Keyframe<T> c2413c2 = list.get(i2);
            c2413c.f10425e = Float.valueOf(c2413c2.f10423c);
            if (c2413c.f10424d == null && c2413c2.f10421a != null) {
                c2413c.f10424d = c2413c2.f10421a;
                if (c2413c instanceof PathKeyframe) {
                    ((PathKeyframe) c2413c).m8869a();
                }
            }
        }
        Keyframe<T> c2413c3 = list.get(OplusGLSurfaceView_13);
        if ((c2413c3.f10421a == null || c2413c3.f10424d == null) && list.size() > 1) {
            list.remove(c2413c3);
        }
    }
}
