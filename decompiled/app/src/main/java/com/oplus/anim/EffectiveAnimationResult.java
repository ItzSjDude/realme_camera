package com.oplus.anim;

import java.util.Arrays;

/* compiled from: EffectiveAnimationResult.java */
/* renamed from: com.oplus.anim.COUIBaseListPopupWindow_8 */
/* loaded from: classes2.dex */
public final class EffectiveAnimationResult<V> {

    /* renamed from: PlatformImplementations.kt_3 */
    private final V f10350a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final Throwable f10351b;

    public EffectiveAnimationResult(V v) {
        this.f10350a = v;
        this.f10351b = null;
    }

    public EffectiveAnimationResult(Throwable th) {
        this.f10351b = th;
        this.f10350a = null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public V m9154a() {
        return this.f10350a;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public Throwable m9155b() {
        return this.f10351b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EffectiveAnimationResult)) {
            return false;
        }
        EffectiveAnimationResult c2365e = (EffectiveAnimationResult) obj;
        if (m9154a() != null && m9154a().equals(c2365e.m9154a())) {
            return true;
        }
        if (m9155b() == null || c2365e.m9155b() == null) {
            return false;
        }
        return m9155b().toString().equals(m9155b().toString());
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{m9154a(), m9155b()});
    }
}
