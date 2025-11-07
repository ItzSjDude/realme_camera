package com.oplus.camera.ui.control;

/* compiled from: Thumbnail.java */
/* loaded from: classes2.dex */
public class e_renamed {

    /* renamed from: b_renamed, reason: collision with root package name */
    private static com.oplus.camera.ui.control.e_renamed.d_renamed f6058b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private static com.oplus.camera.ui.control.e_renamed.d_renamed f6059c;
    private static com.oplus.camera.ui.control.e_renamed.d_renamed d_renamed;
    private static int f_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    public boolean f6060a;
    private android.net.Uri g_renamed;
    private java.lang.String h_renamed;
    private java.lang.String i_renamed;
    private long j_renamed;
    private android.graphics.Bitmap k_renamed;
    private android.graphics.Bitmap l_renamed;
    private boolean m_renamed;
    private boolean n_renamed;
    private long o_renamed;
    private com.oplus.camera.ui.control.e_renamed.d_renamed p_renamed;
    private static java.lang.Object e_renamed = new java.lang.Object();
    private static com.oplus.camera.jni.FormatConverter q_renamed = null;
    private static android.os.ConditionVariable r_renamed = new android.os.ConditionVariable(true);

    /* compiled from: Thumbnail.java */
    public interface a_renamed {
        void a_renamed(long j_renamed, long j2, byte[] bArr);
    }

    /* compiled from: Thumbnail.java */
    public interface b_renamed {
        void a_renamed(com.oplus.camera.ui.control.e_renamed eVar);
    }

    /* compiled from: Thumbnail.java */
    public interface c_renamed {
        void a_renamed(long j_renamed);
    }

    public static void a_renamed() {
        q_renamed = new com.oplus.camera.jni.FormatConverter();
    }

    public e_renamed() {
        this.f6060a = false;
        this.g_renamed = null;
        this.h_renamed = null;
        this.i_renamed = null;
        this.j_renamed = 0L;
        this.k_renamed = null;
        this.l_renamed = null;
        this.m_renamed = false;
        this.n_renamed = false;
        this.o_renamed = 0L;
        this.p_renamed = null;
    }

    public e_renamed(android.graphics.Bitmap bitmap) {
        this.f6060a = false;
        this.g_renamed = null;
        this.h_renamed = null;
        this.i_renamed = null;
        this.j_renamed = 0L;
        this.k_renamed = null;
        this.l_renamed = null;
        this.m_renamed = false;
        this.n_renamed = false;
        this.o_renamed = 0L;
        this.p_renamed = null;
        this.k_renamed = bitmap;
    }

    public e_renamed(android.graphics.Bitmap bitmap, long j_renamed, long j2) {
        this.f6060a = false;
        this.g_renamed = null;
        this.h_renamed = null;
        this.i_renamed = null;
        this.j_renamed = 0L;
        this.k_renamed = null;
        this.l_renamed = null;
        this.m_renamed = false;
        this.n_renamed = false;
        this.o_renamed = 0L;
        this.p_renamed = null;
        this.i_renamed = null;
        this.j_renamed = j2;
        this.g_renamed = null;
        this.o_renamed = j_renamed;
        this.k_renamed = bitmap;
    }

    private e_renamed(android.net.Uri uri, android.graphics.Bitmap bitmap, int i_renamed, java.lang.String str, long j_renamed) {
        this.f6060a = false;
        this.g_renamed = null;
        this.h_renamed = null;
        this.i_renamed = null;
        this.j_renamed = 0L;
        this.k_renamed = null;
        this.l_renamed = null;
        this.m_renamed = false;
        this.n_renamed = false;
        this.o_renamed = 0L;
        this.p_renamed = null;
        this.g_renamed = uri;
        this.i_renamed = str;
        this.j_renamed = j_renamed;
        if (bitmap != null) {
            this.k_renamed = a_renamed(bitmap, i_renamed);
            if (uri != null) {
                a_renamed(b_renamed(this.k_renamed, com.oplus.camera.ui.control.ThumbImageView.f6022a), uri.toString(), (long) java.lang.Math.ceil(j_renamed / 1000.0d), i_renamed);
                return;
            }
            return;
        }
        com.oplus.camera.e_renamed.a_renamed("Thumbnail", "Thumbnail, mUri: " + this.g_renamed + ", thumbnail bitmap is_renamed null...");
        this.k_renamed = bitmap;
    }

    public long b_renamed() {
        return this.o_renamed;
    }

    public void a_renamed(long j_renamed) {
        this.o_renamed = j_renamed;
    }

    public static android.graphics.Bitmap a_renamed(android.graphics.Bitmap bitmap, int i_renamed) {
        com.oplus.camera.e_renamed.a_renamed("Thumbnail", "rotateImage");
        if (i_renamed != 0) {
            android.graphics.Matrix matrix = new android.graphics.Matrix();
            matrix.setRotate(i_renamed, bitmap.getWidth() * 0.5f, bitmap.getHeight() * 0.5f);
            try {
                android.graphics.Bitmap bitmapA = com.oplus.camera.util.Util.a_renamed(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                if (bitmapA != bitmap) {
                    bitmap.recycle();
                }
                return bitmapA;
            } catch (java.lang.Throwable th) {
                com.oplus.camera.e_renamed.c_renamed("Thumbnail", "Failed to rotate thumbnail", th);
            }
        }
        return bitmap;
    }

    /* JADX WARN: Can't_renamed fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as_renamed a_renamed decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B_renamed:25:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int m_renamed() {
        /*
            com.oplus.camera.ui.control.e_renamed$d_renamed r0 = com.oplus.camera.ui.control.e_renamed.d_renamed
            r1 = 0
            r2 = -1
            r3 = 1
            if (r0 == 0) goto L67
            java.lang.String r0 = r0.h_renamed
            int r4 = r0.hashCode()
            r5 = 5
            r6 = 4
            r7 = 3
            r8 = 2
            switch(r4) {
                case -1487464693: goto L47;
                case -1487394660: goto L3d;
                case -1423313290: goto L33;
                case -879258763: goto L29;
                case 1331792072: goto L1f;
                case 1331848029: goto L15;
                default: goto L14;
            }
        L14:
            goto L51
        L15:
            java.lang.String r4 = "video/mp4"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L51
            r0 = r6
            goto L52
        L1f:
            java.lang.String r4 = "video/3gp"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L51
            r0 = r5
            goto L52
        L29:
            java.lang.String r4 = "image/png"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L51
            r0 = r8
            goto L52
        L33:
            java.lang.String r4 = "image/x_renamed-adobe-dng"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L51
            r0 = r7
            goto L52
        L3d:
            java.lang.String r4 = "image/jpeg"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L51
            r0 = r1
            goto L52
        L47:
            java.lang.String r4 = "image/heic"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L51
            r0 = r3
            goto L52
        L51:
            r0 = r2
        L52:
            if (r0 == 0) goto L64
            if (r0 == r3) goto L64
            if (r0 == r8) goto L64
            if (r0 == r7) goto L64
            if (r0 == r6) goto L61
            if (r0 == r5) goto L61
            com.oplus.camera.ui.control.e_renamed.f_renamed = r2
            goto L91
        L61:
            com.oplus.camera.ui.control.e_renamed.f_renamed = r3
            goto L91
        L64:
            com.oplus.camera.ui.control.e_renamed.f_renamed = r1
            goto L91
        L67:
            com.oplus.camera.ui.control.e_renamed$d_renamed r0 = com.oplus.camera.ui.control.e_renamed.f6058b
            r4 = 0
            if (r0 == 0) goto L70
            long r6 = r0.f6063c
            goto L71
        L70:
            r6 = r4
        L71:
            com.oplus.camera.ui.control.e_renamed$d_renamed r0 = com.oplus.camera.ui.control.e_renamed.f6059c
            if (r0 == 0) goto L78
            long r8 = r0.f6063c
            goto L79
        L78:
            r8 = r4
        L79:
            int r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r0 < 0) goto L84
            int r0 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r0 <= 0) goto L84
            com.oplus.camera.ui.control.e_renamed.f_renamed = r1
            goto L91
        L84:
            int r0 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r0 <= 0) goto L8f
            int r0 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r0 <= 0) goto L8f
            com.oplus.camera.ui.control.e_renamed.f_renamed = r3
            goto L91
        L8f:
            com.oplus.camera.ui.control.e_renamed.f_renamed = r2
        L91:
            int r0 = com.oplus.camera.ui.control.e_renamed.f_renamed
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.ui.control.e_renamed.m_renamed():int");
    }

    public static int a_renamed(android.content.ContentResolver contentResolver, com.oplus.camera.ui.control.e_renamed eVar, boolean z_renamed) throws java.lang.Throwable {
        int iM;
        android.graphics.Bitmap bitmapA;
        com.oplus.camera.ui.control.e_renamed.d_renamed dVarA;
        android.graphics.Bitmap bitmapLoadThumbnail;
        android.graphics.Bitmap bitmapC;
        android.net.Uri uriC = com.oplus.camera.Storage.c_renamed(z_renamed);
        android.net.Uri uriD = com.oplus.camera.Storage.d_renamed(z_renamed);
        com.oplus.camera.e_renamed.a_renamed("Thumbnail", "getLastThumbnailFromContentResolver, sdCard: " + z_renamed);
        com.oplus.camera.ui.control.e_renamed.d_renamed dVar = eVar.p_renamed;
        if (dVar != null && -1 != dVar.k_renamed) {
            iM = eVar.p_renamed.k_renamed;
            bitmapA = eVar.p_renamed.m_renamed;
            d_renamed = null;
            if (eVar.p_renamed.k_renamed == 0) {
                f6058b = a_renamed(contentResolver, uriC);
            } else if (1 == eVar.p_renamed.k_renamed) {
                f6059c = a_renamed(contentResolver, uriD, eVar.p_renamed.d_renamed);
            }
        } else {
            d_renamed = a_renamed(contentResolver);
            com.oplus.camera.e_renamed.b_renamed("Thumbnail", "getLastThumbnailFromContentResolver, getLatestMediaItem: " + d_renamed);
            if (d_renamed == null) {
                f6058b = null;
                f6059c = null;
            }
            iM = -1;
            bitmapA = null;
        }
        if (d_renamed == null && f6058b == null && f6059c == null) {
            com.oplus.camera.e_renamed.a_renamed("Thumbnail", "getLastThumbnailFromContentResolver, image: " + f6058b + ", video: " + f6059c);
            return 0;
        }
        if (-1 == iM) {
            iM = m_renamed();
        }
        com.oplus.camera.e_renamed.b_renamed("Thumbnail", "getLastThumbnailFromContentResolver, latestFileType: " + iM);
        if (-1 == iM) {
            return 0;
        }
        if (iM == 0) {
            dVarA = d_renamed;
            if (dVarA == null) {
                dVarA = f6058b;
            }
            dVarA.d_renamed = android.content.ContentUris.withAppendedId(uriC, dVarA.f6061a);
            if (com.oplus.camera.util.Util.a_renamed(dVarA.d_renamed, dVarA.g_renamed, dVarA.i_renamed, dVarA.j_renamed)) {
                com.oplus.camera.e_renamed.a_renamed("Thumbnail", "getLastThumbnailFromContentResolver, uri: " + dVarA.d_renamed + ", path: " + dVarA.g_renamed + ", width: " + dVarA.i_renamed + ", height: " + dVarA.j_renamed);
                if (com.oplus.camera.Storage.c_renamed()) {
                    bitmapC = com.oplus.camera.util.n_renamed.a_renamed().e_renamed(dVarA.f_renamed);
                } else {
                    bitmapC = com.oplus.camera.util.n_renamed.a_renamed().c_renamed(dVarA.f_renamed);
                }
                bitmapA = b_renamed(bitmapC, com.oplus.camera.ui.control.ThumbImageView.f6022a);
                if (bitmapA == null && (dVarA = a_renamed(contentResolver, uriC)) == null) {
                    com.oplus.camera.e_renamed.a_renamed("Thumbnail", "getLastThumbnailFromContentResolver, sImage null");
                    return 0;
                }
            }
            if (bitmapA == null) {
                try {
                    if (dVarA.n_renamed) {
                        com.oplus.camera.aps.service.ThumbnailProcessor.THUMBNAIL_URI_CREATING_VARIABLE.block(1000L);
                    }
                    bitmapA = a_renamed(dVarA, false);
                    com.oplus.camera.e_renamed.f_renamed("Thumbnail", "getLastThumbnailFromContentResolver, getBitmapFromCache: " + bitmapA);
                    if (bitmapA == null) {
                        bitmapA = a_renamed(contentResolver, dVarA);
                    }
                } catch (java.lang.Exception e2) {
                    e2.printStackTrace();
                }
            }
            if (bitmapA == null) {
                com.oplus.camera.e_renamed.f_renamed("Thumbnail", "getLastThumbnailFromContentResolver, bitmap null");
                java.lang.String[] strArrSplit = dVarA.g_renamed.split("\\.");
                if (strArrSplit != null && strArrSplit.length > 0 && "jpg".equals(strArrSplit[strArrSplit.length - 1])) {
                    try {
                        contentResolver.delete(dVarA.d_renamed, null, null);
                        com.oplus.camera.e_renamed.a_renamed("Thumbnail", "getLastThumbnailFromContentResolver, delete image: " + dVarA.d_renamed);
                    } catch (java.lang.Exception unused) {
                        com.oplus.camera.e_renamed.f_renamed("Thumbnail", "getLastThumbnailFromContentResolver, Failed to delete image: " + dVarA.d_renamed);
                    }
                }
                return 0;
            }
            a_renamed(bitmapA, dVarA.d_renamed.toString(), dVarA.l_renamed, dVarA.f6062b);
        } else if (1 == iM) {
            dVarA = d_renamed;
            if (dVarA == null) {
                dVarA = f6059c;
            }
            dVarA.d_renamed = android.content.ContentUris.withAppendedId(uriD, dVarA.f6061a);
            if (bitmapA == null) {
                try {
                    bitmapA = a_renamed(dVarA, true);
                    com.oplus.camera.e_renamed.f_renamed("Thumbnail", "getLastThumbnailFromContentResolver, getBitmapFromCache: " + bitmapA);
                } catch (java.lang.Exception e3) {
                    e3.printStackTrace();
                    return 0;
                }
            }
            if (bitmapA == null) {
                android.os.CancellationSignal cancellationSignal = new android.os.CancellationSignal();
                if (29 <= android.os.Build.VERSION.SDK_INT) {
                    com.oplus.camera.e_renamed.a_renamed("Thumbnail", "getThumbnailBitmapFromUri, media.mWidth: " + dVarA.i_renamed + "media.mHeight: " + dVarA.j_renamed);
                    if (dVarA.i_renamed > dVarA.j_renamed) {
                        bitmapLoadThumbnail = contentResolver.loadThumbnail(dVarA.d_renamed, new android.util.Size((dVarA.i_renamed / dVarA.j_renamed) * com.oplus.camera.ui.control.ThumbImageView.f6022a, com.oplus.camera.ui.control.ThumbImageView.f6022a), cancellationSignal);
                    } else if (dVarA.i_renamed < dVarA.j_renamed) {
                        bitmapLoadThumbnail = contentResolver.loadThumbnail(dVarA.d_renamed, new android.util.Size(com.oplus.camera.ui.control.ThumbImageView.f6022a, (dVarA.j_renamed / dVarA.i_renamed) * com.oplus.camera.ui.control.ThumbImageView.f6022a), cancellationSignal);
                    } else {
                        bitmapLoadThumbnail = contentResolver.loadThumbnail(dVarA.d_renamed, new android.util.Size(com.oplus.camera.ui.control.ThumbImageView.f6022a, com.oplus.camera.ui.control.ThumbImageView.f6022a), cancellationSignal);
                    }
                    bitmapA = b_renamed(bitmapLoadThumbnail, com.oplus.camera.ui.control.ThumbImageView.f6022a);
                }
            }
            if (bitmapA != null) {
                a_renamed(bitmapA, dVarA.d_renamed.toString(), dVarA.l_renamed, dVarA.f6062b);
            }
        } else {
            dVarA = null;
        }
        if (dVarA != null) {
            com.oplus.camera.e_renamed.a_renamed("Thumbnail", "getLastThumbnailFromContentResolver, thumbnail uri: " + dVarA.d_renamed);
        }
        if (dVarA != null && (com.oplus.camera.util.Util.a_renamed(dVarA.d_renamed, dVarA.g_renamed, dVarA.i_renamed, dVarA.j_renamed) || com.oplus.camera.util.Util.a_renamed(dVarA.d_renamed, contentResolver))) {
            eVar.g_renamed = dVarA.d_renamed;
            eVar.i_renamed = dVarA.e_renamed;
            eVar.j_renamed = dVarA.f6063c;
            eVar.h_renamed = dVarA.h_renamed;
            if (bitmapA != null) {
                if (29 <= android.os.Build.VERSION.SDK_INT && !"image/x_renamed-adobe-dng".equals(eVar.h_renamed)) {
                    eVar.k_renamed = bitmapA;
                } else {
                    eVar.k_renamed = a_renamed(bitmapA, dVarA.f6062b);
                }
            } else {
                com.oplus.camera.e_renamed.a_renamed("Thumbnail", "getLastThumbnailFromContentResolver, bitmap is_renamed null, mUri: " + eVar.g_renamed);
                eVar.k_renamed = null;
            }
            return 1;
        }
        com.oplus.camera.e_renamed.a_renamed("Thumbnail", "getLastThumbnailFromContentResolver, THUMBNAIL_DELETED");
        return 2;
    }

    private static void a_renamed(android.graphics.Bitmap bitmap, java.lang.String str, long j_renamed, int i_renamed) {
        com.oplus.camera.util.n_renamed.b_renamed bVarB = com.oplus.camera.util.n_renamed.a_renamed().b_renamed(str);
        if (bVarB == null || j_renamed != bVarB.b_renamed() || i_renamed != bVarB.b_renamed()) {
            com.oplus.camera.util.n_renamed.b_renamed bVar = new com.oplus.camera.util.n_renamed.b_renamed();
            bVar.a_renamed(j_renamed);
            bVar.a_renamed(i_renamed);
            bVar.a_renamed(bitmap.copy(android.graphics.Bitmap.Config.ARGB_8888, true));
            com.oplus.camera.util.n_renamed.a_renamed().a_renamed(str, bVar);
        }
        com.oplus.camera.e_renamed.a_renamed("Thumbnail", "cacheThumbnail, uri: " + str + ", bitmap width: " + bitmap.getWidth() + ", height: " + bitmap.getHeight() + ", dateModified: " + j_renamed + ", orientation: " + i_renamed);
    }

    private static android.graphics.Bitmap a_renamed(com.oplus.camera.ui.control.e_renamed.d_renamed dVar, boolean z_renamed) {
        java.lang.String str;
        android.graphics.Bitmap bitmapC;
        java.lang.String string = dVar.d_renamed.toString();
        com.oplus.camera.util.n_renamed.b_renamed bVarB = com.oplus.camera.util.n_renamed.a_renamed().b_renamed(string);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("getBitmapFromCache, uri: ");
        sb.append(string);
        if (bVarB != null) {
            str = ", thumbnailCacheData.modified: " + bVarB.b_renamed() + ", thumbnailCacheData.orientation: " + bVarB.a_renamed() + ", lastMediaInfo.modified: " + dVar.l_renamed + ", lastMediaInfo.Orientation: " + dVar.f6062b + ", lastMediaInfo.mbIsPending: " + dVar.n_renamed;
        } else {
            str = ", thumbnailCacheData is_renamed null.";
        }
        sb.append(str);
        com.oplus.camera.e_renamed.b_renamed("Thumbnail", sb.toString());
        if (bVarB == null) {
            return null;
        }
        if ((!z_renamed && !dVar.n_renamed && (dVar.l_renamed != bVarB.b_renamed() || dVar.f6062b != bVarB.a_renamed())) || (bitmapC = bVarB.c_renamed()) == null || bitmapC.isRecycled()) {
            return null;
        }
        return bitmapC.copy(android.graphics.Bitmap.Config.ARGB_8888, true);
    }

    public static android.graphics.Bitmap a_renamed(android.content.ContentResolver contentResolver, com.oplus.camera.ui.control.e_renamed.d_renamed dVar) {
        if (29 <= android.os.Build.VERSION.SDK_INT) {
            return a_renamed(contentResolver, dVar.d_renamed, dVar);
        }
        return a_renamed(dVar.e_renamed);
    }

    private static android.graphics.Bitmap a_renamed(android.content.ContentResolver contentResolver, android.net.Uri uri, com.oplus.camera.ui.control.e_renamed.d_renamed dVar) throws java.io.IOException {
        android.graphics.Bitmap bitmapLoadThumbnail;
        if (uri == null) {
            com.oplus.camera.e_renamed.f_renamed("Thumbnail", "getThumbnailBitmapFromUri, uri: null");
            return null;
        }
        android.os.CancellationSignal cancellationSignal = new android.os.CancellationSignal();
        try {
            if (29 <= android.os.Build.VERSION.SDK_INT) {
                com.oplus.camera.e_renamed.f_renamed("Thumbnail", "getThumbnailBitmapFromUri, media.mWidth: " + dVar.i_renamed + "media.mHeight: " + dVar.j_renamed);
                if (dVar.i_renamed > dVar.j_renamed) {
                    bitmapLoadThumbnail = contentResolver.loadThumbnail(uri, new android.util.Size((dVar.i_renamed / dVar.j_renamed) * com.oplus.camera.ui.control.ThumbImageView.f6022a, com.oplus.camera.ui.control.ThumbImageView.f6022a), cancellationSignal);
                } else if (dVar.i_renamed < dVar.j_renamed) {
                    bitmapLoadThumbnail = contentResolver.loadThumbnail(uri, new android.util.Size(com.oplus.camera.ui.control.ThumbImageView.f6022a, (dVar.j_renamed / dVar.i_renamed) * com.oplus.camera.ui.control.ThumbImageView.f6022a), cancellationSignal);
                } else {
                    bitmapLoadThumbnail = contentResolver.loadThumbnail(uri, new android.util.Size(com.oplus.camera.ui.control.ThumbImageView.f6022a, com.oplus.camera.ui.control.ThumbImageView.f6022a), cancellationSignal);
                }
                return b_renamed(bitmapLoadThumbnail, com.oplus.camera.ui.control.ThumbImageView.f6022a);
            }
        } catch (java.io.IOException e2) {
            e2.printStackTrace();
        }
        return null;
    }

    private static android.graphics.Bitmap a_renamed(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        android.graphics.BitmapFactory.decodeFile(str, options);
        options.inPreferredConfig = android.graphics.Bitmap.Config.RGB_565;
        options.inJustDecodeBounds = false;
        if (options.outWidth / 4 >= com.oplus.camera.ui.control.ThumbImageView.f6022a && options.outHeight / 4 >= com.oplus.camera.ui.control.ThumbImageView.f6022a) {
            options.outHeight /= 4;
            options.outWidth /= 4;
            options.inSampleSize = 4;
        }
        return b_renamed(android.graphics.BitmapFactory.decodeFile(str, options), com.oplus.camera.ui.control.ThumbImageView.f6022a);
    }

    public static android.graphics.Bitmap b_renamed(android.graphics.Bitmap bitmap, int i_renamed) {
        int i2;
        if (bitmap == null) {
            return null;
        }
        int i3 = 2;
        if (android.graphics.Bitmap.Config.RGB_565 == bitmap.getConfig()) {
            i2 = 2;
        } else {
            i2 = android.graphics.Bitmap.Config.RGBA_F16 == bitmap.getConfig() ? 5 : 0;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int iMin = java.lang.Math.min(width, height);
        com.oplus.camera.e_renamed.f_renamed("Thumbnail", "getThumbnailBitmapFromUri, width: " + width + ", height: " + height + ", channelType: " + i2);
        if (iMin <= i_renamed) {
            return bitmap;
        }
        android.graphics.Bitmap.Config config = android.graphics.Bitmap.Config.ARGB_8888;
        if (2 == i2) {
            config = android.graphics.Bitmap.Config.RGB_565;
        } else if (5 == i2) {
            i3 = 8;
            config = android.graphics.Bitmap.Config.RGBA_F16;
        } else {
            i3 = 4;
        }
        float f2 = i_renamed / iMin;
        int iRound = java.lang.Math.round(width * f2);
        int iRound2 = java.lang.Math.round(f2 * height);
        android.graphics.Bitmap bitmapA = com.oplus.camera.util.Util.a_renamed(iRound, iRound2, config);
        com.oplus.camera.jni.FormatConverter formatConverter = q_renamed;
        if (formatConverter != null) {
            formatConverter.scaleArea(bitmap, width * i3, width, height, bitmapA, iRound * i3, iRound, iRound2, i2);
            return bitmapA;
        }
        com.oplus.camera.e_renamed.f_renamed("Thumbnail", "getNoMoireThumbnailBitmap, sFormatConverter: null");
        return bitmapA;
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:27:0x0173 A_renamed[Catch: all -> 0x016a, Exception -> 0x016d, TRY_ENTER, TryCatch #5 {Exception -> 0x016d, all -> 0x016a, blocks: (B_renamed:12:0x00db, B_renamed:14:0x00e1, B_renamed:18:0x015d, B_renamed:27:0x0173, B_renamed:28:0x0176), top: B_renamed:66:0x00db }] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:45:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:52:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:64:0x0185 A_renamed[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:67:? A_renamed[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:69:? A_renamed[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static com.oplus.camera.ui.control.e_renamed.d_renamed a_renamed(android.content.ContentResolver r34, android.net.Uri r35) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 585
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.ui.control.e_renamed.a_renamed(android.content.ContentResolver, android.net.Uri):com.oplus.camera.ui.control.e_renamed$d_renamed");
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:27:0x0179 A_renamed[Catch: all -> 0x0170, Exception -> 0x0173, TRY_ENTER, TryCatch #7 {Exception -> 0x0173, all -> 0x0170, blocks: (B_renamed:12:0x00e3, B_renamed:14:0x00e9, B_renamed:18:0x0163, B_renamed:27:0x0179, B_renamed:28:0x017c), top: B_renamed:62:0x00e3 }] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:45:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:52:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:65:0x0188 A_renamed[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:67:? A_renamed[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:69:? A_renamed[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static com.oplus.camera.ui.control.e_renamed.d_renamed a_renamed(android.content.ContentResolver r33) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 589
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.ui.control.e_renamed.a_renamed(android.content.ContentResolver):com.oplus.camera.ui.control.e_renamed$d_renamed");
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:29:0x0105 A_renamed[PHI: r2
      0x0105: PHI (r2v12 android.database.Cursor) = (r2v11 android.database.Cursor), (r2v13 android.database.Cursor) binds: [B_renamed:35:0x0113, B_renamed:28:0x0103] A_renamed[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:39:0x0119  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static com.oplus.camera.ui.control.e_renamed.d_renamed a_renamed(android.content.ContentResolver r29, android.net.Uri r30, android.net.Uri r31) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 285
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.ui.control.e_renamed.a_renamed(android.content.ContentResolver, android.net.Uri, android.net.Uri):com.oplus.camera.ui.control.e_renamed$d_renamed");
    }

    public static com.oplus.camera.ui.control.e_renamed a_renamed(android.graphics.Bitmap bitmap, int i_renamed, int i2, android.net.Uri uri, java.lang.String str, long j_renamed) {
        if (bitmap == null) {
            com.oplus.camera.e_renamed.a_renamed("Thumbnail", "createThumbnail(), use data cereate bitmap is_renamed null... ");
            return null;
        }
        return a_renamed(uri, bitmap, i_renamed, str, j_renamed);
    }

    public static com.oplus.camera.ui.control.e_renamed a_renamed(byte[] bArr, int i_renamed, int i2, android.net.Uri uri, java.lang.String str, long j_renamed) {
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        if (i2 > 4) {
            i2 = 4;
        }
        options.inSampleSize = i2;
        return a_renamed(uri, b_renamed(android.graphics.BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options), com.oplus.camera.ui.control.ThumbImageView.f6022a), i_renamed, str, j_renamed);
    }

    public static android.graphics.Bitmap a_renamed(java.io.FileDescriptor fileDescriptor, int i_renamed) {
        return a_renamed((java.lang.String) null, fileDescriptor, i_renamed);
    }

    public static android.graphics.Bitmap a_renamed(java.lang.String str, int i_renamed) {
        return a_renamed(str, (java.io.FileDescriptor) null, i_renamed);
    }

    private static android.graphics.Bitmap a_renamed(java.lang.String str, java.io.FileDescriptor fileDescriptor, int i_renamed) throws java.io.IOException {
        android.graphics.Bitmap frameAtTime;
        r_renamed.block();
        android.media.MediaMetadataRetriever mediaMetadataRetriever = new android.media.MediaMetadataRetriever();
        try {
            try {
                if (str != null) {
                    mediaMetadataRetriever.setDataSource(str);
                } else {
                    mediaMetadataRetriever.setDataSource(fileDescriptor);
                }
                frameAtTime = mediaMetadataRetriever.getFrameAtTime(-1L);
                try {
                    mediaMetadataRetriever.release();
                } catch (java.lang.RuntimeException unused) {
                }
            } catch (java.lang.RuntimeException unused2) {
                frameAtTime = null;
                return b_renamed(frameAtTime, i_renamed);
            }
        } catch (java.lang.IllegalArgumentException | java.lang.RuntimeException unused3) {
            mediaMetadataRetriever.release();
            frameAtTime = null;
            return b_renamed(frameAtTime, i_renamed);
        } catch (java.lang.Throwable th) {
            try {
                mediaMetadataRetriever.release();
            } catch (java.lang.RuntimeException unused4) {
            }
            throw th;
        }
        return b_renamed(frameAtTime, i_renamed);
    }

    public static void c_renamed() {
        com.oplus.camera.e_renamed.c_renamed("Thumbnail", "closeMediaLimitCondition");
        r_renamed.close();
    }

    public static void d_renamed() {
        com.oplus.camera.e_renamed.c_renamed("Thumbnail", "openMediaLimitCondition");
        r_renamed.open();
    }

    public static com.oplus.camera.ui.control.e_renamed a_renamed(android.net.Uri uri, android.graphics.Bitmap bitmap, int i_renamed, java.lang.String str, long j_renamed) {
        com.oplus.camera.e_renamed.f_renamed("Thumbnail", "createThumbnail, uri: " + uri);
        return new com.oplus.camera.ui.control.e_renamed(uri, bitmap, i_renamed, str, j_renamed);
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:25:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.oplus.camera.ui.control.e_renamed a_renamed(android.hardware.HardwareBuffer r21, int r22, int r23, int r24, int r25, boolean r26) {
        /*
            r2 = r22
            r3 = r23
            r0 = r24
            r1 = r25
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "createThumbnail start, width: "
            r4.append(r5)
            r4.append(r2)
            java.lang.String r5 = ", height: "
            r4.append(r5)
            r4.append(r3)
            java.lang.String r5 = ", rotate: "
            r4.append(r5)
            r4.append(r1)
            java.lang.String r4 = r4.toString()
            java.lang.String r12 = "Thumbnail"
            com.oplus.camera.e_renamed.a_renamed(r12, r4)
            if (r0 == 0) goto L3a
            if (r2 >= r3) goto L34
            r4 = r2
            goto L35
        L34:
            r4 = r3
        L35:
            float r4 = (float) r4
            float r0 = (float) r0
            float r4 = r4 / r0
            r6 = r4
            goto L3c
        L3a:
            r0 = 0
            r6 = r0
        L3c:
            r0 = 270(0x10e, float:3.78E-43)
            r4 = 90
            if (r1 == r4) goto L4a
            if (r1 != r0) goto L45
            goto L4a
        L45:
            float r5 = (float) r2
            float r5 = r5 / r6
            int r5 = (int) r5
            float r7 = (float) r3
            goto L4e
        L4a:
            float r5 = (float) r3
            float r5 = r5 / r6
            int r5 = (int) r5
            float r7 = (float) r2
        L4e:
            float r7 = r7 / r6
            int r7 = (int) r7
            r14 = r5
            r5 = r7
            if (r1 == 0) goto L63
            if (r1 == r4) goto L61
            r4 = 180(0xb4, float:2.52E-43)
            if (r1 == r4) goto L5f
            if (r1 == r0) goto L5d
            goto L63
        L5d:
            r0 = 3
            goto L64
        L5f:
            r0 = 2
            goto L64
        L61:
            r0 = 1
            goto L64
        L63:
            r0 = 0
        L64:
            r8 = r0
            android.graphics.Bitmap$Config r0 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r20 = com.oplus.camera.util.Util.a_renamed(r14, r5, r0)
            com.oplus.camera.jni.FormatConverter r15 = new com.oplus.camera.jni.FormatConverter
            r15.<init>()
            r7 = 1
            r9 = 0
            r10 = 0
            r11 = 2
            r0 = r15
            r1 = r21
            r2 = r22
            r3 = r23
            r4 = r14
            long r0 = r0.nv21ToBitmapInitWithHardwareBuffer(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r17 = 0
            r13 = r15
            r5 = r14
            r2 = r15
            r14 = r0
            r16 = r21
            r18 = r20
            r19 = r5
            r13.hardwareBufferToBitmapProcess(r14, r16, r17, r18, r19)
            r2.nv21ToBitmapUnInit(r0)
            if (r26 == 0) goto L98
            android.graphics.Bitmap r20 = com.oplus.camera.util.Util.c_renamed(r20)
        L98:
            r0 = r20
            java.lang.String r1 = "createThumbnail end"
            com.oplus.camera.e_renamed.a_renamed(r12, r1)
            com.oplus.camera.ui.control.e_renamed r1 = new com.oplus.camera.ui.control.e_renamed
            r1.<init>(r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.ui.control.e_renamed.a_renamed(android.hardware.HardwareBuffer, int, int, int, int, boolean):com.oplus.camera.ui.control.e_renamed");
    }

    public static android.graphics.Bitmap a_renamed(android.graphics.Bitmap bitmap, int i_renamed, int i2, boolean z_renamed) {
        if (bitmap == null) {
            return null;
        }
        android.graphics.Bitmap bitmapA = com.oplus.camera.util.Util.a_renamed(bitmap.getWidth(), bitmap.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
        android.graphics.Canvas canvas = new android.graphics.Canvas(bitmapA);
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        android.graphics.Paint paint = new android.graphics.Paint();
        android.graphics.Rect rect = new android.graphics.Rect(0, 0, width, height);
        android.graphics.RectF rectF = new android.graphics.RectF(rect);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-12434878);
        float f2 = i_renamed;
        canvas.drawRoundRect(rectF, f2, f2, paint);
        paint.setXfermode(new android.graphics.PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        if (z_renamed) {
            android.graphics.Paint paint2 = new android.graphics.Paint();
            paint2.setColor(452984831);
            paint2.setStrokeWidth(i2);
            paint2.setStyle(android.graphics.Paint.Style.STROKE);
            paint2.setAntiAlias(true);
            canvas.drawCircle(width / 2, height / 2, i_renamed - (i2 / 2), paint2);
        }
        return bitmapA;
    }

    public android.net.Uri e_renamed() {
        return this.g_renamed;
    }

    public java.lang.String f_renamed() {
        return this.i_renamed;
    }

    public long g_renamed() {
        return this.j_renamed;
    }

    public android.graphics.Bitmap h_renamed() {
        return this.k_renamed;
    }

    public android.graphics.Bitmap i_renamed() {
        return this.l_renamed;
    }

    public void a_renamed(android.graphics.Bitmap bitmap) {
        this.l_renamed = bitmap;
    }

    public boolean j_renamed() {
        return this.m_renamed;
    }

    public void a_renamed(boolean z_renamed) {
        this.m_renamed = z_renamed;
    }

    public void k_renamed() {
        android.graphics.Bitmap bitmap = this.k_renamed;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.k_renamed.recycle();
        }
        this.k_renamed = null;
        this.g_renamed = null;
    }

    public java.lang.String l_renamed() {
        return this.h_renamed;
    }

    public void a_renamed(com.oplus.camera.ui.control.e_renamed.d_renamed dVar) {
        this.p_renamed = dVar;
    }

    /* compiled from: Thumbnail.java */
    public static class d_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        public long f6061a;

        /* renamed from: b_renamed, reason: collision with root package name */
        public int f6062b;

        /* renamed from: c_renamed, reason: collision with root package name */
        public long f6063c;
        public android.net.Uri d_renamed;
        public java.lang.String e_renamed;
        public java.lang.String f_renamed;
        public java.lang.String g_renamed;
        public java.lang.String h_renamed;
        public int i_renamed;
        public int j_renamed;
        public int k_renamed;
        public long l_renamed;
        public android.graphics.Bitmap m_renamed;
        public boolean n_renamed;

        public d_renamed() {
            this.i_renamed = 0;
            this.j_renamed = 0;
            this.k_renamed = -1;
            this.m_renamed = null;
            this.n_renamed = false;
        }

        public d_renamed(long j_renamed, int i_renamed, long j2, android.net.Uri uri, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, int i2, int i3) {
            this.i_renamed = 0;
            this.j_renamed = 0;
            this.k_renamed = -1;
            this.m_renamed = null;
            this.n_renamed = false;
            this.f6061a = j_renamed;
            this.f6062b = i_renamed;
            this.f6063c = j2;
            this.d_renamed = uri;
            this.e_renamed = str;
            this.f_renamed = str2;
            this.g_renamed = str3;
            this.i_renamed = i2;
            this.j_renamed = i3;
            this.h_renamed = str4;
        }

        public d_renamed(long j_renamed, int i_renamed, long j2, android.net.Uri uri, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, int i2, int i3, long j3, boolean z_renamed) {
            this.i_renamed = 0;
            this.j_renamed = 0;
            this.k_renamed = -1;
            this.m_renamed = null;
            this.n_renamed = false;
            this.f6061a = j_renamed;
            this.f6062b = i_renamed;
            this.f6063c = j2;
            this.d_renamed = uri;
            this.e_renamed = str;
            this.f_renamed = str2;
            this.g_renamed = str3;
            this.i_renamed = i2;
            this.j_renamed = i3;
            this.h_renamed = str4;
            this.l_renamed = j3;
            this.n_renamed = z_renamed;
        }

        public java.lang.String toString() {
            return "MediaInfo{mId=" + this.f6061a + ", mOrientation=" + this.f6062b + ", mDateTaken=" + this.f6063c + ", mUri=" + this.d_renamed + ", mData='" + this.e_renamed + "', mTitle='" + this.f_renamed + "', mPath='" + this.g_renamed + "', mMimeType='" + this.h_renamed + "', mWidth=" + this.i_renamed + ", mHeight=" + this.j_renamed + ", mType=" + this.k_renamed + ", mBitmap=" + this.m_renamed + ", mbIsPending=" + this.n_renamed + '}';
        }
    }
}
