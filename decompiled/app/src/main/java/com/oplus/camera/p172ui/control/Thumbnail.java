package com.oplus.camera.p172ui.control;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.ConditionVariable;
import android.text.TextUtils;
import android.util.Size;
import com.oplus.camera.CameraLog;
import com.oplus.camera.Storage;
import com.oplus.camera.aps.service.ThumbnailProcessor;
import com.oplus.camera.jni.FormatConverter;
import com.oplus.camera.util.ThumbnailCacheUtil;
import com.oplus.camera.util.Util;
import java.io.FileDescriptor;
import java.io.IOException;

/* compiled from: Thumbnail.java */
/* renamed from: com.oplus.camera.ui.control.COUIBaseListPopupWindow_8 */
/* loaded from: classes2.dex */
public class Thumbnail {

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static IntrinsicsJvm.kt_5 f18270b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static IntrinsicsJvm.kt_5 f18271c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static IntrinsicsJvm.kt_5 f18272d;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private static int f18274f;

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean f18277a;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private Uri f18278g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private String f18279h;

    /* renamed from: OplusGLSurfaceView_13 */
    private String f18280i;

    /* renamed from: OplusGLSurfaceView_15 */
    private long f18281j;

    /* renamed from: OplusGLSurfaceView_5 */
    private Bitmap f18282k;

    /* renamed from: OplusGLSurfaceView_14 */
    private Bitmap f18283l;

    /* renamed from: OplusGLSurfaceView_6 */
    private boolean f18284m;

    /* renamed from: OplusGLSurfaceView_11 */
    private boolean f18285n;

    /* renamed from: o */
    private long f18286o;

    /* renamed from: p */
    private IntrinsicsJvm.kt_5 f18287p;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private static Object f18273e = new Object();

    /* renamed from: q */
    private static FormatConverter f18275q = null;

    /* renamed from: r */
    private static ConditionVariable f18276r = new ConditionVariable(true);

    /* compiled from: Thumbnail.java */
    /* renamed from: com.oplus.camera.ui.control.COUIBaseListPopupWindow_8$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo10597a(long OplusGLSurfaceView_15, long j2, byte[] bArr);
    }

    /* compiled from: Thumbnail.java */
    /* renamed from: com.oplus.camera.ui.control.COUIBaseListPopupWindow_8$IntrinsicsJvm.kt_4 */
    public interface IntrinsicsJvm.kt_4 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo10413a(Thumbnail c3203e);
    }

    /* compiled from: Thumbnail.java */
    /* renamed from: com.oplus.camera.ui.control.COUIBaseListPopupWindow_8$IntrinsicsJvm.kt_3 */
    public interface IntrinsicsJvm.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo12685a(long OplusGLSurfaceView_15);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m19280a() {
        f18275q = new FormatConverter();
    }

    public Thumbnail() {
        this.f18277a = false;
        this.f18278g = null;
        this.f18279h = null;
        this.f18280i = null;
        this.f18281j = 0L;
        this.f18282k = null;
        this.f18283l = null;
        this.f18284m = false;
        this.f18285n = false;
        this.f18286o = 0L;
        this.f18287p = null;
    }

    public Thumbnail(Bitmap bitmap) {
        this.f18277a = false;
        this.f18278g = null;
        this.f18279h = null;
        this.f18280i = null;
        this.f18281j = 0L;
        this.f18282k = null;
        this.f18283l = null;
        this.f18284m = false;
        this.f18285n = false;
        this.f18286o = 0L;
        this.f18287p = null;
        this.f18282k = bitmap;
    }

    public Thumbnail(Bitmap bitmap, long OplusGLSurfaceView_15, long j2) {
        this.f18277a = false;
        this.f18278g = null;
        this.f18279h = null;
        this.f18280i = null;
        this.f18281j = 0L;
        this.f18282k = null;
        this.f18283l = null;
        this.f18284m = false;
        this.f18285n = false;
        this.f18286o = 0L;
        this.f18287p = null;
        this.f18280i = null;
        this.f18281j = j2;
        this.f18278g = null;
        this.f18286o = OplusGLSurfaceView_15;
        this.f18282k = bitmap;
    }

    private Thumbnail(Uri uri, Bitmap bitmap, int OplusGLSurfaceView_13, String str, long OplusGLSurfaceView_15) {
        this.f18277a = false;
        this.f18278g = null;
        this.f18279h = null;
        this.f18280i = null;
        this.f18281j = 0L;
        this.f18282k = null;
        this.f18283l = null;
        this.f18284m = false;
        this.f18285n = false;
        this.f18286o = 0L;
        this.f18287p = null;
        this.f18278g = uri;
        this.f18280i = str;
        this.f18281j = OplusGLSurfaceView_15;
        if (bitmap != null) {
            this.f18282k = m19266a(bitmap, OplusGLSurfaceView_13);
            if (uri != null) {
                m19281a(m19282b(this.f18282k, ThumbImageView.f18106a), uri.toString(), (long) Math.ceil(OplusGLSurfaceView_15 / 1000.0d), OplusGLSurfaceView_13);
                return;
            }
            return;
        }
        CameraLog.m12954a("Thumbnail", "Thumbnail, mUri: " + this.f18278g + ", thumbnail bitmap is null...");
        this.f18282k = bitmap;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public long m19290b() {
        return this.f18286o;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m19286a(long OplusGLSurfaceView_15) {
        this.f18286o = OplusGLSurfaceView_15;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Bitmap m19266a(Bitmap bitmap, int OplusGLSurfaceView_13) {
        CameraLog.m12954a("Thumbnail", "rotateImage");
        if (OplusGLSurfaceView_13 != 0) {
            Matrix matrix = new Matrix();
            matrix.setRotate(OplusGLSurfaceView_13, bitmap.getWidth() * 0.5f, bitmap.getHeight() * 0.5f);
            try {
                Bitmap bitmapM24221a = Util.m24221a(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                if (bitmapM24221a != bitmap) {
                    bitmap.recycle();
                }
                return bitmapM24221a;
            } catch (Throwable th) {
                CameraLog.m12963c("Thumbnail", "Failed to rotate thumbnail", th);
            }
        }
        return bitmap;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as PlatformImplementations.kt_3 decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0051  */
    /* renamed from: OplusGLSurfaceView_6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int m19285m() {
        /*
            com.oplus.camera.ui.control.COUIBaseListPopupWindow_8$IntrinsicsJvm.kt_5 r0 = com.oplus.camera.p172ui.control.Thumbnail.f18272d
            r1 = 0
            r2 = -1
            r3 = 1
            if (r0 == 0) goto L67
            java.lang.String r0 = r0.f18295h
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
            java.lang.String r4 = "image/x-adobe-dng"
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
            com.oplus.camera.p172ui.control.Thumbnail.f18274f = r2
            goto L91
        L61:
            com.oplus.camera.p172ui.control.Thumbnail.f18274f = r3
            goto L91
        L64:
            com.oplus.camera.p172ui.control.Thumbnail.f18274f = r1
            goto L91
        L67:
            com.oplus.camera.ui.control.COUIBaseListPopupWindow_8$IntrinsicsJvm.kt_5 r0 = com.oplus.camera.p172ui.control.Thumbnail.f18270b
            r4 = 0
            if (r0 == 0) goto L70
            long r6 = r0.f18290c
            goto L71
        L70:
            r6 = r4
        L71:
            com.oplus.camera.ui.control.COUIBaseListPopupWindow_8$IntrinsicsJvm.kt_5 r0 = com.oplus.camera.p172ui.control.Thumbnail.f18271c
            if (r0 == 0) goto L78
            long r8 = r0.f18290c
            goto L79
        L78:
            r8 = r4
        L79:
            int r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r0 < 0) goto L84
            int r0 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r0 <= 0) goto L84
            com.oplus.camera.p172ui.control.Thumbnail.f18274f = r1
            goto L91
        L84:
            int r0 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r0 <= 0) goto L8f
            int r0 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r0 <= 0) goto L8f
            com.oplus.camera.p172ui.control.Thumbnail.f18274f = r3
            goto L91
        L8f:
            com.oplus.camera.p172ui.control.Thumbnail.f18274f = r2
        L91:
            int r0 = com.oplus.camera.p172ui.control.Thumbnail.f18274f
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.p172ui.control.Thumbnail.m19285m():int");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static int m19263a(ContentResolver contentResolver, Thumbnail c3203e, boolean z) throws Throwable {
        int iM19285m;
        Bitmap bitmapM19268a;
        IntrinsicsJvm.kt_5 dVarM19274a;
        Bitmap bitmapLoadThumbnail;
        Bitmap bitmapM24624c;
        Uri uriM11130c = Storage.m11130c(z);
        Uri uriM11135d = Storage.m11135d(z);
        CameraLog.m12954a("Thumbnail", "getLastThumbnailFromContentResolver, sdCard: " + z);
        IntrinsicsJvm.kt_5 dVar = c3203e.f18287p;
        if (dVar != null && -1 != dVar.f18298k) {
            iM19285m = c3203e.f18287p.f18298k;
            bitmapM19268a = c3203e.f18287p.f18300m;
            f18272d = null;
            if (c3203e.f18287p.f18298k == 0) {
                f18270b = m19274a(contentResolver, uriM11130c);
            } else if (1 == c3203e.f18287p.f18298k) {
                f18271c = m19275a(contentResolver, uriM11135d, c3203e.f18287p.f18291d);
            }
        } else {
            f18272d = m19273a(contentResolver);
            CameraLog.m12959b("Thumbnail", "getLastThumbnailFromContentResolver, getLatestMediaItem: " + f18272d);
            if (f18272d == null) {
                f18270b = null;
                f18271c = null;
            }
            iM19285m = -1;
            bitmapM19268a = null;
        }
        if (f18272d == null && f18270b == null && f18271c == null) {
            CameraLog.m12954a("Thumbnail", "getLastThumbnailFromContentResolver, image: " + f18270b + ", video: " + f18271c);
            return 0;
        }
        if (-1 == iM19285m) {
            iM19285m = m19285m();
        }
        CameraLog.m12959b("Thumbnail", "getLastThumbnailFromContentResolver, latestFileType: " + iM19285m);
        if (-1 == iM19285m) {
            return 0;
        }
        if (iM19285m == 0) {
            dVarM19274a = f18272d;
            if (dVarM19274a == null) {
                dVarM19274a = f18270b;
            }
            dVarM19274a.f18291d = ContentUris.withAppendedId(uriM11130c, dVarM19274a.f18288a);
            if (Util.m24291a(dVarM19274a.f18291d, dVarM19274a.f18294g, dVarM19274a.f18296i, dVarM19274a.f18297j)) {
                CameraLog.m12954a("Thumbnail", "getLastThumbnailFromContentResolver, uri: " + dVarM19274a.f18291d + ", path: " + dVarM19274a.f18294g + ", width: " + dVarM19274a.f18296i + ", height: " + dVarM19274a.f18297j);
                if (Storage.m11134c()) {
                    bitmapM24624c = ThumbnailCacheUtil.m24610a().m24627e(dVarM19274a.f18293f);
                } else {
                    bitmapM24624c = ThumbnailCacheUtil.m24610a().m24624c(dVarM19274a.f18293f);
                }
                bitmapM19268a = m19282b(bitmapM24624c, ThumbImageView.f18106a);
                if (bitmapM19268a == null && (dVarM19274a = m19274a(contentResolver, uriM11130c)) == null) {
                    CameraLog.m12954a("Thumbnail", "getLastThumbnailFromContentResolver, sImage null");
                    return 0;
                }
            }
            if (bitmapM19268a == null) {
                try {
                    if (dVarM19274a.f18301n) {
                        ThumbnailProcessor.THUMBNAIL_URI_CREATING_VARIABLE.block(1000L);
                    }
                    bitmapM19268a = m19268a(dVarM19274a, false);
                    CameraLog.m12967f("Thumbnail", "getLastThumbnailFromContentResolver, getBitmapFromCache: " + bitmapM19268a);
                    if (bitmapM19268a == null) {
                        bitmapM19268a = m19265a(contentResolver, dVarM19274a);
                    }
                } catch (Exception COUIBaseListPopupWindow_8) {
                    COUIBaseListPopupWindow_8.printStackTrace();
                }
            }
            if (bitmapM19268a == null) {
                CameraLog.m12967f("Thumbnail", "getLastThumbnailFromContentResolver, bitmap null");
                String[] strArrSplit = dVarM19274a.f18294g.split("\\.");
                if (strArrSplit != null && strArrSplit.length > 0 && "jpg".equals(strArrSplit[strArrSplit.length - 1])) {
                    try {
                        contentResolver.delete(dVarM19274a.f18291d, null, null);
                        CameraLog.m12954a("Thumbnail", "getLastThumbnailFromContentResolver, delete image: " + dVarM19274a.f18291d);
                    } catch (Exception unused) {
                        CameraLog.m12967f("Thumbnail", "getLastThumbnailFromContentResolver, Failed to delete image: " + dVarM19274a.f18291d);
                    }
                }
                return 0;
            }
            m19281a(bitmapM19268a, dVarM19274a.f18291d.toString(), dVarM19274a.f18299l, dVarM19274a.f18289b);
        } else if (1 == iM19285m) {
            dVarM19274a = f18272d;
            if (dVarM19274a == null) {
                dVarM19274a = f18271c;
            }
            dVarM19274a.f18291d = ContentUris.withAppendedId(uriM11135d, dVarM19274a.f18288a);
            if (bitmapM19268a == null) {
                try {
                    bitmapM19268a = m19268a(dVarM19274a, true);
                    CameraLog.m12967f("Thumbnail", "getLastThumbnailFromContentResolver, getBitmapFromCache: " + bitmapM19268a);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return 0;
                }
            }
            if (bitmapM19268a == null) {
                CancellationSignal cancellationSignal = new CancellationSignal();
                if (29 <= Build.VERSION.SDK_INT) {
                    CameraLog.m12954a("Thumbnail", "getThumbnailBitmapFromUri, media.mWidth: " + dVarM19274a.f18296i + "media.mHeight: " + dVarM19274a.f18297j);
                    if (dVarM19274a.f18296i > dVarM19274a.f18297j) {
                        bitmapLoadThumbnail = contentResolver.loadThumbnail(dVarM19274a.f18291d, new Size((dVarM19274a.f18296i / dVarM19274a.f18297j) * ThumbImageView.f18106a, ThumbImageView.f18106a), cancellationSignal);
                    } else if (dVarM19274a.f18296i < dVarM19274a.f18297j) {
                        bitmapLoadThumbnail = contentResolver.loadThumbnail(dVarM19274a.f18291d, new Size(ThumbImageView.f18106a, (dVarM19274a.f18297j / dVarM19274a.f18296i) * ThumbImageView.f18106a), cancellationSignal);
                    } else {
                        bitmapLoadThumbnail = contentResolver.loadThumbnail(dVarM19274a.f18291d, new Size(ThumbImageView.f18106a, ThumbImageView.f18106a), cancellationSignal);
                    }
                    bitmapM19268a = m19282b(bitmapLoadThumbnail, ThumbImageView.f18106a);
                }
            }
            if (bitmapM19268a != null) {
                m19281a(bitmapM19268a, dVarM19274a.f18291d.toString(), dVarM19274a.f18299l, dVarM19274a.f18289b);
            }
        } else {
            dVarM19274a = null;
        }
        if (dVarM19274a != null) {
            CameraLog.m12954a("Thumbnail", "getLastThumbnailFromContentResolver, thumbnail uri: " + dVarM19274a.f18291d);
        }
        if (dVarM19274a != null && (Util.m24291a(dVarM19274a.f18291d, dVarM19274a.f18294g, dVarM19274a.f18296i, dVarM19274a.f18297j) || Util.m24290a(dVarM19274a.f18291d, contentResolver))) {
            c3203e.f18278g = dVarM19274a.f18291d;
            c3203e.f18280i = dVarM19274a.f18292e;
            c3203e.f18281j = dVarM19274a.f18290c;
            c3203e.f18279h = dVarM19274a.f18295h;
            if (bitmapM19268a != null) {
                if (29 <= Build.VERSION.SDK_INT && !"image/x-adobe-dng".equals(c3203e.f18279h)) {
                    c3203e.f18282k = bitmapM19268a;
                } else {
                    c3203e.f18282k = m19266a(bitmapM19268a, dVarM19274a.f18289b);
                }
            } else {
                CameraLog.m12954a("Thumbnail", "getLastThumbnailFromContentResolver, bitmap is null, mUri: " + c3203e.f18278g);
                c3203e.f18282k = null;
            }
            return 1;
        }
        CameraLog.m12954a("Thumbnail", "getLastThumbnailFromContentResolver, THUMBNAIL_DELETED");
        return 2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static void m19281a(Bitmap bitmap, String str, long OplusGLSurfaceView_15, int OplusGLSurfaceView_13) {
        ThumbnailCacheUtil.IntrinsicsJvm.kt_4 bVarM24621b = ThumbnailCacheUtil.m24610a().m24621b(str);
        if (bVarM24621b == null || OplusGLSurfaceView_15 != bVarM24621b.m24636b() || OplusGLSurfaceView_13 != bVarM24621b.m24636b()) {
            ThumbnailCacheUtil.IntrinsicsJvm.kt_4 bVar = new ThumbnailCacheUtil.IntrinsicsJvm.kt_4();
            bVar.m24634a(OplusGLSurfaceView_15);
            bVar.m24633a(OplusGLSurfaceView_13);
            bVar.m24635a(bitmap.copy(Bitmap.Config.ARGB_8888, true));
            ThumbnailCacheUtil.m24610a().m24620a(str, bVar);
        }
        CameraLog.m12954a("Thumbnail", "cacheThumbnail, uri: " + str + ", bitmap width: " + bitmap.getWidth() + ", height: " + bitmap.getHeight() + ", dateModified: " + OplusGLSurfaceView_15 + ", orientation: " + OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static Bitmap m19268a(IntrinsicsJvm.kt_5 dVar, boolean z) {
        String str;
        Bitmap bitmapM24637c;
        String string = dVar.f18291d.toString();
        ThumbnailCacheUtil.IntrinsicsJvm.kt_4 bVarM24621b = ThumbnailCacheUtil.m24610a().m24621b(string);
        StringBuilder sb = new StringBuilder();
        sb.append("getBitmapFromCache, uri: ");
        sb.append(string);
        if (bVarM24621b != null) {
            str = ", thumbnailCacheData.modified: " + bVarM24621b.m24636b() + ", thumbnailCacheData.orientation: " + bVarM24621b.m24632a() + ", lastMediaInfo.modified: " + dVar.f18299l + ", lastMediaInfo.Orientation: " + dVar.f18289b + ", lastMediaInfo.mbIsPending: " + dVar.f18301n;
        } else {
            str = ", thumbnailCacheData is null.";
        }
        sb.append(str);
        CameraLog.m12959b("Thumbnail", sb.toString());
        if (bVarM24621b == null) {
            return null;
        }
        if ((!z && !dVar.f18301n && (dVar.f18299l != bVarM24621b.m24636b() || dVar.f18289b != bVarM24621b.m24632a())) || (bitmapM24637c = bVarM24621b.m24637c()) == null || bitmapM24637c.isRecycled()) {
            return null;
        }
        return bitmapM24637c.copy(Bitmap.Config.ARGB_8888, true);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Bitmap m19265a(ContentResolver contentResolver, IntrinsicsJvm.kt_5 dVar) {
        if (29 <= Build.VERSION.SDK_INT) {
            return m19264a(contentResolver, dVar.f18291d, dVar);
        }
        return m19270a(dVar.f18292e);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static Bitmap m19264a(ContentResolver contentResolver, Uri uri, IntrinsicsJvm.kt_5 dVar) throws IOException {
        Bitmap bitmapLoadThumbnail;
        if (uri == null) {
            CameraLog.m12967f("Thumbnail", "getThumbnailBitmapFromUri, uri: null");
            return null;
        }
        CancellationSignal cancellationSignal = new CancellationSignal();
        try {
            if (29 <= Build.VERSION.SDK_INT) {
                CameraLog.m12967f("Thumbnail", "getThumbnailBitmapFromUri, media.mWidth: " + dVar.f18296i + "media.mHeight: " + dVar.f18297j);
                if (dVar.f18296i > dVar.f18297j) {
                    bitmapLoadThumbnail = contentResolver.loadThumbnail(uri, new Size((dVar.f18296i / dVar.f18297j) * ThumbImageView.f18106a, ThumbImageView.f18106a), cancellationSignal);
                } else if (dVar.f18296i < dVar.f18297j) {
                    bitmapLoadThumbnail = contentResolver.loadThumbnail(uri, new Size(ThumbImageView.f18106a, (dVar.f18297j / dVar.f18296i) * ThumbImageView.f18106a), cancellationSignal);
                } else {
                    bitmapLoadThumbnail = contentResolver.loadThumbnail(uri, new Size(ThumbImageView.f18106a, ThumbImageView.f18106a), cancellationSignal);
                }
                return m19282b(bitmapLoadThumbnail, ThumbImageView.f18106a);
            }
        } catch (IOException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
        return null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static Bitmap m19270a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        options.inJustDecodeBounds = false;
        if (options.outWidth / 4 >= ThumbImageView.f18106a && options.outHeight / 4 >= ThumbImageView.f18106a) {
            options.outHeight /= 4;
            options.outWidth /= 4;
            options.inSampleSize = 4;
        }
        return m19282b(BitmapFactory.decodeFile(str, options), ThumbImageView.f18106a);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static Bitmap m19282b(Bitmap bitmap, int OplusGLSurfaceView_13) {
        int i2;
        if (bitmap == null) {
            return null;
        }
        int i3 = 2;
        if (Bitmap.Config.RGB_565 == bitmap.getConfig()) {
            i2 = 2;
        } else {
            i2 = Bitmap.Config.RGBA_F16 == bitmap.getConfig() ? 5 : 0;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int iMin = Math.min(width, height);
        CameraLog.m12967f("Thumbnail", "getThumbnailBitmapFromUri, width: " + width + ", height: " + height + ", channelType: " + i2);
        if (iMin <= OplusGLSurfaceView_13) {
            return bitmap;
        }
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        if (2 == i2) {
            config = Bitmap.Config.RGB_565;
        } else if (5 == i2) {
            i3 = 8;
            config = Bitmap.Config.RGBA_F16;
        } else {
            i3 = 4;
        }
        float COUIBaseListPopupWindow_12 = OplusGLSurfaceView_13 / iMin;
        int iRound = Math.round(width * COUIBaseListPopupWindow_12);
        int iRound2 = Math.round(COUIBaseListPopupWindow_12 * height);
        Bitmap bitmapM24215a = Util.m24215a(iRound, iRound2, config);
        FormatConverter formatConverter = f18275q;
        if (formatConverter != null) {
            formatConverter.scaleArea(bitmap, width * i3, width, height, bitmapM24215a, iRound * i3, iRound, iRound2, i2);
            return bitmapM24215a;
        }
        CameraLog.m12967f("Thumbnail", "getNoMoireThumbnailBitmap, sFormatConverter: null");
        return bitmapM24215a;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0173 A[Catch: all -> 0x016a, Exception -> 0x016d, TRY_ENTER, TryCatch #5 {Exception -> 0x016d, all -> 0x016a, blocks: (B:12:0x00db, B:14:0x00e1, B:18:0x015d, B:27:0x0173, B:28:0x0176), top: B:66:0x00db }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0185 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:? A[RETURN, SYNTHETIC] */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static com.oplus.camera.p172ui.control.Thumbnail.IntrinsicsJvm.kt_5 m19274a(android.content.ContentResolver r34, android.net.Uri r35) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 585
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.p172ui.control.Thumbnail.m19274a(android.content.ContentResolver, android.net.Uri):com.oplus.camera.ui.control.COUIBaseListPopupWindow_8$IntrinsicsJvm.kt_5");
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0179 A[Catch: all -> 0x0170, Exception -> 0x0173, TRY_ENTER, TryCatch #7 {Exception -> 0x0173, all -> 0x0170, blocks: (B:12:0x00e3, B:14:0x00e9, B:18:0x0163, B:27:0x0179, B:28:0x017c), top: B:62:0x00e3 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0188 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:? A[RETURN, SYNTHETIC] */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static com.oplus.camera.p172ui.control.Thumbnail.IntrinsicsJvm.kt_5 m19273a(android.content.ContentResolver r33) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 589
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.p172ui.control.Thumbnail.m19273a(android.content.ContentResolver):com.oplus.camera.ui.control.COUIBaseListPopupWindow_8$IntrinsicsJvm.kt_5");
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0105 A[PHI: r2
      0x0105: PHI (r2v12 android.database.Cursor) = (r2v11 android.database.Cursor), (r2v13 android.database.Cursor) binds: [B:35:0x0113, B:28:0x0103] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0119  */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static com.oplus.camera.p172ui.control.Thumbnail.IntrinsicsJvm.kt_5 m19275a(android.content.ContentResolver r29, android.net.Uri r30, android.net.Uri r31) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 285
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.p172ui.control.Thumbnail.m19275a(android.content.ContentResolver, android.net.Uri, android.net.Uri):com.oplus.camera.ui.control.COUIBaseListPopupWindow_8$IntrinsicsJvm.kt_5");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Thumbnail m19276a(Bitmap bitmap, int OplusGLSurfaceView_13, int i2, Uri uri, String str, long OplusGLSurfaceView_15) {
        if (bitmap == null) {
            CameraLog.m12954a("Thumbnail", "createThumbnail(), use data cereate bitmap is null... ");
            return null;
        }
        return m19278a(uri, bitmap, OplusGLSurfaceView_13, str, OplusGLSurfaceView_15);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Thumbnail m19279a(byte[] bArr, int OplusGLSurfaceView_13, int i2, Uri uri, String str, long OplusGLSurfaceView_15) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (i2 > 4) {
            i2 = 4;
        }
        options.inSampleSize = i2;
        return m19278a(uri, m19282b(BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options), ThumbImageView.f18106a), OplusGLSurfaceView_13, str, OplusGLSurfaceView_15);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Bitmap m19269a(FileDescriptor fileDescriptor, int OplusGLSurfaceView_13) {
        return m19272a((String) null, fileDescriptor, OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Bitmap m19271a(String str, int OplusGLSurfaceView_13) {
        return m19272a(str, (FileDescriptor) null, OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static Bitmap m19272a(String str, FileDescriptor fileDescriptor, int OplusGLSurfaceView_13) throws IOException {
        Bitmap frameAtTime;
        f18276r.block();
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
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
                } catch (RuntimeException unused) {
                }
            } catch (RuntimeException unused2) {
                frameAtTime = null;
                return m19282b(frameAtTime, OplusGLSurfaceView_13);
            }
        } catch (IllegalArgumentException | RuntimeException unused3) {
            mediaMetadataRetriever.release();
            frameAtTime = null;
            return m19282b(frameAtTime, OplusGLSurfaceView_13);
        } catch (Throwable th) {
            try {
                mediaMetadataRetriever.release();
            } catch (RuntimeException unused4) {
            }
            throw th;
        }
        return m19282b(frameAtTime, OplusGLSurfaceView_13);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static void m19283c() {
        CameraLog.m12962c("Thumbnail", "closeMediaLimitCondition");
        f18276r.close();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public static void m19284d() {
        CameraLog.m12962c("Thumbnail", "openMediaLimitCondition");
        f18276r.open();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Thumbnail m19278a(Uri uri, Bitmap bitmap, int OplusGLSurfaceView_13, String str, long OplusGLSurfaceView_15) {
        CameraLog.m12967f("Thumbnail", "createThumbnail, uri: " + uri);
        return new Thumbnail(uri, bitmap, OplusGLSurfaceView_13, str, OplusGLSurfaceView_15);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0063  */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.oplus.camera.p172ui.control.Thumbnail m19277a(android.hardware.HardwareBuffer r21, int r22, int r23, int r24, int r25, boolean r26) {
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
            com.oplus.camera.CameraLog.m12954a(r12, r4)
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
            android.graphics.Bitmap r20 = com.oplus.camera.util.Util.m24215a(r14, r5, r0)
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
            android.graphics.Bitmap r20 = com.oplus.camera.util.Util.m24410c(r20)
        L98:
            r0 = r20
            java.lang.String r1 = "createThumbnail end"
            com.oplus.camera.CameraLog.m12954a(r12, r1)
            com.oplus.camera.ui.control.COUIBaseListPopupWindow_8 r1 = new com.oplus.camera.ui.control.COUIBaseListPopupWindow_8
            r1.<init>(r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.p172ui.control.Thumbnail.m19277a(android.hardware.HardwareBuffer, int, int, int, int, boolean):com.oplus.camera.ui.control.COUIBaseListPopupWindow_8");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Bitmap m19267a(Bitmap bitmap, int OplusGLSurfaceView_13, int i2, boolean z) {
        if (bitmap == null) {
            return null;
        }
        Bitmap bitmapM24215a = Util.m24215a(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapM24215a);
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, width, height);
        RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-12434878);
        float COUIBaseListPopupWindow_12 = OplusGLSurfaceView_13;
        canvas.drawRoundRect(rectF, COUIBaseListPopupWindow_12, COUIBaseListPopupWindow_12, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        if (z) {
            Paint paint2 = new Paint();
            paint2.setColor(452984831);
            paint2.setStrokeWidth(i2);
            paint2.setStyle(Paint.Style.STROKE);
            paint2.setAntiAlias(true);
            canvas.drawCircle(width / 2, height / 2, OplusGLSurfaceView_13 - (i2 / 2), paint2);
        }
        return bitmapM24215a;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public Uri m19291e() {
        return this.f18278g;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public String m19292f() {
        return this.f18280i;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public long m19293g() {
        return this.f18281j;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public Bitmap m19294h() {
        return this.f18282k;
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public Bitmap m19295i() {
        return this.f18283l;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m19287a(Bitmap bitmap) {
        this.f18283l = bitmap;
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public boolean m19296j() {
        return this.f18284m;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m19289a(boolean z) {
        this.f18284m = z;
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public void m19297k() {
        Bitmap bitmap = this.f18282k;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f18282k.recycle();
        }
        this.f18282k = null;
        this.f18278g = null;
    }

    /* renamed from: OplusGLSurfaceView_14 */
    public String m19298l() {
        return this.f18279h;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m19288a(IntrinsicsJvm.kt_5 dVar) {
        this.f18287p = dVar;
    }

    /* compiled from: Thumbnail.java */
    /* renamed from: com.oplus.camera.ui.control.COUIBaseListPopupWindow_8$IntrinsicsJvm.kt_5 */
    public static class IntrinsicsJvm.kt_5 {

        /* renamed from: PlatformImplementations.kt_3 */
        public long f18288a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        public int f18289b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        public long f18290c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        public Uri f18291d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        public String f18292e;

        /* renamed from: COUIBaseListPopupWindow_12 */
        public String f18293f;

        /* renamed from: COUIBaseListPopupWindow_11 */
        public String f18294g;

        /* renamed from: COUIBaseListPopupWindow_10 */
        public String f18295h;

        /* renamed from: OplusGLSurfaceView_13 */
        public int f18296i;

        /* renamed from: OplusGLSurfaceView_15 */
        public int f18297j;

        /* renamed from: OplusGLSurfaceView_5 */
        public int f18298k;

        /* renamed from: OplusGLSurfaceView_14 */
        public long f18299l;

        /* renamed from: OplusGLSurfaceView_6 */
        public Bitmap f18300m;

        /* renamed from: OplusGLSurfaceView_11 */
        public boolean f18301n;

        public IntrinsicsJvm.kt_5() {
            this.f18296i = 0;
            this.f18297j = 0;
            this.f18298k = -1;
            this.f18300m = null;
            this.f18301n = false;
        }

        public IntrinsicsJvm.kt_5(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13, long j2, Uri uri, String str, String str2, String str3, String str4, int i2, int i3) {
            this.f18296i = 0;
            this.f18297j = 0;
            this.f18298k = -1;
            this.f18300m = null;
            this.f18301n = false;
            this.f18288a = OplusGLSurfaceView_15;
            this.f18289b = OplusGLSurfaceView_13;
            this.f18290c = j2;
            this.f18291d = uri;
            this.f18292e = str;
            this.f18293f = str2;
            this.f18294g = str3;
            this.f18296i = i2;
            this.f18297j = i3;
            this.f18295h = str4;
        }

        public IntrinsicsJvm.kt_5(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13, long j2, Uri uri, String str, String str2, String str3, String str4, int i2, int i3, long j3, boolean z) {
            this.f18296i = 0;
            this.f18297j = 0;
            this.f18298k = -1;
            this.f18300m = null;
            this.f18301n = false;
            this.f18288a = OplusGLSurfaceView_15;
            this.f18289b = OplusGLSurfaceView_13;
            this.f18290c = j2;
            this.f18291d = uri;
            this.f18292e = str;
            this.f18293f = str2;
            this.f18294g = str3;
            this.f18296i = i2;
            this.f18297j = i3;
            this.f18295h = str4;
            this.f18299l = j3;
            this.f18301n = z;
        }

        public String toString() {
            return "MediaInfo{mId=" + this.f18288a + ", mOrientation=" + this.f18289b + ", mDateTaken=" + this.f18290c + ", mUri=" + this.f18291d + ", mData='" + this.f18292e + "', mTitle='" + this.f18293f + "', mPath='" + this.f18294g + "', mMimeType='" + this.f18295h + "', mWidth=" + this.f18296i + ", mHeight=" + this.f18297j + ", mType=" + this.f18298k + ", mBitmap=" + this.f18300m + ", mbIsPending=" + this.f18301n + '}';
        }
    }
}
