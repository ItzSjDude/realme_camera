package com.oplus.c_renamed.a_renamed.a_renamed;

/* compiled from: BitmapCacheManager.kt */
/* loaded from: classes2.dex */
public final class a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static final com.oplus.c_renamed.a_renamed.a_renamed.a_renamed.BitmapCacheManager.kt_2 f3730a = new com.oplus.c_renamed.a_renamed.a_renamed.a_renamed.BitmapCacheManager.kt_2(null);
    private static volatile com.oplus.c_renamed.a_renamed.a_renamed.a_renamed d_renamed;

    /* renamed from: b_renamed, reason: collision with root package name */
    private com.oplus.c_renamed.a_renamed.a_renamed.b_renamed.a_renamed f3731b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private com.oplus.c_renamed.a_renamed.a_renamed.a_renamed.d_renamed f3732c;

    private a_renamed(android.content.Context context) {
        this.f3731b = new com.oplus.c_renamed.a_renamed.a_renamed.b_renamed.a_renamed();
        this.f3732c = new com.oplus.c_renamed.a_renamed.a_renamed.a_renamed.d_renamed(context);
    }

    public /* synthetic */ a_renamed(android.content.Context context, c_renamed.f_renamed.b_renamed.f_renamed fVar) {
        this(context);
    }

    /* compiled from: BitmapCacheManager.kt */
    /* renamed from: com.oplus.c_renamed.a_renamed.a_renamed.a_renamed$a_renamed, reason: collision with other inner class name */
    public static final class BitmapCacheManager.kt_2 {
        private BitmapCacheManager.kt_2() {
        }

        public /* synthetic */ BitmapCacheManager.kt_2(c_renamed.f_renamed.b_renamed.f_renamed fVar) {
            this();
        }

        public final com.oplus.c_renamed.a_renamed.a_renamed.a_renamed a_renamed(android.content.Context context) {
            c_renamed.f_renamed.b_renamed.h_renamed.c_renamed(context, "context");
            if (com.oplus.c_renamed.a_renamed.a_renamed.a_renamed.d_renamed == null) {
                synchronized (this) {
                    if (com.oplus.c_renamed.a_renamed.a_renamed.a_renamed.d_renamed == null) {
                        com.oplus.c_renamed.a_renamed.a_renamed.a_renamed.d_renamed = new com.oplus.c_renamed.a_renamed.a_renamed.a_renamed(context, null);
                    }
                }
            }
            com.oplus.c_renamed.a_renamed.a_renamed.a_renamed aVar = com.oplus.c_renamed.a_renamed.a_renamed.a_renamed.d_renamed;
            if (aVar == null) {
                c_renamed.f_renamed.b_renamed.h_renamed.a_renamed();
            }
            return aVar;
        }
    }

    public final void a_renamed(java.lang.String str, android.graphics.Bitmap bitmap) {
        c_renamed.f_renamed.b_renamed.h_renamed.c_renamed(str, "key");
        c_renamed.f_renamed.b_renamed.h_renamed.c_renamed(bitmap, "bitmap");
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        com.oplus.c_renamed.a_renamed.a_renamed.b_renamed.a_renamed aVar = this.f3731b;
        if (aVar != null) {
            aVar.a_renamed(str, bitmap);
        }
        com.oplus.c_renamed.a_renamed.a_renamed.a_renamed.d_renamed dVar = this.f3732c;
        if (dVar != null) {
            dVar.a_renamed(str, bitmap);
        }
        com.oplus.c_renamed.a_renamed.e_renamed.a_renamed.a_renamed("BitmapCacheManager", "putBitmapToCache cost time = " + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis));
    }

    public final android.graphics.Bitmap a_renamed(java.lang.String str) {
        android.graphics.Bitmap bitmapA;
        android.graphics.Bitmap bitmapA2;
        c_renamed.f_renamed.b_renamed.h_renamed.c_renamed(str, "key");
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        com.oplus.c_renamed.a_renamed.a_renamed.b_renamed.a_renamed aVar = this.f3731b;
        if (aVar != null && (bitmapA2 = aVar.a_renamed(str)) != null) {
            com.oplus.c_renamed.a_renamed.e_renamed.a_renamed.a_renamed("BitmapCacheManager", "getBitmapFromCache  form lruCache cost time = " + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis));
            return bitmapA2;
        }
        long jCurrentTimeMillis2 = java.lang.System.currentTimeMillis();
        com.oplus.c_renamed.a_renamed.a_renamed.a_renamed.d_renamed dVar = this.f3732c;
        if (dVar == null || (bitmapA = dVar.a_renamed(str)) == null) {
            return null;
        }
        com.oplus.c_renamed.a_renamed.a_renamed.b_renamed.a_renamed aVar2 = this.f3731b;
        if (aVar2 != null) {
            aVar2.a_renamed(str, bitmapA);
        }
        com.oplus.c_renamed.a_renamed.e_renamed.a_renamed.a_renamed("BitmapCacheManager", "getBitmapFromCache  form disk cost time = " + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis2));
        return bitmapA;
    }

    public final void a_renamed() {
        com.oplus.c_renamed.a_renamed.a_renamed.b_renamed.a_renamed aVar = this.f3731b;
        if (aVar != null) {
            aVar.a_renamed();
        }
    }

    public final void b_renamed() {
        com.oplus.c_renamed.a_renamed.a_renamed.a_renamed.d_renamed dVar = this.f3732c;
        if (dVar != null) {
            dVar.a_renamed();
        }
    }
}
