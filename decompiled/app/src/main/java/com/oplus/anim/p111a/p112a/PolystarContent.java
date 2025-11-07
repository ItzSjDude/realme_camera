package com.oplus.anim.p111a.p112a;

import android.graphics.Path;
import android.graphics.PointF;
import com.oplus.anim.EffectiveAnimationDrawable;
import com.oplus.anim.InterfaceC2361d;
import com.oplus.anim.p111a.p113b.BaseKeyframeAnimation;
import com.oplus.anim.p115c.KeyPath;
import com.oplus.anim.p115c.p117b.PolystarShape;
import com.oplus.anim.p115c.p117b.ShapeTrimPath;
import com.oplus.anim.p115c.p118c.BaseLayer;
import com.oplus.anim.p121f.MiscUtils;
import com.oplus.anim.p122g.EffectiveValueCallback;
import java.util.List;

/* compiled from: PolystarContent.java */
/* renamed from: com.oplus.anim.PlatformImplementations.kt_3.PlatformImplementations.kt_3.OplusGLSurfaceView_11 */
/* loaded from: classes2.dex */
public class PolystarContent implements KeyPathElementContent, PathContent, BaseKeyframeAnimation.PlatformImplementations.kt_3 {

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final String f9944b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final EffectiveAnimationDrawable f9945c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final PolystarShape.PlatformImplementations.kt_3 f9946d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final boolean f9947e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final BaseKeyframeAnimation<?, Float> f9948f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private final BaseKeyframeAnimation<?, PointF> f9949g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private final BaseKeyframeAnimation<?, Float> f9950h;

    /* renamed from: OplusGLSurfaceView_13 */
    private final BaseKeyframeAnimation<?, Float> f9951i;

    /* renamed from: OplusGLSurfaceView_15 */
    private final BaseKeyframeAnimation<?, Float> f9952j;

    /* renamed from: OplusGLSurfaceView_5 */
    private final BaseKeyframeAnimation<?, Float> f9953k;

    /* renamed from: OplusGLSurfaceView_14 */
    private final BaseKeyframeAnimation<?, Float> f9954l;

    /* renamed from: OplusGLSurfaceView_11 */
    private boolean f9956n;

    /* renamed from: PlatformImplementations.kt_3 */
    private final Path f9943a = new Path();

    /* renamed from: OplusGLSurfaceView_6 */
    private CompoundTrimPathContent f9955m = new CompoundTrimPathContent();

    public PolystarContent(EffectiveAnimationDrawable c2309b, BaseLayer abstractC2347a, PolystarShape c2337i) {
        this.f9945c = c2309b;
        this.f9944b = c2337i.m9010a();
        this.f9946d = c2337i.m9011b();
        this.f9947e = c2337i.m9019j();
        this.f9948f = c2337i.m9012c().mo8957a();
        this.f9949g = c2337i.m9013d().mo8957a();
        this.f9950h = c2337i.m9014e().mo8957a();
        this.f9952j = c2337i.m9016g().mo8957a();
        this.f9954l = c2337i.m9018i().mo8957a();
        if (this.f9946d == PolystarShape.PlatformImplementations.kt_3.STAR) {
            this.f9951i = c2337i.m9015f().mo8957a();
            this.f9953k = c2337i.m9017h().mo8957a();
        } else {
            this.f9951i = null;
            this.f9953k = null;
        }
        abstractC2347a.m9082a(this.f9948f);
        abstractC2347a.m9082a(this.f9949g);
        abstractC2347a.m9082a(this.f9950h);
        abstractC2347a.m9082a(this.f9952j);
        abstractC2347a.m9082a(this.f9954l);
        if (this.f9946d == PolystarShape.PlatformImplementations.kt_3.STAR) {
            abstractC2347a.m9082a(this.f9951i);
            abstractC2347a.m9082a(this.f9953k);
        }
        this.f9948f.m8847a(this);
        this.f9949g.m8847a(this);
        this.f9950h.m8847a(this);
        this.f9952j.m8847a(this);
        this.f9954l.m8847a(this);
        if (this.f9946d == PolystarShape.PlatformImplementations.kt_3.STAR) {
            this.f9951i.m8847a(this);
            this.f9953k.m8847a(this);
        }
    }

    @Override // com.oplus.anim.p111a.p113b.BaseKeyframeAnimation.PlatformImplementations.kt_3
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo8806a() {
        m8832c();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m8832c() {
        this.f9956n = false;
        this.f9945c.invalidateSelf();
    }

    @Override // com.oplus.anim.p111a.p112a.Content
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo8811a(List<Content> list, List<Content> list2) {
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < list.size(); OplusGLSurfaceView_13++) {
            Content interfaceC2276c = list.get(OplusGLSurfaceView_13);
            if (interfaceC2276c instanceof TrimPathContent) {
                TrimPathContent c2292s = (TrimPathContent) interfaceC2276c;
                if (c2292s.m8838c() == ShapeTrimPath.PlatformImplementations.kt_3.SIMULTANEOUSLY) {
                    this.f9955m.m8815a(c2292s);
                    c2292s.m8837a(this);
                }
            }
        }
    }

    @Override // com.oplus.anim.p111a.p112a.PathContent
    /* renamed from: COUIBaseListPopupWindow_8 */
    public Path mo8821e() {
        if (this.f9956n) {
            return this.f9943a;
        }
        this.f9943a.reset();
        if (this.f9947e) {
            this.f9956n = true;
            return this.f9943a;
        }
        int OplusGLSurfaceView_13 = COUIBaseListPopupWindow_2.f9957a[this.f9946d.ordinal()];
        if (OplusGLSurfaceView_13 == 1) {
            m8833d();
        } else if (OplusGLSurfaceView_13 == 2) {
            m8834f();
        }
        this.f9943a.close();
        this.f9955m.m8814a(this.f9943a);
        this.f9956n = true;
        return this.f9943a;
    }

    /* compiled from: PolystarContent.java */
    /* renamed from: com.oplus.anim.PlatformImplementations.kt_3.PlatformImplementations.kt_3.OplusGLSurfaceView_11$1, reason: invalid class name */
    static /* synthetic */ class COUIBaseListPopupWindow_2 {

        /* renamed from: PlatformImplementations.kt_3 */
        static final /* synthetic */ int[] f9957a = new int[PolystarShape.PlatformImplementations.kt_3.values().length];

        static {
            try {
                f9957a[PolystarShape.PlatformImplementations.kt_3.STAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9957a[PolystarShape.PlatformImplementations.kt_3.POLYGON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // com.oplus.anim.p111a.p112a.Content
    /* renamed from: IntrinsicsJvm.kt_4 */
    public String mo8816b() {
        return this.f9944b;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m8833d() {
        double IntrinsicsJvm.kt_5;
        int OplusGLSurfaceView_13;
        double d2;
        float fCos;
        float fSin;
        float COUIBaseListPopupWindow_12;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        float fFloatValue = this.f9948f.mo8854g().floatValue();
        double radians = Math.toRadians((this.f9950h == null ? 0.0d : r2.mo8854g().floatValue()) - 90.0d);
        double d3 = fFloatValue;
        float f11 = (float) (6.283185307179586d / d3);
        float f12 = f11 / 2.0f;
        float f13 = fFloatValue - ((int) fFloatValue);
        int i2 = (f13 > 0.0f ? 1 : (f13 == 0.0f ? 0 : -1));
        if (i2 != 0) {
            radians += (1.0f - f13) * f12;
        }
        float fFloatValue2 = this.f9952j.mo8854g().floatValue();
        float fFloatValue3 = this.f9951i.mo8854g().floatValue();
        BaseKeyframeAnimation<?, Float> abstractC2293a = this.f9953k;
        float fFloatValue4 = abstractC2293a != null ? abstractC2293a.mo8854g().floatValue() / 100.0f : 0.0f;
        BaseKeyframeAnimation<?, Float> abstractC2293a2 = this.f9954l;
        float fFloatValue5 = abstractC2293a2 != null ? abstractC2293a2.mo8854g().floatValue() / 100.0f : 0.0f;
        if (i2 != 0) {
            COUIBaseListPopupWindow_12 = ((fFloatValue2 - fFloatValue3) * f13) + fFloatValue3;
            OplusGLSurfaceView_13 = i2;
            double d4 = COUIBaseListPopupWindow_12;
            IntrinsicsJvm.kt_5 = d3;
            fCos = (float) (d4 * Math.cos(radians));
            fSin = (float) (d4 * Math.sin(radians));
            this.f9943a.moveTo(fCos, fSin);
            d2 = radians + ((f11 * f13) / 2.0f);
        } else {
            IntrinsicsJvm.kt_5 = d3;
            OplusGLSurfaceView_13 = i2;
            double d5 = fFloatValue2;
            float fCos2 = (float) (Math.cos(radians) * d5);
            float fSin2 = (float) (d5 * Math.sin(radians));
            this.f9943a.moveTo(fCos2, fSin2);
            d2 = radians + f12;
            fCos = fCos2;
            fSin = fSin2;
            COUIBaseListPopupWindow_12 = 0.0f;
        }
        double dCeil = Math.ceil(IntrinsicsJvm.kt_5) * 2.0d;
        boolean z = false;
        double d6 = d2;
        float f14 = f12;
        int i3 = 0;
        while (true) {
            double d7 = i3;
            if (d7 < dCeil) {
                float f15 = z ? fFloatValue2 : fFloatValue3;
                if (COUIBaseListPopupWindow_12 == 0.0f || d7 != dCeil - 2.0d) {
                    f2 = f14;
                } else {
                    f2 = f14;
                    f14 = (f11 * f13) / 2.0f;
                }
                if (COUIBaseListPopupWindow_12 == 0.0f || d7 != dCeil - 1.0d) {
                    f3 = f11;
                    f4 = fFloatValue3;
                    f5 = f15;
                    f6 = fFloatValue2;
                } else {
                    f3 = f11;
                    f6 = fFloatValue2;
                    f4 = fFloatValue3;
                    f5 = COUIBaseListPopupWindow_12;
                }
                double d8 = f5;
                float f16 = f14;
                float fCos3 = (float) (d8 * Math.cos(d6));
                float fSin3 = (float) (d8 * Math.sin(d6));
                if (fFloatValue4 == 0.0f && fFloatValue5 == 0.0f) {
                    this.f9943a.lineTo(fCos3, fSin3);
                    f10 = fSin3;
                    f7 = fFloatValue4;
                    f8 = fFloatValue5;
                    f9 = COUIBaseListPopupWindow_12;
                } else {
                    f7 = fFloatValue4;
                    f8 = fFloatValue5;
                    double dAtan2 = (float) (Math.atan2(fSin, fCos) - 1.5707963267948966d);
                    float fCos4 = (float) Math.cos(dAtan2);
                    float fSin4 = (float) Math.sin(dAtan2);
                    f9 = COUIBaseListPopupWindow_12;
                    f10 = fSin3;
                    float f17 = fCos;
                    double dAtan22 = (float) (Math.atan2(fSin3, fCos3) - 1.5707963267948966d);
                    float fCos5 = (float) Math.cos(dAtan22);
                    float fSin5 = (float) Math.sin(dAtan22);
                    float f18 = z ? f7 : f8;
                    float f19 = z ? f8 : f7;
                    float f20 = (z ? f4 : f6) * f18 * 0.47829f;
                    float f21 = fCos4 * f20;
                    float f22 = f20 * fSin4;
                    float f23 = (z ? f6 : f4) * f19 * 0.47829f;
                    float f24 = fCos5 * f23;
                    float f25 = f23 * fSin5;
                    if (OplusGLSurfaceView_13 != 0) {
                        if (i3 == 0) {
                            f21 *= f13;
                            f22 *= f13;
                        } else if (d7 == dCeil - 1.0d) {
                            f24 *= f13;
                            f25 *= f13;
                        }
                    }
                    this.f9943a.cubicTo(f17 - f21, fSin - f22, fCos3 + f24, f10 + f25, fCos3, f10);
                }
                d6 += f16;
                z = !z;
                i3++;
                fCos = fCos3;
                COUIBaseListPopupWindow_12 = f9;
                fFloatValue2 = f6;
                f11 = f3;
                f14 = f2;
                fFloatValue3 = f4;
                fFloatValue4 = f7;
                fFloatValue5 = f8;
                fSin = f10;
            } else {
                PointF pointFMo8854g = this.f9949g.mo8854g();
                this.f9943a.offset(pointFMo8854g.x, pointFMo8854g.y);
                this.f9943a.close();
                return;
            }
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private void m8834f() {
        double IntrinsicsJvm.kt_5;
        double d2;
        double d3;
        int OplusGLSurfaceView_13;
        int iFloor = (int) Math.floor(this.f9948f.mo8854g().floatValue());
        double radians = Math.toRadians((this.f9950h == null ? 0.0d : r2.mo8854g().floatValue()) - 90.0d);
        double d4 = iFloor;
        float fFloatValue = this.f9954l.mo8854g().floatValue() / 100.0f;
        float fFloatValue2 = this.f9952j.mo8854g().floatValue();
        double d5 = fFloatValue2;
        float fCos = (float) (Math.cos(radians) * d5);
        float fSin = (float) (Math.sin(radians) * d5);
        this.f9943a.moveTo(fCos, fSin);
        double d6 = (float) (6.283185307179586d / d4);
        double d7 = radians + d6;
        double dCeil = Math.ceil(d4);
        int i2 = 0;
        while (i2 < dCeil) {
            float fCos2 = (float) (Math.cos(d7) * d5);
            double d8 = dCeil;
            float fSin2 = (float) (d5 * Math.sin(d7));
            if (fFloatValue != 0.0f) {
                d2 = d5;
                OplusGLSurfaceView_13 = i2;
                IntrinsicsJvm.kt_5 = d7;
                double dAtan2 = (float) (Math.atan2(fSin, fCos) - 1.5707963267948966d);
                float fCos3 = (float) Math.cos(dAtan2);
                float fSin3 = (float) Math.sin(dAtan2);
                d3 = d6;
                double dAtan22 = (float) (Math.atan2(fSin2, fCos2) - 1.5707963267948966d);
                float COUIBaseListPopupWindow_12 = fFloatValue2 * fFloatValue * 0.25f;
                this.f9943a.cubicTo(fCos - (fCos3 * COUIBaseListPopupWindow_12), fSin - (fSin3 * COUIBaseListPopupWindow_12), fCos2 + (((float) Math.cos(dAtan22)) * COUIBaseListPopupWindow_12), fSin2 + (COUIBaseListPopupWindow_12 * ((float) Math.sin(dAtan22))), fCos2, fSin2);
            } else {
                IntrinsicsJvm.kt_5 = d7;
                d2 = d5;
                d3 = d6;
                OplusGLSurfaceView_13 = i2;
                this.f9943a.lineTo(fCos2, fSin2);
            }
            d7 = IntrinsicsJvm.kt_5 + d3;
            i2 = OplusGLSurfaceView_13 + 1;
            fSin = fSin2;
            fCos = fCos2;
            dCeil = d8;
            d5 = d2;
            d6 = d3;
        }
        PointF pointFMo8854g = this.f9949g.mo8854g();
        this.f9943a.offset(pointFMo8854g.x, pointFMo8854g.y);
        this.f9943a.close();
    }

    @Override // com.oplus.anim.p115c.KeyPathElement
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo8809a(KeyPath c2357f, int OplusGLSurfaceView_13, List<KeyPath> list, KeyPath c2357f2) {
        MiscUtils.m9281a(c2357f, OplusGLSurfaceView_13, list, c2357f2, this);
    }

    @Override // com.oplus.anim.p115c.KeyPathElement
    /* renamed from: PlatformImplementations.kt_3 */
    public <T> void mo8810a(T t, EffectiveValueCallback<T> c2412b) {
        BaseKeyframeAnimation<?, Float> abstractC2293a;
        BaseKeyframeAnimation<?, Float> abstractC2293a2;
        if (t == InterfaceC2361d.f10335q) {
            this.f9948f.m8848a((EffectiveValueCallback<Float>) c2412b);
            return;
        }
        if (t == InterfaceC2361d.f10336r) {
            this.f9950h.m8848a((EffectiveValueCallback<Float>) c2412b);
            return;
        }
        if (t == InterfaceC2361d.f10326h) {
            this.f9949g.m8848a((EffectiveValueCallback<PointF>) c2412b);
            return;
        }
        if (t == InterfaceC2361d.f10337s && (abstractC2293a2 = this.f9951i) != null) {
            abstractC2293a2.m8848a((EffectiveValueCallback<Float>) c2412b);
            return;
        }
        if (t == InterfaceC2361d.f10338t) {
            this.f9952j.m8848a((EffectiveValueCallback<Float>) c2412b);
            return;
        }
        if (t == InterfaceC2361d.f10339u && (abstractC2293a = this.f9953k) != null) {
            abstractC2293a.m8848a((EffectiveValueCallback<Float>) c2412b);
        } else if (t == InterfaceC2361d.f10340v) {
            this.f9954l.m8848a((EffectiveValueCallback<Float>) c2412b);
        }
    }
}
