package com.oplus.camera.u_renamed;

/* compiled from: SuperTextEngine.java */
/* loaded from: classes2.dex */
public class c_renamed implements com.oplus.camera.u_renamed.b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static boolean f5736a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private static boolean f5737b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private boolean f5738c;
    private boolean d_renamed;
    private final java.lang.Object e_renamed;
    private int f_renamed;
    private com.youtu.ocr.docprocess.DocDetector g_renamed;
    private android.content.Context h_renamed;
    private int i_renamed;

    private c_renamed() {
        this.f5738c = false;
        this.d_renamed = false;
        this.e_renamed = new java.lang.Object();
        this.f_renamed = -1;
        this.g_renamed = new com.youtu.ocr.docprocess.DocDetector();
        this.h_renamed = null;
        this.i_renamed = 0;
        this.h_renamed = com.oplus.camera.util.Util.l_renamed();
    }

    public static com.oplus.camera.u_renamed.c_renamed d_renamed() {
        return com.oplus.camera.u_renamed.c_renamed.a_renamed.f5741a;
    }

    /* compiled from: SuperTextEngine.java */
    private static final class a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        private static com.oplus.camera.u_renamed.c_renamed f5741a = new com.oplus.camera.u_renamed.c_renamed();
    }

    static {
        java.lang.System.loadLibrary(com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_COMMON);
    }

    @Override // com.oplus.camera.u_renamed.b_renamed
    public void a_renamed(int i_renamed) {
        this.i_renamed = i_renamed;
    }

    @Override // com.oplus.camera.u_renamed.b_renamed
    public int b_renamed() {
        return this.i_renamed;
    }

    @Override // com.oplus.camera.u_renamed.b_renamed
    public void a_renamed(final boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("SuperTextEngine", "init, isCpuProcess: " + z_renamed + ", sbIniting: " + f5737b);
        if (f5737b) {
            return;
        }
        com.oplus.camera.w_renamed.d_renamed.a_renamed().a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.u_renamed.c_renamed.1
            @Override // java.lang.Runnable
            public void run() throws java.io.IOException {
                com.oplus.camera.u_renamed.c_renamed.this.c_renamed(z_renamed);
            }
        }, "init super text sdk");
    }

    @Override // com.oplus.camera.u_renamed.b_renamed
    public boolean a_renamed() {
        boolean z_renamed;
        synchronized (this.e_renamed) {
            z_renamed = this.f_renamed == 0;
        }
        return z_renamed;
    }

    @Override // com.oplus.camera.u_renamed.b_renamed
    public void b_renamed(boolean z_renamed) {
        synchronized (this.e_renamed) {
            if (z_renamed) {
                this.f_renamed = 0;
            } else {
                this.f_renamed = -1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c_renamed(boolean z_renamed) throws java.io.IOException {
        com.oplus.camera.e_renamed.a_renamed("SuperTextEngine", "initSdk, isCpuProcess: " + z_renamed);
        f5737b = true;
        java.io.InputStream inputStreamOpen = null;
        try {
            try {
                android.content.res.AssetManager assets = this.h_renamed.getResources().getAssets();
                com.oplus.camera.e_renamed.b_renamed("SuperTextEngine", "initSdk, ret: " + com.tencent.youtu.YTCommonInterface.a_renamed("license.lic", "DF6i36rLXS6SgeKipfIgndCUUCckbARQ"));
                inputStreamOpen = assets.open("DocDetectV15.xbin");
                byte[] bArrA = a_renamed(inputStreamOpen, inputStreamOpen.available());
                if (z_renamed) {
                    this.d_renamed = this.g_renamed.xnnInitedByByte(bArrA);
                } else {
                    this.f5738c = this.g_renamed.xnnInitedByByteGPU(bArrA, this.h_renamed.getFilesDir().getAbsolutePath() + java.io.File.separator + "initGPUcache.bin");
                }
                com.oplus.camera.e_renamed.b_renamed("SuperTextEngine", "initSdk, mbCpuSdkInited: " + this.d_renamed + ", version: " + com.youtu.ocr.docprocess.b_renamed.f7777a.a_renamed());
                if (inputStreamOpen != null) {
                    try {
                        inputStreamOpen.close();
                    } catch (java.io.IOException e_renamed) {
                        e_renamed = e_renamed;
                        e_renamed.printStackTrace();
                        f5737b = false;
                    }
                }
            } catch (java.lang.Exception e2) {
                e2.printStackTrace();
                if (inputStreamOpen != null) {
                    try {
                        inputStreamOpen.close();
                    } catch (java.io.IOException e3) {
                        e_renamed = e3;
                        e_renamed.printStackTrace();
                        f5737b = false;
                    }
                }
            }
            f5737b = false;
        } catch (java.lang.Throwable th) {
            if (inputStreamOpen != null) {
                try {
                    inputStreamOpen.close();
                } catch (java.io.IOException e4) {
                    e4.printStackTrace();
                }
            }
            f5737b = false;
            throw th;
        }
    }

    @Override // com.oplus.camera.u_renamed.b_renamed
    public com.oplus.camera.u_renamed.a_renamed a_renamed(byte[] bArr, int i_renamed, int i2, int i3) {
        if (!this.d_renamed) {
            com.oplus.camera.e_renamed.f_renamed("SuperTextEngine", "detectTextByByte, sdk not init yet");
            a_renamed(com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPER_TEXT_CPU_PROCESS));
            return new com.oplus.camera.u_renamed.a_renamed();
        }
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        if (f5736a) {
            jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        }
        com.youtu.ocr.docprocess.IText.DetectResult detectResultA = this.g_renamed.a_renamed(bArr, i_renamed, i2, i3);
        if (f5736a) {
            com.oplus.camera.e_renamed.f_renamed("SuperTextEngine", "detectTextByByte, cpu detect cost time: " + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis));
        }
        return a_renamed(detectResultA, i_renamed, i2, i3);
    }

    @Override // com.oplus.camera.u_renamed.b_renamed
    public boolean a_renamed(int i_renamed, int i2, int i3, int i4) {
        return this.g_renamed.a_renamed(i_renamed, i2, i3, i4);
    }

    @Override // com.oplus.camera.u_renamed.b_renamed
    public com.oplus.camera.u_renamed.a_renamed a_renamed(int i_renamed, int i2, int i3, boolean z_renamed) {
        if (!this.f5738c) {
            com.oplus.camera.e_renamed.f_renamed("SuperTextEngine", "detectTextByTexture, sdk not init yet");
            a_renamed(com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPER_TEXT_CPU_PROCESS));
            return new com.oplus.camera.u_renamed.a_renamed();
        }
        long jCurrentTimeMillis = f5736a ? java.lang.System.currentTimeMillis() : 0L;
        com.youtu.ocr.docprocess.IText.DetectResult detectResultA = this.g_renamed.a_renamed(z_renamed);
        if (f5736a) {
            com.oplus.camera.e_renamed.f_renamed("SuperTextEngine", "detectTextByTexture, gpu detect cost time: " + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis));
        }
        return a_renamed(detectResultA, i_renamed, i2, i3);
    }

    private com.oplus.camera.u_renamed.a_renamed a_renamed(com.youtu.ocr.docprocess.IText.DetectResult detectResult, int i_renamed, int i2, int i3) {
        com.oplus.camera.u_renamed.a_renamed aVar = new com.oplus.camera.u_renamed.a_renamed();
        aVar.a_renamed(detectResult.hasResult);
        if (!detectResult.hasResult) {
            return aVar;
        }
        android.graphics.Point[] pointArr = new android.graphics.Point[4];
        android.graphics.PointF[] pointFArr = new android.graphics.PointF[4];
        android.graphics.PointF[] pointFArr2 = new android.graphics.PointF[4];
        for (int i4 = 0; i4 < detectResult.pointArr.length; i4++) {
            if (i3 == 0) {
                pointArr[i4] = new android.graphics.Point(detectResult.pointArr[i4].y_renamed, detectResult.pointArr[i4].x_renamed);
                float f_renamed = i2;
                float f2 = i_renamed;
                pointFArr[i4] = new android.graphics.PointF(detectResult.pointArr[i4].y_renamed / f_renamed, detectResult.pointArr[i4].x_renamed / f2);
                pointFArr2[i4] = new android.graphics.PointF(detectResult.pointArr[i4].y_renamed / f_renamed, detectResult.pointArr[i4].x_renamed / f2);
            } else if (i3 == 90) {
                pointArr[i4] = new android.graphics.Point(detectResult.pointArr[i4].x_renamed, i_renamed - detectResult.pointArr[i4].y_renamed);
                float f3 = i2;
                float f4 = i_renamed;
                pointFArr[i4] = new android.graphics.PointF(detectResult.pointArr[i4].x_renamed / f3, (f4 - detectResult.pointArr[i4].y_renamed) / f4);
                pointFArr2[i4] = new android.graphics.PointF(detectResult.pointArr[i4].y_renamed / f4, detectResult.pointArr[i4].x_renamed / f3);
            } else if (i3 == 180) {
                pointArr[i4] = new android.graphics.Point(i2 - detectResult.pointArr[i4].y_renamed, i_renamed - detectResult.pointArr[i4].x_renamed);
                float f5 = i2;
                float f6 = i_renamed;
                pointFArr[i4] = new android.graphics.PointF((i2 - detectResult.pointArr[i4].y_renamed) / f5, (f6 - detectResult.pointArr[i4].x_renamed) / f6);
                pointFArr2[i4] = new android.graphics.PointF(detectResult.pointArr[i4].y_renamed / f5, detectResult.pointArr[i4].x_renamed / f6);
            } else if (i3 == 270) {
                pointArr[i4] = new android.graphics.Point(i2 - detectResult.pointArr[i4].x_renamed, detectResult.pointArr[i4].y_renamed);
                float f7 = i2;
                float f8 = i_renamed;
                pointFArr[i4] = new android.graphics.PointF((i2 - detectResult.pointArr[i4].x_renamed) / f7, detectResult.pointArr[i4].y_renamed / f8);
                pointFArr2[i4] = new android.graphics.PointF(detectResult.pointArr[i4].y_renamed / f8, detectResult.pointArr[i4].x_renamed / f7);
            }
            pointFArr[i4].x_renamed = com.oplus.camera.util.Util.a_renamed(pointFArr[i4].x_renamed, 0.0f, 1.0f);
            pointFArr[i4].y_renamed = com.oplus.camera.util.Util.a_renamed(pointFArr[i4].y_renamed, 0.0f, 1.0f);
            pointFArr2[i4].x_renamed = com.oplus.camera.util.Util.a_renamed(pointFArr2[i4].x_renamed, 0.0f, 1.0f);
            pointFArr2[i4].y_renamed = com.oplus.camera.util.Util.a_renamed(pointFArr2[i4].y_renamed, 0.0f, 1.0f);
        }
        aVar.a_renamed(pointArr);
        aVar.b_renamed(pointFArr);
        aVar.a_renamed(pointFArr2);
        return aVar;
    }

    @Override // com.oplus.camera.u_renamed.b_renamed
    public void c_renamed() {
        this.g_renamed.xnnReleaseGLSource();
    }

    private byte[] a_renamed(java.io.InputStream inputStream, int i_renamed) throws java.lang.Exception {
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        byte[] bArr = new byte[i_renamed];
        while (true) {
            int i2 = inputStream.read(bArr);
            if (i2 != -1) {
                byteArrayOutputStream.write(bArr, 0, i2);
            } else {
                byteArrayOutputStream.close();
                inputStream.close();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }
}
