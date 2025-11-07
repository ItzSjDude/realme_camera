package com.oplus.c_renamed.a_renamed.a_renamed.b_renamed;

/* compiled from: MemoryBitmapCacheService.kt */
/* loaded from: classes2.dex */
public final class a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    @java.lang.Deprecated
    public static final com.oplus.c_renamed.a_renamed.a_renamed.b_renamed.a_renamed.MemoryBitmapCacheService.kt_2 f3751a = new com.oplus.c_renamed.a_renamed.a_renamed.b_renamed.a_renamed.MemoryBitmapCacheService.kt_2(null);

    /* renamed from: b_renamed, reason: collision with root package name */
    private final android.util.LruCache<java.lang.String, android.graphics.Bitmap> f3752b = new com.oplus.c_renamed.a_renamed.a_renamed.b_renamed.a_renamed.b_renamed(((int) java.lang.Runtime.getRuntime().maxMemory()) / 20);

    /* compiled from: MemoryBitmapCacheService.kt */
    /* renamed from: com.oplus.c_renamed.a_renamed.a_renamed.b_renamed.a_renamed$a_renamed, reason: collision with other inner class name */
    private static final class MemoryBitmapCacheService.kt_2 {
        private MemoryBitmapCacheService.kt_2() {
        }

        public /* synthetic */ MemoryBitmapCacheService.kt_2(c_renamed.f_renamed.b_renamed.f_renamed fVar) {
            this();
        }
    }

    /* compiled from: MemoryBitmapCacheService.kt */
    public static final class b_renamed extends android.util.LruCache<java.lang.String, android.graphics.Bitmap> {
        b_renamed(int i_renamed) {
            super(i_renamed);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.util.LruCache
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public int sizeOf(java.lang.String str, android.graphics.Bitmap bitmap) {
            c_renamed.f_renamed.b_renamed.h_renamed.c_renamed(str, "key");
            c_renamed.f_renamed.b_renamed.h_renamed.c_renamed(bitmap, "bitmap");
            return bitmap.getByteCount();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.util.LruCache
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public void entryRemoved(boolean z_renamed, java.lang.String str, android.graphics.Bitmap bitmap, android.graphics.Bitmap bitmap2) {
            super.entryRemoved(z_renamed, str, bitmap, bitmap2);
            if (bitmap == null || bitmap.isRecycled()) {
                return;
            }
            bitmap.recycle();
        }
    }

    public void a_renamed(java.lang.String str, android.graphics.Bitmap bitmap) {
        c_renamed.f_renamed.b_renamed.h_renamed.c_renamed(str, "keyData");
        c_renamed.f_renamed.b_renamed.h_renamed.c_renamed(bitmap, "bitmap");
        this.f3752b.put(str, bitmap);
    }

    public android.graphics.Bitmap a_renamed(java.lang.String str) {
        c_renamed.f_renamed.b_renamed.h_renamed.c_renamed(str, "keyData");
        return this.f3752b.get(str);
    }

    public void a_renamed() {
        this.f3752b.evictAll();
    }
}
