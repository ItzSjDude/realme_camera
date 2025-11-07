package com.airbnb.lottie.p089e;

import com.airbnb.lottie.p089e.p090a.JsonReader;
import java.io.IOException;

/* compiled from: FloatParser.java */
/* renamed from: com.airbnb.lottie.COUIBaseListPopupWindow_8.OplusGLSurfaceView_13 */
/* loaded from: classes.dex */
public class FloatParser_2 implements ValueParser_2<Float> {

    /* renamed from: PlatformImplementations.kt_3 */
    public static final FloatParser_2 f5786a = new FloatParser_2();

    private FloatParser_2() {
    }

    @Override // com.airbnb.lottie.p089e.ValueParser_2
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public Float mo5948b(JsonReader abstractC1149c, float COUIBaseListPopupWindow_12) throws IOException {
        return Float.valueOf(JsonUtils_3.m5990b(abstractC1149c) * COUIBaseListPopupWindow_12);
    }
}
