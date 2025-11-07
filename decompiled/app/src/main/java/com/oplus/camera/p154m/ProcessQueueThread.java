package com.oplus.camera.p154m;

import android.os.Process;
import com.oplus.camera.CameraLog;
import com.oplus.camera.Storage;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.aps.constant.ApsConstant;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: ProcessQueueThread.java */
/* renamed from: com.oplus.camera.OplusGLSurfaceView_6.IntrinsicsJvm.kt_5 */
/* loaded from: classes2.dex */
public abstract class ProcessQueueThread {

    /* renamed from: PlatformImplementations.kt_3 */
    protected ExecutorService f14713a = null;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f14714b = 0;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f14715c = 0;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private volatile int f14716d = 0;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private boolean f14717e = false;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private PlatformImplementations.kt_3 f14718f = null;

    /* compiled from: ProcessQueueThread.java */
    /* renamed from: com.oplus.camera.OplusGLSurfaceView_6.IntrinsicsJvm.kt_5$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo11041a();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected abstract void mo14693b();

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected abstract void mo14694b(Storage.CameraPicture cameraPicture) throws Exception;

    /* renamed from: PlatformImplementations.kt_3 */
    static /* synthetic */ int m14701a(ProcessQueueThread abstractC2812d) {
        int OplusGLSurfaceView_13 = abstractC2812d.f14715c;
        abstractC2812d.f14715c = OplusGLSurfaceView_13 - 1;
        return OplusGLSurfaceView_13;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    static /* synthetic */ int m14704c(ProcessQueueThread abstractC2812d) {
        int OplusGLSurfaceView_13 = abstractC2812d.f14714b;
        abstractC2812d.f14714b = OplusGLSurfaceView_13 - 1;
        return OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14706a(PlatformImplementations.kt_3 aVar) {
        synchronized (this) {
            this.f14718f = aVar;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m14708d() {
        mo14693b();
        if (this.f14713a == null) {
            this.f14713a = Executors.newSingleThreadExecutor();
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public int m14709e() {
        int OplusGLSurfaceView_13;
        CameraLog.m12954a("ProcessQueueThread", "getSaveListRawCount");
        synchronized (this) {
            OplusGLSurfaceView_13 = this.f14714b;
        }
        return OplusGLSurfaceView_13;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public synchronized boolean m14710f() {
        return this.f14715c > 50;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public synchronized boolean m14711g() {
        return this.f14715c == 0;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public synchronized void m14712h() {
        this.f14716d++;
        CameraLog.m12954a("ProcessQueueThread", "afterAddFrame, mCaptureSize: " + this.f14716d);
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public synchronized void m14713i() {
        this.f14716d--;
        CameraLog.m12954a("ProcessQueueThread", "onPicReceiveFromAPS, mCaptureSize: " + this.f14716d);
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public synchronized boolean m14714j() {
        CameraLog.m12954a("ProcessQueueThread", "imageCaptureListIsEmpty, mCaptureSize: " + this.f14716d);
        return this.f14716d == 0;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public final void m14707c(final Storage.CameraPicture cameraPicture) {
        CameraLog.m12954a("ProcessQueueThread", "pictureArrive, width: " + cameraPicture.f12142o + ", height: " + cameraPicture.f12143p + ", orientation: " + cameraPicture.f12147t + ", uri: " + cameraPicture.f12130c + ", title: " + cameraPicture.f12134g);
        synchronized (this) {
            this.f14715c++;
            if ("raw".equals(cameraPicture.f12135h)) {
                this.f14714b++;
            }
        }
        if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_ONLY_HIGH_PICTURE_SIZE_HEIF_IN_APS) || ApsConstant.CAPTURE_MODE_PANORAMA.equals(cameraPicture.f12136i) || (!("heic_8bits".equalsIgnoreCase(cameraPicture.f12135h) || "heic_10bits".equalsIgnoreCase(cameraPicture.f12135h)) || cameraPicture.f12126X)) {
            this.f14713a.submit(new Runnable() { // from class: com.oplus.camera.OplusGLSurfaceView_6.IntrinsicsJvm.kt_5.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        try {
                            ProcessQueueThread.this.mo14694b(cameraPicture);
                            synchronized (ProcessQueueThread.this) {
                                ProcessQueueThread.m14701a(ProcessQueueThread.this);
                                if (ProcessQueueThread.this.f14718f != null) {
                                    ProcessQueueThread.this.f14718f.mo11041a();
                                }
                                if ("raw".equals(cameraPicture.f12135h)) {
                                    ProcessQueueThread.m14704c(ProcessQueueThread.this);
                                }
                                ProcessQueueThread.this.m14702a();
                            }
                        } catch (Exception COUIBaseListPopupWindow_8) {
                            COUIBaseListPopupWindow_8.printStackTrace();
                            synchronized (ProcessQueueThread.this) {
                                ProcessQueueThread.m14701a(ProcessQueueThread.this);
                                if (ProcessQueueThread.this.f14718f != null) {
                                    ProcessQueueThread.this.f14718f.mo11041a();
                                }
                                if ("raw".equals(cameraPicture.f12135h)) {
                                    ProcessQueueThread.m14704c(ProcessQueueThread.this);
                                }
                                ProcessQueueThread.this.m14702a();
                            }
                        }
                    } catch (Throwable th) {
                        synchronized (ProcessQueueThread.this) {
                            ProcessQueueThread.m14701a(ProcessQueueThread.this);
                            if (ProcessQueueThread.this.f14718f != null) {
                                ProcessQueueThread.this.f14718f.mo11041a();
                            }
                            if ("raw".equals(cameraPicture.f12135h)) {
                                ProcessQueueThread.m14704c(ProcessQueueThread.this);
                            }
                            ProcessQueueThread.this.m14702a();
                            throw th;
                        }
                    }
                }
            });
            return;
        }
        try {
            try {
                mo14694b(cameraPicture);
                synchronized (this) {
                    this.f14715c--;
                    if (this.f14718f != null) {
                        this.f14718f.mo11041a();
                    }
                    if ("raw".equals(cameraPicture.f12135h)) {
                        this.f14714b--;
                    }
                    m14702a();
                }
            } catch (Exception COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
                synchronized (this) {
                    this.f14715c--;
                    if (this.f14718f != null) {
                        this.f14718f.mo11041a();
                    }
                    if ("raw".equals(cameraPicture.f12135h)) {
                        this.f14714b--;
                    }
                    m14702a();
                }
            }
        } catch (Throwable th) {
            synchronized (this) {
                this.f14715c--;
                if (this.f14718f != null) {
                    this.f14718f.mo11041a();
                }
                if ("raw".equals(cameraPicture.f12135h)) {
                    this.f14714b--;
                }
                m14702a();
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m14702a() {
        if (this.f14717e && m14711g()) {
            CameraLog.m12967f("ProcessQueueThread", "checkAndKillProcess will kill camera process");
            Process.killProcess(Process.myPid());
        }
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public synchronized void m14715k() {
        if (this.f14718f != null) {
            this.f14718f.mo11041a();
        }
    }
}
