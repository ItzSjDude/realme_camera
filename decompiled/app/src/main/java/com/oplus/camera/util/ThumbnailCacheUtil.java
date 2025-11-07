package com.oplus.camera.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.LruCache;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.oplus.camera.CameraLog;
import com.oplus.camera.Storage;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.jni.IccProfile;
import com.oplus.camera.p160q.DocumentUtil;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Comparator;
import libcore.p217io.DiskLruCache;

/* compiled from: ThumbnailCacheUtil.java */
/* renamed from: com.oplus.camera.util.OplusGLSurfaceView_11 */
/* loaded from: classes2.dex */
public class ThumbnailCacheUtil {

    /* renamed from: PlatformImplementations.kt_3 */
    private static LruCache<String, IntrinsicsJvm.kt_4> f23089a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private DiskLruCache f23090b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private FileFilter f23091c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private Comparator<File> f23092d;

    /* renamed from: PlatformImplementations.kt_3 */
    public void m24620a(String str, IntrinsicsJvm.kt_4 bVar) {
        LruCache<String, IntrinsicsJvm.kt_4> lruCache = f23089a;
        if (lruCache != null) {
            lruCache.put(str, bVar);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m24618a(String str) {
        LruCache<String, IntrinsicsJvm.kt_4> lruCache = f23089a;
        if (lruCache != null) {
            lruCache.remove(str);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public IntrinsicsJvm.kt_4 m24621b(String str) {
        IntrinsicsJvm.kt_4 bVar = f23089a.get(str);
        if (f23089a == null || bVar == null) {
            return null;
        }
        Bitmap bitmapM24637c = bVar.m24637c();
        synchronized (f23089a) {
            if (bitmapM24637c != null) {
                if (!bitmapM24637c.isRecycled()) {
                    IntrinsicsJvm.kt_4 bVar2 = new IntrinsicsJvm.kt_4();
                    bVar2.m24634a(bVar.m24636b());
                    bVar2.m24633a(bVar.m24632a());
                    bVar2.m24635a(bitmapM24637c.copy(Bitmap.Config.ARGB_8888, true));
                    return bVar2;
                }
            }
            return null;
        }
    }

    private ThumbnailCacheUtil() {
        this.f23090b = null;
        this.f23091c = new FileFilter() { // from class: com.oplus.camera.util.OplusGLSurfaceView_11.4
            @Override // java.io.FileFilter
            public boolean accept(File file) {
                String name;
                return file.isFile() && (name = file.getName()) != null && name.startsWith("IMG");
            }
        };
        this.f23092d = new Comparator<File>() { // from class: com.oplus.camera.util.OplusGLSurfaceView_11.5
            @Override // java.util.Comparator
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public int compare(File file, File file2) {
                long jLastModified = file.lastModified() - file2.lastModified();
                if (jLastModified > 0) {
                    return -1;
                }
                return 0 == jLastModified ? 0 : 1;
            }
        };
        f23089a = new LruCache<String, IntrinsicsJvm.kt_4>(ExtractorMediaSource.DEFAULT_LOADING_CHECK_INTERVAL_BYTES) { // from class: com.oplus.camera.util.OplusGLSurfaceView_11.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.util.LruCache
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public int sizeOf(String str, IntrinsicsJvm.kt_4 bVar) {
                return bVar.m24637c().getByteCount();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.util.LruCache
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public void entryRemoved(boolean z, String str, IntrinsicsJvm.kt_4 bVar, IntrinsicsJvm.kt_4 bVar2) {
                CameraLog.m12959b("ThumbnailCacheUtil", "entryRemoved, remove the bitmap's key: " + str);
                synchronized (ThumbnailCacheUtil.f23089a) {
                    if (bVar != null) {
                        if (bVar.m24637c() != null) {
                            bVar.m24637c().recycle();
                        }
                        bVar = null;
                        super.entryRemoved(z, str, bVar, bVar2);
                    } else {
                        super.entryRemoved(z, str, bVar, bVar2);
                    }
                }
            }
        };
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static ThumbnailCacheUtil m24610a() {
        return PlatformImplementations.kt_3.f23098a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private DiskLruCache m24611a(String str, boolean z) {
        DiskLruCache c3965a;
        File file = new File(str);
        if (!z || !file.exists() || ((c3965a = this.f23090b) != null && c3965a.m25977b())) {
            DiskLruCache c3965a2 = this.f23090b;
            if (c3965a2 != null) {
                try {
                    c3965a2.close();
                } catch (Exception COUIBaseListPopupWindow_8) {
                    COUIBaseListPopupWindow_8.printStackTrace();
                }
            }
            if (!file.exists()) {
                file.mkdirs();
            }
            try {
                return DiskLruCache.m25954a(file, 1, 1, 52428800L);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return this.f23090b;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m24613a(Bitmap bitmap, DiskLruCache.PlatformImplementations.kt_3 aVar, boolean z) throws IOException {
        CameraLog.m12954a("ThumbnailCacheUtil", "saveBitmapToDiskLruCache");
        if (bitmap == null) {
            CameraLog.m12967f("ThumbnailCacheUtil", "saveBitmapToDiskLruCache, bitmap: " + bitmap);
            return false;
        }
        OutputStream outputStreamM25984a = null;
        int OplusGLSurfaceView_13 = z ? 90 : 75;
        try {
            try {
                outputStreamM25984a = aVar.m25984a(0);
                boolean zCompress = bitmap.compress(Bitmap.CompressFormat.JPEG, OplusGLSurfaceView_13, outputStreamM25984a);
                if (!zCompress) {
                    CameraLog.m12967f("ThumbnailCacheUtil", "saveBitmapToDiskLruCache, bitmap compress fail, byte count: " + bitmap.getByteCount() + ", isRecycled: " + bitmap.isRecycled() + ", width: " + bitmap.getWidth() + ", height: " + bitmap.getHeight());
                }
                outputStreamM25984a.flush();
                if (outputStreamM25984a != null) {
                    try {
                        outputStreamM25984a.close();
                    } catch (IOException COUIBaseListPopupWindow_8) {
                        COUIBaseListPopupWindow_8.printStackTrace();
                    }
                }
                CameraLog.m12954a("ThumbnailCacheUtil", "saveBitmapToDiskLruCache X");
                return zCompress;
            } catch (Exception e2) {
                e2.printStackTrace();
                if (outputStreamM25984a != null) {
                    try {
                        outputStreamM25984a.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                CameraLog.m12954a("ThumbnailCacheUtil", "saveBitmapToDiskLruCache X");
                return false;
            }
        } catch (Throwable th) {
            if (outputStreamM25984a != null) {
                try {
                    outputStreamM25984a.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
            CameraLog.m12954a("ThumbnailCacheUtil", "saveBitmapToDiskLruCache X");
            throw th;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m24619a(String str, Bitmap bitmap, boolean z) {
        if (this.f23090b == null) {
            this.f23090b = m24611a(Storage.m11124b(), false);
        } else {
            this.f23090b = m24611a(Storage.m11124b(), true);
        }
        DiskLruCache c3965a = this.f23090b;
        if (c3965a == null) {
            CameraLog.m12967f("ThumbnailCacheUtil", "saveSmallImageForGallery, mDiskLruCache null");
            return;
        }
        try {
            DiskLruCache.PlatformImplementations.kt_3 aVarM25976b = c3965a.m25976b(str);
            if (aVarM25976b != null) {
                if (m24613a(bitmap, aVarM25976b, z)) {
                    aVarM25976b.m25985a();
                } else {
                    aVarM25976b.m25986b();
                }
                this.f23090b.m25978c();
            }
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00a7 A[Catch: IOException -> 0x00a3, TRY_LEAVE, TryCatch #2 {IOException -> 0x00a3, blocks: (B:56:0x009f, B:60:0x00a7), top: B:64:0x009f }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x009f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: IntrinsicsJvm.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.graphics.Bitmap m24624c(java.lang.String r7) throws java.lang.Throwable {
        /*
            r6 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "getThumbnailBitmapFromCache, title: "
            r0.append(r1)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "ThumbnailCacheUtil"
            com.oplus.camera.CameraLog.m12954a(r1, r0)
            r0 = 0
            libcore.io.PlatformImplementations.kt_3 r2 = r6.f23090b     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L83
            r3 = 0
            if (r2 != 0) goto L27
            java.lang.String r2 = com.oplus.camera.Storage.m11124b()     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L83
            libcore.io.PlatformImplementations.kt_3 r2 = r6.m24611a(r2, r3)     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L83
            r6.f23090b = r2     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L83
            goto L32
        L27:
            java.lang.String r2 = com.oplus.camera.Storage.m11124b()     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L83
            r4 = 1
            libcore.io.PlatformImplementations.kt_3 r2 = r6.m24611a(r2, r4)     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L83
            r6.f23090b = r2     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L83
        L32:
            libcore.io.PlatformImplementations.kt_3 r2 = r6.f23090b     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L83
            if (r2 != 0) goto L3c
            java.lang.String r6 = "getThumbnailBitmapFromCache, mDiskLruCache null"
            com.oplus.camera.CameraLog.m12967f(r1, r6)     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L83
            return r0
        L3c:
            libcore.io.PlatformImplementations.kt_3 r6 = r6.f23090b     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L83
            libcore.io.PlatformImplementations.kt_3$IntrinsicsJvm.kt_3 r6 = r6.m25975a(r7)     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L83
            if (r6 != 0) goto L54
            java.lang.String r7 = "getThumbnailBitmapFromCache, snapShot null"
            com.oplus.camera.CameraLog.m12967f(r1, r7)     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L7b
            if (r6 == 0) goto L53
            r6.close()     // Catch: java.io.IOException -> L4f
            goto L53
        L4f:
            r6 = move-exception
            r6.printStackTrace()
        L53:
            return r0
        L54:
            java.io.InputStream r7 = r6.m26001a(r3)     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L7b
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeStream(r7)     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L72
            if (r7 == 0) goto L64
            r7.close()     // Catch: java.io.IOException -> L62
            goto L64
        L62:
            r6 = move-exception
            goto L6a
        L64:
            if (r6 == 0) goto L6d
            r6.close()     // Catch: java.io.IOException -> L62
            goto L6d
        L6a:
            r6.printStackTrace()
        L6d:
            return r0
        L6e:
            r0 = move-exception
            r1 = r6
            r6 = r0
            goto L9c
        L72:
            r1 = move-exception
            r5 = r1
            r1 = r6
            r6 = r5
            goto L86
        L77:
            r7 = move-exception
            r1 = r6
            r6 = r7
            goto L9d
        L7b:
            r7 = move-exception
            r1 = r6
            r6 = r7
            r7 = r0
            goto L86
        L80:
            r6 = move-exception
            r1 = r0
            goto L9d
        L83:
            r6 = move-exception
            r7 = r0
            r1 = r7
        L86:
            r6.printStackTrace()     // Catch: java.lang.Throwable -> L9b
            if (r7 == 0) goto L91
            r7.close()     // Catch: java.io.IOException -> L8f
            goto L91
        L8f:
            r6 = move-exception
            goto L97
        L91:
            if (r1 == 0) goto L9a
            r1.close()     // Catch: java.io.IOException -> L8f
            goto L9a
        L97:
            r6.printStackTrace()
        L9a:
            return r0
        L9b:
            r6 = move-exception
        L9c:
            r0 = r7
        L9d:
            if (r0 == 0) goto La5
            r0.close()     // Catch: java.io.IOException -> La3
            goto La5
        La3:
            r7 = move-exception
            goto Lab
        La5:
            if (r1 == 0) goto Lae
            r1.close()     // Catch: java.io.IOException -> La3
            goto Lae
        Lab:
            r7.printStackTrace()
        Lae:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.util.ThumbnailCacheUtil.m24624c(java.lang.String):android.graphics.Bitmap");
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m24626d(String str) {
        if (this.f23090b == null) {
            this.f23090b = m24611a(Storage.m11124b(), false);
        } else {
            this.f23090b = m24611a(Storage.m11124b(), true);
        }
        DiskLruCache c3965a = this.f23090b;
        if (c3965a == null) {
            CameraLog.m12967f("ThumbnailCacheUtil", "removeSmallImageForGallery, mDiskLruCache null");
            return;
        }
        try {
            c3965a.m25979c(str);
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m24622b() {
        new Thread(new Runnable() { // from class: com.oplus.camera.util.OplusGLSurfaceView_11.2
            @Override // java.lang.Runnable
            public void run() {
                ThumbnailCacheUtil.this.m24616e();
            }
        }, "clearOldSmallImagesThread").start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m24616e() {
        CameraLog.m12954a("ThumbnailCacheUtil", "clearOldSmallImages");
        if (this.f23090b == null) {
            this.f23090b = m24611a(Storage.m11124b(), false);
        } else {
            this.f23090b = m24611a(Storage.m11124b(), true);
        }
        DiskLruCache c3965a = this.f23090b;
        if (c3965a == null) {
            CameraLog.m12967f("ThumbnailCacheUtil", "clearOldSmallImages, mDiskLruCache null");
            return;
        }
        File fileM25974a = c3965a.m25974a();
        if (fileM25974a == null) {
            CameraLog.m12966e("ThumbnailCacheUtil", "clearOldSmallImages, directory null");
            return;
        }
        File[] fileArrListFiles = fileM25974a.listFiles(this.f23091c);
        if (fileArrListFiles == null) {
            CameraLog.m12967f("ThumbnailCacheUtil", "clearOldSmallImages, files null");
            return;
        }
        for (File file : fileArrListFiles) {
            String name = file.getName();
            long jCurrentTimeMillis = System.currentTimeMillis() - file.lastModified();
            if ((name != null && jCurrentTimeMillis > 300000) || jCurrentTimeMillis < 0) {
                String strSubstring = name.substring(0, name.indexOf("."));
                try {
                    this.f23090b.m25979c(strSubstring);
                } catch (Exception COUIBaseListPopupWindow_8) {
                    COUIBaseListPopupWindow_8.printStackTrace();
                }
                CameraLog.m12954a("ThumbnailCacheUtil", "clearOldSmallImages, title: " + strSubstring + ", timeGap: " + jCurrentTimeMillis);
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m24623b(String str, Bitmap bitmap, boolean z) {
        FileOutputStream fileOutputStream;
        if (bitmap == null) {
            CameraLog.m12967f("ThumbnailCacheUtil", "saveSmallImageForGalleryFile, bitmap is null");
            return;
        }
        File file = new File(Storage.m11124b());
        if (!file.exists()) {
            DocumentUtil.m16210f(Storage.m11124b());
        }
        File[] fileArrListFiles = file.listFiles(this.f23091c);
        if (fileArrListFiles != null && fileArrListFiles.length >= 30) {
            Arrays.sort(fileArrListFiles, this.f23092d);
            for (int OplusGLSurfaceView_13 = 29; OplusGLSurfaceView_13 < fileArrListFiles.length; OplusGLSurfaceView_13++) {
                File file2 = fileArrListFiles[OplusGLSurfaceView_13];
                long jCurrentTimeMillis = System.currentTimeMillis() - file2.lastModified();
                if (!file2.getName().contains("_quick.jpg") || 300000 < jCurrentTimeMillis || 0 > jCurrentTimeMillis) {
                    file2.delete();
                }
            }
        }
        int i2 = z ? 90 : 75;
        String str2 = z ? "_quick.jpg" : "_tmp.jpg";
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_FEATURE_DCIP3_SUPPORT)) {
            CameraLog.m12954a("ThumbnailCacheUtil", "saveSmallImageForGalleryFile, title: " + str + ", ret: " + IccProfile.compressBitmapToFile(bitmap, i2, Storage.m11124b() + File.separator + str + str2));
            return;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                try {
                    fileOutputStream = new FileOutputStream(Storage.m11124b() + File.separator + str + str2);
                } catch (IOException COUIBaseListPopupWindow_8) {
                    COUIBaseListPopupWindow_8 = COUIBaseListPopupWindow_8;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                boolean zCompress = bitmap.compress(Bitmap.CompressFormat.JPEG, i2, fileOutputStream);
                fileOutputStream.flush();
                CameraLog.m12954a("ThumbnailCacheUtil", "saveSmallImageForGalleryFile, title: " + str + ", isCompressed: " + zCompress);
                fileOutputStream.close();
            } catch (IOException e2) {
                COUIBaseListPopupWindow_8 = e2;
                fileOutputStream2 = fileOutputStream;
                COUIBaseListPopupWindow_8.printStackTrace();
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (IOException e4) {
            e4.printStackTrace();
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public Bitmap m24627e(String str) {
        CameraLog.m12954a("ThumbnailCacheUtil", "getThumbnailBitmapFromPrivateCache, title: " + str);
        File file = new File(Storage.m11124b() + File.separator + str + "_tmp.jpg");
        if (file.exists()) {
            return BitmapFactory.decodeFile(file.getAbsolutePath());
        }
        return null;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m24625c() {
        new Thread(new Runnable() { // from class: com.oplus.camera.util.OplusGLSurfaceView_11.3
            @Override // java.lang.Runnable
            public void run() {
                ThumbnailCacheUtil.this.m24617f();
            }
        }, "clearOldSmallImageFilesThread").start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m24617f() {
        CameraLog.m12954a("ThumbnailCacheUtil", "clearOldSmallImageFiles");
        File[] fileArrListFiles = new File(Storage.m11124b()).listFiles(this.f23091c);
        if (fileArrListFiles == null) {
            CameraLog.m12967f("ThumbnailCacheUtil", "clearOldSmallImageFiles, files null");
            return;
        }
        for (File file : fileArrListFiles) {
            long jCurrentTimeMillis = System.currentTimeMillis() - file.lastModified();
            if (jCurrentTimeMillis > 300000 || jCurrentTimeMillis < 0) {
                file.delete();
                CameraLog.m12954a("ThumbnailCacheUtil", "clearOldSmallImageFiles, fileName: " + file.getName() + ", timeGap: " + jCurrentTimeMillis);
            }
        }
    }

    /* compiled from: ThumbnailCacheUtil.java */
    /* renamed from: com.oplus.camera.util.OplusGLSurfaceView_11$PlatformImplementations.kt_3 */
    private static class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        private static final ThumbnailCacheUtil f23098a = new ThumbnailCacheUtil();
    }

    /* compiled from: ThumbnailCacheUtil.java */
    /* renamed from: com.oplus.camera.util.OplusGLSurfaceView_11$IntrinsicsJvm.kt_4 */
    public static class IntrinsicsJvm.kt_4 {

        /* renamed from: PlatformImplementations.kt_3 */
        private long f23099a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private int f23100b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private Bitmap f23101c;

        /* renamed from: PlatformImplementations.kt_3 */
        public int m24632a() {
            return this.f23100b;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m24633a(int OplusGLSurfaceView_13) {
            this.f23100b = OplusGLSurfaceView_13;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public long m24636b() {
            return this.f23099a;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m24634a(long OplusGLSurfaceView_15) {
            this.f23099a = OplusGLSurfaceView_15;
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        public Bitmap m24637c() {
            return this.f23101c;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m24635a(Bitmap bitmap) {
            this.f23101c = bitmap;
        }
    }
}
