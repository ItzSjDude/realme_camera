package com.airbnb.lottie.p080a.p081a;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.InterfaceC1205k;
import com.airbnb.lottie.p080a.p082b.BaseKeyframeAnimation_3;
import com.airbnb.lottie.p080a.p082b.ValueCallbackKeyframeAnimation_2;
import com.airbnb.lottie.p084c.p086b.GradientColor_2;
import com.airbnb.lottie.p084c.p086b.GradientStroke_2;
import com.airbnb.lottie.p084c.p086b.GradientType_2;
import com.airbnb.lottie.p084c.p087c.BaseLayer_3;
import com.airbnb.lottie.p092g.LottieValueCallback;

/* compiled from: GradientStrokeContent.java */
/* renamed from: com.airbnb.lottie.PlatformImplementations.kt_3.PlatformImplementations.kt_3.OplusGLSurfaceView_13 */
/* loaded from: classes.dex */
public class GradientStrokeContent_2 extends BaseStrokeContent_3 {

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final String f5332c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final boolean f5333d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final LongSparseArray<LinearGradient> f5334e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final LongSparseArray<RadialGradient> f5335f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private final RectF f5336g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private final GradientType_2 f5337h;

    /* renamed from: OplusGLSurfaceView_13 */
    private final int f5338i;

    /* renamed from: OplusGLSurfaceView_15 */
    private final BaseKeyframeAnimation_3<GradientColor_2, GradientColor_2> f5339j;

    /* renamed from: OplusGLSurfaceView_5 */
    private final BaseKeyframeAnimation_3<PointF, PointF> f5340k;

    /* renamed from: OplusGLSurfaceView_14 */
    private final BaseKeyframeAnimation_3<PointF, PointF> f5341l;

    /* renamed from: OplusGLSurfaceView_6 */
    private ValueCallbackKeyframeAnimation_2 f5342m;

    public GradientStrokeContent_2(LottieDrawable c1187f, BaseLayer_3 abstractC1122a, GradientStroke_2 c1108e) {
        super(c1187f, abstractC1122a, c1108e.m5686h().toPaintCap(), c1108e.m5687i().toPaintJoin(), c1108e.m5690l(), c1108e.m5682d(), c1108e.m5685g(), c1108e.m5688j(), c1108e.m5689k());
        this.f5334e = new LongSparseArray<>();
        this.f5335f = new LongSparseArray<>();
        this.f5336g = new RectF();
        this.f5332c = c1108e.m5679a();
        this.f5337h = c1108e.m5680b();
        this.f5333d = c1108e.m5691m();
        this.f5338i = (int) (c1187f.m6080t().m5852e() / 32.0f);
        this.f5339j = c1108e.m5681c().mo5647a();
        this.f5339j.m5576a(this);
        abstractC1122a.m5774a(this.f5339j);
        this.f5340k = c1108e.m5683e().mo5647a();
        this.f5340k.m5576a(this);
        abstractC1122a.m5774a(this.f5340k);
        this.f5341l = c1108e.m5684f().mo5647a();
        this.f5341l.m5576a(this);
        abstractC1122a.m5774a(this.f5341l);
    }

    @Override // com.airbnb.lottie.p080a.p081a.BaseStrokeContent_3, com.airbnb.lottie.p080a.p081a.DrawingContent_2
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo5531a(Canvas canvas, Matrix matrix, int OplusGLSurfaceView_13) {
        Shader shaderM5554d;
        if (this.f5333d) {
            return;
        }
        mo5532a(this.f5336g, matrix, false);
        if (this.f5337h == GradientType_2.LINEAR) {
            shaderM5554d = m5553c();
        } else {
            shaderM5554d = m5554d();
        }
        shaderM5554d.setLocalMatrix(matrix);
        this.f5269b.setShader(shaderM5554d);
        super.mo5531a(canvas, matrix, OplusGLSurfaceView_13);
    }

    @Override // com.airbnb.lottie.p080a.p081a.Content_2
    /* renamed from: IntrinsicsJvm.kt_4 */
    public String mo5540b() {
        return this.f5332c;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private LinearGradient m5553c() {
        long jM5555e = m5555e();
        LinearGradient linearGradient = this.f5334e.get(jM5555e);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF pointFMo5583g = this.f5340k.mo5583g();
        PointF pointFMo5583g2 = this.f5341l.mo5583g();
        GradientColor_2 c1106cMo5583g = this.f5339j.mo5583g();
        LinearGradient linearGradient2 = new LinearGradient(pointFMo5583g.x, pointFMo5583g.y, pointFMo5583g2.x, pointFMo5583g2.y, m5552a(c1106cMo5583g.m5669b()), c1106cMo5583g.m5668a(), Shader.TileMode.CLAMP);
        this.f5334e.put(jM5555e, linearGradient2);
        return linearGradient2;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private RadialGradient m5554d() {
        long jM5555e = m5555e();
        RadialGradient radialGradient = this.f5335f.get(jM5555e);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF pointFMo5583g = this.f5340k.mo5583g();
        PointF pointFMo5583g2 = this.f5341l.mo5583g();
        GradientColor_2 c1106cMo5583g = this.f5339j.mo5583g();
        int[] iArrM5552a = m5552a(c1106cMo5583g.m5669b());
        float[] fArrM5668a = c1106cMo5583g.m5668a();
        RadialGradient radialGradient2 = new RadialGradient(pointFMo5583g.x, pointFMo5583g.y, (float) Math.hypot(pointFMo5583g2.x - r7, pointFMo5583g2.y - r8), iArrM5552a, fArrM5668a, Shader.TileMode.CLAMP);
        this.f5335f.put(jM5555e, radialGradient2);
        return radialGradient2;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int m5555e() {
        int iRound = Math.round(this.f5340k.m5584h() * this.f5338i);
        int iRound2 = Math.round(this.f5341l.m5584h() * this.f5338i);
        int iRound3 = Math.round(this.f5339j.m5584h() * this.f5338i);
        int OplusGLSurfaceView_13 = iRound != 0 ? 527 * iRound : 17;
        if (iRound2 != 0) {
            OplusGLSurfaceView_13 = OplusGLSurfaceView_13 * 31 * iRound2;
        }
        return iRound3 != 0 ? OplusGLSurfaceView_13 * 31 * iRound3 : OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int[] m5552a(int[] iArr) {
        ValueCallbackKeyframeAnimation_2 c1083p = this.f5342m;
        if (c1083p != null) {
            Integer[] numArr = (Integer[]) c1083p.mo5583g();
            int OplusGLSurfaceView_13 = 0;
            if (iArr.length == numArr.length) {
                while (OplusGLSurfaceView_13 < iArr.length) {
                    iArr[OplusGLSurfaceView_13] = numArr[OplusGLSurfaceView_13].intValue();
                    OplusGLSurfaceView_13++;
                }
            } else {
                iArr = new int[numArr.length];
                while (OplusGLSurfaceView_13 < numArr.length) {
                    iArr[OplusGLSurfaceView_13] = numArr[OplusGLSurfaceView_13].intValue();
                    OplusGLSurfaceView_13++;
                }
            }
        }
        return iArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.p080a.p081a.BaseStrokeContent_3, com.airbnb.lottie.p084c.KeyPathElement_2
    /* renamed from: PlatformImplementations.kt_3 */
    public <T> void mo5534a(T t, LottieValueCallback<T> c1199c) {
        super.mo5534a((GradientStrokeContent_2) t, (LottieValueCallback<GradientStrokeContent_2>) c1199c);
        if (t == InterfaceC1205k.f5927F) {
            if (this.f5342m != null) {
                this.f5268a.m5778b(this.f5342m);
            }
            if (c1199c == null) {
                this.f5342m = null;
                return;
            }
            this.f5342m = new ValueCallbackKeyframeAnimation_2(c1199c);
            this.f5342m.m5576a(this);
            this.f5268a.m5774a(this.f5342m);
        }
    }
}
