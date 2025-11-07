package com.airbnb.lottie.p080a.p081a;

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
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.L_2;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.InterfaceC1205k;
import com.airbnb.lottie.p080a.LPaint_2;
import com.airbnb.lottie.p080a.p082b.BaseKeyframeAnimation_3;
import com.airbnb.lottie.p080a.p082b.ValueCallbackKeyframeAnimation_2;
import com.airbnb.lottie.p084c.KeyPath_2;
import com.airbnb.lottie.p084c.p086b.GradientColor_2;
import com.airbnb.lottie.p084c.p086b.GradientFill_2;
import com.airbnb.lottie.p084c.p086b.GradientType_2;
import com.airbnb.lottie.p084c.p087c.BaseLayer_3;
import com.airbnb.lottie.p091f.MiscUtils_2;
import com.airbnb.lottie.p092g.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

/* compiled from: GradientFillContent.java */
/* renamed from: com.airbnb.lottie.PlatformImplementations.kt_3.PlatformImplementations.kt_3.COUIBaseListPopupWindow_10 */
/* loaded from: classes.dex */
public class GradientFillContent_2 implements DrawingContent_2, KeyPathElementContent_2, BaseKeyframeAnimation_3.PlatformImplementations.kt_3 {

    /* renamed from: PlatformImplementations.kt_3 */
    private final String f5314a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final boolean f5315b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final BaseLayer_3 f5316c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final LongSparseArray<LinearGradient> f5317d = new LongSparseArray<>();

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final LongSparseArray<RadialGradient> f5318e = new LongSparseArray<>();

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final Path f5319f = new Path();

    /* renamed from: COUIBaseListPopupWindow_11 */
    private final Paint f5320g = new LPaint_2(1);

    /* renamed from: COUIBaseListPopupWindow_10 */
    private final RectF f5321h = new RectF();

    /* renamed from: OplusGLSurfaceView_13 */
    private final List<PathContent_2> f5322i = new ArrayList();

    /* renamed from: OplusGLSurfaceView_15 */
    private final GradientType_2 f5323j;

    /* renamed from: OplusGLSurfaceView_5 */
    private final BaseKeyframeAnimation_3<GradientColor_2, GradientColor_2> f5324k;

    /* renamed from: OplusGLSurfaceView_14 */
    private final BaseKeyframeAnimation_3<Integer, Integer> f5325l;

    /* renamed from: OplusGLSurfaceView_6 */
    private final BaseKeyframeAnimation_3<PointF, PointF> f5326m;

    /* renamed from: OplusGLSurfaceView_11 */
    private final BaseKeyframeAnimation_3<PointF, PointF> f5327n;

    /* renamed from: o */
    private BaseKeyframeAnimation_3<ColorFilter, ColorFilter> f5328o;

    /* renamed from: p */
    private ValueCallbackKeyframeAnimation_2 f5329p;

    /* renamed from: q */
    private final LottieDrawable f5330q;

    /* renamed from: r */
    private final int f5331r;

    public GradientFillContent_2(LottieDrawable c1187f, BaseLayer_3 abstractC1122a, GradientFill_2 c1107d) {
        this.f5316c = abstractC1122a;
        this.f5314a = c1107d.m5671a();
        this.f5315b = c1107d.m5678h();
        this.f5330q = c1187f;
        this.f5323j = c1107d.m5672b();
        this.f5319f.setFillType(c1107d.m5673c());
        this.f5331r = (int) (c1187f.m6080t().m5852e() / 32.0f);
        this.f5324k = c1107d.m5674d().mo5647a();
        this.f5324k.m5576a(this);
        abstractC1122a.m5774a(this.f5324k);
        this.f5325l = c1107d.m5675e().mo5647a();
        this.f5325l.m5576a(this);
        abstractC1122a.m5774a(this.f5325l);
        this.f5326m = c1107d.m5676f().mo5647a();
        this.f5326m.m5576a(this);
        abstractC1122a.m5774a(this.f5326m);
        this.f5327n = c1107d.m5677g().mo5647a();
        this.f5327n.m5576a(this);
        abstractC1122a.m5774a(this.f5327n);
    }

    @Override // com.airbnb.lottie.p080a.p082b.BaseKeyframeAnimation_3.PlatformImplementations.kt_3
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo5530a() {
        this.f5330q.invalidateSelf();
    }

    @Override // com.airbnb.lottie.p080a.p081a.Content_2
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo5535a(List<Content_2> list, List<Content_2> list2) {
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < list2.size(); OplusGLSurfaceView_13++) {
            Content_2 interfaceC1051c = list2.get(OplusGLSurfaceView_13);
            if (interfaceC1051c instanceof PathContent_2) {
                this.f5322i.add((PathContent_2) interfaceC1051c);
            }
        }
    }

    @Override // com.airbnb.lottie.p080a.p081a.DrawingContent_2
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo5531a(Canvas canvas, Matrix matrix, int OplusGLSurfaceView_13) {
        Shader shaderM5550d;
        if (this.f5315b) {
            return;
        }
        L_2.m5637a("GradientFillContent#draw");
        this.f5319f.reset();
        for (int i2 = 0; i2 < this.f5322i.size(); i2++) {
            this.f5319f.addPath(this.f5322i.get(i2).mo5546e(), matrix);
        }
        this.f5319f.computeBounds(this.f5321h, false);
        if (this.f5323j == GradientType_2.LINEAR) {
            shaderM5550d = m5549c();
        } else {
            shaderM5550d = m5550d();
        }
        shaderM5550d.setLocalMatrix(matrix);
        this.f5320g.setShader(shaderM5550d);
        BaseKeyframeAnimation_3<ColorFilter, ColorFilter> abstractC1068a = this.f5328o;
        if (abstractC1068a != null) {
            this.f5320g.setColorFilter(abstractC1068a.mo5583g());
        }
        this.f5320g.setAlpha(MiscUtils_2.m6131a((int) ((((OplusGLSurfaceView_13 / 255.0f) * this.f5325l.mo5583g().intValue()) / 100.0f) * 255.0f), 0, 255));
        canvas.drawPath(this.f5319f, this.f5320g);
        L_2.m5638b("GradientFillContent#draw");
    }

    @Override // com.airbnb.lottie.p080a.p081a.DrawingContent_2
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo5532a(RectF rectF, Matrix matrix, boolean z) {
        this.f5319f.reset();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f5322i.size(); OplusGLSurfaceView_13++) {
            this.f5319f.addPath(this.f5322i.get(OplusGLSurfaceView_13).mo5546e(), matrix);
        }
        this.f5319f.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // com.airbnb.lottie.p080a.p081a.Content_2
    /* renamed from: IntrinsicsJvm.kt_4 */
    public String mo5540b() {
        return this.f5314a;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private LinearGradient m5549c() {
        long jM5551e = m5551e();
        LinearGradient linearGradient = this.f5317d.get(jM5551e);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF pointFMo5583g = this.f5326m.mo5583g();
        PointF pointFMo5583g2 = this.f5327n.mo5583g();
        GradientColor_2 c1106cMo5583g = this.f5324k.mo5583g();
        LinearGradient linearGradient2 = new LinearGradient(pointFMo5583g.x, pointFMo5583g.y, pointFMo5583g2.x, pointFMo5583g2.y, m5548a(c1106cMo5583g.m5669b()), c1106cMo5583g.m5668a(), Shader.TileMode.CLAMP);
        this.f5317d.put(jM5551e, linearGradient2);
        return linearGradient2;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private RadialGradient m5550d() {
        long jM5551e = m5551e();
        RadialGradient radialGradient = this.f5318e.get(jM5551e);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF pointFMo5583g = this.f5326m.mo5583g();
        PointF pointFMo5583g2 = this.f5327n.mo5583g();
        GradientColor_2 c1106cMo5583g = this.f5324k.mo5583g();
        int[] iArrM5548a = m5548a(c1106cMo5583g.m5669b());
        float[] fArrM5668a = c1106cMo5583g.m5668a();
        float COUIBaseListPopupWindow_12 = pointFMo5583g.x;
        float f2 = pointFMo5583g.y;
        float fHypot = (float) Math.hypot(pointFMo5583g2.x - COUIBaseListPopupWindow_12, pointFMo5583g2.y - f2);
        if (fHypot <= 0.0f) {
            fHypot = 0.001f;
        }
        RadialGradient radialGradient2 = new RadialGradient(COUIBaseListPopupWindow_12, f2, fHypot, iArrM5548a, fArrM5668a, Shader.TileMode.CLAMP);
        this.f5318e.put(jM5551e, radialGradient2);
        return radialGradient2;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int m5551e() {
        int iRound = Math.round(this.f5326m.m5584h() * this.f5331r);
        int iRound2 = Math.round(this.f5327n.m5584h() * this.f5331r);
        int iRound3 = Math.round(this.f5324k.m5584h() * this.f5331r);
        int OplusGLSurfaceView_13 = iRound != 0 ? 527 * iRound : 17;
        if (iRound2 != 0) {
            OplusGLSurfaceView_13 = OplusGLSurfaceView_13 * 31 * iRound2;
        }
        return iRound3 != 0 ? OplusGLSurfaceView_13 * 31 * iRound3 : OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int[] m5548a(int[] iArr) {
        ValueCallbackKeyframeAnimation_2 c1083p = this.f5329p;
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

    @Override // com.airbnb.lottie.p084c.KeyPathElement_2
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo5533a(KeyPath_2 c1131e, int OplusGLSurfaceView_13, List<KeyPath_2> list, KeyPath_2 c1131e2) {
        MiscUtils_2.m6134a(c1131e, OplusGLSurfaceView_13, list, c1131e2, this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.p084c.KeyPathElement_2
    /* renamed from: PlatformImplementations.kt_3 */
    public <T> void mo5534a(T t, LottieValueCallback<T> c1199c) {
        if (t == InterfaceC1205k.f5931d) {
            this.f5325l.m5577a((LottieValueCallback<Integer>) c1199c);
            return;
        }
        if (t == InterfaceC1205k.f5926E) {
            BaseKeyframeAnimation_3<ColorFilter, ColorFilter> abstractC1068a = this.f5328o;
            if (abstractC1068a != null) {
                this.f5316c.m5778b(abstractC1068a);
            }
            if (c1199c == null) {
                this.f5328o = null;
                return;
            }
            this.f5328o = new ValueCallbackKeyframeAnimation_2(c1199c);
            this.f5328o.m5576a(this);
            this.f5316c.m5774a(this.f5328o);
            return;
        }
        if (t == InterfaceC1205k.f5927F) {
            ValueCallbackKeyframeAnimation_2 c1083p = this.f5329p;
            if (c1083p != null) {
                this.f5316c.m5778b(c1083p);
            }
            if (c1199c == null) {
                this.f5329p = null;
                return;
            }
            this.f5317d.clear();
            this.f5318e.clear();
            this.f5329p = new ValueCallbackKeyframeAnimation_2(c1199c);
            this.f5329p.m5576a(this);
            this.f5316c.m5774a(this.f5329p);
        }
    }
}
