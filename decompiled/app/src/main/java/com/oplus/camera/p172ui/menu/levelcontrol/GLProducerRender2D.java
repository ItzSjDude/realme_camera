package com.oplus.camera.p172ui.menu.levelcontrol;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.opengl.GLES20;
import android.view.animation.Interpolator;
import com.arcsoft.arcsoftjni.ArcSoftOffscreen;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.p146gl.GLES20Canvas;
import com.oplus.camera.p172ui.preview.p177a.FilterHelper;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: GLProducerRender2D.java */
/* renamed from: com.oplus.camera.ui.menu.levelcontrol.OplusGLSurfaceView_5 */
/* loaded from: classes2.dex */
public abstract class GLProducerRender2D extends GLProducerRender {

    /* renamed from: G */
    protected int f19830G;

    /* renamed from: H */
    protected int f19831H;

    /* renamed from: I */
    private boolean f19832I;

    /* renamed from: J */
    private boolean f19833J;

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected abstract int mo20975c(GLModelParam c3284i);

    /* renamed from: IntrinsicsJvm.kt_5 */
    protected abstract int mo20976d(GLModelParam c3284i);

    /* renamed from: OplusGLSurfaceView_5 */
    protected abstract void mo20977k();

    public GLProducerRender2D(Context context, int OplusGLSurfaceView_13) {
        super(context);
        this.f19831H = 0;
        this.f19832I = false;
        this.f19833J = false;
        this.f19830G = OplusGLSurfaceView_13;
    }

    @Override // com.oplus.camera.p146gl.GLProducer.OplusGLSurfaceView_6
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo14099a(GL10 gl10, EGLConfig eGLConfig) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        GLES20.glDisable(2929);
        GLES20.glDisable(2884);
        GLES20Canvas.m14010i();
        MatrixState.m21008a();
        this.f19804c.mo20827a();
        this.f19805d = new FilterMenuCanvas2D(this.f19802a, this.f19830G);
        this.f19805d.m20791a(this.f19800F);
        CameraLog.m12954a("GLProducerRender2D", "onSurfaceCreated, cost: " + (System.currentTimeMillis() - jCurrentTimeMillis));
    }

    @Override // com.oplus.camera.p146gl.GLProducer.OplusGLSurfaceView_6
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo14098a(GL10 gl10, int OplusGLSurfaceView_13, int i2) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        GLES20.glViewport(0, 0, OplusGLSurfaceView_13, i2);
        GLES20Canvas.m14010i();
        this.f19805d.m20787a(OplusGLSurfaceView_13, i2);
        if (this.f19817p != null) {
            m20974e(this.f19817p);
        } else {
            CameraLog.m12954a("GLProducerRender2D", "onSurfaceChanged, mGLModelParam has not init.");
        }
        this.f19832I = true;
        CameraLog.m12954a("GLProducerRender2D", "onSurfaceChanged, cost: " + (System.currentTimeMillis() - jCurrentTimeMillis));
    }

    @Override // com.oplus.camera.p172ui.menu.levelcontrol.GLProducerRender
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo20964b(GL10 gl10) {
        if (Float.compare(this.f19809h, 0.0f) != 0) {
            float COUIBaseListPopupWindow_12 = this.f19809h;
            Interpolator interpolator = this.f19812k;
            int OplusGLSurfaceView_13 = this.f19810i;
            this.f19810i = OplusGLSurfaceView_13 + 1;
            float interpolation = COUIBaseListPopupWindow_12 * interpolator.getInterpolation(OplusGLSurfaceView_13 / this.f19811j);
            float interpolation2 = this.f19809h * this.f19812k.getInterpolation(this.f19810i / this.f19811j);
            this.f19807f += interpolation2 - interpolation;
            if (this.f19813l != null) {
                this.f19813l.mo20825a(this.f19807f);
            } else {
                CameraLog.m12967f("GLProducerRender2D", "onDrawFrame, mScrollAnimListener == null !");
            }
            if ((Float.compare(this.f19809h, 0.0f) > 0 && Float.compare(interpolation2, this.f19809h) >= 0) || (Float.compare(this.f19809h, 0.0f) < 0 && Float.compare(interpolation2, this.f19809h) <= 0)) {
                this.f19807f = this.f19808g;
                this.f19809h = 0.0f;
                this.f19810i = 0;
                if (this.f19813l != null) {
                    this.f19813l.mo20826b(this.f19807f);
                } else {
                    CameraLog.m12967f("GLProducerRender2D", "onDrawFrame, mScrollAnimListener == null !");
                }
            }
        }
        mo20977k();
        if (this.f19817p.m20943v() && this.f19832I && this.f19814m != null) {
            this.f19804c.mo20828a(this);
        }
        GLES20.glEnable(3042);
        GLES20.glBlendFunc(ArcSoftOffscreen.ASVL_PAF_RGB32_B8G8R8A8, 771);
        GLES20Canvas.m14010i();
    }

    @Override // com.oplus.camera.p172ui.menu.levelcontrol.GLProducerRender
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo20954a(GLModelParam c3284i, boolean z) {
        Bitmap bitmapM22618b;
        CameraLog.m12954a("GLProducerRender2D", "createTextures, glModelParam: " + c3284i.toString());
        this.f19819r = false;
        this.f19818q = false;
        this.f19820s = c3284i.m20914c();
        this.f19803b = c3284i.m20933l();
        if (this.f19805d != null) {
            this.f19805d.m20783a(c3284i.m20942u());
            this.f19805d.m20795b(c3284i.m20941t());
            this.f19805d.m20784a(this.f19824w, this.f19825x);
            this.f19805d.m20792a(Color.valueOf(this.f19802a.getColor(this.f19806e ? R.color.color_black_with_full_percent_transparency : R.color.camera_white)).getComponents());
        }
        if (c3284i.m20943v()) {
            int iMo20975c = mo20975c(c3284i);
            int iMo20976d = mo20976d(c3284i);
            CameraLog.m12954a("GLProducerRender2D", "createTextures, width: " + iMo20976d + ", height: " + iMo20975c);
            if (this.f19814m == null) {
                this.f19814m = new WrapperTexture(iMo20976d, iMo20975c, -1);
                if (!this.f19814m.m21044h()) {
                    this.f19814m.m21035a();
                }
                if (this.f19805d != null) {
                    this.f19805d.m20788a(iMo20976d, iMo20975c, this.f19831H, this.f19830G);
                }
                m20974e(c3284i);
            } else {
                if (iMo20976d != this.f19814m.m21041e() || iMo20975c != this.f19814m.m21042f()) {
                    this.f19814m.m21037b();
                    this.f19814m = new WrapperTexture(iMo20976d, iMo20975c, -1);
                    if (!this.f19814m.m21044h()) {
                        this.f19814m.m21035a();
                    }
                    if (this.f19805d != null) {
                        this.f19805d.m20788a(iMo20976d, iMo20975c, this.f19831H, this.f19830G);
                    }
                }
                if (z) {
                    m20974e(c3284i);
                }
            }
            if (this.f19816o == null) {
                this.f19816o = new WrapperTexture(iMo20976d, iMo20975c, -1);
                if (!this.f19816o.m21044h()) {
                    this.f19816o.m21035a();
                }
            } else if (iMo20976d != this.f19816o.m21041e() || iMo20975c != this.f19816o.m21042f()) {
                this.f19816o.m21037b();
                this.f19816o = new WrapperTexture(iMo20976d, iMo20975c, -1);
                if (!this.f19816o.m21044h()) {
                    this.f19816o.m21035a();
                }
            }
            if (iMo20976d < iMo20975c) {
                if (this.f19831H == 0) {
                    bitmapM22618b = FilterHelper.m22594a(c3284i, iMo20976d, iMo20975c, this.f19806e);
                } else {
                    bitmapM22618b = FilterHelper.m22595a(c3284i, iMo20976d, iMo20975c, this.f19806e, this.f19831H);
                }
            } else if (this.f19831H == 0) {
                bitmapM22618b = FilterHelper.m22617b(c3284i, iMo20976d, iMo20975c, this.f19806e);
            } else {
                bitmapM22618b = FilterHelper.m22618b(c3284i, iMo20976d, iMo20975c, this.f19806e, this.f19831H);
            }
            this.f19816o.m21038b(bitmapM22618b);
            bitmapM22618b.recycle();
        }
        if (this.f19805d != null) {
            this.f19805d.m20796b(c3284i.m20930i(), c3284i.m20929h());
            this.f19805d.m20786a(this.f19816o.m21039c());
        }
    }

    @Override // com.oplus.camera.p172ui.menu.levelcontrol.GLProducerRender
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo20963b(GLModelParam c3284i) {
        Bitmap bitmapM22618b;
        if (this.f19805d != null) {
            this.f19805d.m20792a(Color.valueOf(this.f19802a.getColor(this.f19806e ? R.color.color_black_with_full_percent_transparency : R.color.camera_white)).getComponents());
        }
        if (c3284i == null || !c3284i.m20943v() || this.f19805d == null) {
            return;
        }
        int iMo20975c = mo20975c(c3284i);
        int iMo20976d = mo20976d(c3284i);
        if (this.f19816o == null) {
            this.f19816o = new WrapperTexture(iMo20976d, iMo20975c, -1);
            if (!this.f19816o.m21044h()) {
                this.f19816o.m21035a();
            }
        } else if (iMo20976d != this.f19816o.m21041e() || iMo20975c != this.f19816o.m21042f()) {
            this.f19816o.m21037b();
            this.f19816o = new WrapperTexture(iMo20976d, iMo20975c, -1);
            if (!this.f19816o.m21044h()) {
                this.f19816o.m21035a();
            }
        }
        if (iMo20976d < iMo20975c) {
            if (this.f19831H == 0) {
                bitmapM22618b = FilterHelper.m22594a(c3284i, iMo20976d, iMo20975c, this.f19806e);
            } else {
                bitmapM22618b = FilterHelper.m22595a(c3284i, iMo20976d, iMo20975c, this.f19806e, this.f19831H);
            }
        } else if (this.f19831H == 0) {
            bitmapM22618b = FilterHelper.m22617b(c3284i, iMo20976d, iMo20975c, this.f19806e);
        } else {
            bitmapM22618b = FilterHelper.m22618b(c3284i, iMo20976d, iMo20975c, this.f19806e, this.f19831H);
        }
        this.f19816o.m21038b(bitmapM22618b);
        this.f19805d.m20786a(this.f19816o.m21039c());
        bitmapM22618b.recycle();
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m20974e(GLModelParam c3284i) {
        CameraLog.m12954a("GLProducerRender2D", "updateElementsParam, glModelParam: " + c3284i.toString());
        if (this.f19805d != null) {
            this.f19805d.m20782a();
            this.f19805d.mo20790a(c3284i);
        }
        this.f19817p = c3284i;
    }
}
