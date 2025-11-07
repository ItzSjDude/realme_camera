package com.oplus.camera.screen.out;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.opengl.GLES20;
import android.util.Size;
import android.view.animation.PathInterpolator;
import com.oplus.camera.R;
import com.oplus.camera.jni.PreviewShow;
import com.oplus.camera.p146gl.p147a.GLImageProcessor;
import com.oplus.camera.p146gl.p147a.GLImageScaleCircularGaussProcessor;
import com.oplus.camera.util.OpenGLUtils;
import java.nio.FloatBuffer;

/* compiled from: OesDrawer.java */
/* renamed from: com.oplus.camera.screen.out.IntrinsicsJvm.kt_5 */
/* loaded from: classes2.dex */
public class OesDrawer extends GLES20Drawer {

    /* renamed from: COUIBaseListPopupWindow_8 */
    private static final PathInterpolator f16085e = new PathInterpolator(0.35f, 0.62f, 0.2f, 1.0f);

    /* renamed from: A */
    private Frame f16086A;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f16087f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f16088g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f16089h;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f16090i;

    /* renamed from: OplusGLSurfaceView_15 */
    private int f16091j;

    /* renamed from: OplusGLSurfaceView_5 */
    private int f16092k;

    /* renamed from: OplusGLSurfaceView_14 */
    private int[] f16093l;

    /* renamed from: OplusGLSurfaceView_6 */
    private int f16094m;

    /* renamed from: OplusGLSurfaceView_11 */
    private long f16095n;

    /* renamed from: o */
    private String f16096o;

    /* renamed from: p */
    private String f16097p;

    /* renamed from: q */
    private FloatBuffer f16098q;

    /* renamed from: r */
    private Matrix f16099r;

    /* renamed from: s */
    private Rect f16100s;

    /* renamed from: t */
    private Rect f16101t;

    /* renamed from: u */
    private Rect f16102u;

    /* renamed from: v */
    private long f16103v;

    /* renamed from: w */
    private GLImageScaleCircularGaussProcessor f16104w;

    /* renamed from: x */
    private FloatBuffer f16105x;

    /* renamed from: y */
    private FloatBuffer f16106y;

    /* renamed from: z */
    private int f16107z;

    public OesDrawer(Context context) {
        super(context, 2);
        this.f16087f = 0;
        this.f16088g = 0;
        this.f16089h = 0;
        this.f16090i = 0;
        this.f16091j = 1;
        this.f16092k = 0;
        this.f16093l = null;
        this.f16094m = 0;
        this.f16095n = 0L;
        this.f16096o = null;
        this.f16097p = null;
        this.f16098q = null;
        this.f16099r = new Matrix();
        this.f16100s = new Rect();
        this.f16101t = new Rect();
        this.f16102u = new Rect();
        this.f16103v = 0L;
        this.f16104w = null;
        this.f16105x = null;
        this.f16106y = null;
        this.f16107z = 0;
        this.f16086A = null;
        this.f16105x = m16686a(RenderConst.f16121c);
        this.f16106y = m16686a(RenderConst.f16122d);
        this.f16093l = new int[1];
        this.f16096o = m16682a(context.getResources().openRawResource(R.raw.fragment_shader_oes));
        this.f16097p = m16682a(context.getResources().openRawResource(R.raw.vertex_shader_oes));
    }

    @Override // com.oplus.camera.screen.out.GLES20Drawer
    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo16687a() {
        super.mo16687a();
        m16699e();
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m16699e() {
        if (this.f16087f == 0) {
            this.f16087f = m16681a(this.f16097p, this.f16096o);
            this.f16088g = GLES20.glGetAttribLocation(this.f16087f, "aPosition");
            this.f16089h = GLES20.glGetAttribLocation(this.f16087f, "aTextureCoord");
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean m16703c() {
        return 0 != this.f16095n;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m16701a(Frame c2955a, Rect rect) {
        if (this.f16095n == 0) {
            GLES20.glGenTextures(this.f16068c.length, this.f16068c, 0);
            int[] iArr = this.f16093l;
            GLES20.glGenFramebuffers(iArr.length, iArr, 0);
            this.f16095n = PreviewShow.init();
        }
        mo16687a();
        m16698a(c2955a, rect, this.f16100s);
        GLES20.glViewport(this.f16100s.left, this.f16100s.top, this.f16100s.width(), this.f16100s.height());
        GLES20.glUseProgram(this.f16087f);
        GLES20.glActiveTexture(33984);
        if (!c2955a.f16060b.isClosed()) {
            PreviewShow.process(c2955a.f16060b, 36197, this.f16068c[this.f16090i], this.f16095n);
        }
        m16690b(this.f16089h, this.f16106y);
        m16691c(this.f16088g, m16696a(c2955a.f16063e));
        GLES20.glDrawArrays(5, 0, 4);
        this.f16086A = c2955a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m16698a(Frame c2955a, Rect rect, Rect rect2) {
        double dHeight;
        double IntrinsicsJvm.kt_5;
        double d2 = (c2955a.f16061c * 1.0d) / c2955a.f16062d;
        if (Math.abs(d2 - 1.3333333333333333d) < 0.01d) {
            dHeight = rect.height();
            IntrinsicsJvm.kt_5 = 0.21896792189679218d;
        } else if (Math.abs(d2 - 1.7777777777777777d) < 0.01d) {
            dHeight = rect.height();
            IntrinsicsJvm.kt_5 = 0.061366806136680614d;
        } else {
            dHeight = rect.height();
            IntrinsicsJvm.kt_5 = 0.30264993026499304d;
        }
        double d3 = dHeight * IntrinsicsJvm.kt_5;
        rect2.set(0, (int) d3, rect.width(), (int) (d3 + (rect.width() * d2)));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private FloatBuffer m16696a(int OplusGLSurfaceView_13) {
        float[] fArrA = m16684a(RenderConst.f16119a, (float[]) null);
        this.f16099r.reset();
        this.f16099r.postRotate(OplusGLSurfaceView_13);
        this.f16099r.mapPoints(fArrA);
        FloatBuffer floatBuffer = this.f16098q;
        if (floatBuffer == null) {
            this.f16098q = m16686a(fArrA);
        } else {
            floatBuffer.position(0);
            this.f16098q.put(fArrA);
            this.f16098q.position(0);
        }
        return this.f16098q;
    }

    @Override // com.oplus.camera.screen.out.GLES20Drawer
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo16689b() {
        super.mo16689b();
        int[] iArr = this.f16093l;
        GLES20.glDeleteFramebuffers(iArr.length, iArr, 0);
        PreviewShow.release(this.f16095n);
        GLImageScaleCircularGaussProcessor c2741d = this.f16104w;
        if (c2741d != null) {
            c2741d.mo13826b();
            this.f16104w = null;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int m16700a(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        int i5 = i2 / 10;
        int i6 = i3 / 10;
        this.f16104w.mo13827b(i5, i6);
        this.f16104w.mo13825a(i5, i6);
        this.f16104w.mo13824a(i4);
        return this.f16104w.mo13822a(OplusGLSurfaceView_13, OpenGLUtils.m24592a(GLImageProcessor.f13872a), OpenGLUtils.m24592a(GLImageProcessor.f13873b));
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m16702b(Frame c2955a, Rect rect) {
        this.f16101t.set(this.f16100s);
        m16698a(c2955a, rect, this.f16102u);
        this.f16103v = System.currentTimeMillis();
        m16697a(this.f16068c[this.f16091j], this.f16101t.width(), this.f16101t.height());
        GLES20.glBindFramebuffer(36160, this.f16093l[this.f16094m]);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.f16068c[this.f16091j], 0);
        GLES20.glViewport(0, 0, this.f16101t.width(), this.f16101t.height());
        GLES20.glUseProgram(this.f16087f);
        GLES20.glActiveTexture(33984);
        m16690b(this.f16089h, this.f16106y);
        m16691c(this.f16088g, m16696a(c2955a.f16063e));
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glBindFramebuffer(36160, 0);
        if (this.f16104w == null) {
            this.f16104w = new GLImageScaleCircularGaussProcessor();
        }
        this.f16104w.m13855a(new Size(this.f16101t.height(), this.f16101t.width()), new Size(this.f16102u.height(), this.f16102u.width()));
        this.f16107z = 0;
        this.f16086A = null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m16697a(int OplusGLSurfaceView_13, int i2, int i3) {
        GLES20.glBindTexture(3553, OplusGLSurfaceView_13);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLES20.glTexImage2D(3553, 0, 6408, i2, i3, 0, 6408, 5121, null);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean m16704c(Frame c2955a, Rect rect) {
        float fCurrentTimeMillis = (System.currentTimeMillis() - this.f16103v) / 600.0f;
        boolean z = fCurrentTimeMillis >= 1.0f;
        if (z) {
            fCurrentTimeMillis = 1.0f;
        }
        float interpolation = f16085e.getInterpolation(fCurrentTimeMillis);
        if (this.f16107z < 30) {
            this.f16092k = m16700a(this.f16068c[this.f16091j], this.f16100s.width(), this.f16100s.height(), (int) ((20.0f * interpolation) + 5.0f));
        }
        this.f16100s.set(0, (int) (this.f16101t.top + ((this.f16102u.top - this.f16101t.top) * interpolation)), rect.width(), (int) (this.f16101t.bottom + ((this.f16102u.bottom - this.f16101t.bottom) * interpolation)));
        GLES20.glViewport(this.f16100s.left, this.f16100s.top, this.f16100s.width(), this.f16100s.height());
        m16688a(this.f16092k, (FloatBuffer) null);
        this.f16107z++;
        return z;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m16705d() {
        if (this.f16086A != null) {
            GLES20.glUseProgram(this.f16087f);
            GLES20.glActiveTexture(33984);
            m16690b(this.f16089h, this.f16106y);
            m16691c(this.f16088g, m16696a(this.f16086A.f16063e));
            GLES20.glDrawArrays(5, 0, 4);
        }
    }
}
