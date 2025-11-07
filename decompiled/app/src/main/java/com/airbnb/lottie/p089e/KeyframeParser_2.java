package com.airbnb.lottie.p089e;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.collection.SparseArrayCompat;
import androidx.core.p036h.p038b.PathInterpolatorCompat_2;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.p089e.p090a.JsonReader;
import com.airbnb.lottie.p091f.MiscUtils_2;
import com.airbnb.lottie.p091f.Utils_4;
import com.airbnb.lottie.p092g.Keyframe_2;
import java.io.IOException;
import java.lang.ref.WeakReference;

/* compiled from: KeyframeParser.java */
/* renamed from: com.airbnb.lottie.COUIBaseListPopupWindow_8.q */
/* loaded from: classes.dex */
class KeyframeParser_2 {

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static SparseArrayCompat<WeakReference<Interpolator>> f5802d;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static final Interpolator f5801c = new LinearInterpolator();

    /* renamed from: PlatformImplementations.kt_3 */
    static JsonReader.PlatformImplementations.kt_3 f5799a = JsonReader.PlatformImplementations.kt_3.m5929a("t", "s", "COUIBaseListPopupWindow_8", "o", "OplusGLSurfaceView_13", "COUIBaseListPopupWindow_10", "to", "ti");

    /* renamed from: IntrinsicsJvm.kt_4 */
    static JsonReader.PlatformImplementations.kt_3 f5800b = JsonReader.PlatformImplementations.kt_3.m5929a("x", "y");

    KeyframeParser_2() {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static SparseArrayCompat<WeakReference<Interpolator>> m5996a() {
        if (f5802d == null) {
            f5802d = new SparseArrayCompat<>();
        }
        return f5802d;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static WeakReference<Interpolator> m6000a(int OplusGLSurfaceView_13) {
        WeakReference<Interpolator> weakReference;
        synchronized (KeyframeParser_2.class) {
            weakReference = m5996a().get(OplusGLSurfaceView_13);
        }
        return weakReference;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static void m6001a(int OplusGLSurfaceView_13, WeakReference<Interpolator> weakReference) {
        synchronized (KeyframeParser_2.class) {
            f5802d.put(OplusGLSurfaceView_13, weakReference);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static <T> Keyframe_2<T> m5999a(JsonReader abstractC1149c, LottieComposition c1136d, float COUIBaseListPopupWindow_12, ValueParser_2<T> interfaceC1161aj, boolean z, boolean z2) throws IOException {
        if (z && z2) {
            return m6002b(c1136d, abstractC1149c, COUIBaseListPopupWindow_12, interfaceC1161aj);
        }
        if (z) {
            return m5997a(c1136d, abstractC1149c, COUIBaseListPopupWindow_12, interfaceC1161aj);
        }
        return m5998a(abstractC1149c, COUIBaseListPopupWindow_12, interfaceC1161aj);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static <T> Keyframe_2<T> m5997a(LottieComposition c1136d, JsonReader abstractC1149c, float COUIBaseListPopupWindow_12, ValueParser_2<T> interfaceC1161aj) throws IOException {
        Interpolator interpolatorM5995a;
        Interpolator interpolator;
        T t;
        abstractC1149c.mo5917c();
        PointF pointFM5991b = null;
        T tMo5948b = null;
        T tMo5948b2 = null;
        PointF pointFM5991b2 = null;
        PointF pointFM5991b3 = null;
        float fMo5925k = 0.0f;
        boolean z = false;
        PointF pointFM5991b4 = null;
        while (abstractC1149c.mo5919e()) {
            switch (abstractC1149c.mo5912a(f5799a)) {
                case 0:
                    fMo5925k = (float) abstractC1149c.mo5925k();
                    break;
                case 1:
                    tMo5948b2 = interfaceC1161aj.mo5948b(abstractC1149c, COUIBaseListPopupWindow_12);
                    break;
                case 2:
                    tMo5948b = interfaceC1161aj.mo5948b(abstractC1149c, COUIBaseListPopupWindow_12);
                    break;
                case 3:
                    pointFM5991b4 = JsonUtils_3.m5991b(abstractC1149c, 1.0f);
                    break;
                case 4:
                    pointFM5991b = JsonUtils_3.m5991b(abstractC1149c, 1.0f);
                    break;
                case 5:
                    if (abstractC1149c.mo5926l() != 1) {
                        z = false;
                        break;
                    } else {
                        z = true;
                        break;
                    }
                case 6:
                    pointFM5991b2 = JsonUtils_3.m5991b(abstractC1149c, COUIBaseListPopupWindow_12);
                    break;
                case 7:
                    pointFM5991b3 = JsonUtils_3.m5991b(abstractC1149c, COUIBaseListPopupWindow_12);
                    break;
                default:
                    abstractC1149c.mo5927m();
                    break;
            }
        }
        abstractC1149c.mo5918d();
        if (z) {
            interpolator = f5801c;
            t = tMo5948b2;
        } else {
            if (pointFM5991b4 != null && pointFM5991b != null) {
                interpolatorM5995a = m5995a(pointFM5991b4, pointFM5991b);
            } else {
                interpolatorM5995a = f5801c;
            }
            interpolator = interpolatorM5995a;
            t = tMo5948b;
        }
        Keyframe_2<T> c1197a = new Keyframe_2<>(c1136d, tMo5948b2, t, interpolator, fMo5925k, null);
        c1197a.f5901h = pointFM5991b2;
        c1197a.f5902i = pointFM5991b3;
        return c1197a;
    }

    /* JADX WARN: Removed duplicated region for block: B:78:0x01c6  */
    /* renamed from: IntrinsicsJvm.kt_4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static <T> com.airbnb.lottie.p092g.Keyframe_2<T> m6002b(com.airbnb.lottie.LottieComposition r20, com.airbnb.lottie.p089e.p090a.JsonReader r21, float r22, com.airbnb.lottie.p089e.ValueParser_2<T> r23) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 494
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.p089e.KeyframeParser_2.m6002b(com.airbnb.lottie.IntrinsicsJvm.kt_5, com.airbnb.lottie.COUIBaseListPopupWindow_8.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3, float, com.airbnb.lottie.COUIBaseListPopupWindow_8.aj):com.airbnb.lottie.COUIBaseListPopupWindow_11.PlatformImplementations.kt_3");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static Interpolator m5995a(PointF pointF, PointF pointF2) {
        Interpolator linearInterpolator;
        pointF.x = MiscUtils_2.m6136b(pointF.x, -1.0f, 1.0f);
        pointF.y = MiscUtils_2.m6136b(pointF.y, -100.0f, 100.0f);
        pointF2.x = MiscUtils_2.m6136b(pointF2.x, -1.0f, 1.0f);
        pointF2.y = MiscUtils_2.m6136b(pointF2.y, -100.0f, 100.0f);
        int iM6142a = Utils_4.m6142a(pointF.x, pointF.y, pointF2.x, pointF2.y);
        WeakReference<Interpolator> weakReferenceM6000a = m6000a(iM6142a);
        Interpolator interpolator = weakReferenceM6000a != null ? weakReferenceM6000a.get() : null;
        if (weakReferenceM6000a == null || interpolator == null) {
            try {
                linearInterpolator = PathInterpolatorCompat_2.m2772a(pointF.x, pointF.y, pointF2.x, pointF2.y);
            } catch (IllegalArgumentException COUIBaseListPopupWindow_8) {
                if ("The Path cannot loop back on itself.".equals(COUIBaseListPopupWindow_8.getMessage())) {
                    linearInterpolator = PathInterpolatorCompat_2.m2772a(Math.min(pointF.x, 1.0f), pointF.y, Math.max(pointF2.x, 0.0f), pointF2.y);
                } else {
                    linearInterpolator = new LinearInterpolator();
                }
            }
            interpolator = linearInterpolator;
            try {
                m6001a(iM6142a, (WeakReference<Interpolator>) new WeakReference(interpolator));
            } catch (ArrayIndexOutOfBoundsException unused) {
            }
        }
        return interpolator;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static <T> Keyframe_2<T> m5998a(JsonReader abstractC1149c, float COUIBaseListPopupWindow_12, ValueParser_2<T> interfaceC1161aj) throws IOException {
        return new Keyframe_2<>(interfaceC1161aj.mo5948b(abstractC1149c, COUIBaseListPopupWindow_12));
    }
}
