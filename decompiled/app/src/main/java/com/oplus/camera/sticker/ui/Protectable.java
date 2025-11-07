package com.oplus.camera.sticker.ui;

/* compiled from: ImageDownloader.java */
/* loaded from: classes2.dex */
public class c_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.ref.SoftReference<android.graphics.drawable.Drawable>> f5508a = new java.util.concurrent.ConcurrentHashMap<>(10);

    /* renamed from: b_renamed, reason: collision with root package name */
    private static java.util.Map<java.lang.String, com.oplus.camera.sticker.ui.c_renamed.ImageDownloader_2> f5509b = new java.util.concurrent.ConcurrentHashMap();

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.content.Context f5510c;
    private android.graphics.drawable.BitmapDrawable d_renamed;
    private int e_renamed;
    private int f_renamed;
    private int g_renamed;
    private int h_renamed;
    private java.util.HashMap<java.lang.String, android.graphics.drawable.Drawable> i_renamed;

    public c_renamed(android.content.Context context, int i_renamed) {
        this.d_renamed = null;
        this.e_renamed = 0;
        this.f_renamed = 0;
        this.g_renamed = 0;
        this.h_renamed = 0;
        this.f5510c = context.getApplicationContext();
        try {
            this.d_renamed = (android.graphics.drawable.BitmapDrawable) context.getResources().getDrawable(i_renamed);
        } catch (java.lang.OutOfMemoryError unused) {
            java.lang.System.gc_renamed();
        }
        a_renamed(10);
        this.h_renamed = this.f5510c.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.sticker_gridview_image_width);
        this.f_renamed = this.f5510c.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.sticker_gridview_redpoint_margin_top);
        this.g_renamed = this.f5510c.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.sticker_gridview_redpoint_radius);
        this.e_renamed = this.f5510c.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.sticker_gridview_thumbnail_display_size);
    }

    private void a_renamed(final int i_renamed) {
        this.i_renamed = new java.util.LinkedHashMap<java.lang.String, android.graphics.drawable.Drawable>(i_renamed, 0.75f, false) { // from class: com.oplus.camera.sticker.ui.c_renamed.1
            @Override // java.util.LinkedHashMap
            protected boolean removeEldestEntry(java.util.Map.Entry<java.lang.String, android.graphics.drawable.Drawable> entry) {
                if (size() <= i_renamed) {
                    return false;
                }
                com.oplus.camera.sticker.ui.c_renamed.f5508a.put(entry.getKey(), new java.lang.ref.SoftReference(entry.getValue()));
                return true;
            }
        };
    }

    public void a_renamed(java.lang.String str, java.lang.String str2, com.oplus.camera.sticker.ui.d_renamed dVar) throws android.content.res.Resources.NotFoundException {
        android.graphics.drawable.BitmapDrawable bitmapDrawable;
        if (str == null && (bitmapDrawable = this.d_renamed) != null) {
            a_renamed(dVar, bitmapDrawable);
            return;
        }
        android.graphics.drawable.Drawable drawableB = b_renamed(str);
        if (drawableB == null) {
            b_renamed(str, str2, dVar);
        } else {
            a_renamed(str);
            a_renamed(dVar, drawableB);
        }
    }

    private void b_renamed(java.lang.String str, java.lang.String str2, com.oplus.camera.sticker.ui.d_renamed dVar) throws android.content.res.Resources.NotFoundException {
        boolean z_renamed;
        com.oplus.camera.sticker.ui.c_renamed.ImageDownloader_2 asyncTaskC0118c;
        if (str == null) {
            return;
        }
        java.lang.String strA = a_renamed(dVar);
        if (strA != null && !strA.equals(str) && (asyncTaskC0118c = f5509b.get(strA)) != null) {
            asyncTaskC0118c.b_renamed(dVar);
        }
        com.oplus.camera.sticker.ui.c_renamed.ImageDownloader_2 asyncTaskC0118c2 = f5509b.get(str);
        if (asyncTaskC0118c2 == null || asyncTaskC0118c2.isCancelled()) {
            com.oplus.camera.sticker.ui.c_renamed.ImageDownloader_2 asyncTaskC0118cB = b_renamed(dVar);
            if (asyncTaskC0118cB != null) {
                asyncTaskC0118cB.cancel(true);
            }
            asyncTaskC0118c2 = new com.oplus.camera.sticker.ui.c_renamed.ImageDownloader_2();
            f5509b.put(str, asyncTaskC0118c2);
            z_renamed = true;
        } else {
            z_renamed = false;
        }
        asyncTaskC0118c2.a_renamed(dVar);
        if (z_renamed) {
            if (this.d_renamed != null) {
                a_renamed(dVar, new com.oplus.camera.sticker.ui.c_renamed.b_renamed(this.f5510c.getResources(), this.d_renamed, str, asyncTaskC0118c2));
            } else {
                a_renamed(dVar, new com.oplus.camera.sticker.ui.c_renamed.a_renamed(str, asyncTaskC0118c2));
            }
            asyncTaskC0118c2.execute(str, str2);
        }
    }

    private static boolean a_renamed(java.lang.String str) {
        com.oplus.camera.sticker.ui.c_renamed.ImageDownloader_2 asyncTaskC0118c;
        if (str != null && (asyncTaskC0118c = f5509b.get(str)) != null) {
            asyncTaskC0118c.cancel(true);
        }
        return true;
    }

    private java.lang.String a_renamed(com.oplus.camera.sticker.ui.d_renamed dVar) {
        if (dVar == null) {
            return null;
        }
        android.graphics.drawable.Drawable drawableB = dVar.b_renamed();
        if (drawableB instanceof com.oplus.camera.sticker.ui.c_renamed.a_renamed) {
            return ((com.oplus.camera.sticker.ui.c_renamed.a_renamed) drawableB).a_renamed();
        }
        if (drawableB instanceof com.oplus.camera.sticker.ui.c_renamed.b_renamed) {
            return ((com.oplus.camera.sticker.ui.c_renamed.b_renamed) drawableB).a_renamed();
        }
        return null;
    }

    private com.oplus.camera.sticker.ui.c_renamed.ImageDownloader_2 b_renamed(com.oplus.camera.sticker.ui.d_renamed dVar) {
        if (dVar == null) {
            return null;
        }
        android.graphics.drawable.Drawable drawableB = dVar.b_renamed();
        if (drawableB instanceof com.oplus.camera.sticker.ui.c_renamed.a_renamed) {
            return ((com.oplus.camera.sticker.ui.c_renamed.a_renamed) drawableB).b_renamed();
        }
        if (drawableB instanceof com.oplus.camera.sticker.ui.c_renamed.b_renamed) {
            return ((com.oplus.camera.sticker.ui.c_renamed.b_renamed) drawableB).b_renamed();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public android.graphics.drawable.Drawable a_renamed(java.lang.String str, java.lang.String str2) throws java.lang.Throwable {
        android.graphics.drawable.Drawable drawableA;
        if ("parse_url".equals(str2)) {
            drawableA = a_renamed(this.f5510c, android.net.Uri.parse(str));
        } else {
            drawableA = "parse_file".equals(str2) ? a_renamed(this.f5510c, str) : null;
        }
        com.oplus.camera.e_renamed.a_renamed("ImageDownloader", "downloadDrawable, drawable: " + drawableA);
        return drawableA;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B_renamed:39:0x0056 A_renamed[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r5v0, types: [android.net.Uri] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.io.InputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private android.graphics.drawable.Drawable a_renamed(android.content.Context r4, android.net.Uri r5) throws java.lang.Throwable {
        /*
            r3 = this;
            android.content.ContentResolver r0 = r4.getContentResolver()
            r1 = 0
            java.io.InputStream r5 = r0.openInputStream(r5)     // Catch: java.lang.Throwable -> L34 java.io.FileNotFoundException -> L37
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeStream(r5)     // Catch: java.lang.Throwable -> L30 java.io.FileNotFoundException -> L32
            if (r0 == 0) goto L2a
            android.graphics.drawable.BitmapDrawable r2 = new android.graphics.drawable.BitmapDrawable     // Catch: java.lang.Throwable -> L30 java.io.FileNotFoundException -> L32
            android.content.res.Resources r4 = r4.getResources()     // Catch: java.lang.Throwable -> L30 java.io.FileNotFoundException -> L32
            r2.<init>(r4, r0)     // Catch: java.lang.Throwable -> L30 java.io.FileNotFoundException -> L32
            int r4 = r0.getDensity()     // Catch: java.lang.Throwable -> L30 java.io.FileNotFoundException -> L32
            r2.setTargetDensity(r4)     // Catch: java.lang.Throwable -> L30 java.io.FileNotFoundException -> L32
            if (r5 == 0) goto L29
            r5.close()     // Catch: java.io.IOException -> L25
            goto L29
        L25:
            r3 = move-exception
            r3.printStackTrace()
        L29:
            return r2
        L2a:
            if (r5 == 0) goto L46
            r5.close()     // Catch: java.io.IOException -> L42
            goto L46
        L30:
            r3 = move-exception
            goto L54
        L32:
            r4 = move-exception
            goto L39
        L34:
            r3 = move-exception
            r5 = r1
            goto L54
        L37:
            r4 = move-exception
            r5 = r1
        L39:
            r4.printStackTrace()     // Catch: java.lang.Throwable -> L30
            if (r5 == 0) goto L46
            r5.close()     // Catch: java.io.IOException -> L42
            goto L46
        L42:
            r4 = move-exception
            r4.printStackTrace()
        L46:
            android.content.Context r3 = r3.f5510c
            android.content.res.Resources r3 = r3.getResources()
            r4 = 2131232270(0x7f08060e, float:1.8080645E38)
            android.graphics.drawable.Drawable r3 = r3.getDrawable(r4, r1)
            return r3
        L54:
            if (r5 == 0) goto L5e
            r5.close()     // Catch: java.io.IOException -> L5a
            goto L5e
        L5a:
            r4 = move-exception
            r4.printStackTrace()
        L5e:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.sticker.ui.c_renamed.a_renamed(android.content.Context, android.net.Uri):android.graphics.drawable.Drawable");
    }

    private android.graphics.drawable.Drawable a_renamed(android.content.Context context, java.lang.String str) throws java.lang.Throwable {
        java.io.FileInputStream fileInputStream;
        android.graphics.Bitmap bitmapDecodeStream;
        java.io.File file = new java.io.File(str);
        java.io.FileInputStream fileInputStream2 = null;
        try {
        } catch (java.lang.Throwable th) {
            th = th;
        }
        try {
            try {
                fileInputStream = file.exists() ? new java.io.FileInputStream(file) : null;
            } catch (java.io.IOException e_renamed) {
                e_renamed.printStackTrace();
            }
            try {
                bitmapDecodeStream = android.graphics.BitmapFactory.decodeStream(fileInputStream);
            } catch (java.io.FileNotFoundException e2) {
                e_renamed = e2;
                e_renamed.printStackTrace();
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                return this.f5510c.getResources().getDrawable(com.oplus.camera.R_renamed.drawable.sticker_undownload, null);
            }
        } catch (java.io.FileNotFoundException e3) {
            e_renamed = e3;
            fileInputStream = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            if (0 != 0) {
                try {
                    fileInputStream2.close();
                } catch (java.io.IOException e4) {
                    e4.printStackTrace();
                }
            }
            throw th;
        }
        if (bitmapDecodeStream == null) {
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            return this.f5510c.getResources().getDrawable(com.oplus.camera.R_renamed.drawable.sticker_undownload, null);
        }
        android.graphics.drawable.BitmapDrawable bitmapDrawable = new android.graphics.drawable.BitmapDrawable(context.getResources(), bitmapDecodeStream);
        bitmapDrawable.setTargetDensity(bitmapDecodeStream.getDensity());
        if (fileInputStream != null) {
            try {
                fileInputStream.close();
            } catch (java.io.IOException e5) {
                e5.printStackTrace();
            }
        }
        return bitmapDrawable;
    }

    /* compiled from: ImageDownloader.java */
    /* renamed from: com.oplus.camera.sticker.ui.c_renamed$c_renamed, reason: collision with other inner class name */
    class ImageDownloader_2 extends android.os.AsyncTask<java.lang.String, java.lang.Void, android.graphics.drawable.Drawable> {

        /* renamed from: a_renamed, reason: collision with root package name */
        public java.lang.String f5515a;

        /* renamed from: c_renamed, reason: collision with root package name */
        private final java.util.List<com.oplus.camera.sticker.ui.d_renamed> f5517c = new java.util.ArrayList();
        private java.lang.String d_renamed;

        ImageDownloader_2() {
        }

        public void a_renamed(com.oplus.camera.sticker.ui.d_renamed dVar) {
            if (dVar == null || a_renamed(dVar, false)) {
                return;
            }
            this.f5517c.add(dVar);
        }

        private boolean a_renamed(com.oplus.camera.sticker.ui.d_renamed dVar, boolean z_renamed) {
            int size = this.f5517c.size();
            for (int i_renamed = 0; i_renamed < size; i_renamed++) {
                if (this.f5517c.get(i_renamed) == dVar) {
                    if (!z_renamed) {
                        return true;
                    }
                    this.f5517c.remove(i_renamed);
                    return true;
                }
            }
            return false;
        }

        public void b_renamed(com.oplus.camera.sticker.ui.d_renamed dVar) {
            a_renamed(dVar, true);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public android.graphics.drawable.Drawable doInBackground(java.lang.String... strArr) throws java.lang.SecurityException, java.lang.IllegalArgumentException {
            android.os.Process.setThreadPriority(10);
            this.f5515a = strArr[0];
            this.d_renamed = strArr[1];
            if (isCancelled()) {
                return null;
            }
            return com.oplus.camera.sticker.ui.c_renamed.this.a_renamed(this.f5515a, this.d_renamed);
        }

        @Override // android.os.AsyncTask
        protected void onCancelled() {
            super.onCancelled();
            if (com.oplus.camera.sticker.ui.c_renamed.f5509b == null || this.f5515a == null) {
                return;
            }
            com.oplus.camera.sticker.ui.c_renamed.f5509b.remove(this.f5515a);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public void onCancelled(android.graphics.drawable.Drawable drawable) {
            super.onCancelled(drawable);
            if (com.oplus.camera.sticker.ui.c_renamed.f5509b == null || this.f5515a == null) {
                return;
            }
            com.oplus.camera.sticker.ui.c_renamed.f5509b.remove(this.f5515a);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b_renamed, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(android.graphics.drawable.Drawable drawable) throws android.content.res.Resources.NotFoundException {
            com.oplus.camera.e_renamed.a_renamed("ImageDownloader", "onPostExecute, isCancelled: " + isCancelled() + ", bitmap: " + drawable);
            com.oplus.camera.sticker.ui.c_renamed.f5509b.remove(this.f5515a);
            if (isCancelled()) {
                drawable = null;
            }
            if (drawable != null) {
                com.oplus.camera.sticker.ui.c_renamed.this.a_renamed(this.f5515a, drawable);
                c_renamed(drawable);
            } else {
                a_renamed();
            }
        }

        private void c_renamed(android.graphics.drawable.Drawable drawable) throws android.content.res.Resources.NotFoundException {
            int size = this.f5517c.size();
            for (int i_renamed = 0; i_renamed < size; i_renamed++) {
                com.oplus.camera.sticker.ui.d_renamed dVar = this.f5517c.get(i_renamed);
                if (dVar != null) {
                    com.oplus.camera.sticker.ui.c_renamed.this.a_renamed(dVar, drawable);
                }
            }
            this.f5517c.clear();
        }

        private void a_renamed() throws android.content.res.Resources.NotFoundException {
            int size = this.f5517c.size();
            for (int i_renamed = 0; i_renamed < size; i_renamed++) {
                com.oplus.camera.sticker.ui.d_renamed dVar = this.f5517c.get(i_renamed);
                if (dVar != null && com.oplus.camera.sticker.ui.c_renamed.this.d_renamed != null) {
                    com.oplus.camera.sticker.ui.c_renamed cVar = com.oplus.camera.sticker.ui.c_renamed.this;
                    cVar.a_renamed(dVar, cVar.d_renamed);
                }
            }
            this.f5517c.clear();
        }
    }

    /* compiled from: ImageDownloader.java */
    private static class a_renamed extends android.graphics.drawable.ColorDrawable {

        /* renamed from: a_renamed, reason: collision with root package name */
        private final java.lang.ref.WeakReference<java.lang.String> f5511a;

        /* renamed from: b_renamed, reason: collision with root package name */
        private final java.lang.ref.WeakReference<com.oplus.camera.sticker.ui.c_renamed.ImageDownloader_2> f5512b;

        public a_renamed(java.lang.String str, com.oplus.camera.sticker.ui.c_renamed.ImageDownloader_2 asyncTaskC0118c) {
            super(-1);
            this.f5511a = new java.lang.ref.WeakReference<>(str);
            this.f5512b = new java.lang.ref.WeakReference<>(asyncTaskC0118c);
        }

        public java.lang.String a_renamed() {
            return this.f5511a.get();
        }

        public com.oplus.camera.sticker.ui.c_renamed.ImageDownloader_2 b_renamed() {
            return this.f5512b.get();
        }
    }

    /* compiled from: ImageDownloader.java */
    private static class b_renamed extends android.graphics.drawable.BitmapDrawable {

        /* renamed from: a_renamed, reason: collision with root package name */
        private final java.lang.ref.WeakReference<java.lang.String> f5513a;

        /* renamed from: b_renamed, reason: collision with root package name */
        private final java.lang.ref.WeakReference<com.oplus.camera.sticker.ui.c_renamed.ImageDownloader_2> f5514b;

        public b_renamed(android.content.res.Resources resources, android.graphics.drawable.BitmapDrawable bitmapDrawable, java.lang.String str, com.oplus.camera.sticker.ui.c_renamed.ImageDownloader_2 asyncTaskC0118c) {
            super(resources, bitmapDrawable.getBitmap());
            this.f5513a = new java.lang.ref.WeakReference<>(str);
            this.f5514b = new java.lang.ref.WeakReference<>(asyncTaskC0118c);
        }

        public java.lang.String a_renamed() {
            return this.f5513a.get();
        }

        public com.oplus.camera.sticker.ui.c_renamed.ImageDownloader_2 b_renamed() {
            return this.f5514b.get();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(java.lang.String str, android.graphics.drawable.Drawable drawable) {
        if (drawable != null) {
            java.util.HashMap<java.lang.String, android.graphics.drawable.Drawable> map = this.i_renamed;
            if (map != null) {
                synchronized (map) {
                    this.i_renamed.put(str, drawable);
                }
            }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.ref.SoftReference<android.graphics.drawable.Drawable>> concurrentHashMap = f5508a;
            if (concurrentHashMap != null) {
                concurrentHashMap.put(str, new java.lang.ref.SoftReference<>(drawable));
            }
        }
    }

    private android.graphics.drawable.Drawable b_renamed(java.lang.String str) {
        java.lang.ref.SoftReference<android.graphics.drawable.Drawable> softReference;
        if (str == null) {
            return null;
        }
        java.util.HashMap<java.lang.String, android.graphics.drawable.Drawable> map = this.i_renamed;
        if (map != null) {
            synchronized (map) {
                android.graphics.drawable.Drawable drawable = this.i_renamed.get(str);
                if (drawable != null) {
                    this.i_renamed.remove(str);
                    this.i_renamed.put(str, drawable);
                    return drawable;
                }
            }
        }
        java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.ref.SoftReference<android.graphics.drawable.Drawable>> concurrentHashMap = f5508a;
        if (concurrentHashMap != null && (softReference = concurrentHashMap.get(str)) != null) {
            android.graphics.drawable.Drawable drawable2 = softReference.get();
            if (drawable2 != null) {
                return drawable2;
            }
            f5508a.remove(str);
        }
        return null;
    }

    public void a_renamed() {
        java.util.HashMap<java.lang.String, android.graphics.drawable.Drawable> map = this.i_renamed;
        if (map != null) {
            map.clear();
        }
        this.d_renamed = null;
    }

    public static void b_renamed() {
        java.util.Map<java.lang.String, com.oplus.camera.sticker.ui.c_renamed.ImageDownloader_2> map = f5509b;
        if (map != null) {
            map.clear();
        }
        java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.ref.SoftReference<android.graphics.drawable.Drawable>> concurrentHashMap = f5508a;
        if (concurrentHashMap != null) {
            concurrentHashMap.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(com.oplus.camera.sticker.ui.d_renamed dVar, android.graphics.drawable.Drawable drawable) throws android.content.res.Resources.NotFoundException {
        if (dVar == null || drawable == null) {
            com.oplus.camera.e_renamed.a_renamed("ImageDownloader", "setImageDrawable, imageTagInfo: " + dVar + ", drawable: " + drawable);
            return;
        }
        a_renamed(dVar.a_renamed(), a_renamed(dVar.a_renamed(), drawable, dVar.f_renamed(), dVar.d_renamed(), dVar.e_renamed()), dVar.c_renamed());
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:16:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private android.graphics.drawable.Drawable a_renamed(com.oplus.camera.sticker.ui.b_renamed r3, android.graphics.drawable.Drawable r4, int r5, boolean r6, boolean r7) throws android.content.res.Resources.NotFoundException {
        /*
            r2 = this;
            if (r7 == 0) goto L6
            android.graphics.drawable.Drawable r4 = r2.a_renamed(r4)
        L6:
            r7 = 8
            r0 = 1
            if (r5 == 0) goto L29
            if (r5 == r0) goto L24
            r1 = 2
            if (r5 == r1) goto L24
            r1 = 4
            if (r5 == r1) goto L1f
            if (r5 == r7) goto L1a
            r1 = 16
            if (r5 == r1) goto L1f
            goto L2d
        L1a:
            android.graphics.drawable.Drawable r4 = r2.b_renamed(r3, r4)
            goto L2d
        L1f:
            android.graphics.drawable.Drawable r4 = r2.d_renamed(r3, r4)
            goto L2d
        L24:
            android.graphics.drawable.Drawable r4 = r2.c_renamed(r3, r4)
            goto L2d
        L29:
            android.graphics.drawable.Drawable r4 = r2.a_renamed(r3, r4)
        L2d:
            int r3 = r4.getIntrinsicWidth()
            int r1 = r2.e_renamed
            if (r3 <= r1) goto L44
            android.graphics.drawable.Drawable[] r3 = new android.graphics.drawable.Drawable[r0]
            r0 = 0
            r3[r0] = r4
            android.graphics.drawable.LayerDrawable r4 = new android.graphics.drawable.LayerDrawable
            r4.<init>(r3)
            int r3 = r2.e_renamed
            r4.setLayerSize(r0, r3, r3)
        L44:
            if (r6 == 0) goto L4c
            if (r7 == r5) goto L4c
            android.graphics.drawable.LayerDrawable r4 = r2.b_renamed(r4)
        L4c:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.sticker.ui.c_renamed.a_renamed(com.oplus.camera.sticker.ui.b_renamed, android.graphics.drawable.Drawable, int, boolean, boolean):android.graphics.drawable.Drawable");
    }

    private android.graphics.drawable.Drawable a_renamed(android.graphics.drawable.Drawable drawable) throws android.content.res.Resources.NotFoundException {
        android.graphics.drawable.LayerDrawable layerDrawable = new android.graphics.drawable.LayerDrawable(new android.graphics.drawable.Drawable[]{drawable});
        android.graphics.drawable.Drawable drawable2 = this.f5510c.getResources().getDrawable(com.oplus.camera.R_renamed.drawable.sticker_music, null);
        if (drawable2 != null) {
            layerDrawable.addLayer(drawable2);
        }
        return layerDrawable;
    }

    private android.graphics.drawable.Drawable a_renamed(com.oplus.camera.sticker.ui.b_renamed bVar, android.graphics.drawable.Drawable drawable) throws android.content.res.Resources.NotFoundException {
        android.graphics.drawable.LayerDrawable layerDrawable = new android.graphics.drawable.LayerDrawable(new android.graphics.drawable.Drawable[]{drawable});
        drawable.setAlpha(255);
        android.graphics.drawable.Drawable drawable2 = this.f5510c.getResources().getDrawable(com.oplus.camera.R_renamed.drawable.sticker_need_download, null);
        if (drawable2 != null) {
            layerDrawable.addLayer(drawable2);
        }
        if (bVar.f5503a != null) {
            bVar.f5503a.setVisibility(8);
            bVar.f5503a.clearAnimation();
        }
        return layerDrawable;
    }

    private android.graphics.drawable.Drawable b_renamed(com.oplus.camera.sticker.ui.b_renamed bVar, android.graphics.drawable.Drawable drawable) {
        drawable.setAlpha(255);
        if (bVar.f5503a != null) {
            bVar.f5503a.setVisibility(8);
            bVar.f5503a.clearAnimation();
        }
        return drawable;
    }

    private android.graphics.drawable.Drawable c_renamed(com.oplus.camera.sticker.ui.b_renamed bVar, android.graphics.drawable.Drawable drawable) {
        drawable.setAlpha(127);
        if (bVar.f5503a != null) {
            bVar.f5503a.setVisibility(0);
            bVar.f5503a.a_renamed();
        }
        return drawable;
    }

    private android.graphics.drawable.Drawable d_renamed(com.oplus.camera.sticker.ui.b_renamed bVar, android.graphics.drawable.Drawable drawable) throws android.content.res.Resources.NotFoundException {
        android.graphics.drawable.LayerDrawable layerDrawable = new android.graphics.drawable.LayerDrawable(new android.graphics.drawable.Drawable[]{drawable});
        drawable.setAlpha(255);
        android.graphics.drawable.Drawable drawable2 = this.f5510c.getResources().getDrawable(com.oplus.camera.R_renamed.drawable.sticker_need_refresh, null);
        if (drawable2 != null) {
            layerDrawable.addLayer(drawable2);
        }
        if (bVar.f5503a != null) {
            bVar.f5503a.setVisibility(8);
            bVar.f5503a.clearAnimation();
        }
        return layerDrawable;
    }

    private void a_renamed(com.oplus.camera.sticker.ui.b_renamed bVar, android.graphics.drawable.Drawable drawable, java.lang.String str) {
        if (bVar.f5504b != null) {
            bVar.f5504b.setImageDrawable(drawable);
        }
    }

    private android.graphics.drawable.LayerDrawable b_renamed(android.graphics.drawable.Drawable drawable) {
        android.graphics.drawable.Drawable[] drawableArr = {drawable, this.f5510c.getResources().getDrawable(com.oplus.camera.R_renamed.drawable.sticker_red_point)};
        android.graphics.drawable.LayerDrawable layerDrawable = new android.graphics.drawable.LayerDrawable(drawableArr);
        int intrinsicWidth = drawableArr[0].getIntrinsicWidth();
        int intrinsicWidth2 = drawableArr[1].getIntrinsicWidth();
        int i_renamed = this.h_renamed;
        int i2 = (i_renamed - intrinsicWidth) / 2;
        int i3 = i2 + 0;
        int i4 = i_renamed - (intrinsicWidth + i2);
        int i5 = this.g_renamed;
        int i6 = i_renamed - ((intrinsicWidth2 / 2) + i5);
        int i7 = i5 - this.f_renamed;
        int i8 = i6 + intrinsicWidth2;
        int i9 = i6 - 0;
        int i10 = i7 + 0;
        int i11 = i_renamed - i8;
        int i12 = i_renamed - (intrinsicWidth2 + i7);
        if (i3 < 0 || i3 < 0 || i4 > 0 || i4 > 0) {
            com.oplus.camera.e_renamed.f_renamed("ImageDownloader", "showRedPoint, drawable0 out of_renamed thumbnail display!");
        }
        layerDrawable.setLayerInset(0, i3, i3, i4, i4);
        layerDrawable.setLayerInset(1, i9, i10, i11, i12);
        return layerDrawable;
    }
}
