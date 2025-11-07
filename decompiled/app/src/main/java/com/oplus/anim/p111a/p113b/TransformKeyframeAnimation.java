package com.oplus.anim.p111a.p113b;

import android.graphics.Matrix;
import android.graphics.PointF;
import com.oplus.anim.InterfaceC2361d;
import com.oplus.anim.p111a.p113b.BaseKeyframeAnimation;
import com.oplus.anim.p115c.p116a.AnimatableTransform;
import com.oplus.anim.p115c.p118c.BaseLayer;
import com.oplus.anim.p122g.EffectiveValueCallback;
import com.oplus.anim.p122g.Keyframe;
import com.oplus.anim.p122g.ScaleXY;
import java.util.Collections;

/* compiled from: TransformKeyframeAnimation.java */
/* renamed from: com.oplus.anim.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.o */
/* loaded from: classes2.dex */
public class TransformKeyframeAnimation {

    /* renamed from: PlatformImplementations.kt_3 */
    private final Matrix f10025a = new Matrix();

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final Matrix f10026b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final Matrix f10027c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final Matrix f10028d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final float[] f10029e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private BaseKeyframeAnimation<PointF, PointF> f10030f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private BaseKeyframeAnimation<?, PointF> f10031g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private BaseKeyframeAnimation<ScaleXY, ScaleXY> f10032h;

    /* renamed from: OplusGLSurfaceView_13 */
    private BaseKeyframeAnimation<Float, Float> f10033i;

    /* renamed from: OplusGLSurfaceView_15 */
    private BaseKeyframeAnimation<Integer, Integer> f10034j;

    /* renamed from: OplusGLSurfaceView_5 */
    private FloatKeyframeAnimation f10035k;

    /* renamed from: OplusGLSurfaceView_14 */
    private FloatKeyframeAnimation f10036l;

    /* renamed from: OplusGLSurfaceView_6 */
    private BaseKeyframeAnimation<?, Float> f10037m;

    /* renamed from: OplusGLSurfaceView_11 */
    private BaseKeyframeAnimation<?, Float> f10038n;

    public TransformKeyframeAnimation(AnimatableTransform c2325l) {
        this.f10030f = c2325l.m8963a() == null ? null : c2325l.m8963a().mo8957a();
        this.f10031g = c2325l.m8964b() == null ? null : c2325l.m8964b().mo8957a();
        this.f10032h = c2325l.m8965c() == null ? null : c2325l.m8965c().mo8957a();
        this.f10033i = c2325l.m8966d() == null ? null : c2325l.m8966d().mo8957a();
        this.f10035k = c2325l.m8970h() == null ? null : (FloatKeyframeAnimation) c2325l.m8970h().mo8957a();
        if (this.f10035k != null) {
            this.f10026b = new Matrix();
            this.f10027c = new Matrix();
            this.f10028d = new Matrix();
            this.f10029e = new float[9];
        } else {
            this.f10026b = null;
            this.f10027c = null;
            this.f10028d = null;
            this.f10029e = null;
        }
        this.f10036l = c2325l.m8971i() == null ? null : (FloatKeyframeAnimation) c2325l.m8971i().mo8957a();
        if (c2325l.m8967e() != null) {
            this.f10034j = c2325l.m8967e().mo8957a();
        }
        if (c2325l.m8968f() != null) {
            this.f10037m = c2325l.m8968f().mo8957a();
        } else {
            this.f10037m = null;
        }
        if (c2325l.m8969g() != null) {
            this.f10038n = c2325l.m8969g().mo8957a();
        } else {
            this.f10038n = null;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m8882a(BaseLayer abstractC2347a) {
        abstractC2347a.m9082a(this.f10034j);
        abstractC2347a.m9082a(this.f10037m);
        abstractC2347a.m9082a(this.f10038n);
        abstractC2347a.m9082a(this.f10030f);
        abstractC2347a.m9082a(this.f10031g);
        abstractC2347a.m9082a(this.f10032h);
        abstractC2347a.m9082a(this.f10033i);
        abstractC2347a.m9082a(this.f10035k);
        abstractC2347a.m9082a(this.f10036l);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m8881a(BaseKeyframeAnimation.PlatformImplementations.kt_3 aVar) {
        BaseKeyframeAnimation<Integer, Integer> abstractC2293a = this.f10034j;
        if (abstractC2293a != null) {
            abstractC2293a.m8847a(aVar);
        }
        BaseKeyframeAnimation<?, Float> abstractC2293a2 = this.f10037m;
        if (abstractC2293a2 != null) {
            abstractC2293a2.m8847a(aVar);
        }
        BaseKeyframeAnimation<?, Float> abstractC2293a3 = this.f10038n;
        if (abstractC2293a3 != null) {
            abstractC2293a3.m8847a(aVar);
        }
        BaseKeyframeAnimation<PointF, PointF> abstractC2293a4 = this.f10030f;
        if (abstractC2293a4 != null) {
            abstractC2293a4.m8847a(aVar);
        }
        BaseKeyframeAnimation<?, PointF> abstractC2293a5 = this.f10031g;
        if (abstractC2293a5 != null) {
            abstractC2293a5.m8847a(aVar);
        }
        BaseKeyframeAnimation<ScaleXY, ScaleXY> abstractC2293a6 = this.f10032h;
        if (abstractC2293a6 != null) {
            abstractC2293a6.m8847a(aVar);
        }
        BaseKeyframeAnimation<Float, Float> abstractC2293a7 = this.f10033i;
        if (abstractC2293a7 != null) {
            abstractC2293a7.m8847a(aVar);
        }
        FloatKeyframeAnimation c2295c = this.f10035k;
        if (c2295c != null) {
            c2295c.m8847a(aVar);
        }
        FloatKeyframeAnimation c2295c2 = this.f10036l;
        if (c2295c2 != null) {
            c2295c2.m8847a(aVar);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m8880a(float COUIBaseListPopupWindow_12) {
        BaseKeyframeAnimation<Integer, Integer> abstractC2293a = this.f10034j;
        if (abstractC2293a != null) {
            abstractC2293a.mo8846a(COUIBaseListPopupWindow_12);
        }
        BaseKeyframeAnimation<?, Float> abstractC2293a2 = this.f10037m;
        if (abstractC2293a2 != null) {
            abstractC2293a2.mo8846a(COUIBaseListPopupWindow_12);
        }
        BaseKeyframeAnimation<?, Float> abstractC2293a3 = this.f10038n;
        if (abstractC2293a3 != null) {
            abstractC2293a3.mo8846a(COUIBaseListPopupWindow_12);
        }
        BaseKeyframeAnimation<PointF, PointF> abstractC2293a4 = this.f10030f;
        if (abstractC2293a4 != null) {
            abstractC2293a4.mo8846a(COUIBaseListPopupWindow_12);
        }
        BaseKeyframeAnimation<?, PointF> abstractC2293a5 = this.f10031g;
        if (abstractC2293a5 != null) {
            abstractC2293a5.mo8846a(COUIBaseListPopupWindow_12);
        }
        BaseKeyframeAnimation<ScaleXY, ScaleXY> abstractC2293a6 = this.f10032h;
        if (abstractC2293a6 != null) {
            abstractC2293a6.mo8846a(COUIBaseListPopupWindow_12);
        }
        BaseKeyframeAnimation<Float, Float> abstractC2293a7 = this.f10033i;
        if (abstractC2293a7 != null) {
            abstractC2293a7.mo8846a(COUIBaseListPopupWindow_12);
        }
        FloatKeyframeAnimation c2295c = this.f10035k;
        if (c2295c != null) {
            c2295c.mo8846a(COUIBaseListPopupWindow_12);
        }
        FloatKeyframeAnimation c2295c2 = this.f10036l;
        if (c2295c2 != null) {
            c2295c2.mo8846a(COUIBaseListPopupWindow_12);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public BaseKeyframeAnimation<?, Integer> m8879a() {
        return this.f10034j;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public BaseKeyframeAnimation<?, Float> m8885b() {
        return this.f10037m;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public BaseKeyframeAnimation<?, Float> m8886c() {
        return this.f10038n;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public Matrix m8887d() {
        float fM8861i;
        this.f10025a.reset();
        BaseKeyframeAnimation<?, PointF> abstractC2293a = this.f10031g;
        if (abstractC2293a != null) {
            PointF pointFMo8854g = abstractC2293a.mo8854g();
            if (pointFMo8854g.x != 0.0f || pointFMo8854g.y != 0.0f) {
                this.f10025a.preTranslate(pointFMo8854g.x, pointFMo8854g.y);
            }
        }
        BaseKeyframeAnimation<Float, Float> abstractC2293a2 = this.f10033i;
        if (abstractC2293a2 != null) {
            if (abstractC2293a2 instanceof ValueCallbackKeyframeAnimation) {
                fM8861i = abstractC2293a2.mo8854g().floatValue();
            } else {
                fM8861i = ((FloatKeyframeAnimation) abstractC2293a2).m8861i();
            }
            if (fM8861i != 0.0f) {
                this.f10025a.preRotate(fM8861i);
            }
        }
        if (this.f10035k != null) {
            float fCos = this.f10036l == null ? 0.0f : (float) Math.cos(Math.toRadians((-r0.m8861i()) + 90.0f));
            float fSin = this.f10036l == null ? 1.0f : (float) Math.sin(Math.toRadians((-r4.m8861i()) + 90.0f));
            float fTan = (float) Math.tan(Math.toRadians(this.f10035k.m8861i()));
            m8878e();
            float[] fArr = this.f10029e;
            fArr[0] = fCos;
            fArr[1] = fSin;
            float COUIBaseListPopupWindow_12 = -fSin;
            fArr[3] = COUIBaseListPopupWindow_12;
            fArr[4] = fCos;
            fArr[8] = 1.0f;
            this.f10026b.setValues(fArr);
            m8878e();
            float[] fArr2 = this.f10029e;
            fArr2[0] = 1.0f;
            fArr2[3] = fTan;
            fArr2[4] = 1.0f;
            fArr2[8] = 1.0f;
            this.f10027c.setValues(fArr2);
            m8878e();
            float[] fArr3 = this.f10029e;
            fArr3[0] = fCos;
            fArr3[1] = COUIBaseListPopupWindow_12;
            fArr3[3] = fSin;
            fArr3[4] = fCos;
            fArr3[8] = 1.0f;
            this.f10028d.setValues(fArr3);
            this.f10027c.preConcat(this.f10026b);
            this.f10028d.preConcat(this.f10027c);
            this.f10025a.preConcat(this.f10028d);
        }
        BaseKeyframeAnimation<ScaleXY, ScaleXY> abstractC2293a3 = this.f10032h;
        if (abstractC2293a3 != null) {
            ScaleXY c2414dMo8854g = abstractC2293a3.mo8854g();
            if (c2414dMo8854g.m9335a() != 1.0f || c2414dMo8854g.m9337b() != 1.0f) {
                this.f10025a.preScale(c2414dMo8854g.m9335a(), c2414dMo8854g.m9337b());
            }
        }
        BaseKeyframeAnimation<PointF, PointF> abstractC2293a4 = this.f10030f;
        if (abstractC2293a4 != null) {
            PointF pointFMo8854g2 = abstractC2293a4.mo8854g();
            if (pointFMo8854g2.x != 0.0f || pointFMo8854g2.y != 0.0f) {
                this.f10025a.preTranslate(-pointFMo8854g2.x, -pointFMo8854g2.y);
            }
        }
        return this.f10025a;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m8878e() {
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < 9; OplusGLSurfaceView_13++) {
            this.f10029e[OplusGLSurfaceView_13] = 0.0f;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public Matrix m8884b(float COUIBaseListPopupWindow_12) {
        BaseKeyframeAnimation<?, PointF> abstractC2293a = this.f10031g;
        PointF pointFMo8854g = abstractC2293a == null ? null : abstractC2293a.mo8854g();
        BaseKeyframeAnimation<ScaleXY, ScaleXY> abstractC2293a2 = this.f10032h;
        ScaleXY c2414dMo8854g = abstractC2293a2 == null ? null : abstractC2293a2.mo8854g();
        this.f10025a.reset();
        if (pointFMo8854g != null) {
            this.f10025a.preTranslate(pointFMo8854g.x * COUIBaseListPopupWindow_12, pointFMo8854g.y * COUIBaseListPopupWindow_12);
        }
        if (c2414dMo8854g != null) {
            double IntrinsicsJvm.kt_5 = COUIBaseListPopupWindow_12;
            this.f10025a.preScale((float) Math.pow(c2414dMo8854g.m9335a(), IntrinsicsJvm.kt_5), (float) Math.pow(c2414dMo8854g.m9337b(), IntrinsicsJvm.kt_5));
        }
        BaseKeyframeAnimation<Float, Float> abstractC2293a3 = this.f10033i;
        if (abstractC2293a3 != null) {
            float fFloatValue = abstractC2293a3.mo8854g().floatValue();
            BaseKeyframeAnimation<PointF, PointF> abstractC2293a4 = this.f10030f;
            PointF pointFMo8854g2 = abstractC2293a4 != null ? abstractC2293a4.mo8854g() : null;
            this.f10025a.preRotate(fFloatValue * COUIBaseListPopupWindow_12, pointFMo8854g2 == null ? 0.0f : pointFMo8854g2.x, pointFMo8854g2 != null ? pointFMo8854g2.y : 0.0f);
        }
        return this.f10025a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public <T> boolean m8883a(T t, EffectiveValueCallback<T> c2412b) {
        FloatKeyframeAnimation c2295c;
        FloatKeyframeAnimation c2295c2;
        BaseKeyframeAnimation<?, Float> abstractC2293a;
        BaseKeyframeAnimation<?, Float> abstractC2293a2;
        if (t == InterfaceC2361d.f10323e) {
            BaseKeyframeAnimation<PointF, PointF> abstractC2293a3 = this.f10030f;
            if (abstractC2293a3 == null) {
                this.f10030f = new ValueCallbackKeyframeAnimation(c2412b, new PointF());
                return true;
            }
            abstractC2293a3.m8848a((EffectiveValueCallback<PointF>) c2412b);
            return true;
        }
        if (t == InterfaceC2361d.f10324f) {
            BaseKeyframeAnimation<?, PointF> abstractC2293a4 = this.f10031g;
            if (abstractC2293a4 == null) {
                this.f10031g = new ValueCallbackKeyframeAnimation(c2412b, new PointF());
                return true;
            }
            abstractC2293a4.m8848a((EffectiveValueCallback<PointF>) c2412b);
            return true;
        }
        if (t == InterfaceC2361d.f10327i) {
            BaseKeyframeAnimation<ScaleXY, ScaleXY> abstractC2293a5 = this.f10032h;
            if (abstractC2293a5 == null) {
                this.f10032h = new ValueCallbackKeyframeAnimation(c2412b, new ScaleXY());
                return true;
            }
            abstractC2293a5.m8848a((EffectiveValueCallback<ScaleXY>) c2412b);
            return true;
        }
        if (t == InterfaceC2361d.f10328j) {
            BaseKeyframeAnimation<Float, Float> abstractC2293a6 = this.f10033i;
            if (abstractC2293a6 == null) {
                this.f10033i = new ValueCallbackKeyframeAnimation(c2412b, Float.valueOf(0.0f));
                return true;
            }
            abstractC2293a6.m8848a((EffectiveValueCallback<Float>) c2412b);
            return true;
        }
        if (t == InterfaceC2361d.f10321c) {
            BaseKeyframeAnimation<Integer, Integer> abstractC2293a7 = this.f10034j;
            if (abstractC2293a7 == null) {
                this.f10034j = new ValueCallbackKeyframeAnimation(c2412b, 100);
                return true;
            }
            abstractC2293a7.m8848a((EffectiveValueCallback<Integer>) c2412b);
            return true;
        }
        if (t == InterfaceC2361d.f10341w && (abstractC2293a2 = this.f10037m) != null) {
            if (abstractC2293a2 == null) {
                this.f10037m = new ValueCallbackKeyframeAnimation(c2412b, 100);
                return true;
            }
            abstractC2293a2.m8848a((EffectiveValueCallback<Float>) c2412b);
            return true;
        }
        if (t == InterfaceC2361d.f10342x && (abstractC2293a = this.f10038n) != null) {
            if (abstractC2293a == null) {
                this.f10038n = new ValueCallbackKeyframeAnimation(c2412b, 100);
                return true;
            }
            abstractC2293a.m8848a((EffectiveValueCallback<Float>) c2412b);
            return true;
        }
        if (t == InterfaceC2361d.f10329k && (c2295c2 = this.f10035k) != null) {
            if (c2295c2 == null) {
                this.f10035k = new FloatKeyframeAnimation(Collections.singletonList(new Keyframe(Float.valueOf(0.0f))));
            }
            this.f10035k.m8848a(c2412b);
            return true;
        }
        if (t != InterfaceC2361d.f10330l || (c2295c = this.f10036l) == null) {
            return false;
        }
        if (c2295c == null) {
            this.f10036l = new FloatKeyframeAnimation(Collections.singletonList(new Keyframe(Float.valueOf(0.0f))));
        }
        this.f10036l.m8848a(c2412b);
        return true;
    }
}
