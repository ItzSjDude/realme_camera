package com.oplus.anim.c_renamed;

/* compiled from: EffectiveCompositionCache.java */
/* loaded from: classes2.dex */
public class c_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final com.oplus.anim.c_renamed.c_renamed f3612a = new com.oplus.anim.c_renamed.c_renamed();

    /* renamed from: b_renamed, reason: collision with root package name */
    private final android.util.LruCache<java.lang.String, com.oplus.anim.a_renamed> f3613b = new android.util.LruCache<>(20);

    c_renamed() {
    }

    public static com.oplus.anim.c_renamed.c_renamed a_renamed() {
        return f3612a;
    }

    public com.oplus.anim.a_renamed a_renamed(java.lang.String str) {
        if (str == null) {
            return null;
        }
        return this.f3613b.get(str);
    }

    public void a_renamed(java.lang.String str, com.oplus.anim.a_renamed aVar) {
        if (str == null) {
            return;
        }
        this.f3613b.put(str, aVar);
    }
}
