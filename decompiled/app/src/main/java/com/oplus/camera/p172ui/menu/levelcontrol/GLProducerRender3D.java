package com.oplus.camera.p172ui.menu.levelcontrol;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.view.animation.Interpolator;
import com.arcsoft.arcsoftjni.ArcSoftOffscreen;
import com.oplus.camera.CameraLog;
import com.oplus.camera.p146gl.GLES20Canvas;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: GLProducerRender3D.java */
/* renamed from: com.oplus.camera.ui.menu.levelcontrol.OplusGLSurfaceView_11 */
/* loaded from: classes2.dex */
public class GLProducerRender3D extends GLProducerRender {

    /* renamed from: G */
    private Ring f19834G;

    /* renamed from: H */
    private ArrayList<WrapperTexture> f19835H;

    /* renamed from: I */
    private WrapperTexture f19836I;

    /* renamed from: J */
    private boolean f19837J;

    /* renamed from: K */
    private boolean f19838K;

    public GLProducerRender3D(Context context) {
        super(context);
        this.f19834G = null;
        this.f19835H = null;
        this.f19836I = null;
        this.f19837J = false;
        this.f19838K = false;
    }

    @Override // com.oplus.camera.p146gl.GLProducer.OplusGLSurfaceView_6
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo14099a(GL10 gl10, EGLConfig eGLConfig) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        GLES20.glEnable(2929);
        GLES20.glEnable(2884);
        GLES20Canvas.m14010i();
        MatrixState.m21008a();
        this.f19804c.mo20827a();
        this.f19805d = new CylinderSide(this.f19802a);
        this.f19805d.m20791a(this.f19800F);
        this.f19834G = new Ring(this.f19802a);
        CameraLog.m12954a("GLProducerRender3D", "onSurfaceCreated, cost: " + (System.currentTimeMillis() - jCurrentTimeMillis));
    }

    @Override // com.oplus.camera.p146gl.GLProducer.OplusGLSurfaceView_6
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo14098a(GL10 gl10, int OplusGLSurfaceView_13, int i2) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        GLES20.glViewport(0, 0, OplusGLSurfaceView_13, i2);
        GLES20Canvas.m14010i();
        this.f19805d.m20787a(OplusGLSurfaceView_13, i2);
        MathUtil.m20993d(i2);
        if (this.f19817p != null) {
            m20979c(this.f19817p);
        } else {
            CameraLog.m12954a("GLProducerRender3D", "onSurfaceChanged, mGLModelParam has not init.");
        }
        MatrixState.m21012a(0.0f, 0.0f, 10.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f);
        MatrixState.m21016c(0.0f, 6.0f, 10.0f);
        this.f19837J = true;
        CameraLog.m12954a("GLProducerRender3D", "onSurfaceChanged, cost: " + (System.currentTimeMillis() - jCurrentTimeMillis));
    }

    @Override // com.oplus.camera.p172ui.menu.levelcontrol.GLProducerRender
    /* renamed from: IntrinsicsJvm.kt_4 */
    protected void mo20964b(GL10 gl10) {
        MatrixState.m21013b();
        MatrixState.m21009a(0.0f, 0.0f, -10.0f);
        GLES20Canvas.m14010i();
        MatrixState.m21013b();
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
                CameraLog.m12967f("GLProducerRender3D", "onDrawFrame, mScrollAnimListener == null !");
            }
            if ((Float.compare(this.f19809h, 0.0f) > 0 && Float.compare(interpolation2, this.f19809h) >= 0) || (Float.compare(this.f19809h, 0.0f) < 0 && Float.compare(interpolation2, this.f19809h) <= 0)) {
                this.f19807f = this.f19808g;
                this.f19809h = 0.0f;
                this.f19810i = 0;
                if (this.f19813l != null) {
                    this.f19813l.mo20826b(this.f19807f);
                } else {
                    CameraLog.m12967f("GLProducerRender3D", "onDrawFrame, mScrollAnimListener == null !");
                }
            }
        }
        MatrixState.m21008a();
        MatrixState.m21009a(this.f19807f / 100.0f, 0.0f, 0.0f);
        GLES20Canvas.m14010i();
        if (this.f19817p.m20943v()) {
            if (this.f19837J && this.f19814m != null) {
                this.f19804c.mo20828a(this);
            }
        } else if (this.f19835H != null) {
            for (int i2 = 0; i2 < this.f19835H.size(); i2++) {
                if (m20978a(i2, this.f19807f) && i2 < this.f19805d.m20794b()) {
                    GLES20Canvas.m14010i();
                    MatrixState.m21013b();
                    GLES20Canvas.m14010i();
                    MatrixState.m21009a(0.0f, ((-MathUtil.m21000i()) / 2.0f) * 1.0f, 0.0f);
                    this.f19805d.mo20799c(this.f19835H.get(i2).m21039c(), i2);
                    MatrixState.m21015c();
                    GLES20Canvas.m14010i();
                }
            }
        }
        MatrixState.m21015c();
        GLES20.glEnable(3042);
        GLES20.glBlendFunc(ArcSoftOffscreen.ASVL_PAF_RGB32_B8G8R8A8, 771);
        GLES20Canvas.m14010i();
        if (this.f19834G != null && this.f19823v != null && this.f19814m != null) {
            if (this.f19838K) {
                for (int i3 = 0; i3 < this.f19823v.size(); i3++) {
                    if (this.f19823v.get(i3).m21040d() == 0) {
                        this.f19823v.get(i3).m21038b(this.f19806e ? this.f19817p.m20923f() : this.f19817p.m20919e());
                    }
                }
                this.f19838K = false;
            }
            for (int i4 = 0; i4 < this.f19823v.size(); i4++) {
                if (this.f19823v.get(i4).m21039c() != -1) {
                    MatrixState.m21013b();
                    MatrixState.m21009a(0.0f, ((-MathUtil.m21000i()) / 2.0f) * 1.0f, 0.0f);
                    this.f19834G.m21024a(this.f19823v.get(i4).m21039c(), i4);
                    MatrixState.m21015c();
                } else {
                    CameraLog.m12967f("GLProducerRender3D", "onDrawFrame, mRingTexs[" + i4 + "] not init.");
                }
            }
        }
        MatrixState.m21015c();
        GLES20Canvas.m14010i();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m20978a(int OplusGLSurfaceView_13, float COUIBaseListPopupWindow_12) {
        float fM20982a = (((float) MathUtil.m20982a()) / 2.0f) + MathUtil.m20998g();
        float f2 = COUIBaseListPopupWindow_12 + fM20982a;
        float f3 = COUIBaseListPopupWindow_12 - fM20982a;
        float fM20980d = m20980d(OplusGLSurfaceView_13);
        return fM20980d >= f3 && fM20980d <= f2;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private float m20980d(int OplusGLSurfaceView_13) {
        return (-OplusGLSurfaceView_13) * MathUtil.m20998g();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m20979c(GLModelParam c3284i) {
        float COUIBaseListPopupWindow_12;
        float f2;
        float f3;
        CameraLog.m12954a("GLProducerRender3D", "updateElementsParam, glModelParam: " + c3284i.toString());
        MathUtil.m20995e(c3284i.m20937p());
        MathUtil.m20988b(c3284i.m20939r());
        MathUtil.m20991c(c3284i.m20940s());
        int OplusGLSurfaceView_13 = 0;
        if (this.f19834G != null && this.f19823v != null) {
            this.f19834G.m21022a();
            for (int i2 = 0; i2 < this.f19823v.size(); i2++) {
                if (this.f19823v.get(i2).m21040d() != 0) {
                    f2 = 0.0f;
                    f3 = 0.0f;
                    COUIBaseListPopupWindow_12 = 0.0f;
                } else {
                    float fM20984a = MathUtil.m20984a(c3284i.m20941t());
                    COUIBaseListPopupWindow_12 = (-fM20984a) / 2.0f;
                    f2 = fM20984a;
                    f3 = f2;
                }
                this.f19834G.m21023a(f2, f3, 10.0f, MathUtil.m21007p(), COUIBaseListPopupWindow_12);
            }
        }
        if (this.f19805d != null) {
            this.f19805d.m20782a();
            if (c3284i.m20943v()) {
                this.f19805d.mo20785a(1.0f, MathUtil.m20987b(), MathUtil.m21000i(), MathUtil.m21001j(), MathUtil.m20985a(0), (MathUtil.m20998g() * (c3284i.m20896a().size() - 1)) + MathUtil.m20994e(), false, c3284i);
                while (OplusGLSurfaceView_13 < c3284i.m20926g()) {
                    this.f19805d.mo20785a(1.0f, MathUtil.m20987b(), MathUtil.m21000i(), MathUtil.m21001j(), MathUtil.m20985a(OplusGLSurfaceView_13), MathUtil.m20994e(), true, c3284i);
                    OplusGLSurfaceView_13++;
                }
            } else {
                while (OplusGLSurfaceView_13 < c3284i.m20926g()) {
                    this.f19805d.mo20785a(1.0f, MathUtil.m20987b(), MathUtil.m21000i(), MathUtil.m21001j(), MathUtil.m20985a(OplusGLSurfaceView_13), MathUtil.m20994e(), false, c3284i);
                    OplusGLSurfaceView_13++;
                }
            }
        }
        MatrixState.m21011a(MathUtil.m21002k(), MathUtil.m21003l(), MathUtil.m21004m(), MathUtil.m21005n(), 10.0f, 100.0f);
        this.f19817p = c3284i;
    }

    @Override // com.oplus.camera.p172ui.menu.levelcontrol.GLProducerRender
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo20954a(GLModelParam c3284i, boolean z) {
        CameraLog.m12954a("GLProducerRender3D", "createTextures, glModelParam: " + c3284i.toString());
        this.f19819r = false;
        this.f19818q = false;
        this.f19803b = c3284i.m20933l();
        m20951a(0, this.f19806e ? c3284i.m20923f() : c3284i.m20919e());
        if (this.f19805d != null) {
            this.f19805d.m20783a(c3284i.m20942u());
        }
        if (c3284i.m20943v()) {
            int iWidth = c3284i.m20896a().get(0).rect.width();
            int OplusGLSurfaceView_13 = c3284i.m20896a().get(c3284i.m20896a().size() - 1).rect.bottom - c3284i.m20896a().get(0).rect.top;
            if (this.f19814m == null) {
                this.f19814m = new WrapperTexture(iWidth, OplusGLSurfaceView_13, -1);
                if (!this.f19814m.m21044h()) {
                    this.f19814m.m21035a();
                }
                if (this.f19837J) {
                    m20979c(c3284i);
                }
            } else {
                if (iWidth != this.f19814m.m21041e() || OplusGLSurfaceView_13 != this.f19814m.m21042f()) {
                    this.f19814m.m21037b();
                    this.f19814m = new WrapperTexture(iWidth, OplusGLSurfaceView_13, -1);
                    if (!this.f19814m.m21044h()) {
                        this.f19814m.m21035a();
                    }
                }
                if (z) {
                    m20979c(c3284i);
                }
            }
        } else {
            if (c3284i.m20915d() == null) {
                return;
            }
            if (this.f19835H == null) {
                m20981a(c3284i.m20915d());
                if (this.f19837J) {
                    m20979c(c3284i);
                }
            } else {
                m20981a(c3284i.m20915d());
                if (z) {
                    m20979c(c3284i);
                }
            }
        }
        if (this.f19805d != null) {
            this.f19805d.m20796b(c3284i.m20930i(), c3284i.m20929h());
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20981a(List<Bitmap> list) {
        CameraLog.m12954a("GLProducerRender3D", "createCylinderSideTexs, bitmaps: " + list);
        if (this.f19835H == null) {
            this.f19835H = new ArrayList<>();
        }
        if (this.f19835H.size() > 0) {
            Iterator<WrapperTexture> it = this.f19835H.iterator();
            while (it.hasNext()) {
                it.next().m21037b();
            }
            this.f19835H.clear();
        }
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < list.size(); OplusGLSurfaceView_13++) {
            WrapperTexture c3295t = new WrapperTexture();
            if (!c3295t.m21044h()) {
                c3295t.m21036a(list.get(OplusGLSurfaceView_13));
            }
            this.f19835H.add(c3295t);
        }
    }

    @Override // com.oplus.camera.p172ui.menu.levelcontrol.GLProducerRender
    /* renamed from: OplusGLSurfaceView_15 */
    public void mo20973j() {
        super.mo20973j();
        CameraLog.m12954a("GLProducerRender3D", "releaseResource");
        ArrayList<WrapperTexture> arrayList = this.f19835H;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<WrapperTexture> it = this.f19835H.iterator();
            while (it.hasNext()) {
                it.next().m21037b();
            }
            this.f19835H.clear();
            this.f19835H = null;
        }
        if (this.f19823v != null && this.f19823v.size() > 0) {
            Iterator<WrapperTexture> it2 = this.f19823v.iterator();
            while (it2.hasNext()) {
                it2.next().m21037b();
            }
            this.f19823v.clear();
            this.f19823v = null;
        }
        WrapperTexture c3295t = this.f19836I;
        if (c3295t != null) {
            c3295t.m21037b();
            this.f19836I = null;
        }
    }
}
