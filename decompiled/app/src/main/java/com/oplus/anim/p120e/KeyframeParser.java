package com.oplus.anim.p120e;

import android.util.JsonReader;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.collection.SparseArrayCompat;
import com.oplus.anim.EffectiveAnimationComposition;
import com.oplus.anim.p122g.Keyframe;
import java.io.IOException;
import java.lang.ref.WeakReference;

/* compiled from: KeyframeParser.java */
/* renamed from: com.oplus.anim.COUIBaseListPopupWindow_8.r */
/* loaded from: classes2.dex */
class KeyframeParser {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final Interpolator f10360a = new LinearInterpolator();

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static SparseArrayCompat<WeakReference<Interpolator>> f10361b;

    KeyframeParser() {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static SparseArrayCompat<WeakReference<Interpolator>> m9214a() {
        if (f10361b == null) {
            f10361b = new SparseArrayCompat<>();
        }
        return f10361b;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static WeakReference<Interpolator> m9218a(int OplusGLSurfaceView_13) {
        WeakReference<Interpolator> weakReference;
        synchronized (KeyframeParser.class) {
            weakReference = m9214a().get(OplusGLSurfaceView_13);
        }
        return weakReference;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static void m9219a(int OplusGLSurfaceView_13, WeakReference<Interpolator> weakReference) {
        synchronized (KeyframeParser.class) {
            f10361b.put(OplusGLSurfaceView_13, weakReference);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static <T> Keyframe<T> m9216a(JsonReader jsonReader, EffectiveAnimationComposition c2272a, float COUIBaseListPopupWindow_12, ValueParser<T> interfaceC2376aj, boolean z) throws IOException {
        if (z) {
            return m9217a(c2272a, jsonReader, COUIBaseListPopupWindow_12, interfaceC2376aj);
        }
        return m9215a(jsonReader, COUIBaseListPopupWindow_12, interfaceC2376aj);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static <T> Keyframe<T> m9215a(JsonReader jsonReader, float COUIBaseListPopupWindow_12, ValueParser<T> interfaceC2376aj) throws IOException {
        return new Keyframe<>(interfaceC2376aj.mo9161b(jsonReader, COUIBaseListPopupWindow_12));
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0093  */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static <T> com.oplus.anim.p122g.Keyframe<T> m9217a(com.oplus.anim.EffectiveAnimationComposition r17, android.util.JsonReader r18, float r19, com.oplus.anim.p120e.ValueParser<T> r20) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 372
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.anim.p120e.KeyframeParser.m9217a(com.oplus.anim.PlatformImplementations.kt_3, android.util.JsonReader, float, com.oplus.anim.COUIBaseListPopupWindow_8.aj):com.oplus.anim.COUIBaseListPopupWindow_11.IntrinsicsJvm.kt_3");
    }
}
