package com.oplus.camera.p172ui.preview.p177a;

import android.content.Context;
import android.opengl.GLES20;
import com.oplus.camera.CameraLog;
import com.oplus.camera.p146gl.GLES20Canvas;
import com.oplus.camera.p146gl.RawTexture;
import com.oplus.camera.p146gl.GLCanvas;
import com.oplus.camera.p172ui.preview.p177a.TexturePreview;
import com.oplus.ocs.camera.HumanEffectRetainApiV2Helper;
import java.io.File;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: VideoRetentionV2TexturePreview.java */
/* renamed from: com.oplus.camera.ui.preview.PlatformImplementations.kt_3.af */
/* loaded from: classes2.dex */
public class VideoRetentionV2TexturePreview extends TexturePreview {

    /* renamed from: PlatformImplementations.kt_3 */
    private int f21090a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f21091b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f21092c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private boolean f21093d;

    /* renamed from: OplusGLSurfaceView_5 */
    private boolean f21094k;

    /* renamed from: OplusGLSurfaceView_14 */
    private boolean f21095l;

    /* renamed from: OplusGLSurfaceView_6 */
    private boolean f21096m;

    /* renamed from: OplusGLSurfaceView_11 */
    private RawTexture f21097n;

    /* renamed from: o */
    private RawTexture f21098o;

    /* renamed from: p */
    private HumanEffectRetainApiV2Helper f21099p;

    /* renamed from: q */
    private TexturePreviewRequest f21100q;

    /* renamed from: r */
    private HumanEffectRetainApiV2Helper.HumanVideoConfig f21101r;

    /* renamed from: s */
    private Lock f21102s;

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0015, code lost:
    
        if (r5 != false) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:?, code lost:
    
        return 270;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:?, code lost:
    
        return 90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x000f, code lost:
    
        if (r5 != false) goto L8;
     */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int m22479a(int r4, boolean r5) {
        /*
            r3 = this;
            r3 = 180(0xb4, float:2.52E-43)
            r0 = 0
            r1 = 270(0x10e, float:3.78E-43)
            r2 = 90
            if (r4 == 0) goto L15
            if (r4 == r2) goto L18
            if (r4 == r3) goto Lf
            r3 = r0
            goto L18
        Lf:
            if (r5 == 0) goto L13
        L11:
            r3 = r1
            goto L18
        L13:
            r3 = r2
            goto L18
        L15:
            if (r5 == 0) goto L11
            goto L13
        L18:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.p172ui.preview.p177a.VideoRetentionV2TexturePreview.m22479a(int, boolean):int");
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo22282a() {
        return false;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo22287c() {
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: IntrinsicsJvm.kt_5 */
    public int mo22289d() {
        return 256;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: COUIBaseListPopupWindow_10 */
    public boolean mo22293h() {
        return false;
    }

    public VideoRetentionV2TexturePreview(Context context) {
        super(context);
        this.f21090a = 0;
        this.f21091b = 0;
        this.f21092c = 0;
        this.f21093d = false;
        this.f21094k = false;
        this.f21095l = false;
        this.f21096m = false;
        this.f21097n = null;
        this.f21098o = null;
        this.f21099p = null;
        this.f21100q = null;
        this.f21101r = null;
        this.f21102s = new ReentrantLock();
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo22283a(int OplusGLSurfaceView_13) {
        if (!mo22673a_(OplusGLSurfaceView_13)) {
            return false;
        }
        this.f21102s.lock();
        try {
            if (this.f21100q != null) {
                if (this.f21100q.m22386h()) {
                    this.f21102s.unlock();
                    if (this.f21094k) {
                        return true;
                    }
                    CameraLog.m12954a("VideoRetentionV2TexturePreview", "canProcess, texture is not init");
                    return false;
                }
            }
            return false;
        } finally {
            this.f21102s.unlock();
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo22284a(TexturePreview.PlatformImplementations.kt_3 aVar) {
        this.f21102s.lock();
        try {
            if (this.f21100q == null || aVar == null || aVar.f21549c == null || this.f21097n == null) {
                CameraLog.m12954a("VideoRetentionV2TexturePreview", "process, false");
            } else if (!this.f21093d) {
                CameraLog.m12954a("VideoRetentionV2TexturePreview", "process, not create, so return!");
            } else {
                this.f21102s.unlock();
                RawTexture c2768s = aVar.f21549c;
                int iM13937h = c2768s.m13937h();
                int iM13938i = c2768s.m13938i();
                boolean z = this.f21543g;
                this.f21102s.lock();
                try {
                    if (this.f21095l && !m22478B()) {
                        CameraLog.m12954a("VideoRetentionV2TexturePreview", "process, inTextureWidth: " + iM13938i + ", inTextureHeight: " + iM13937h);
                        m22485a(iM13938i, iM13937h, z);
                        this.f21095l = false;
                    }
                    int iM22481a = this.f21100q.m22386h() ? m22481a(c2768s.m13934e(), new int[]{this.f21097n.m13934e()}, z, m22479a(this.f21092c, z)) : -1;
                    this.f21096m = iM22481a == 0 || 4 == iM22481a;
                    return this.f21096m;
                } finally {
                }
            }
            return false;
        } finally {
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: y */
    public boolean mo22428y() {
        return this.f21096m;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo22285b() {
        CameraLog.m12959b("VideoRetentionV2TexturePreview", "onDestroy");
        mo22290e();
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22281a(final TexturePreviewRequest c3397aa) {
        CameraLog.m12954a("VideoRetentionV2TexturePreview", "createEngine");
        this.f21544h.m14132a(new Runnable() { // from class: com.oplus.camera.ui.preview.PlatformImplementations.kt_3.af.1
            @Override // java.lang.Runnable
            public void run() {
                VideoRetentionV2TexturePreview.this.f21102s.lock();
                try {
                    if (VideoRetentionV2TexturePreview.this.m22478B()) {
                        VideoRetentionV2TexturePreview.this.m22477A();
                    }
                    VideoRetentionV2TexturePreview.this.f21093d = true;
                    VideoRetentionV2TexturePreview.this.f21100q = c3397aa;
                    CameraLog.m12954a("VideoRetentionV2TexturePreview", "createEngine X");
                } finally {
                    VideoRetentionV2TexturePreview.this.f21102s.unlock();
                }
            }
        });
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: COUIBaseListPopupWindow_8 */
    public void mo22290e() {
        CameraLog.m12954a("VideoRetentionV2TexturePreview", "destroyEngine, mHumanEffectApi: " + this.f21099p);
        this.f21544h.m14132a(new Runnable() { // from class: com.oplus.camera.ui.preview.PlatformImplementations.kt_3.af.2
            @Override // java.lang.Runnable
            public void run() {
                VideoRetentionV2TexturePreview.this.f21102s.lock();
                try {
                    if (VideoRetentionV2TexturePreview.this.f21099p != null) {
                        CameraLog.m12959b("VideoRetentionV2TexturePreview", "destroyEngine, mHumanEffectApi release");
                        VideoRetentionV2TexturePreview.this.f21544h.m14133g();
                        VideoRetentionV2TexturePreview.this.f21099p.release();
                        VideoRetentionV2TexturePreview.this.f21099p = null;
                    }
                    VideoRetentionV2TexturePreview.this.f21100q = null;
                    VideoRetentionV2TexturePreview.this.f21093d = false;
                    CameraLog.m12954a("VideoRetentionV2TexturePreview", "destroyEngine X");
                } finally {
                    VideoRetentionV2TexturePreview.this.f21102s.unlock();
                }
            }
        });
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: COUIBaseListPopupWindow_12 */
    public RawTexture mo22291f() {
        return this.f21098o;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: COUIBaseListPopupWindow_11 */
    public RawTexture mo22292g() {
        return this.f21097n;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: OplusGLSurfaceView_13 */
    public void mo22294i() {
        CameraLog.m12954a("VideoRetentionV2TexturePreview", "newTextures");
        this.f21098o = new RawTexture(this.f21090a, this.f21091b, true);
        this.f21097n = new RawTexture(this.f21090a, this.f21091b, true);
        this.f21094k = true;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22280a(GLCanvas interfaceC2757h) {
        RawTexture c2768s = this.f21098o;
        if (c2768s != null && !c2768s.m13943n()) {
            this.f21098o.m14193c(interfaceC2757h);
            CameraLog.m12954a("VideoRetentionV2TexturePreview", "prepareTextures, mInputTexture.getId: " + this.f21098o.m13934e());
        }
        RawTexture c2768s2 = this.f21097n;
        if (c2768s2 == null || c2768s2.m13943n()) {
            return;
        }
        this.f21097n.m14193c(interfaceC2757h);
        CameraLog.m12954a("VideoRetentionV2TexturePreview", "prepareTextures, mOutputTexture.getId: " + this.f21097n.m13934e());
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: OplusGLSurfaceView_15 */
    public void mo22295j() {
        CameraLog.m12954a("VideoRetentionV2TexturePreview", "recycleTextures");
        if (this.f21094k) {
            RawTexture c2768s = this.f21098o;
            if (c2768s != null) {
                c2768s.mo13944o();
                this.f21098o = null;
            }
            RawTexture c2768s2 = this.f21097n;
            if (c2768s2 != null) {
                c2768s2.mo13944o();
                this.f21097n = null;
            }
            this.f21094k = false;
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22278a(int OplusGLSurfaceView_13, int i2) {
        CameraLog.m12954a("VideoRetentionV2TexturePreview", "setSize, height: " + OplusGLSurfaceView_13 + ", width: " + i2);
        this.f21090a = i2;
        this.f21091b = OplusGLSurfaceView_13;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22427a(boolean z) {
        this.f21102s.lock();
        try {
            this.f21095l = z;
        } finally {
            this.f21102s.unlock();
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo22286b(int OplusGLSurfaceView_13) {
        this.f21092c = OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m22485a(int OplusGLSurfaceView_13, int i2, boolean z) {
        if (m22478B()) {
            return;
        }
        CameraLog.m12954a("VideoRetentionV2TexturePreview", "initVideoEffect, width: " + OplusGLSurfaceView_13 + ", height: " + i2 + ", isFrontCamera: " + z);
        if (this.f21101r == null) {
            this.f21101r = m22492r();
        }
        m22491q();
        this.f21099p.release();
        m22487b(z);
        GLES20Canvas.m14010i();
    }

    /* renamed from: q */
    private void m22491q() {
        HumanEffectRetainApiV2Helper.getInstance().preInit();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m22481a(int OplusGLSurfaceView_13, int[] iArr, boolean z, int i2) {
        if (m22478B() || iArr == null) {
            return -1;
        }
        CameraLog.m12954a("VideoRetentionV2TexturePreview", "processVideoEffect, textureInput: " + OplusGLSurfaceView_13 + ", textureOutput[0]: " + iArr[0] + ", isFrontCamera: " + z + ", orientation: " + i2 + ", mWidth: " + this.f21090a + ", mHeight: " + this.f21091b);
        int iM22480a = m22480a(OplusGLSurfaceView_13, iArr, i2);
        GLES20Canvas.m14010i();
        GLES20.glFinish();
        return iM22480a;
    }

    /* renamed from: r */
    private HumanEffectRetainApiV2Helper.HumanVideoConfig m22492r() {
        String str = this.f21546j.getApplicationContext().getCacheDir() + File.separator + "anc_cache";
        try {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
        HumanEffectRetainApiV2Helper.HumanVideoConfig humanVideoConfig = new HumanEffectRetainApiV2Helper.HumanVideoConfig();
        humanVideoConfig.nativeLibPath = "/odm/lib64;/odm/lib/rfsa/adsp";
        humanVideoConfig.isRealTime = true;
        humanVideoConfig.cachePath = str;
        humanVideoConfig.modelPath = "odm/etc/camera/megvii/video_retention_model";
        humanVideoConfig.sdkLoadType = HumanEffectRetainApiV2Helper.SdkLoadType.ANC_LOAD_TYPE_VNDKSUPPORT.ordinal();
        return humanVideoConfig;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A */
    public void m22477A() {
        this.f21099p = HumanEffectRetainApiV2Helper.getInstance();
        this.f21099p.setLogLevel(4);
        CameraLog.m12959b("VideoRetentionV2TexturePreview", "initVideoEffectPara, mHumanEffectApi: " + this.f21099p);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m22480a(int OplusGLSurfaceView_13, int[] iArr, int i2) {
        HumanEffectRetainApiV2Helper.HumanProcessTextureRequest humanProcessTextureRequestBuild = new HumanEffectRetainApiV2Helper.HumanProcessTextureRequestBuilder().setCameraType(this.f21543g ? HumanEffectRetainApiV2Helper.CameraType.CAMERA_TYPE_FRONT : HumanEffectRetainApiV2Helper.CameraType.CAMERA_TYPE_REAR).setHeight(this.f21091b).setWidth(this.f21090a).setRotation(i2).setOES(false).setTexID(OplusGLSurfaceView_13).build();
        HumanEffectRetainApiV2Helper.HumanProcessTexureResult humanProcessTexureResult = new HumanEffectRetainApiV2Helper.HumanProcessTexureResult(iArr[0], false, this.f21090a, this.f21091b, i2);
        int iProcess = this.f21099p.process(humanProcessTextureRequestBuild, humanProcessTexureResult);
        CameraLog.m12954a("VideoRetentionV2TexturePreview", "processEffect, request: " + humanProcessTextureRequestBuild + ", result: " + humanProcessTexureResult + ", processResult: " + iProcess);
        return iProcess;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m22487b(boolean z) {
        int iInitHandle = this.f21099p.initHandle(this.f21101r);
        CameraLog.m12959b("VideoRetentionV2TexturePreview", "initVideoRetentionV2, initResult: " + iInitHandle + ", paraRet: " + this.f21099p.setParams(new HumanEffectRetainApiV2Helper.HumanVideoRetainParams(z ? "odm/etc/camera/megvii/videolut_portrait_front.png" : "odm/etc/camera/megvii/videolut_portrait.png", "odm/etc/camera/megvii/videolut_background.png")) + ", sdk version: " + this.f21099p.getVersion());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B */
    public boolean m22478B() {
        return this.f21099p == null;
    }
}
