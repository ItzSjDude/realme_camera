package com.oplus.camera.p172ui.preview.p177a;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import com.coui.appcompat.dialog.app.COUIAlertDialog;
import com.heytap.accessory.constant.AFConstants;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.statistics.CameraStatisticsUtil;
import com.oplus.camera.sticker.StickerItemDBHelper;
import com.oplus.camera.sticker.StickerMediator;
import com.oplus.camera.sticker.IStickerCallback;
import com.oplus.camera.sticker.data.StickerCategoryItem;
import com.oplus.camera.sticker.data.StickerItem;
import com.oplus.camera.sticker.p168ui.StickerMenu;
import com.oplus.camera.util.ToastUtil;
import com.oplus.util.OplusNetworkUtil;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: ImageStickerTools.java */
/* renamed from: com.oplus.camera.ui.preview.PlatformImplementations.kt_3.q */
/* loaded from: classes2.dex */
public class ImageStickerTools {

    /* renamed from: PlatformImplementations.kt_3 */
    private static ImageStickerTools f21405a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static Object f21406b = new Object();

    /* renamed from: IntrinsicsJvm.kt_3 */
    private Context f21407c;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private SharedPreferences f21409e;

    /* renamed from: o */
    private COUIAlertDialog f21419o;

    /* renamed from: p */
    private StickerItem f21420p;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private IntrinsicsJvm.kt_3 f21408d = new IntrinsicsJvm.kt_3();

    /* renamed from: COUIBaseListPopupWindow_12 */
    private HandlerThread f21410f = null;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private Handler f21411g = null;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private StickerDownloadListener f21412h = null;

    /* renamed from: OplusGLSurfaceView_13 */
    private long f21413i = 1;

    /* renamed from: OplusGLSurfaceView_15 */
    private StickerMediator f21414j = null;

    /* renamed from: OplusGLSurfaceView_5 */
    private HashMap<String, IntrinsicsJvm.kt_4> f21415k = null;

    /* renamed from: OplusGLSurfaceView_14 */
    private boolean f21416l = false;

    /* renamed from: OplusGLSurfaceView_6 */
    private int f21417m = 0;

    /* renamed from: OplusGLSurfaceView_11 */
    private boolean f21418n = false;

    /* renamed from: q */
    private IStickerCallback f21421q = new IStickerCallback() { // from class: com.oplus.camera.ui.preview.PlatformImplementations.kt_3.q.7
        @Override // com.oplus.camera.sticker.IStickerCallback
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo16733a(int OplusGLSurfaceView_13) {
            synchronized (ImageStickerTools.f21406b) {
                if (OplusGLSurfaceView_13 == 1) {
                    ImageStickerTools.this.m22720c();
                    if (ImageStickerTools.this.f21412h != null) {
                        ImageStickerTools.this.f21412h.mo12677a();
                    }
                }
            }
        }

        @Override // com.oplus.camera.sticker.IStickerCallback
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo16736b(StickerItem stickerItem) {
            if (stickerItem == null) {
                CameraLog.m12967f("ImageStickerTools", "onStickerDownloadSuccess return");
                return;
            }
            CameraLog.m12959b("ImageStickerTools", "onStickerDownloadSuccess, item: " + stickerItem);
            stickerItem.setDownloadState(8);
            synchronized (ImageStickerTools.f21406b) {
                ImageStickerTools.this.m22720c();
                if (ImageStickerTools.this.f21412h != null) {
                    ImageStickerTools.this.f21412h.mo12681b(stickerItem);
                }
            }
            if (ImageStickerTools.this.f21415k != null) {
                ImageStickerTools.this.m22679a((IntrinsicsJvm.kt_4) ImageStickerTools.this.f21415k.get(stickerItem.getStickerUUID()), true);
            }
        }

        @Override // com.oplus.camera.sticker.IStickerCallback
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo16734a(StickerItem stickerItem) {
            CameraLog.m12959b("ImageStickerTools", "onStickerDelete, item: " + stickerItem);
            if (stickerItem == null || !stickerItem.matchAppAttribute(1L)) {
                return;
            }
            synchronized (ImageStickerTools.f21406b) {
                ImageStickerTools.this.m22720c();
                if (ImageStickerTools.this.f21412h != null) {
                    ImageStickerTools.this.f21412h.mo12682c(stickerItem);
                }
            }
        }

        @Override // com.oplus.camera.sticker.IStickerCallback
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo16732a() {
            CameraLog.m12959b("ImageStickerTools", "onStickerImportFinish");
            synchronized (ImageStickerTools.f21406b) {
                ImageStickerTools.this.m22720c();
                if (ImageStickerTools.this.f21412h != null) {
                    ImageStickerTools.this.f21412h.mo12677a();
                }
            }
        }

        @Override // com.oplus.camera.sticker.IStickerCallback
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo16735a(StickerItem stickerItem, int OplusGLSurfaceView_13) {
            CameraLog.m12959b("ImageStickerTools", "onStickerDownloadFail, errorCode: " + OplusGLSurfaceView_13 + ", item: " + stickerItem);
            if (stickerItem != null) {
                if (ImageStickerTools.this.f21412h != null) {
                    ImageStickerTools.this.f21412h.mo12680a(stickerItem, OplusGLSurfaceView_13);
                }
                if (ImageStickerTools.this.f21415k != null) {
                    ImageStickerTools.this.m22679a((IntrinsicsJvm.kt_4) ImageStickerTools.this.f21415k.get(stickerItem.getStickerUUID()), false);
                    return;
                }
                return;
            }
            CameraLog.m12967f("ImageStickerTools", "onStickerDownloadFail return! Since item: " + stickerItem);
        }

        @Override // com.oplus.camera.sticker.IStickerCallback
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo16737b(StickerItem stickerItem, int OplusGLSurfaceView_13) {
            CameraLog.m12959b("ImageStickerTools", "onStickerDownloadPause, errorCode: " + OplusGLSurfaceView_13 + ", item: " + stickerItem);
            if (stickerItem != null) {
                if (ImageStickerTools.this.f21412h != null) {
                    ImageStickerTools.this.f21412h.mo12680a(stickerItem, OplusGLSurfaceView_13);
                }
                if (ImageStickerTools.this.f21415k != null) {
                    ImageStickerTools.this.m22679a((IntrinsicsJvm.kt_4) ImageStickerTools.this.f21415k.get(stickerItem.getStickerUUID()), false);
                    return;
                }
                return;
            }
            CameraLog.m12967f("ImageStickerTools", "onStickerDownloadPause return! Since item: " + stickerItem);
        }

        @Override // com.oplus.camera.sticker.IStickerCallback
        /* renamed from: IntrinsicsJvm.kt_3 */
        public void mo16738c(StickerItem stickerItem) {
            CameraLog.m12959b("ImageStickerTools", "onUpdateStickerDownloadTime, item: " + stickerItem);
            synchronized (ImageStickerTools.f21406b) {
                ImageStickerTools.this.m22720c();
                if (ImageStickerTools.this.f21412h != null) {
                    ImageStickerTools.this.f21412h.mo12683d(stickerItem);
                }
            }
        }
    };

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m22683a(int OplusGLSurfaceView_13) {
        return 2 == OplusGLSurfaceView_13;
    }

    private ImageStickerTools(Context context) {
        this.f21407c = null;
        this.f21407c = context;
        this.f21409e = this.f21407c.getSharedPreferences("sticker_info", 0);
        m22700h();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m22711a(Context context) {
        CameraLog.m12959b("ImageStickerTools", "initStickerMediator");
        if (this.f21414j == null) {
            this.f21414j = StickerMediator.m16958a(context);
            this.f21414j.m16959a();
            this.f21414j.m16960a(this.f21421q);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    private void m22700h() {
        if (this.f21410f == null) {
            this.f21410f = new HandlerThread("StickerHandlerThread");
            this.f21410f.start();
        }
        if (this.f21411g == null) {
            this.f21411g = new Handler(this.f21410f.getLooper());
        }
    }

    /* renamed from: OplusGLSurfaceView_13 */
    private void m22701i() {
        Handler handler = this.f21411g;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f21411g = null;
        }
        HandlerThread handlerThread = this.f21410f;
        if (handlerThread != null) {
            handlerThread.quitSafely();
            this.f21410f = null;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m22709a(final int OplusGLSurfaceView_13, boolean z) {
        synchronized (f21406b) {
            if (this.f21416l && OplusGLSurfaceView_13 == 0) {
                return;
            }
            this.f21416l = true;
            if (z) {
                if (this.f21411g != null) {
                    this.f21411g.post(new Runnable() { // from class: com.oplus.camera.ui.preview.PlatformImplementations.kt_3.q.1
                        @Override // java.lang.Runnable
                        public void run() {
                            synchronized (ImageStickerTools.f21406b) {
                                ImageStickerTools.this.m22689b(OplusGLSurfaceView_13);
                            }
                        }
                    });
                }
            } else {
                m22689b(OplusGLSurfaceView_13);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m22689b(int OplusGLSurfaceView_13) {
        m22720c();
        StickerDownloadListener interfaceC3425v = this.f21412h;
        if (interfaceC3425v != null) {
            interfaceC3425v.mo12678a(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public Integer m22707a() {
        return Integer.valueOf(this.f21417m - 1);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public IntrinsicsJvm.kt_3 m22718b() {
        return this.f21408d;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m22717a(String str) {
        SharedPreferences sharedPreferences = this.f21409e;
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean(str, false);
        }
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m22715a(String str, boolean z) {
        SharedPreferences sharedPreferences = this.f21409e;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putBoolean(str, z);
            editorEdit.apply();
        }
    }

    /* renamed from: OplusGLSurfaceView_15 */
    private boolean m22702j() {
        SharedPreferences sharedPreferences = this.f21409e;
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean("sticker_dialog_status", false);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_5 */
    public void m22703k() {
        SharedPreferences sharedPreferences = this.f21409e;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean("sticker_dialog_status", true).apply();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static ImageStickerTools m22687b(Context context) {
        ImageStickerTools c3420q;
        synchronized (f21406b) {
            if (f21405a == null && context != null) {
                f21405a = new ImageStickerTools(context.getApplicationContext());
            }
            c3420q = f21405a;
        }
        return c3420q;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m22720c() {
        CameraLog.m12954a("ImageStickerTools", "refreshStickerInfoByCameraId");
        if (this.f21407c == null) {
            CameraLog.m12967f("ImageStickerTools", "refreshStickerInfoByCameraId, mContext is null");
            return;
        }
        CameraLog.m12952a("refreshStickerInfoByCameraId");
        this.f21408d.m22744a(m22688b(m22722d()));
        List<StickerItem> listM22708a = m22708a(this.f21408d.m22749c());
        if (listM22708a != null) {
            Iterator<StickerItem> it = listM22708a.iterator();
            while (it.hasNext()) {
                m22712a(it.next());
            }
        } else {
            CameraLog.m12967f("ImageStickerTools", "initStickerInfoToMap, databaseList is null");
        }
        CameraLog.m12958b("refreshStickerInfoByCameraId");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0029  */
    /* renamed from: IntrinsicsJvm.kt_5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.ArrayList<com.oplus.camera.sticker.data.StickerCategoryItem> m22722d() {
        /*
            r4 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            android.content.Context r1 = r4.f21407c
            long r2 = r4.f21413i
            android.database.Cursor r4 = com.oplus.camera.sticker.StickerCategoryDBHelper.m16930a(r1, r2)
            if (r4 == 0) goto L27
        Lf:
            boolean r1 = r4.moveToNext()     // Catch: java.lang.Throwable -> L1d java.lang.Exception -> L24
            if (r1 == 0) goto L27
            com.oplus.camera.sticker.data.StickerCategoryItem r1 = com.oplus.camera.sticker.StickerCategoryDBHelper.m16932a(r4)     // Catch: java.lang.Throwable -> L1d java.lang.Exception -> L24
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
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.p172ui.preview.p177a.ImageStickerTools.m22722d():java.util.ArrayList");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public List<StickerItem> m22708a(ArrayList<StickerMenu.IntrinsicsJvm.kt_4> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        try {
            Iterator<StickerMenu.IntrinsicsJvm.kt_4> it = arrayList.iterator();
            while (it.hasNext()) {
                StickerMenu.IntrinsicsJvm.kt_4 next = it.next();
                Cursor cursorM16950a = StickerItemDBHelper.m16950a(this.f21407c, this.f21413i, next.f16443c);
                if (cursorM16950a != null) {
                    if (StickerCategoryItem.isMyCategory(next.f16443c)) {
                        this.f21417m = cursorM16950a.getCount();
                    }
                    while (cursorM16950a.moveToNext()) {
                        StickerItem stickerItemM16953a = StickerItemDBHelper.m16953a(cursorM16950a);
                        stickerItemM16953a.getCategoryId();
                        if (StickerCategoryItem.isMyCategory(next.f16443c)) {
                            stickerItemM16953a.setCategoryId(next.f16443c);
                        }
                        arrayList2.add(stickerItemM16953a);
                    }
                    cursorM16950a.close();
                }
            }
        } catch (Exception COUIBaseListPopupWindow_8) {
            CameraLog.m12967f("ImageStickerTools", "querySingleStickerInfo, COUIBaseListPopupWindow_8: " + COUIBaseListPopupWindow_8);
        }
        return arrayList2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public StickerItem m22706a(SharedPreferences sharedPreferences) {
        StickerItem stickerItemM16952a;
        if (sharedPreferences == null) {
            CameraLog.m12967f("ImageStickerTools", "getSelectedStickerItem, preferences: " + sharedPreferences);
            return null;
        }
        CameraLog.m12952a("getSelectedStickerItem");
        String string = sharedPreferences.getString(CameraUIInterface.KEY_CURRENT_STICKER_UUID, "unselected_uuid");
        if ("unselected_uuid".equals(string) || (stickerItemM16952a = StickerItemDBHelper.m16952a(this.f21407c, AFConstants.EXTRA_UUID, string)) == null || !stickerItemM16952a.isDownloaded()) {
            return null;
        }
        CameraLog.m12958b("getSelectedStickerItem");
        return stickerItemM16952a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:46:0x004a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v0, types: [android.net.Uri] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.io.InputStream] */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.graphics.drawable.Drawable m22705a(android.content.Context r3, android.net.Uri r4) throws java.lang.Throwable {
        /*
            r2 = this;
            android.content.ContentResolver r0 = r3.getContentResolver()
            r1 = 0
            java.io.InputStream r4 = r0.openInputStream(r4)     // Catch: java.lang.Throwable -> L28 java.io.FileNotFoundException -> L2b
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeStream(r4)     // Catch: java.lang.Throwable -> L24 java.io.FileNotFoundException -> L26
            if (r0 == 0) goto L1e
            android.graphics.drawable.BitmapDrawable r2 = com.oplus.camera.util.Util.m24227a(r3, r0)     // Catch: java.lang.Throwable -> L24 java.io.FileNotFoundException -> L26
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
            android.content.Context r2 = r2.f21407c
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
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.p172ui.preview.p177a.ImageStickerTools.m22705a(android.content.Context, android.net.Uri):android.graphics.drawable.Drawable");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static byte[] m22685a(Context context, String str) throws IOException {
        InputStream inputStreamOpenInputStream = null;
        if (context == null || TextUtils.isEmpty(str)) {
            CameraLog.m12959b("ImageStickerTools", "readStickerStream, context or stickerUri is null");
            return null;
        }
        byte[] bArr = new byte[1024];
        ContentResolver contentResolver = context.getContentResolver();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                inputStreamOpenInputStream = contentResolver.openInputStream(Uri.parse(str));
                while (inputStreamOpenInputStream != null) {
                    int OplusGLSurfaceView_13 = inputStreamOpenInputStream.read(bArr);
                    if (OplusGLSurfaceView_13 == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, OplusGLSurfaceView_13);
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                if (inputStreamOpenInputStream != null) {
                    try {
                        inputStreamOpenInputStream.close();
                    } catch (IOException COUIBaseListPopupWindow_8) {
                        COUIBaseListPopupWindow_8.printStackTrace();
                    }
                }
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                return byteArray;
            } catch (Exception e3) {
                CameraLog.m12967f("ImageStickerTools", "readStickerStream, ex: " + e3);
                if (inputStreamOpenInputStream != null) {
                    try {
                        inputStreamOpenInputStream.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
                return bArr;
            }
        } finally {
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private ArrayList<StickerMenu.IntrinsicsJvm.kt_4> m22688b(ArrayList<StickerCategoryItem> arrayList) throws Throwable {
        Drawable drawable;
        ArrayList<StickerMenu.IntrinsicsJvm.kt_4> arrayList2 = new ArrayList<>();
        this.f21408d.m22741a();
        if (arrayList != null) {
            int OplusGLSurfaceView_13 = 0;
            Iterator<StickerCategoryItem> it = arrayList.iterator();
            while (it.hasNext()) {
                StickerCategoryItem next = it.next();
                if (next != null) {
                    String iconHighlightFileUri = next.getIconHighlightFileUri();
                    String iconFileUri = next.getIconFileUri();
                    boolean zIsCategoryNew = next.isCategoryNew();
                    Drawable drawable2 = null;
                    if (TextUtils.isEmpty(iconFileUri)) {
                        drawable = null;
                    } else {
                        drawable = m22705a(this.f21407c, Uri.parse(iconFileUri));
                    }
                    if (drawable == null) {
                        drawable = this.f21407c.getDrawable(R.drawable.unselect_preset);
                    }
                    if (!TextUtils.isEmpty(iconHighlightFileUri)) {
                        drawable2 = m22705a(this.f21407c, Uri.parse(iconHighlightFileUri));
                    }
                    if (drawable2 == null) {
                        drawable2 = this.f21407c.getDrawable(R.drawable.select_preset);
                    }
                    arrayList2.add(new StickerMenu.IntrinsicsJvm.kt_4(drawable2, drawable, next.getReadableId(), zIsCategoryNew));
                    this.f21408d.m22747b(next.getReadableId(), OplusGLSurfaceView_13);
                    OplusGLSurfaceView_13++;
                }
            }
        }
        return arrayList2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m22716a(Activity activity, StickerItem stickerItem) {
        StringBuilder sb = new StringBuilder();
        sb.append("onEffectClick, isDownloaded: ");
        sb.append(stickerItem != null ? Boolean.valueOf(stickerItem.isDownloaded()) : null);
        sb.append(", item.needUpdate: ");
        sb.append(stickerItem != null ? Boolean.valueOf(stickerItem.needUpdate()) : null);
        CameraLog.m12954a("ImageStickerTools", sb.toString());
        if (stickerItem != null) {
            if (!stickerItem.needUpdate() && stickerItem.isDownloaded()) {
                return false;
            }
            Context context = this.f21407c;
            if (context != null) {
                if (OplusNetworkUtil.isWifiConnected(context)) {
                    stickerItem.setDownloadState(2);
                    StickerDownloadListener interfaceC3425v = this.f21412h;
                    if (interfaceC3425v != null) {
                        interfaceC3425v.mo12679a(stickerItem);
                    }
                    StickerMediator c3001h = this.f21414j;
                    if (c3001h != null) {
                        c3001h.m16963a(stickerItem, false);
                        m22697e(stickerItem);
                    }
                } else if (OplusNetworkUtil.isMobileDataConnected(this.f21407c)) {
                    m22690b(activity, stickerItem);
                } else {
                    ToastUtil.m24640a(this.f21407c, R.string.sticker_toast_disconnect);
                    stickerItem.setDownloadState(16);
                    StickerDownloadListener interfaceC3425v2 = this.f21412h;
                    if (interfaceC3425v2 != null) {
                        interfaceC3425v2.mo12679a(stickerItem);
                    }
                }
            }
            return true;
        }
        CameraLog.m12966e("ImageStickerTools", "onEffectClick, item is null!");
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m22712a(StickerItem stickerItem) {
        if (stickerItem != null) {
            CopyOnWriteArrayList<StickerItem> copyOnWriteArrayListM22740a = this.f21408d.m22740a(stickerItem.getCategoryId());
            if (copyOnWriteArrayListM22740a == null) {
                copyOnWriteArrayListM22740a = new CopyOnWriteArrayList<>();
                this.f21408d.m22743a(stickerItem.getCategoryId(), copyOnWriteArrayListM22740a);
            }
            copyOnWriteArrayListM22740a.add(stickerItem);
            this.f21408d.m22742a(stickerItem.getStickerUUID(), copyOnWriteArrayListM22740a.indexOf(stickerItem));
            return;
        }
        CameraLog.m12967f("ImageStickerTools", "refreshSticker, item is null");
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m22719b(String str) {
        synchronized (f21406b) {
            this.f21408d.m22746b(str);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0051 A[Catch: all -> 0x0063, TryCatch #0 {, blocks: (B:5:0x0005, B:6:0x000e, B:8:0x0027, B:10:0x002d, B:12:0x0033, B:16:0x005f, B:13:0x0051, B:15:0x0055), top: B:22:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0055 A[Catch: all -> 0x0063, TryCatch #0 {, blocks: (B:5:0x0005, B:6:0x000e, B:8:0x0027, B:10:0x002d, B:12:0x0033, B:16:0x005f, B:13:0x0051, B:15:0x0055), top: B:22:0x0005 }] */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m22713a(final com.oplus.camera.p172ui.preview.p177a.ImageCallback r7, final com.oplus.camera.sticker.data.StickerItem r8, final boolean r9) {
        /*
            r6 = this;
            java.lang.Object r0 = com.oplus.camera.p172ui.preview.p177a.ImageStickerTools.f21406b
            monitor-enter(r0)
            if (r8 == 0) goto Le
            java.lang.String r1 = r8.getCategoryId()     // Catch: java.lang.Throwable -> L63
            com.oplus.camera.ui.preview.PlatformImplementations.kt_3.q$IntrinsicsJvm.kt_3 r2 = r6.f21408d     // Catch: java.lang.Throwable -> L63
            r2.m22746b(r1)     // Catch: java.lang.Throwable -> L63
        Le:
            com.oplus.camera.ui.preview.PlatformImplementations.kt_3.q$IntrinsicsJvm.kt_3 r1 = r6.f21408d     // Catch: java.lang.Throwable -> L63
            java.util.concurrent.CopyOnWriteArrayList r1 = r1.m22745b()     // Catch: java.lang.Throwable -> L63
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L63
            com.oplus.camera.ui.preview.PlatformImplementations.kt_3.q$IntrinsicsJvm.kt_3 r3 = r6.f21408d     // Catch: java.lang.Throwable -> L63
            java.util.ArrayList r3 = r3.m22749c()     // Catch: java.lang.Throwable -> L63
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L63
            com.oplus.camera.ui.preview.PlatformImplementations.kt_3.q$IntrinsicsJvm.kt_3 r3 = r6.f21408d     // Catch: java.lang.Throwable -> L63
            int r3 = r3.m22750d()     // Catch: java.lang.Throwable -> L63
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
            com.oplus.camera.CameraLog.m12954a(r6, r1)     // Catch: java.lang.Throwable -> L63
            r7.mo12657a(r2, r3, r8, r9)     // Catch: java.lang.Throwable -> L63
            goto L5f
        L51:
            android.os.Handler r1 = r6.f21411g     // Catch: java.lang.Throwable -> L63
            if (r1 == 0) goto L5f
            android.os.Handler r1 = r6.f21411g     // Catch: java.lang.Throwable -> L63
            com.oplus.camera.ui.preview.PlatformImplementations.kt_3.q$2 r2 = new com.oplus.camera.ui.preview.PlatformImplementations.kt_3.q$2     // Catch: java.lang.Throwable -> L63
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
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.p172ui.preview.p177a.ImageStickerTools.m22713a(com.oplus.camera.ui.preview.PlatformImplementations.kt_3.p, com.oplus.camera.sticker.data.StickerItem, boolean):void");
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m22721c(Context context) {
        CameraLog.m12954a("ImageStickerTools", "releaseResource");
        if (context.getApplicationContext() != this.f21407c) {
            CameraLog.m12954a("ImageStickerTools", "releaseResource, return");
            return;
        }
        StickerMediator c3001h = this.f21414j;
        if (c3001h != null) {
            c3001h.m16966b(this.f21421q);
            this.f21414j.m16965b();
            this.f21414j = null;
        }
        synchronized (f21406b) {
            this.f21408d.m22741a();
            m22701i();
            this.f21416l = false;
            f21405a = null;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m22714a(StickerDownloadListener interfaceC3425v) {
        this.f21412h = interfaceC3425v;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m22710a(Activity activity) {
        COUIAlertDialog dialogInterfaceC1289b = this.f21419o;
        if (dialogInterfaceC1289b == null || !dialogInterfaceC1289b.isShowing()) {
            return;
        }
        m22678a(activity, this.f21418n, true);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m22723e() {
        COUIAlertDialog dialogInterfaceC1289b = this.f21419o;
        if (dialogInterfaceC1289b != null && dialogInterfaceC1289b.isShowing()) {
            this.f21419o.dismiss();
        }
        this.f21419o = null;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m22690b(Activity activity, StickerItem stickerItem) {
        if (activity == null) {
            CameraLog.m12959b("ImageStickerTools", "showNetworkWarningDialog, context is null .");
        } else if (m22702j()) {
            m22694d(stickerItem);
        } else {
            this.f21420p = stickerItem;
            m22678a(activity, this.f21418n, false);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m22678a(Activity activity, boolean z, boolean z2) {
        COUIAlertDialog dialogInterfaceC1289b = this.f21419o;
        if (dialogInterfaceC1289b != null && (dialogInterfaceC1289b.isShowing() || z2)) {
            this.f21419o.cancel();
            this.f21419o = null;
        }
        View viewInflate = LayoutInflater.from(activity).inflate(R.layout.sticker_warning_checkbox, (ViewGroup) null);
        final CheckBox checkBox = (CheckBox) ((LinearLayout) viewInflate).findViewById(R.id_renamed.sticker_check_box_never);
        if (z2) {
            checkBox.setChecked(z);
        }
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.oplus.camera.ui.preview.PlatformImplementations.kt_3.q.3
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
                ImageStickerTools.this.f21418n = z3;
            }
        });
        this.f21419o = new COUIAlertDialog.PlatformImplementations.kt_3(activity, 2131821271).setCancelable(false).setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.oplus.camera.ui.preview.PlatformImplementations.kt_3.q.6
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int OplusGLSurfaceView_13, KeyEvent keyEvent) {
                if (4 != OplusGLSurfaceView_13) {
                    return false;
                }
                dialogInterface.dismiss();
                return false;
            }
        }).setPositiveButton(R.string.sticker_continue_download, new DialogInterface.OnClickListener() { // from class: com.oplus.camera.ui.preview.PlatformImplementations.kt_3.q.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int OplusGLSurfaceView_13) {
                ImageStickerTools c3420q = ImageStickerTools.this;
                c3420q.m22694d(c3420q.f21420p);
                if (ImageStickerTools.this.f21418n) {
                    ImageStickerTools.this.m22703k();
                }
            }
        }).setNegativeButton(R.string.sticker_cancel_download, (DialogInterface.OnClickListener) null).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.oplus.camera.ui.preview.PlatformImplementations.kt_3.q.4
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                ImageStickerTools.this.f21418n = checkBox.isChecked();
            }
        }).setTitle(R.string.sticker_consumption_networks_dialog).setView(viewInflate).create();
        CameraLog.m12954a("ImageStickerTools", "startDownloadFromDialog mWarningDialog created");
        if (activity.isFinishing()) {
            CameraLog.m12954a("ImageStickerTools", "startDownloadFromDialog activity isFinishing");
        } else {
            this.f21419o.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m22694d(StickerItem stickerItem) {
        CameraLog.m12954a("ImageStickerTools", "startDownloadFromDialog");
        stickerItem.setDownloadState(2);
        StickerDownloadListener interfaceC3425v = this.f21412h;
        if (interfaceC3425v != null) {
            interfaceC3425v.mo12679a(stickerItem);
        }
        StickerMediator.m16958a(this.f21407c).m16963a(stickerItem, true);
        m22697e(stickerItem);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static boolean m22691b(StickerItem stickerItem) {
        if (stickerItem != null) {
            return m22683a(stickerItem.getMaterialType());
        }
        return false;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static boolean m22692c(StickerItem stickerItem) {
        return stickerItem != null && stickerItem.getMaterialType() == 1;
    }

    /* compiled from: ImageStickerTools.java */
    /* renamed from: com.oplus.camera.ui.preview.PlatformImplementations.kt_3.q$IntrinsicsJvm.kt_3 */
    public static class IntrinsicsJvm.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        public CopyOnWriteArrayList<PlatformImplementations.kt_3> f21442a = new CopyOnWriteArrayList<>();

        /* renamed from: IntrinsicsJvm.kt_4 */
        public Map<String, Integer> f21443b = new HashMap();

        /* renamed from: IntrinsicsJvm.kt_3 */
        public Map<String, Integer> f21444c = new HashMap();

        /* renamed from: IntrinsicsJvm.kt_5 */
        public ArrayList<StickerMenu.IntrinsicsJvm.kt_4> f21445d = new ArrayList<>();

        /* renamed from: COUIBaseListPopupWindow_8 */
        private String f21446e = null;

        /* renamed from: PlatformImplementations.kt_3 */
        public void m22741a() {
            CameraLog.m12954a("ImageStickerTools", "recycle");
            this.f21442a.clear();
            this.f21443b.clear();
            this.f21444c.clear();
            this.f21445d.clear();
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public CopyOnWriteArrayList<StickerItem> m22740a(String str) {
            int iM22739a = m22739a(this.f21442a, str);
            if (iM22739a >= 0) {
                return this.f21442a.get(iM22739a).m22725a();
            }
            return null;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public CopyOnWriteArrayList<PlatformImplementations.kt_3> m22745b() {
            return this.f21442a;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m22743a(String str, CopyOnWriteArrayList<StickerItem> copyOnWriteArrayList) {
            PlatformImplementations.kt_3 aVar = new PlatformImplementations.kt_3();
            aVar.m22726a(str);
            aVar.m22727a(copyOnWriteArrayList);
            this.f21442a.add(aVar);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m22744a(ArrayList<StickerMenu.IntrinsicsJvm.kt_4> arrayList) {
            this.f21445d = arrayList;
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        public ArrayList<StickerMenu.IntrinsicsJvm.kt_4> m22749c() {
            return this.f21445d;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public void m22746b(String str) {
            this.f21446e = str;
        }

        /* renamed from: IntrinsicsJvm.kt_5 */
        public int m22750d() {
            ArrayList<StickerMenu.IntrinsicsJvm.kt_4> arrayList = this.f21445d;
            if (arrayList == null) {
                return 1;
            }
            Iterator<StickerMenu.IntrinsicsJvm.kt_4> it = arrayList.iterator();
            int OplusGLSurfaceView_13 = 0;
            while (it.hasNext()) {
                if (it.next().f16443c.equals(this.f21446e)) {
                    return OplusGLSurfaceView_13;
                }
                OplusGLSurfaceView_13++;
            }
            return 1;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m22742a(String str, int OplusGLSurfaceView_13) {
            this.f21443b.put(str, Integer.valueOf(OplusGLSurfaceView_13));
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        public Integer m22748c(String str) {
            return this.f21443b.get(str);
        }

        /* renamed from: IntrinsicsJvm.kt_5 */
        public boolean m22751d(String str) {
            return this.f21443b.get(str) != null;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public void m22747b(String str, int OplusGLSurfaceView_13) {
            this.f21444c.put(str, Integer.valueOf(OplusGLSurfaceView_13));
        }

        /* renamed from: COUIBaseListPopupWindow_8 */
        public Integer m22752e(String str) {
            Integer num;
            synchronized (ImageStickerTools.f21406b) {
                num = this.f21444c.get(str);
            }
            return num;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public int m22739a(CopyOnWriteArrayList<PlatformImplementations.kt_3> copyOnWriteArrayList, String str) {
            if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty() || str == null) {
                return -1;
            }
            Iterator<PlatformImplementations.kt_3> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                PlatformImplementations.kt_3 next = it.next();
                if (str.equals(next.m22728b())) {
                    return copyOnWriteArrayList.indexOf(next);
                }
            }
            return -1;
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m22724f() {
        if (this.f21414j != null) {
            CameraLog.m12959b("ImageStickerTools", "requestSticker");
            this.f21414j.m16969c();
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m22697e(StickerItem stickerItem) {
        CameraLog.m12959b("ImageStickerTools", "startDownloadStickerNearme");
        if (this.f21415k == null) {
            this.f21415k = new HashMap<>();
        }
        IntrinsicsJvm.kt_4 bVar = new IntrinsicsJvm.kt_4();
        bVar.f21438c = System.currentTimeMillis();
        bVar.f21439d = m22704l();
        bVar.f21437b = stickerItem.getStickerUUID();
        bVar.f21440e = stickerItem.getStickerName();
        bVar.f21441f = stickerItem.getCategoryId();
        this.f21415k.put(stickerItem.getStickerUUID(), bVar);
    }

    /* renamed from: OplusGLSurfaceView_14 */
    private int m22704l() {
        if (OplusNetworkUtil.isWifiConnected(this.f21407c)) {
            return 1;
        }
        return OplusNetworkUtil.isMobileDataConnected(this.f21407c) ? 0 : -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m22679a(IntrinsicsJvm.kt_4 bVar, boolean z) {
        if (bVar == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(CameraStatisticsUtil.format(CameraStatisticsUtil.STICKER_UUID, bVar.f21437b));
        sb.append(CameraStatisticsUtil.format(CameraStatisticsUtil.STICKER_TYPE, bVar.f21441f));
        sb.append(CameraStatisticsUtil.format(CameraStatisticsUtil.STICKER_NAME, bVar.f21440e));
        sb.append(CameraStatisticsUtil.format(CameraStatisticsUtil.STICKER_DOWNLOAD_RESULT, z ? "0" : "1"));
        sb.append(CameraStatisticsUtil.format(CameraStatisticsUtil.STICKER_NETWORK, String.valueOf(bVar.f21439d)));
        long jCurrentTimeMillis = System.currentTimeMillis() - bVar.f21438c;
        if (jCurrentTimeMillis > 0) {
            sb.append(CameraStatisticsUtil.format(CameraStatisticsUtil.STICKER_DOWNLOAD_COST_TIME, String.valueOf(jCurrentTimeMillis)));
        }
        CameraStatisticsUtil.onCommon(this.f21407c, "sticker_download", sb.toString());
        HashMap<String, IntrinsicsJvm.kt_4> map = this.f21415k;
        if (map != null) {
            map.remove(bVar.f21437b);
        }
    }

    /* compiled from: ImageStickerTools.java */
    /* renamed from: com.oplus.camera.ui.preview.PlatformImplementations.kt_3.q$PlatformImplementations.kt_3 */
    public static class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        private CopyOnWriteArrayList<StickerItem> f21434a = null;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private String f21435b = null;

        /* renamed from: PlatformImplementations.kt_3 */
        public void m22727a(CopyOnWriteArrayList<StickerItem> copyOnWriteArrayList) {
            this.f21434a = copyOnWriteArrayList;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m22726a(String str) {
            this.f21435b = str;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public CopyOnWriteArrayList<StickerItem> m22725a() {
            return this.f21434a;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public String m22728b() {
            return this.f21435b;
        }
    }

    /* compiled from: ImageStickerTools.java */
    /* renamed from: com.oplus.camera.ui.preview.PlatformImplementations.kt_3.q$IntrinsicsJvm.kt_4 */
    private class IntrinsicsJvm.kt_4 {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private String f21437b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private long f21438c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private int f21439d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        private String f21440e;

        /* renamed from: COUIBaseListPopupWindow_12 */
        private String f21441f;

        private IntrinsicsJvm.kt_4() {
            this.f21437b = "";
            this.f21438c = 0L;
            this.f21439d = -1;
            this.f21440e = "";
            this.f21441f = "";
        }
    }
}
