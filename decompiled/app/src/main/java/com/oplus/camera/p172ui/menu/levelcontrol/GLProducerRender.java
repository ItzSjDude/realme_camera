package com.oplus.camera.p172ui.menu.levelcontrol;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLES20;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import co.polarr.renderer.FilterPackageUtil;
import co.polarr.renderer.PolarrRender;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.p146gl.GLES20Canvas;
import com.oplus.camera.p146gl.GLProducer;
import com.oplus.camera.p172ui.inverse.InverseAble;
import com.oplus.camera.p172ui.preview.p177a.FilterHelper;
import com.oplus.camera.p172ui.preview.p177a.FilterModel;
import com.oplus.camera.p172ui.preview.p177a.FilterTexturePreview;
import com.oplus.camera.util.OpenGLUtils;
import com.oplus.camera.util.Util;
import java.util.ArrayList;
import java.util.Iterator;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: GLProducerRender.java */
/* renamed from: com.oplus.camera.ui.menu.levelcontrol.OplusGLSurfaceView_15 */
/* loaded from: classes2.dex */
public abstract class GLProducerRender implements GLProducer.OplusGLSurfaceView_6, InverseAble {

    /* renamed from: G */
    private int[] f19801G;

    /* renamed from: PlatformImplementations.kt_3 */
    protected Context f19802a;

    /* renamed from: w */
    protected float f19824w;

    /* renamed from: x */
    protected float f19825x;

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected int f19803b = 0;

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected PlatformImplementations.kt_3 f19804c = null;

    /* renamed from: IntrinsicsJvm.kt_5 */
    protected BaseFilterMenuCanvas f19805d = null;

    /* renamed from: COUIBaseListPopupWindow_8 */
    protected boolean f19806e = false;

    /* renamed from: COUIBaseListPopupWindow_12 */
    protected float f19807f = 0.0f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    protected float f19808g = 0.0f;

    /* renamed from: COUIBaseListPopupWindow_10 */
    protected float f19809h = 0.0f;

    /* renamed from: OplusGLSurfaceView_13 */
    protected int f19810i = 0;

    /* renamed from: OplusGLSurfaceView_15 */
    protected int f19811j = 26;

    /* renamed from: OplusGLSurfaceView_5 */
    protected Interpolator f19812k = new PathInterpolator(0.0f, 0.1f, 0.1f, 1.0f);

    /* renamed from: OplusGLSurfaceView_14 */
    protected IntrinsicsJvm.kt_4 f19813l = null;

    /* renamed from: OplusGLSurfaceView_6 */
    protected WrapperTexture f19814m = null;

    /* renamed from: OplusGLSurfaceView_11 */
    protected WrapperTexture f19815n = null;

    /* renamed from: o */
    protected WrapperTexture f19816o = null;

    /* renamed from: p */
    protected GLModelParam f19817p = null;

    /* renamed from: q */
    protected boolean f19818q = false;

    /* renamed from: r */
    protected boolean f19819r = false;

    /* renamed from: s */
    protected boolean f19820s = false;

    /* renamed from: t */
    protected float[] f19821t = {0.0f, 0.0f, 0.0f, 0.0f};

    /* renamed from: u */
    protected int f19822u = 10;

    /* renamed from: v */
    protected ArrayList<WrapperTexture> f19823v = null;

    /* renamed from: y */
    protected int f19826y = -1;

    /* renamed from: z */
    protected int f19827z = -1;

    /* renamed from: A */
    protected int f19795A = -1;

    /* renamed from: B */
    protected int f19796B = -1;

    /* renamed from: C */
    protected int f19797C = -1;

    /* renamed from: D */
    protected int f19798D = -1;

    /* renamed from: E */
    protected boolean f19799E = true;

    /* renamed from: F */
    protected FilterTexturePreview.PlatformImplementations.kt_3 f19800F = FilterTexturePreview.PlatformImplementations.kt_3.Polarr;

    /* compiled from: GLProducerRender.java */
    /* renamed from: com.oplus.camera.ui.menu.levelcontrol.OplusGLSurfaceView_15$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo20827a();

        /* renamed from: PlatformImplementations.kt_3 */
        void mo20828a(GLProducerRender abstractC3285j);

        /* renamed from: IntrinsicsJvm.kt_4 */
        void mo20829b();
    }

    /* compiled from: GLProducerRender.java */
    /* renamed from: com.oplus.camera.ui.menu.levelcontrol.OplusGLSurfaceView_15$IntrinsicsJvm.kt_4 */
    public interface IntrinsicsJvm.kt_4 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo20825a(float COUIBaseListPopupWindow_12);

        /* renamed from: IntrinsicsJvm.kt_4 */
        void mo20826b(float COUIBaseListPopupWindow_12);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public abstract void mo20954a(GLModelParam c3284i, boolean z);

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo20963b(GLModelParam c3284i) {
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected abstract void mo20964b(GL10 gl10);

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20957a(boolean z) {
        this.f19799E = z;
    }

    public GLProducerRender(Context context) {
        this.f19802a = null;
        this.f19802a = context;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20949a(int OplusGLSurfaceView_13) {
        this.f19803b = OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20955a(PlatformImplementations.kt_3 aVar) {
        this.f19804c = aVar;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20956a(FilterTexturePreview.PlatformImplementations.kt_3 aVar) {
        this.f19800F = aVar;
        BaseFilterMenuCanvas abstractC3276a = this.f19805d;
        if (abstractC3276a != null) {
            abstractC3276a.m20791a(aVar);
        }
    }

    @Override // com.oplus.camera.p172ui.inverse.InverseAble
    public void setInverseColor(boolean z) {
        this.f19806e = z;
        PlatformImplementations.kt_3 aVar = this.f19804c;
        if (aVar != null) {
            aVar.mo20829b();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20948a(float COUIBaseListPopupWindow_12, float f2, int OplusGLSurfaceView_13, Interpolator interpolator, IntrinsicsJvm.kt_4 bVar) {
        int i2;
        this.f19807f = COUIBaseListPopupWindow_12;
        this.f19808g = COUIBaseListPopupWindow_12 + f2;
        this.f19809h = f2;
        CameraLog.m12954a("GLProducerRender", "startScrollAnim, mCurrPosition: " + this.f19807f + ", mToPosition: " + this.f19808g + ", mAnimDistance: " + this.f19809h);
        if (OplusGLSurfaceView_13 <= 0) {
            CameraLog.m12954a("GLProducerRender", "startScrollAnim, durationFrame must > 0!");
            OplusGLSurfaceView_13 = 1;
        } else {
            int i3 = this.f19810i;
            if (i3 > 0 && (i2 = this.f19811j) > i3) {
                OplusGLSurfaceView_13 = i2 - i3;
                this.f19810i = 0;
            }
        }
        this.f19811j = OplusGLSurfaceView_13;
        if (interpolator != null) {
            this.f19812k = interpolator;
        }
        if (bVar != null) {
            this.f19813l = bVar;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20946a() {
        this.f19809h = 0.0f;
        this.f19810i = 0;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public float m20960b() {
        return this.f19807f;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20953a(GLProducer c2762m) {
        if (c2762m != null) {
            c2762m.m14046a(new Runnable() { // from class: com.oplus.camera.ui.menu.levelcontrol.OplusGLSurfaceView_15.1
                @Override // java.lang.Runnable
                public void run() {
                    if (GLProducerRender.this.f19805d != null) {
                        GLProducerRender.this.f19805d.m20798c();
                    }
                    GLProducerRender.this.mo20973j();
                }
            });
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m20965c() {
        BaseFilterMenuCanvas abstractC3276a = this.f19805d;
        if (abstractC3276a != null) {
            abstractC3276a.m20800d();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m20962b(GLProducer c2762m) {
        if (c2762m != null) {
            c2762m.m14046a(new Runnable() { // from class: com.oplus.camera.ui.menu.levelcontrol.OplusGLSurfaceView_15.2
                @Override // java.lang.Runnable
                public void run() {
                    if (GLProducerRender.this.f19814m != null) {
                        PolarrRender.clearTextureHelper(GLProducerRender.this.f19814m.m21039c(), GLProducerRender.this.f19814m.m21041e(), GLProducerRender.this.f19814m.m21042f());
                        GLProducerRender.this.f19814m.m21037b();
                        GLProducerRender abstractC3285j = GLProducerRender.this;
                        abstractC3285j.f19814m = null;
                        abstractC3285j.f19816o.m21037b();
                        GLProducerRender.this.f19816o = null;
                    }
                }
            });
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public boolean m20967d() {
        BaseFilterMenuCanvas abstractC3276a = this.f19805d;
        if (abstractC3276a != null) {
            return abstractC3276a.m20803e();
        }
        return false;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m20968e() {
        BaseFilterMenuCanvas abstractC3276a = this.f19805d;
        if (abstractC3276a != null) {
            abstractC3276a.m20789a(this.f19802a);
            GLModelParam c3284i = this.f19817p;
            if (c3284i != null) {
                this.f19805d.m20796b(c3284i.m20930i(), this.f19817p.m20929h());
            }
        }
    }

    /* renamed from: OplusGLSurfaceView_5 */
    private void m20945k() {
        if (this.f19801G == null) {
            this.f19801G = new int[1];
            GLES20.glGenFramebuffers(1, this.f19801G, 0);
        }
        GLES20.glBindFramebuffer(36160, this.f19801G[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.f19814m.m21039c(), 0);
        float[] fArr = this.f19821t;
        GLES20.glClearColor(fArr[1], fArr[2], fArr[3], fArr[0]);
        GLES20.glClear(16384);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20Canvas.m14010i();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m20961b(int OplusGLSurfaceView_13) {
        GLModelParam c3284i = this.f19817p;
        if (c3284i == null || c3284i.m20926g() <= 0) {
            CameraLog.m12967f("GLProducerRender", "onDrawFrame, vertex not ready");
            return;
        }
        if (this.f19805d.m20803e() && this.f19814m != null) {
            if (this.f19820s && !this.f19818q) {
                m20945k();
                this.f19818q = this.f19805d.m20793a(OplusGLSurfaceView_13, this.f19814m.m21039c(), this.f19817p.m20896a(), this.f19807f);
            } else if (!this.f19820s) {
                if (Float.compare(this.f19809h, 0.0f) == 0 || !this.f19818q) {
                    m20945k();
                }
                this.f19818q = this.f19805d.m20793a(OplusGLSurfaceView_13, this.f19814m.m21039c(), this.f19817p.m20896a(), this.f19807f);
            }
            this.f19805d.mo20802e(this.f19814m.m21039c(), 0);
            return;
        }
        for (int i2 = 0; i2 < this.f19817p.m20926g(); i2++) {
            m20944a(OplusGLSurfaceView_13, i2, (int) this.f19817p.m20938q(), (int) this.f19817p.m20939r());
        }
        CameraLog.m12954a("GLProducerRender", "onDrawFrame, drawOesTexture.");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20950a(int OplusGLSurfaceView_13, int i2) {
        CameraLog.m12954a("GLProducerRender", "notifyPreviewSizeChanged, Size: " + OplusGLSurfaceView_13 + "x" + i2);
        GLModelParam c3284i = this.f19817p;
        if (c3284i == null || !c3284i.m20943v()) {
            return;
        }
        if (this.f19817p.m20929h() == OplusGLSurfaceView_13 && this.f19817p.m20930i() == i2) {
            return;
        }
        if (Math.abs((OplusGLSurfaceView_13 / i2) - (this.f19817p.m20929h() / this.f19817p.m20930i())) < 0.01d) {
            return;
        }
        this.f19817p.m20906b(OplusGLSurfaceView_13);
        this.f19817p.m20911c(i2);
        this.f19819r = true;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m20969f() {
        GLModelParam c3284i;
        if (this.f19819r && (c3284i = this.f19817p) != null && c3284i.m20943v()) {
            if (this.f19817p.m20929h() == this.f19817p.m20931j() && this.f19817p.m20930i() == this.f19817p.m20932k()) {
                return;
            }
            GLModelParam c3284i2 = this.f19817p;
            c3284i2.m20917d(c3284i2.m20929h());
            GLModelParam c3284i3 = this.f19817p;
            c3284i3.m20921e(c3284i3.m20930i());
            GLModelParam c3284i4 = this.f19817p;
            FilterHelper.m22607a(c3284i4, c3284i4.m20930i(), this.f19817p.m20929h());
            this.f19822u = 0;
            mo20954a(this.f19817p, true);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20958a(float[] fArr) {
        this.f19821t = fArr;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public int m20970g() {
        GLModelParam c3284i = this.f19817p;
        if (c3284i != null) {
            return c3284i.m20926g();
        }
        return 0;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public boolean m20971h() {
        GLModelParam c3284i = this.f19817p;
        if (c3284i != null) {
            return c3284i.m20943v();
        }
        return false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m20959a(GLModelParam c3284i) {
        GLModelParam c3284i2 = this.f19817p;
        return c3284i2 != null && c3284i2.m20903a(c3284i);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20952a(int OplusGLSurfaceView_13, String str) {
        GLModelParam c3284i = this.f19817p;
        if (c3284i == null || c3284i.m20896a() == null || OplusGLSurfaceView_13 >= this.f19817p.m20896a().size() || this.f19817p.m20896a().get(OplusGLSurfaceView_13) == null) {
            return;
        }
        this.f19817p.m20896a().get(OplusGLSurfaceView_13).filterId = str;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m20966c(int OplusGLSurfaceView_13) {
        GLModelParam c3284i = this.f19817p;
        if (c3284i == null || c3284i.m20896a() == null || OplusGLSurfaceView_13 >= this.f19817p.m20896a().size() || this.f19817p.m20896a().get(OplusGLSurfaceView_13) == null) {
            return;
        }
        FilterModel c3414k = this.f19817p.m20904b().get(OplusGLSurfaceView_13);
        FilterHelper.m22606a(this.f19817p.m20896a().get(OplusGLSurfaceView_13), c3414k.f21338b, this.f19817p.m20934m());
        c3414k.f21339c = false;
        mo20963b(this.f19817p);
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public void m20972i() {
        mo20963b(this.f19817p);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m20944a(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        Bitmap bitmapDecodeResource;
        Bitmap bitmapDecodeResource2;
        Bitmap bitmapDecodeResource3;
        Bitmap bitmapDecodeResource4;
        Bitmap bitmapDecodeResource5;
        Bitmap bitmapDecodeResource6;
        if (i2 == this.f19817p.m20895a("portrait_retention") || i2 == this.f19817p.m20895a("oplus_video_filter_portrait_retention")) {
            if (-1 == this.f19826y) {
                if (this.f19817p.m20934m()) {
                    bitmapDecodeResource = Util.m24218a(BitmapFactory.decodeResource(this.f19802a.getResources(), R.drawable.filter_retention));
                } else {
                    bitmapDecodeResource = BitmapFactory.decodeResource(this.f19802a.getResources(), R.drawable.filter_retention);
                }
                this.f19826y = OpenGLUtils.m24588a(FilterHelper.m22593a(bitmapDecodeResource, i3, i4));
            }
            this.f19805d.mo20801d(this.f19826y, i2 + 1);
            return;
        }
        if (i2 == this.f19817p.m20895a("portrait_streamer")) {
            if (-1 == this.f19795A) {
                if (this.f19817p.m20934m()) {
                    bitmapDecodeResource6 = Util.m24218a(BitmapFactory.decodeResource(this.f19802a.getResources(), R.drawable.icon_portrait_streamer));
                } else {
                    bitmapDecodeResource6 = BitmapFactory.decodeResource(this.f19802a.getResources(), R.drawable.icon_portrait_streamer);
                }
                this.f19795A = OpenGLUtils.m24588a(FilterHelper.m22593a(bitmapDecodeResource6, i3, i4));
            }
            this.f19805d.mo20801d(this.f19795A, i2 + 1);
            return;
        }
        if (i2 == this.f19817p.m20895a("neon-2020.cube.rgb.bin") || i2 == this.f19817p.m20895a("oplus_video_filter_neon")) {
            if (-1 == this.f19827z) {
                if (this.f19817p.m20934m()) {
                    bitmapDecodeResource2 = Util.m24218a(BitmapFactory.decodeResource(this.f19802a.getResources(), R.drawable.filter_portrait_neon));
                } else {
                    bitmapDecodeResource2 = BitmapFactory.decodeResource(this.f19802a.getResources(), R.drawable.filter_portrait_neon);
                }
                this.f19827z = OpenGLUtils.m24588a(FilterHelper.m22593a(bitmapDecodeResource2, i3, i4));
            }
            this.f19805d.mo20801d(this.f19827z, i2 + 1);
            return;
        }
        if (i2 == this.f19817p.m20895a(FilterPackageUtil.SKY_BLUE_2020)) {
            if (-1 == this.f19797C) {
                if (this.f19817p.m20934m()) {
                    bitmapDecodeResource5 = Util.m24218a(BitmapFactory.decodeResource(this.f19802a.getResources(), R.drawable.icon_filter_video_blue));
                } else {
                    bitmapDecodeResource5 = BitmapFactory.decodeResource(this.f19802a.getResources(), R.drawable.icon_filter_video_blue);
                }
                this.f19797C = OpenGLUtils.m24588a(FilterHelper.m22593a(bitmapDecodeResource5, i3, i4));
            }
            this.f19805d.mo20801d(this.f19797C, i2 + 1);
            return;
        }
        if (i2 == this.f19817p.m20895a(FilterPackageUtil.RED_RED_2020)) {
            if (-1 == this.f19796B) {
                if (this.f19817p.m20934m()) {
                    bitmapDecodeResource4 = Util.m24218a(BitmapFactory.decodeResource(this.f19802a.getResources(), R.drawable.icon_filter_video_red));
                } else {
                    bitmapDecodeResource4 = BitmapFactory.decodeResource(this.f19802a.getResources(), R.drawable.icon_filter_video_red);
                }
                this.f19796B = OpenGLUtils.m24588a(FilterHelper.m22593a(bitmapDecodeResource4, i3, i4));
            }
            this.f19805d.mo20801d(this.f19796B, i2 + 1);
            return;
        }
        if (i2 == this.f19817p.m20895a(FilterPackageUtil.TREE_GREEN_2020)) {
            if (-1 == this.f19798D) {
                if (this.f19817p.m20934m()) {
                    bitmapDecodeResource3 = Util.m24218a(BitmapFactory.decodeResource(this.f19802a.getResources(), R.drawable.icon_filter_video_green));
                } else {
                    bitmapDecodeResource3 = BitmapFactory.decodeResource(this.f19802a.getResources(), R.drawable.icon_filter_video_green);
                }
                this.f19798D = OpenGLUtils.m24588a(FilterHelper.m22593a(bitmapDecodeResource3, i3, i4));
            }
            this.f19805d.mo20801d(this.f19798D, i2 + 1);
            return;
        }
        this.f19805d.mo20804f(OplusGLSurfaceView_13, 0);
    }

    @Override // com.oplus.camera.p146gl.GLProducer.OplusGLSurfaceView_6
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo14097a(GL10 gl10) {
        GLModelParam c3284i = this.f19817p;
        if (c3284i == null || c3284i.m20926g() <= 0) {
            CameraLog.m12967f("GLProducerRender", "onDrawFrame, vertex not ready");
            return;
        }
        GLModelParam c3284i2 = this.f19817p;
        if (c3284i2 != null && c3284i2.m20943v() && this.f19822u < 10) {
            CameraLog.m12954a("GLProducerRender", "onDrawFrame, mDisableFrameNum: " + this.f19822u);
            this.f19822u = this.f19822u + 1;
            return;
        }
        GLES20Canvas.m14010i();
        float[] fArr = this.f19821t;
        GLES20.glClearColor(fArr[1], fArr[2], fArr[3], fArr[0]);
        GLES20.glClear(16640);
        mo20964b(gl10);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20951a(int OplusGLSurfaceView_13, Bitmap bitmap) {
        if (this.f19823v == null) {
            this.f19823v = new ArrayList<>();
        }
        Iterator<WrapperTexture> it = this.f19823v.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            WrapperTexture next = it.next();
            if (next.m21040d() == OplusGLSurfaceView_13) {
                next.m21037b();
                this.f19823v.remove(next);
                break;
            }
        }
        this.f19815n = new WrapperTexture(0);
        if (!this.f19815n.m21044h()) {
            this.f19815n.m21036a(bitmap);
        }
        this.f19823v.add(this.f19815n);
        CameraLog.m12954a("GLProducerRender", "createRingTexture, length: " + this.f19823v.size() + ", type: " + OplusGLSurfaceView_13);
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public void mo20973j() {
        CameraLog.m12954a("GLProducerRender", "releaseResource");
        WrapperTexture c3295t = this.f19814m;
        if (c3295t != null) {
            PolarrRender.clearTextureHelper(c3295t.m21039c(), this.f19814m.m21041e(), this.f19814m.m21042f());
            this.f19814m.m21037b();
            this.f19814m = null;
        }
        WrapperTexture c3295t2 = this.f19816o;
        if (c3295t2 != null) {
            c3295t2.m21037b();
            this.f19816o = null;
        }
        int OplusGLSurfaceView_13 = this.f19826y;
        if (-1 != OplusGLSurfaceView_13) {
            OpenGLUtils.m24593a(OplusGLSurfaceView_13);
            this.f19826y = -1;
        }
        int i2 = this.f19827z;
        if (-1 != i2) {
            OpenGLUtils.m24593a(i2);
            this.f19827z = -1;
        }
        int i3 = this.f19795A;
        if (-1 != i3) {
            OpenGLUtils.m24593a(i3);
            this.f19795A = -1;
        }
        int i4 = this.f19797C;
        if (-1 != i4) {
            OpenGLUtils.m24593a(i4);
            this.f19797C = -1;
        }
        int i5 = this.f19796B;
        if (-1 != i5) {
            OpenGLUtils.m24593a(i5);
            this.f19796B = -1;
        }
        int i6 = this.f19798D;
        if (-1 != i6) {
            OpenGLUtils.m24593a(i6);
            this.f19798D = -1;
        }
        int[] iArr = this.f19801G;
        if (iArr != null) {
            GLES20.glDeleteBuffers(1, iArr, 0);
            this.f19801G = null;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20947a(float COUIBaseListPopupWindow_12, float f2) {
        this.f19824w = COUIBaseListPopupWindow_12;
        this.f19825x = f2;
    }
}
