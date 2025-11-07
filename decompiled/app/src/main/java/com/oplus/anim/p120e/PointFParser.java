package com.oplus.anim.p120e;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;

/* compiled from: PointFParser.java */
/* renamed from: com.oplus.anim.COUIBaseListPopupWindow_8.y */
/* loaded from: classes2.dex */
public class PointFParser implements ValueParser<PointF> {

    /* renamed from: PlatformImplementations.kt_3 */
    public static final PointFParser f10363a = new PointFParser();

    private PointFParser() {
    }

    @Override // com.oplus.anim.p120e.ValueParser
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public PointF mo9161b(JsonReader jsonReader, float COUIBaseListPopupWindow_12) throws IOException {
        JsonToken jsonTokenPeek = jsonReader.peek();
        if (jsonTokenPeek == JsonToken.BEGIN_ARRAY) {
            return JsonUtils.m9210b(jsonReader, COUIBaseListPopupWindow_12);
        }
        if (jsonTokenPeek == JsonToken.BEGIN_OBJECT) {
            return JsonUtils.m9210b(jsonReader, COUIBaseListPopupWindow_12);
        }
        if (jsonTokenPeek == JsonToken.NUMBER) {
            PointF pointF = new PointF(((float) jsonReader.nextDouble()) * COUIBaseListPopupWindow_12, ((float) jsonReader.nextDouble()) * COUIBaseListPopupWindow_12);
            while (jsonReader.hasNext()) {
                jsonReader.skipValue();
            }
            return pointF;
        }
        throw new IllegalArgumentException("Cannot convert json to point. Next token is " + jsonTokenPeek);
    }
}
