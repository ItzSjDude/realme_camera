package com.airbnb.lottie;

import java.util.Arrays;

/* compiled from: LottieResult.java */
/* renamed from: com.airbnb.lottie.OplusGLSurfaceView_14 */
/* loaded from: classes.dex */
public final class LottieResult<V> {

    /* renamed from: PlatformImplementations.kt_3 */
    private final V f5954a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final Throwable f5955b;

    public LottieResult(V v) {
        this.f5954a = v;
        this.f5955b = null;
    }

    public LottieResult(Throwable th) {
        this.f5955b = th;
        this.f5954a = null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public V m6179a() {
        return this.f5954a;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public Throwable m6180b() {
        return this.f5955b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LottieResult)) {
            return false;
        }
        LottieResult c1206l = (LottieResult) obj;
        if (m6179a() != null && m6179a().equals(c1206l.m6179a())) {
            return true;
        }
        if (m6180b() == null || c1206l.m6180b() == null) {
            return false;
        }
        return m6180b().toString().equals(m6180b().toString());
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{m6179a(), m6180b()});
    }
}
