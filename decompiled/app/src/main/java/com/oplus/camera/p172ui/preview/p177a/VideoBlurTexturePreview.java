package com.oplus.camera.p172ui.preview.p177a;

import android.content.Context;
import android.graphics.Point;
import android.text.TextUtils;
import com.oplus.camera.CameraLog;
import com.oplus.camera.algovisualization.AlgoListProcessor;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.p146gl.GLES20Canvas;
import com.oplus.camera.p146gl.RawTexture;
import com.oplus.camera.p146gl.GLCanvas;
import com.oplus.camera.p172ui.preview.p177a.TexturePreview;
import com.oplus.camera.util.Util;
import com.oplus.ocs.camera.HumanEffectBokehHelper;
import java.io.File;

/* compiled from: VideoBlurTexturePreview.java */
/* renamed from: com.oplus.camera.ui.preview.PlatformImplementations.kt_3.ac */
/* loaded from: classes2.dex */
public class VideoBlurTexturePreview extends TexturePreview {

    /* renamed from: PlatformImplementations.kt_3 */
    public static String f21027a = "0ms";

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final Object f21028b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f21029c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f21030d;

    /* renamed from: OplusGLSurfaceView_5 */
    private int f21031k;

    /* renamed from: OplusGLSurfaceView_14 */
    private RawTexture f21032l;

    /* renamed from: OplusGLSurfaceView_6 */
    private RawTexture f21033m;

    /* renamed from: OplusGLSurfaceView_11 */
    private boolean f21034n;

    /* renamed from: o */
    private boolean f21035o;

    /* renamed from: p */
    private HumanEffectBokehHelper f21036p;

    /* renamed from: q */
    private TexturePreviewRequest f21037q;

    /* renamed from: r */
    private boolean f21038r;

    /* renamed from: PlatformImplementations.kt_3 */
    private int m22429a(int OplusGLSurfaceView_13, boolean z) {
        if (z) {
            if (OplusGLSurfaceView_13 != 0) {
                if (OplusGLSurfaceView_13 != 90) {
                    if (OplusGLSurfaceView_13 != 180) {
                        return 0;
                    }
                    return 270;
                }
                return 180;
            }
            return 90;
        }
        if (OplusGLSurfaceView_13 != 0) {
            if (OplusGLSurfaceView_13 != 90) {
                if (OplusGLSurfaceView_13 != 180) {
                    return 0;
                }
                return 90;
            }
            return 180;
        }
        return 270;
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
        return 32;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: COUIBaseListPopupWindow_10 */
    public boolean mo22293h() {
        return false;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: z */
    public int[] mo22437z() {
        return null;
    }

    public VideoBlurTexturePreview(Context context) {
        super(context);
        this.f21028b = new Object();
        this.f21029c = 0;
        this.f21030d = 0;
        this.f21031k = 0;
        this.f21032l = null;
        this.f21033m = null;
        this.f21034n = false;
        this.f21035o = false;
        this.f21036p = null;
        this.f21037q = null;
        this.f21038r = false;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo22283a(int OplusGLSurfaceView_13) {
        if (!mo22673a_(OplusGLSurfaceView_13)) {
            return false;
        }
        synchronized (this.f21028b) {
            if (this.f21037q == null) {
                return false;
            }
            if (!this.f21037q.m22366b()) {
                return false;
            }
            if (this.f21038r) {
                return true;
            }
            CameraLog.m12954a("VideoBlurTexturePreview", "canProcess, texture is not inited");
            return false;
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo22284a(TexturePreview.PlatformImplementations.kt_3 aVar) {
        boolean z;
        int iM22430a;
        long jM11591a = AlgoListProcessor.m11591a();
        if (this.f21037q == null || aVar == null || aVar.f21549c == null || this.f21032l == null) {
            CameraLog.m12954a("VideoBlurTexturePreview", "process, false");
            return false;
        }
        RawTexture c2768s = aVar.f21549c;
        int iM13937h = c2768s.m13937h();
        int iM13938i = c2768s.m13938i();
        boolean z2 = this.f21543g;
        synchronized (this.f21028b) {
            if (this.f21034n) {
                CameraLog.m12954a("VideoBlurTexturePreview", "process, inTextureWidth: " + iM13938i + ", inTextureHeight: " + iM13937h);
                m22435q();
                this.f21034n = false;
            }
            int iM22429a = m22429a(this.f21031k, z2);
            float fM22383g = this.f21037q.m22383g();
            int iM13934e = c2768s.m13934e();
            z = true;
            iM22430a = m22430a(iM13934e, new int[]{this.f21032l.m13934e()}, z2, fM22383g, iM22429a, this.f21037q.m22340I());
        }
        this.f21035o = iM22430a == 0;
        if (iM22430a != 0 && 4 != iM22430a && 5 != iM22430a && 6 != iM22430a) {
            z = false;
        }
        f21027a = AlgoListProcessor.m11592a(jM11591a, AlgoListProcessor.m11591a());
        return z;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: y */
    public boolean mo22428y() {
        return this.f21035o;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22281a(final TexturePreviewRequest c3397aa) {
        CameraLog.m12954a("VideoBlurTexturePreview", "createEngine");
        this.f21544h.m14132a(new Runnable() { // from class: com.oplus.camera.ui.preview.PlatformImplementations.kt_3.ac.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (VideoBlurTexturePreview.this.f21028b) {
                    VideoBlurTexturePreview.this.f21037q = c3397aa;
                    CameraLog.m12954a("VideoBlurTexturePreview", "createEngine X");
                }
            }
        });
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: COUIBaseListPopupWindow_8 */
    public void mo22290e() {
        CameraLog.m12954a("VideoBlurTexturePreview", "destroyEngine");
        this.f21544h.m14132a(new Runnable() { // from class: com.oplus.camera.ui.preview.PlatformImplementations.kt_3.ac.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (VideoBlurTexturePreview.this.f21028b) {
                    if (VideoBlurTexturePreview.this.f21036p != null) {
                        VideoBlurTexturePreview.this.f21544h.m14133g();
                        VideoBlurTexturePreview.this.f21036p.release();
                        VideoBlurTexturePreview.this.f21036p = null;
                    }
                    VideoBlurTexturePreview.this.f21037q = null;
                    CameraLog.m12954a("VideoBlurTexturePreview", "destroyEngine X");
                }
            }
        });
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: COUIBaseListPopupWindow_12 */
    public RawTexture mo22291f() {
        return this.f21033m;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: COUIBaseListPopupWindow_11 */
    public RawTexture mo22292g() {
        return this.f21032l;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: OplusGLSurfaceView_13 */
    public void mo22294i() {
        CameraLog.m12954a("VideoBlurTexturePreview", "newTextures");
        this.f21033m = new RawTexture(this.f21029c, this.f21030d, true);
        this.f21032l = new RawTexture(this.f21029c, this.f21030d, true);
        this.f21038r = true;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22280a(GLCanvas interfaceC2757h) {
        RawTexture c2768s = this.f21033m;
        if (c2768s != null && !c2768s.m13943n()) {
            this.f21033m.m14193c(interfaceC2757h);
            CameraLog.m12954a("VideoBlurTexturePreview", "prepareTextures, mInputBlurTexture.getId: " + this.f21033m.m13934e());
        }
        RawTexture c2768s2 = this.f21032l;
        if (c2768s2 == null || c2768s2.m13943n()) {
            return;
        }
        this.f21032l.m14193c(interfaceC2757h);
        CameraLog.m12954a("VideoBlurTexturePreview", "prepareTextures, mOutputBlurTexture.getId: " + this.f21032l.m13934e());
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: OplusGLSurfaceView_15 */
    public void mo22295j() {
        CameraLog.m12954a("VideoBlurTexturePreview", "recycleTextures");
        if (this.f21038r) {
            RawTexture c2768s = this.f21033m;
            if (c2768s != null) {
                c2768s.mo13944o();
                this.f21033m = null;
            }
            RawTexture c2768s2 = this.f21032l;
            if (c2768s2 != null) {
                c2768s2.mo13944o();
                this.f21032l = null;
            }
            this.f21038r = false;
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22278a(int OplusGLSurfaceView_13, int i2) {
        CameraLog.m12954a("VideoBlurTexturePreview", "setSize, height: " + OplusGLSurfaceView_13 + ", width: " + i2);
        this.f21029c = i2;
        this.f21030d = OplusGLSurfaceView_13;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22427a(boolean z) {
        synchronized (this.f21028b) {
            this.f21034n = z;
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo22286b(int OplusGLSurfaceView_13) {
        this.f21031k = OplusGLSurfaceView_13;
    }

    /* renamed from: q */
    private void m22435q() {
        if (m22436r()) {
            CameraLog.m12954a("VideoBlurTexturePreview", "initVideoBlur, start");
            String configStringValue = CameraConfig.getConfigStringValue(ConfigDataBase.KEY_VIDEO_BLUR_CACHE_PATH);
            String str = !TextUtils.isEmpty(configStringValue) ? configStringValue : this.f21546j.getApplicationContext().getCacheDir() + File.separator + "anc_cache";
            CameraLog.m12954a("VideoBlurTexturePreview", "initVideoBlur, path:" + str);
            try {
                File file = new File(str);
                if (!file.exists()) {
                    file.mkdirs();
                }
            } catch (Exception COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
            }
            this.f21036p = new HumanEffectBokehHelper(str, "odm/etc/camera/megvii/merged_model", "/odm/lib64;/odm/lib/rfsa/adsp", Util.m24169C(), CameraLog.m12957a() ? 4 : 0);
            GLES20Canvas.m14010i();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m22430a(int OplusGLSurfaceView_13, int[] iArr, boolean z, float COUIBaseListPopupWindow_12, int i2, Point point) {
        int iProcess;
        if (m22436r() || iArr == null) {
            return -1;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (point != null) {
            iProcess = this.f21036p.process(OplusGLSurfaceView_13, iArr[0], -1, null, null, COUIBaseListPopupWindow_12, i2, z ? 1 : 0, point.x, point.y, this.f21029c, this.f21030d);
        } else {
            iProcess = this.f21036p.process(OplusGLSurfaceView_13, iArr[0], -1, null, null, COUIBaseListPopupWindow_12, i2, z ? 1 : 0, 0.0f, 0.0f, this.f21029c, this.f21030d);
        }
        CameraLog.m12954a("VideoBlurTexturePreview", "processVideoBlur, result: " + iProcess + ", costTime: " + (System.currentTimeMillis() - jCurrentTimeMillis));
        GLES20Canvas.m14010i();
        return iProcess;
    }

    /* renamed from: r */
    private boolean m22436r() {
        return this.f21036p == null;
    }
}
