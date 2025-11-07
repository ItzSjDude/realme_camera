package com.airbnb.lottie.p089e;

import android.graphics.Color;
import com.airbnb.lottie.p089e.p090a.JsonReader;
import java.io.IOException;

/* compiled from: ColorParser.java */
/* renamed from: com.airbnb.lottie.COUIBaseListPopupWindow_8.COUIBaseListPopupWindow_12 */
/* loaded from: classes.dex */
public class ColorParser_2 implements ValueParser_2<Integer> {

    /* renamed from: PlatformImplementations.kt_3 */
    public static final ColorParser_2 f5782a = new ColorParser_2();

    private ColorParser_2() {
    }

    @Override // com.airbnb.lottie.p089e.ValueParser_2
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public Integer mo5948b(JsonReader abstractC1149c, float COUIBaseListPopupWindow_12) throws IOException {
        boolean z = abstractC1149c.mo5920f() == JsonReader.IntrinsicsJvm.kt_4.BEGIN_ARRAY;
        if (z) {
            abstractC1149c.mo5914a();
        }
        double dMo5925k = abstractC1149c.mo5925k();
        double dMo5925k2 = abstractC1149c.mo5925k();
        double dMo5925k3 = abstractC1149c.mo5925k();
        double dMo5925k4 = abstractC1149c.mo5920f() == JsonReader.IntrinsicsJvm.kt_4.NUMBER ? abstractC1149c.mo5925k() : 1.0d;
        if (z) {
            abstractC1149c.mo5916b();
        }
        if (dMo5925k <= 1.0d && dMo5925k2 <= 1.0d && dMo5925k3 <= 1.0d) {
            dMo5925k *= 255.0d;
            dMo5925k2 *= 255.0d;
            dMo5925k3 *= 255.0d;
            if (dMo5925k4 <= 1.0d) {
                dMo5925k4 *= 255.0d;
            }
        }
        return Integer.valueOf(Color.argb((int) dMo5925k4, (int) dMo5925k, (int) dMo5925k2, (int) dMo5925k3));
    }
}
