package com.oplus.camera.p171u;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Point;
import android.graphics.PointF;
import com.oplus.camera.CameraLog;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.aps.constant.ApsConstant;
import com.oplus.camera.p181w.CameraThreadExector;
import com.oplus.camera.util.Util;
import com.tencent.youtu.YTCommonInterface;
import com.youtu.ocr.docprocess.Helper_2;
import com.youtu.ocr.docprocess.DocDetector;
import com.youtu.ocr.docprocess.IText;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: SuperTextEngine.java */
/* renamed from: com.oplus.camera.u.IntrinsicsJvm.kt_3 */
/* loaded from: classes2.dex */
public class SuperTextEngine implements ISuperText {

    /* renamed from: PlatformImplementations.kt_3 */
    private static boolean f17068a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static boolean f17069b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private boolean f17070c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private boolean f17071d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final Object f17072e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f17073f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private DocDetector f17074g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private Context f17075h;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f17076i;

    private SuperTextEngine() {
        this.f17070c = false;
        this.f17071d = false;
        this.f17072e = new Object();
        this.f17073f = -1;
        this.f17074g = new DocDetector();
        this.f17075h = null;
        this.f17076i = 0;
        this.f17075h = Util.m24472l();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public static SuperTextEngine m17970d() {
        return PlatformImplementations.kt_3.f17079a;
    }

    /* compiled from: SuperTextEngine.java */
    /* renamed from: com.oplus.camera.u.IntrinsicsJvm.kt_3$PlatformImplementations.kt_3 */
    private static final class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        private static SuperTextEngine f17079a = new SuperTextEngine();
    }

    static {
        System.loadLibrary(ApsConstant.CAPTURE_MODE_COMMON);
    }

    @Override // com.oplus.camera.p171u.ISuperText
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo17959a(int OplusGLSurfaceView_13) {
        this.f17076i = OplusGLSurfaceView_13;
    }

    @Override // com.oplus.camera.p171u.ISuperText
    /* renamed from: IntrinsicsJvm.kt_4 */
    public int mo17963b() {
        return this.f17076i;
    }

    @Override // com.oplus.camera.p171u.ISuperText
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo17960a(final boolean z) {
        CameraLog.m12954a("SuperTextEngine", "init, isCpuProcess: " + z + ", sbIniting: " + f17069b);
        if (f17069b) {
            return;
        }
        CameraThreadExector.m24695a().m24696a(new Runnable() { // from class: com.oplus.camera.u.IntrinsicsJvm.kt_3.1
            @Override // java.lang.Runnable
            public void run() throws IOException {
                SuperTextEngine.this.m17969c(z);
            }
        }, "init super text sdk");
    }

    @Override // com.oplus.camera.p171u.ISuperText
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo17961a() {
        boolean z;
        synchronized (this.f17072e) {
            z = this.f17073f == 0;
        }
        return z;
    }

    @Override // com.oplus.camera.p171u.ISuperText
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo17964b(boolean z) {
        synchronized (this.f17072e) {
            if (z) {
                this.f17073f = 0;
            } else {
                this.f17073f = -1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m17969c(boolean z) throws IOException {
        CameraLog.m12954a("SuperTextEngine", "initSdk, isCpuProcess: " + z);
        f17069b = true;
        InputStream inputStreamOpen = null;
        try {
            try {
                AssetManager assets = this.f17075h.getResources().getAssets();
                CameraLog.m12959b("SuperTextEngine", "initSdk, ret: " + YTCommonInterface.m25549a("license.lic", "DF6i36rLXS6SgeKipfIgndCUUCckbARQ"));
                inputStreamOpen = assets.open("DocDetectV15.xbin");
                byte[] bArrM17968a = m17968a(inputStreamOpen, inputStreamOpen.available());
                if (z) {
                    this.f17071d = this.f17074g.xnnInitedByByte(bArrM17968a);
                } else {
                    this.f17070c = this.f17074g.xnnInitedByByteGPU(bArrM17968a, this.f17075h.getFilesDir().getAbsolutePath() + File.separator + "initGPUcache.bin");
                }
                CameraLog.m12959b("SuperTextEngine", "initSdk, mbCpuSdkInited: " + this.f17071d + ", version: " + Helper_2.f24209a.m25555a());
                if (inputStreamOpen != null) {
                    try {
                        inputStreamOpen.close();
                    } catch (IOException COUIBaseListPopupWindow_8) {
                        COUIBaseListPopupWindow_8 = COUIBaseListPopupWindow_8;
                        COUIBaseListPopupWindow_8.printStackTrace();
                        f17069b = false;
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                if (inputStreamOpen != null) {
                    try {
                        inputStreamOpen.close();
                    } catch (IOException e3) {
                        COUIBaseListPopupWindow_8 = e3;
                        COUIBaseListPopupWindow_8.printStackTrace();
                        f17069b = false;
                    }
                }
            }
            f17069b = false;
        } catch (Throwable th) {
            if (inputStreamOpen != null) {
                try {
                    inputStreamOpen.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
            f17069b = false;
            throw th;
        }
    }

    @Override // com.oplus.camera.p171u.ISuperText
    /* renamed from: PlatformImplementations.kt_3 */
    public DetectResult mo17958a(byte[] bArr, int OplusGLSurfaceView_13, int i2, int i3) {
        if (!this.f17071d) {
            CameraLog.m12967f("SuperTextEngine", "detectTextByByte, sdk not init yet");
            mo17960a(CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPER_TEXT_CPU_PROCESS));
            return new DetectResult();
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (f17068a) {
            jCurrentTimeMillis = System.currentTimeMillis();
        }
        IText.DetectResult detectResultM25552a = this.f17074g.m25552a(bArr, OplusGLSurfaceView_13, i2, i3);
        if (f17068a) {
            CameraLog.m12967f("SuperTextEngine", "detectTextByByte, cpu detect cost time: " + (System.currentTimeMillis() - jCurrentTimeMillis));
        }
        return m17966a(detectResultM25552a, OplusGLSurfaceView_13, i2, i3);
    }

    @Override // com.oplus.camera.p171u.ISuperText
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo17962a(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        return this.f17074g.m25553a(OplusGLSurfaceView_13, i2, i3, i4);
    }

    @Override // com.oplus.camera.p171u.ISuperText
    /* renamed from: PlatformImplementations.kt_3 */
    public DetectResult mo17957a(int OplusGLSurfaceView_13, int i2, int i3, boolean z) {
        if (!this.f17070c) {
            CameraLog.m12967f("SuperTextEngine", "detectTextByTexture, sdk not init yet");
            mo17960a(CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPER_TEXT_CPU_PROCESS));
            return new DetectResult();
        }
        long jCurrentTimeMillis = f17068a ? System.currentTimeMillis() : 0L;
        IText.DetectResult detectResultM25551a = this.f17074g.m25551a(z);
        if (f17068a) {
            CameraLog.m12967f("SuperTextEngine", "detectTextByTexture, gpu detect cost time: " + (System.currentTimeMillis() - jCurrentTimeMillis));
        }
        return m17966a(detectResultM25551a, OplusGLSurfaceView_13, i2, i3);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private DetectResult m17966a(IText.DetectResult detectResult, int OplusGLSurfaceView_13, int i2, int i3) {
        DetectResult c3077a = new DetectResult();
        c3077a.m17950a(detectResult.hasResult);
        if (!detectResult.hasResult) {
            return c3077a;
        }
        Point[] pointArr = new Point[4];
        PointF[] pointFArr = new PointF[4];
        PointF[] pointFArr2 = new PointF[4];
        for (int i4 = 0; i4 < detectResult.pointArr.length; i4++) {
            if (i3 == 0) {
                pointArr[i4] = new Point(detectResult.pointArr[i4].y, detectResult.pointArr[i4].x);
                float COUIBaseListPopupWindow_12 = i2;
                float f2 = OplusGLSurfaceView_13;
                pointFArr[i4] = new PointF(detectResult.pointArr[i4].y / COUIBaseListPopupWindow_12, detectResult.pointArr[i4].x / f2);
                pointFArr2[i4] = new PointF(detectResult.pointArr[i4].y / COUIBaseListPopupWindow_12, detectResult.pointArr[i4].x / f2);
            } else if (i3 == 90) {
                pointArr[i4] = new Point(detectResult.pointArr[i4].x, OplusGLSurfaceView_13 - detectResult.pointArr[i4].y);
                float f3 = i2;
                float f4 = OplusGLSurfaceView_13;
                pointFArr[i4] = new PointF(detectResult.pointArr[i4].x / f3, (f4 - detectResult.pointArr[i4].y) / f4);
                pointFArr2[i4] = new PointF(detectResult.pointArr[i4].y / f4, detectResult.pointArr[i4].x / f3);
            } else if (i3 == 180) {
                pointArr[i4] = new Point(i2 - detectResult.pointArr[i4].y, OplusGLSurfaceView_13 - detectResult.pointArr[i4].x);
                float f5 = i2;
                float f6 = OplusGLSurfaceView_13;
                pointFArr[i4] = new PointF((i2 - detectResult.pointArr[i4].y) / f5, (f6 - detectResult.pointArr[i4].x) / f6);
                pointFArr2[i4] = new PointF(detectResult.pointArr[i4].y / f5, detectResult.pointArr[i4].x / f6);
            } else if (i3 == 270) {
                pointArr[i4] = new Point(i2 - detectResult.pointArr[i4].x, detectResult.pointArr[i4].y);
                float f7 = i2;
                float f8 = OplusGLSurfaceView_13;
                pointFArr[i4] = new PointF((i2 - detectResult.pointArr[i4].x) / f7, detectResult.pointArr[i4].y / f8);
                pointFArr2[i4] = new PointF(detectResult.pointArr[i4].y / f8, detectResult.pointArr[i4].x / f7);
            }
            pointFArr[i4].x = Util.m24201a(pointFArr[i4].x, 0.0f, 1.0f);
            pointFArr[i4].y = Util.m24201a(pointFArr[i4].y, 0.0f, 1.0f);
            pointFArr2[i4].x = Util.m24201a(pointFArr2[i4].x, 0.0f, 1.0f);
            pointFArr2[i4].y = Util.m24201a(pointFArr2[i4].y, 0.0f, 1.0f);
        }
        c3077a.m17951a(pointArr);
        c3077a.m17954b(pointFArr);
        c3077a.m17952a(pointFArr2);
        return c3077a;
    }

    @Override // com.oplus.camera.p171u.ISuperText
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo17965c() {
        this.f17074g.xnnReleaseGLSource();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private byte[] m17968a(InputStream inputStream, int OplusGLSurfaceView_13) throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[OplusGLSurfaceView_13];
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
