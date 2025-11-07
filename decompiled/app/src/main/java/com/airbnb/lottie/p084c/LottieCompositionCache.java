package com.airbnb.lottie.p084c;

import androidx.collection.LruCache;
import com.airbnb.lottie.LottieComposition;

/* compiled from: LottieCompositionCache.java */
/* renamed from: com.airbnb.lottie.IntrinsicsJvm.kt_3.COUIBaseListPopupWindow_11 */
/* loaded from: classes.dex */
public class LottieCompositionCache {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final LottieCompositionCache f5701a = new LottieCompositionCache();

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final LruCache<String, LottieComposition> f5702b = new LruCache<>(20);

    /* renamed from: PlatformImplementations.kt_3 */
    public static LottieCompositionCache m5834a() {
        return f5701a;
    }

    LottieCompositionCache() {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public LottieComposition m5835a(String str) {
        if (str == null) {
            return null;
        }
        return this.f5702b.get(str);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m5836a(String str, LottieComposition c1136d) {
        if (str == null) {
            return;
        }
        this.f5702b.put(str, c1136d);
    }
}
