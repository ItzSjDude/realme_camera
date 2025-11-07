package com.airbnb.lottie.p089e;

import android.graphics.PointF;
import com.airbnb.lottie.p089e.p090a.JsonReader;
import java.io.IOException;

/* compiled from: PointFParser.java */
/* renamed from: com.airbnb.lottie.COUIBaseListPopupWindow_8.y */
/* loaded from: classes.dex */
public class PointFParser_2 implements ValueParser_2<PointF> {

    /* renamed from: PlatformImplementations.kt_3 */
    public static final PointFParser_2 f5814a = new PointFParser_2();

    private PointFParser_2() {
    }

    @Override // com.airbnb.lottie.p089e.ValueParser_2
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public PointF mo5948b(JsonReader abstractC1149c, float COUIBaseListPopupWindow_12) throws IOException {
        JsonReader.IntrinsicsJvm.kt_4 bVarMo5920f = abstractC1149c.mo5920f();
        if (bVarMo5920f == JsonReader.IntrinsicsJvm.kt_4.BEGIN_ARRAY) {
            return JsonUtils_3.m5991b(abstractC1149c, COUIBaseListPopupWindow_12);
        }
        if (bVarMo5920f == JsonReader.IntrinsicsJvm.kt_4.BEGIN_OBJECT) {
            return JsonUtils_3.m5991b(abstractC1149c, COUIBaseListPopupWindow_12);
        }
        if (bVarMo5920f == JsonReader.IntrinsicsJvm.kt_4.NUMBER) {
            PointF pointF = new PointF(((float) abstractC1149c.mo5925k()) * COUIBaseListPopupWindow_12, ((float) abstractC1149c.mo5925k()) * COUIBaseListPopupWindow_12);
            while (abstractC1149c.mo5919e()) {
                abstractC1149c.mo5927m();
            }
            return pointF;
        }
        throw new IllegalArgumentException("Cannot convert json to point. Next token is " + bVarMo5920f);
    }
}
