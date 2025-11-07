package com.oplus.anim.p115c;

import android.util.LruCache;
import com.oplus.anim.EffectiveAnimationComposition;

/* compiled from: EffectiveCompositionCache.java */
/* renamed from: com.oplus.anim.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3 */
/* loaded from: classes2.dex */
public class EffectiveCompositionCache {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final EffectiveCompositionCache f10220a = new EffectiveCompositionCache();

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final LruCache<String, EffectiveAnimationComposition> f10221b = new LruCache<>(20);

    EffectiveCompositionCache() {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static EffectiveCompositionCache m9062a() {
        return f10220a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public EffectiveAnimationComposition m9063a(String str) {
        if (str == null) {
            return null;
        }
        return this.f10221b.get(str);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m9064a(String str, EffectiveAnimationComposition c2272a) {
        if (str == null) {
            return;
        }
        this.f10221b.put(str, c2272a);
    }
}
