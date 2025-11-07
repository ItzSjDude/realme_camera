package com.oplus.camera.sticker;

import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import com.oplus.camera.CameraLog;
import com.oplus.camera.sticker.data.StickerDataManager;
import com.oplus.camera.sticker.data.StickerItem;
import com.oplus.camera.sticker.download.DownloadManagerHelper;
import com.oplus.camera.sticker.download.thumbnail.ThumbDownloadService;
import com.oplus.camera.sticker.p167c.FileUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: StickerMediator.java */
/* renamed from: com.oplus.camera.sticker.COUIBaseListPopupWindow_10 */
/* loaded from: classes2.dex */
public class StickerMediator implements StickerDataManager.PlatformImplementations.kt_3 {

    /* renamed from: PlatformImplementations.kt_3 */
    private static volatile StickerMediator f16255a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Context f16256b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private StickerDataManager f16257c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private ConcurrentHashMap<String, IStickerCallback> f16258d = new ConcurrentHashMap<>();

    /* renamed from: COUIBaseListPopupWindow_8 */
    private boolean f16259e = false;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private boolean f16260f = false;

    /* renamed from: PlatformImplementations.kt_3 */
    public static StickerMediator m16958a(Context context) {
        if (f16255a == null) {
            synchronized (StickerMediator.class) {
                if (f16255a == null) {
                    CameraLog.m12959b("StickerMediator", "getInstance");
                    f16255a = new StickerMediator(context.getApplicationContext());
                }
            }
        }
        return f16255a;
    }

    private StickerMediator(Context context) {
        this.f16256b = null;
        this.f16257c = null;
        CameraLog.m12959b("StickerMediator", "StickerMediator");
        this.f16256b = context;
        this.f16257c = new StickerDataManager(context);
        this.f16257c.m16871a(this);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m16959a() {
        CameraLog.m12959b("StickerMediator", "create, mbCreated: " + this.f16259e + ", mbDataLoaded: " + this.f16260f);
        CameraLog.m12952a("StickerMediator.create");
        DownloadManagerHelper.m16879a().m16888c(this.f16256b);
        if (!this.f16259e) {
            this.f16257c.m16867a();
            this.f16259e = true;
            if (!this.f16260f) {
                this.f16257c.m16875d();
                FileUtils.m16819c(FileUtils.f16223k);
                this.f16260f = true;
            }
        }
        CameraLog.m12958b("StickerMediator.create");
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m16965b() {
        CameraLog.m12959b("StickerMediator", "release, mIsCreated: " + this.f16259e);
        if (this.f16259e) {
            this.f16257c.m16873b();
            this.f16259e = false;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public synchronized void m16960a(IStickerCallback interfaceC2969a) {
        this.f16257c.m16877f();
        if (interfaceC2969a != null) {
            String strValueOf = String.valueOf(Binder.getCallingPid());
            if (this.f16258d.get(strValueOf) != null) {
                this.f16258d.remove(strValueOf);
            }
            this.f16258d.put(strValueOf, interfaceC2969a);
            CameraLog.m12959b("StickerMediator", "addStickerCallback, mStickerCallbacks.size: " + this.f16258d.size());
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public synchronized void m16966b(IStickerCallback interfaceC2969a) {
        String strValueOf = String.valueOf(Binder.getCallingPid());
        if (this.f16258d.get(strValueOf) != null) {
            this.f16258d.remove(strValueOf);
        }
        if (this.f16258d.isEmpty()) {
            this.f16256b.stopService(new Intent(this.f16256b, (Class<?>) ThumbDownloadService.class));
            CameraLog.m12959b("StickerMediator", "removeStickerCallback, stop ThumbDownloadService");
        }
        CameraLog.m12959b("StickerMediator", "removeStickerCallback, mStickerCallbacks.size: " + this.f16258d.size());
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m16969c() {
        this.f16257c.m16876e();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m16961a(StickerItem stickerItem) {
        CameraLog.m12959b("StickerMediator", "updateStickerDownloadTime, item: " + stickerItem);
        this.f16257c.m16869a(stickerItem);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m16963a(StickerItem stickerItem, boolean z) {
        this.f16257c.m16870a(stickerItem, z);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m16964a(List<StickerItem> list) {
        this.f16257c.m16872a(list);
    }

    @Override // com.oplus.camera.sticker.data.StickerDataManager.PlatformImplementations.kt_3
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo16878a(int OplusGLSurfaceView_13) {
        Iterator<Map.Entry<String, IStickerCallback>> it = this.f16258d.entrySet().iterator();
        while (it.hasNext()) {
            try {
                IStickerCallback value = it.next().getValue();
                if (value != null) {
                    value.mo16733a(OplusGLSurfaceView_13);
                }
            } catch (Exception COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m16967b(StickerItem stickerItem) {
        Iterator<Map.Entry<String, IStickerCallback>> it = this.f16258d.entrySet().iterator();
        while (it.hasNext()) {
            try {
                IStickerCallback value = it.next().getValue();
                if (value != null) {
                    value.mo16736b(stickerItem);
                }
            } catch (Exception COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m16970c(StickerItem stickerItem) {
        Iterator<Map.Entry<String, IStickerCallback>> it = this.f16258d.entrySet().iterator();
        while (it.hasNext()) {
            try {
                IStickerCallback value = it.next().getValue();
                if (value != null) {
                    value.mo16738c(stickerItem);
                }
            } catch (Exception COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m16972d(StickerItem stickerItem) {
        Iterator<Map.Entry<String, IStickerCallback>> it = this.f16258d.entrySet().iterator();
        while (it.hasNext()) {
            try {
                IStickerCallback value = it.next().getValue();
                if (value != null) {
                    value.mo16734a(stickerItem);
                }
            } catch (Exception COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m16971d() {
        Iterator<Map.Entry<String, IStickerCallback>> it = this.f16258d.entrySet().iterator();
        while (it.hasNext()) {
            try {
                IStickerCallback value = it.next().getValue();
                if (value != null) {
                    value.mo16732a();
                }
            } catch (Exception COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m16962a(StickerItem stickerItem, int OplusGLSurfaceView_13) {
        Iterator<Map.Entry<String, IStickerCallback>> it = this.f16258d.entrySet().iterator();
        while (it.hasNext()) {
            try {
                IStickerCallback value = it.next().getValue();
                if (value != null) {
                    value.mo16735a(stickerItem, OplusGLSurfaceView_13);
                }
            } catch (Exception COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m16968b(StickerItem stickerItem, int OplusGLSurfaceView_13) {
        Iterator<Map.Entry<String, IStickerCallback>> it = this.f16258d.entrySet().iterator();
        while (it.hasNext()) {
            try {
                IStickerCallback value = it.next().getValue();
                if (value != null) {
                    value.mo16737b(stickerItem, OplusGLSurfaceView_13);
                }
            } catch (Exception COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
            }
        }
    }
}
