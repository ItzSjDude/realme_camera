package com.oplus.camera.p141e;

import android.content.Intent;
import android.hardware.camera2.CameraDevice;
import android.media.ImageReader;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.LogPrinter;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.oplus.camera.CameraLog;
import com.oplus.camera.p141e.OneCamera;
import com.oplus.camera.p181w.CameraHandler;
import com.oplus.camera.p181w.CameraHandlerThread;
import com.oplus.camera.util.Util;
import com.oplus.ocs.camera.CameraDeviceConfig;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: OneCameraStateMachine.java */
/* renamed from: com.oplus.camera.COUIBaseListPopupWindow_8.COUIBaseListPopupWindow_11 */
/* loaded from: classes2.dex */
public abstract class OneCameraStateMachine implements OneCamera {

    /* renamed from: p */
    protected PlatformImplementations.kt_3 f13515p;

    /* renamed from: q */
    protected CameraHandler f13516q;

    /* renamed from: r */
    protected Handler f13517r;

    /* renamed from: s */
    protected HashMap<String, ImageReader> f13518s;

    /* renamed from: t */
    protected HashMap<String, Long> f13519t;

    /* renamed from: w */
    protected int f13522w;

    /* renamed from: y */
    protected ConditionVariable f13524y;

    /* renamed from: OplusGLSurfaceView_11 */
    protected final Object f13513n = new Object();

    /* renamed from: o */
    protected ConditionVariable f13514o = new ConditionVariable();

    /* renamed from: u */
    protected int f13520u = 3;

    /* renamed from: v */
    protected int f13521v = 1;

    /* renamed from: x */
    protected int f13523x = 0;

    /* renamed from: z */
    private long f13525z = 0;

    /* renamed from: A */
    private long f13507A = AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS;

    /* renamed from: B */
    private boolean f13508B = true;

    /* renamed from: C */
    private boolean f13509C = false;

    /* renamed from: D */
    private ConditionVariable f13510D = new ConditionVariable();

    /* renamed from: E */
    private ConditionVariable f13511E = new ConditionVariable();

    /* renamed from: F */
    private Lock f13512F = new ReentrantLock();

    /* renamed from: E */
    protected abstract void mo13208E();

    /* renamed from: F */
    protected abstract void mo13209F();

    /* renamed from: PlatformImplementations.kt_3 */
    protected abstract void mo13210a(int OplusGLSurfaceView_13, OneCamera.IntrinsicsJvm.kt_4 bVar);

    /* renamed from: PlatformImplementations.kt_3 */
    protected abstract void mo13211a(CameraDevice cameraDevice, boolean z);

    /* renamed from: PlatformImplementations.kt_3 */
    protected abstract void mo13212a(CameraDeviceConfig.Builder builder, OneCamera.IntrinsicsJvm.kt_5 dVar, int OplusGLSurfaceView_13);

    public OneCameraStateMachine(int OplusGLSurfaceView_13) {
        this.f13515p = null;
        this.f13516q = null;
        this.f13517r = null;
        this.f13518s = null;
        this.f13519t = null;
        this.f13522w = 1;
        this.f13524y = null;
        CameraHandlerThread handlerThreadC3563c = new CameraHandlerThread("Camera Hal Control Thread" + OplusGLSurfaceView_13);
        handlerThreadC3563c.m24694a();
        handlerThreadC3563c.start();
        this.f13515p = new PlatformImplementations.kt_3(handlerThreadC3563c.getLooper());
        handlerThreadC3563c.getLooper().setMessageLogging(new LogPrinter(2, "hal-control-handler"));
        HandlerThread handlerThread = new HandlerThread("Camera Hal Callback Thread" + OplusGLSurfaceView_13);
        handlerThread.start();
        this.f13516q = new CameraHandler(handlerThread.getLooper());
        HandlerThread handlerThread2 = new HandlerThread("Aps Capture Yuv Thread" + OplusGLSurfaceView_13);
        handlerThread2.start();
        this.f13517r = new Handler(handlerThread2.getLooper());
        this.f13522w = OplusGLSurfaceView_13;
        if (1 == OplusGLSurfaceView_13) {
            this.f13524y = new ConditionVariable(true);
        }
        synchronized (this.f13513n) {
            this.f13518s = new HashMap<>();
            this.f13519t = new HashMap<>();
        }
    }

    /* compiled from: OneCameraStateMachine.java */
    /* renamed from: com.oplus.camera.COUIBaseListPopupWindow_8.COUIBaseListPopupWindow_11$PlatformImplementations.kt_3 */
    protected class PlatformImplementations.kt_3 extends CameraHandler {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private boolean f13529b;

        PlatformImplementations.kt_3(Looper looper) {
            super(looper);
            this.f13529b = false;
        }

        @Override // com.oplus.camera.p181w.CameraHandler
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo13242a(Runnable runnable) {
            if (!this.f13529b) {
                CameraLog.m12959b("OneCameraStateMachine", "postRunnable, mbEnabled:" + this.f13529b);
                return;
            }
            super.mo13242a(runnable);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            CameraLog.m12959b("OneCameraStateMachine", "handleMessage, mCameraRole: " + OneCameraStateMachine.this.f13522w + ", msg: " + message.what);
            switch (message.what) {
                case 2:
                    if (message.obj instanceof OneCamera.IntrinsicsJvm.kt_4) {
                        CameraLog.m12962c("OneCameraStateMachine", "handleMessage, open camera, cameraId: " + message.arg1 + ", openType: " + message.arg2);
                        if (message.obj instanceof OneCamera.IntrinsicsJvm.kt_4) {
                            OneCameraStateMachine.this.m13240b(message.arg1, (OneCamera.IntrinsicsJvm.kt_4) message.obj);
                            ((OneCamera.IntrinsicsJvm.kt_4) message.obj).mo10950c(message.arg1);
                            break;
                        }
                    } else {
                        CameraLog.m12959b("OneCameraStateMachine", "handleMessage, not open camera, openCallback: " + message.obj);
                        break;
                    }
                    break;
                case 3:
                    IntrinsicsJvm.kt_4 bVar = (IntrinsicsJvm.kt_4) message.obj;
                    OneCameraStateMachine.this.mo13212a(bVar.f13530a, bVar.f13531b, bVar.f13532c);
                    OneCameraStateMachine.this.f13515p.removeMessages(8);
                    message = OneCameraStateMachine.this.f13515p.obtainMessage(8);
                    message.sendToTarget();
                    break;
                case 4:
                    CameraLog.m12953a("OneCameraStateMachine", OneCameraStateMachine.this.f13515p, "closing camera");
                    OneCameraStateMachine.this.f13515p.removeCallbacksAndMessages(null);
                    if (OneCameraStateMachine.this.f13508B) {
                        OneCameraStateMachine.this.m13230a(message.obj != null ? (CameraDevice) message.obj : null, message.arg1);
                        break;
                    } else {
                        CameraLog.m12959b("OneCameraStateMachine", "don't close camera and run open flow");
                        OneCameraStateMachine.this.f13508B = true;
                        break;
                    }
                case 5:
                    OneCameraStateMachine.this.mo13211a(message.obj != null ? (CameraDevice) message.obj : null, 1 == message.arg1);
                    break;
                case 6:
                    OneCameraStateMachine.this.m13229D();
                    OneCameraStateMachine.this.mo13208E();
                    break;
                case 7:
                    if (OneCameraStateMachine.this.f13520u == 1 || OneCameraStateMachine.this.f13520u == 8 || OneCameraStateMachine.this.f13520u == 6) {
                        ((OneCamera.IntrinsicsJvm.kt_4) message.obj).mo10946a(OneCameraStateMachine.this.f13522w);
                        break;
                    }
                    break;
                case 8:
                    OneCameraStateMachine.this.mo13209F();
                    break;
            }
            CameraLog.m12954a("OneCameraStateMachine", "handleMessage x, mCameraRole: " + OneCameraStateMachine.this.f13522w + ", msg: " + message.what);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m13243a(boolean z) {
            this.f13529b = z;
        }
    }

    /* renamed from: G */
    protected void m13236G() {
        if (this.f13524y != null) {
            CameraLog.m12959b("OneCameraStateMachine", "openMainCameraOpenBlock, mCameraRole: " + this.f13522w);
            this.f13524y.open();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m13230a(CameraDevice cameraDevice, int OplusGLSurfaceView_13) {
        CameraLog.m12959b("OneCameraStateMachine", "closeCameraDecision, mCameraRole: " + this.f13522w + ", mDeviceState: " + this.f13520u);
        int i2 = this.f13520u;
        if (i2 == 1 || i2 == 8 || i2 == 0 || i2 == 5 || i2 == 6) {
            CameraLog.m12959b("OneCameraStateMachine", "closeCameraDecision, mCameraRole: " + this.f13522w + ",  quick close");
            Message messageObtainMessage = this.f13515p.obtainMessage();
            messageObtainMessage.what = 5;
            messageObtainMessage.obj = cameraDevice;
            messageObtainMessage.arg1 = OplusGLSurfaceView_13;
            this.f13515p.sendMessage(messageObtainMessage);
        }
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13027a(int OplusGLSurfaceView_13, OneCamera.IntrinsicsJvm.kt_4 bVar, int i2) {
        CameraLog.m12962c("OneCameraStateMachine", "openCamera, send open message, cameraId: " + OplusGLSurfaceView_13 + ", this: " + this);
        Message messageObtainMessage = this.f13515p.obtainMessage();
        messageObtainMessage.what = 2;
        messageObtainMessage.obj = bVar;
        messageObtainMessage.arg1 = OplusGLSurfaceView_13;
        messageObtainMessage.arg2 = i2;
        this.f13515p.sendMessage(messageObtainMessage);
        CameraLog.m12953a("OneCameraStateMachine", this.f13515p, "dump-after-enqueue-open-camera");
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m13240b(int OplusGLSurfaceView_13, OneCamera.IntrinsicsJvm.kt_4 bVar) {
        CameraLog.m12962c("OneCameraStateMachine", "openCamera, mCameraRole: " + this.f13522w + ", cameraId: " + OplusGLSurfaceView_13 + ", this: " + this);
        CameraLog.m12953a("OneCameraStateMachine", this.f13515p, "dump-before-open");
        this.f13515p.removeCallbacksAndMessages(null);
        if (this.f13509C) {
            this.f13508B = false;
        } else {
            this.f13507A = AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS;
        }
        mo13070b(false);
        if (mo13075c() == -1) {
            CameraLog.m12962c("OneCameraStateMachine", "openCamera, mCameraRole: " + this.f13522w + ", normal open");
        } else {
            CameraLog.m12962c("OneCameraStateMachine", "openCamera, mCameraRole: " + this.f13522w + ", close then open");
            mo13211a((CameraDevice) null, false);
        }
        mo13210a(OplusGLSurfaceView_13, bVar);
        this.f13508B = true;
        Message messageObtainMessage = this.f13515p.obtainMessage();
        messageObtainMessage.what = 7;
        messageObtainMessage.obj = bVar;
        this.f13515p.sendMessageAtFrontOfQueue(messageObtainMessage);
        CameraLog.m12953a("OneCameraStateMachine", this.f13515p, "openCamera");
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13050a(boolean z, CameraDevice cameraDevice, boolean z2) {
        CameraLog.m12967f("OneCameraStateMachine", "closeCamera, mCameraRole: " + this.f13522w + ",  mCameraDevice: " + cameraDevice + ", fromError: " + z + ", needDelay: " + z2);
        Message messageObtainMessage = this.f13515p.obtainMessage();
        messageObtainMessage.what = 4;
        messageObtainMessage.obj = cameraDevice;
        messageObtainMessage.arg1 = z2 ? 1 : 0;
        this.f13508B = true;
        this.f13515p.sendMessageAtFrontOfQueue(messageObtainMessage);
        CameraLog.m12953a("OneCameraStateMachine", this.f13515p, "closeCamera");
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m13241b(CameraDeviceConfig.Builder builder, OneCamera.IntrinsicsJvm.kt_5 dVar, int OplusGLSurfaceView_13) {
        CameraLog.m12954a("OneCameraStateMachine", "createCaptureSession");
        Message messageObtainMessage = this.f13515p.obtainMessage();
        messageObtainMessage.what = 3;
        IntrinsicsJvm.kt_4 bVar = new IntrinsicsJvm.kt_4();
        bVar.f13530a = builder;
        bVar.f13531b = dVar;
        bVar.f13532c = OplusGLSurfaceView_13;
        messageObtainMessage.obj = bVar;
        this.f13515p.sendMessage(messageObtainMessage);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: COUIBaseListPopupWindow_12 */
    public void mo13090f() {
        CameraLog.m12954a("OneCameraStateMachine", "closeSession, mCameraRole: " + this.f13522w);
        Message messageObtainMessage = this.f13515p.obtainMessage();
        messageObtainMessage.what = 6;
        messageObtainMessage.obj = null;
        messageObtainMessage.arg1 = 0;
        this.f13515p.sendMessage(messageObtainMessage);
    }

    /* renamed from: B */
    protected void m13235B(int OplusGLSurfaceView_13) {
        CameraLog.m12967f("OneCameraStateMachine", "setDeviceState, mCameraRole: " + this.f13522w + ",  mDeviceState: " + this.f13520u + " -> " + OplusGLSurfaceView_13);
        if (this.f13520u == 5 && OplusGLSurfaceView_13 == 3) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.f13514o.close();
            this.f13514o.block(1000L);
            CameraLog.m12967f("OneCameraStateMachine", "setDeviceState, wait close: " + (System.currentTimeMillis() - jCurrentTimeMillis));
        }
        this.f13520u = OplusGLSurfaceView_13;
        if (this.f13520u == 5) {
            this.f13515p.m13243a(true);
        } else {
            this.f13515p.m13243a(false);
        }
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo13064b(int OplusGLSurfaceView_13) {
        synchronized (this.f13513n) {
            Iterator<Map.Entry<String, ImageReader>> it = this.f13518s.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().close();
            }
            this.f13518s.clear();
            this.f13519t.clear();
        }
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo13076c(int OplusGLSurfaceView_13) {
        CameraLog.m12962c("OneCameraStateMachine", "discardFreeBuffers, format: " + OplusGLSurfaceView_13);
        synchronized (this.f13513n) {
            String[] strArr = null;
            try {
                if (35 == OplusGLSurfaceView_13) {
                    strArr = new String[]{"type_still_capture_yuv_main", "type_still_capture_yuv_mfnr", "type_still_capture_yuv_sub", "type_still_capture_yuv_third", "type_tuning_data_yuv"};
                } else if (32 == OplusGLSurfaceView_13) {
                    strArr = new String[]{"type_still_capture_raw", "type_tuning_data_raw"};
                }
                if (strArr != null) {
                    for (String str : strArr) {
                        if (this.f13518s.containsKey(str)) {
                            this.f13518s.get(str).discardFreeBuffers();
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void mo13081d() {
        this.f13516q.getLooper().quitSafely();
        this.f13515p.getLooper().quitSafely();
        this.f13517r.getLooper().quitSafely();
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13048a(final boolean z) {
        Util.m24279a(new Runnable() { // from class: com.oplus.camera.COUIBaseListPopupWindow_8.COUIBaseListPopupWindow_11.1
            @Override // java.lang.Runnable
            public void run() {
                CameraLog.m12954a("OneCameraStateMachine", "broadcastRearCamera, enterRearCamera: " + z);
                Intent intent = new Intent("com.oplus.rearcamera");
                intent.putExtra("command", z ? "enterrear" : "exitrear");
                Util.m24472l().sendBroadcast(intent);
            }
        });
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13024a(int OplusGLSurfaceView_13) {
        this.f13521v = OplusGLSurfaceView_13;
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: OplusGLSurfaceView_14 */
    public Handler mo13110l() {
        return this.f13515p;
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: OplusGLSurfaceView_6 */
    public void mo13113m() {
        CameraLog.m12954a("OneCameraStateMachine", "removeStaleCameraMessage");
        PlatformImplementations.kt_3 aVar = this.f13515p;
        if (aVar != null) {
            if (aVar.hasMessages(4)) {
                CameraLog.m12954a("OneCameraStateMachine", "openCamera, open after close, don't need close, just remove close msg.");
                this.f13515p.removeMessages(4);
            }
            if (this.f13515p.hasMessages(2)) {
                CameraLog.m12954a("OneCameraStateMachine", "openCamera, open again, remove the old open message.");
                this.f13515p.removeMessages(2);
            }
        }
    }

    /* renamed from: H */
    public void m13237H() {
        this.f13512F.lock();
        try {
            this.f13511E.close();
            this.f13510D.close();
        } finally {
            this.f13512F.unlock();
        }
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo13070b(boolean z) {
        CameraLog.m12959b("OneCameraStateMachine", "openLock, mCameraRole: " + this.f13522w + ", openboth : " + z);
        this.f13512F.lock();
        try {
            this.f13510D.open();
            if (z) {
                this.f13511E.open();
            }
        } finally {
            this.f13512F.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D */
    public void m13229D() {
        long OplusGLSurfaceView_15 = AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS - this.f13507A;
        if (OplusGLSurfaceView_15 > 1) {
            CameraLog.m12959b("OneCameraStateMachine", "blockCloseOldSession begin, mCameraRole: " + this.f13522w + ", leftWaitingTime: " + OplusGLSurfaceView_15);
            this.f13511E.block(OplusGLSurfaceView_15);
            this.f13507A = AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS;
            this.f13511E.open();
            CameraLog.m12959b("OneCameraStateMachine", "blockCloseOldSession end, mCameraRole: " + this.f13522w);
        }
    }

    /* renamed from: I */
    public boolean m13238I() {
        return 5 == this.f13520u;
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo13060a() {
        return 3 == this.f13520u;
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean mo13074b() {
        return 2 == this.f13520u;
    }

    /* renamed from: J */
    public boolean m13239J() {
        int OplusGLSurfaceView_13 = this.f13520u;
        return 1 == OplusGLSurfaceView_13 || 4 == OplusGLSurfaceView_13 || 5 == OplusGLSurfaceView_13;
    }

    /* compiled from: OneCameraStateMachine.java */
    /* renamed from: com.oplus.camera.COUIBaseListPopupWindow_8.COUIBaseListPopupWindow_11$IntrinsicsJvm.kt_4 */
    private class IntrinsicsJvm.kt_4 {

        /* renamed from: PlatformImplementations.kt_3 */
        CameraDeviceConfig.Builder f13530a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        OneCamera.IntrinsicsJvm.kt_5 f13531b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        int f13532c;

        private IntrinsicsJvm.kt_4() {
            this.f13530a = null;
            this.f13531b = null;
            this.f13532c = 0;
        }
    }
}
