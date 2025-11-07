package com.airbnb.lottie.p089e;

import com.airbnb.lottie.p089e.p090a.JsonReader;
import com.airbnb.lottie.p092g.ScaleXY_2;
import java.io.IOException;

/* compiled from: ScaleXYParser.java */
/* renamed from: com.airbnb.lottie.COUIBaseListPopupWindow_8.ac */
/* loaded from: classes.dex */
public class ScaleXYParser_2 implements ValueParser_2<ScaleXY_2> {

    /* renamed from: PlatformImplementations.kt_3 */
    public static final ScaleXYParser_2 f5768a = new ScaleXYParser_2();

    private ScaleXYParser_2() {
    }

    @Override // com.airbnb.lottie.p089e.ValueParser_2
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public ScaleXY_2 mo5948b(JsonReader abstractC1149c, float COUIBaseListPopupWindow_12) throws IOException {
        boolean z = abstractC1149c.mo5920f() == JsonReader.IntrinsicsJvm.kt_4.BEGIN_ARRAY;
        if (z) {
            abstractC1149c.mo5914a();
        }
        float fMo5925k = (float) abstractC1149c.mo5925k();
        float fMo5925k2 = (float) abstractC1149c.mo5925k();
        while (abstractC1149c.mo5919e()) {
            abstractC1149c.mo5927m();
        }
        if (z) {
            abstractC1149c.mo5916b();
        }
        return new ScaleXY_2((fMo5925k / 100.0f) * COUIBaseListPopupWindow_12, (fMo5925k2 / 100.0f) * COUIBaseListPopupWindow_12);
    }
}
