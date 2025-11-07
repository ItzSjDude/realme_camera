package com.oplus.p125c.p126a.p127a.p128a;

/* compiled from: ThumbnailPools.kt */
/* renamed from: com.oplus.IntrinsicsJvm.kt_3.PlatformImplementations.kt_3.PlatformImplementations.kt_3.PlatformImplementations.kt_3.COUIBaseListPopupWindow_8 */
/* loaded from: classes2.dex */
public final class ThumbnailPools.kt {

    /* renamed from: PlatformImplementations.kt_3 */
    public static final ThumbnailPools.kt f10506a = new ThumbnailPools.kt();

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static final BytesBufferPool f10507b = new BytesBufferPool(16, 307200);

    private ThumbnailPools.kt() {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static final BytesBufferPool m9414a() {
        return f10507b;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static final void m9415b() {
        f10507b.m9408b();
    }
}
