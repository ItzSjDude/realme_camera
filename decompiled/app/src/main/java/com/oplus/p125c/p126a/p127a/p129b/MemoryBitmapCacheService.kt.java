package com.oplus.p125c.p126a.p127a.p129b;

import android.graphics.Bitmap;
import android.util.LruCache;
import p061c.p070f.p072b.DefaultConstructorMarker;
import p061c.p070f.p072b.Intrinsics;

/* compiled from: MemoryBitmapCacheService.kt */
/* renamed from: com.oplus.IntrinsicsJvm.kt_3.PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public final class MemoryBitmapCacheService.kt {

    /* renamed from: PlatformImplementations.kt_3 */
    @Deprecated
    public static final PlatformImplementations.kt_3 f10508a = new PlatformImplementations.kt_3(null);

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final LruCache<String, Bitmap> f10509b = new IntrinsicsJvm.kt_4(((int) Runtime.getRuntime().maxMemory()) / 20);

    /* compiled from: MemoryBitmapCacheService.kt */
    /* renamed from: com.oplus.IntrinsicsJvm.kt_3.PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3$PlatformImplementations.kt_3 */
    private static final class PlatformImplementations.kt_3 {
        private PlatformImplementations.kt_3() {
        }

        public /* synthetic */ PlatformImplementations.kt_3(DefaultConstructorMarker c0970f) {
            this();
        }
    }

    /* compiled from: MemoryBitmapCacheService.kt */
    /* renamed from: com.oplus.IntrinsicsJvm.kt_3.PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3$IntrinsicsJvm.kt_4 */
    public static final class IntrinsicsJvm.kt_4 extends LruCache<String, Bitmap> {
        IntrinsicsJvm.kt_4(int OplusGLSurfaceView_13) {
            super(OplusGLSurfaceView_13);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.util.LruCache
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public int sizeOf(String str, Bitmap bitmap) {
            Intrinsics.m5303c(str, "key");
            Intrinsics.m5303c(bitmap, "bitmap");
            return bitmap.getByteCount();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.util.LruCache
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public void entryRemoved(boolean z, String str, Bitmap bitmap, Bitmap bitmap2) {
            super.entryRemoved(z, str, bitmap, bitmap2);
            if (bitmap == null || bitmap.isRecycled()) {
                return;
            }
            bitmap.recycle();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m9418a(String str, Bitmap bitmap) {
        Intrinsics.m5303c(str, "keyData");
        Intrinsics.m5303c(bitmap, "bitmap");
        this.f10509b.put(str, bitmap);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public Bitmap m9416a(String str) {
        Intrinsics.m5303c(str, "keyData");
        return this.f10509b.get(str);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m9417a() {
        this.f10509b.evictAll();
    }
}
