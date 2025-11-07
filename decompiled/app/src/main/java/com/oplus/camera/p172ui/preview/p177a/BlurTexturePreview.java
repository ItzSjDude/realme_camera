package com.oplus.camera.p172ui.preview.p177a;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.oplus.camera.CameraLog;
import com.oplus.camera.algovisualization.AlgoListProcessor;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.jni.SecurityLicenseChecker;
import com.oplus.camera.p136a.ModelStorage;
import com.oplus.camera.p146gl.GLES20Canvas;
import com.oplus.camera.p146gl.RawTexture;
import com.oplus.camera.p146gl.GLCanvas;
import com.oplus.camera.p172ui.preview.p177a.TexturePreview;
import com.oplus.camera.p172ui.preview.p177a.TexturePreviewRequest;
import com.oplus.camera.sticker.p167c.PrefUtils;
import com.oplus.camera.util.OpenGLUtils;
import com.oplus.camera.util.Util;
import com.sensetime.blur.BlurFilterLibrary;
import com.sensetime.blur.STBlurPreview;
import com.sensetime.faceapi.LicenseHelper;
import java.io.File;

/* compiled from: BlurTexturePreview.java */
/* renamed from: com.oplus.camera.ui.preview.PlatformImplementations.kt_3.COUIBaseListPopupWindow_8 */
/* loaded from: classes2.dex */
public class BlurTexturePreview extends TexturePreview implements TexturePreviewRequest.IntrinsicsJvm.kt_5 {

    /* renamed from: PlatformImplementations.kt_3 */
    public static String f21204a = "0ms";

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static boolean f21205b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final Object f21206c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f21207d;

    /* renamed from: OplusGLSurfaceView_5 */
    private int f21208k;

    /* renamed from: OplusGLSurfaceView_14 */
    private int f21209l;

    /* renamed from: OplusGLSurfaceView_6 */
    private int f21210m;

    /* renamed from: OplusGLSurfaceView_11 */
    private int f21211n;

    /* renamed from: o */
    private RawTexture f21212o;

    /* renamed from: p */
    private RawTexture f21213p;

    /* renamed from: q */
    private boolean f21214q;

    /* renamed from: r */
    private boolean f21215r;

    /* renamed from: s */
    private boolean f21216s;

    /* renamed from: t */
    private STBlurPreview f21217t;

    /* renamed from: u */
    private TexturePreviewRequest f21218u;

    /* renamed from: v */
    private boolean f21219v;

    /* renamed from: w */
    private boolean f21220w;

    /* renamed from: x */
    private Handler f21221x;

    /* renamed from: y */
    private HandlerThread f21222y;

    /* renamed from: z */
    private boolean f21223z;

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo22282a() {
        return false;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo22285b() {
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo22287c() {
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: IntrinsicsJvm.kt_5 */
    public int mo22289d() {
        return 1;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: COUIBaseListPopupWindow_10 */
    public boolean mo22293h() {
        return false;
    }

    public BlurTexturePreview(Context context) {
        super(context);
        this.f21206c = new Object();
        this.f21207d = 0;
        this.f21208k = 0;
        this.f21209l = 0;
        this.f21210m = -1;
        this.f21211n = -1;
        this.f21212o = null;
        this.f21213p = null;
        this.f21214q = false;
        this.f21215r = false;
        this.f21216s = true;
        this.f21217t = null;
        this.f21218u = null;
        this.f21219v = false;
        this.f21220w = false;
        this.f21221x = null;
        this.f21222y = null;
        this.f21223z = false;
        this.f21223z = PrefUtils.m16837g(context);
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22524a(byte[] bArr, int OplusGLSurfaceView_13, int i2) {
        if (this.f21219v) {
            synchronized (this.f21206c) {
                if (this.f21215r) {
                    return;
                }
                boolean z = this.f21543g;
                synchronized (this.f21206c) {
                    if (this.f21217t != null && this.f21218u != null) {
                        this.f21217t.onPreviewCallback(bArr, OplusGLSurfaceView_13, i2, this.f21218u.m22334C(), z, true, 1, null);
                    }
                }
            }
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo22283a(int OplusGLSurfaceView_13) {
        if (!mo22673a_(OplusGLSurfaceView_13)) {
            return false;
        }
        synchronized (this.f21206c) {
            if (this.f21218u == null) {
                CameraLog.m12954a("BlurTexturePreview", "canProcess, Engine has not init!");
                return false;
            }
            if (this.f21218u.m22334C() <= 0 && !this.f21215r) {
                CameraLog.m12967f("BlurTexturePreview", "canProcess, facesCount: " + this.f21218u.m22334C());
                return false;
            }
            if (!this.f21218u.m22401r()) {
                CameraLog.m12967f("BlurTexturePreview", "canProcess, not open effect");
                return false;
            }
            if (this.f21220w) {
                return true;
            }
            CameraLog.m12967f("BlurTexturePreview", "canProcess, texture is not inited");
            return false;
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo22284a(TexturePreview.PlatformImplementations.kt_3 aVar) throws Throwable {
        boolean z;
        Object obj;
        int OplusGLSurfaceView_13;
        int iProcessTextureGradual;
        int i2;
        int iDoOnPreviewProcess;
        long jM11591a = AlgoListProcessor.m11591a();
        if (this.f21218u == null || aVar == null || aVar.f21549c == null || this.f21212o == null) {
            return false;
        }
        if (!this.f21219v) {
            CameraLog.m12966e("BlurTexturePreview", "process, mSTBlurFilter not create, so return!");
            return false;
        }
        RawTexture c2768s = aVar.f21549c;
        int iH = c2768s.m13937h();
        int i3 = c2768s.m13938i();
        boolean z2 = this.f21543g;
        Object obj2 = this.f21206c;
        synchronized (obj2) {
            try {
                try {
                    if (this.f21217t != null) {
                        if (this.f21216s) {
                            this.f21217t.resetSegmentThread();
                            this.f21217t.setParam(BlurFilterLibrary.ST_BLUR_PARAM_TYPE_EFFECT_TYPE, this.f21215r ? 1.0f : 0.0f);
                            this.f21216s = false;
                        }
                        if (this.f21214q) {
                            m22539a(iH, i3, z2);
                            this.f21214q = false;
                        }
                        GLES20.glViewport(0, 0, iH, i3);
                        this.f21217t.setParam(4097, m22534a(this.f21218u.m22344a()));
                        if (z2) {
                            if (this.f21223z && this.f21215r) {
                                Util.m24252a(c2768s.m13934e(), iH, i3, "dump_retention_before");
                            }
                            if (!this.f21215r) {
                                iDoOnPreviewProcess = this.f21217t.processTexture(c2768s.m13934e(), this.f21210m, this.f21211n, new int[]{this.f21212o.m13934e()}, false);
                                obj = obj2;
                                i2 = -1;
                            } else {
                                STBlurPreview sTBlurPreview = this.f21217t;
                                int iE = c2768s.m13934e();
                                i2 = -1;
                                obj = obj2;
                                iDoOnPreviewProcess = sTBlurPreview.doOnPreviewProcess(iE, this.f21210m, this.f21211n, iH, i3, this.f21218u.m22334C(), new int[]{this.f21212o.m13934e()}, z2, false);
                            }
                            if (this.f21223z && this.f21215r) {
                                Util.m24252a(this.f21212o.m13934e(), this.f21212o.m13937h(), this.f21212o.m13938i(), "dump_retention_after");
                            }
                            iProcessTextureGradual = iDoOnPreviewProcess;
                            z = true;
                            OplusGLSurfaceView_13 = i2;
                        } else {
                            obj = obj2;
                            OplusGLSurfaceView_13 = -1;
                            int i4 = this.f21209l;
                            int i5 = 180;
                            if (i4 != 0) {
                                if (i4 == 90) {
                                    i5 = 270;
                                } else if (i4 == 180) {
                                    i5 = 0;
                                } else if (i4 == 270) {
                                    i5 = 90;
                                }
                            }
                            this.f21217t.rotateGrdualTexture(i5, false, false);
                            z = true;
                            iProcessTextureGradual = this.f21217t.processTextureGradual(c2768s.m13934e(), this.f21210m, this.f21211n, new float[]{1.0f, 0.8f, 0.6f, 0.3f}, new int[]{this.f21212o.m13934e()}, false);
                        }
                        GLES20Canvas.m14010i();
                    } else {
                        z = true;
                        obj = obj2;
                        OplusGLSurfaceView_13 = -1;
                        iProcessTextureGradual = -1;
                    }
                    GLES20.glViewport(0, 0, aVar.f21547a.mo13983d(), aVar.f21547a.mo13984e());
                    f21204a = AlgoListProcessor.m11592a(jM11591a, AlgoListProcessor.m11591a());
                    if (iProcessTextureGradual != OplusGLSurfaceView_13) {
                        return z;
                    }
                    return false;
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        throw th;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private float m22534a(float COUIBaseListPopupWindow_12) {
        if (Float.compare(COUIBaseListPopupWindow_12, 0.1f) <= 0) {
            return COUIBaseListPopupWindow_12;
        }
        if (Float.compare(COUIBaseListPopupWindow_12, 0.3f) < 0) {
            return 0.4f;
        }
        if (Float.compare(COUIBaseListPopupWindow_12, 0.4f) < 0) {
            return 0.5f;
        }
        if (Float.compare(COUIBaseListPopupWindow_12, 0.5f) < 0) {
            return 0.6f;
        }
        if (Float.compare(COUIBaseListPopupWindow_12, 0.6f) < 0) {
            return 0.7f;
        }
        if (Float.compare(COUIBaseListPopupWindow_12, 0.8f) < 0) {
            return 0.8f;
        }
        return COUIBaseListPopupWindow_12;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22281a(TexturePreviewRequest c3397aa) {
        CameraLog.m12954a("BlurTexturePreview", "createEngine, sbBlurLicenseChecked: " + f21205b + ", mBlurPreviewHandlerThread: " + this.f21222y + ", version: " + STBlurPreview.getVersion());
        if (-1 == this.f21210m) {
            this.f21210m = OpenGLUtils.m24588a(BitmapFactory.decodeFile("/odm/etc/camera/sensetime/singlut_portrait.png"));
            this.f21211n = OpenGLUtils.m24588a(BitmapFactory.decodeFile("/odm/etc/camera/sensetime/singlut_background.png"));
        }
        if (this.f21222y == null) {
            this.f21222y = new HandlerThread("BlurPreviewHandlerThread");
            this.f21222y.start();
            this.f21221x = new Handler(this.f21222y.getLooper()) { // from class: com.oplus.camera.ui.preview.PlatformImplementations.kt_3.COUIBaseListPopupWindow_8.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    CameraLog.m12959b("BlurTexturePreview", "mBlurPreviewHandler, handleMessage, msg: " + message.what);
                    int OplusGLSurfaceView_13 = message.what;
                    if (OplusGLSurfaceView_13 == 1) {
                        BlurTexturePreview.this.m22550q();
                        return;
                    }
                    if (OplusGLSurfaceView_13 != 2) {
                        if (OplusGLSurfaceView_13 != 3) {
                            return;
                        }
                        synchronized (BlurTexturePreview.this.f21206c) {
                            if (BlurTexturePreview.this.f21217t != null) {
                                BlurTexturePreview.this.f21217t.destroy();
                                BlurTexturePreview.this.f21217t = null;
                            }
                            BlurTexturePreview.this.f21218u = null;
                        }
                        CameraLog.m12954a("BlurTexturePreview", "mBlurPreviewHandler, handleMessage, MSG_DESTROY_BLUR_PREVIEW X");
                        return;
                    }
                    BlurTexturePreview.this.f21219v = false;
                    synchronized (BlurTexturePreview.this.f21206c) {
                        if (BlurTexturePreview.this.f21217t == null) {
                            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PORTRAIT_SINGLE_BLUR_MODEL)) {
                                BlurTexturePreview.this.f21217t = new STBlurPreview(BlurTexturePreview.this.f21546j, true, "/odm/etc/camera/singleblur/portrait_retention_model.bin");
                            } else {
                                BlurTexturePreview.this.f21217t = new STBlurPreview(BlurTexturePreview.this.f21546j, true);
                            }
                            BlurTexturePreview.this.f21217t.setRetentionOpen(BlurTexturePreview.this.f21215r);
                        }
                    }
                    BlurTexturePreview.this.f21219v = true;
                }
            };
        }
        if (!f21205b) {
            this.f21221x.sendEmptyMessage(1);
        }
        synchronized (this.f21206c) {
            if (this.f21217t == null) {
                this.f21221x.sendEmptyMessage(2);
            } else {
                this.f21219v = true;
            }
            this.f21218u = c3397aa;
            if (this.f21218u != null) {
                this.f21218u.m22355a(this);
            }
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: COUIBaseListPopupWindow_8 */
    public void mo22290e() {
        this.f21544h.m14132a(new Runnable() { // from class: com.oplus.camera.ui.preview.PlatformImplementations.kt_3.COUIBaseListPopupWindow_8.2
            @Override // java.lang.Runnable
            public void run() {
                CameraLog.m12954a("BlurTexturePreview", "destroyEngine");
                BlurTexturePreview.this.f21219v = false;
                synchronized (BlurTexturePreview.this.f21206c) {
                    if (BlurTexturePreview.this.f21217t != null) {
                        CameraLog.m12954a("BlurTexturePreview", "mBlurPreviewHandler, handleMessage, destroyRender");
                        BlurTexturePreview.this.f21217t.destroyRender();
                        GLES20Canvas.m14010i();
                        CameraLog.m12954a("BlurTexturePreview", "mBlurPreviewHandler, handleMessage, destroyRender X");
                    }
                }
                if (-1 != BlurTexturePreview.this.f21210m) {
                    OpenGLUtils.m24593a(BlurTexturePreview.this.f21210m);
                    OpenGLUtils.m24593a(BlurTexturePreview.this.f21211n);
                    BlurTexturePreview.this.f21210m = -1;
                    BlurTexturePreview.this.f21211n = -1;
                }
                if (BlurTexturePreview.this.f21221x != null) {
                    BlurTexturePreview.this.f21221x.removeCallbacksAndMessages(null);
                    if (BlurTexturePreview.this.f21222y != null && BlurTexturePreview.this.f21222y.isAlive()) {
                        BlurTexturePreview.this.f21221x.sendEmptyMessage(3);
                    }
                }
                if (BlurTexturePreview.this.f21222y != null) {
                    BlurTexturePreview.this.f21222y.quitSafely();
                    BlurTexturePreview.this.f21222y = null;
                }
            }
        });
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: COUIBaseListPopupWindow_12 */
    public RawTexture mo22291f() {
        return this.f21213p;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: COUIBaseListPopupWindow_11 */
    public RawTexture mo22292g() {
        return this.f21212o;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22532a(RawTexture c2768s) {
        this.f21212o = c2768s;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: OplusGLSurfaceView_13 */
    public void mo22294i() {
        CameraLog.m12954a("BlurTexturePreview", "newTextures");
        this.f21213p = new RawTexture(this.f21207d, this.f21208k, true);
        this.f21212o = new RawTexture(this.f21207d, this.f21208k, true);
        this.f21220w = true;
        synchronized (this.f21206c) {
            this.f21216s = true;
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22280a(GLCanvas interfaceC2757h) {
        RawTexture c2768s = this.f21213p;
        if (c2768s != null && !c2768s.m13943n()) {
            this.f21213p.m14193c(interfaceC2757h);
            CameraLog.m12954a("BlurTexturePreview", "prepareTextures, mInputBlurTexture.getId: " + this.f21213p.m13934e());
        }
        RawTexture c2768s2 = this.f21212o;
        if (c2768s2 == null || c2768s2.m13943n()) {
            return;
        }
        this.f21212o.m14193c(interfaceC2757h);
        CameraLog.m12954a("BlurTexturePreview", "prepareTextures, mOutputBlurTexture.getId: " + this.f21212o.m13934e());
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: OplusGLSurfaceView_15 */
    public void mo22295j() {
        CameraLog.m12954a("BlurTexturePreview", "recycleTextures");
        if (this.f21220w) {
            RawTexture c2768s = this.f21213p;
            if (c2768s != null) {
                c2768s.mo13944o();
                this.f21213p = null;
            }
            RawTexture c2768s2 = this.f21212o;
            if (c2768s2 != null) {
                c2768s2.mo13944o();
                this.f21212o = null;
            }
            this.f21220w = false;
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22278a(int OplusGLSurfaceView_13, int i2) {
        CameraLog.m12954a("BlurTexturePreview", "setSize, height: " + OplusGLSurfaceView_13 + ", width: " + i2);
        this.f21207d = i2;
        this.f21208k = OplusGLSurfaceView_13;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22427a(boolean z) {
        synchronized (this.f21206c) {
            this.f21214q = z;
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo22286b(int OplusGLSurfaceView_13) {
        this.f21209l = OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m22539a(int OplusGLSurfaceView_13, int i2, boolean z) {
        if (this.f21217t != null) {
            CameraLog.m12954a("BlurTexturePreview", "initSTBlur, width: " + OplusGLSurfaceView_13 + ", height: " + i2);
            this.f21217t.initRender(OplusGLSurfaceView_13, i2, z);
            GLES20Canvas.m14010i();
            CameraLog.m12954a("BlurTexturePreview", "initSTBlur, X");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q */
    public void m22550q() {
        if (f21205b) {
            return;
        }
        byte[] bArrDecodeBuffer = null;
        if (new File("/odm/etc/camera/singleblur/license_release.lic").exists()) {
            byte[] bArrM11168a = ModelStorage.m11168a("singleblur/license_release.lic");
            bArrDecodeBuffer = new byte[bArrM11168a.length + 1];
            System.arraycopy(bArrM11168a, 0, bArrDecodeBuffer, 0, bArrM11168a.length);
            bArrDecodeBuffer[bArrM11168a.length] = 0;
        } else if (new File("/odm/etc/camera/singleblur/license_release.license").exists()) {
            bArrDecodeBuffer = SecurityLicenseChecker.decodeBuffer(this.f21546j, ModelStorage.m11168a("singleblur/license_release.license"));
        }
        int iInitLicense = LicenseHelper.initLicense(bArrDecodeBuffer);
        if (iInitLicense != 0) {
            CameraLog.m12967f("BlurTexturePreview", "checkLicense failed, resultCode : " + iInitLicense);
            return;
        }
        f21205b = true;
        CameraLog.m12954a("BlurTexturePreview", "checkLicense success");
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreviewRequest.IntrinsicsJvm.kt_5
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo22412b(boolean z) {
        synchronized (this.f21206c) {
            if (this.f21215r != z) {
                this.f21215r = z;
                this.f21216s = true;
                if (this.f21217t != null) {
                    this.f21217t.setRetentionOpen(this.f21215r);
                }
            }
        }
    }
}
