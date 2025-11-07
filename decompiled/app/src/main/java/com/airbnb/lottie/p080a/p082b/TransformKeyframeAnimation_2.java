package com.airbnb.lottie.p080a.p082b;

import android.graphics.Matrix;
import android.graphics.PointF;
import com.airbnb.lottie.InterfaceC1205k;
import com.airbnb.lottie.p080a.p082b.BaseKeyframeAnimation_3;
import com.airbnb.lottie.p084c.p085a.AnimatableTransform_2;
import com.airbnb.lottie.p084c.p087c.BaseLayer_3;
import com.airbnb.lottie.p092g.Keyframe_2;
import com.airbnb.lottie.p092g.LottieValueCallback;
import com.airbnb.lottie.p092g.ScaleXY_2;
import java.util.Collections;

/* compiled from: TransformKeyframeAnimation.java */
/* renamed from: com.airbnb.lottie.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.o */
/* loaded from: classes.dex */
public class TransformKeyframeAnimation_2 {

    /* renamed from: PlatformImplementations.kt_3 */
    private final Matrix f5438a = new Matrix();

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final Matrix f5439b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final Matrix f5440c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final Matrix f5441d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final float[] f5442e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private BaseKeyframeAnimation_3<PointF, PointF> f5443f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private BaseKeyframeAnimation_3<?, PointF> f5444g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private BaseKeyframeAnimation_3<ScaleXY_2, ScaleXY_2> f5445h;

    /* renamed from: OplusGLSurfaceView_13 */
    private BaseKeyframeAnimation_3<Float, Float> f5446i;

    /* renamed from: OplusGLSurfaceView_15 */
    private BaseKeyframeAnimation_3<Integer, Integer> f5447j;

    /* renamed from: OplusGLSurfaceView_5 */
    private FloatKeyframeAnimation_2 f5448k;

    /* renamed from: OplusGLSurfaceView_14 */
    private FloatKeyframeAnimation_2 f5449l;

    /* renamed from: OplusGLSurfaceView_6 */
    private BaseKeyframeAnimation_3<?, Float> f5450m;

    /* renamed from: OplusGLSurfaceView_11 */
    private BaseKeyframeAnimation_3<?, Float> f5451n;

    public TransformKeyframeAnimation_2(AnimatableTransform_2 c1100l) {
        this.f5443f = c1100l.m5652a() == null ? null : c1100l.m5652a().mo5647a();
        this.f5444g = c1100l.m5653b() == null ? null : c1100l.m5653b().mo5647a();
        this.f5445h = c1100l.m5654c() == null ? null : c1100l.m5654c().mo5647a();
        this.f5446i = c1100l.m5655d() == null ? null : c1100l.m5655d().mo5647a();
        this.f5448k = c1100l.m5659h() == null ? null : (FloatKeyframeAnimation_2) c1100l.m5659h().mo5647a();
        if (this.f5448k != null) {
            this.f5439b = new Matrix();
            this.f5440c = new Matrix();
            this.f5441d = new Matrix();
            this.f5442e = new float[9];
        } else {
            this.f5439b = null;
            this.f5440c = null;
            this.f5441d = null;
            this.f5442e = null;
        }
        this.f5449l = c1100l.m5660i() == null ? null : (FloatKeyframeAnimation_2) c1100l.m5660i().mo5647a();
        if (c1100l.m5656e() != null) {
            this.f5447j = c1100l.m5656e().mo5647a();
        }
        if (c1100l.m5657f() != null) {
            this.f5450m = c1100l.m5657f().mo5647a();
        } else {
            this.f5450m = null;
        }
        if (c1100l.m5658g() != null) {
            this.f5451n = c1100l.m5658g().mo5647a();
        } else {
            this.f5451n = null;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m5621a(BaseLayer_3 abstractC1122a) {
        abstractC1122a.m5774a(this.f5447j);
        abstractC1122a.m5774a(this.f5450m);
        abstractC1122a.m5774a(this.f5451n);
        abstractC1122a.m5774a(this.f5443f);
        abstractC1122a.m5774a(this.f5444g);
        abstractC1122a.m5774a(this.f5445h);
        abstractC1122a.m5774a(this.f5446i);
        abstractC1122a.m5774a(this.f5448k);
        abstractC1122a.m5774a(this.f5449l);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m5620a(BaseKeyframeAnimation_3.PlatformImplementations.kt_3 aVar) {
        BaseKeyframeAnimation_3<Integer, Integer> abstractC1068a = this.f5447j;
        if (abstractC1068a != null) {
            abstractC1068a.m5576a(aVar);
        }
        BaseKeyframeAnimation_3<?, Float> abstractC1068a2 = this.f5450m;
        if (abstractC1068a2 != null) {
            abstractC1068a2.m5576a(aVar);
        }
        BaseKeyframeAnimation_3<?, Float> abstractC1068a3 = this.f5451n;
        if (abstractC1068a3 != null) {
            abstractC1068a3.m5576a(aVar);
        }
        BaseKeyframeAnimation_3<PointF, PointF> abstractC1068a4 = this.f5443f;
        if (abstractC1068a4 != null) {
            abstractC1068a4.m5576a(aVar);
        }
        BaseKeyframeAnimation_3<?, PointF> abstractC1068a5 = this.f5444g;
        if (abstractC1068a5 != null) {
            abstractC1068a5.m5576a(aVar);
        }
        BaseKeyframeAnimation_3<ScaleXY_2, ScaleXY_2> abstractC1068a6 = this.f5445h;
        if (abstractC1068a6 != null) {
            abstractC1068a6.m5576a(aVar);
        }
        BaseKeyframeAnimation_3<Float, Float> abstractC1068a7 = this.f5446i;
        if (abstractC1068a7 != null) {
            abstractC1068a7.m5576a(aVar);
        }
        FloatKeyframeAnimation_2 c1070c = this.f5448k;
        if (c1070c != null) {
            c1070c.m5576a(aVar);
        }
        FloatKeyframeAnimation_2 c1070c2 = this.f5449l;
        if (c1070c2 != null) {
            c1070c2.m5576a(aVar);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m5619a(float COUIBaseListPopupWindow_12) {
        BaseKeyframeAnimation_3<Integer, Integer> abstractC1068a = this.f5447j;
        if (abstractC1068a != null) {
            abstractC1068a.mo5575a(COUIBaseListPopupWindow_12);
        }
        BaseKeyframeAnimation_3<?, Float> abstractC1068a2 = this.f5450m;
        if (abstractC1068a2 != null) {
            abstractC1068a2.mo5575a(COUIBaseListPopupWindow_12);
        }
        BaseKeyframeAnimation_3<?, Float> abstractC1068a3 = this.f5451n;
        if (abstractC1068a3 != null) {
            abstractC1068a3.mo5575a(COUIBaseListPopupWindow_12);
        }
        BaseKeyframeAnimation_3<PointF, PointF> abstractC1068a4 = this.f5443f;
        if (abstractC1068a4 != null) {
            abstractC1068a4.mo5575a(COUIBaseListPopupWindow_12);
        }
        BaseKeyframeAnimation_3<?, PointF> abstractC1068a5 = this.f5444g;
        if (abstractC1068a5 != null) {
            abstractC1068a5.mo5575a(COUIBaseListPopupWindow_12);
        }
        BaseKeyframeAnimation_3<ScaleXY_2, ScaleXY_2> abstractC1068a6 = this.f5445h;
        if (abstractC1068a6 != null) {
            abstractC1068a6.mo5575a(COUIBaseListPopupWindow_12);
        }
        BaseKeyframeAnimation_3<Float, Float> abstractC1068a7 = this.f5446i;
        if (abstractC1068a7 != null) {
            abstractC1068a7.mo5575a(COUIBaseListPopupWindow_12);
        }
        FloatKeyframeAnimation_2 c1070c = this.f5448k;
        if (c1070c != null) {
            c1070c.mo5575a(COUIBaseListPopupWindow_12);
        }
        FloatKeyframeAnimation_2 c1070c2 = this.f5449l;
        if (c1070c2 != null) {
            c1070c2.mo5575a(COUIBaseListPopupWindow_12);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public BaseKeyframeAnimation_3<?, Integer> m5618a() {
        return this.f5447j;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public BaseKeyframeAnimation_3<?, Float> m5624b() {
        return this.f5450m;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public BaseKeyframeAnimation_3<?, Float> m5625c() {
        return this.f5451n;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public Matrix m5626d() {
        float fM5597i;
        this.f5438a.reset();
        BaseKeyframeAnimation_3<?, PointF> abstractC1068a = this.f5444g;
        if (abstractC1068a != null) {
            PointF pointFMo5583g = abstractC1068a.mo5583g();
            if (pointFMo5583g.x != 0.0f || pointFMo5583g.y != 0.0f) {
                this.f5438a.preTranslate(pointFMo5583g.x, pointFMo5583g.y);
            }
        }
        BaseKeyframeAnimation_3<Float, Float> abstractC1068a2 = this.f5446i;
        if (abstractC1068a2 != null) {
            if (abstractC1068a2 instanceof ValueCallbackKeyframeAnimation_2) {
                fM5597i = abstractC1068a2.mo5583g().floatValue();
            } else {
                fM5597i = ((FloatKeyframeAnimation_2) abstractC1068a2).m5597i();
            }
            if (fM5597i != 0.0f) {
                this.f5438a.preRotate(fM5597i);
            }
        }
        if (this.f5448k != null) {
            float fCos = this.f5449l == null ? 0.0f : (float) Math.cos(Math.toRadians((-r0.m5597i()) + 90.0f));
            float fSin = this.f5449l == null ? 1.0f : (float) Math.sin(Math.toRadians((-r4.m5597i()) + 90.0f));
            float fTan = (float) Math.tan(Math.toRadians(this.f5448k.m5597i()));
            m5617e();
            float[] fArr = this.f5442e;
            fArr[0] = fCos;
            fArr[1] = fSin;
            float COUIBaseListPopupWindow_12 = -fSin;
            fArr[3] = COUIBaseListPopupWindow_12;
            fArr[4] = fCos;
            fArr[8] = 1.0f;
            this.f5439b.setValues(fArr);
            m5617e();
            float[] fArr2 = this.f5442e;
            fArr2[0] = 1.0f;
            fArr2[3] = fTan;
            fArr2[4] = 1.0f;
            fArr2[8] = 1.0f;
            this.f5440c.setValues(fArr2);
            m5617e();
            float[] fArr3 = this.f5442e;
            fArr3[0] = fCos;
            fArr3[1] = COUIBaseListPopupWindow_12;
            fArr3[3] = fSin;
            fArr3[4] = fCos;
            fArr3[8] = 1.0f;
            this.f5441d.setValues(fArr3);
            this.f5440c.preConcat(this.f5439b);
            this.f5441d.preConcat(this.f5440c);
            this.f5438a.preConcat(this.f5441d);
        }
        BaseKeyframeAnimation_3<ScaleXY_2, ScaleXY_2> abstractC1068a3 = this.f5445h;
        if (abstractC1068a3 != null) {
            ScaleXY_2 c1200dMo5583g = abstractC1068a3.mo5583g();
            if (c1200dMo5583g.m6175a() != 1.0f || c1200dMo5583g.m6177b() != 1.0f) {
                this.f5438a.preScale(c1200dMo5583g.m6175a(), c1200dMo5583g.m6177b());
            }
        }
        BaseKeyframeAnimation_3<PointF, PointF> abstractC1068a4 = this.f5443f;
        if (abstractC1068a4 != null) {
            PointF pointFMo5583g2 = abstractC1068a4.mo5583g();
            if (pointFMo5583g2.x != 0.0f || pointFMo5583g2.y != 0.0f) {
                this.f5438a.preTranslate(-pointFMo5583g2.x, -pointFMo5583g2.y);
            }
        }
        return this.f5438a;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m5617e() {
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < 9; OplusGLSurfaceView_13++) {
            this.f5442e[OplusGLSurfaceView_13] = 0.0f;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public Matrix m5623b(float COUIBaseListPopupWindow_12) {
        BaseKeyframeAnimation_3<?, PointF> abstractC1068a = this.f5444g;
        PointF pointFMo5583g = abstractC1068a == null ? null : abstractC1068a.mo5583g();
        BaseKeyframeAnimation_3<ScaleXY_2, ScaleXY_2> abstractC1068a2 = this.f5445h;
        ScaleXY_2 c1200dMo5583g = abstractC1068a2 == null ? null : abstractC1068a2.mo5583g();
        this.f5438a.reset();
        if (pointFMo5583g != null) {
            this.f5438a.preTranslate(pointFMo5583g.x * COUIBaseListPopupWindow_12, pointFMo5583g.y * COUIBaseListPopupWindow_12);
        }
        if (c1200dMo5583g != null) {
            double IntrinsicsJvm.kt_5 = COUIBaseListPopupWindow_12;
            this.f5438a.preScale((float) Math.pow(c1200dMo5583g.m6175a(), IntrinsicsJvm.kt_5), (float) Math.pow(c1200dMo5583g.m6177b(), IntrinsicsJvm.kt_5));
        }
        BaseKeyframeAnimation_3<Float, Float> abstractC1068a3 = this.f5446i;
        if (abstractC1068a3 != null) {
            float fFloatValue = abstractC1068a3.mo5583g().floatValue();
            BaseKeyframeAnimation_3<PointF, PointF> abstractC1068a4 = this.f5443f;
            PointF pointFMo5583g2 = abstractC1068a4 != null ? abstractC1068a4.mo5583g() : null;
            this.f5438a.preRotate(fFloatValue * COUIBaseListPopupWindow_12, pointFMo5583g2 == null ? 0.0f : pointFMo5583g2.x, pointFMo5583g2 != null ? pointFMo5583g2.y : 0.0f);
        }
        return this.f5438a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public <T> boolean m5622a(T t, LottieValueCallback<T> c1199c) {
        FloatKeyframeAnimation_2 c1070c;
        FloatKeyframeAnimation_2 c1070c2;
        BaseKeyframeAnimation_3<?, Float> abstractC1068a;
        BaseKeyframeAnimation_3<?, Float> abstractC1068a2;
        if (t == InterfaceC1205k.f5932e) {
            BaseKeyframeAnimation_3<PointF, PointF> abstractC1068a3 = this.f5443f;
            if (abstractC1068a3 == null) {
                this.f5443f = new ValueCallbackKeyframeAnimation_2(c1199c, new PointF());
                return true;
            }
            abstractC1068a3.m5577a((LottieValueCallback<PointF>) c1199c);
            return true;
        }
        if (t == InterfaceC1205k.f5933f) {
            BaseKeyframeAnimation_3<?, PointF> abstractC1068a4 = this.f5444g;
            if (abstractC1068a4 == null) {
                this.f5444g = new ValueCallbackKeyframeAnimation_2(c1199c, new PointF());
                return true;
            }
            abstractC1068a4.m5577a((LottieValueCallback<PointF>) c1199c);
            return true;
        }
        if (t == InterfaceC1205k.f5934g) {
            BaseKeyframeAnimation_3<?, PointF> abstractC1068a5 = this.f5444g;
            if (abstractC1068a5 instanceof SplitDimensionPathKeyframeAnimation_2) {
                ((SplitDimensionPathKeyframeAnimation_2) abstractC1068a5).m5613b(c1199c);
                return true;
            }
        }
        if (t == InterfaceC1205k.f5935h) {
            BaseKeyframeAnimation_3<?, PointF> abstractC1068a6 = this.f5444g;
            if (abstractC1068a6 instanceof SplitDimensionPathKeyframeAnimation_2) {
                ((SplitDimensionPathKeyframeAnimation_2) abstractC1068a6).m5614c(c1199c);
                return true;
            }
        }
        if (t == InterfaceC1205k.f5940m) {
            BaseKeyframeAnimation_3<ScaleXY_2, ScaleXY_2> abstractC1068a7 = this.f5445h;
            if (abstractC1068a7 == null) {
                this.f5445h = new ValueCallbackKeyframeAnimation_2(c1199c, new ScaleXY_2());
                return true;
            }
            abstractC1068a7.m5577a((LottieValueCallback<ScaleXY_2>) c1199c);
            return true;
        }
        if (t == InterfaceC1205k.f5941n) {
            BaseKeyframeAnimation_3<Float, Float> abstractC1068a8 = this.f5446i;
            if (abstractC1068a8 == null) {
                this.f5446i = new ValueCallbackKeyframeAnimation_2(c1199c, Float.valueOf(0.0f));
                return true;
            }
            abstractC1068a8.m5577a((LottieValueCallback<Float>) c1199c);
            return true;
        }
        if (t == InterfaceC1205k.f5930c) {
            BaseKeyframeAnimation_3<Integer, Integer> abstractC1068a9 = this.f5447j;
            if (abstractC1068a9 == null) {
                this.f5447j = new ValueCallbackKeyframeAnimation_2(c1199c, 100);
                return true;
            }
            abstractC1068a9.m5577a((LottieValueCallback<Integer>) c1199c);
            return true;
        }
        if (t == InterfaceC1205k.f5922A && (abstractC1068a2 = this.f5450m) != null) {
            if (abstractC1068a2 == null) {
                this.f5450m = new ValueCallbackKeyframeAnimation_2(c1199c, 100);
                return true;
            }
            abstractC1068a2.m5577a((LottieValueCallback<Float>) c1199c);
            return true;
        }
        if (t == InterfaceC1205k.f5923B && (abstractC1068a = this.f5451n) != null) {
            if (abstractC1068a == null) {
                this.f5451n = new ValueCallbackKeyframeAnimation_2(c1199c, 100);
                return true;
            }
            abstractC1068a.m5577a((LottieValueCallback<Float>) c1199c);
            return true;
        }
        if (t == InterfaceC1205k.f5942o && (c1070c2 = this.f5448k) != null) {
            if (c1070c2 == null) {
                this.f5448k = new FloatKeyframeAnimation_2(Collections.singletonList(new Keyframe_2(Float.valueOf(0.0f))));
            }
            this.f5448k.m5577a(c1199c);
            return true;
        }
        if (t != InterfaceC1205k.f5943p || (c1070c = this.f5449l) == null) {
            return false;
        }
        if (c1070c == null) {
            this.f5449l = new FloatKeyframeAnimation_2(Collections.singletonList(new Keyframe_2(Float.valueOf(0.0f))));
        }
        this.f5449l.m5577a(c1199c);
        return true;
    }
}
