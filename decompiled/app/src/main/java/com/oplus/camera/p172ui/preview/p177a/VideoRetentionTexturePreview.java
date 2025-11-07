package com.oplus.camera.p172ui.preview.p177a;

import android.content.Context;
import com.oplus.camera.CameraLog;
import com.oplus.camera.algovisualization.AlgoListProcessor;
import com.oplus.camera.p146gl.GLES20Canvas;
import com.oplus.camera.p146gl.RawTexture;
import com.oplus.camera.p146gl.GLCanvas;
import com.oplus.camera.p172ui.preview.p177a.TexturePreview;
import com.oplus.ocs.camera.HumanVideoApiHelper;
import java.io.File;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: VideoRetentionTexturePreview.java */
/* renamed from: com.oplus.camera.ui.preview.PlatformImplementations.kt_3.ae */
/* loaded from: classes2.dex */
public class VideoRetentionTexturePreview extends TexturePreview {

    /* renamed from: PlatformImplementations.kt_3 */
    public static String f21072a = "0ms";

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f21073b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f21074c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f21075d;

    /* renamed from: OplusGLSurfaceView_5 */
    private boolean f21076k;

    /* renamed from: OplusGLSurfaceView_14 */
    private boolean f21077l;

    /* renamed from: OplusGLSurfaceView_6 */
    private boolean f21078m;

    /* renamed from: OplusGLSurfaceView_11 */
    private boolean f21079n;

    /* renamed from: o */
    private Context f21080o;

    /* renamed from: p */
    private RawTexture f21081p;

    /* renamed from: q */
    private RawTexture f21082q;

    /* renamed from: r */
    private HumanVideoApiHelper f21083r;

    /* renamed from: s */
    private TexturePreviewRequest f21084s;

    /* renamed from: t */
    private HumanVideoApiHelper.HumanVideoConfig f21085t;

    /* renamed from: u */
    private Lock f21086u;

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
    private int m22461a(int r4, boolean r5) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.p172ui.preview.p177a.VideoRetentionTexturePreview.m22461a(int, boolean):int");
    }

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
        return 256;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: COUIBaseListPopupWindow_10 */
    public boolean mo22293h() {
        return false;
    }

    public VideoRetentionTexturePreview(Context context) {
        super(context);
        this.f21073b = 0;
        this.f21074c = 0;
        this.f21075d = 0;
        this.f21076k = false;
        this.f21077l = false;
        this.f21078m = false;
        this.f21079n = false;
        this.f21080o = null;
        this.f21081p = null;
        this.f21082q = null;
        this.f21083r = null;
        this.f21084s = null;
        this.f21085t = null;
        this.f21086u = new ReentrantLock();
        this.f21080o = context;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo22283a(int OplusGLSurfaceView_13) {
        if (!mo22673a_(OplusGLSurfaceView_13)) {
            return false;
        }
        this.f21086u.lock();
        try {
            if (this.f21084s != null) {
                if (this.f21084s.m22386h()) {
                    this.f21086u.unlock();
                    if (this.f21077l) {
                        return true;
                    }
                    CameraLog.m12954a("VideoRetentionTexturePreview", "canProcess, texture is not init");
                    return false;
                }
            }
            return false;
        } finally {
            this.f21086u.unlock();
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo22284a(TexturePreview.PlatformImplementations.kt_3 aVar) {
        long jM11591a = AlgoListProcessor.m11591a();
        this.f21086u.lock();
        try {
            if (this.f21084s == null || aVar == null || aVar.f21549c == null || this.f21081p == null) {
                CameraLog.m12954a("VideoRetentionTexturePreview", "process, false");
            } else if (!this.f21076k) {
                CameraLog.m12954a("VideoRetentionTexturePreview", "process, not create, so return!");
            } else {
                this.f21086u.unlock();
                RawTexture c2768s = aVar.f21549c;
                int iM13937h = c2768s.m13937h();
                int iM13938i = c2768s.m13938i();
                boolean z = this.f21543g;
                this.f21086u.lock();
                try {
                    if (this.f21078m && !m22460B()) {
                        CameraLog.m12954a("VideoRetentionTexturePreview", "process, inTextureWidth: " + iM13938i + ", inTextureHeight: " + iM13937h);
                        m22467a(iM13938i, iM13937h, z);
                        this.f21078m = false;
                    }
                    int iM22463a = this.f21084s.m22386h() ? m22463a(c2768s.m13934e(), new int[]{this.f21081p.m13934e()}, z, m22461a(this.f21075d, z)) : -1;
                    this.f21079n = iM22463a == 0 || 4 == iM22463a;
                    f21072a = AlgoListProcessor.m11592a(jM11591a, AlgoListProcessor.m11591a());
                    return this.f21079n;
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
        return this.f21079n;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22281a(final TexturePreviewRequest c3397aa) {
        CameraLog.m12954a("VideoRetentionTexturePreview", "createEngine");
        this.f21544h.m14132a(new Runnable() { // from class: com.oplus.camera.ui.preview.PlatformImplementations.kt_3.ae.1
            @Override // java.lang.Runnable
            public void run() {
                VideoRetentionTexturePreview.this.f21086u.lock();
                try {
                    if (VideoRetentionTexturePreview.this.m22460B()) {
                        VideoRetentionTexturePreview.this.m22459A();
                    }
                    VideoRetentionTexturePreview.this.f21076k = true;
                    VideoRetentionTexturePreview.this.f21084s = c3397aa;
                    CameraLog.m12954a("VideoRetentionTexturePreview", "createEngine X");
                } finally {
                    VideoRetentionTexturePreview.this.f21086u.unlock();
                }
            }
        });
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: COUIBaseListPopupWindow_8 */
    public void mo22290e() {
        CameraLog.m12954a("VideoRetentionTexturePreview", "destroyEngine");
        this.f21544h.m14132a(new Runnable() { // from class: com.oplus.camera.ui.preview.PlatformImplementations.kt_3.ae.2
            @Override // java.lang.Runnable
            public void run() {
                VideoRetentionTexturePreview.this.f21086u.lock();
                try {
                    if (VideoRetentionTexturePreview.this.f21083r != null) {
                        VideoRetentionTexturePreview.this.f21544h.m14133g();
                        VideoRetentionTexturePreview.this.f21083r.release();
                        VideoRetentionTexturePreview.this.f21083r = null;
                    }
                    VideoRetentionTexturePreview.this.f21084s = null;
                    VideoRetentionTexturePreview.this.f21076k = false;
                    CameraLog.m12954a("VideoRetentionTexturePreview", "destroyEngine X");
                } finally {
                    VideoRetentionTexturePreview.this.f21086u.unlock();
                }
            }
        });
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: COUIBaseListPopupWindow_12 */
    public RawTexture mo22291f() {
        return this.f21082q;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: COUIBaseListPopupWindow_11 */
    public RawTexture mo22292g() {
        return this.f21081p;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: OplusGLSurfaceView_13 */
    public void mo22294i() {
        CameraLog.m12954a("VideoRetentionTexturePreview", "newTextures");
        this.f21082q = new RawTexture(this.f21073b, this.f21074c, true);
        this.f21081p = new RawTexture(this.f21073b, this.f21074c, true);
        this.f21077l = true;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22280a(GLCanvas interfaceC2757h) {
        RawTexture c2768s = this.f21082q;
        if (c2768s != null && !c2768s.m13943n()) {
            this.f21082q.m14193c(interfaceC2757h);
            CameraLog.m12954a("VideoRetentionTexturePreview", "prepareTextures, mInputTexture.getId: " + this.f21082q.m13934e());
        }
        RawTexture c2768s2 = this.f21081p;
        if (c2768s2 == null || c2768s2.m13943n()) {
            return;
        }
        this.f21081p.m14193c(interfaceC2757h);
        CameraLog.m12954a("VideoRetentionTexturePreview", "prepareTextures, mOutputTexture.getId: " + this.f21081p.m13934e());
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: OplusGLSurfaceView_15 */
    public void mo22295j() {
        CameraLog.m12954a("VideoRetentionTexturePreview", "recycleTextures");
        if (this.f21077l) {
            RawTexture c2768s = this.f21082q;
            if (c2768s != null) {
                c2768s.mo13944o();
                this.f21082q = null;
            }
            RawTexture c2768s2 = this.f21081p;
            if (c2768s2 != null) {
                c2768s2.mo13944o();
                this.f21081p = null;
            }
            this.f21077l = false;
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22278a(int OplusGLSurfaceView_13, int i2) {
        CameraLog.m12954a("VideoRetentionTexturePreview", "setSize, height: " + OplusGLSurfaceView_13 + ", width: " + i2);
        this.f21073b = i2;
        this.f21074c = OplusGLSurfaceView_13;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22427a(boolean z) {
        this.f21086u.lock();
        try {
            this.f21078m = z;
        } finally {
            this.f21086u.unlock();
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo22286b(int OplusGLSurfaceView_13) {
        this.f21075d = OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m22467a(int OplusGLSurfaceView_13, int i2, boolean z) {
        if (m22460B()) {
            return;
        }
        CameraLog.m12954a("VideoRetentionTexturePreview", "initVideoEffect, width: " + OplusGLSurfaceView_13 + ", height: " + i2 + ", isFrontCamera: " + z);
        if (this.f21085t == null) {
            this.f21085t = m22476r();
        }
        m22475q();
        this.f21083r.release();
        m22471b(z);
        GLES20Canvas.m14010i();
    }

    /* renamed from: q */
    private void m22475q() {
        HumanVideoApiHelper.getInstance().preInit();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m22463a(int OplusGLSurfaceView_13, int[] iArr, boolean z, int i2) {
        if (m22460B() || iArr == null) {
            return -1;
        }
        CameraLog.m12954a("VideoRetentionTexturePreview", "processVideoEffect, textureInput: " + OplusGLSurfaceView_13 + ", textureOutput[0]: " + iArr[0] + ", isFrontCamera: " + z + ", orientation: " + i2 + ", mWidth: " + this.f21073b + ", mHeight: " + this.f21074c);
        long jCurrentTimeMillis = System.currentTimeMillis();
        int iM22462a = m22462a(OplusGLSurfaceView_13, iArr, i2);
        GLES20Canvas.m14010i();
        StringBuilder sb = new StringBuilder();
        sb.append("processVideoEffect X, costTime: ");
        sb.append(System.currentTimeMillis() - jCurrentTimeMillis);
        CameraLog.m12954a("VideoRetentionTexturePreview", sb.toString());
        return iM22462a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m22468a(HumanVideoApiHelper.HumanProcessTextureRequest humanProcessTextureRequest, int OplusGLSurfaceView_13, int i2) {
        humanProcessTextureRequest.humanTexture.height = this.f21074c;
        humanProcessTextureRequest.humanTexture.width = this.f21073b;
        humanProcessTextureRequest.humanTexture.rotation = i2;
        humanProcessTextureRequest.humanTexture.texID = OplusGLSurfaceView_13;
        humanProcessTextureRequest.humanTexture.isOES = false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m22469a(HumanVideoApiHelper.HumanProcessTexureResult humanProcessTexureResult, int[] iArr, int OplusGLSurfaceView_13) {
        humanProcessTexureResult.humanTexture.texID = iArr[0];
        humanProcessTexureResult.humanTexture.rotation = OplusGLSurfaceView_13;
        humanProcessTexureResult.humanTexture.width = this.f21073b;
        humanProcessTexureResult.humanTexture.height = this.f21074c;
        humanProcessTexureResult.humanTexture.isOES = false;
    }

    /* renamed from: r */
    private HumanVideoApiHelper.HumanVideoConfig m22476r() {
        String str = this.f21080o.getApplicationContext().getCacheDir() + File.separator + "anc_cache";
        try {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
        HumanVideoApiHelper.HumanVideoConfig humanVideoConfig = new HumanVideoApiHelper.HumanVideoConfig();
        humanVideoConfig.sdkCapability = HumanVideoApiHelper.FeatureType.ANCHUM_FEATURE_RETAIN.getValue();
        humanVideoConfig.nativeLibPath = "/odm/lib64;/odm/lib/rfsa/adsp";
        humanVideoConfig.isRealTime = true;
        humanVideoConfig.cachePath = str;
        humanVideoConfig.modelPath = "odm/etc/camera/megvii/video_retention_model";
        return humanVideoConfig;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A */
    public void m22459A() {
        this.f21083r = HumanVideoApiHelper.getInstance();
        this.f21083r.setLogLevel(4);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m22462a(int OplusGLSurfaceView_13, int[] iArr, int i2) {
        HumanVideoApiHelper.HumanProcessTextureRequest humanProcessTextureRequest = new HumanVideoApiHelper.HumanProcessTextureRequest();
        HumanVideoApiHelper.HumanProcessTexureResult humanProcessTexureResult = new HumanVideoApiHelper.HumanProcessTexureResult();
        m22468a(humanProcessTextureRequest, OplusGLSurfaceView_13, i2);
        m22469a(humanProcessTexureResult, iArr, i2);
        int iProcess = this.f21083r.process(humanProcessTextureRequest, humanProcessTexureResult);
        CameraLog.m12954a("VideoRetentionTexturePreview", "processVideoEffect, processResult: " + iProcess);
        return iProcess;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m22471b(boolean z) {
        int iInitHandle = this.f21083r.initHandle(this.f21085t);
        this.f21083r.enableRuntimeFeature(HumanVideoApiHelper.FeatureType.ANCHUM_FEATURE_BOKEH, false);
        this.f21083r.enableRuntimeFeature(HumanVideoApiHelper.FeatureType.ANCHUM_FEATURE_RETAIN, true);
        HumanVideoApiHelper.HumanVideoRetainParams humanVideoRetainParams = new HumanVideoApiHelper.HumanVideoRetainParams();
        humanVideoRetainParams.bgPath = "odm/etc/camera/megvii/videolut_background.png";
        if (z) {
            humanVideoRetainParams.fgPath = "odm/etc/camera/megvii/videolut_portrait_front.png";
        } else {
            humanVideoRetainParams.fgPath = "odm/etc/camera/megvii/videolut_portrait.png";
        }
        CameraLog.m12954a("VideoRetentionTexturePreview", "initVideoLut  initResult:" + iInitHandle + " paraRet:" + this.f21083r.setParams(humanVideoRetainParams));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B */
    public boolean m22460B() {
        return this.f21083r == null;
    }
}
