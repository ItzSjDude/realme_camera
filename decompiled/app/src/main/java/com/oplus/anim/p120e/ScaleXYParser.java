package com.oplus.anim.p120e;

import android.util.JsonReader;
import android.util.JsonToken;
import com.oplus.anim.p122g.ScaleXY;
import java.io.IOException;

/* compiled from: ScaleXYParser.java */
/* renamed from: com.oplus.anim.COUIBaseListPopupWindow_8.ac */
/* loaded from: classes2.dex */
public class ScaleXYParser implements ValueParser<ScaleXY> {

    /* renamed from: PlatformImplementations.kt_3 */
    public static final ScaleXYParser f10352a = new ScaleXYParser();

    private ScaleXYParser() {
    }

    @Override // com.oplus.anim.p120e.ValueParser
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public ScaleXY mo9161b(JsonReader jsonReader, float COUIBaseListPopupWindow_12) throws IOException {
        boolean z = jsonReader.peek() == JsonToken.BEGIN_ARRAY;
        if (z) {
            jsonReader.beginArray();
        }
        float fNextDouble = (float) jsonReader.nextDouble();
        float fNextDouble2 = (float) jsonReader.nextDouble();
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        if (z) {
            jsonReader.endArray();
        }
        return new ScaleXY((fNextDouble / 100.0f) * COUIBaseListPopupWindow_12, (fNextDouble2 / 100.0f) * COUIBaseListPopupWindow_12);
    }
}
