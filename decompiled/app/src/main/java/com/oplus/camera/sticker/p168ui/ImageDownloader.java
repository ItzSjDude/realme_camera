package com.oplus.camera.sticker.p168ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Process;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: ImageDownloader.java */
/* renamed from: com.oplus.camera.sticker.ui.IntrinsicsJvm.kt_3 */
/* loaded from: classes2.dex */
public class ImageDownloader {

    /* renamed from: PlatformImplementations.kt_3 */
    private static ConcurrentHashMap<String, SoftReference<Drawable>> f16330a = new ConcurrentHashMap<>(10);

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static Map<String, IntrinsicsJvm.kt_3> f16331b = new ConcurrentHashMap();

    /* renamed from: IntrinsicsJvm.kt_3 */
    private Context f16332c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private BitmapDrawable f16333d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f16334e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f16335f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f16336g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f16337h;

    /* renamed from: OplusGLSurfaceView_13 */
    private HashMap<String, Drawable> f16338i;

    public ImageDownloader(Context context, int OplusGLSurfaceView_13) {
        this.f16333d = null;
        this.f16334e = 0;
        this.f16335f = 0;
        this.f16336g = 0;
        this.f16337h = 0;
        this.f16332c = context.getApplicationContext();
        try {
            this.f16333d = (BitmapDrawable) context.getResources().getDrawable(OplusGLSurfaceView_13);
        } catch (OutOfMemoryError unused) {
            System.gc();
        }
        m17026a(10);
        this.f16337h = this.f16332c.getResources().getDimensionPixelSize(R.dimen.sticker_gridview_image_width);
        this.f16335f = this.f16332c.getResources().getDimensionPixelSize(R.dimen.sticker_gridview_redpoint_margin_top);
        this.f16336g = this.f16332c.getResources().getDimensionPixelSize(R.dimen.sticker_gridview_redpoint_radius);
        this.f16334e = this.f16332c.getResources().getDimensionPixelSize(R.dimen.sticker_gridview_thumbnail_display_size);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m17026a(final int OplusGLSurfaceView_13) {
        this.f16338i = new LinkedHashMap<String, Drawable>(OplusGLSurfaceView_13, 0.75f, false) { // from class: com.oplus.camera.sticker.ui.IntrinsicsJvm.kt_3.1
            @Override // java.util.LinkedHashMap
            protected boolean removeEldestEntry(Map.Entry<String, Drawable> entry) {
                if (size() <= OplusGLSurfaceView_13) {
                    return false;
                }
                ImageDownloader.f16330a.put(entry.getKey(), new SoftReference(entry.getValue()));
                return true;
            }
        };
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17044a(String str, String str2, ImageTagInfo c3011d) throws Resources.NotFoundException {
        BitmapDrawable bitmapDrawable;
        if (str == null && (bitmapDrawable = this.f16333d) != null) {
            m17030a(c3011d, bitmapDrawable);
            return;
        }
        Drawable drawableM17034b = m17034b(str);
        if (drawableM17034b == null) {
            m17038b(str, str2, c3011d);
        } else {
            m17032a(str);
            m17030a(c3011d, drawableM17034b);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m17038b(String str, String str2, ImageTagInfo c3011d) throws Resources.NotFoundException {
        boolean z;
        IntrinsicsJvm.kt_3 cVar;
        if (str == null) {
            return;
        }
        String strM17025a = m17025a(c3011d);
        if (strM17025a != null && !strM17025a.equals(str) && (cVar = f16331b.get(strM17025a)) != null) {
            cVar.m17056b(c3011d);
        }
        IntrinsicsJvm.kt_3 cVar2 = f16331b.get(str);
        if (cVar2 == null || cVar2.isCancelled()) {
            IntrinsicsJvm.kt_3 cVarM17036b = m17036b(c3011d);
            if (cVarM17036b != null) {
                cVarM17036b.cancel(true);
            }
            cVar2 = new IntrinsicsJvm.kt_3();
            f16331b.put(str, cVar2);
            z = true;
        } else {
            z = false;
        }
        cVar2.m17054a(c3011d);
        if (z) {
            if (this.f16333d != null) {
                m17030a(c3011d, new IntrinsicsJvm.kt_4(this.f16332c.getResources(), this.f16333d, str, cVar2));
            } else {
                m17030a(c3011d, new PlatformImplementations.kt_3(str, cVar2));
            }
            cVar2.execute(str, str2);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static boolean m17032a(String str) {
        IntrinsicsJvm.kt_3 cVar;
        if (str != null && (cVar = f16331b.get(str)) != null) {
            cVar.cancel(true);
        }
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private String m17025a(ImageTagInfo c3011d) {
        if (c3011d == null) {
            return null;
        }
        Drawable drawableM17063b = c3011d.m17063b();
        if (drawableM17063b instanceof PlatformImplementations.kt_3) {
            return ((PlatformImplementations.kt_3) drawableM17063b).m17045a();
        }
        if (drawableM17063b instanceof IntrinsicsJvm.kt_4) {
            return ((IntrinsicsJvm.kt_4) drawableM17063b).m17047a();
        }
        return null;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private IntrinsicsJvm.kt_3 m17036b(ImageTagInfo c3011d) {
        if (c3011d == null) {
            return null;
        }
        Drawable drawableM17063b = c3011d.m17063b();
        if (drawableM17063b instanceof PlatformImplementations.kt_3) {
            return ((PlatformImplementations.kt_3) drawableM17063b).m17046b();
        }
        if (drawableM17063b instanceof IntrinsicsJvm.kt_4) {
            return ((IntrinsicsJvm.kt_4) drawableM17063b).m17048b();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public Drawable m17024a(String str, String str2) throws Throwable {
        Drawable drawableM17019a;
        if ("parse_url".equals(str2)) {
            drawableM17019a = m17018a(this.f16332c, Uri.parse(str));
        } else {
            drawableM17019a = "parse_file".equals(str2) ? m17019a(this.f16332c, str) : null;
        }
        CameraLog.m12954a("ImageDownloader", "downloadDrawable, drawable: " + drawableM17019a);
        return drawableM17019a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0056 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r5v0, types: [android.net.Uri] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.io.InputStream] */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private android.graphics.drawable.Drawable m17018a(android.content.Context r4, android.net.Uri r5) throws java.lang.Throwable {
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
            android.content.Context r3 = r3.f16332c
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
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.sticker.p168ui.ImageDownloader.m17018a(android.content.Context, android.net.Uri):android.graphics.drawable.Drawable");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private Drawable m17019a(Context context, String str) throws Throwable {
        FileInputStream fileInputStream;
        Bitmap bitmapDecodeStream;
        File file = new File(str);
        FileInputStream fileInputStream2 = null;
        try {
        } catch (Throwable th) {
            th = th;
        }
        try {
            try {
                fileInputStream = file.exists() ? new FileInputStream(file) : null;
            } catch (IOException COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
            }
            try {
                bitmapDecodeStream = BitmapFactory.decodeStream(fileInputStream);
            } catch (FileNotFoundException e2) {
                COUIBaseListPopupWindow_8 = e2;
                COUIBaseListPopupWindow_8.printStackTrace();
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                return this.f16332c.getResources().getDrawable(R.drawable.sticker_undownload, null);
            }
        } catch (FileNotFoundException e3) {
            COUIBaseListPopupWindow_8 = e3;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            if (0 != 0) {
                try {
                    fileInputStream2.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
            throw th;
        }
        if (bitmapDecodeStream == null) {
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            return this.f16332c.getResources().getDrawable(R.drawable.sticker_undownload, null);
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(context.getResources(), bitmapDecodeStream);
        bitmapDrawable.setTargetDensity(bitmapDecodeStream.getDensity());
        if (fileInputStream != null) {
            try {
                fileInputStream.close();
            } catch (IOException e5) {
                e5.printStackTrace();
            }
        }
        return bitmapDrawable;
    }

    /* compiled from: ImageDownloader.java */
    /* renamed from: com.oplus.camera.sticker.ui.IntrinsicsJvm.kt_3$IntrinsicsJvm.kt_3 */
    class IntrinsicsJvm.kt_3 extends AsyncTask<String, Void, Drawable> {

        /* renamed from: PlatformImplementations.kt_3 */
        public String f16343a;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private final List<ImageTagInfo> f16345c = new ArrayList();

        /* renamed from: IntrinsicsJvm.kt_5 */
        private String f16346d;

        IntrinsicsJvm.kt_3() {
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m17054a(ImageTagInfo c3011d) {
            if (c3011d == null || m17050a(c3011d, false)) {
                return;
            }
            this.f16345c.add(c3011d);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private boolean m17050a(ImageTagInfo c3011d, boolean z) {
            int size = this.f16345c.size();
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
                if (this.f16345c.get(OplusGLSurfaceView_13) == c3011d) {
                    if (!z) {
                        return true;
                    }
                    this.f16345c.remove(OplusGLSurfaceView_13);
                    return true;
                }
            }
            return false;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public void m17056b(ImageTagInfo c3011d) {
            m17050a(c3011d, true);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public Drawable doInBackground(String... strArr) throws SecurityException, IllegalArgumentException {
            Process.setThreadPriority(10);
            this.f16343a = strArr[0];
            this.f16346d = strArr[1];
            if (isCancelled()) {
                return null;
            }
            return ImageDownloader.this.m17024a(this.f16343a, this.f16346d);
        }

        @Override // android.os.AsyncTask
        protected void onCancelled() {
            super.onCancelled();
            if (ImageDownloader.f16331b == null || this.f16343a == null) {
                return;
            }
            ImageDownloader.f16331b.remove(this.f16343a);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public void onCancelled(Drawable drawable) {
            super.onCancelled(drawable);
            if (ImageDownloader.f16331b == null || this.f16343a == null) {
                return;
            }
            ImageDownloader.f16331b.remove(this.f16343a);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: IntrinsicsJvm.kt_4, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Drawable drawable) throws Resources.NotFoundException {
            CameraLog.m12954a("ImageDownloader", "onPostExecute, isCancelled: " + isCancelled() + ", bitmap: " + drawable);
            ImageDownloader.f16331b.remove(this.f16343a);
            if (isCancelled()) {
                drawable = null;
            }
            if (drawable != null) {
                ImageDownloader.this.m17031a(this.f16343a, drawable);
                m17051c(drawable);
            } else {
                m17049a();
            }
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        private void m17051c(Drawable drawable) throws Resources.NotFoundException {
            int size = this.f16345c.size();
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
                ImageTagInfo c3011d = this.f16345c.get(OplusGLSurfaceView_13);
                if (c3011d != null) {
                    ImageDownloader.this.m17030a(c3011d, drawable);
                }
            }
            this.f16345c.clear();
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private void m17049a() throws Resources.NotFoundException {
            int size = this.f16345c.size();
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
                ImageTagInfo c3011d = this.f16345c.get(OplusGLSurfaceView_13);
                if (c3011d != null && ImageDownloader.this.f16333d != null) {
                    ImageDownloader c3010c = ImageDownloader.this;
                    c3010c.m17030a(c3011d, c3010c.f16333d);
                }
            }
            this.f16345c.clear();
        }
    }

    /* compiled from: ImageDownloader.java */
    /* renamed from: com.oplus.camera.sticker.ui.IntrinsicsJvm.kt_3$PlatformImplementations.kt_3 */
    private static class PlatformImplementations.kt_3 extends ColorDrawable {

        /* renamed from: PlatformImplementations.kt_3 */
        private final WeakReference<String> f16339a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private final WeakReference<IntrinsicsJvm.kt_3> f16340b;

        public PlatformImplementations.kt_3(String str, IntrinsicsJvm.kt_3 cVar) {
            super(-1);
            this.f16339a = new WeakReference<>(str);
            this.f16340b = new WeakReference<>(cVar);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public String m17045a() {
            return this.f16339a.get();
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public IntrinsicsJvm.kt_3 m17046b() {
            return this.f16340b.get();
        }
    }

    /* compiled from: ImageDownloader.java */
    /* renamed from: com.oplus.camera.sticker.ui.IntrinsicsJvm.kt_3$IntrinsicsJvm.kt_4 */
    private static class IntrinsicsJvm.kt_4 extends BitmapDrawable {

        /* renamed from: PlatformImplementations.kt_3 */
        private final WeakReference<String> f16341a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private final WeakReference<IntrinsicsJvm.kt_3> f16342b;

        public IntrinsicsJvm.kt_4(Resources resources, BitmapDrawable bitmapDrawable, String str, IntrinsicsJvm.kt_3 cVar) {
            super(resources, bitmapDrawable.getBitmap());
            this.f16341a = new WeakReference<>(str);
            this.f16342b = new WeakReference<>(cVar);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public String m17047a() {
            return this.f16341a.get();
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public IntrinsicsJvm.kt_3 m17048b() {
            return this.f16342b.get();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m17031a(String str, Drawable drawable) {
        if (drawable != null) {
            HashMap<String, Drawable> map = this.f16338i;
            if (map != null) {
                synchronized (map) {
                    this.f16338i.put(str, drawable);
                }
            }
            ConcurrentHashMap<String, SoftReference<Drawable>> concurrentHashMap = f16330a;
            if (concurrentHashMap != null) {
                concurrentHashMap.put(str, new SoftReference<>(drawable));
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Drawable m17034b(String str) {
        SoftReference<Drawable> softReference;
        if (str == null) {
            return null;
        }
        HashMap<String, Drawable> map = this.f16338i;
        if (map != null) {
            synchronized (map) {
                Drawable drawable = this.f16338i.get(str);
                if (drawable != null) {
                    this.f16338i.remove(str);
                    this.f16338i.put(str, drawable);
                    return drawable;
                }
            }
        }
        ConcurrentHashMap<String, SoftReference<Drawable>> concurrentHashMap = f16330a;
        if (concurrentHashMap != null && (softReference = concurrentHashMap.get(str)) != null) {
            Drawable drawable2 = softReference.get();
            if (drawable2 != null) {
                return drawable2;
            }
            f16330a.remove(str);
        }
        return null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17043a() {
        HashMap<String, Drawable> map = this.f16338i;
        if (map != null) {
            map.clear();
        }
        this.f16333d = null;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static void m17037b() {
        Map<String, IntrinsicsJvm.kt_3> map = f16331b;
        if (map != null) {
            map.clear();
        }
        ConcurrentHashMap<String, SoftReference<Drawable>> concurrentHashMap = f16330a;
        if (concurrentHashMap != null) {
            concurrentHashMap.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m17030a(ImageTagInfo c3011d, Drawable drawable) throws Resources.NotFoundException {
        if (c3011d == null || drawable == null) {
            CameraLog.m12954a("ImageDownloader", "setImageDrawable, imageTagInfo: " + c3011d + ", drawable: " + drawable);
            return;
        }
        m17027a(c3011d.m17058a(), m17022a(c3011d.m17058a(), drawable, c3011d.m17068f(), c3011d.m17066d(), c3011d.m17067e()), c3011d.m17065c());
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x001f  */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private android.graphics.drawable.Drawable m17022a(com.oplus.camera.sticker.p168ui.GridItemViewTag r3, android.graphics.drawable.Drawable r4, int r5, boolean r6, boolean r7) throws android.content.res.Resources.NotFoundException {
        /*
            r2 = this;
            if (r7 == 0) goto L6
            android.graphics.drawable.Drawable r4 = r2.m17020a(r4)
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
            android.graphics.drawable.Drawable r4 = r2.m17033b(r3, r4)
            goto L2d
        L1f:
            android.graphics.drawable.Drawable r4 = r2.m17041d(r3, r4)
            goto L2d
        L24:
            android.graphics.drawable.Drawable r4 = r2.m17039c(r3, r4)
            goto L2d
        L29:
            android.graphics.drawable.Drawable r4 = r2.m17021a(r3, r4)
        L2d:
            int r3 = r4.getIntrinsicWidth()
            int r1 = r2.f16334e
            if (r3 <= r1) goto L44
            android.graphics.drawable.Drawable[] r3 = new android.graphics.drawable.Drawable[r0]
            r0 = 0
            r3[r0] = r4
            android.graphics.drawable.LayerDrawable r4 = new android.graphics.drawable.LayerDrawable
            r4.<init>(r3)
            int r3 = r2.f16334e
            r4.setLayerSize(r0, r3, r3)
        L44:
            if (r6 == 0) goto L4c
            if (r7 == r5) goto L4c
            android.graphics.drawable.LayerDrawable r4 = r2.m17035b(r4)
        L4c:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.sticker.p168ui.ImageDownloader.m17022a(com.oplus.camera.sticker.ui.IntrinsicsJvm.kt_4, android.graphics.drawable.Drawable, int, boolean, boolean):android.graphics.drawable.Drawable");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private Drawable m17020a(Drawable drawable) throws Resources.NotFoundException {
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{drawable});
        Drawable drawable2 = this.f16332c.getResources().getDrawable(R.drawable.sticker_music, null);
        if (drawable2 != null) {
            layerDrawable.addLayer(drawable2);
        }
        return layerDrawable;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private Drawable m17021a(GridItemViewTag c3009b, Drawable drawable) throws Resources.NotFoundException {
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{drawable});
        drawable.setAlpha(255);
        Drawable drawable2 = this.f16332c.getResources().getDrawable(R.drawable.sticker_need_download, null);
        if (drawable2 != null) {
            layerDrawable.addLayer(drawable2);
        }
        if (c3009b.f16322a != null) {
            c3009b.f16322a.setVisibility(8);
            c3009b.f16322a.clearAnimation();
        }
        return layerDrawable;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Drawable m17033b(GridItemViewTag c3009b, Drawable drawable) {
        drawable.setAlpha(255);
        if (c3009b.f16322a != null) {
            c3009b.f16322a.setVisibility(8);
            c3009b.f16322a.clearAnimation();
        }
        return drawable;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private Drawable m17039c(GridItemViewTag c3009b, Drawable drawable) {
        drawable.setAlpha(127);
        if (c3009b.f16322a != null) {
            c3009b.f16322a.setVisibility(0);
            c3009b.f16322a.m18290a();
        }
        return drawable;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private Drawable m17041d(GridItemViewTag c3009b, Drawable drawable) throws Resources.NotFoundException {
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{drawable});
        drawable.setAlpha(255);
        Drawable drawable2 = this.f16332c.getResources().getDrawable(R.drawable.sticker_need_refresh, null);
        if (drawable2 != null) {
            layerDrawable.addLayer(drawable2);
        }
        if (c3009b.f16322a != null) {
            c3009b.f16322a.setVisibility(8);
            c3009b.f16322a.clearAnimation();
        }
        return layerDrawable;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m17027a(GridItemViewTag c3009b, Drawable drawable, String str) {
        if (c3009b.f16323b != null) {
            c3009b.f16323b.setImageDrawable(drawable);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private LayerDrawable m17035b(Drawable drawable) {
        Drawable[] drawableArr = {drawable, this.f16332c.getResources().getDrawable(R.drawable.sticker_red_point)};
        LayerDrawable layerDrawable = new LayerDrawable(drawableArr);
        int intrinsicWidth = drawableArr[0].getIntrinsicWidth();
        int intrinsicWidth2 = drawableArr[1].getIntrinsicWidth();
        int OplusGLSurfaceView_13 = this.f16337h;
        int i2 = (OplusGLSurfaceView_13 - intrinsicWidth) / 2;
        int i3 = i2 + 0;
        int i4 = OplusGLSurfaceView_13 - (intrinsicWidth + i2);
        int i5 = this.f16336g;
        int i6 = OplusGLSurfaceView_13 - ((intrinsicWidth2 / 2) + i5);
        int i7 = i5 - this.f16335f;
        int i8 = i6 + intrinsicWidth2;
        int i9 = i6 - 0;
        int i10 = i7 + 0;
        int i11 = OplusGLSurfaceView_13 - i8;
        int i12 = OplusGLSurfaceView_13 - (intrinsicWidth2 + i7);
        if (i3 < 0 || i3 < 0 || i4 > 0 || i4 > 0) {
            CameraLog.m12967f("ImageDownloader", "showRedPoint, drawable0 out of thumbnail display!");
        }
        layerDrawable.setLayerInset(0, i3, i3, i4, i4);
        layerDrawable.setLayerInset(1, i9, i10, i11, i12);
        return layerDrawable;
    }
}
