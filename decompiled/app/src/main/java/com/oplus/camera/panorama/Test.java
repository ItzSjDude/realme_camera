package com.oplus.camera.panorama;

/* compiled from: FrontPanoramaEngine.java */
/* loaded from: classes2.dex */
public class d_renamed implements android.hardware.SensorEventListener, com.arcsoft.camera.wideselfie.WideSelfieCallback {
    private boolean L_renamed;
    private float[] P_renamed;
    private android.util.Size S_renamed;
    private com.oplus.camera.panorama.d_renamed.a_renamed W_renamed;
    private android.graphics.Paint X_renamed;
    private int Y_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    private final int f4941a = 6;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final int f4942b = 2;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final int f4943c = 90;
    private final int d_renamed = 90;
    private final float e_renamed = 2.0f;
    private final float f_renamed = 1.0f;
    private final float g_renamed = 4.0f;
    private final float h_renamed = 3.0f;
    private final float i_renamed = 0.5f;
    private final float j_renamed = 0.25f;
    private final int k_renamed = 2;
    private final int l_renamed = 2;
    private final int m_renamed = 1;
    private final int n_renamed = 2;
    private final int o_renamed = 3;
    private final int p_renamed = 4;
    private final int q_renamed = 10000;
    private final int r_renamed = 1;
    private final int s_renamed = 10000;
    private final int t_renamed = 4;
    private final int u_renamed = 100;
    private final int v_renamed = 1;
    private final int w_renamed = 2;
    private final int x_renamed = 3;
    private final int y_renamed = 4;
    private final int z_renamed = 5;
    private final int A_renamed = 7;
    private int B_renamed = 90;
    private int C_renamed = 0;
    private int D_renamed = 0;
    private int E_renamed = 0;
    private int F_renamed = 0;
    private int G_renamed = 0;
    private int H_renamed = 0;
    private boolean I_renamed = false;
    private boolean J_renamed = false;
    private boolean K_renamed = false;
    private com.arcsoft.camera.wideselfie.AwsInitParameter M_renamed = null;
    private com.arcsoft.camera.wideselfie.WideSelfieEngine N_renamed = null;
    private float O_renamed = 10000.0f;
    private android.os.HandlerThread Q_renamed = null;
    private android.os.Handler R_renamed = null;
    private android.hardware.SensorManager T_renamed = null;
    private android.hardware.Sensor U_renamed = null;
    private java.lang.Object V_renamed = new java.lang.Object();

    /* compiled from: FrontPanoramaEngine.java */
    public interface a_renamed {
        void a_renamed();

        void a_renamed(int i_renamed);

        void a_renamed(android.graphics.Bitmap bitmap);

        void a_renamed(boolean z_renamed, byte[] bArr, int i_renamed, int i2);

        void b_renamed();

        void c_renamed();

        void d_renamed();

        int e_renamed();

        boolean f_renamed();
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(android.hardware.Sensor sensor, int i_renamed) {
    }

    public d_renamed(android.app.Activity activity, android.util.Size size, boolean z_renamed, com.oplus.camera.panorama.d_renamed.a_renamed aVar, float[] fArr) {
        this.L_renamed = false;
        this.P_renamed = null;
        this.S_renamed = null;
        this.W_renamed = null;
        this.X_renamed = null;
        this.Y_renamed = 0;
        this.S_renamed = size;
        this.L_renamed = z_renamed;
        this.W_renamed = aVar;
        this.P_renamed = fArr;
        this.Y_renamed = activity.getApplicationContext().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.panorama_rim_width);
        this.X_renamed = new android.graphics.Paint();
        this.X_renamed.setStyle(android.graphics.Paint.Style.STROKE);
        this.X_renamed.setStrokeWidth(this.Y_renamed);
        this.X_renamed.setColor(-1);
        k_renamed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f_renamed() throws java.lang.Throwable {
        com.oplus.camera.e_renamed.a_renamed("FrontPanoramaEngine", "frontCapPrepare enter");
        j_renamed();
        this.F_renamed = 0;
        this.O_renamed = g_renamed() / 4.0f;
        this.I_renamed = true;
        h_renamed();
    }

    private int g_renamed() {
        android.util.Size size = this.S_renamed;
        if (size != null) {
            return (size.getHeight() * 2) / 6;
        }
        return 0;
    }

    private void h_renamed() throws java.lang.Throwable {
        android.util.Size size = this.S_renamed;
        if (size == null) {
            return;
        }
        this.M_renamed = com.arcsoft.camera.wideselfie.AwsInitParameter.getDefaultInitParams(size.getWidth(), this.S_renamed.getHeight(), 2050, this.B_renamed);
        this.M_renamed.maxResultWidth = this.S_renamed.getHeight() * 2;
        this.M_renamed.progressBarThumbHeight = i_renamed();
        float[] fArr = this.P_renamed;
        if (fArr != null && fArr.length == 2) {
            com.arcsoft.camera.wideselfie.AwsInitParameter awsInitParameter = this.M_renamed;
            awsInitParameter.cameraViewAngleForWidth = fArr[0];
            awsInitParameter.cameraViewAngleForHeight = fArr[1];
        }
        com.oplus.camera.e_renamed.a_renamed("FrontPanoramaEngine", "createEngine, cameraViewAngleForHeight after: " + this.M_renamed.cameraViewAngleForHeight + ", cameraViewAngleForWidth after: " + this.M_renamed.cameraViewAngleForWidth);
        this.N_renamed = com.arcsoft.camera.wideselfie.WideSelfieEngine.singleInstance(com.arcsoft.camera.wideselfie.ArcWideSelfieDef.DEFAUT_JNI_LIB_NAME);
        int iInit = this.N_renamed.init(this.M_renamed);
        if (iInit != 0) {
            com.oplus.camera.e_renamed.f_renamed("FrontPanoramaEngine", "createEngine WideSelfieEngine init error, res: " + iInit);
        }
        this.N_renamed.setOnCallback(this);
        int i_renamed = this.M_renamed.maxResultWidth;
        int i2 = this.M_renamed.progressBarThumbHeight;
        int fullImageWidth = this.M_renamed.getFullImageWidth();
        this.C_renamed = this.M_renamed.progressBarThumbHeight;
        this.D_renamed = (int) (((i_renamed * 1.0f) / fullImageWidth) * i2);
        this.D_renamed = (this.D_renamed / 4) * 4;
    }

    private int i_renamed() {
        android.util.Size size = this.S_renamed;
        if (size != null) {
            return size.getWidth() / 6;
        }
        return 0;
    }

    private void j_renamed() {
        this.T_renamed = (android.hardware.SensorManager) com.oplus.camera.util.Util.l_renamed().getSystemService("sensor");
        this.U_renamed = this.T_renamed.getDefaultSensor(4);
        synchronized (this.V_renamed) {
            if (this.U_renamed != null) {
                this.T_renamed.registerListener(this, this.U_renamed, 10000, this.R_renamed);
            } else {
                com.oplus.camera.e_renamed.f_renamed("FrontPanoramaEngine", "initSensor, mGyroSensor is_renamed null.");
                android.widget.Toast.makeText(com.oplus.camera.util.Util.l_renamed(), com.oplus.camera.util.Util.l_renamed().getString(com.oplus.camera.R_renamed.string.camera_gyroscope_abnormal_warning_toast), 0).show();
            }
        }
    }

    public void a_renamed(boolean z_renamed) {
        this.K_renamed = z_renamed;
        synchronized (this.V_renamed) {
            if (this.R_renamed != null) {
                this.R_renamed.sendEmptyMessage(1);
            }
        }
    }

    private void k_renamed() {
        com.oplus.camera.e_renamed.a_renamed("FrontPanoramaEngine", "initFrontHandler enter");
        if (this.Q_renamed == null) {
            this.Q_renamed = new android.os.HandlerThread("front_panorama");
            this.Q_renamed.start();
        }
        synchronized (this.V_renamed) {
            if (this.R_renamed != null) {
                return;
            }
            this.R_renamed = new android.os.Handler(this.Q_renamed.getLooper()) { // from class: com.oplus.camera.panorama.d_renamed.1
                @Override // android.os.Handler
                public void handleMessage(android.os.Message message) throws java.lang.Throwable {
                    int i_renamed = message.what;
                    if (i_renamed == 1) {
                        com.oplus.camera.panorama.d_renamed.this.f_renamed();
                    } else if (i_renamed == 2) {
                        com.oplus.camera.panorama.d_renamed.this.l_renamed();
                    } else if (i_renamed == 3) {
                        com.oplus.camera.panorama.d_renamed.this.a_renamed((byte[]) message.obj);
                    } else if (i_renamed == 4) {
                        com.oplus.camera.panorama.d_renamed.this.n_renamed();
                    } else {
                        com.oplus.camera.e_renamed.a_renamed("FrontPanoramaEngine", "mFrontHandler default enter");
                    }
                    super.handleMessage(message);
                }
            };
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(android.hardware.SensorEvent sensorEvent) {
        com.arcsoft.camera.wideselfie.WideSelfieEngine wideSelfieEngine;
        int type = sensorEvent.sensor.getType();
        if (4 != type || (wideSelfieEngine = this.N_renamed) == null) {
            return;
        }
        wideSelfieEngine.pushSensorDataIn(type, sensorEvent.values, sensorEvent.timestamp);
        this.J_renamed = true;
    }

    @Override // com.arcsoft.camera.wideselfie.WideSelfieCallback
    public void onProcessCallback(int i_renamed, com.arcsoft.camera.wideselfie.ProcessResult processResult) throws java.lang.Throwable {
        if (processResult == null) {
            com.oplus.camera.e_renamed.f_renamed("FrontPanoramaEngine", "onProcessCallback error, data is_renamed null");
            return;
        }
        if (!this.I_renamed) {
            a_renamed(processResult);
        } else {
            c_renamed(processResult);
            b_renamed(processResult);
        }
        a_renamed(i_renamed, processResult);
    }

    private void a_renamed(int i_renamed, com.arcsoft.camera.wideselfie.ProcessResult processResult) {
        if (28672 == i_renamed || 28673 == i_renamed || 28675 == i_renamed || 28676 == i_renamed || 28677 == i_renamed || 28678 == i_renamed || 28679 == i_renamed || 4 == i_renamed || 2 == i_renamed) {
            a_renamed(4);
            com.oplus.camera.e_renamed.f_renamed("FrontPanoramaEngine", "processResultForStatus, error code: " + i_renamed);
        }
        if (32769 == i_renamed || 32770 == i_renamed) {
            a_renamed(5);
        }
        if (java.lang.Math.abs(processResult.progressBarThumbOffset.y_renamed) >= ((int) (g_renamed() * 0.25f)) + ((int) ((g_renamed() * 0.5f) / 3.0f))) {
            a_renamed(7);
        }
        if (100 == processResult.progress) {
            a_renamed(2);
        }
    }

    private void a_renamed(com.arcsoft.camera.wideselfie.ProcessResult processResult) throws java.lang.Throwable {
        byte[] bArrA;
        com.oplus.camera.e_renamed.a_renamed("FrontPanoramaEngine", "processResultRealTimeBitmap enter");
        if (processResult.resultImageHeight <= 0 || processResult.resultImageWidth <= 0) {
            com.oplus.camera.e_renamed.f_renamed("FrontPanoramaEngine", "processResultRealTimeBitmap error, resultImageHeight: " + processResult.resultImageHeight + ", resultImageWidth: " + processResult.resultImageWidth);
            this.W_renamed.a_renamed();
            return;
        }
        if (this.W_renamed.f_renamed()) {
            bArrA = b_renamed(this.K_renamed, processResult);
        } else {
            bArrA = a_renamed(this.K_renamed, processResult);
        }
        this.W_renamed.d_renamed();
        l_renamed();
        this.W_renamed.a_renamed(this.K_renamed, bArrA, processResult.resultImageWidth, processResult.resultImageHeight);
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:81:0x01a0 A_renamed[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:89:? A_renamed[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private byte[] a_renamed(boolean r20, com.arcsoft.camera.wideselfie.ProcessResult r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 445
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.panorama.d_renamed.a_renamed(boolean, com.arcsoft.camera.wideselfie.ProcessResult):byte[]");
    }

    private byte[] b_renamed(boolean z_renamed, com.arcsoft.camera.wideselfie.ProcessResult processResult) {
        byte[] bArr = new byte[processResult.resultImageArray.length];
        int i_renamed = processResult.resultImageWidth;
        int i2 = processResult.resultImageHeight;
        com.oplus.camera.jni.FormatConverter.rotateAndMirrorYUV(processResult.resultImageArray, bArr, processResult.resultImageArray.length, new int[]{i_renamed, i_renamed}, new int[]{i2, i2}, i_renamed, i2, z_renamed ? this.W_renamed.e_renamed() + 90 : this.W_renamed.e_renamed(), !this.L_renamed);
        return bArr;
    }

    public android.graphics.Bitmap a_renamed(android.graphics.Bitmap bitmap) {
        if (bitmap == null || g_renamed() <= 0 || i_renamed() <= 0) {
            com.oplus.camera.e_renamed.f_renamed("FrontPanoramaEngine", "drawFrontPreviewBitmap, bitmap is_renamed null,or getFrontPreviewHeight: " + i_renamed() + ", getFrontPreviewWidth: " + g_renamed());
            return null;
        }
        android.graphics.Bitmap bitmapA = com.oplus.camera.util.Util.a_renamed(g_renamed(), i_renamed(), android.graphics.Bitmap.Config.ARGB_8888);
        int iG = g_renamed();
        int i_renamed = i_renamed();
        float f_renamed = 0.5f * iG * 0.5f;
        android.graphics.Canvas canvas = new android.graphics.Canvas(bitmapA);
        canvas.drawBitmap(bitmap, g_renamed() / 4.0f, 0.0f, (android.graphics.Paint) null);
        int i2 = this.Y_renamed;
        canvas.drawRect(((int) f_renamed) + (i2 / 2.0f), i2 / 2.0f, ((int) (f_renamed + r3)) - (i2 / 2.0f), i_renamed - (i2 / 2.0f), this.X_renamed);
        return bitmapA;
    }

    private android.graphics.Bitmap a_renamed(android.graphics.Bitmap bitmap, float f_renamed) {
        if (bitmap == null) {
            com.oplus.camera.e_renamed.a_renamed("FrontPanoramaEngine", "drawPreviewBitmap, bitmap is_renamed null");
            return null;
        }
        android.graphics.Bitmap bitmapA = com.oplus.camera.util.Util.a_renamed(g_renamed(), i_renamed(), android.graphics.Bitmap.Config.ARGB_8888);
        android.graphics.Canvas canvas = new android.graphics.Canvas(bitmapA);
        float fG_renamed = g_renamed() / 4.0f;
        if (f_renamed > 0.0f) {
            fG_renamed -= f_renamed;
        }
        this.F_renamed = java.lang.Math.max((int) (((g_renamed() * 0.5f) + fG_renamed) - f_renamed), this.F_renamed);
        if (this.F_renamed > g_renamed()) {
            this.F_renamed = g_renamed();
        }
        float f2 = this.O_renamed;
        int iMin = 10000.0f != f2 ? (int) java.lang.Math.min(fG_renamed, f2) : 0;
        if (iMin < 0) {
            iMin = 0;
        }
        int i_renamed = this.F_renamed;
        int i2 = i_renamed();
        this.O_renamed = iMin;
        canvas.drawBitmap(bitmap, (android.graphics.Rect) null, new android.graphics.Rect(iMin, 0, i_renamed, i2), (android.graphics.Paint) null);
        int iG = g_renamed();
        int i3 = i_renamed();
        float f3 = iG;
        float f4 = f3 * 0.5f;
        float f5 = (int) (0.5f * f4);
        int iMax = (int) java.lang.Math.max(0.0f, f5 - f_renamed);
        int iMin2 = (int) java.lang.Math.min(f3, (f5 + f4) - f_renamed);
        int i4 = this.Y_renamed;
        canvas.drawRect(iMax + (i4 / 2.0f), i4 / 2.0f, iMin2 - (i4 / 2.0f), i3 - (i4 / 2.0f), this.X_renamed);
        return bitmapA;
    }

    private void b_renamed(com.arcsoft.camera.wideselfie.ProcessResult processResult) {
        if (processResult == null || this.E_renamed == processResult.direction) {
            return;
        }
        if (processResult.direction == 1) {
            this.W_renamed.a_renamed(0);
        } else {
            this.W_renamed.a_renamed(1);
        }
        this.E_renamed = processResult.direction;
    }

    private void c_renamed(com.arcsoft.camera.wideselfie.ProcessResult processResult) {
        new android.graphics.Canvas(android.graphics.Bitmap.createBitmap(this.C_renamed, this.D_renamed, android.graphics.Bitmap.Config.ARGB_8888)).drawARGB(100, 0, 0, 0);
        this.G_renamed = java.lang.Math.max(processResult.progressBarThumbOffset.y_renamed, this.G_renamed);
        this.H_renamed = java.lang.Math.min(processResult.progressBarThumbOffset.y_renamed, this.H_renamed);
        android.graphics.Bitmap bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(processResult.progressBarThumbRgbPixels, processResult.progressBarThumbImageWidth, processResult.progressBarThumbImageHeight, android.graphics.Bitmap.Config.ARGB_8888);
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        matrix.postRotate(90.0f);
        android.graphics.Bitmap bitmapA = com.oplus.camera.util.Util.a_renamed(bitmapCreateBitmap, 0, 0, bitmapCreateBitmap.getWidth(), bitmapCreateBitmap.getHeight(), matrix, true);
        if (bitmapA != null) {
            this.W_renamed.a_renamed(a_renamed(bitmapA, processResult.progressBarThumbOffset.y_renamed));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l_renamed() {
        int iUninit;
        com.oplus.camera.e_renamed.a_renamed("FrontPanoramaEngine", "destroyEngine enter");
        com.arcsoft.camera.wideselfie.WideSelfieEngine wideSelfieEngine = this.N_renamed;
        if (wideSelfieEngine != null && (iUninit = wideSelfieEngine.uninit()) != 0) {
            com.oplus.camera.e_renamed.f_renamed("FrontPanoramaEngine", "destroyEngine error, res: " + iUninit);
        }
        this.N_renamed = null;
        this.M_renamed = null;
        this.J_renamed = false;
        this.H_renamed = 0;
        this.G_renamed = 0;
        m_renamed();
    }

    private void m_renamed() {
        android.hardware.SensorManager sensorManager;
        com.oplus.camera.e_renamed.a_renamed("FrontPanoramaEngine", "unRegisterSensor, mGyroSensor: " + this.U_renamed + ", mSensorManager: " + this.T_renamed);
        if (this.U_renamed == null || (sensorManager = this.T_renamed) == null) {
            return;
        }
        sensorManager.unregisterListener(this);
    }

    public void a_renamed(byte[] bArr) {
        if (this.N_renamed == null || !this.I_renamed) {
            com.oplus.camera.e_renamed.a_renamed("FrontPanoramaEngine", "onPreviewFrame, mWideSelfieEngine: " + this.N_renamed + ", mbFrontCapturing: " + this.I_renamed);
            return;
        }
        this.W_renamed.b_renamed();
        int iProcess = this.N_renamed.process(0, bArr);
        this.W_renamed.c_renamed();
        if (iProcess != 0) {
            com.oplus.camera.e_renamed.f_renamed("FrontPanoramaEngine", "onPreviewFrame process select error, res：" + iProcess);
        }
    }

    public void a_renamed() {
        com.oplus.camera.e_renamed.a_renamed("FrontPanoramaEngine", "destroyFrontEngine enter");
        this.K_renamed = false;
        synchronized (this.V_renamed) {
            if (this.R_renamed != null) {
                this.R_renamed.sendEmptyMessage(2);
            }
        }
    }

    public void b_renamed(byte[] bArr) {
        if (this.I_renamed) {
            synchronized (this.V_renamed) {
                if (this.R_renamed != null && bArr != null && (this.J_renamed || this.U_renamed == null)) {
                    android.os.Message messageObtain = android.os.Message.obtain();
                    messageObtain.what = 3;
                    messageObtain.obj = bArr;
                    this.R_renamed.sendMessage(messageObtain);
                } else {
                    com.oplus.camera.e_renamed.a_renamed("FrontPanoramaEngine", "manageOnFrame, mFrontHandler: " + this.R_renamed + ", mbSensorDataReady: " + this.J_renamed);
                }
            }
        }
    }

    public boolean b_renamed() {
        return this.I_renamed;
    }

    public void b_renamed(boolean z_renamed) {
        this.I_renamed = z_renamed;
    }

    public void c_renamed() {
        a_renamed(1);
    }

    public void d_renamed() {
        synchronized (this.V_renamed) {
            if (this.R_renamed != null) {
                this.R_renamed.getLooper().quitSafely();
                this.R_renamed = null;
            }
        }
    }

    private void a_renamed(int i_renamed) {
        com.oplus.camera.e_renamed.a_renamed("FrontPanoramaEngine", "stopProcessingWithType, stopType: " + i_renamed);
        synchronized (this.V_renamed) {
            if (this.R_renamed != null) {
                android.os.Message messageObtain = android.os.Message.obtain();
                messageObtain.what = 4;
                this.R_renamed.sendMessage(messageObtain);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n_renamed() {
        com.arcsoft.camera.wideselfie.WideSelfieEngine wideSelfieEngine = this.N_renamed;
        if (wideSelfieEngine == null || !this.I_renamed) {
            return;
        }
        this.I_renamed = false;
        wideSelfieEngine.stopProcessing();
    }

    public void e_renamed() {
        a_renamed(3);
    }
}
