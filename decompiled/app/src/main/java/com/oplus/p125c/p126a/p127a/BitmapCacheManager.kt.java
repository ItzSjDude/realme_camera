package com.oplus.p125c.p126a.p127a;

import android.content.Context;
import android.graphics.Bitmap;
import com.oplus.p125c.p126a.p127a.p128a.DiskBitmapCacheService.kt;
import com.oplus.p125c.p126a.p127a.p129b.MemoryBitmapCacheService.kt;
import com.oplus.p125c.p126a.p135e.Debugger.kt;
import p061c.p070f.p072b.DefaultConstructorMarker;
import p061c.p070f.p072b.Intrinsics;

/* compiled from: BitmapCacheManager.kt */
/* renamed from: com.oplus.IntrinsicsJvm.kt_3.PlatformImplementations.kt_3.PlatformImplementations.kt_3.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public final class BitmapCacheManager.kt {

    /* renamed from: PlatformImplementations.kt_3 */
    public static final PlatformImplementations.kt_3 f10468a = new PlatformImplementations.kt_3(null);

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static volatile BitmapCacheManager.kt f10469d;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private MemoryBitmapCacheService.kt f10470b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private DiskBitmapCacheService.kt f10471c;

    private BitmapCacheManager.kt(Context context) {
        this.f10470b = new MemoryBitmapCacheService.kt();
        this.f10471c = new DiskBitmapCacheService.kt(context);
    }

    public /* synthetic */ BitmapCacheManager.kt(Context context, DefaultConstructorMarker c0970f) {
        this(context);
    }

    /* compiled from: BitmapCacheManager.kt */
    /* renamed from: com.oplus.IntrinsicsJvm.kt_3.PlatformImplementations.kt_3.PlatformImplementations.kt_3.PlatformImplementations.kt_3$PlatformImplementations.kt_3 */
    public static final class PlatformImplementations.kt_3 {
        private PlatformImplementations.kt_3() {
        }

        public /* synthetic */ PlatformImplementations.kt_3(DefaultConstructorMarker c0970f) {
            this();
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public final BitmapCacheManager.kt m9378a(Context context) {
            Intrinsics.m5303c(context, "context");
            if (BitmapCacheManager.kt.f10469d == null) {
                synchronized (this) {
                    if (BitmapCacheManager.kt.f10469d == null) {
                        BitmapCacheManager.kt.f10469d = new BitmapCacheManager.kt(context, null);
                    }
                }
            }
            BitmapCacheManager.kt c2428a = BitmapCacheManager.kt.f10469d;
            if (c2428a == null) {
                Intrinsics.m5295a();
            }
            return c2428a;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final void m9376a(String str, Bitmap bitmap) {
        Intrinsics.m5303c(str, "key");
        Intrinsics.m5303c(bitmap, "bitmap");
        long jCurrentTimeMillis = System.currentTimeMillis();
        MemoryBitmapCacheService.kt c2434a = this.f10470b;
        if (c2434a != null) {
            c2434a.m9418a(str, bitmap);
        }
        DiskBitmapCacheService.kt c2432d = this.f10471c;
        if (c2432d != null) {
            c2432d.m9413a(str, bitmap);
        }
        Debugger.kt.m9503a("BitmapCacheManager", "putBitmapToCache cost time = " + (System.currentTimeMillis() - jCurrentTimeMillis));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final Bitmap m9374a(String str) {
        Bitmap bitmapM9411a;
        Bitmap bitmapM9416a;
        Intrinsics.m5303c(str, "key");
        long jCurrentTimeMillis = System.currentTimeMillis();
        MemoryBitmapCacheService.kt c2434a = this.f10470b;
        if (c2434a != null && (bitmapM9416a = c2434a.m9416a(str)) != null) {
            Debugger.kt.m9503a("BitmapCacheManager", "getBitmapFromCache  form lruCache cost time = " + (System.currentTimeMillis() - jCurrentTimeMillis));
            return bitmapM9416a;
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        DiskBitmapCacheService.kt c2432d = this.f10471c;
        if (c2432d == null || (bitmapM9411a = c2432d.m9411a(str)) == null) {
            return null;
        }
        MemoryBitmapCacheService.kt c2434a2 = this.f10470b;
        if (c2434a2 != null) {
            c2434a2.m9418a(str, bitmapM9411a);
        }
        Debugger.kt.m9503a("BitmapCacheManager", "getBitmapFromCache  form disk cost time = " + (System.currentTimeMillis() - jCurrentTimeMillis2));
        return bitmapM9411a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final void m9375a() {
        MemoryBitmapCacheService.kt c2434a = this.f10470b;
        if (c2434a != null) {
            c2434a.m9417a();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public final void m9377b() {
        DiskBitmapCacheService.kt c2432d = this.f10471c;
        if (c2432d != null) {
            c2432d.m9412a();
        }
    }
}
