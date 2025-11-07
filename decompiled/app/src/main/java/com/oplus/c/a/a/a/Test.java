package com.oplus.c_renamed.a_renamed.a_renamed.a_renamed;

/* compiled from: DiskBitmapCacheService.kt */
/* loaded from: classes2.dex */
public final class d_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    @java.lang.Deprecated
    public static final com.oplus.c_renamed.a_renamed.a_renamed.a_renamed.d_renamed.a_renamed f3746a = new com.oplus.c_renamed.a_renamed.a_renamed.a_renamed.d_renamed.a_renamed(null);

    /* renamed from: b_renamed, reason: collision with root package name */
    private com.oplus.c_renamed.a_renamed.a_renamed.a_renamed.a_renamed f3747b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final android.content.Context f3748c;

    public d_renamed(android.content.Context context) {
        c_renamed.f_renamed.b_renamed.h_renamed.c_renamed(context, "context");
        this.f3748c = context;
        this.f3747b = com.oplus.c_renamed.a_renamed.a_renamed.a_renamed.b_renamed.a_renamed(this.f3748c, "imgcache", 50, 314572800, 1);
    }

    /* compiled from: DiskBitmapCacheService.kt */
    private static final class a_renamed {
        private a_renamed() {
        }

        public /* synthetic */ a_renamed(c_renamed.f_renamed.b_renamed.f_renamed fVar) {
            this();
        }
    }

    public android.graphics.Bitmap a_renamed(java.lang.String str) {
        c_renamed.f_renamed.b_renamed.h_renamed.c_renamed(str, "keyData");
        com.oplus.c_renamed.a_renamed.a_renamed.a_renamed.c_renamed.a_renamed aVarA = com.oplus.c_renamed.a_renamed.a_renamed.a_renamed.e_renamed.a_renamed().a_renamed();
        try {
            try {
                c_renamed.f_renamed.b_renamed.h_renamed.a_renamed((java.lang.Object) aVarA, com.oplus.ocs.camera.CameraParameter.WaterMarkParamKeys.YUV_BUFFER);
                if (a_renamed(str, aVarA)) {
                    return android.graphics.BitmapFactory.decodeByteArray(aVarA.f3743a, aVarA.f3744b, aVarA.f3745c);
                }
            } catch (java.lang.Exception e_renamed) {
                com.oplus.c_renamed.a_renamed.e_renamed.a_renamed.c_renamed("DiskImageCacheService", "getCacheBitmap", e_renamed);
            }
            return null;
        } finally {
            com.oplus.c_renamed.a_renamed.a_renamed.a_renamed.e_renamed.a_renamed().a_renamed(aVarA);
        }
    }

    public void a_renamed() {
        com.oplus.c_renamed.a_renamed.a_renamed.a_renamed.b_renamed.a_renamed(this.f3748c, "imgcache");
    }

    private final boolean a_renamed(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null || bArr2.length < bArr.length) {
            return false;
        }
        int length = bArr.length;
        for (int i_renamed = 0; i_renamed < length; i_renamed++) {
            if (bArr[i_renamed] != bArr2[i_renamed]) {
                return false;
            }
        }
        return true;
    }

    private final boolean a_renamed(java.lang.String str, com.oplus.c_renamed.a_renamed.a_renamed.a_renamed.c_renamed.a_renamed aVar) {
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        byte[] bArrA = com.oplus.c_renamed.a_renamed.e_renamed.b_renamed.a_renamed(str);
        long jA = com.oplus.c_renamed.a_renamed.e_renamed.b_renamed.a_renamed(bArrA);
        try {
            com.oplus.c_renamed.a_renamed.a_renamed.a_renamed.a_renamed.BlobCache_2 c0081a = new com.oplus.c_renamed.a_renamed.a_renamed.a_renamed.a_renamed.BlobCache_2();
            c0081a.f3736a = jA;
            c0081a.f3737b = aVar.f3743a;
            com.oplus.c_renamed.a_renamed.a_renamed.a_renamed.a_renamed aVar2 = this.f3747b;
            if (aVar2 != null) {
                synchronized (aVar2) {
                    if (!aVar2.a_renamed(c0081a)) {
                        com.oplus.c_renamed.a_renamed.e_renamed.a_renamed.a_renamed("DiskImageCacheService", "getCacheDataFromDisk !mCache.lookup(request) cost time = " + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis));
                        return false;
                    }
                    c_renamed.s_renamed sVar = c_renamed.s_renamed.f1925a;
                    if (a_renamed(bArrA, c0081a.f3737b)) {
                        aVar.f3743a = c0081a.f3737b;
                        aVar.f3744b = bArrA.length;
                        aVar.f3745c = c0081a.f3738c - aVar.f3744b;
                        com.oplus.c_renamed.a_renamed.e_renamed.a_renamed.a_renamed("DiskImageCacheService", "getCacheDataFromDisk isSameKey cost time = " + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis));
                        return true;
                    }
                }
            }
        } catch (java.lang.Exception e_renamed) {
            com.oplus.c_renamed.a_renamed.e_renamed.a_renamed.a_renamed("DiskImageCacheService", "getCacheDataFromDisk", e_renamed);
        }
        com.oplus.c_renamed.a_renamed.e_renamed.a_renamed.a_renamed("DiskImageCacheService", "getCacheDataFromDisk end cost time = " + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis));
        return false;
    }

    public void a_renamed(java.lang.String str, android.graphics.Bitmap bitmap) {
        c_renamed.f_renamed.b_renamed.h_renamed.c_renamed(str, "keyData");
        c_renamed.f_renamed.b_renamed.h_renamed.c_renamed(bitmap, "bitmap");
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        byte[] bArrA = com.oplus.c_renamed.a_renamed.e_renamed.b_renamed.a_renamed(bitmap);
        if (this.f3747b == null) {
            com.oplus.c_renamed.a_renamed.e_renamed.a_renamed.b_renamed("DiskImageCacheService", "putDataToCache mCache is_renamed null");
            return;
        }
        byte[] bArrA2 = com.oplus.c_renamed.a_renamed.e_renamed.b_renamed.a_renamed(str);
        c_renamed.f_renamed.b_renamed.h_renamed.a_renamed((java.lang.Object) bArrA2, "Utils.getBytes(keyData)");
        long jA = com.oplus.c_renamed.a_renamed.e_renamed.b_renamed.a_renamed(bArrA2);
        java.nio.ByteBuffer byteBufferAllocate = java.nio.ByteBuffer.allocate(bArrA2.length + bArrA.length);
        byteBufferAllocate.put(bArrA2);
        byteBufferAllocate.put(bArrA);
        com.oplus.c_renamed.a_renamed.a_renamed.a_renamed.a_renamed aVar = this.f3747b;
        if (aVar != null) {
            synchronized (aVar) {
                try {
                    aVar.a_renamed(jA, byteBufferAllocate.array());
                } catch (java.io.IOException e_renamed) {
                    com.oplus.c_renamed.a_renamed.e_renamed.a_renamed.a_renamed("DiskImageCacheService", "getCacheDataFromDisk", e_renamed);
                }
                c_renamed.s_renamed sVar = c_renamed.s_renamed.f1925a;
            }
        }
        com.oplus.c_renamed.a_renamed.e_renamed.a_renamed.a_renamed("DiskImageCacheService", "putDataToCache  cost time = " + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis));
    }
}
