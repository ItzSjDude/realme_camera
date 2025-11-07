package com.oplus.p125c.p126a.p127a.p128a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.oplus.ocs.camera.CameraParameter;
import com.oplus.p125c.p126a.p127a.p128a.BlobCache;
import com.oplus.p125c.p126a.p127a.p128a.BytesBufferPool;
import com.oplus.p125c.p126a.p135e.Debugger.kt;
import com.oplus.p125c.p126a.p135e.Utils;
import java.io.IOException;
import java.nio.ByteBuffer;
import p061c.Unit.kt;
import p061c.p070f.p072b.DefaultConstructorMarker;
import p061c.p070f.p072b.Intrinsics;

/* compiled from: DiskBitmapCacheService.kt */
/* renamed from: com.oplus.IntrinsicsJvm.kt_3.PlatformImplementations.kt_3.PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_5 */
/* loaded from: classes2.dex */
public final class DiskBitmapCacheService.kt {

    /* renamed from: PlatformImplementations.kt_3 */
    @Deprecated
    public static final PlatformImplementations.kt_3 f10503a = new PlatformImplementations.kt_3(null);

    /* renamed from: IntrinsicsJvm.kt_4 */
    private BlobCache f10504b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final Context f10505c;

    public DiskBitmapCacheService.kt(Context context) {
        Intrinsics.m5303c(context, "context");
        this.f10505c = context;
        this.f10504b = BlobCacheManager.m9402a(this.f10505c, "imgcache", 50, 314572800, 1);
    }

    /* compiled from: DiskBitmapCacheService.kt */
    /* renamed from: com.oplus.IntrinsicsJvm.kt_3.PlatformImplementations.kt_3.PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_5$PlatformImplementations.kt_3 */
    private static final class PlatformImplementations.kt_3 {
        private PlatformImplementations.kt_3() {
        }

        public /* synthetic */ PlatformImplementations.kt_3(DefaultConstructorMarker c0970f) {
            this();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public Bitmap m9411a(String str) {
        Intrinsics.m5303c(str, "keyData");
        BytesBufferPool.PlatformImplementations.kt_3 aVarM9406a = ThumbnailPools.kt.m9414a().m9406a();
        try {
            try {
                Intrinsics.m5297a((Object) aVarM9406a, CameraParameter.WaterMarkParamKeys.YUV_BUFFER);
                if (m9409a(str, aVarM9406a)) {
                    return BitmapFactory.decodeByteArray(aVarM9406a.f10500a, aVarM9406a.f10501b, aVarM9406a.f10502c);
                }
            } catch (Exception COUIBaseListPopupWindow_8) {
                Debugger.kt.m9508c("DiskImageCacheService", "getCacheBitmap", COUIBaseListPopupWindow_8);
            }
            return null;
        } finally {
            ThumbnailPools.kt.m9414a().m9407a(aVarM9406a);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m9412a() {
        BlobCacheManager.m9405a(this.f10505c, "imgcache");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private final boolean m9410a(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null || bArr2.length < bArr.length) {
            return false;
        }
        int length = bArr.length;
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < length; OplusGLSurfaceView_13++) {
            if (bArr[OplusGLSurfaceView_13] != bArr2[OplusGLSurfaceView_13]) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private final boolean m9409a(String str, BytesBufferPool.PlatformImplementations.kt_3 aVar) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        byte[] bArrM9514a = Utils.m9514a(str);
        long jM9509a = Utils.m9509a(bArrM9514a);
        try {
            BlobCache.PlatformImplementations.kt_3 aVar2 = new BlobCache.PlatformImplementations.kt_3();
            aVar2.f10493a = jM9509a;
            aVar2.f10494b = aVar.f10500a;
            BlobCache c2429a = this.f10504b;
            if (c2429a != null) {
                synchronized (c2429a) {
                    if (!c2429a.m9400a(aVar2)) {
                        Debugger.kt.m9503a("DiskImageCacheService", "getCacheDataFromDisk !mCache.lookup(request) cost time = " + (System.currentTimeMillis() - jCurrentTimeMillis));
                        return false;
                    }
                    Unit.kt c1025s = Unit.kt.f5071a;
                    if (m9410a(bArrM9514a, aVar2.f10494b)) {
                        aVar.f10500a = aVar2.f10494b;
                        aVar.f10501b = bArrM9514a.length;
                        aVar.f10502c = aVar2.f10495c - aVar.f10501b;
                        Debugger.kt.m9503a("DiskImageCacheService", "getCacheDataFromDisk isSameKey cost time = " + (System.currentTimeMillis() - jCurrentTimeMillis));
                        return true;
                    }
                }
            }
        } catch (Exception COUIBaseListPopupWindow_8) {
            Debugger.kt.m9504a("DiskImageCacheService", "getCacheDataFromDisk", COUIBaseListPopupWindow_8);
        }
        Debugger.kt.m9503a("DiskImageCacheService", "getCacheDataFromDisk end cost time = " + (System.currentTimeMillis() - jCurrentTimeMillis));
        return false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m9413a(String str, Bitmap bitmap) {
        Intrinsics.m5303c(str, "keyData");
        Intrinsics.m5303c(bitmap, "bitmap");
        long jCurrentTimeMillis = System.currentTimeMillis();
        byte[] bArrM9512a = Utils.m9512a(bitmap);
        if (this.f10504b == null) {
            Debugger.kt.m9505b("DiskImageCacheService", "putDataToCache mCache is null");
            return;
        }
        byte[] bArrM9514a = Utils.m9514a(str);
        Intrinsics.m5297a((Object) bArrM9514a, "Utils.getBytes(keyData)");
        long jM9509a = Utils.m9509a(bArrM9514a);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bArrM9514a.length + bArrM9512a.length);
        byteBufferAllocate.put(bArrM9514a);
        byteBufferAllocate.put(bArrM9512a);
        BlobCache c2429a = this.f10504b;
        if (c2429a != null) {
            synchronized (c2429a) {
                try {
                    c2429a.m9399a(jM9509a, byteBufferAllocate.array());
                } catch (IOException COUIBaseListPopupWindow_8) {
                    Debugger.kt.m9504a("DiskImageCacheService", "getCacheDataFromDisk", COUIBaseListPopupWindow_8);
                }
                Unit.kt c1025s = Unit.kt.f5071a;
            }
        }
        Debugger.kt.m9503a("DiskImageCacheService", "putDataToCache  cost time = " + (System.currentTimeMillis() - jCurrentTimeMillis));
    }
}
