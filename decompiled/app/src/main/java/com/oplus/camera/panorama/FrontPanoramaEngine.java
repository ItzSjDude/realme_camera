package com.oplus.camera.panorama;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Size;
import android.widget.Toast;
import com.arcsoft.camera.wideselfie.ArcWideSelfieDef;
import com.arcsoft.camera.wideselfie.AwsInitParameter;
import com.arcsoft.camera.wideselfie.ProcessResult;
import com.arcsoft.camera.wideselfie.WideSelfieCallback;
import com.arcsoft.camera.wideselfie.WideSelfieEngine;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.jni.FormatConverter;
import com.oplus.camera.util.Util;

/* compiled from: FrontPanoramaEngine.java */
/* renamed from: com.oplus.camera.panorama.IntrinsicsJvm.kt_5 */
/* loaded from: classes2.dex */
public class FrontPanoramaEngine implements SensorEventListener, WideSelfieCallback {

    /* renamed from: L */
    private boolean f14953L;

    /* renamed from: P */
    private float[] f14957P;

    /* renamed from: S */
    private Size f14960S;

    /* renamed from: W */
    private PlatformImplementations.kt_3 f14964W;

    /* renamed from: X */
    private Paint f14965X;

    /* renamed from: Y */
    private int f14966Y;

    /* renamed from: PlatformImplementations.kt_3 */
    private final int f14967a = 6;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final int f14968b = 2;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final int f14969c = 90;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final int f14970d = 90;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final float f14971e = 2.0f;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final float f14972f = 1.0f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private final float f14973g = 4.0f;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private final float f14974h = 3.0f;

    /* renamed from: OplusGLSurfaceView_13 */
    private final float f14975i = 0.5f;

    /* renamed from: OplusGLSurfaceView_15 */
    private final float f14976j = 0.25f;

    /* renamed from: OplusGLSurfaceView_5 */
    private final int f14977k = 2;

    /* renamed from: OplusGLSurfaceView_14 */
    private final int f14978l = 2;

    /* renamed from: OplusGLSurfaceView_6 */
    private final int f14979m = 1;

    /* renamed from: OplusGLSurfaceView_11 */
    private final int f14980n = 2;

    /* renamed from: o */
    private final int f14981o = 3;

    /* renamed from: p */
    private final int f14982p = 4;

    /* renamed from: q */
    private final int f14983q = 10000;

    /* renamed from: r */
    private final int f14984r = 1;

    /* renamed from: s */
    private final int f14985s = 10000;

    /* renamed from: t */
    private final int f14986t = 4;

    /* renamed from: u */
    private final int f14987u = 100;

    /* renamed from: v */
    private final int f14988v = 1;

    /* renamed from: w */
    private final int f14989w = 2;

    /* renamed from: x */
    private final int f14990x = 3;

    /* renamed from: y */
    private final int f14991y = 4;

    /* renamed from: z */
    private final int f14992z = 5;

    /* renamed from: A */
    private final int f14942A = 7;

    /* renamed from: B */
    private int f14943B = 90;

    /* renamed from: C */
    private int f14944C = 0;

    /* renamed from: D */
    private int f14945D = 0;

    /* renamed from: E */
    private int f14946E = 0;

    /* renamed from: F */
    private int f14947F = 0;

    /* renamed from: G */
    private int f14948G = 0;

    /* renamed from: H */
    private int f14949H = 0;

    /* renamed from: I */
    private boolean f14950I = false;

    /* renamed from: J */
    private boolean f14951J = false;

    /* renamed from: K */
    private boolean f14952K = false;

    /* renamed from: M */
    private AwsInitParameter f14954M = null;

    /* renamed from: N */
    private WideSelfieEngine f14955N = null;

    /* renamed from: O */
    private float f14956O = 10000.0f;

    /* renamed from: Q */
    private HandlerThread f14958Q = null;

    /* renamed from: R */
    private Handler f14959R = null;

    /* renamed from: T */
    private SensorManager f14961T = null;

    /* renamed from: U */
    private Sensor f14962U = null;

    /* renamed from: V */
    private Object f14963V = new Object();

    /* compiled from: FrontPanoramaEngine.java */
    /* renamed from: com.oplus.camera.panorama.IntrinsicsJvm.kt_5$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo14956a();

        /* renamed from: PlatformImplementations.kt_3 */
        void mo14957a(int OplusGLSurfaceView_13);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo14958a(Bitmap bitmap);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo14959a(boolean z, byte[] bArr, int OplusGLSurfaceView_13, int i2);

        /* renamed from: IntrinsicsJvm.kt_4 */
        void mo14960b();

        /* renamed from: IntrinsicsJvm.kt_3 */
        void mo14961c();

        /* renamed from: IntrinsicsJvm.kt_5 */
        void mo14962d();

        /* renamed from: COUIBaseListPopupWindow_8 */
        int mo14963e();

        /* renamed from: COUIBaseListPopupWindow_12 */
        boolean mo14964f();
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int OplusGLSurfaceView_13) {
    }

    public FrontPanoramaEngine(Activity activity, Size size, boolean z, PlatformImplementations.kt_3 aVar, float[] fArr) {
        this.f14953L = false;
        this.f14957P = null;
        this.f14960S = null;
        this.f14964W = null;
        this.f14965X = null;
        this.f14966Y = 0;
        this.f14960S = size;
        this.f14953L = z;
        this.f14964W = aVar;
        this.f14957P = fArr;
        this.f14966Y = activity.getApplicationContext().getResources().getDimensionPixelSize(R.dimen.panorama_rim_width);
        this.f14965X = new Paint();
        this.f14965X.setStyle(Paint.Style.STROKE);
        this.f14965X.setStrokeWidth(this.f14966Y);
        this.f14965X.setColor(-1);
        m14942k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m14937f() throws Throwable {
        CameraLog.m12954a("FrontPanoramaEngine", "frontCapPrepare enter");
        m14941j();
        this.f14947F = 0;
        this.f14956O = m14938g() / 4.0f;
        this.f14950I = true;
        m14939h();
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int m14938g() {
        Size size = this.f14960S;
        if (size != null) {
            return (size.getHeight() * 2) / 6;
        }
        return 0;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    private void m14939h() throws Throwable {
        Size size = this.f14960S;
        if (size == null) {
            return;
        }
        this.f14954M = AwsInitParameter.getDefaultInitParams(size.getWidth(), this.f14960S.getHeight(), 2050, this.f14943B);
        this.f14954M.maxResultWidth = this.f14960S.getHeight() * 2;
        this.f14954M.progressBarThumbHeight = m14940i();
        float[] fArr = this.f14957P;
        if (fArr != null && fArr.length == 2) {
            AwsInitParameter awsInitParameter = this.f14954M;
            awsInitParameter.cameraViewAngleForWidth = fArr[0];
            awsInitParameter.cameraViewAngleForHeight = fArr[1];
        }
        CameraLog.m12954a("FrontPanoramaEngine", "createEngine, cameraViewAngleForHeight after: " + this.f14954M.cameraViewAngleForHeight + ", cameraViewAngleForWidth after: " + this.f14954M.cameraViewAngleForWidth);
        this.f14955N = WideSelfieEngine.singleInstance(ArcWideSelfieDef.DEFAUT_JNI_LIB_NAME);
        int iInit = this.f14955N.init(this.f14954M);
        if (iInit != 0) {
            CameraLog.m12967f("FrontPanoramaEngine", "createEngine WideSelfieEngine init error, res: " + iInit);
        }
        this.f14955N.setOnCallback(this);
        int OplusGLSurfaceView_13 = this.f14954M.maxResultWidth;
        int i2 = this.f14954M.progressBarThumbHeight;
        int fullImageWidth = this.f14954M.getFullImageWidth();
        this.f14944C = this.f14954M.progressBarThumbHeight;
        this.f14945D = (int) (((OplusGLSurfaceView_13 * 1.0f) / fullImageWidth) * i2);
        this.f14945D = (this.f14945D / 4) * 4;
    }

    /* renamed from: OplusGLSurfaceView_13 */
    private int m14940i() {
        Size size = this.f14960S;
        if (size != null) {
            return size.getWidth() / 6;
        }
        return 0;
    }

    /* renamed from: OplusGLSurfaceView_15 */
    private void m14941j() {
        this.f14961T = (SensorManager) Util.m24472l().getSystemService("sensor");
        this.f14962U = this.f14961T.getDefaultSensor(4);
        synchronized (this.f14963V) {
            if (this.f14962U != null) {
                this.f14961T.registerListener(this, this.f14962U, 10000, this.f14959R);
            } else {
                CameraLog.m12967f("FrontPanoramaEngine", "initSensor, mGyroSensor is null.");
                Toast.makeText(Util.m24472l(), Util.m24472l().getString(R.string.camera_gyroscope_abnormal_warning_toast), 0).show();
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14948a(boolean z) {
        this.f14952K = z;
        synchronized (this.f14963V) {
            if (this.f14959R != null) {
                this.f14959R.sendEmptyMessage(1);
            }
        }
    }

    /* renamed from: OplusGLSurfaceView_5 */
    private void m14942k() {
        CameraLog.m12954a("FrontPanoramaEngine", "initFrontHandler enter");
        if (this.f14958Q == null) {
            this.f14958Q = new HandlerThread("front_panorama");
            this.f14958Q.start();
        }
        synchronized (this.f14963V) {
            if (this.f14959R != null) {
                return;
            }
            this.f14959R = new Handler(this.f14958Q.getLooper()) { // from class: com.oplus.camera.panorama.IntrinsicsJvm.kt_5.1
                @Override // android.os.Handler
                public void handleMessage(Message message) throws Throwable {
                    int OplusGLSurfaceView_13 = message.what;
                    if (OplusGLSurfaceView_13 == 1) {
                        FrontPanoramaEngine.this.m14937f();
                    } else if (OplusGLSurfaceView_13 == 2) {
                        FrontPanoramaEngine.this.m14943l();
                    } else if (OplusGLSurfaceView_13 == 3) {
                        FrontPanoramaEngine.this.m14949a((byte[]) message.obj);
                    } else if (OplusGLSurfaceView_13 == 4) {
                        FrontPanoramaEngine.this.m14945n();
                    } else {
                        CameraLog.m12954a("FrontPanoramaEngine", "mFrontHandler default enter");
                    }
                    super.handleMessage(message);
                }
            };
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        WideSelfieEngine wideSelfieEngine;
        int type = sensorEvent.sensor.getType();
        if (4 != type || (wideSelfieEngine = this.f14955N) == null) {
            return;
        }
        wideSelfieEngine.pushSensorDataIn(type, sensorEvent.values, sensorEvent.timestamp);
        this.f14951J = true;
    }

    @Override // com.arcsoft.camera.wideselfie.WideSelfieCallback
    public void onProcessCallback(int OplusGLSurfaceView_13, ProcessResult processResult) throws Throwable {
        if (processResult == null) {
            CameraLog.m12967f("FrontPanoramaEngine", "onProcessCallback error, data is null");
            return;
        }
        if (!this.f14950I) {
            m14929a(processResult);
        } else {
            m14935c(processResult);
            m14932b(processResult);
        }
        m14928a(OplusGLSurfaceView_13, processResult);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m14928a(int OplusGLSurfaceView_13, ProcessResult processResult) {
        if (28672 == OplusGLSurfaceView_13 || 28673 == OplusGLSurfaceView_13 || 28675 == OplusGLSurfaceView_13 || 28676 == OplusGLSurfaceView_13 || 28677 == OplusGLSurfaceView_13 || 28678 == OplusGLSurfaceView_13 || 28679 == OplusGLSurfaceView_13 || 4 == OplusGLSurfaceView_13 || 2 == OplusGLSurfaceView_13) {
            m14927a(4);
            CameraLog.m12967f("FrontPanoramaEngine", "processResultForStatus, error code: " + OplusGLSurfaceView_13);
        }
        if (32769 == OplusGLSurfaceView_13 || 32770 == OplusGLSurfaceView_13) {
            m14927a(5);
        }
        if (Math.abs(processResult.progressBarThumbOffset.y) >= ((int) (m14938g() * 0.25f)) + ((int) ((m14938g() * 0.5f) / 3.0f))) {
            m14927a(7);
        }
        if (100 == processResult.progress) {
            m14927a(2);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m14929a(ProcessResult processResult) throws Throwable {
        byte[] bArrM14931a;
        CameraLog.m12954a("FrontPanoramaEngine", "processResultRealTimeBitmap enter");
        if (processResult.resultImageHeight <= 0 || processResult.resultImageWidth <= 0) {
            CameraLog.m12967f("FrontPanoramaEngine", "processResultRealTimeBitmap error, resultImageHeight: " + processResult.resultImageHeight + ", resultImageWidth: " + processResult.resultImageWidth);
            this.f14964W.mo14956a();
            return;
        }
        if (this.f14964W.mo14964f()) {
            bArrM14931a = m14934b(this.f14952K, processResult);
        } else {
            bArrM14931a = m14931a(this.f14952K, processResult);
        }
        this.f14964W.mo14962d();
        m14943l();
        this.f14964W.mo14959a(this.f14952K, bArrM14931a, processResult.resultImageWidth, processResult.resultImageHeight);
    }

    /* JADX WARN: Removed duplicated region for block: B:81:0x01a0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:? A[SYNTHETIC] */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private byte[] m14931a(boolean r20, com.arcsoft.camera.wideselfie.ProcessResult r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 445
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.panorama.FrontPanoramaEngine.m14931a(boolean, com.arcsoft.camera.wideselfie.ProcessResult):byte[]");
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private byte[] m14934b(boolean z, ProcessResult processResult) {
        byte[] bArr = new byte[processResult.resultImageArray.length];
        int OplusGLSurfaceView_13 = processResult.resultImageWidth;
        int i2 = processResult.resultImageHeight;
        FormatConverter.rotateAndMirrorYUV(processResult.resultImageArray, bArr, processResult.resultImageArray.length, new int[]{OplusGLSurfaceView_13, OplusGLSurfaceView_13}, new int[]{i2, i2}, OplusGLSurfaceView_13, i2, z ? this.f14964W.mo14963e() + 90 : this.f14964W.mo14963e(), !this.f14953L);
        return bArr;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public Bitmap m14946a(Bitmap bitmap) {
        if (bitmap == null || m14938g() <= 0 || m14940i() <= 0) {
            CameraLog.m12967f("FrontPanoramaEngine", "drawFrontPreviewBitmap, bitmap is null,or getFrontPreviewHeight: " + m14940i() + ", getFrontPreviewWidth: " + m14938g());
            return null;
        }
        Bitmap bitmapM24215a = Util.m24215a(m14938g(), m14940i(), Bitmap.Config.ARGB_8888);
        int iM14938g = m14938g();
        int iM14940i = m14940i();
        float COUIBaseListPopupWindow_12 = 0.5f * iM14938g * 0.5f;
        Canvas canvas = new Canvas(bitmapM24215a);
        canvas.drawBitmap(bitmap, m14938g() / 4.0f, 0.0f, (Paint) null);
        int OplusGLSurfaceView_13 = this.f14966Y;
        canvas.drawRect(((int) COUIBaseListPopupWindow_12) + (OplusGLSurfaceView_13 / 2.0f), OplusGLSurfaceView_13 / 2.0f, ((int) (COUIBaseListPopupWindow_12 + r3)) - (OplusGLSurfaceView_13 / 2.0f), iM14940i - (OplusGLSurfaceView_13 / 2.0f), this.f14965X);
        return bitmapM24215a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private Bitmap m14926a(Bitmap bitmap, float COUIBaseListPopupWindow_12) {
        if (bitmap == null) {
            CameraLog.m12954a("FrontPanoramaEngine", "drawPreviewBitmap, bitmap is null");
            return null;
        }
        Bitmap bitmapM24215a = Util.m24215a(m14938g(), m14940i(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapM24215a);
        float fM14938g = m14938g() / 4.0f;
        if (COUIBaseListPopupWindow_12 > 0.0f) {
            fM14938g -= COUIBaseListPopupWindow_12;
        }
        this.f14947F = Math.max((int) (((m14938g() * 0.5f) + fM14938g) - COUIBaseListPopupWindow_12), this.f14947F);
        if (this.f14947F > m14938g()) {
            this.f14947F = m14938g();
        }
        float f2 = this.f14956O;
        int iMin = 10000.0f != f2 ? (int) Math.min(fM14938g, f2) : 0;
        if (iMin < 0) {
            iMin = 0;
        }
        int OplusGLSurfaceView_13 = this.f14947F;
        int iM14940i = m14940i();
        this.f14956O = iMin;
        canvas.drawBitmap(bitmap, (Rect) null, new Rect(iMin, 0, OplusGLSurfaceView_13, iM14940i), (Paint) null);
        int iM14938g = m14938g();
        int iM14940i2 = m14940i();
        float f3 = iM14938g;
        float f4 = f3 * 0.5f;
        float f5 = (int) (0.5f * f4);
        int iMax = (int) Math.max(0.0f, f5 - COUIBaseListPopupWindow_12);
        int iMin2 = (int) Math.min(f3, (f5 + f4) - COUIBaseListPopupWindow_12);
        int i2 = this.f14966Y;
        canvas.drawRect(iMax + (i2 / 2.0f), i2 / 2.0f, iMin2 - (i2 / 2.0f), iM14940i2 - (i2 / 2.0f), this.f14965X);
        return bitmapM24215a;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m14932b(ProcessResult processResult) {
        if (processResult == null || this.f14946E == processResult.direction) {
            return;
        }
        if (processResult.direction == 1) {
            this.f14964W.mo14957a(0);
        } else {
            this.f14964W.mo14957a(1);
        }
        this.f14946E = processResult.direction;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m14935c(ProcessResult processResult) {
        new Canvas(Bitmap.createBitmap(this.f14944C, this.f14945D, Bitmap.Config.ARGB_8888)).drawARGB(100, 0, 0, 0);
        this.f14948G = Math.max(processResult.progressBarThumbOffset.y, this.f14948G);
        this.f14949H = Math.min(processResult.progressBarThumbOffset.y, this.f14949H);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(processResult.progressBarThumbRgbPixels, processResult.progressBarThumbImageWidth, processResult.progressBarThumbImageHeight, Bitmap.Config.ARGB_8888);
        Matrix matrix = new Matrix();
        matrix.postRotate(90.0f);
        Bitmap bitmapM24221a = Util.m24221a(bitmapCreateBitmap, 0, 0, bitmapCreateBitmap.getWidth(), bitmapCreateBitmap.getHeight(), matrix, true);
        if (bitmapM24221a != null) {
            this.f14964W.mo14958a(m14926a(bitmapM24221a, processResult.progressBarThumbOffset.y));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_14 */
    public void m14943l() {
        int iUninit;
        CameraLog.m12954a("FrontPanoramaEngine", "destroyEngine enter");
        WideSelfieEngine wideSelfieEngine = this.f14955N;
        if (wideSelfieEngine != null && (iUninit = wideSelfieEngine.uninit()) != 0) {
            CameraLog.m12967f("FrontPanoramaEngine", "destroyEngine error, res: " + iUninit);
        }
        this.f14955N = null;
        this.f14954M = null;
        this.f14951J = false;
        this.f14949H = 0;
        this.f14948G = 0;
        m14944m();
    }

    /* renamed from: OplusGLSurfaceView_6 */
    private void m14944m() {
        SensorManager sensorManager;
        CameraLog.m12954a("FrontPanoramaEngine", "unRegisterSensor, mGyroSensor: " + this.f14962U + ", mSensorManager: " + this.f14961T);
        if (this.f14962U == null || (sensorManager = this.f14961T) == null) {
            return;
        }
        sensorManager.unregisterListener(this);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14949a(byte[] bArr) {
        if (this.f14955N == null || !this.f14950I) {
            CameraLog.m12954a("FrontPanoramaEngine", "onPreviewFrame, mWideSelfieEngine: " + this.f14955N + ", mbFrontCapturing: " + this.f14950I);
            return;
        }
        this.f14964W.mo14960b();
        int iProcess = this.f14955N.process(0, bArr);
        this.f14964W.mo14961c();
        if (iProcess != 0) {
            CameraLog.m12967f("FrontPanoramaEngine", "onPreviewFrame process select error, res：" + iProcess);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14947a() {
        CameraLog.m12954a("FrontPanoramaEngine", "destroyFrontEngine enter");
        this.f14952K = false;
        synchronized (this.f14963V) {
            if (this.f14959R != null) {
                this.f14959R.sendEmptyMessage(2);
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m14951b(byte[] bArr) {
        if (this.f14950I) {
            synchronized (this.f14963V) {
                if (this.f14959R != null && bArr != null && (this.f14951J || this.f14962U == null)) {
                    Message messageObtain = Message.obtain();
                    messageObtain.what = 3;
                    messageObtain.obj = bArr;
                    this.f14959R.sendMessage(messageObtain);
                } else {
                    CameraLog.m12954a("FrontPanoramaEngine", "manageOnFrame, mFrontHandler: " + this.f14959R + ", mbSensorDataReady: " + this.f14951J);
                }
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m14952b() {
        return this.f14950I;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m14950b(boolean z) {
        this.f14950I = z;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m14953c() {
        m14927a(1);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m14954d() {
        synchronized (this.f14963V) {
            if (this.f14959R != null) {
                this.f14959R.getLooper().quitSafely();
                this.f14959R = null;
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m14927a(int OplusGLSurfaceView_13) {
        CameraLog.m12954a("FrontPanoramaEngine", "stopProcessingWithType, stopType: " + OplusGLSurfaceView_13);
        synchronized (this.f14963V) {
            if (this.f14959R != null) {
                Message messageObtain = Message.obtain();
                messageObtain.what = 4;
                this.f14959R.sendMessage(messageObtain);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_11 */
    public void m14945n() {
        WideSelfieEngine wideSelfieEngine = this.f14955N;
        if (wideSelfieEngine == null || !this.f14950I) {
            return;
        }
        this.f14950I = false;
        wideSelfieEngine.stopProcessing();
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m14955e() {
        m14927a(3);
    }
}
