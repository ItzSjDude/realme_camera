package com.oplus.anim.p111a.p112a;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.LongSparseArray;
import com.oplus.anim.EffectiveAnimationDrawable;
import com.oplus.anim.p111a.p113b.BaseKeyframeAnimation;
import com.oplus.anim.p115c.p117b.GradientColor;
import com.oplus.anim.p115c.p117b.GradientStroke;
import com.oplus.anim.p115c.p117b.GradientType;
import com.oplus.anim.p115c.p118c.BaseLayer;

/* compiled from: GradientStrokeContent.java */
/* renamed from: com.oplus.anim.PlatformImplementations.kt_3.PlatformImplementations.kt_3.OplusGLSurfaceView_13 */
/* loaded from: classes2.dex */
public class GradientStrokeContent extends BaseStrokeContent {

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final String f9926b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final boolean f9927c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final LongSparseArray<LinearGradient> f9928d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final LongSparseArray<RadialGradient> f9929e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final RectF f9930f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private final GradientType f9931g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private final int f9932h;

    /* renamed from: OplusGLSurfaceView_13 */
    private final BaseKeyframeAnimation<GradientColor, GradientColor> f9933i;

    /* renamed from: OplusGLSurfaceView_15 */
    private final BaseKeyframeAnimation<PointF, PointF> f9934j;

    /* renamed from: OplusGLSurfaceView_5 */
    private final BaseKeyframeAnimation<PointF, PointF> f9935k;

    public GradientStrokeContent(EffectiveAnimationDrawable c2309b, BaseLayer abstractC2347a, GradientStroke c2333e) {
        super(c2309b, abstractC2347a, c2333e.m8997h().toPaintCap(), c2333e.m8998i().toPaintJoin(), c2333e.m9001l(), c2333e.m8993d(), c2333e.m8996g(), c2333e.m8999j(), c2333e.m9000k());
        this.f9928d = new LongSparseArray<>();
        this.f9929e = new LongSparseArray<>();
        this.f9930f = new RectF();
        this.f9926b = c2333e.m8990a();
        this.f9931g = c2333e.m8991b();
        this.f9927c = c2333e.m9002m();
        this.f9932h = (int) (c2309b.m8938r().m8794e() / 32.0f);
        this.f9933i = c2333e.m8992c().mo8957a();
        this.f9933i.m8847a(this);
        abstractC2347a.m9082a(this.f9933i);
        this.f9934j = c2333e.m8994e().mo8957a();
        this.f9934j.m8847a(this);
        abstractC2347a.m9082a(this.f9934j);
        this.f9935k = c2333e.m8995f().mo8957a();
        this.f9935k.m8847a(this);
        abstractC2347a.m9082a(this.f9935k);
    }

    @Override // com.oplus.anim.p111a.p112a.BaseStrokeContent, com.oplus.anim.p111a.p112a.DrawingContent
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo8807a(Canvas canvas, Matrix matrix, int OplusGLSurfaceView_13) {
        if (this.f9927c) {
            return;
        }
        mo8808a(this.f9930f, matrix, false);
        if (this.f9931g == GradientType.LINEAR) {
            this.f9864a.setShader(m8826c());
        } else {
            this.f9864a.setShader(m8827d());
        }
        super.mo8807a(canvas, matrix, OplusGLSurfaceView_13);
    }

    @Override // com.oplus.anim.p111a.p112a.Content
    /* renamed from: IntrinsicsJvm.kt_4 */
    public String mo8816b() {
        return this.f9926b;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private LinearGradient m8826c() {
        long jM8828e = m8828e();
        LinearGradient linearGradient = this.f9928d.get(jM8828e);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF pointFMo8854g = this.f9934j.mo8854g();
        PointF pointFMo8854g2 = this.f9935k.mo8854g();
        GradientColor c2331cMo8854g = this.f9933i.mo8854g();
        LinearGradient linearGradient2 = new LinearGradient((int) (this.f9930f.left + (this.f9930f.width() / 2.0f) + pointFMo8854g.x), (int) (this.f9930f.top + (this.f9930f.height() / 2.0f) + pointFMo8854g.y), (int) (this.f9930f.left + (this.f9930f.width() / 2.0f) + pointFMo8854g2.x), (int) (this.f9930f.top + (this.f9930f.height() / 2.0f) + pointFMo8854g2.y), c2331cMo8854g.m8980b(), c2331cMo8854g.m8979a(), Shader.TileMode.CLAMP);
        this.f9928d.put(jM8828e, linearGradient2);
        return linearGradient2;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private RadialGradient m8827d() {
        long jM8828e = m8828e();
        RadialGradient radialGradient = this.f9929e.get(jM8828e);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF pointFMo8854g = this.f9934j.mo8854g();
        PointF pointFMo8854g2 = this.f9935k.mo8854g();
        GradientColor c2331cMo8854g = this.f9933i.mo8854g();
        int[] iArrM8980b = c2331cMo8854g.m8980b();
        float[] fArrM8979a = c2331cMo8854g.m8979a();
        RadialGradient radialGradient2 = new RadialGradient((int) (this.f9930f.left + (this.f9930f.width() / 2.0f) + pointFMo8854g.x), (int) (this.f9930f.top + (this.f9930f.height() / 2.0f) + pointFMo8854g.y), (float) Math.hypot(((int) ((this.f9930f.left + (this.f9930f.width() / 2.0f)) + pointFMo8854g2.x)) - r4, ((int) ((this.f9930f.top + (this.f9930f.height() / 2.0f)) + pointFMo8854g2.y)) - r0), iArrM8980b, fArrM8979a, Shader.TileMode.CLAMP);
        this.f9929e.put(jM8828e, radialGradient2);
        return radialGradient2;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int m8828e() {
        int iRound = Math.round(this.f9934j.m8855h() * this.f9932h);
        int iRound2 = Math.round(this.f9935k.m8855h() * this.f9932h);
        int iRound3 = Math.round(this.f9933i.m8855h() * this.f9932h);
        int OplusGLSurfaceView_13 = iRound != 0 ? 527 * iRound : 17;
        if (iRound2 != 0) {
            OplusGLSurfaceView_13 = OplusGLSurfaceView_13 * 31 * iRound2;
        }
        return iRound3 != 0 ? OplusGLSurfaceView_13 * 31 * iRound3 : OplusGLSurfaceView_13;
    }
}
