package com.oplus.camera.p172ui.menu.levelcontrol;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.TextureView;
import android.view.animation.Interpolator;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.p146gl.GLProducer;
import com.oplus.camera.p172ui.menu.levelcontrol.GLProducerRender;
import com.oplus.camera.p172ui.preview.p177a.FilterHelper;
import com.oplus.camera.p172ui.preview.p177a.FilterTexturePreview;
import com.oplus.camera.util.Util;

/* compiled from: BaseScrollBar.java */
/* renamed from: com.oplus.camera.ui.menu.levelcontrol.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public abstract class BaseScrollBar extends TextureView implements TextureView.SurfaceTextureListener {

    /* renamed from: PlatformImplementations.kt_3 */
    protected Handler f19597a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected GLProducer f19598b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected GLProducerRender f19599c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    protected PlatformImplementations.kt_3 f19600d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    protected boolean f19601e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    protected int f19602f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    protected final Interpolator f19603g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    protected int f19604h;

    /* renamed from: OplusGLSurfaceView_13 */
    protected int f19605i;

    /* renamed from: OplusGLSurfaceView_15 */
    protected float f19606j;

    /* renamed from: OplusGLSurfaceView_5 */
    protected float f19607k;

    /* renamed from: OplusGLSurfaceView_14 */
    protected float f19608l;

    /* renamed from: OplusGLSurfaceView_6 */
    protected float f19609m;

    /* renamed from: OplusGLSurfaceView_11 */
    protected float f19610n;

    /* renamed from: o */
    protected float f19611o;

    /* renamed from: p */
    protected float f19612p;

    /* renamed from: q */
    protected float f19613q;

    /* renamed from: r */
    protected boolean f19614r;

    /* renamed from: s */
    protected GLProducerRender.IntrinsicsJvm.kt_4 f19615s;

    /* renamed from: t */
    protected GLProducerRender.IntrinsicsJvm.kt_4 f19616t;

    /* renamed from: u */
    protected GLProducerRender.IntrinsicsJvm.kt_4 f19617u;

    /* renamed from: v */
    GLProducerRender.PlatformImplementations.kt_3 f19618v;

    /* renamed from: w */
    private int f19619w;

    /* renamed from: x */
    private boolean f19620x;

    /* renamed from: y */
    private boolean f19621y;

    /* compiled from: BaseScrollBar.java */
    /* renamed from: com.oplus.camera.ui.menu.levelcontrol.IntrinsicsJvm.kt_4$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo20830a();

        /* renamed from: PlatformImplementations.kt_3 */
        void mo20831a(int OplusGLSurfaceView_13, boolean z);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo20832a(GLProducerRender abstractC3285j);

        /* renamed from: PlatformImplementations.kt_3 */
        boolean mo20833a(int OplusGLSurfaceView_13);

        /* renamed from: IntrinsicsJvm.kt_4 */
        boolean mo20834b();

        /* renamed from: IntrinsicsJvm.kt_3 */
        int mo20835c();

        /* renamed from: IntrinsicsJvm.kt_5 */
        int mo20836d();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected abstract void mo20773a(float COUIBaseListPopupWindow_12);

    /* renamed from: PlatformImplementations.kt_3 */
    protected abstract void mo20774a(MotionEvent motionEvent);

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected abstract void mo20775b(float COUIBaseListPopupWindow_12);

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected abstract void mo20776b(MotionEvent motionEvent);

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected abstract int mo20777c(float COUIBaseListPopupWindow_12);

    /* renamed from: IntrinsicsJvm.kt_5 */
    protected abstract float mo20778d(int OplusGLSurfaceView_13);

    /* renamed from: OplusGLSurfaceView_14 */
    protected abstract void mo20779l();

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public BaseScrollBar(Context context) {
        this(context, null, 0);
    }

    public BaseScrollBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BaseScrollBar(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f19597a = null;
        this.f19598b = null;
        this.f19619w = 1;
        this.f19599c = null;
        this.f19600d = null;
        this.f19601e = false;
        this.f19620x = false;
        this.f19621y = false;
        this.f19602f = FilterHelper.f21279a;
        this.f19603g = new Interpolator() { // from class: com.oplus.camera.ui.menu.levelcontrol.IntrinsicsJvm.kt_4.1
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float COUIBaseListPopupWindow_12) {
                float f2 = COUIBaseListPopupWindow_12 - 1.0f;
                return (f2 * f2 * f2 * f2 * f2) + 1.0f;
            }
        };
        this.f19614r = false;
        this.f19615s = new GLProducerRender.IntrinsicsJvm.kt_4() { // from class: com.oplus.camera.ui.menu.levelcontrol.IntrinsicsJvm.kt_4.3
            @Override // com.oplus.camera.p172ui.menu.levelcontrol.GLProducerRender.IntrinsicsJvm.kt_4
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo20825a(final float COUIBaseListPopupWindow_12) {
                BaseScrollBar.this.f19597a.post(new Runnable() { // from class: com.oplus.camera.ui.menu.levelcontrol.IntrinsicsJvm.kt_4.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int iMo20777c = BaseScrollBar.this.mo20777c(COUIBaseListPopupWindow_12);
                        if (iMo20777c == BaseScrollBar.this.f19602f || FilterHelper.m22613a(iMo20777c, BaseScrollBar.this.f19599c.f19817p)) {
                            return;
                        }
                        BaseScrollBar.this.m20816c(iMo20777c);
                    }
                });
            }

            @Override // com.oplus.camera.p172ui.menu.levelcontrol.GLProducerRender.IntrinsicsJvm.kt_4
            /* renamed from: IntrinsicsJvm.kt_4 */
            public void mo20826b(final float COUIBaseListPopupWindow_12) {
                BaseScrollBar abstractTextureViewSurfaceTextureListenerC3277b = BaseScrollBar.this;
                abstractTextureViewSurfaceTextureListenerC3277b.f19601e = false;
                abstractTextureViewSurfaceTextureListenerC3277b.f19597a.post(new Runnable() { // from class: com.oplus.camera.ui.menu.levelcontrol.IntrinsicsJvm.kt_4.3.2
                    @Override // java.lang.Runnable
                    public void run() {
                        BaseScrollBar.this.f19598b.m14049b(0);
                        BaseScrollBar.this.m20816c(BaseScrollBar.this.mo20777c(COUIBaseListPopupWindow_12));
                        BaseScrollBar.this.setScrolling(false);
                    }
                });
            }
        };
        this.f19616t = new GLProducerRender.IntrinsicsJvm.kt_4() { // from class: com.oplus.camera.ui.menu.levelcontrol.IntrinsicsJvm.kt_4.4
            @Override // com.oplus.camera.p172ui.menu.levelcontrol.GLProducerRender.IntrinsicsJvm.kt_4
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo20825a(float COUIBaseListPopupWindow_12) {
            }

            @Override // com.oplus.camera.p172ui.menu.levelcontrol.GLProducerRender.IntrinsicsJvm.kt_4
            /* renamed from: IntrinsicsJvm.kt_4 */
            public void mo20826b(final float COUIBaseListPopupWindow_12) {
                BaseScrollBar abstractTextureViewSurfaceTextureListenerC3277b = BaseScrollBar.this;
                abstractTextureViewSurfaceTextureListenerC3277b.f19601e = false;
                abstractTextureViewSurfaceTextureListenerC3277b.f19597a.post(new Runnable() { // from class: com.oplus.camera.ui.menu.levelcontrol.IntrinsicsJvm.kt_4.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        BaseScrollBar.this.f19598b.m14049b(0);
                        BaseScrollBar.this.setScrolling(false);
                    }
                });
            }
        };
        this.f19617u = new GLProducerRender.IntrinsicsJvm.kt_4() { // from class: com.oplus.camera.ui.menu.levelcontrol.IntrinsicsJvm.kt_4.5
            @Override // com.oplus.camera.p172ui.menu.levelcontrol.GLProducerRender.IntrinsicsJvm.kt_4
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo20825a(final float COUIBaseListPopupWindow_12) {
                BaseScrollBar.this.f19597a.post(new Runnable() { // from class: com.oplus.camera.ui.menu.levelcontrol.IntrinsicsJvm.kt_4.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int iMo20777c = BaseScrollBar.this.mo20777c(COUIBaseListPopupWindow_12);
                        if (iMo20777c == BaseScrollBar.this.f19602f || FilterHelper.m22613a(iMo20777c, BaseScrollBar.this.f19599c.f19817p)) {
                            return;
                        }
                        BaseScrollBar.this.m20816c(iMo20777c);
                    }
                });
            }

            @Override // com.oplus.camera.p172ui.menu.levelcontrol.GLProducerRender.IntrinsicsJvm.kt_4
            /* renamed from: IntrinsicsJvm.kt_4 */
            public void mo20826b(final float COUIBaseListPopupWindow_12) {
                BaseScrollBar.this.f19597a.post(new Runnable() { // from class: com.oplus.camera.ui.menu.levelcontrol.IntrinsicsJvm.kt_4.5.2
                    @Override // java.lang.Runnable
                    public void run() {
                        BaseScrollBar.this.m20816c(BaseScrollBar.this.mo20777c(COUIBaseListPopupWindow_12));
                        BaseScrollBar.this.mo20779l();
                    }
                });
            }
        };
        this.f19618v = new GLProducerRender.PlatformImplementations.kt_3() { // from class: com.oplus.camera.ui.menu.levelcontrol.IntrinsicsJvm.kt_4.6
            @Override // com.oplus.camera.p172ui.menu.levelcontrol.GLProducerRender.PlatformImplementations.kt_3
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo20827a() {
                BaseScrollBar.this.f19600d.mo20830a();
            }

            @Override // com.oplus.camera.p172ui.menu.levelcontrol.GLProducerRender.PlatformImplementations.kt_3
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo20828a(GLProducerRender abstractC3285j) {
                BaseScrollBar.this.f19600d.mo20832a(abstractC3285j);
                if (BaseScrollBar.this.f19599c.m20967d()) {
                    return;
                }
                BaseScrollBar.this.f19598b.m14046a(new Runnable() { // from class: com.oplus.camera.ui.menu.levelcontrol.IntrinsicsJvm.kt_4.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        BaseScrollBar.this.f19599c.m20968e();
                    }
                });
            }

            @Override // com.oplus.camera.p172ui.menu.levelcontrol.GLProducerRender.PlatformImplementations.kt_3
            /* renamed from: IntrinsicsJvm.kt_4 */
            public void mo20829b() {
                BaseScrollBar.this.f19598b.m14046a(new Runnable() { // from class: com.oplus.camera.ui.menu.levelcontrol.IntrinsicsJvm.kt_4.6.2
                    @Override // java.lang.Runnable
                    public void run() {
                        BaseScrollBar.this.f19599c.m20972i();
                    }
                });
            }
        };
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BaseScrollBar, OplusGLSurfaceView_13, 0);
        this.f19604h = typedArrayObtainStyledAttributes.getInt(0, 0);
        this.f19605i = typedArrayObtainStyledAttributes.getInt(5, 0);
        this.f19606j = typedArrayObtainStyledAttributes.getDimensionPixelOffset(8, 0);
        this.f19607k = typedArrayObtainStyledAttributes.getDimensionPixelOffset(9, 0);
        this.f19608l = typedArrayObtainStyledAttributes.getDimensionPixelOffset(2, 0);
        this.f19609m = typedArrayObtainStyledAttributes.getDimensionPixelOffset(3, 0);
        this.f19610n = typedArrayObtainStyledAttributes.getDimensionPixelOffset(4, 0);
        this.f19611o = typedArrayObtainStyledAttributes.getDimensionPixelOffset(1, 0);
        this.f19612p = typedArrayObtainStyledAttributes.getDimensionPixelOffset(6, 0);
        this.f19613q = typedArrayObtainStyledAttributes.getDimensionPixelOffset(7, 0);
        typedArrayObtainStyledAttributes.recycle();
        setOpaque(false);
        setSurfaceTextureListener(this);
        this.f19597a = new Handler(Looper.myLooper());
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int OplusGLSurfaceView_13, int i2) {
        CameraLog.m12954a("BaseScrollBar", "onSurfaceTextureAvailable");
        this.f19598b = new GLProducer(surfaceTexture);
        if (this.f19619w == 1) {
            this.f19598b.m14047a(true);
        }
        this.f19598b.m14040a(2);
        this.f19598b.m14041a(8, 8, 8, 8, 16, 0);
        this.f19598b.m14045a(this.f19599c);
        this.f19598b.m14049b(0);
        this.f19598b.m14042a((SurfaceHolder) null);
        this.f19598b.m14043a(null, 0, OplusGLSurfaceView_13, i2);
        this.f19621y = true;
        m20814b(this.f19600d.mo20835c());
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int OplusGLSurfaceView_13, int i2) {
        CameraLog.m12954a("BaseScrollBar", "onSurfaceTextureSizeChanged");
        this.f19598b.m14043a(null, 0, OplusGLSurfaceView_13, i2);
        this.f19598b.m14052d();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        CameraLog.m12954a("BaseScrollBar", "onSurfaceTextureDestroyed");
        this.f19598b.m14050b((SurfaceHolder) null);
        this.f19598b.m14053e();
        return false;
    }

    public void setScrollBarTextureViewCallback(PlatformImplementations.kt_3 aVar) {
        this.f19600d = aVar;
    }

    public void setCameraEntryType(int OplusGLSurfaceView_13) {
        this.f19619w = OplusGLSurfaceView_13;
    }

    public void setFilterCategory(FilterTexturePreview.PlatformImplementations.kt_3 aVar) {
        this.f19599c.m20956a(aVar);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20805a() {
        GLProducerRender abstractC3285j;
        if (this.f19598b == null || (abstractC3285j = this.f19599c) == null || !abstractC3285j.m20971h() || m20818e()) {
            return;
        }
        this.f19598b.m14052d();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20808a(final int OplusGLSurfaceView_13, final int i2) {
        CameraLog.m12954a("BaseScrollBar", "notifyPreviewSizeChanged, Size: " + OplusGLSurfaceView_13 + " x " + i2);
        float[] fArr = {0.0f, 0.0f, 0.0f, 0.0f};
        if (Util.m24426d(i2, OplusGLSurfaceView_13) == 2) {
            fArr[0] = 0.0f;
        }
        GLProducerRender abstractC3285j = this.f19599c;
        if (abstractC3285j != null) {
            abstractC3285j.m20958a(fArr);
        }
        GLProducer c2762m = this.f19598b;
        if (c2762m != null) {
            c2762m.m14046a(new Runnable() { // from class: com.oplus.camera.ui.menu.levelcontrol.IntrinsicsJvm.kt_4.7
                @Override // java.lang.Runnable
                public void run() {
                    BaseScrollBar.this.f19599c.m20950a(OplusGLSurfaceView_13, i2);
                }
            });
            this.f19598b.m14052d();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m20813b() {
        this.f19614r = false;
        GLProducer c2762m = this.f19598b;
        if (c2762m != null) {
            c2762m.m14055g();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m20815c() {
        this.f19614r = true;
        GLProducer c2762m = this.f19598b;
        if (c2762m != null) {
            GLProducerRender abstractC3285j = this.f19599c;
            if (abstractC3285j != null) {
                abstractC3285j.m20953a(c2762m);
            }
            this.f19598b.m14054f();
            this.f19598b.m14056h();
        }
        this.f19601e = false;
        setScrolling(false);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m20817d() {
        GLProducerRender abstractC3285j;
        GLProducer c2762m = this.f19598b;
        if (c2762m == null || (abstractC3285j = this.f19599c) == null) {
            return;
        }
        abstractC3285j.m20962b(c2762m);
    }

    public void setScrolling(boolean z) {
        CameraLog.m12954a("BaseScrollBar", "setScrolling, isScrolling: " + this.f19620x + " -> " + z);
        this.f19620x = z;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public boolean m20818e() {
        return this.f19620x;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20811a(final GLModelParam c3284i) {
        CameraLog.m12954a("BaseScrollBar", "createTextures, mGLProducer: " + this.f19598b);
        GLProducer c2762m = this.f19598b;
        if (c2762m != null) {
            c2762m.m14046a(new Runnable() { // from class: com.oplus.camera.ui.menu.levelcontrol.IntrinsicsJvm.kt_4.8
                @Override // java.lang.Runnable
                public void run() {
                    BaseScrollBar.this.f19599c.m20947a(BaseScrollBar.this.f19612p, BaseScrollBar.this.f19613q);
                    BaseScrollBar.this.f19599c.mo20954a(c3284i, !BaseScrollBar.this.f19599c.m20959a(c3284i));
                    BaseScrollBar.this.f19599c.m20965c();
                    BaseScrollBar.this.m20814b(c3284i.m20933l());
                }
            });
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20809a(int OplusGLSurfaceView_13, String str) {
        if (this.f19598b != null) {
            this.f19599c.m20952a(OplusGLSurfaceView_13, str);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20807a(final int OplusGLSurfaceView_13) {
        GLProducer c2762m = this.f19598b;
        if (c2762m != null) {
            c2762m.m14046a(new Runnable() { // from class: com.oplus.camera.ui.menu.levelcontrol.IntrinsicsJvm.kt_4.9
                @Override // java.lang.Runnable
                public void run() {
                    BaseScrollBar.this.f19599c.m20966c(OplusGLSurfaceView_13);
                    BaseScrollBar.this.f19598b.m14052d();
                }
            });
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m20814b(int OplusGLSurfaceView_13) {
        this.f19602f = OplusGLSurfaceView_13;
        m20823j();
        m20806a(mo20778d(OplusGLSurfaceView_13), false);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected void m20816c(int OplusGLSurfaceView_13) {
        m20810a(OplusGLSurfaceView_13, true);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected void m20810a(int OplusGLSurfaceView_13, boolean z) {
        CameraLog.m12954a("BaseScrollBar", "onItemChanged, index: " + this.f19602f + " -> " + OplusGLSurfaceView_13 + ", hasTexturesInited: " + m20824k() + ", isFromSlide: " + z);
        if (OplusGLSurfaceView_13 == this.f19602f || !m20824k()) {
            return;
        }
        this.f19599c.m20949a(OplusGLSurfaceView_13);
        this.f19600d.mo20831a(OplusGLSurfaceView_13, z);
        this.f19602f = OplusGLSurfaceView_13;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m20819f() {
        this.f19601e = false;
        if (!m20824k()) {
            CameraLog.m12967f("BaseScrollBar", "slideToNextItem, texture not init, so return");
            return;
        }
        if (this.f19602f >= getModelNum() - 1) {
            return;
        }
        int OplusGLSurfaceView_13 = this.f19602f + 1;
        CameraLog.m12954a("BaseScrollBar", "slideToNextItem, index: " + this.f19602f + " -> " + OplusGLSurfaceView_13);
        m20823j();
        m20812a(mo20778d(OplusGLSurfaceView_13), 26, this.f19603g, this.f19615s);
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m20820g() {
        this.f19601e = false;
        if (!m20824k()) {
            CameraLog.m12967f("BaseScrollBar", "slideToPreviousItem, texture not init, so return");
            return;
        }
        if (this.f19602f <= this.f19600d.mo20836d()) {
            return;
        }
        int OplusGLSurfaceView_13 = this.f19602f - 1;
        CameraLog.m12954a("BaseScrollBar", "slideToPreviousItem, index: " + this.f19602f + " -> " + OplusGLSurfaceView_13);
        m20823j();
        m20812a(mo20778d(OplusGLSurfaceView_13), 26, this.f19603g, this.f19615s);
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public void m20821h() {
        this.f19601e = false;
        float fMo20778d = mo20778d(mo20777c(getCurrPosition()));
        if (Float.compare(fMo20778d, getCurrPosition()) != 0) {
            CameraLog.m12954a("BaseScrollBar", "forceScrollNearWithNoAnim, position: " + getCurrPosition() + " -> " + fMo20778d);
            m20823j();
            m20806a(fMo20778d, true);
        }
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public void m20822i() {
        if (this.f19621y) {
            this.f19598b.m14046a(new Runnable() { // from class: com.oplus.camera.ui.menu.levelcontrol.IntrinsicsJvm.kt_4.10
                @Override // java.lang.Runnable
                public void run() {
                    if (BaseScrollBar.this.f19599c == null || !BaseScrollBar.this.f19599c.m20967d()) {
                        return;
                    }
                    BaseScrollBar.this.f19599c.m20947a(BaseScrollBar.this.f19612p, BaseScrollBar.this.f19613q);
                    BaseScrollBar.this.f19599c.m20969f();
                }
            });
        } else {
            CameraLog.m12967f("BaseScrollBar", "notifyGLModelParam, GLProducer has not been init.");
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected boolean m20812a(float COUIBaseListPopupWindow_12, int OplusGLSurfaceView_13, Interpolator interpolator, GLProducerRender.IntrinsicsJvm.kt_4 bVar) {
        float currPosition = COUIBaseListPopupWindow_12 - getCurrPosition();
        if (!this.f19614r && this.f19599c != null && Float.compare(currPosition, 0.0f) != 0) {
            setScrolling(true);
            this.f19599c.m20948a(getCurrPosition(), currPosition, OplusGLSurfaceView_13, interpolator, bVar);
            this.f19598b.m14049b(1);
            ((Activity) getContext()).runOnUiThread(new Runnable() { // from class: com.oplus.camera.ui.menu.levelcontrol.IntrinsicsJvm.kt_4.2
                @Override // java.lang.Runnable
                public void run() {
                    if (BaseScrollBar.this.f19598b != null) {
                        BaseScrollBar.this.f19598b.m14048b();
                    }
                }
            });
            return true;
        }
        this.f19601e = false;
        return false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected void m20806a(float COUIBaseListPopupWindow_12, boolean z) {
        CameraLog.m12954a("BaseScrollBar", "moveToPosition, position: " + getCurrPosition() + " -> " + COUIBaseListPopupWindow_12);
        GLProducerRender abstractC3285j = this.f19599c;
        if (abstractC3285j != null) {
            abstractC3285j.m20948a(COUIBaseListPopupWindow_12, 0.0f, 0, null, null);
            GLProducer c2762m = this.f19598b;
            if (c2762m != null) {
                c2762m.m14052d();
            }
            if (z) {
                m20816c(mo20777c(COUIBaseListPopupWindow_12));
            }
        }
    }

    /* renamed from: OplusGLSurfaceView_15 */
    protected void m20823j() {
        CameraLog.m12954a("BaseScrollBar", "cancelScrollAnim");
        Handler handler = this.f19597a;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.f19601e = false;
        setScrolling(false);
        GLProducer c2762m = this.f19598b;
        if (c2762m != null) {
            c2762m.m14049b(0);
        }
        GLProducerRender abstractC3285j = this.f19599c;
        if (abstractC3285j != null) {
            abstractC3285j.m20946a();
        }
    }

    /* renamed from: OplusGLSurfaceView_5 */
    protected boolean m20824k() {
        return getModelNum() > 0;
    }

    protected int getModelNum() {
        GLProducerRender abstractC3285j = this.f19599c;
        if (abstractC3285j != null) {
            return abstractC3285j.m20970g();
        }
        return 0;
    }

    protected float getCurrPosition() {
        GLProducerRender abstractC3285j = this.f19599c;
        if (abstractC3285j != null) {
            return abstractC3285j.m20960b();
        }
        return 0.0f;
    }

    protected float getElementWidth() {
        return FilterHelper.m22572A();
    }

    protected float getElementHeight() {
        return FilterHelper.m22573B();
    }

    protected float getElementGap() {
        return FilterHelper.m22574C();
    }

    protected float getElementImageSize() {
        return FilterHelper.m22652z();
    }
}
