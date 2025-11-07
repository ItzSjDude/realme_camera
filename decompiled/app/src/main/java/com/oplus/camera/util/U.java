package com.oplus.camera.util;

/* compiled from: ThumbnailCacheUtil.java */
/* loaded from: classes2.dex */
public class n_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static android.util.LruCache<java.lang.String, com.oplus.camera.util.n_renamed.b_renamed> f7353a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private libcore.io.a_renamed f7354b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private java.io.FileFilter f7355c;
    private java.util.Comparator<java.io.File> d_renamed;

    public void a_renamed(java.lang.String str, com.oplus.camera.util.n_renamed.b_renamed bVar) {
        android.util.LruCache<java.lang.String, com.oplus.camera.util.n_renamed.b_renamed> lruCache = f7353a;
        if (lruCache != null) {
            lruCache.put(str, bVar);
        }
    }

    public void a_renamed(java.lang.String str) {
        android.util.LruCache<java.lang.String, com.oplus.camera.util.n_renamed.b_renamed> lruCache = f7353a;
        if (lruCache != null) {
            lruCache.remove(str);
        }
    }

    public com.oplus.camera.util.n_renamed.b_renamed b_renamed(java.lang.String str) {
        com.oplus.camera.util.n_renamed.b_renamed bVar = f7353a.get(str);
        if (f7353a == null || bVar == null) {
            return null;
        }
        android.graphics.Bitmap bitmapC = bVar.c_renamed();
        synchronized (f7353a) {
            if (bitmapC != null) {
                if (!bitmapC.isRecycled()) {
                    com.oplus.camera.util.n_renamed.b_renamed bVar2 = new com.oplus.camera.util.n_renamed.b_renamed();
                    bVar2.a_renamed(bVar.b_renamed());
                    bVar2.a_renamed(bVar.a_renamed());
                    bVar2.a_renamed(bitmapC.copy(android.graphics.Bitmap.Config.ARGB_8888, true));
                    return bVar2;
                }
            }
            return null;
        }
    }

    private n_renamed() {
        this.f7354b = null;
        this.f7355c = new java.io.FileFilter() { // from class: com.oplus.camera.util.n_renamed.4
            @Override // java.io.FileFilter
            public boolean accept(java.io.File file) {
                java.lang.String name;
                return file.isFile() && (name = file.getName()) != null && name.startsWith("IMG");
            }
        };
        this.d_renamed = new java.util.Comparator<java.io.File>() { // from class: com.oplus.camera.util.n_renamed.5
            @Override // java.util.Comparator
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public int compare(java.io.File file, java.io.File file2) {
                long jLastModified = file.lastModified() - file2.lastModified();
                if (jLastModified > 0) {
                    return -1;
                }
                return 0 == jLastModified ? 0 : 1;
            }
        };
        f7353a = new android.util.LruCache<java.lang.String, com.oplus.camera.util.n_renamed.b_renamed>(com.google.android.exoplayer2.source.ExtractorMediaSource.DEFAULT_LOADING_CHECK_INTERVAL_BYTES) { // from class: com.oplus.camera.util.n_renamed.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.util.LruCache
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public int sizeOf(java.lang.String str, com.oplus.camera.util.n_renamed.b_renamed bVar) {
                return bVar.c_renamed().getByteCount();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.util.LruCache
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public void entryRemoved(boolean z_renamed, java.lang.String str, com.oplus.camera.util.n_renamed.b_renamed bVar, com.oplus.camera.util.n_renamed.b_renamed bVar2) {
                com.oplus.camera.e_renamed.b_renamed("ThumbnailCacheUtil", "entryRemoved, remove the bitmap's_renamed key: " + str);
                synchronized (com.oplus.camera.util.n_renamed.f7353a) {
                    if (bVar != null) {
                        if (bVar.c_renamed() != null) {
                            bVar.c_renamed().recycle();
                        }
                        bVar = null;
                        super.entryRemoved(z_renamed, str, bVar, bVar2);
                    } else {
                        super.entryRemoved(z_renamed, str, bVar, bVar2);
                    }
                }
            }
        };
    }

    public static com.oplus.camera.util.n_renamed a_renamed() {
        return com.oplus.camera.util.n_renamed.a_renamed.f7361a;
    }

    private libcore.io.a_renamed a_renamed(java.lang.String str, boolean z_renamed) {
        libcore.io.a_renamed aVar;
        java.io.File file = new java.io.File(str);
        if (!z_renamed || !file.exists() || ((aVar = this.f7354b) != null && aVar.b_renamed())) {
            libcore.io.a_renamed aVar2 = this.f7354b;
            if (aVar2 != null) {
                try {
                    aVar2.close();
                } catch (java.lang.Exception e_renamed) {
                    e_renamed.printStackTrace();
                }
            }
            if (!file.exists()) {
                file.mkdirs();
            }
            try {
                return libcore.io.a_renamed.a_renamed(file, 1, 1, 52428800L);
            } catch (java.lang.Exception e2) {
                e2.printStackTrace();
            }
        }
        return this.f7354b;
    }

    private boolean a_renamed(android.graphics.Bitmap bitmap, libcore.io.a_renamed.DiskLruCache_3 c0153a, boolean z_renamed) throws java.io.IOException {
        com.oplus.camera.e_renamed.a_renamed("ThumbnailCacheUtil", "saveBitmapToDiskLruCache");
        if (bitmap == null) {
            com.oplus.camera.e_renamed.f_renamed("ThumbnailCacheUtil", "saveBitmapToDiskLruCache, bitmap: " + bitmap);
            return false;
        }
        java.io.OutputStream outputStreamA = null;
        int i_renamed = z_renamed ? 90 : 75;
        try {
            try {
                outputStreamA = c0153a.a_renamed(0);
                boolean zCompress = bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, i_renamed, outputStreamA);
                if (!zCompress) {
                    com.oplus.camera.e_renamed.f_renamed("ThumbnailCacheUtil", "saveBitmapToDiskLruCache, bitmap compress fail, byte count: " + bitmap.getByteCount() + ", isRecycled: " + bitmap.isRecycled() + ", width: " + bitmap.getWidth() + ", height: " + bitmap.getHeight());
                }
                outputStreamA.flush();
                if (outputStreamA != null) {
                    try {
                        outputStreamA.close();
                    } catch (java.io.IOException e_renamed) {
                        e_renamed.printStackTrace();
                    }
                }
                com.oplus.camera.e_renamed.a_renamed("ThumbnailCacheUtil", "saveBitmapToDiskLruCache X_renamed");
                return zCompress;
            } catch (java.lang.Exception e2) {
                e2.printStackTrace();
                if (outputStreamA != null) {
                    try {
                        outputStreamA.close();
                    } catch (java.io.IOException e3) {
                        e3.printStackTrace();
                    }
                }
                com.oplus.camera.e_renamed.a_renamed("ThumbnailCacheUtil", "saveBitmapToDiskLruCache X_renamed");
                return false;
            }
        } catch (java.lang.Throwable th) {
            if (outputStreamA != null) {
                try {
                    outputStreamA.close();
                } catch (java.io.IOException e4) {
                    e4.printStackTrace();
                }
            }
            com.oplus.camera.e_renamed.a_renamed("ThumbnailCacheUtil", "saveBitmapToDiskLruCache X_renamed");
            throw th;
        }
    }

    public void a_renamed(java.lang.String str, android.graphics.Bitmap bitmap, boolean z_renamed) {
        if (this.f7354b == null) {
            this.f7354b = a_renamed(com.oplus.camera.Storage.b_renamed(), false);
        } else {
            this.f7354b = a_renamed(com.oplus.camera.Storage.b_renamed(), true);
        }
        libcore.io.a_renamed aVar = this.f7354b;
        if (aVar == null) {
            com.oplus.camera.e_renamed.f_renamed("ThumbnailCacheUtil", "saveSmallImageForGallery, mDiskLruCache null");
            return;
        }
        try {
            libcore.io.a_renamed.DiskLruCache_3 c0153aB = aVar.b_renamed(str);
            if (c0153aB != null) {
                if (a_renamed(bitmap, c0153aB, z_renamed)) {
                    c0153aB.a_renamed();
                } else {
                    c0153aB.b_renamed();
                }
                this.f7354b.c_renamed();
            }
        } catch (java.lang.Exception e_renamed) {
            e_renamed.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:60:0x00a7 A_renamed[Catch: IOException -> 0x00a3, TRY_LEAVE, TryCatch #2 {IOException -> 0x00a3, blocks: (B_renamed:56:0x009f, B_renamed:60:0x00a7), top: B_renamed:64:0x009f }] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:64:0x009f A_renamed[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.graphics.Bitmap c_renamed(java.lang.String r7) throws java.lang.Throwable {
        /*
            r6 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "getThumbnailBitmapFromCache, title: "
            r0.append(r1)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "ThumbnailCacheUtil"
            com.oplus.camera.e_renamed.a_renamed(r1, r0)
            r0 = 0
            libcore.io.a_renamed r2 = r6.f7354b     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L83
            r3 = 0
            if (r2 != 0) goto L27
            java.lang.String r2 = com.oplus.camera.Storage.b_renamed()     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L83
            libcore.io.a_renamed r2 = r6.a_renamed(r2, r3)     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L83
            r6.f7354b = r2     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L83
            goto L32
        L27:
            java.lang.String r2 = com.oplus.camera.Storage.b_renamed()     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L83
            r4 = 1
            libcore.io.a_renamed r2 = r6.a_renamed(r2, r4)     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L83
            r6.f7354b = r2     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L83
        L32:
            libcore.io.a_renamed r2 = r6.f7354b     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L83
            if (r2 != 0) goto L3c
            java.lang.String r6 = "getThumbnailBitmapFromCache, mDiskLruCache null"
            com.oplus.camera.e_renamed.f_renamed(r1, r6)     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L83
            return r0
        L3c:
            libcore.io.a_renamed r6 = r6.f7354b     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L83
            libcore.io.a_renamed$c_renamed r6 = r6.a_renamed(r7)     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L83
            if (r6 != 0) goto L54
            java.lang.String r7 = "getThumbnailBitmapFromCache, snapShot null"
            com.oplus.camera.e_renamed.f_renamed(r1, r7)     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L7b
            if (r6 == 0) goto L53
            r6.close()     // Catch: java.io.IOException -> L4f
            goto L53
        L4f:
            r6 = move-exception
            r6.printStackTrace()
        L53:
            return r0
        L54:
            java.io.InputStream r7 = r6.a_renamed(r3)     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L7b
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
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.util.n_renamed.c_renamed(java.lang.String):android.graphics.Bitmap");
    }

    public void d_renamed(java.lang.String str) {
        if (this.f7354b == null) {
            this.f7354b = a_renamed(com.oplus.camera.Storage.b_renamed(), false);
        } else {
            this.f7354b = a_renamed(com.oplus.camera.Storage.b_renamed(), true);
        }
        libcore.io.a_renamed aVar = this.f7354b;
        if (aVar == null) {
            com.oplus.camera.e_renamed.f_renamed("ThumbnailCacheUtil", "removeSmallImageForGallery, mDiskLruCache null");
            return;
        }
        try {
            aVar.c_renamed(str);
        } catch (java.lang.Exception e_renamed) {
            e_renamed.printStackTrace();
        }
    }

    public void b_renamed() {
        new java.lang.Thread(new java.lang.Runnable() { // from class: com.oplus.camera.util.n_renamed.2
            @Override // java.lang.Runnable
            public void run() {
                com.oplus.camera.util.n_renamed.this.e_renamed();
            }
        }, "clearOldSmallImagesThread").start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e_renamed() {
        com.oplus.camera.e_renamed.a_renamed("ThumbnailCacheUtil", "clearOldSmallImages");
        if (this.f7354b == null) {
            this.f7354b = a_renamed(com.oplus.camera.Storage.b_renamed(), false);
        } else {
            this.f7354b = a_renamed(com.oplus.camera.Storage.b_renamed(), true);
        }
        libcore.io.a_renamed aVar = this.f7354b;
        if (aVar == null) {
            com.oplus.camera.e_renamed.f_renamed("ThumbnailCacheUtil", "clearOldSmallImages, mDiskLruCache null");
            return;
        }
        java.io.File fileA = aVar.a_renamed();
        if (fileA == null) {
            com.oplus.camera.e_renamed.e_renamed("ThumbnailCacheUtil", "clearOldSmallImages, directory null");
            return;
        }
        java.io.File[] fileArrListFiles = fileA.listFiles(this.f7355c);
        if (fileArrListFiles == null) {
            com.oplus.camera.e_renamed.f_renamed("ThumbnailCacheUtil", "clearOldSmallImages, files null");
            return;
        }
        for (java.io.File file : fileArrListFiles) {
            java.lang.String name = file.getName();
            long jCurrentTimeMillis = java.lang.System.currentTimeMillis() - file.lastModified();
            if ((name != null && jCurrentTimeMillis > 300000) || jCurrentTimeMillis < 0) {
                java.lang.String strSubstring = name.substring(0, name.indexOf("."));
                try {
                    this.f7354b.c_renamed(strSubstring);
                } catch (java.lang.Exception e_renamed) {
                    e_renamed.printStackTrace();
                }
                com.oplus.camera.e_renamed.a_renamed("ThumbnailCacheUtil", "clearOldSmallImages, title: " + strSubstring + ", timeGap: " + jCurrentTimeMillis);
            }
        }
    }

    public void b_renamed(java.lang.String str, android.graphics.Bitmap bitmap, boolean z_renamed) {
        java.io.FileOutputStream fileOutputStream;
        if (bitmap == null) {
            com.oplus.camera.e_renamed.f_renamed("ThumbnailCacheUtil", "saveSmallImageForGalleryFile, bitmap is_renamed null");
            return;
        }
        java.io.File file = new java.io.File(com.oplus.camera.Storage.b_renamed());
        if (!file.exists()) {
            com.oplus.camera.q_renamed.a_renamed.f_renamed(com.oplus.camera.Storage.b_renamed());
        }
        java.io.File[] fileArrListFiles = file.listFiles(this.f7355c);
        if (fileArrListFiles != null && fileArrListFiles.length >= 30) {
            java.util.Arrays.sort(fileArrListFiles, this.d_renamed);
            for (int i_renamed = 29; i_renamed < fileArrListFiles.length; i_renamed++) {
                java.io.File file2 = fileArrListFiles[i_renamed];
                long jCurrentTimeMillis = java.lang.System.currentTimeMillis() - file2.lastModified();
                if (!file2.getName().contains("_quick.jpg") || 300000 < jCurrentTimeMillis || 0 > jCurrentTimeMillis) {
                    file2.delete();
                }
            }
        }
        int i2 = z_renamed ? 90 : 75;
        java.lang.String str2 = z_renamed ? "_quick.jpg" : "_tmp.jpg";
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_FEATURE_DCIP3_SUPPORT)) {
            com.oplus.camera.e_renamed.a_renamed("ThumbnailCacheUtil", "saveSmallImageForGalleryFile, title: " + str + ", ret: " + com.oplus.camera.jni.IccProfile.compressBitmapToFile(bitmap, i2, com.oplus.camera.Storage.b_renamed() + java.io.File.separator + str + str2));
            return;
        }
        java.io.FileOutputStream fileOutputStream2 = null;
        try {
            try {
                try {
                    fileOutputStream = new java.io.FileOutputStream(com.oplus.camera.Storage.b_renamed() + java.io.File.separator + str + str2);
                } catch (java.io.IOException e_renamed) {
                    e_renamed = e_renamed;
                }
            } catch (java.lang.Throwable th) {
                th = th;
            }
            try {
                boolean zCompress = bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, i2, fileOutputStream);
                fileOutputStream.flush();
                com.oplus.camera.e_renamed.a_renamed("ThumbnailCacheUtil", "saveSmallImageForGalleryFile, title: " + str + ", isCompressed: " + zCompress);
                fileOutputStream.close();
            } catch (java.io.IOException e2) {
                e_renamed = e2;
                fileOutputStream2 = fileOutputStream;
                e_renamed.printStackTrace();
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (java.io.IOException e3) {
                        e3.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (java.io.IOException e4) {
            e4.printStackTrace();
        }
    }

    public android.graphics.Bitmap e_renamed(java.lang.String str) {
        com.oplus.camera.e_renamed.a_renamed("ThumbnailCacheUtil", "getThumbnailBitmapFromPrivateCache, title: " + str);
        java.io.File file = new java.io.File(com.oplus.camera.Storage.b_renamed() + java.io.File.separator + str + "_tmp.jpg");
        if (file.exists()) {
            return android.graphics.BitmapFactory.decodeFile(file.getAbsolutePath());
        }
        return null;
    }

    public void c_renamed() {
        new java.lang.Thread(new java.lang.Runnable() { // from class: com.oplus.camera.util.n_renamed.3
            @Override // java.lang.Runnable
            public void run() {
                com.oplus.camera.util.n_renamed.this.f_renamed();
            }
        }, "clearOldSmallImageFilesThread").start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f_renamed() {
        com.oplus.camera.e_renamed.a_renamed("ThumbnailCacheUtil", "clearOldSmallImageFiles");
        java.io.File[] fileArrListFiles = new java.io.File(com.oplus.camera.Storage.b_renamed()).listFiles(this.f7355c);
        if (fileArrListFiles == null) {
            com.oplus.camera.e_renamed.f_renamed("ThumbnailCacheUtil", "clearOldSmallImageFiles, files null");
            return;
        }
        for (java.io.File file : fileArrListFiles) {
            long jCurrentTimeMillis = java.lang.System.currentTimeMillis() - file.lastModified();
            if (jCurrentTimeMillis > 300000 || jCurrentTimeMillis < 0) {
                file.delete();
                com.oplus.camera.e_renamed.a_renamed("ThumbnailCacheUtil", "clearOldSmallImageFiles, fileName: " + file.getName() + ", timeGap: " + jCurrentTimeMillis);
            }
        }
    }

    /* compiled from: ThumbnailCacheUtil.java */
    private static class a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        private static final com.oplus.camera.util.n_renamed f7361a = new com.oplus.camera.util.n_renamed();
    }

    /* compiled from: ThumbnailCacheUtil.java */
    public static class b_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        private long f7362a;

        /* renamed from: b_renamed, reason: collision with root package name */
        private int f7363b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private android.graphics.Bitmap f7364c;

        public int a_renamed() {
            return this.f7363b;
        }

        public void a_renamed(int i_renamed) {
            this.f7363b = i_renamed;
        }

        public long b_renamed() {
            return this.f7362a;
        }

        public void a_renamed(long j_renamed) {
            this.f7362a = j_renamed;
        }

        public android.graphics.Bitmap c_renamed() {
            return this.f7364c;
        }

        public void a_renamed(android.graphics.Bitmap bitmap) {
            this.f7364c = bitmap;
        }
    }
}
