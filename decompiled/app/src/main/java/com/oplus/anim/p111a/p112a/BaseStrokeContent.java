package com.oplus.anim.p111a.p112a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import com.oplus.anim.EffectiveAnimationDrawable;
import com.oplus.anim.L;
import com.oplus.anim.InterfaceC2361d;
import com.oplus.anim.p111a.LPaint;
import com.oplus.anim.p111a.p113b.BaseKeyframeAnimation;
import com.oplus.anim.p111a.p113b.FloatKeyframeAnimation;
import com.oplus.anim.p111a.p113b.IntegerKeyframeAnimation;
import com.oplus.anim.p111a.p113b.ValueCallbackKeyframeAnimation;
import com.oplus.anim.p115c.KeyPath;
import com.oplus.anim.p115c.p116a.AnimatableFloatValue;
import com.oplus.anim.p115c.p116a.AnimatableIntegerValue;
import com.oplus.anim.p115c.p118c.BaseLayer;
import com.oplus.anim.p121f.MiscUtils;
import com.oplus.anim.p121f.Utils_2;
import com.oplus.anim.p122g.EffectiveValueCallback;
import java.util.ArrayList;
import java.util.List;

/* compiled from: BaseStrokeContent.java */
/* renamed from: com.oplus.anim.PlatformImplementations.kt_3.PlatformImplementations.kt_3.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public abstract class BaseStrokeContent implements DrawingContent, KeyPathElementContent, BaseKeyframeAnimation.PlatformImplementations.kt_3 {

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final EffectiveAnimationDrawable f9869f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private final BaseLayer f9870g;

    /* renamed from: OplusGLSurfaceView_13 */
    private final float[] f9872i;

    /* renamed from: OplusGLSurfaceView_15 */
    private final BaseKeyframeAnimation<?, Float> f9873j;

    /* renamed from: OplusGLSurfaceView_5 */
    private final BaseKeyframeAnimation<?, Integer> f9874k;

    /* renamed from: OplusGLSurfaceView_14 */
    private final List<BaseKeyframeAnimation<?, Float>> f9875l;

    /* renamed from: OplusGLSurfaceView_6 */
    private final BaseKeyframeAnimation<?, Float> f9876m;

    /* renamed from: OplusGLSurfaceView_11 */
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> f9877n;

    /* renamed from: PlatformImplementations.kt_3 */
    final Paint f9864a = new LPaint(1);

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final PathMeasure f9865b = new PathMeasure();

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final Path f9866c = new Path();

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final Path f9867d = new Path();

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final RectF f9868e = new RectF();

    /* renamed from: COUIBaseListPopupWindow_10 */
    private final List<PlatformImplementations.kt_3> f9871h = new ArrayList();

    BaseStrokeContent(EffectiveAnimationDrawable c2309b, BaseLayer abstractC2347a, Paint.Cap cap, Paint.Join join, float COUIBaseListPopupWindow_12, AnimatableIntegerValue c2317d, AnimatableFloatValue c2315b, List<AnimatableFloatValue> list, AnimatableFloatValue c2315b2) {
        this.f9869f = c2309b;
        this.f9870g = abstractC2347a;
        this.f9864a.setStyle(Paint.Style.STROKE);
        this.f9864a.setStrokeCap(cap);
        this.f9864a.setStrokeJoin(join);
        this.f9864a.setStrokeMiter(COUIBaseListPopupWindow_12);
        this.f9874k = c2317d.mo8957a();
        this.f9873j = c2315b.mo8957a();
        if (c2315b2 == null) {
            this.f9876m = null;
        } else {
            this.f9876m = c2315b2.mo8957a();
        }
        this.f9875l = new ArrayList(list.size());
        this.f9872i = new float[list.size()];
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < list.size(); OplusGLSurfaceView_13++) {
            this.f9875l.add(list.get(OplusGLSurfaceView_13).mo8957a());
        }
        abstractC2347a.m9082a(this.f9874k);
        abstractC2347a.m9082a(this.f9873j);
        for (int i2 = 0; i2 < this.f9875l.size(); i2++) {
            abstractC2347a.m9082a(this.f9875l.get(i2));
        }
        BaseKeyframeAnimation<?, Float> abstractC2293a = this.f9876m;
        if (abstractC2293a != null) {
            abstractC2347a.m9082a(abstractC2293a);
        }
        this.f9874k.m8847a(this);
        this.f9873j.m8847a(this);
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.f9875l.get(i3).m8847a(this);
        }
        BaseKeyframeAnimation<?, Float> abstractC2293a2 = this.f9876m;
        if (abstractC2293a2 != null) {
            abstractC2293a2.m8847a(this);
        }
    }

    @Override // com.oplus.anim.p111a.p113b.BaseKeyframeAnimation.PlatformImplementations.kt_3
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo8806a() {
        this.f9869f.invalidateSelf();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0055  */
    @Override // com.oplus.anim.p111a.p112a.Content
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void mo8811a(java.util.List<com.oplus.anim.p111a.p112a.Content> r8, java.util.List<com.oplus.anim.p111a.p112a.Content> r9) {
        /*
            r7 = this;
            int r0 = r8.size()
            int r0 = r0 + (-1)
            r1 = 0
            r2 = r1
        L8:
            if (r0 < 0) goto L22
            java.lang.Object r3 = r8.get(r0)
            com.oplus.anim.PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3 r3 = (com.oplus.anim.p111a.p112a.Content) r3
            boolean r4 = r3 instanceof com.oplus.anim.p111a.p112a.TrimPathContent
            if (r4 == 0) goto L1f
            com.oplus.anim.PlatformImplementations.kt_3.PlatformImplementations.kt_3.s r3 = (com.oplus.anim.p111a.p112a.TrimPathContent) r3
            com.oplus.anim.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_4.q$PlatformImplementations.kt_3 r4 = r3.m8838c()
            com.oplus.anim.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_4.q$PlatformImplementations.kt_3 r5 = com.oplus.anim.p115c.p117b.ShapeTrimPath.PlatformImplementations.kt_3.INDIVIDUALLY
            if (r4 != r5) goto L1f
            r2 = r3
        L1f:
            int r0 = r0 + (-1)
            goto L8
        L22:
            if (r2 == 0) goto L27
            r2.m8837a(r7)
        L27:
            int r8 = r9.size()
            int r8 = r8 + (-1)
            r0 = r1
        L2e:
            if (r8 < 0) goto L6c
            java.lang.Object r3 = r9.get(r8)
            com.oplus.anim.PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3 r3 = (com.oplus.anim.p111a.p112a.Content) r3
            boolean r4 = r3 instanceof com.oplus.anim.p111a.p112a.TrimPathContent
            if (r4 == 0) goto L55
            r4 = r3
            com.oplus.anim.PlatformImplementations.kt_3.PlatformImplementations.kt_3.s r4 = (com.oplus.anim.p111a.p112a.TrimPathContent) r4
            com.oplus.anim.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_4.q$PlatformImplementations.kt_3 r5 = r4.m8838c()
            com.oplus.anim.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_4.q$PlatformImplementations.kt_3 r6 = com.oplus.anim.p115c.p117b.ShapeTrimPath.PlatformImplementations.kt_3.INDIVIDUALLY
            if (r5 != r6) goto L55
            if (r0 == 0) goto L4c
            java.util.List<com.oplus.anim.PlatformImplementations.kt_3.PlatformImplementations.kt_3.PlatformImplementations.kt_3$PlatformImplementations.kt_3> r3 = r7.f9871h
            r3.add(r0)
        L4c:
            com.oplus.anim.PlatformImplementations.kt_3.PlatformImplementations.kt_3.PlatformImplementations.kt_3$PlatformImplementations.kt_3 r0 = new com.oplus.anim.PlatformImplementations.kt_3.PlatformImplementations.kt_3.PlatformImplementations.kt_3$PlatformImplementations.kt_3
            r0.<init>(r4)
            r4.m8837a(r7)
            goto L69
        L55:
            boolean r4 = r3 instanceof com.oplus.anim.p111a.p112a.PathContent
            if (r4 == 0) goto L69
            if (r0 != 0) goto L60
            com.oplus.anim.PlatformImplementations.kt_3.PlatformImplementations.kt_3.PlatformImplementations.kt_3$PlatformImplementations.kt_3 r0 = new com.oplus.anim.PlatformImplementations.kt_3.PlatformImplementations.kt_3.PlatformImplementations.kt_3$PlatformImplementations.kt_3
            r0.<init>(r2)
        L60:
            java.util.List r4 = com.oplus.anim.p111a.p112a.BaseStrokeContent.PlatformImplementations.kt_3.m8812a(r0)
            com.oplus.anim.PlatformImplementations.kt_3.PlatformImplementations.kt_3.OplusGLSurfaceView_6 r3 = (com.oplus.anim.p111a.p112a.PathContent) r3
            r4.add(r3)
        L69:
            int r8 = r8 + (-1)
            goto L2e
        L6c:
            if (r0 == 0) goto L73
            java.util.List<com.oplus.anim.PlatformImplementations.kt_3.PlatformImplementations.kt_3.PlatformImplementations.kt_3$PlatformImplementations.kt_3> r7 = r7.f9871h
            r7.add(r0)
        L73:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.anim.p111a.p112a.BaseStrokeContent.mo8811a(java.util.List, java.util.List):void");
    }

    @Override // com.oplus.anim.p111a.p112a.DrawingContent
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo8807a(Canvas canvas, Matrix matrix, int OplusGLSurfaceView_13) {
        L.m9349c("StrokeContent#draw");
        this.f9864a.setAlpha(MiscUtils.m9278a((int) ((((OplusGLSurfaceView_13 / 255.0f) * ((IntegerKeyframeAnimation) this.f9874k).m8865i()) / 100.0f) * 255.0f), 0, 255));
        this.f9864a.setStrokeWidth(((FloatKeyframeAnimation) this.f9873j).m8861i() * Utils_2.m9289a(matrix));
        if (this.f9864a.getStrokeWidth() <= 0.0f) {
            L.m9350d("StrokeContent#draw");
            return;
        }
        m8805a(matrix);
        BaseKeyframeAnimation<ColorFilter, ColorFilter> abstractC2293a = this.f9877n;
        if (abstractC2293a != null) {
            this.f9864a.setColorFilter(abstractC2293a.mo8854g());
        }
        for (int i2 = 0; i2 < this.f9871h.size(); i2++) {
            PlatformImplementations.kt_3 aVar = this.f9871h.get(i2);
            if (aVar.f9879b != null) {
                m8804a(canvas, aVar, matrix);
            } else {
                L.m9349c("StrokeContent#buildPath");
                this.f9866c.reset();
                for (int size = aVar.f9878a.size() - 1; size >= 0; size--) {
                    this.f9866c.addPath(((PathContent) aVar.f9878a.get(size)).mo8821e(), matrix);
                }
                L.m9350d("StrokeContent#buildPath");
                L.m9349c("StrokeContent#drawPath");
                canvas.drawPath(this.f9866c, this.f9864a);
                L.m9350d("StrokeContent#drawPath");
            }
        }
        L.m9350d("StrokeContent#draw");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00f6  */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void m8804a(android.graphics.Canvas r13, com.oplus.anim.p111a.p112a.BaseStrokeContent.PlatformImplementations.kt_3 r14, android.graphics.Matrix r15) {
        /*
            Method dump skipped, instructions count: 312
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.anim.p111a.p112a.BaseStrokeContent.m8804a(android.graphics.Canvas, com.oplus.anim.PlatformImplementations.kt_3.PlatformImplementations.kt_3.PlatformImplementations.kt_3$PlatformImplementations.kt_3, android.graphics.Matrix):void");
    }

    @Override // com.oplus.anim.p111a.p112a.DrawingContent
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo8808a(RectF rectF, Matrix matrix, boolean z) {
        L.m9349c("StrokeContent#getBounds");
        this.f9866c.reset();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f9871h.size(); OplusGLSurfaceView_13++) {
            PlatformImplementations.kt_3 aVar = this.f9871h.get(OplusGLSurfaceView_13);
            for (int i2 = 0; i2 < aVar.f9878a.size(); i2++) {
                this.f9866c.addPath(((PathContent) aVar.f9878a.get(i2)).mo8821e(), matrix);
            }
        }
        this.f9866c.computeBounds(this.f9868e, false);
        float fM8861i = ((FloatKeyframeAnimation) this.f9873j).m8861i();
        RectF rectF2 = this.f9868e;
        float COUIBaseListPopupWindow_12 = fM8861i / 2.0f;
        rectF2.set(rectF2.left - COUIBaseListPopupWindow_12, this.f9868e.top - COUIBaseListPopupWindow_12, this.f9868e.right + COUIBaseListPopupWindow_12, this.f9868e.bottom + COUIBaseListPopupWindow_12);
        rectF.set(this.f9868e);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        L.m9350d("StrokeContent#getBounds");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m8805a(Matrix matrix) {
        L.m9349c("StrokeContent#applyDashPattern");
        if (this.f9875l.isEmpty()) {
            L.m9350d("StrokeContent#applyDashPattern");
            return;
        }
        float fM9289a = Utils_2.m9289a(matrix);
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f9875l.size(); OplusGLSurfaceView_13++) {
            this.f9872i[OplusGLSurfaceView_13] = this.f9875l.get(OplusGLSurfaceView_13).mo8854g().floatValue();
            if (OplusGLSurfaceView_13 % 2 == 0) {
                float[] fArr = this.f9872i;
                if (fArr[OplusGLSurfaceView_13] < 1.0f) {
                    fArr[OplusGLSurfaceView_13] = 1.0f;
                }
            } else {
                float[] fArr2 = this.f9872i;
                if (fArr2[OplusGLSurfaceView_13] < 0.1f) {
                    fArr2[OplusGLSurfaceView_13] = 0.1f;
                }
            }
            float[] fArr3 = this.f9872i;
            fArr3[OplusGLSurfaceView_13] = fArr3[OplusGLSurfaceView_13] * fM9289a;
        }
        BaseKeyframeAnimation<?, Float> abstractC2293a = this.f9876m;
        this.f9864a.setPathEffect(new DashPathEffect(this.f9872i, abstractC2293a == null ? 0.0f : abstractC2293a.mo8854g().floatValue()));
        L.m9350d("StrokeContent#applyDashPattern");
    }

    @Override // com.oplus.anim.p115c.KeyPathElement
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo8809a(KeyPath c2357f, int OplusGLSurfaceView_13, List<KeyPath> list, KeyPath c2357f2) {
        MiscUtils.m9281a(c2357f, OplusGLSurfaceView_13, list, c2357f2, this);
    }

    @Override // com.oplus.anim.p115c.KeyPathElement
    /* renamed from: PlatformImplementations.kt_3 */
    public <T> void mo8810a(T t, EffectiveValueCallback<T> c2412b) {
        if (t == InterfaceC2361d.f10322d) {
            this.f9874k.m8848a((EffectiveValueCallback<Integer>) c2412b);
            return;
        }
        if (t == InterfaceC2361d.f10331m) {
            this.f9873j.m8848a((EffectiveValueCallback<Float>) c2412b);
            return;
        }
        if (t == InterfaceC2361d.f10344z) {
            if (c2412b == null) {
                this.f9877n = null;
                return;
            }
            this.f9877n = new ValueCallbackKeyframeAnimation(c2412b);
            this.f9877n.m8847a(this);
            this.f9870g.m9082a(this.f9877n);
        }
    }

    /* compiled from: BaseStrokeContent.java */
    /* renamed from: com.oplus.anim.PlatformImplementations.kt_3.PlatformImplementations.kt_3.PlatformImplementations.kt_3$PlatformImplementations.kt_3 */
    private static final class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        private final List<PathContent> f9878a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private final TrimPathContent f9879b;

        private PlatformImplementations.kt_3(TrimPathContent c2292s) {
            this.f9878a = new ArrayList();
            this.f9879b = c2292s;
        }
    }
}
