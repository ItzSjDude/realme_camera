package com.oplus.anim.p111a.p112a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.LongSparseArray;
import com.oplus.anim.EffectiveAnimationDrawable;
import com.oplus.anim.L;
import com.oplus.anim.InterfaceC2361d;
import com.oplus.anim.p111a.LPaint;
import com.oplus.anim.p111a.p113b.BaseKeyframeAnimation;
import com.oplus.anim.p111a.p113b.ValueCallbackKeyframeAnimation;
import com.oplus.anim.p115c.KeyPath;
import com.oplus.anim.p115c.p117b.GradientColor;
import com.oplus.anim.p115c.p117b.GradientFill;
import com.oplus.anim.p115c.p117b.GradientType;
import com.oplus.anim.p115c.p118c.BaseLayer;
import com.oplus.anim.p121f.MiscUtils;
import com.oplus.anim.p122g.EffectiveValueCallback;
import java.util.ArrayList;
import java.util.List;

/* compiled from: GradientFillContent.java */
/* renamed from: com.oplus.anim.PlatformImplementations.kt_3.PlatformImplementations.kt_3.COUIBaseListPopupWindow_10 */
/* loaded from: classes2.dex */
public class GradientFillContent implements DrawingContent, KeyPathElementContent, BaseKeyframeAnimation.PlatformImplementations.kt_3 {

    /* renamed from: PlatformImplementations.kt_3 */
    private final String f9908a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final boolean f9909b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final BaseLayer f9910c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final LongSparseArray<LinearGradient> f9911d = new LongSparseArray<>();

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final LongSparseArray<RadialGradient> f9912e = new LongSparseArray<>();

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final Matrix f9913f = new Matrix();

    /* renamed from: COUIBaseListPopupWindow_11 */
    private final Path f9914g = new Path();

    /* renamed from: COUIBaseListPopupWindow_10 */
    private final Paint f9915h = new LPaint(1);

    /* renamed from: OplusGLSurfaceView_13 */
    private final RectF f9916i = new RectF();

    /* renamed from: OplusGLSurfaceView_15 */
    private final List<PathContent> f9917j = new ArrayList();

    /* renamed from: OplusGLSurfaceView_5 */
    private final GradientType f9918k;

    /* renamed from: OplusGLSurfaceView_14 */
    private final BaseKeyframeAnimation<GradientColor, GradientColor> f9919l;

    /* renamed from: OplusGLSurfaceView_6 */
    private final BaseKeyframeAnimation<Integer, Integer> f9920m;

    /* renamed from: OplusGLSurfaceView_11 */
    private final BaseKeyframeAnimation<PointF, PointF> f9921n;

    /* renamed from: o */
    private final BaseKeyframeAnimation<PointF, PointF> f9922o;

    /* renamed from: p */
    private final EffectiveAnimationDrawable f9923p;

    /* renamed from: q */
    private final int f9924q;

    /* renamed from: r */
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> f9925r;

    public GradientFillContent(EffectiveAnimationDrawable c2309b, BaseLayer abstractC2347a, GradientFill c2332d) {
        this.f9910c = abstractC2347a;
        this.f9908a = c2332d.m8982a();
        this.f9909b = c2332d.m8989h();
        this.f9923p = c2309b;
        this.f9918k = c2332d.m8983b();
        this.f9914g.setFillType(c2332d.m8984c());
        this.f9924q = (int) (c2309b.m8938r().m8794e() / 32.0f);
        this.f9919l = c2332d.m8985d().mo8957a();
        this.f9919l.m8847a(this);
        abstractC2347a.m9082a(this.f9919l);
        this.f9920m = c2332d.m8986e().mo8957a();
        this.f9920m.m8847a(this);
        abstractC2347a.m9082a(this.f9920m);
        this.f9921n = c2332d.m8987f().mo8957a();
        this.f9921n.m8847a(this);
        abstractC2347a.m9082a(this.f9921n);
        this.f9922o = c2332d.m8988g().mo8957a();
        this.f9922o.m8847a(this);
        abstractC2347a.m9082a(this.f9922o);
    }

    @Override // com.oplus.anim.p111a.p113b.BaseKeyframeAnimation.PlatformImplementations.kt_3
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo8806a() {
        this.f9923p.invalidateSelf();
    }

    @Override // com.oplus.anim.p111a.p112a.Content
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo8811a(List<Content> list, List<Content> list2) {
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < list2.size(); OplusGLSurfaceView_13++) {
            Content interfaceC2276c = list2.get(OplusGLSurfaceView_13);
            if (interfaceC2276c instanceof PathContent) {
                this.f9917j.add((PathContent) interfaceC2276c);
            }
        }
    }

    @Override // com.oplus.anim.p111a.p112a.DrawingContent
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo8807a(Canvas canvas, Matrix matrix, int OplusGLSurfaceView_13) {
        Shader shaderM8824d;
        if (this.f9909b) {
            return;
        }
        L.m9349c("GradientFillContent#draw");
        this.f9914g.reset();
        for (int i2 = 0; i2 < this.f9917j.size(); i2++) {
            this.f9914g.addPath(this.f9917j.get(i2).mo8821e(), matrix);
        }
        this.f9914g.computeBounds(this.f9916i, false);
        if (this.f9918k == GradientType.LINEAR) {
            shaderM8824d = m8823c();
        } else {
            shaderM8824d = m8824d();
        }
        this.f9913f.set(matrix);
        shaderM8824d.setLocalMatrix(this.f9913f);
        this.f9915h.setShader(shaderM8824d);
        BaseKeyframeAnimation<ColorFilter, ColorFilter> abstractC2293a = this.f9925r;
        if (abstractC2293a != null) {
            this.f9915h.setColorFilter(abstractC2293a.mo8854g());
        }
        this.f9915h.setAlpha(MiscUtils.m9278a((int) ((((OplusGLSurfaceView_13 / 255.0f) * this.f9920m.mo8854g().intValue()) / 100.0f) * 255.0f), 0, 255));
        canvas.drawPath(this.f9914g, this.f9915h);
        L.m9350d("GradientFillContent#draw");
    }

    @Override // com.oplus.anim.p111a.p112a.DrawingContent
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo8808a(RectF rectF, Matrix matrix, boolean z) {
        this.f9914g.reset();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f9917j.size(); OplusGLSurfaceView_13++) {
            this.f9914g.addPath(this.f9917j.get(OplusGLSurfaceView_13).mo8821e(), matrix);
        }
        this.f9914g.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // com.oplus.anim.p111a.p112a.Content
    /* renamed from: IntrinsicsJvm.kt_4 */
    public String mo8816b() {
        return this.f9908a;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private LinearGradient m8823c() {
        long jM8825e = m8825e();
        LinearGradient linearGradient = this.f9911d.get(jM8825e);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF pointFMo8854g = this.f9921n.mo8854g();
        PointF pointFMo8854g2 = this.f9922o.mo8854g();
        GradientColor c2331cMo8854g = this.f9919l.mo8854g();
        LinearGradient linearGradient2 = new LinearGradient(pointFMo8854g.x, pointFMo8854g.y, pointFMo8854g2.x, pointFMo8854g2.y, c2331cMo8854g.m8980b(), c2331cMo8854g.m8979a(), Shader.TileMode.CLAMP);
        this.f9911d.put(jM8825e, linearGradient2);
        return linearGradient2;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private RadialGradient m8824d() {
        long jM8825e = m8825e();
        RadialGradient radialGradient = this.f9912e.get(jM8825e);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF pointFMo8854g = this.f9921n.mo8854g();
        PointF pointFMo8854g2 = this.f9922o.mo8854g();
        GradientColor c2331cMo8854g = this.f9919l.mo8854g();
        int[] iArrM8980b = c2331cMo8854g.m8980b();
        float[] fArrM8979a = c2331cMo8854g.m8979a();
        float COUIBaseListPopupWindow_12 = pointFMo8854g.x;
        float f2 = pointFMo8854g.y;
        float fHypot = (float) Math.hypot(pointFMo8854g2.x - COUIBaseListPopupWindow_12, pointFMo8854g2.y - f2);
        if (fHypot <= 0.0f) {
            fHypot = 0.001f;
        }
        RadialGradient radialGradient2 = new RadialGradient(COUIBaseListPopupWindow_12, f2, fHypot, iArrM8980b, fArrM8979a, Shader.TileMode.CLAMP);
        this.f9912e.put(jM8825e, radialGradient2);
        return radialGradient2;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int m8825e() {
        int iRound = Math.round(this.f9921n.m8855h() * this.f9924q);
        int iRound2 = Math.round(this.f9922o.m8855h() * this.f9924q);
        int iRound3 = Math.round(this.f9919l.m8855h() * this.f9924q);
        int OplusGLSurfaceView_13 = iRound != 0 ? 527 * iRound : 17;
        if (iRound2 != 0) {
            OplusGLSurfaceView_13 = OplusGLSurfaceView_13 * 31 * iRound2;
        }
        return iRound3 != 0 ? OplusGLSurfaceView_13 * 31 * iRound3 : OplusGLSurfaceView_13;
    }

    @Override // com.oplus.anim.p115c.KeyPathElement
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo8809a(KeyPath c2357f, int OplusGLSurfaceView_13, List<KeyPath> list, KeyPath c2357f2) {
        MiscUtils.m9281a(c2357f, OplusGLSurfaceView_13, list, c2357f2, this);
    }

    @Override // com.oplus.anim.p115c.KeyPathElement
    /* renamed from: PlatformImplementations.kt_3 */
    public <T> void mo8810a(T t, EffectiveValueCallback<T> c2412b) {
        if (t == InterfaceC2361d.f10344z) {
            if (c2412b == null) {
                this.f9925r = null;
                return;
            }
            this.f9925r = new ValueCallbackKeyframeAnimation(c2412b);
            this.f9925r.m8847a(this);
            this.f9910c.m9082a(this.f9925r);
        }
    }
}
