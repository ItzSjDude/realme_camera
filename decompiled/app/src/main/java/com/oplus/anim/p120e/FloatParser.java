package com.oplus.anim.p120e;

import android.util.JsonReader;
import java.io.IOException;

/* compiled from: FloatParser.java */
/* renamed from: com.oplus.anim.COUIBaseListPopupWindow_8.OplusGLSurfaceView_15 */
/* loaded from: classes2.dex */
public class FloatParser implements ValueParser<Float> {

    /* renamed from: PlatformImplementations.kt_3 */
    public static final FloatParser f10356a = new FloatParser();

    private FloatParser() {
    }

    @Override // com.oplus.anim.p120e.ValueParser
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public Float mo9161b(JsonReader jsonReader, float COUIBaseListPopupWindow_12) throws IOException {
        return Float.valueOf(JsonUtils.m9209b(jsonReader) * COUIBaseListPopupWindow_12);
    }
}
