package com.airbnb.lottie.p080a.p081a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import com.airbnb.lottie.L_2;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.InterfaceC1205k;
import com.airbnb.lottie.p080a.LPaint_2;
import com.airbnb.lottie.p080a.p082b.BaseKeyframeAnimation_3;
import com.airbnb.lottie.p080a.p082b.FloatKeyframeAnimation_2;
import com.airbnb.lottie.p080a.p082b.IntegerKeyframeAnimation_2;
import com.airbnb.lottie.p080a.p082b.ValueCallbackKeyframeAnimation_2;
import com.airbnb.lottie.p084c.KeyPath_2;
import com.airbnb.lottie.p084c.p085a.AnimatableFloatValue_2;
import com.airbnb.lottie.p084c.p085a.AnimatableIntegerValue_2;
import com.airbnb.lottie.p084c.p087c.BaseLayer_3;
import com.airbnb.lottie.p091f.MiscUtils_2;
import com.airbnb.lottie.p091f.Utils_4;
import com.airbnb.lottie.p092g.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

/* compiled from: BaseStrokeContent.java */
/* renamed from: com.airbnb.lottie.PlatformImplementations.kt_3.PlatformImplementations.kt_3.PlatformImplementations.kt_3 */
/* loaded from: classes.dex */
public abstract class BaseStrokeContent_3 implements DrawingContent_2, KeyPathElementContent_2, BaseKeyframeAnimation_3.PlatformImplementations.kt_3 {

    /* renamed from: PlatformImplementations.kt_3 */
    protected final BaseLayer_3 f5268a;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private final LottieDrawable f5274g;

    /* renamed from: OplusGLSurfaceView_13 */
    private final float[] f5276i;

    /* renamed from: OplusGLSurfaceView_15 */
    private final BaseKeyframeAnimation_3<?, Float> f5277j;

    /* renamed from: OplusGLSurfaceView_5 */
    private final BaseKeyframeAnimation_3<?, Integer> f5278k;

    /* renamed from: OplusGLSurfaceView_14 */
    private final List<BaseKeyframeAnimation_3<?, Float>> f5279l;

    /* renamed from: OplusGLSurfaceView_6 */
    private final BaseKeyframeAnimation_3<?, Float> f5280m;

    /* renamed from: OplusGLSurfaceView_11 */
    private BaseKeyframeAnimation_3<ColorFilter, ColorFilter> f5281n;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final PathMeasure f5270c = new PathMeasure();

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final Path f5271d = new Path();

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final Path f5272e = new Path();

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final RectF f5273f = new RectF();

    /* renamed from: COUIBaseListPopupWindow_10 */
    private final List<PlatformImplementations.kt_3> f5275h = new ArrayList();

    /* renamed from: IntrinsicsJvm.kt_4 */
    final Paint f5269b = new LPaint_2(1);

    BaseStrokeContent_3(LottieDrawable c1187f, BaseLayer_3 abstractC1122a, Paint.Cap cap, Paint.Join join, float COUIBaseListPopupWindow_12, AnimatableIntegerValue_2 c1092d, AnimatableFloatValue_2 c1090b, List<AnimatableFloatValue_2> list, AnimatableFloatValue_2 c1090b2) {
        this.f5274g = c1187f;
        this.f5268a = abstractC1122a;
        this.f5269b.setStyle(Paint.Style.STROKE);
        this.f5269b.setStrokeCap(cap);
        this.f5269b.setStrokeJoin(join);
        this.f5269b.setStrokeMiter(COUIBaseListPopupWindow_12);
        this.f5278k = c1092d.mo5647a();
        this.f5277j = c1090b.mo5647a();
        if (c1090b2 == null) {
            this.f5280m = null;
        } else {
            this.f5280m = c1090b2.mo5647a();
        }
        this.f5279l = new ArrayList(list.size());
        this.f5276i = new float[list.size()];
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < list.size(); OplusGLSurfaceView_13++) {
            this.f5279l.add(list.get(OplusGLSurfaceView_13).mo5647a());
        }
        abstractC1122a.m5774a(this.f5278k);
        abstractC1122a.m5774a(this.f5277j);
        for (int i2 = 0; i2 < this.f5279l.size(); i2++) {
            abstractC1122a.m5774a(this.f5279l.get(i2));
        }
        BaseKeyframeAnimation_3<?, Float> abstractC1068a = this.f5280m;
        if (abstractC1068a != null) {
            abstractC1122a.m5774a(abstractC1068a);
        }
        this.f5278k.m5576a(this);
        this.f5277j.m5576a(this);
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.f5279l.get(i3).m5576a(this);
        }
        BaseKeyframeAnimation_3<?, Float> abstractC1068a2 = this.f5280m;
        if (abstractC1068a2 != null) {
            abstractC1068a2.m5576a(this);
        }
    }

    @Override // com.airbnb.lottie.p080a.p082b.BaseKeyframeAnimation_3.PlatformImplementations.kt_3
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo5530a() {
        this.f5274g.invalidateSelf();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0055  */
    @Override // com.airbnb.lottie.p080a.p081a.Content_2
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void mo5535a(java.util.List<com.airbnb.lottie.p080a.p081a.Content_2> r8, java.util.List<com.airbnb.lottie.p080a.p081a.Content_2> r9) {
        /*
            r7 = this;
            int r0 = r8.size()
            int r0 = r0 + (-1)
            r1 = 0
            r2 = r1
        L8:
            if (r0 < 0) goto L22
            java.lang.Object r3 = r8.get(r0)
            com.airbnb.lottie.PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3 r3 = (com.airbnb.lottie.p080a.p081a.Content_2) r3
            boolean r4 = r3 instanceof com.airbnb.lottie.p080a.p081a.TrimPathContent_2
            if (r4 == 0) goto L1f
            com.airbnb.lottie.PlatformImplementations.kt_3.PlatformImplementations.kt_3.s r3 = (com.airbnb.lottie.p080a.p081a.TrimPathContent_2) r3
            com.airbnb.lottie.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_4.q$PlatformImplementations.kt_3 r4 = r3.m5565c()
            com.airbnb.lottie.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_4.q$PlatformImplementations.kt_3 r5 = com.airbnb.lottie.p084c.p086b.ShapeTrimPath_3.PlatformImplementations.kt_3.INDIVIDUALLY
            if (r4 != r5) goto L1f
            r2 = r3
        L1f:
            int r0 = r0 + (-1)
            goto L8
        L22:
            if (r2 == 0) goto L27
            r2.m5564a(r7)
        L27:
            int r8 = r9.size()
            int r8 = r8 + (-1)
            r0 = r1
        L2e:
            if (r8 < 0) goto L6c
            java.lang.Object r3 = r9.get(r8)
            com.airbnb.lottie.PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3 r3 = (com.airbnb.lottie.p080a.p081a.Content_2) r3
            boolean r4 = r3 instanceof com.airbnb.lottie.p080a.p081a.TrimPathContent_2
            if (r4 == 0) goto L55
            r4 = r3
            com.airbnb.lottie.PlatformImplementations.kt_3.PlatformImplementations.kt_3.s r4 = (com.airbnb.lottie.p080a.p081a.TrimPathContent_2) r4
            com.airbnb.lottie.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_4.q$PlatformImplementations.kt_3 r5 = r4.m5565c()
            com.airbnb.lottie.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_4.q$PlatformImplementations.kt_3 r6 = com.airbnb.lottie.p084c.p086b.ShapeTrimPath_3.PlatformImplementations.kt_3.INDIVIDUALLY
            if (r5 != r6) goto L55
            if (r0 == 0) goto L4c
            java.util.List<com.airbnb.lottie.PlatformImplementations.kt_3.PlatformImplementations.kt_3.PlatformImplementations.kt_3$PlatformImplementations.kt_3> r3 = r7.f5275h
            r3.add(r0)
        L4c:
            com.airbnb.lottie.PlatformImplementations.kt_3.PlatformImplementations.kt_3.PlatformImplementations.kt_3$PlatformImplementations.kt_3 r0 = new com.airbnb.lottie.PlatformImplementations.kt_3.PlatformImplementations.kt_3.PlatformImplementations.kt_3$PlatformImplementations.kt_3
            r0.<init>(r4)
            r4.m5564a(r7)
            goto L69
        L55:
            boolean r4 = r3 instanceof com.airbnb.lottie.p080a.p081a.PathContent_2
            if (r4 == 0) goto L69
            if (r0 != 0) goto L60
            com.airbnb.lottie.PlatformImplementations.kt_3.PlatformImplementations.kt_3.PlatformImplementations.kt_3$PlatformImplementations.kt_3 r0 = new com.airbnb.lottie.PlatformImplementations.kt_3.PlatformImplementations.kt_3.PlatformImplementations.kt_3$PlatformImplementations.kt_3
            r0.<init>(r2)
        L60:
            java.util.List r4 = com.airbnb.lottie.p080a.p081a.BaseStrokeContent_3.PlatformImplementations.kt_3.m5536a(r0)
            com.airbnb.lottie.PlatformImplementations.kt_3.PlatformImplementations.kt_3.OplusGLSurfaceView_6 r3 = (com.airbnb.lottie.p080a.p081a.PathContent_2) r3
            r4.add(r3)
        L69:
            int r8 = r8 + (-1)
            goto L2e
        L6c:
            if (r0 == 0) goto L73
            java.util.List<com.airbnb.lottie.PlatformImplementations.kt_3.PlatformImplementations.kt_3.PlatformImplementations.kt_3$PlatformImplementations.kt_3> r7 = r7.f5275h
            r7.add(r0)
        L73:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.p080a.p081a.BaseStrokeContent_3.mo5535a(java.util.List, java.util.List):void");
    }

    @Override // com.airbnb.lottie.p080a.p081a.DrawingContent_2
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo5531a(Canvas canvas, Matrix matrix, int OplusGLSurfaceView_13) {
        L_2.m5637a("StrokeContent#draw");
        if (Utils_4.m6152b(matrix)) {
            L_2.m5638b("StrokeContent#draw");
            return;
        }
        this.f5269b.setAlpha(MiscUtils_2.m6131a((int) ((((OplusGLSurfaceView_13 / 255.0f) * ((IntegerKeyframeAnimation_2) this.f5278k).m5601i()) / 100.0f) * 255.0f), 0, 255));
        this.f5269b.setStrokeWidth(((FloatKeyframeAnimation_2) this.f5277j).m5597i() * Utils_4.m6141a(matrix));
        if (this.f5269b.getStrokeWidth() <= 0.0f) {
            L_2.m5638b("StrokeContent#draw");
            return;
        }
        m5529a(matrix);
        BaseKeyframeAnimation_3<ColorFilter, ColorFilter> abstractC1068a = this.f5281n;
        if (abstractC1068a != null) {
            this.f5269b.setColorFilter(abstractC1068a.mo5583g());
        }
        for (int i2 = 0; i2 < this.f5275h.size(); i2++) {
            PlatformImplementations.kt_3 aVar = this.f5275h.get(i2);
            if (aVar.f5283b != null) {
                m5528a(canvas, aVar, matrix);
            } else {
                L_2.m5637a("StrokeContent#buildPath");
                this.f5271d.reset();
                for (int size = aVar.f5282a.size() - 1; size >= 0; size--) {
                    this.f5271d.addPath(((PathContent_2) aVar.f5282a.get(size)).mo5546e(), matrix);
                }
                L_2.m5638b("StrokeContent#buildPath");
                L_2.m5637a("StrokeContent#drawPath");
                canvas.drawPath(this.f5271d, this.f5269b);
                L_2.m5638b("StrokeContent#drawPath");
            }
        }
        L_2.m5638b("StrokeContent#draw");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00f6  */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void m5528a(android.graphics.Canvas r13, com.airbnb.lottie.p080a.p081a.BaseStrokeContent_3.PlatformImplementations.kt_3 r14, android.graphics.Matrix r15) {
        /*
            Method dump skipped, instructions count: 312
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.p080a.p081a.BaseStrokeContent_3.m5528a(android.graphics.Canvas, com.airbnb.lottie.PlatformImplementations.kt_3.PlatformImplementations.kt_3.PlatformImplementations.kt_3$PlatformImplementations.kt_3, android.graphics.Matrix):void");
    }

    @Override // com.airbnb.lottie.p080a.p081a.DrawingContent_2
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo5532a(RectF rectF, Matrix matrix, boolean z) {
        L_2.m5637a("StrokeContent#getBounds");
        this.f5271d.reset();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f5275h.size(); OplusGLSurfaceView_13++) {
            PlatformImplementations.kt_3 aVar = this.f5275h.get(OplusGLSurfaceView_13);
            for (int i2 = 0; i2 < aVar.f5282a.size(); i2++) {
                this.f5271d.addPath(((PathContent_2) aVar.f5282a.get(i2)).mo5546e(), matrix);
            }
        }
        this.f5271d.computeBounds(this.f5273f, false);
        float fM5597i = ((FloatKeyframeAnimation_2) this.f5277j).m5597i();
        RectF rectF2 = this.f5273f;
        float COUIBaseListPopupWindow_12 = fM5597i / 2.0f;
        rectF2.set(rectF2.left - COUIBaseListPopupWindow_12, this.f5273f.top - COUIBaseListPopupWindow_12, this.f5273f.right + COUIBaseListPopupWindow_12, this.f5273f.bottom + COUIBaseListPopupWindow_12);
        rectF.set(this.f5273f);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        L_2.m5638b("StrokeContent#getBounds");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m5529a(Matrix matrix) {
        L_2.m5637a("StrokeContent#applyDashPattern");
        if (this.f5279l.isEmpty()) {
            L_2.m5638b("StrokeContent#applyDashPattern");
            return;
        }
        float fM6141a = Utils_4.m6141a(matrix);
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f5279l.size(); OplusGLSurfaceView_13++) {
            this.f5276i[OplusGLSurfaceView_13] = this.f5279l.get(OplusGLSurfaceView_13).mo5583g().floatValue();
            if (OplusGLSurfaceView_13 % 2 == 0) {
                float[] fArr = this.f5276i;
                if (fArr[OplusGLSurfaceView_13] < 1.0f) {
                    fArr[OplusGLSurfaceView_13] = 1.0f;
                }
            } else {
                float[] fArr2 = this.f5276i;
                if (fArr2[OplusGLSurfaceView_13] < 0.1f) {
                    fArr2[OplusGLSurfaceView_13] = 0.1f;
                }
            }
            float[] fArr3 = this.f5276i;
            fArr3[OplusGLSurfaceView_13] = fArr3[OplusGLSurfaceView_13] * fM6141a;
        }
        BaseKeyframeAnimation_3<?, Float> abstractC1068a = this.f5280m;
        this.f5269b.setPathEffect(new DashPathEffect(this.f5276i, abstractC1068a == null ? 0.0f : fM6141a * abstractC1068a.mo5583g().floatValue()));
        L_2.m5638b("StrokeContent#applyDashPattern");
    }

    @Override // com.airbnb.lottie.p084c.KeyPathElement_2
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo5533a(KeyPath_2 c1131e, int OplusGLSurfaceView_13, List<KeyPath_2> list, KeyPath_2 c1131e2) {
        MiscUtils_2.m6134a(c1131e, OplusGLSurfaceView_13, list, c1131e2, this);
    }

    @Override // com.airbnb.lottie.p084c.KeyPathElement_2
    /* renamed from: PlatformImplementations.kt_3 */
    public <T> void mo5534a(T t, LottieValueCallback<T> c1199c) {
        if (t == InterfaceC1205k.f5931d) {
            this.f5278k.m5577a((LottieValueCallback<Integer>) c1199c);
            return;
        }
        if (t == InterfaceC1205k.f5944q) {
            this.f5277j.m5577a((LottieValueCallback<Float>) c1199c);
            return;
        }
        if (t == InterfaceC1205k.f5926E) {
            BaseKeyframeAnimation_3<ColorFilter, ColorFilter> abstractC1068a = this.f5281n;
            if (abstractC1068a != null) {
                this.f5268a.m5778b(abstractC1068a);
            }
            if (c1199c == null) {
                this.f5281n = null;
                return;
            }
            this.f5281n = new ValueCallbackKeyframeAnimation_2(c1199c);
            this.f5281n.m5576a(this);
            this.f5268a.m5774a(this.f5281n);
        }
    }

    /* compiled from: BaseStrokeContent.java */
    /* renamed from: com.airbnb.lottie.PlatformImplementations.kt_3.PlatformImplementations.kt_3.PlatformImplementations.kt_3$PlatformImplementations.kt_3 */
    private static final class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        private final List<PathContent_2> f5282a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private final TrimPathContent_2 f5283b;

        private PlatformImplementations.kt_3(TrimPathContent_2 c1067s) {
            this.f5282a = new ArrayList();
            this.f5283b = c1067s;
        }
    }
}
