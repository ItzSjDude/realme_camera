package com.airbnb.lottie.p080a.p081a;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.InterfaceC1205k;
import com.airbnb.lottie.p080a.p082b.BaseKeyframeAnimation_3;
import com.airbnb.lottie.p084c.KeyPath_2;
import com.airbnb.lottie.p084c.p086b.PolystarShape_3;
import com.airbnb.lottie.p084c.p086b.ShapeTrimPath_3;
import com.airbnb.lottie.p084c.p087c.BaseLayer_3;
import com.airbnb.lottie.p091f.MiscUtils_2;
import com.airbnb.lottie.p092g.LottieValueCallback;
import java.util.List;

/* compiled from: PolystarContent.java */
/* renamed from: com.airbnb.lottie.PlatformImplementations.kt_3.PlatformImplementations.kt_3.OplusGLSurfaceView_11 */
/* loaded from: classes.dex */
public class PolystarContent_3 implements KeyPathElementContent_2, PathContent_2, BaseKeyframeAnimation_3.PlatformImplementations.kt_3 {

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final String f5351b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final LottieDrawable f5352c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final PolystarShape_3.PlatformImplementations.kt_3 f5353d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final boolean f5354e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final BaseKeyframeAnimation_3<?, Float> f5355f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private final BaseKeyframeAnimation_3<?, PointF> f5356g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private final BaseKeyframeAnimation_3<?, Float> f5357h;

    /* renamed from: OplusGLSurfaceView_13 */
    private final BaseKeyframeAnimation_3<?, Float> f5358i;

    /* renamed from: OplusGLSurfaceView_15 */
    private final BaseKeyframeAnimation_3<?, Float> f5359j;

    /* renamed from: OplusGLSurfaceView_5 */
    private final BaseKeyframeAnimation_3<?, Float> f5360k;

    /* renamed from: OplusGLSurfaceView_14 */
    private final BaseKeyframeAnimation_3<?, Float> f5361l;

    /* renamed from: OplusGLSurfaceView_11 */
    private boolean f5363n;

    /* renamed from: PlatformImplementations.kt_3 */
    private final Path f5350a = new Path();

    /* renamed from: OplusGLSurfaceView_6 */
    private CompoundTrimPathContent_2 f5362m = new CompoundTrimPathContent_2();

    public PolystarContent_3(LottieDrawable c1187f, BaseLayer_3 abstractC1122a, PolystarShape_3 c1112i) {
        this.f5352c = c1187f;
        this.f5351b = c1112i.m5699a();
        this.f5353d = c1112i.m5700b();
        this.f5354e = c1112i.m5708j();
        this.f5355f = c1112i.m5701c().mo5647a();
        this.f5356g = c1112i.m5702d().mo5647a();
        this.f5357h = c1112i.m5703e().mo5647a();
        this.f5359j = c1112i.m5705g().mo5647a();
        this.f5361l = c1112i.m5707i().mo5647a();
        if (this.f5353d == PolystarShape_3.PlatformImplementations.kt_3.STAR) {
            this.f5358i = c1112i.m5704f().mo5647a();
            this.f5360k = c1112i.m5706h().mo5647a();
        } else {
            this.f5358i = null;
            this.f5360k = null;
        }
        abstractC1122a.m5774a(this.f5355f);
        abstractC1122a.m5774a(this.f5356g);
        abstractC1122a.m5774a(this.f5357h);
        abstractC1122a.m5774a(this.f5359j);
        abstractC1122a.m5774a(this.f5361l);
        if (this.f5353d == PolystarShape_3.PlatformImplementations.kt_3.STAR) {
            abstractC1122a.m5774a(this.f5358i);
            abstractC1122a.m5774a(this.f5360k);
        }
        this.f5355f.m5576a(this);
        this.f5356g.m5576a(this);
        this.f5357h.m5576a(this);
        this.f5359j.m5576a(this);
        this.f5361l.m5576a(this);
        if (this.f5353d == PolystarShape_3.PlatformImplementations.kt_3.STAR) {
            this.f5358i.m5576a(this);
            this.f5360k.m5576a(this);
        }
    }

    @Override // com.airbnb.lottie.p080a.p082b.BaseKeyframeAnimation_3.PlatformImplementations.kt_3
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo5530a() {
        m5559c();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m5559c() {
        this.f5363n = false;
        this.f5352c.invalidateSelf();
    }

    @Override // com.airbnb.lottie.p080a.p081a.Content_2
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo5535a(List<Content_2> list, List<Content_2> list2) {
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < list.size(); OplusGLSurfaceView_13++) {
            Content_2 interfaceC1051c = list.get(OplusGLSurfaceView_13);
            if (interfaceC1051c instanceof TrimPathContent_2) {
                TrimPathContent_2 c1067s = (TrimPathContent_2) interfaceC1051c;
                if (c1067s.m5565c() == ShapeTrimPath_3.PlatformImplementations.kt_3.SIMULTANEOUSLY) {
                    this.f5362m.m5539a(c1067s);
                    c1067s.m5564a(this);
                }
            }
        }
    }

    @Override // com.airbnb.lottie.p080a.p081a.PathContent_2
    /* renamed from: COUIBaseListPopupWindow_8 */
    public Path mo5546e() {
        if (this.f5363n) {
            return this.f5350a;
        }
        this.f5350a.reset();
        if (this.f5354e) {
            this.f5363n = true;
            return this.f5350a;
        }
        int OplusGLSurfaceView_13 = COUIBaseListPopupWindow_2.f5364a[this.f5353d.ordinal()];
        if (OplusGLSurfaceView_13 == 1) {
            m5560d();
        } else if (OplusGLSurfaceView_13 == 2) {
            m5561f();
        }
        this.f5350a.close();
        this.f5362m.m5538a(this.f5350a);
        this.f5363n = true;
        return this.f5350a;
    }

    /* compiled from: PolystarContent.java */
    /* renamed from: com.airbnb.lottie.PlatformImplementations.kt_3.PlatformImplementations.kt_3.OplusGLSurfaceView_11$1, reason: invalid class name */
    static /* synthetic */ class COUIBaseListPopupWindow_2 {

        /* renamed from: PlatformImplementations.kt_3 */
        static final /* synthetic */ int[] f5364a = new int[PolystarShape_3.PlatformImplementations.kt_3.values().length];

        static {
            try {
                f5364a[PolystarShape_3.PlatformImplementations.kt_3.STAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5364a[PolystarShape_3.PlatformImplementations.kt_3.POLYGON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // com.airbnb.lottie.p080a.p081a.Content_2
    /* renamed from: IntrinsicsJvm.kt_4 */
    public String mo5540b() {
        return this.f5351b;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m5560d() {
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
        float fFloatValue = this.f5355f.mo5583g().floatValue();
        double radians = Math.toRadians((this.f5357h == null ? 0.0d : r2.mo5583g().floatValue()) - 90.0d);
        double d3 = fFloatValue;
        float f11 = (float) (6.283185307179586d / d3);
        float f12 = f11 / 2.0f;
        float f13 = fFloatValue - ((int) fFloatValue);
        int i2 = (f13 > 0.0f ? 1 : (f13 == 0.0f ? 0 : -1));
        if (i2 != 0) {
            radians += (1.0f - f13) * f12;
        }
        float fFloatValue2 = this.f5359j.mo5583g().floatValue();
        float fFloatValue3 = this.f5358i.mo5583g().floatValue();
        BaseKeyframeAnimation_3<?, Float> abstractC1068a = this.f5360k;
        float fFloatValue4 = abstractC1068a != null ? abstractC1068a.mo5583g().floatValue() / 100.0f : 0.0f;
        BaseKeyframeAnimation_3<?, Float> abstractC1068a2 = this.f5361l;
        float fFloatValue5 = abstractC1068a2 != null ? abstractC1068a2.mo5583g().floatValue() / 100.0f : 0.0f;
        if (i2 != 0) {
            COUIBaseListPopupWindow_12 = ((fFloatValue2 - fFloatValue3) * f13) + fFloatValue3;
            OplusGLSurfaceView_13 = i2;
            double d4 = COUIBaseListPopupWindow_12;
            IntrinsicsJvm.kt_5 = d3;
            fCos = (float) (d4 * Math.cos(radians));
            fSin = (float) (d4 * Math.sin(radians));
            this.f5350a.moveTo(fCos, fSin);
            d2 = radians + ((f11 * f13) / 2.0f);
        } else {
            IntrinsicsJvm.kt_5 = d3;
            OplusGLSurfaceView_13 = i2;
            double d5 = fFloatValue2;
            float fCos2 = (float) (Math.cos(radians) * d5);
            float fSin2 = (float) (d5 * Math.sin(radians));
            this.f5350a.moveTo(fCos2, fSin2);
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
                    this.f5350a.lineTo(fCos3, fSin3);
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
                    this.f5350a.cubicTo(f17 - f21, fSin - f22, fCos3 + f24, f10 + f25, fCos3, f10);
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
                PointF pointFMo5583g = this.f5356g.mo5583g();
                this.f5350a.offset(pointFMo5583g.x, pointFMo5583g.y);
                this.f5350a.close();
                return;
            }
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private void m5561f() {
        double IntrinsicsJvm.kt_5;
        double d2;
        double d3;
        int OplusGLSurfaceView_13;
        int iFloor = (int) Math.floor(this.f5355f.mo5583g().floatValue());
        double radians = Math.toRadians((this.f5357h == null ? 0.0d : r2.mo5583g().floatValue()) - 90.0d);
        double d4 = iFloor;
        float fFloatValue = this.f5361l.mo5583g().floatValue() / 100.0f;
        float fFloatValue2 = this.f5359j.mo5583g().floatValue();
        double d5 = fFloatValue2;
        float fCos = (float) (Math.cos(radians) * d5);
        float fSin = (float) (Math.sin(radians) * d5);
        this.f5350a.moveTo(fCos, fSin);
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
                this.f5350a.cubicTo(fCos - (fCos3 * COUIBaseListPopupWindow_12), fSin - (fSin3 * COUIBaseListPopupWindow_12), fCos2 + (((float) Math.cos(dAtan22)) * COUIBaseListPopupWindow_12), fSin2 + (COUIBaseListPopupWindow_12 * ((float) Math.sin(dAtan22))), fCos2, fSin2);
            } else {
                IntrinsicsJvm.kt_5 = d7;
                d2 = d5;
                d3 = d6;
                OplusGLSurfaceView_13 = i2;
                this.f5350a.lineTo(fCos2, fSin2);
            }
            d7 = IntrinsicsJvm.kt_5 + d3;
            i2 = OplusGLSurfaceView_13 + 1;
            fSin = fSin2;
            fCos = fCos2;
            dCeil = d8;
            d5 = d2;
            d6 = d3;
        }
        PointF pointFMo5583g = this.f5356g.mo5583g();
        this.f5350a.offset(pointFMo5583g.x, pointFMo5583g.y);
        this.f5350a.close();
    }

    @Override // com.airbnb.lottie.p084c.KeyPathElement_2
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo5533a(KeyPath_2 c1131e, int OplusGLSurfaceView_13, List<KeyPath_2> list, KeyPath_2 c1131e2) {
        MiscUtils_2.m6134a(c1131e, OplusGLSurfaceView_13, list, c1131e2, this);
    }

    @Override // com.airbnb.lottie.p084c.KeyPathElement_2
    /* renamed from: PlatformImplementations.kt_3 */
    public <T> void mo5534a(T t, LottieValueCallback<T> c1199c) {
        BaseKeyframeAnimation_3<?, Float> abstractC1068a;
        BaseKeyframeAnimation_3<?, Float> abstractC1068a2;
        if (t == InterfaceC1205k.f5948u) {
            this.f5355f.m5577a((LottieValueCallback<Float>) c1199c);
            return;
        }
        if (t == InterfaceC1205k.f5949v) {
            this.f5357h.m5577a((LottieValueCallback<Float>) c1199c);
            return;
        }
        if (t == InterfaceC1205k.f5939l) {
            this.f5356g.m5577a((LottieValueCallback<PointF>) c1199c);
            return;
        }
        if (t == InterfaceC1205k.f5950w && (abstractC1068a2 = this.f5358i) != null) {
            abstractC1068a2.m5577a((LottieValueCallback<Float>) c1199c);
            return;
        }
        if (t == InterfaceC1205k.f5951x) {
            this.f5359j.m5577a((LottieValueCallback<Float>) c1199c);
            return;
        }
        if (t == InterfaceC1205k.f5952y && (abstractC1068a = this.f5360k) != null) {
            abstractC1068a.m5577a((LottieValueCallback<Float>) c1199c);
        } else if (t == InterfaceC1205k.f5953z) {
            this.f5361l.m5577a((LottieValueCallback<Float>) c1199c);
        }
    }
}
