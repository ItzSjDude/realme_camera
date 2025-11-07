package com.oplus.camera.ui.preview.a_renamed;

/* compiled from: ImageStickerTools.java */
/* loaded from: classes2.dex */
public class q_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static com.oplus.camera.ui.preview.a_renamed.q_renamed f6925a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private static java.lang.Object f6926b = new java.lang.Object();

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.content.Context f6927c;
    private android.content.SharedPreferences e_renamed;
    private com.coui.appcompat.dialog.app.b_renamed o_renamed;
    private com.oplus.camera.sticker.data.StickerItem p_renamed;
    private com.oplus.camera.ui.preview.a_renamed.q_renamed.c_renamed d_renamed = new com.oplus.camera.ui.preview.a_renamed.q_renamed.c_renamed();
    private android.os.HandlerThread f_renamed = null;
    private android.os.Handler g_renamed = null;
    private com.oplus.camera.ui.preview.a_renamed.v_renamed h_renamed = null;
    private long i_renamed = 1;
    private com.oplus.camera.sticker.h_renamed j_renamed = null;
    private java.util.HashMap<java.lang.String, com.oplus.camera.ui.preview.a_renamed.q_renamed.b_renamed> k_renamed = null;
    private boolean l_renamed = false;
    private int m_renamed = 0;
    private boolean n_renamed = false;
    private com.oplus.camera.sticker.a_renamed q_renamed = new com.oplus.camera.sticker.a_renamed() { // from class: com.oplus.camera.ui.preview.a_renamed.q_renamed.7
        @Override // com.oplus.camera.sticker.a_renamed
        public void a_renamed(int i_renamed) {
            synchronized (com.oplus.camera.ui.preview.a_renamed.q_renamed.f6926b) {
                if (i_renamed == 1) {
                    com.oplus.camera.ui.preview.a_renamed.q_renamed.this.c_renamed();
                    if (com.oplus.camera.ui.preview.a_renamed.q_renamed.this.h_renamed != null) {
                        com.oplus.camera.ui.preview.a_renamed.q_renamed.this.h_renamed.a_renamed();
                    }
                }
            }
        }

        @Override // com.oplus.camera.sticker.a_renamed
        public void b_renamed(com.oplus.camera.sticker.data.StickerItem stickerItem) {
            if (stickerItem == null) {
                com.oplus.camera.e_renamed.f_renamed("ImageStickerTools", "onStickerDownloadSuccess return");
                return;
            }
            com.oplus.camera.e_renamed.b_renamed("ImageStickerTools", "onStickerDownloadSuccess, item: " + stickerItem);
            stickerItem.setDownloadState(8);
            synchronized (com.oplus.camera.ui.preview.a_renamed.q_renamed.f6926b) {
                com.oplus.camera.ui.preview.a_renamed.q_renamed.this.c_renamed();
                if (com.oplus.camera.ui.preview.a_renamed.q_renamed.this.h_renamed != null) {
                    com.oplus.camera.ui.preview.a_renamed.q_renamed.this.h_renamed.b_renamed(stickerItem);
                }
            }
            if (com.oplus.camera.ui.preview.a_renamed.q_renamed.this.k_renamed != null) {
                com.oplus.camera.ui.preview.a_renamed.q_renamed.this.a_renamed((com.oplus.camera.ui.preview.a_renamed.q_renamed.b_renamed) com.oplus.camera.ui.preview.a_renamed.q_renamed.this.k_renamed.get(stickerItem.getStickerUUID()), true);
            }
        }

        @Override // com.oplus.camera.sticker.a_renamed
        public void a_renamed(com.oplus.camera.sticker.data.StickerItem stickerItem) {
            com.oplus.camera.e_renamed.b_renamed("ImageStickerTools", "onStickerDelete, item: " + stickerItem);
            if (stickerItem == null || !stickerItem.matchAppAttribute(1L)) {
                return;
            }
            synchronized (com.oplus.camera.ui.preview.a_renamed.q_renamed.f6926b) {
                com.oplus.camera.ui.preview.a_renamed.q_renamed.this.c_renamed();
                if (com.oplus.camera.ui.preview.a_renamed.q_renamed.this.h_renamed != null) {
                    com.oplus.camera.ui.preview.a_renamed.q_renamed.this.h_renamed.c_renamed(stickerItem);
                }
            }
        }

        @Override // com.oplus.camera.sticker.a_renamed
        public void a_renamed() {
            com.oplus.camera.e_renamed.b_renamed("ImageStickerTools", "onStickerImportFinish");
            synchronized (com.oplus.camera.ui.preview.a_renamed.q_renamed.f6926b) {
                com.oplus.camera.ui.preview.a_renamed.q_renamed.this.c_renamed();
                if (com.oplus.camera.ui.preview.a_renamed.q_renamed.this.h_renamed != null) {
                    com.oplus.camera.ui.preview.a_renamed.q_renamed.this.h_renamed.a_renamed();
                }
            }
        }

        @Override // com.oplus.camera.sticker.a_renamed
        public void a_renamed(com.oplus.camera.sticker.data.StickerItem stickerItem, int i_renamed) {
            com.oplus.camera.e_renamed.b_renamed("ImageStickerTools", "onStickerDownloadFail, errorCode: " + i_renamed + ", item: " + stickerItem);
            if (stickerItem != null) {
                if (com.oplus.camera.ui.preview.a_renamed.q_renamed.this.h_renamed != null) {
                    com.oplus.camera.ui.preview.a_renamed.q_renamed.this.h_renamed.a_renamed(stickerItem, i_renamed);
                }
                if (com.oplus.camera.ui.preview.a_renamed.q_renamed.this.k_renamed != null) {
                    com.oplus.camera.ui.preview.a_renamed.q_renamed.this.a_renamed((com.oplus.camera.ui.preview.a_renamed.q_renamed.b_renamed) com.oplus.camera.ui.preview.a_renamed.q_renamed.this.k_renamed.get(stickerItem.getStickerUUID()), false);
                    return;
                }
                return;
            }
            com.oplus.camera.e_renamed.f_renamed("ImageStickerTools", "onStickerDownloadFail return! Since item: " + stickerItem);
        }

        @Override // com.oplus.camera.sticker.a_renamed
        public void b_renamed(com.oplus.camera.sticker.data.StickerItem stickerItem, int i_renamed) {
            com.oplus.camera.e_renamed.b_renamed("ImageStickerTools", "onStickerDownloadPause, errorCode: " + i_renamed + ", item: " + stickerItem);
            if (stickerItem != null) {
                if (com.oplus.camera.ui.preview.a_renamed.q_renamed.this.h_renamed != null) {
                    com.oplus.camera.ui.preview.a_renamed.q_renamed.this.h_renamed.a_renamed(stickerItem, i_renamed);
                }
                if (com.oplus.camera.ui.preview.a_renamed.q_renamed.this.k_renamed != null) {
                    com.oplus.camera.ui.preview.a_renamed.q_renamed.this.a_renamed((com.oplus.camera.ui.preview.a_renamed.q_renamed.b_renamed) com.oplus.camera.ui.preview.a_renamed.q_renamed.this.k_renamed.get(stickerItem.getStickerUUID()), false);
                    return;
                }
                return;
            }
            com.oplus.camera.e_renamed.f_renamed("ImageStickerTools", "onStickerDownloadPause return! Since item: " + stickerItem);
        }

        @Override // com.oplus.camera.sticker.a_renamed
        public void c_renamed(com.oplus.camera.sticker.data.StickerItem stickerItem) {
            com.oplus.camera.e_renamed.b_renamed("ImageStickerTools", "onUpdateStickerDownloadTime, item: " + stickerItem);
            synchronized (com.oplus.camera.ui.preview.a_renamed.q_renamed.f6926b) {
                com.oplus.camera.ui.preview.a_renamed.q_renamed.this.c_renamed();
                if (com.oplus.camera.ui.preview.a_renamed.q_renamed.this.h_renamed != null) {
                    com.oplus.camera.ui.preview.a_renamed.q_renamed.this.h_renamed.d_renamed(stickerItem);
                }
            }
        }
    };

    public static boolean a_renamed(int i_renamed) {
        return 2 == i_renamed;
    }

    private q_renamed(android.content.Context context) {
        this.f6927c = null;
        this.f6927c = context;
        this.e_renamed = this.f6927c.getSharedPreferences("sticker_info", 0);
        h_renamed();
    }

    public void a_renamed(android.content.Context context) {
        com.oplus.camera.e_renamed.b_renamed("ImageStickerTools", "initStickerMediator");
        if (this.j_renamed == null) {
            this.j_renamed = com.oplus.camera.sticker.h_renamed.a_renamed(context);
            this.j_renamed.a_renamed();
            this.j_renamed.a_renamed(this.q_renamed);
        }
    }

    private void h_renamed() {
        if (this.f_renamed == null) {
            this.f_renamed = new android.os.HandlerThread("StickerHandlerThread");
            this.f_renamed.start();
        }
        if (this.g_renamed == null) {
            this.g_renamed = new android.os.Handler(this.f_renamed.getLooper());
        }
    }

    private void i_renamed() {
        android.os.Handler handler = this.g_renamed;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.g_renamed = null;
        }
        android.os.HandlerThread handlerThread = this.f_renamed;
        if (handlerThread != null) {
            handlerThread.quitSafely();
            this.f_renamed = null;
        }
    }

    public void a_renamed(final int i_renamed, boolean z_renamed) {
        synchronized (f6926b) {
            if (this.l_renamed && i_renamed == 0) {
                return;
            }
            this.l_renamed = true;
            if (z_renamed) {
                if (this.g_renamed != null) {
                    this.g_renamed.post(new java.lang.Runnable() { // from class: com.oplus.camera.ui.preview.a_renamed.q_renamed.1
                        @Override // java.lang.Runnable
                        public void run() {
                            synchronized (com.oplus.camera.ui.preview.a_renamed.q_renamed.f6926b) {
                                com.oplus.camera.ui.preview.a_renamed.q_renamed.this.b_renamed(i_renamed);
                            }
                        }
                    });
                }
            } else {
                b_renamed(i_renamed);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b_renamed(int i_renamed) {
        c_renamed();
        com.oplus.camera.ui.preview.a_renamed.v_renamed vVar = this.h_renamed;
        if (vVar != null) {
            vVar.a_renamed(i_renamed);
        }
    }

    public java.lang.Integer a_renamed() {
        return java.lang.Integer.valueOf(this.m_renamed - 1);
    }

    public com.oplus.camera.ui.preview.a_renamed.q_renamed.c_renamed b_renamed() {
        return this.d_renamed;
    }

    public boolean a_renamed(java.lang.String str) {
        android.content.SharedPreferences sharedPreferences = this.e_renamed;
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean(str, false);
        }
        return true;
    }

    public void a_renamed(java.lang.String str, boolean z_renamed) {
        android.content.SharedPreferences sharedPreferences = this.e_renamed;
        if (sharedPreferences != null) {
            android.content.SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putBoolean(str, z_renamed);
            editorEdit.apply();
        }
    }

    private boolean j_renamed() {
        android.content.SharedPreferences sharedPreferences = this.e_renamed;
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean("sticker_dialog_status", false);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k_renamed() {
        android.content.SharedPreferences sharedPreferences = this.e_renamed;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean("sticker_dialog_status", true).apply();
        }
    }

    public static com.oplus.camera.ui.preview.a_renamed.q_renamed b_renamed(android.content.Context context) {
        com.oplus.camera.ui.preview.a_renamed.q_renamed qVar;
        synchronized (f6926b) {
            if (f6925a == null && context != null) {
                f6925a = new com.oplus.camera.ui.preview.a_renamed.q_renamed(context.getApplicationContext());
            }
            qVar = f6925a;
        }
        return qVar;
    }

    public void c_renamed() {
        com.oplus.camera.e_renamed.a_renamed("ImageStickerTools", "refreshStickerInfoByCameraId");
        if (this.f6927c == null) {
            com.oplus.camera.e_renamed.f_renamed("ImageStickerTools", "refreshStickerInfoByCameraId, mContext is_renamed null");
            return;
        }
        com.oplus.camera.e_renamed.a_renamed("refreshStickerInfoByCameraId");
        this.d_renamed.a_renamed(b_renamed(d_renamed()));
        java.util.List<com.oplus.camera.sticker.data.StickerItem> listA = a_renamed(this.d_renamed.c_renamed());
        if (listA != null) {
            java.util.Iterator<com.oplus.camera.sticker.data.StickerItem> it = listA.iterator();
            while (it.hasNext()) {
                a_renamed(it.next());
            }
        } else {
            com.oplus.camera.e_renamed.f_renamed("ImageStickerTools", "initStickerInfoToMap, databaseList is_renamed null");
        }
        com.oplus.camera.e_renamed.b_renamed("refreshStickerInfoByCameraId");
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:15:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.ArrayList<com.oplus.camera.sticker.data.StickerCategoryItem> d_renamed() {
        /*
            r4 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            android.content.Context r1 = r4.f6927c
            long r2 = r4.i_renamed
            android.database.Cursor r4 = com.oplus.camera.sticker.e_renamed.a_renamed(r1, r2)
            if (r4 == 0) goto L27
        Lf:
            boolean r1 = r4.moveToNext()     // Catch: java.lang.Throwable -> L1d java.lang.Exception -> L24
            if (r1 == 0) goto L27
            com.oplus.camera.sticker.data.StickerCategoryItem r1 = com.oplus.camera.sticker.e_renamed.a_renamed(r4)     // Catch: java.lang.Throwable -> L1d java.lang.Exception -> L24
            r0.add(r1)     // Catch: java.lang.Throwable -> L1d java.lang.Exception -> L24
            goto Lf
        L1d:
            r0 = move-exception
            if (r4 == 0) goto L23
            r4.close()
        L23:
            throw r0
        L24:
            if (r4 == 0) goto L2c
            goto L29
        L27:
            if (r4 == 0) goto L2c
        L29:
            r4.close()
        L2c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.ui.preview.a_renamed.q_renamed.d_renamed():java.util.ArrayList");
    }

    public java.util.List<com.oplus.camera.sticker.data.StickerItem> a_renamed(java.util.ArrayList<com.oplus.camera.sticker.ui.h_renamed.b_renamed> arrayList) {
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        try {
            java.util.Iterator<com.oplus.camera.sticker.ui.h_renamed.b_renamed> it = arrayList.iterator();
            while (it.hasNext()) {
                com.oplus.camera.sticker.ui.h_renamed.b_renamed next = it.next();
                android.database.Cursor cursorA = com.oplus.camera.sticker.g_renamed.a_renamed(this.f6927c, this.i_renamed, next.f5556c);
                if (cursorA != null) {
                    if (com.oplus.camera.sticker.data.StickerCategoryItem.isMyCategory(next.f5556c)) {
                        this.m_renamed = cursorA.getCount();
                    }
                    while (cursorA.moveToNext()) {
                        com.oplus.camera.sticker.data.StickerItem stickerItemA = com.oplus.camera.sticker.g_renamed.a_renamed(cursorA);
                        stickerItemA.getCategoryId();
                        if (com.oplus.camera.sticker.data.StickerCategoryItem.isMyCategory(next.f5556c)) {
                            stickerItemA.setCategoryId(next.f5556c);
                        }
                        arrayList2.add(stickerItemA);
                    }
                    cursorA.close();
                }
            }
        } catch (java.lang.Exception e_renamed) {
            com.oplus.camera.e_renamed.f_renamed("ImageStickerTools", "querySingleStickerInfo, e_renamed: " + e_renamed);
        }
        return arrayList2;
    }

    public com.oplus.camera.sticker.data.StickerItem a_renamed(android.content.SharedPreferences sharedPreferences) {
        com.oplus.camera.sticker.data.StickerItem stickerItemA;
        if (sharedPreferences == null) {
            com.oplus.camera.e_renamed.f_renamed("ImageStickerTools", "getSelectedStickerItem, preferences: " + sharedPreferences);
            return null;
        }
        com.oplus.camera.e_renamed.a_renamed("getSelectedStickerItem");
        java.lang.String string = sharedPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_CURRENT_STICKER_UUID, "unselected_uuid");
        if ("unselected_uuid".equals(string) || (stickerItemA = com.oplus.camera.sticker.g_renamed.a_renamed(this.f6927c, com.heytap.accessory.constant.AFConstants.EXTRA_UUID, string)) == null || !stickerItemA.isDownloaded()) {
            return null;
        }
        com.oplus.camera.e_renamed.b_renamed("getSelectedStickerItem");
        return stickerItemA;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B_renamed:46:0x004a A_renamed[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v0, types: [android.net.Uri] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.io.InputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.graphics.drawable.Drawable a_renamed(android.content.Context r3, android.net.Uri r4) throws java.lang.Throwable {
        /*
            r2 = this;
            android.content.ContentResolver r0 = r3.getContentResolver()
            r1 = 0
            java.io.InputStream r4 = r0.openInputStream(r4)     // Catch: java.lang.Throwable -> L28 java.io.FileNotFoundException -> L2b
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeStream(r4)     // Catch: java.lang.Throwable -> L24 java.io.FileNotFoundException -> L26
            if (r0 == 0) goto L1e
            android.graphics.drawable.BitmapDrawable r2 = com.oplus.camera.util.Util.a_renamed(r3, r0)     // Catch: java.lang.Throwable -> L24 java.io.FileNotFoundException -> L26
            if (r4 == 0) goto L1d
            r4.close()     // Catch: java.io.IOException -> L19
            goto L1d
        L19:
            r3 = move-exception
            r3.printStackTrace()
        L1d:
            return r2
        L1e:
            if (r4 == 0) goto L3a
            r4.close()     // Catch: java.io.IOException -> L36
            goto L3a
        L24:
            r2 = move-exception
            goto L48
        L26:
            r3 = move-exception
            goto L2d
        L28:
            r2 = move-exception
            r4 = r1
            goto L48
        L2b:
            r3 = move-exception
            r4 = r1
        L2d:
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L24
            if (r4 == 0) goto L3a
            r4.close()     // Catch: java.io.IOException -> L36
            goto L3a
        L36:
            r3 = move-exception
            r3.printStackTrace()
        L3a:
            android.content.Context r2 = r2.f6927c
            android.content.res.Resources r2 = r2.getResources()
            r3 = 2131232270(0x7f08060e, float:1.8080645E38)
            android.graphics.drawable.Drawable r2 = r2.getDrawable(r3, r1)
            return r2
        L48:
            if (r4 == 0) goto L52
            r4.close()     // Catch: java.io.IOException -> L4e
            goto L52
        L4e:
            r3 = move-exception
            r3.printStackTrace()
        L52:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.ui.preview.a_renamed.q_renamed.a_renamed(android.content.Context, android.net.Uri):android.graphics.drawable.Drawable");
    }

    public static byte[] a_renamed(android.content.Context context, java.lang.String str) throws java.io.IOException {
        java.io.InputStream inputStreamOpenInputStream = null;
        if (context == null || android.text.TextUtils.isEmpty(str)) {
            com.oplus.camera.e_renamed.b_renamed("ImageStickerTools", "readStickerStream, context or stickerUri is_renamed null");
            return null;
        }
        byte[] bArr = new byte[1024];
        android.content.ContentResolver contentResolver = context.getContentResolver();
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        try {
            try {
                inputStreamOpenInputStream = contentResolver.openInputStream(android.net.Uri.parse(str));
                while (inputStreamOpenInputStream != null) {
                    int i_renamed = inputStreamOpenInputStream.read(bArr);
                    if (i_renamed == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, i_renamed);
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                if (inputStreamOpenInputStream != null) {
                    try {
                        inputStreamOpenInputStream.close();
                    } catch (java.io.IOException e_renamed) {
                        e_renamed.printStackTrace();
                    }
                }
                try {
                    byteArrayOutputStream.close();
                } catch (java.io.IOException e2) {
                    e2.printStackTrace();
                }
                return byteArray;
            } catch (java.lang.Exception e3) {
                com.oplus.camera.e_renamed.f_renamed("ImageStickerTools", "readStickerStream, ex_renamed: " + e3);
                if (inputStreamOpenInputStream != null) {
                    try {
                        inputStreamOpenInputStream.close();
                    } catch (java.io.IOException e4) {
                        e4.printStackTrace();
                    }
                }
                try {
                    byteArrayOutputStream.close();
                } catch (java.io.IOException e5) {
                    e5.printStackTrace();
                }
                return bArr;
            }
        } finally {
        }
    }

    private java.util.ArrayList<com.oplus.camera.sticker.ui.h_renamed.b_renamed> b_renamed(java.util.ArrayList<com.oplus.camera.sticker.data.StickerCategoryItem> arrayList) throws java.lang.Throwable {
        android.graphics.drawable.Drawable drawable;
        java.util.ArrayList<com.oplus.camera.sticker.ui.h_renamed.b_renamed> arrayList2 = new java.util.ArrayList<>();
        this.d_renamed.a_renamed();
        if (arrayList != null) {
            int i_renamed = 0;
            java.util.Iterator<com.oplus.camera.sticker.data.StickerCategoryItem> it = arrayList.iterator();
            while (it.hasNext()) {
                com.oplus.camera.sticker.data.StickerCategoryItem next = it.next();
                if (next != null) {
                    java.lang.String iconHighlightFileUri = next.getIconHighlightFileUri();
                    java.lang.String iconFileUri = next.getIconFileUri();
                    boolean zIsCategoryNew = next.isCategoryNew();
                    android.graphics.drawable.Drawable drawable2 = null;
                    if (android.text.TextUtils.isEmpty(iconFileUri)) {
                        drawable = null;
                    } else {
                        drawable = a_renamed(this.f6927c, android.net.Uri.parse(iconFileUri));
                    }
                    if (drawable == null) {
                        drawable = this.f6927c.getDrawable(com.oplus.camera.R_renamed.drawable.unselect_preset);
                    }
                    if (!android.text.TextUtils.isEmpty(iconHighlightFileUri)) {
                        drawable2 = a_renamed(this.f6927c, android.net.Uri.parse(iconHighlightFileUri));
                    }
                    if (drawable2 == null) {
                        drawable2 = this.f6927c.getDrawable(com.oplus.camera.R_renamed.drawable.select_preset);
                    }
                    arrayList2.add(new com.oplus.camera.sticker.ui.h_renamed.b_renamed(drawable2, drawable, next.getReadableId(), zIsCategoryNew));
                    this.d_renamed.b_renamed(next.getReadableId(), i_renamed);
                    i_renamed++;
                }
            }
        }
        return arrayList2;
    }

    public boolean a_renamed(android.app.Activity activity, com.oplus.camera.sticker.data.StickerItem stickerItem) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("onEffectClick, isDownloaded: ");
        sb.append(stickerItem != null ? java.lang.Boolean.valueOf(stickerItem.isDownloaded()) : null);
        sb.append(", item.needUpdate: ");
        sb.append(stickerItem != null ? java.lang.Boolean.valueOf(stickerItem.needUpdate()) : null);
        com.oplus.camera.e_renamed.a_renamed("ImageStickerTools", sb.toString());
        if (stickerItem != null) {
            if (!stickerItem.needUpdate() && stickerItem.isDownloaded()) {
                return false;
            }
            android.content.Context context = this.f6927c;
            if (context != null) {
                if (com.oplus.util.OplusNetworkUtil.isWifiConnected(context)) {
                    stickerItem.setDownloadState(2);
                    com.oplus.camera.ui.preview.a_renamed.v_renamed vVar = this.h_renamed;
                    if (vVar != null) {
                        vVar.a_renamed(stickerItem);
                    }
                    com.oplus.camera.sticker.h_renamed hVar = this.j_renamed;
                    if (hVar != null) {
                        hVar.a_renamed(stickerItem, false);
                        e_renamed(stickerItem);
                    }
                } else if (com.oplus.util.OplusNetworkUtil.isMobileDataConnected(this.f6927c)) {
                    b_renamed(activity, stickerItem);
                } else {
                    com.oplus.camera.util.o_renamed.a_renamed(this.f6927c, com.oplus.camera.R_renamed.string.sticker_toast_disconnect);
                    stickerItem.setDownloadState(16);
                    com.oplus.camera.ui.preview.a_renamed.v_renamed vVar2 = this.h_renamed;
                    if (vVar2 != null) {
                        vVar2.a_renamed(stickerItem);
                    }
                }
            }
            return true;
        }
        com.oplus.camera.e_renamed.e_renamed("ImageStickerTools", "onEffectClick, item is_renamed null!");
        return true;
    }

    public void a_renamed(com.oplus.camera.sticker.data.StickerItem stickerItem) {
        if (stickerItem != null) {
            java.util.concurrent.CopyOnWriteArrayList<com.oplus.camera.sticker.data.StickerItem> copyOnWriteArrayListA = this.d_renamed.a_renamed(stickerItem.getCategoryId());
            if (copyOnWriteArrayListA == null) {
                copyOnWriteArrayListA = new java.util.concurrent.CopyOnWriteArrayList<>();
                this.d_renamed.a_renamed(stickerItem.getCategoryId(), copyOnWriteArrayListA);
            }
            copyOnWriteArrayListA.add(stickerItem);
            this.d_renamed.a_renamed(stickerItem.getStickerUUID(), copyOnWriteArrayListA.indexOf(stickerItem));
            return;
        }
        com.oplus.camera.e_renamed.f_renamed("ImageStickerTools", "refreshSticker, item is_renamed null");
    }

    public void b_renamed(java.lang.String str) {
        synchronized (f6926b) {
            this.d_renamed.b_renamed(str);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:13:0x0051 A_renamed[Catch: all -> 0x0063, TryCatch #0 {, blocks: (B_renamed:5:0x0005, B_renamed:6:0x000e, B_renamed:8:0x0027, B_renamed:10:0x002d, B_renamed:12:0x0033, B_renamed:16:0x005f, B_renamed:13:0x0051, B_renamed:15:0x0055), top: B_renamed:22:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:15:0x0055 A_renamed[Catch: all -> 0x0063, TryCatch #0 {, blocks: (B_renamed:5:0x0005, B_renamed:6:0x000e, B_renamed:8:0x0027, B_renamed:10:0x002d, B_renamed:12:0x0033, B_renamed:16:0x005f, B_renamed:13:0x0051, B_renamed:15:0x0055), top: B_renamed:22:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a_renamed(final com.oplus.camera.ui.preview.a_renamed.p_renamed r7, final com.oplus.camera.sticker.data.StickerItem r8, final boolean r9) {
        /*
            r6 = this;
            java.lang.Object r0 = com.oplus.camera.ui.preview.a_renamed.q_renamed.f6926b
            monitor-enter(r0)
            if (r8 == 0) goto Le
            java.lang.String r1 = r8.getCategoryId()     // Catch: java.lang.Throwable -> L63
            com.oplus.camera.ui.preview.a_renamed.q_renamed$c_renamed r2 = r6.d_renamed     // Catch: java.lang.Throwable -> L63
            r2.b_renamed(r1)     // Catch: java.lang.Throwable -> L63
        Le:
            com.oplus.camera.ui.preview.a_renamed.q_renamed$c_renamed r1 = r6.d_renamed     // Catch: java.lang.Throwable -> L63
            java.util.concurrent.CopyOnWriteArrayList r1 = r1.b_renamed()     // Catch: java.lang.Throwable -> L63
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L63
            com.oplus.camera.ui.preview.a_renamed.q_renamed$c_renamed r3 = r6.d_renamed     // Catch: java.lang.Throwable -> L63
            java.util.ArrayList r3 = r3.c_renamed()     // Catch: java.lang.Throwable -> L63
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L63
            com.oplus.camera.ui.preview.a_renamed.q_renamed$c_renamed r3 = r6.d_renamed     // Catch: java.lang.Throwable -> L63
            int r3 = r3.d_renamed()     // Catch: java.lang.Throwable -> L63
            if (r1 == 0) goto L51
            int r4 = r1.size()     // Catch: java.lang.Throwable -> L63
            if (r4 <= 0) goto L51
            int r4 = r2.size()     // Catch: java.lang.Throwable -> L63
            if (r4 <= 0) goto L51
            java.lang.String r6 = "ImageStickerTools"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L63
            r4.<init>()     // Catch: java.lang.Throwable -> L63
            java.lang.String r5 = "setImageResource, stickerList.size: "
            r4.append(r5)     // Catch: java.lang.Throwable -> L63
            int r1 = r1.size()     // Catch: java.lang.Throwable -> L63
            r4.append(r1)     // Catch: java.lang.Throwable -> L63
            java.lang.String r1 = r4.toString()     // Catch: java.lang.Throwable -> L63
            com.oplus.camera.e_renamed.a_renamed(r6, r1)     // Catch: java.lang.Throwable -> L63
            r7.a_renamed(r2, r3, r8, r9)     // Catch: java.lang.Throwable -> L63
            goto L5f
        L51:
            android.os.Handler r1 = r6.g_renamed     // Catch: java.lang.Throwable -> L63
            if (r1 == 0) goto L5f
            android.os.Handler r1 = r6.g_renamed     // Catch: java.lang.Throwable -> L63
            com.oplus.camera.ui.preview.a_renamed.q_renamed$2 r2 = new com.oplus.camera.ui.preview.a_renamed.q_renamed$2     // Catch: java.lang.Throwable -> L63
            r2.<init>()     // Catch: java.lang.Throwable -> L63
            r1.post(r2)     // Catch: java.lang.Throwable -> L63
        L5f:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L63
            return
        L61:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L63
            throw r6
        L63:
            r6 = move-exception
            goto L61
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.ui.preview.a_renamed.q_renamed.a_renamed(com.oplus.camera.ui.preview.a_renamed.p_renamed, com.oplus.camera.sticker.data.StickerItem, boolean):void");
    }

    public void c_renamed(android.content.Context context) {
        com.oplus.camera.e_renamed.a_renamed("ImageStickerTools", "releaseResource");
        if (context.getApplicationContext() != this.f6927c) {
            com.oplus.camera.e_renamed.a_renamed("ImageStickerTools", "releaseResource, return");
            return;
        }
        com.oplus.camera.sticker.h_renamed hVar = this.j_renamed;
        if (hVar != null) {
            hVar.b_renamed(this.q_renamed);
            this.j_renamed.b_renamed();
            this.j_renamed = null;
        }
        synchronized (f6926b) {
            this.d_renamed.a_renamed();
            i_renamed();
            this.l_renamed = false;
            f6925a = null;
        }
    }

    public void a_renamed(com.oplus.camera.ui.preview.a_renamed.v_renamed vVar) {
        this.h_renamed = vVar;
    }

    public void a_renamed(android.app.Activity activity) {
        com.coui.appcompat.dialog.app.b_renamed bVar = this.o_renamed;
        if (bVar == null || !bVar.isShowing()) {
            return;
        }
        a_renamed(activity, this.n_renamed, true);
    }

    public void e_renamed() {
        com.coui.appcompat.dialog.app.b_renamed bVar = this.o_renamed;
        if (bVar != null && bVar.isShowing()) {
            this.o_renamed.dismiss();
        }
        this.o_renamed = null;
    }

    private void b_renamed(android.app.Activity activity, com.oplus.camera.sticker.data.StickerItem stickerItem) {
        if (activity == null) {
            com.oplus.camera.e_renamed.b_renamed("ImageStickerTools", "showNetworkWarningDialog, context is_renamed null .");
        } else if (j_renamed()) {
            d_renamed(stickerItem);
        } else {
            this.p_renamed = stickerItem;
            a_renamed(activity, this.n_renamed, false);
        }
    }

    private void a_renamed(android.app.Activity activity, boolean z_renamed, boolean z2) {
        com.coui.appcompat.dialog.app.b_renamed bVar = this.o_renamed;
        if (bVar != null && (bVar.isShowing() || z2)) {
            this.o_renamed.cancel();
            this.o_renamed = null;
        }
        android.view.View viewInflate = android.view.LayoutInflater.from(activity).inflate(com.oplus.camera.R_renamed.layout.sticker_warning_checkbox, (android.view.ViewGroup) null);
        final android.widget.CheckBox checkBox = (android.widget.CheckBox) ((android.widget.LinearLayout) viewInflate).findViewById(com.oplus.camera.R_renamed.id_renamed.sticker_check_box_never);
        if (z2) {
            checkBox.setChecked(z_renamed);
        }
        checkBox.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() { // from class: com.oplus.camera.ui.preview.a_renamed.q_renamed.3
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(android.widget.CompoundButton compoundButton, boolean z3) {
                com.oplus.camera.ui.preview.a_renamed.q_renamed.this.n_renamed = z3;
            }
        });
        this.o_renamed = new com.coui.appcompat.dialog.app.b_renamed.a_renamed(activity, 2131821271).setCancelable(false).setOnKeyListener(new android.content.DialogInterface.OnKeyListener() { // from class: com.oplus.camera.ui.preview.a_renamed.q_renamed.6
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(android.content.DialogInterface dialogInterface, int i_renamed, android.view.KeyEvent keyEvent) {
                if (4 != i_renamed) {
                    return false;
                }
                dialogInterface.dismiss();
                return false;
            }
        }).setPositiveButton(com.oplus.camera.R_renamed.string.sticker_continue_download, new android.content.DialogInterface.OnClickListener() { // from class: com.oplus.camera.ui.preview.a_renamed.q_renamed.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(android.content.DialogInterface dialogInterface, int i_renamed) {
                com.oplus.camera.ui.preview.a_renamed.q_renamed qVar = com.oplus.camera.ui.preview.a_renamed.q_renamed.this;
                qVar.d_renamed(qVar.p_renamed);
                if (com.oplus.camera.ui.preview.a_renamed.q_renamed.this.n_renamed) {
                    com.oplus.camera.ui.preview.a_renamed.q_renamed.this.k_renamed();
                }
            }
        }).setNegativeButton(com.oplus.camera.R_renamed.string.sticker_cancel_download, (android.content.DialogInterface.OnClickListener) null).setOnDismissListener(new android.content.DialogInterface.OnDismissListener() { // from class: com.oplus.camera.ui.preview.a_renamed.q_renamed.4
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(android.content.DialogInterface dialogInterface) {
                com.oplus.camera.ui.preview.a_renamed.q_renamed.this.n_renamed = checkBox.isChecked();
            }
        }).setTitle(com.oplus.camera.R_renamed.string.sticker_consumption_networks_dialog).setView(viewInflate).create();
        com.oplus.camera.e_renamed.a_renamed("ImageStickerTools", "startDownloadFromDialog mWarningDialog created");
        if (activity.isFinishing()) {
            com.oplus.camera.e_renamed.a_renamed("ImageStickerTools", "startDownloadFromDialog activity isFinishing");
        } else {
            this.o_renamed.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d_renamed(com.oplus.camera.sticker.data.StickerItem stickerItem) {
        com.oplus.camera.e_renamed.a_renamed("ImageStickerTools", "startDownloadFromDialog");
        stickerItem.setDownloadState(2);
        com.oplus.camera.ui.preview.a_renamed.v_renamed vVar = this.h_renamed;
        if (vVar != null) {
            vVar.a_renamed(stickerItem);
        }
        com.oplus.camera.sticker.h_renamed.a_renamed(this.f6927c).a_renamed(stickerItem, true);
        e_renamed(stickerItem);
    }

    public static boolean b_renamed(com.oplus.camera.sticker.data.StickerItem stickerItem) {
        if (stickerItem != null) {
            return a_renamed(stickerItem.getMaterialType());
        }
        return false;
    }

    public static boolean c_renamed(com.oplus.camera.sticker.data.StickerItem stickerItem) {
        return stickerItem != null && stickerItem.getMaterialType() == 1;
    }

    /* compiled from: ImageStickerTools.java */
    public static class c_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        public java.util.concurrent.CopyOnWriteArrayList<com.oplus.camera.ui.preview.a_renamed.q_renamed.a_renamed> f6944a = new java.util.concurrent.CopyOnWriteArrayList<>();

        /* renamed from: b_renamed, reason: collision with root package name */
        public java.util.Map<java.lang.String, java.lang.Integer> f6945b = new java.util.HashMap();

        /* renamed from: c_renamed, reason: collision with root package name */
        public java.util.Map<java.lang.String, java.lang.Integer> f6946c = new java.util.HashMap();
        public java.util.ArrayList<com.oplus.camera.sticker.ui.h_renamed.b_renamed> d_renamed = new java.util.ArrayList<>();
        private java.lang.String e_renamed = null;

        public void a_renamed() {
            com.oplus.camera.e_renamed.a_renamed("ImageStickerTools", "recycle");
            this.f6944a.clear();
            this.f6945b.clear();
            this.f6946c.clear();
            this.d_renamed.clear();
        }

        public java.util.concurrent.CopyOnWriteArrayList<com.oplus.camera.sticker.data.StickerItem> a_renamed(java.lang.String str) {
            int iA = a_renamed(this.f6944a, str);
            if (iA >= 0) {
                return this.f6944a.get(iA).a_renamed();
            }
            return null;
        }

        public java.util.concurrent.CopyOnWriteArrayList<com.oplus.camera.ui.preview.a_renamed.q_renamed.a_renamed> b_renamed() {
            return this.f6944a;
        }

        public void a_renamed(java.lang.String str, java.util.concurrent.CopyOnWriteArrayList<com.oplus.camera.sticker.data.StickerItem> copyOnWriteArrayList) {
            com.oplus.camera.ui.preview.a_renamed.q_renamed.a_renamed aVar = new com.oplus.camera.ui.preview.a_renamed.q_renamed.a_renamed();
            aVar.a_renamed(str);
            aVar.a_renamed(copyOnWriteArrayList);
            this.f6944a.add(aVar);
        }

        public void a_renamed(java.util.ArrayList<com.oplus.camera.sticker.ui.h_renamed.b_renamed> arrayList) {
            this.d_renamed = arrayList;
        }

        public java.util.ArrayList<com.oplus.camera.sticker.ui.h_renamed.b_renamed> c_renamed() {
            return this.d_renamed;
        }

        public void b_renamed(java.lang.String str) {
            this.e_renamed = str;
        }

        public int d_renamed() {
            java.util.ArrayList<com.oplus.camera.sticker.ui.h_renamed.b_renamed> arrayList = this.d_renamed;
            if (arrayList == null) {
                return 1;
            }
            java.util.Iterator<com.oplus.camera.sticker.ui.h_renamed.b_renamed> it = arrayList.iterator();
            int i_renamed = 0;
            while (it.hasNext()) {
                if (it.next().f5556c.equals(this.e_renamed)) {
                    return i_renamed;
                }
                i_renamed++;
            }
            return 1;
        }

        public void a_renamed(java.lang.String str, int i_renamed) {
            this.f6945b.put(str, java.lang.Integer.valueOf(i_renamed));
        }

        public java.lang.Integer c_renamed(java.lang.String str) {
            return this.f6945b.get(str);
        }

        public boolean d_renamed(java.lang.String str) {
            return this.f6945b.get(str) != null;
        }

        public void b_renamed(java.lang.String str, int i_renamed) {
            this.f6946c.put(str, java.lang.Integer.valueOf(i_renamed));
        }

        public java.lang.Integer e_renamed(java.lang.String str) {
            java.lang.Integer num;
            synchronized (com.oplus.camera.ui.preview.a_renamed.q_renamed.f6926b) {
                num = this.f6946c.get(str);
            }
            return num;
        }

        public int a_renamed(java.util.concurrent.CopyOnWriteArrayList<com.oplus.camera.ui.preview.a_renamed.q_renamed.a_renamed> copyOnWriteArrayList, java.lang.String str) {
            if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty() || str == null) {
                return -1;
            }
            java.util.Iterator<com.oplus.camera.ui.preview.a_renamed.q_renamed.a_renamed> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                com.oplus.camera.ui.preview.a_renamed.q_renamed.a_renamed next = it.next();
                if (str.equals(next.b_renamed())) {
                    return copyOnWriteArrayList.indexOf(next);
                }
            }
            return -1;
        }
    }

    public void f_renamed() {
        if (this.j_renamed != null) {
            com.oplus.camera.e_renamed.b_renamed("ImageStickerTools", "requestSticker");
            this.j_renamed.c_renamed();
        }
    }

    private void e_renamed(com.oplus.camera.sticker.data.StickerItem stickerItem) {
        com.oplus.camera.e_renamed.b_renamed("ImageStickerTools", "startDownloadStickerNearme");
        if (this.k_renamed == null) {
            this.k_renamed = new java.util.HashMap<>();
        }
        com.oplus.camera.ui.preview.a_renamed.q_renamed.b_renamed bVar = new com.oplus.camera.ui.preview.a_renamed.q_renamed.b_renamed();
        bVar.f6943c = java.lang.System.currentTimeMillis();
        bVar.d_renamed = l_renamed();
        bVar.f6942b = stickerItem.getStickerUUID();
        bVar.e_renamed = stickerItem.getStickerName();
        bVar.f_renamed = stickerItem.getCategoryId();
        this.k_renamed.put(stickerItem.getStickerUUID(), bVar);
    }

    private int l_renamed() {
        if (com.oplus.util.OplusNetworkUtil.isWifiConnected(this.f6927c)) {
            return 1;
        }
        return com.oplus.util.OplusNetworkUtil.isMobileDataConnected(this.f6927c) ? 0 : -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(com.oplus.camera.ui.preview.a_renamed.q_renamed.b_renamed bVar, boolean z_renamed) {
        if (bVar == null) {
            return;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(com.oplus.camera.statistics.CameraStatisticsUtil.format(com.oplus.camera.statistics.CameraStatisticsUtil.STICKER_UUID, bVar.f6942b));
        sb.append(com.oplus.camera.statistics.CameraStatisticsUtil.format(com.oplus.camera.statistics.CameraStatisticsUtil.STICKER_TYPE, bVar.f_renamed));
        sb.append(com.oplus.camera.statistics.CameraStatisticsUtil.format(com.oplus.camera.statistics.CameraStatisticsUtil.STICKER_NAME, bVar.e_renamed));
        sb.append(com.oplus.camera.statistics.CameraStatisticsUtil.format(com.oplus.camera.statistics.CameraStatisticsUtil.STICKER_DOWNLOAD_RESULT, z_renamed ? "0" : "1"));
        sb.append(com.oplus.camera.statistics.CameraStatisticsUtil.format(com.oplus.camera.statistics.CameraStatisticsUtil.STICKER_NETWORK, java.lang.String.valueOf(bVar.d_renamed)));
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis() - bVar.f6943c;
        if (jCurrentTimeMillis > 0) {
            sb.append(com.oplus.camera.statistics.CameraStatisticsUtil.format(com.oplus.camera.statistics.CameraStatisticsUtil.STICKER_DOWNLOAD_COST_TIME, java.lang.String.valueOf(jCurrentTimeMillis)));
        }
        com.oplus.camera.statistics.CameraStatisticsUtil.onCommon(this.f6927c, "sticker_download", sb.toString());
        java.util.HashMap<java.lang.String, com.oplus.camera.ui.preview.a_renamed.q_renamed.b_renamed> map = this.k_renamed;
        if (map != null) {
            map.remove(bVar.f6942b);
        }
    }

    /* compiled from: ImageStickerTools.java */
    public static class a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        private java.util.concurrent.CopyOnWriteArrayList<com.oplus.camera.sticker.data.StickerItem> f6939a = null;

        /* renamed from: b_renamed, reason: collision with root package name */
        private java.lang.String f6940b = null;

        public void a_renamed(java.util.concurrent.CopyOnWriteArrayList<com.oplus.camera.sticker.data.StickerItem> copyOnWriteArrayList) {
            this.f6939a = copyOnWriteArrayList;
        }

        public void a_renamed(java.lang.String str) {
            this.f6940b = str;
        }

        public java.util.concurrent.CopyOnWriteArrayList<com.oplus.camera.sticker.data.StickerItem> a_renamed() {
            return this.f6939a;
        }

        public java.lang.String b_renamed() {
            return this.f6940b;
        }
    }

    /* compiled from: ImageStickerTools.java */
    private class b_renamed {

        /* renamed from: b_renamed, reason: collision with root package name */
        private java.lang.String f6942b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private long f6943c;
        private int d_renamed;
        private java.lang.String e_renamed;
        private java.lang.String f_renamed;

        private b_renamed() {
            this.f6942b = "";
            this.f6943c = 0L;
            this.d_renamed = -1;
            this.e_renamed = "";
            this.f_renamed = "";
        }
    }
}
