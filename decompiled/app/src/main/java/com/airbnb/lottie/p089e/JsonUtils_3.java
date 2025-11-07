package com.airbnb.lottie.p089e;

import android.graphics.Color;
import android.graphics.PointF;
import com.airbnb.lottie.p089e.p090a.JsonReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: JsonUtils.java */
/* renamed from: com.airbnb.lottie.COUIBaseListPopupWindow_8.p */
/* loaded from: classes.dex */
class JsonUtils_3 {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final JsonReader.PlatformImplementations.kt_3 f5797a = JsonReader.PlatformImplementations.kt_3.m5929a("x", "y");

    /* renamed from: PlatformImplementations.kt_3 */
    static int m5988a(JsonReader abstractC1149c) throws IOException {
        abstractC1149c.mo5914a();
        int iMo5925k = (int) (abstractC1149c.mo5925k() * 255.0d);
        int iMo5925k2 = (int) (abstractC1149c.mo5925k() * 255.0d);
        int iMo5925k3 = (int) (abstractC1149c.mo5925k() * 255.0d);
        while (abstractC1149c.mo5919e()) {
            abstractC1149c.mo5927m();
        }
        abstractC1149c.mo5916b();
        return Color.argb(255, iMo5925k, iMo5925k2, iMo5925k3);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static List<PointF> m5989a(JsonReader abstractC1149c, float COUIBaseListPopupWindow_12) throws IOException {
        ArrayList arrayList = new ArrayList();
        abstractC1149c.mo5914a();
        while (abstractC1149c.mo5920f() == JsonReader.IntrinsicsJvm.kt_4.BEGIN_ARRAY) {
            abstractC1149c.mo5914a();
            arrayList.add(m5991b(abstractC1149c, COUIBaseListPopupWindow_12));
            abstractC1149c.mo5916b();
        }
        abstractC1149c.mo5916b();
        return arrayList;
    }

    /* compiled from: JsonUtils.java */
    /* renamed from: com.airbnb.lottie.COUIBaseListPopupWindow_8.p$1, reason: invalid class name */
    static /* synthetic */ class COUIBaseListPopupWindow_2 {

        /* renamed from: PlatformImplementations.kt_3 */
        static final /* synthetic */ int[] f5798a = new int[JsonReader.IntrinsicsJvm.kt_4.values().length];

        static {
            try {
                f5798a[JsonReader.IntrinsicsJvm.kt_4.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5798a[JsonReader.IntrinsicsJvm.kt_4.BEGIN_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5798a[JsonReader.IntrinsicsJvm.kt_4.BEGIN_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    static PointF m5991b(JsonReader abstractC1149c, float COUIBaseListPopupWindow_12) throws IOException {
        int OplusGLSurfaceView_13 = COUIBaseListPopupWindow_2.f5798a[abstractC1149c.mo5920f().ordinal()];
        if (OplusGLSurfaceView_13 == 1) {
            return m5992c(abstractC1149c, COUIBaseListPopupWindow_12);
        }
        if (OplusGLSurfaceView_13 == 2) {
            return m5993d(abstractC1149c, COUIBaseListPopupWindow_12);
        }
        if (OplusGLSurfaceView_13 == 3) {
            return m5994e(abstractC1149c, COUIBaseListPopupWindow_12);
        }
        throw new IllegalArgumentException("Unknown point starts with " + abstractC1149c.mo5920f());
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static PointF m5992c(JsonReader abstractC1149c, float COUIBaseListPopupWindow_12) throws IOException {
        float fMo5925k = (float) abstractC1149c.mo5925k();
        float fMo5925k2 = (float) abstractC1149c.mo5925k();
        while (abstractC1149c.mo5919e()) {
            abstractC1149c.mo5927m();
        }
        return new PointF(fMo5925k * COUIBaseListPopupWindow_12, fMo5925k2 * COUIBaseListPopupWindow_12);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static PointF m5993d(JsonReader abstractC1149c, float COUIBaseListPopupWindow_12) throws IOException {
        abstractC1149c.mo5914a();
        float fMo5925k = (float) abstractC1149c.mo5925k();
        float fMo5925k2 = (float) abstractC1149c.mo5925k();
        while (abstractC1149c.mo5920f() != JsonReader.IntrinsicsJvm.kt_4.END_ARRAY) {
            abstractC1149c.mo5927m();
        }
        abstractC1149c.mo5916b();
        return new PointF(fMo5925k * COUIBaseListPopupWindow_12, fMo5925k2 * COUIBaseListPopupWindow_12);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private static PointF m5994e(JsonReader abstractC1149c, float COUIBaseListPopupWindow_12) throws IOException {
        abstractC1149c.mo5917c();
        float fM5990b = 0.0f;
        float fM5990b2 = 0.0f;
        while (abstractC1149c.mo5919e()) {
            int iMo5912a = abstractC1149c.mo5912a(f5797a);
            if (iMo5912a == 0) {
                fM5990b = m5990b(abstractC1149c);
            } else if (iMo5912a == 1) {
                fM5990b2 = m5990b(abstractC1149c);
            } else {
                abstractC1149c.mo5922h();
                abstractC1149c.mo5927m();
            }
        }
        abstractC1149c.mo5918d();
        return new PointF(fM5990b * COUIBaseListPopupWindow_12, fM5990b2 * COUIBaseListPopupWindow_12);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    static float m5990b(JsonReader abstractC1149c) throws IOException {
        JsonReader.IntrinsicsJvm.kt_4 bVarMo5920f = abstractC1149c.mo5920f();
        int OplusGLSurfaceView_13 = COUIBaseListPopupWindow_2.f5798a[bVarMo5920f.ordinal()];
        if (OplusGLSurfaceView_13 == 1) {
            return (float) abstractC1149c.mo5925k();
        }
        if (OplusGLSurfaceView_13 == 2) {
            abstractC1149c.mo5914a();
            float fMo5925k = (float) abstractC1149c.mo5925k();
            while (abstractC1149c.mo5919e()) {
                abstractC1149c.mo5927m();
            }
            abstractC1149c.mo5916b();
            return fMo5925k;
        }
        throw new IllegalArgumentException("Unknown value for token of type " + bVarMo5920f);
    }
}
