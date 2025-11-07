package com.oplus.camera.p172ui.preview.p177a.p179b;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.oplus.camera.CameraLog;
import com.oplus.camera.p146gl.RawTexture;
import com.oplus.camera.p146gl.GLCanvas;
import com.oplus.camera.p172ui.preview.p177a.TexturePreview;
import com.oplus.camera.p172ui.preview.p177a.TexturePreviewRequest;

/* compiled from: VideoWatermarkTexturePreview.java */
/* renamed from: com.oplus.camera.ui.preview.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public class VideoWatermarkTexturePreview extends TexturePreview {

    /* renamed from: PlatformImplementations.kt_3 */
    private RawTexture f21140a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private TexturePreviewRequest f21141b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private VideoWatermarkRenderer f21142c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private boolean f21143d;

    /* renamed from: OplusGLSurfaceView_5 */
    private int f21144k;

    /* renamed from: OplusGLSurfaceView_14 */
    private int f21145l;

    /* renamed from: OplusGLSurfaceView_6 */
    private int f21146m;

    /* renamed from: OplusGLSurfaceView_11 */
    private int f21147n;

    /* renamed from: o */
    private int f21148o;

    /* renamed from: p */
    private int f21149p;

    /* renamed from: q */
    private int f21150q;

    /* renamed from: r */
    private int[] f21151r;

    /* renamed from: s */
    private int[] f21152s;

    /* renamed from: t */
    private int[] f21153t;

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
        return 128;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: COUIBaseListPopupWindow_11 */
    public RawTexture mo22292g() {
        return null;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: COUIBaseListPopupWindow_10 */
    public boolean mo22293h() {
        return false;
    }

    public VideoWatermarkTexturePreview(Context context) {
        super(context);
        this.f21140a = null;
        this.f21141b = null;
        this.f21142c = null;
        this.f21143d = false;
        this.f21144k = 0;
        this.f21145l = 0;
        this.f21146m = 0;
        this.f21147n = 0;
        this.f21148o = 0;
        this.f21149p = 0;
        this.f21150q = 0;
        this.f21151r = new int[1];
        this.f21152s = new int[1];
        this.f21153t = new int[1];
        CameraLog.m12954a("VideoWatermarkTexturePreview", "VideoWatermarkTexturePreview");
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22281a(TexturePreviewRequest c3397aa) {
        CameraLog.m12954a("VideoWatermarkTexturePreview", "createEngine");
        this.f21141b = c3397aa;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: COUIBaseListPopupWindow_8 */
    public void mo22290e() {
        this.f21544h.m14132a(new Runnable() { // from class: com.oplus.camera.ui.preview.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.-$$Lambda$IntrinsicsJvm.kt_4$HYAW0lgcN-Rovh0j7hJcG-b1r6w
            @Override // java.lang.Runnable
            public final void run() {
                this.COUIBaseListPopupWindow_12$0.m22504q();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q */
    public /* synthetic */ void m22504q() {
        CameraLog.m12954a("VideoWatermarkTexturePreview", "destroyEngine");
        VideoWatermarkRenderer c3404a = this.f21142c;
        if (c3404a != null) {
            c3404a.m22502b();
            this.f21142c = null;
        }
        TexturePreviewRequest c3397aa = this.f21141b;
        if (c3397aa != null) {
            Bitmap bitmapM22405v = c3397aa.m22405v();
            CameraLog.m12954a("VideoWatermarkTexturePreview", "destroyEngine, watermarkBitmap: " + bitmapM22405v);
            if (bitmapM22405v != null && !bitmapM22405v.isRecycled()) {
                bitmapM22405v.recycle();
            }
        }
        this.f21141b = null;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: COUIBaseListPopupWindow_12 */
    public RawTexture mo22291f() {
        return this.f21140a;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: OplusGLSurfaceView_13 */
    public void mo22294i() {
        CameraLog.m12959b("VideoWatermarkTexturePreview", "newTextures, mPreviewTextureWidth: " + this.f21144k + ", mPreviewTextureHeight: " + this.f21145l);
        this.f21140a = new RawTexture(this.f21144k, this.f21145l, false);
        this.f21143d = true;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22280a(GLCanvas interfaceC2757h) {
        Bitmap bitmapM22405v;
        RawTexture c2768s = this.f21140a;
        if (c2768s != null && !c2768s.m13943n()) {
            this.f21140a.m14193c(interfaceC2757h);
            CameraLog.m12954a("VideoWatermarkTexturePreview", "prepareTextures, mInputTexture id_renamed: " + this.f21140a.m13934e());
        }
        TexturePreviewRequest c3397aa = this.f21141b;
        if (c3397aa != null && (bitmapM22405v = c3397aa.m22405v()) != null && !bitmapM22405v.isRecycled() && this.f21141b.m22332A()) {
            this.f21146m = bitmapM22405v.getWidth();
            this.f21147n = bitmapM22405v.getHeight();
            this.f21148o = this.f21141b.m22406w();
            this.f21149p = this.f21141b.m22407x();
            if (GLES20.glIsTexture(this.f21151r[0])) {
                GLES20.glDeleteTextures(1, this.f21151r, 0);
                this.f21151r[0] = 0;
            }
            GLES20.glGenTextures(1, this.f21151r, 0);
            GLES20.glBindTexture(3553, this.f21151r[0]);
            GLES20.glTexParameteri(3553, 10242, 33071);
            GLES20.glTexParameteri(3553, 10243, 33071);
            GLES20.glTexParameteri(3553, 10241, 9729);
            GLES20.glTexParameteri(3553, 10240, 9729);
            GLUtils.texImage2D(3553, 0, bitmapM22405v, 0);
            this.f21141b.m22392k(false);
            CameraLog.m12959b("VideoWatermarkTexturePreview", "prepareTextures, BitmapTexture: " + this.f21151r[0]);
        }
        int[] iArr = this.f21152s;
        if (iArr[0] == 0) {
            GLES20.glGenTextures(1, iArr, 0);
            int[] iArr2 = this.f21152s;
            if (iArr2[0] == 0) {
                throw new RuntimeException("Could not create PlatformImplementations.kt_3 new texture buffer object, glErrorString: " + GLES20.glGetString(GLES20.glGetError()));
            }
            GLES20.glBindTexture(3553, iArr2[0]);
            GLES20.glTexParameteri(3553, 10241, 9728);
            GLES20.glTexParameteri(3553, 10240, 9729);
            GLES20.glTexParameteri(3553, 10242, 33071);
            GLES20.glTexParameteri(3553, 10243, 33071);
            GLES20.glTexImage2D(3553, 0, 6408, this.f21144k, this.f21145l, 0, 6408, 5121, null);
            CameraLog.m12959b("VideoWatermarkTexturePreview", "prepareTextures, mOutTextures: " + this.f21152s[0]);
        }
        int[] iArr3 = this.f21153t;
        if (iArr3[0] == 0) {
            GLES20.glGenFramebuffers(1, iArr3, 0);
            if (this.f21153t[0] == 0) {
                throw new RuntimeException("Could not create PlatformImplementations.kt_3 new frame buffer object, glErrorString: " + GLES20.glGetString(GLES20.glGetError()));
            }
            CameraLog.m12959b("VideoWatermarkTexturePreview", "prepareTextures, mFBOs: " + this.f21153t[0]);
        }
        if (this.f21142c == null) {
            this.f21142c = new VideoWatermarkRenderer();
        }
        this.f21142c.m22500a();
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: OplusGLSurfaceView_15 */
    public void mo22295j() {
        if (this.f21140a != null) {
            CameraLog.m12954a("VideoWatermarkTexturePreview", "recycleTextures, mInputTexture id_renamed: " + this.f21140a.m13934e());
            this.f21140a.mo13944o();
            this.f21140a = null;
        }
        GLES20.glDeleteFramebuffers(1, this.f21153t, 0);
        GLES20.glDeleteTextures(1, this.f21151r, 0);
        GLES20.glDeleteTextures(1, this.f21152s, 0);
        this.f21153t[0] = 0;
        this.f21151r[0] = 0;
        this.f21152s[0] = 0;
        this.f21143d = false;
        TexturePreviewRequest c3397aa = this.f21141b;
        if (c3397aa != null) {
            Bitmap bitmapM22405v = c3397aa.m22405v();
            CameraLog.m12954a("VideoWatermarkTexturePreview", "recycleTextures, watermarkBitmap: " + bitmapM22405v);
            if (bitmapM22405v == null || bitmapM22405v.isRecycled()) {
                return;
            }
            bitmapM22405v.recycle();
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo22283a(int OplusGLSurfaceView_13) {
        if (!mo22673a_(OplusGLSurfaceView_13)) {
            return false;
        }
        if (!this.f21143d) {
            CameraLog.m12966e("VideoWatermarkTexturePreview", "canProcess, texture is not initialized");
            return false;
        }
        TexturePreviewRequest c3397aa = this.f21141b;
        if (c3397aa == null) {
            return false;
        }
        return c3397aa.m22408y();
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo22284a(TexturePreview.PlatformImplementations.kt_3 aVar) {
        if (aVar == null || aVar.f21549c == null) {
            CameraLog.m12954a("VideoWatermarkTexturePreview", "process, frameInfo: " + aVar);
            return false;
        }
        m22503a(this.f21152s, this.f21153t);
        GLES20.glClear(16640);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glViewport(0, 0, this.f21144k, this.f21145l);
        aVar.f21547a.mo13973a(aVar.f21549c, aVar.f21555i, aVar.f21558l, aVar.f21559m, aVar.f21556j, aVar.f21557k);
        GLES20.glEnable(3042);
        GLES20.glBlendFunc(1, 771);
        int OplusGLSurfaceView_13 = ((this.f21150q + aVar.f21561o) - 90) % 360;
        if (OplusGLSurfaceView_13 == 90) {
            int i2 = this.f21144k;
            int i3 = this.f21147n;
            GLES20.glViewport((i2 - i3) - this.f21149p, this.f21148o, i3, this.f21146m);
        } else if (OplusGLSurfaceView_13 == 180) {
            int i4 = this.f21144k;
            int i5 = this.f21146m;
            int i6 = (i4 - i5) - this.f21148o;
            int i7 = this.f21145l;
            int i8 = this.f21147n;
            GLES20.glViewport(i6, (i7 - i8) - this.f21149p, i5, i8);
        } else if (OplusGLSurfaceView_13 == 270) {
            int i9 = this.f21149p;
            int i10 = this.f21145l;
            int i11 = this.f21146m;
            GLES20.glViewport(i9, (i10 - i11) - this.f21148o, this.f21147n, i11);
        } else {
            GLES20.glViewport(this.f21148o, this.f21149p, this.f21146m, this.f21147n);
        }
        this.f21142c.m22501a(this.f21151r[0], false, OplusGLSurfaceView_13);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glViewport(0, 0, this.f21144k, this.f21145l);
        this.f21142c.m22501a(this.f21152s[0], true, OplusGLSurfaceView_13);
        GLES20.glDisable(3042);
        return true;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22278a(int OplusGLSurfaceView_13, int i2) {
        CameraLog.m12954a("VideoWatermarkTexturePreview", "setSize, width: " + i2 + ", height: " + OplusGLSurfaceView_13);
        this.f21144k = OplusGLSurfaceView_13;
        this.f21145l = i2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m22503a(int[] iArr, int[] iArr2) {
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < iArr2.length; OplusGLSurfaceView_13++) {
            GLES20.glBindFramebuffer(36160, iArr2[OplusGLSurfaceView_13]);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, iArr[OplusGLSurfaceView_13], 0);
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo22286b(int OplusGLSurfaceView_13) {
        TexturePreviewRequest c3397aa = this.f21141b;
        if (c3397aa == null || c3397aa.m22409z() || this.f21141b.m22405v() != null) {
            return;
        }
        CameraLog.m12959b("VideoWatermarkTexturePreview", "setOrientation, orientation: " + OplusGLSurfaceView_13);
        this.f21150q = OplusGLSurfaceView_13;
    }
}
