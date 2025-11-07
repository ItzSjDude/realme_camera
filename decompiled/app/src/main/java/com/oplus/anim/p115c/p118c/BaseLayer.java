package com.oplus.anim.p115c.p118c;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import com.oplus.anim.EffectiveAnimationComposition;
import com.oplus.anim.EffectiveAnimationDrawable;
import com.oplus.anim.L;
import com.oplus.anim.p111a.LPaint;
import com.oplus.anim.p111a.p112a.Content;
import com.oplus.anim.p111a.p112a.DrawingContent;
import com.oplus.anim.p111a.p113b.BaseKeyframeAnimation;
import com.oplus.anim.p111a.p113b.FloatKeyframeAnimation;
import com.oplus.anim.p111a.p113b.MaskKeyframeAnimation;
import com.oplus.anim.p111a.p113b.TransformKeyframeAnimation;
import com.oplus.anim.p115c.KeyPath;
import com.oplus.anim.p115c.KeyPathElement;
import com.oplus.anim.p115c.p117b.Mask;
import com.oplus.anim.p115c.p117b.ShapeData;
import com.oplus.anim.p115c.p118c.Layer;
import com.oplus.anim.p121f.OplusLog;
import com.oplus.anim.p122g.EffectiveValueCallback;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: BaseLayer.java */
/* renamed from: com.oplus.anim.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public abstract class BaseLayer implements DrawingContent, BaseKeyframeAnimation.PlatformImplementations.kt_3, KeyPathElement {

    /* renamed from: IntrinsicsJvm.kt_4 */
    final EffectiveAnimationDrawable f10223b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    final Layer f10224c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    final TransformKeyframeAnimation f10225d;

    /* renamed from: p */
    private final String f10237p;

    /* renamed from: r */
    private MaskKeyframeAnimation f10239r;

    /* renamed from: s */
    private BaseLayer f10240s;

    /* renamed from: t */
    private BaseLayer f10241t;

    /* renamed from: u */
    private List<BaseLayer> f10242u;

    /* renamed from: PlatformImplementations.kt_3 */
    final Matrix f10222a = new Matrix();

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final Path f10226e = new Path();

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final Matrix f10227f = new Matrix();

    /* renamed from: COUIBaseListPopupWindow_11 */
    private final Paint f10228g = new LPaint(1);

    /* renamed from: COUIBaseListPopupWindow_10 */
    private final Paint f10229h = new LPaint(1, PorterDuff.Mode.DST_IN);

    /* renamed from: OplusGLSurfaceView_13 */
    private final Paint f10230i = new LPaint(1, PorterDuff.Mode.DST_OUT);

    /* renamed from: OplusGLSurfaceView_15 */
    private final Paint f10231j = new LPaint(1);

    /* renamed from: OplusGLSurfaceView_5 */
    private final Paint f10232k = new LPaint(PorterDuff.Mode.CLEAR);

    /* renamed from: OplusGLSurfaceView_14 */
    private final RectF f10233l = new RectF();

    /* renamed from: OplusGLSurfaceView_6 */
    private final RectF f10234m = new RectF();

    /* renamed from: OplusGLSurfaceView_11 */
    private final RectF f10235n = new RectF();

    /* renamed from: o */
    private final RectF f10236o = new RectF();

    /* renamed from: q */
    private final List<BaseKeyframeAnimation<?, ?>> f10238q = new ArrayList();

    /* renamed from: v */
    private boolean f10243v = true;

    @Override // com.oplus.anim.p111a.p112a.Content
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo8811a(List<Content> list, List<Content> list2) {
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    abstract void mo9085b(Canvas canvas, Matrix matrix, int OplusGLSurfaceView_13);

    /* renamed from: IntrinsicsJvm.kt_4 */
    void mo9087b(KeyPath c2357f, int OplusGLSurfaceView_13, List<KeyPath> list, KeyPath c2357f2) {
    }

    BaseLayer(EffectiveAnimationDrawable c2309b, Layer c2350d) {
        this.f10223b = c2309b;
        this.f10224c = c2350d;
        this.f10237p = c2350d.m9098f() + "#draw";
        if (OplusLog.f10388d) {
            OplusLog.m9286b("BaseLayer::name = " + c2350d.m9098f() + ";layerModel.getMatteType() = " + c2350d.m9104l() + "; this = " + this);
        }
        if (c2350d.m9104l() == Layer.IntrinsicsJvm.kt_4.INVERT) {
            this.f10231j.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            this.f10231j.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        this.f10225d = c2350d.m9107o().m8972j();
        this.f10225d.m8881a((BaseKeyframeAnimation.PlatformImplementations.kt_3) this);
        if (OplusLog.f10388d) {
            StringBuilder sb = new StringBuilder();
            sb.append("BaseLayer::layerModel.getMasks() ? ");
            sb.append(c2350d.m9102j() == null);
            OplusLog.m9286b(sb.toString());
        }
        if (c2350d.m9102j() != null && !c2350d.m9102j().isEmpty()) {
            this.f10239r = new MaskKeyframeAnimation(c2350d.m9102j());
            Iterator<BaseKeyframeAnimation<ShapeData, Path>> it = this.f10239r.m8867b().iterator();
            while (it.hasNext()) {
                it.next().m8847a(this);
            }
            for (BaseKeyframeAnimation<Integer, Integer> abstractC2293a : this.f10239r.m8868c()) {
                m9082a(abstractC2293a);
                abstractC2293a.m8847a(this);
            }
        }
        m9077f();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static BaseLayer m9065a(Layer c2350d, EffectiveAnimationDrawable c2309b, EffectiveAnimationComposition c2272a) {
        switch (c2350d.m9103k()) {
            case SHAPE:
                return new ShapeLayer(c2309b, c2350d);
            case PRE_COMP:
                return new CompositionLayer(c2309b, c2350d, c2272a.m8789b(c2350d.m9099g()), c2272a);
            case SOLID:
                return new SolidLayer(c2309b, c2350d);
            case IMAGE:
                return new ImageLayer(c2309b, c2350d);
            case NULL:
                return new NullLayer(c2309b, c2350d);
            case TEXT:
                return new TextLayer(c2309b, c2350d);
            default:
                L.m9348b("Unknown layer type " + c2350d.m9103k());
                return null;
        }
    }

    @Override // com.oplus.anim.p111a.p113b.BaseKeyframeAnimation.PlatformImplementations.kt_3
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo8806a() {
        m9079g();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    Layer m9088c() {
        return this.f10224c;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m9083a(BaseLayer abstractC2347a) {
        this.f10240s = abstractC2347a;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    boolean m9089d() {
        return this.f10240s != null;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    void m9086b(BaseLayer abstractC2347a) {
        this.f10241t = abstractC2347a;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private void m9077f() {
        if (!this.f10224c.m9096d().isEmpty()) {
            final FloatKeyframeAnimation c2295c = new FloatKeyframeAnimation(this.f10224c.m9096d());
            if (OplusLog.f10388d) {
                for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f10224c.m9096d().size(); OplusGLSurfaceView_13++) {
                    OplusLog.m9286b("BaseLayer::create InOutAnimations, " + this.f10224c.m9096d().get(OplusGLSurfaceView_13).toString());
                }
            }
            c2295c.m8845a();
            c2295c.m8847a(new BaseKeyframeAnimation.PlatformImplementations.kt_3() { // from class: com.oplus.anim.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3.PlatformImplementations.kt_3.1
                @Override // com.oplus.anim.p111a.p113b.BaseKeyframeAnimation.PlatformImplementations.kt_3
                /* renamed from: PlatformImplementations.kt_3 */
                public void mo8806a() {
                    BaseLayer.this.m9084a(c2295c.m8861i() == 1.0f);
                }
            });
            m9084a(c2295c.mo8854g().floatValue() == 1.0f);
            m9082a(c2295c);
            return;
        }
        m9084a(true);
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private void m9079g() {
        this.f10223b.invalidateSelf();
    }

    @SuppressLint({"WrongConstant"})
    /* renamed from: PlatformImplementations.kt_3 */
    private void m9069a(Canvas canvas, RectF rectF, Paint paint, boolean z) {
        if (Build.VERSION.SDK_INT < 23) {
            canvas.saveLayer(rectF, paint, z ? 31 : 19);
        } else {
            canvas.saveLayer(rectF, paint);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m9082a(BaseKeyframeAnimation<?, ?> abstractC2293a) {
        if (abstractC2293a == null) {
            return;
        }
        this.f10238q.add(abstractC2293a);
    }

    @Override // com.oplus.anim.p111a.p112a.DrawingContent
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo8808a(RectF rectF, Matrix matrix, boolean z) {
        this.f10233l.set(0.0f, 0.0f, 0.0f, 0.0f);
        m9080h();
        this.f10222a.set(matrix);
        if (z) {
            List<BaseLayer> list = this.f10242u;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f10222a.preConcat(this.f10242u.get(size).f10225d.m8887d());
                }
            } else {
                BaseLayer abstractC2347a = this.f10241t;
                if (abstractC2347a != null) {
                    this.f10222a.preConcat(abstractC2347a.f10225d.m8887d());
                }
            }
        }
        this.f10222a.preConcat(this.f10225d.m8887d());
    }

    @Override // com.oplus.anim.p111a.p112a.DrawingContent
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo8807a(Canvas canvas, Matrix matrix, int OplusGLSurfaceView_13) {
        L.m9349c(this.f10237p);
        if (!this.f10243v || this.f10224c.m9114v()) {
            L.m9350d(this.f10237p);
            return;
        }
        m9080h();
        L.m9349c("Layer#parentMatrix");
        this.f10227f.reset();
        this.f10227f.set(matrix);
        for (int size = this.f10242u.size() - 1; size >= 0; size--) {
            this.f10227f.preConcat(this.f10242u.get(size).f10225d.m8887d());
        }
        L.m9350d("Layer#parentMatrix");
        int iIntValue = (int) ((((OplusGLSurfaceView_13 / 255.0f) * (this.f10225d.m8879a() == null ? 100 : this.f10225d.m8879a().mo8854g().intValue())) / 100.0f) * 255.0f);
        if (!m9089d() && !m9090e()) {
            this.f10227f.preConcat(this.f10225d.m8887d());
            L.m9349c("Layer#drawLayer");
            mo9085b(canvas, this.f10227f, iIntValue);
            L.m9350d("Layer#drawLayer");
            float fM9350d = L.m9350d(this.f10237p);
            L.m9347a(this.f10237p + " draw end time = " + fM9350d);
            m9071b(fM9350d);
            return;
        }
        L.m9349c("Layer#computeBounds");
        mo8808a(this.f10233l, this.f10227f, false);
        m9073b(this.f10233l, matrix);
        this.f10227f.preConcat(this.f10225d.m8887d());
        m9070a(this.f10233l, this.f10227f);
        L.m9350d("Layer#computeBounds");
        if (!this.f10233l.isEmpty()) {
            L.m9349c("Layer#saveLayer");
            m9069a(canvas, this.f10233l, this.f10228g, true);
            L.m9350d("Layer#saveLayer");
            m9066a(canvas);
            L.m9349c("Layer#drawLayer");
            mo9085b(canvas, this.f10227f, iIntValue);
            L.m9350d("Layer#drawLayer");
            if (m9090e()) {
                m9067a(canvas, this.f10227f);
            }
            if (m9089d()) {
                L.m9349c("Layer#drawMatte");
                L.m9349c("Layer#saveLayer");
                m9069a(canvas, this.f10233l, this.f10231j, false);
                L.m9350d("Layer#saveLayer");
                m9066a(canvas);
                this.f10240s.mo8807a(canvas, matrix, iIntValue);
                L.m9349c("Layer#restoreLayer");
                canvas.restore();
                L.m9350d("Layer#restoreLayer");
                L.m9350d("Layer#drawMatte");
            }
            L.m9349c("Layer#restoreLayer");
            canvas.restore();
            L.m9350d("Layer#restoreLayer");
        }
        float fM9350d2 = L.m9350d(this.f10237p);
        L.m9347a(this.f10237p + " draw end,time = " + fM9350d2);
        m9071b(fM9350d2);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m9071b(float COUIBaseListPopupWindow_12) {
        this.f10223b.m8938r().m8792c().m9352a(this.f10224c.m9098f(), COUIBaseListPopupWindow_12);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m9066a(Canvas canvas) {
        L.m9349c("Layer#clearLayer");
        canvas.drawRect(this.f10233l.left - 1.0f, this.f10233l.top - 1.0f, this.f10233l.right + 1.0f, this.f10233l.bottom + 1.0f, this.f10232k);
        L.m9350d("Layer#clearLayer");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m9070a(RectF rectF, Matrix matrix) {
        this.f10234m.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (m9090e()) {
            int size = this.f10239r.m8866a().size();
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
                Mask c2335g = this.f10239r.m8866a().get(OplusGLSurfaceView_13);
                this.f10226e.set(this.f10239r.m8867b().get(OplusGLSurfaceView_13).mo8854g());
                this.f10226e.transform(matrix);
                int i2 = XPanMode_2.f10247b[c2335g.m9003a().ordinal()];
                if (i2 == 1) {
                    return;
                }
                if (i2 == 2 || i2 == 3) {
                    if (c2335g.m9006d()) {
                        return;
                    }
                    this.f10226e.computeBounds(this.f10236o, false);
                    if (OplusGLSurfaceView_13 == 0) {
                        this.f10234m.set(this.f10236o);
                    } else {
                        RectF rectF2 = this.f10234m;
                        rectF2.set(Math.min(rectF2.left, this.f10236o.left), Math.min(this.f10234m.top, this.f10236o.top), Math.max(this.f10234m.right, this.f10236o.right), Math.max(this.f10234m.bottom, this.f10236o.bottom));
                    }
                } else {
                    this.f10226e.computeBounds(this.f10236o, false);
                    if (OplusGLSurfaceView_13 == 0) {
                        this.f10234m.set(this.f10236o);
                    } else {
                        RectF rectF3 = this.f10234m;
                        rectF3.set(Math.min(rectF3.left, this.f10236o.left), Math.min(this.f10234m.top, this.f10236o.top), Math.max(this.f10234m.right, this.f10236o.right), Math.max(this.f10234m.bottom, this.f10236o.bottom));
                    }
                }
            }
            if (rectF.intersect(this.f10234m)) {
                return;
            }
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    /* compiled from: BaseLayer.java */
    /* renamed from: com.oplus.anim.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3.PlatformImplementations.kt_3$2, reason: invalid class name */
    static /* synthetic */ class XPanMode_2 {

        /* renamed from: IntrinsicsJvm.kt_4 */
        static final /* synthetic */ int[] f10247b = new int[Mask.PlatformImplementations.kt_3.values().length];

        static {
            try {
                f10247b[Mask.PlatformImplementations.kt_3.MASK_MODE_SUBTRACT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10247b[Mask.PlatformImplementations.kt_3.MASK_MODE_INTERSECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10247b[Mask.PlatformImplementations.kt_3.MASK_MODE_ADD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f10246a = new int[Layer.PlatformImplementations.kt_3.values().length];
            try {
                f10246a[Layer.PlatformImplementations.kt_3.SHAPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f10246a[Layer.PlatformImplementations.kt_3.PRE_COMP.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f10246a[Layer.PlatformImplementations.kt_3.SOLID.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f10246a[Layer.PlatformImplementations.kt_3.IMAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f10246a[Layer.PlatformImplementations.kt_3.NULL.ordinal()] = 5;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f10246a[Layer.PlatformImplementations.kt_3.TEXT.ordinal()] = 6;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f10246a[Layer.PlatformImplementations.kt_3.UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m9073b(RectF rectF, Matrix matrix) {
        if (m9089d() && this.f10224c.m9104l() != Layer.IntrinsicsJvm.kt_4.INVERT) {
            this.f10235n.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.f10240s.mo8808a(this.f10235n, matrix, true);
            if (rectF.intersect(this.f10235n)) {
                return;
            }
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m9067a(Canvas canvas, Matrix matrix) {
        L.m9349c("Layer#saveLayer");
        m9069a(canvas, this.f10233l, this.f10229h, false);
        L.m9350d("Layer#saveLayer");
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f10239r.m8866a().size(); OplusGLSurfaceView_13++) {
            Mask c2335g = this.f10239r.m8866a().get(OplusGLSurfaceView_13);
            BaseKeyframeAnimation<ShapeData, Path> abstractC2293a = this.f10239r.m8867b().get(OplusGLSurfaceView_13);
            BaseKeyframeAnimation<Integer, Integer> abstractC2293a2 = this.f10239r.m8868c().get(OplusGLSurfaceView_13);
            int i2 = XPanMode_2.f10247b[c2335g.m9003a().ordinal()];
            if (i2 == 1) {
                if (OplusGLSurfaceView_13 == 0) {
                    Paint paint = new Paint();
                    paint.setColor(-16777216);
                    canvas.drawRect(this.f10233l, paint);
                }
                if (c2335g.m9006d()) {
                    m9075d(canvas, matrix, c2335g, abstractC2293a, abstractC2293a2);
                } else {
                    m9074c(canvas, matrix, c2335g, abstractC2293a, abstractC2293a2);
                }
            } else if (i2 != 2) {
                if (i2 == 3) {
                    if (c2335g.m9006d()) {
                        m9072b(canvas, matrix, c2335g, abstractC2293a, abstractC2293a2);
                    } else {
                        m9068a(canvas, matrix, c2335g, abstractC2293a, abstractC2293a2);
                    }
                }
            } else if (c2335g.m9006d()) {
                m9078f(canvas, matrix, c2335g, abstractC2293a, abstractC2293a2);
            } else {
                m9076e(canvas, matrix, c2335g, abstractC2293a, abstractC2293a2);
            }
        }
        L.m9349c("Layer#restoreLayer");
        canvas.restore();
        L.m9350d("Layer#restoreLayer");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m9068a(Canvas canvas, Matrix matrix, Mask c2335g, BaseKeyframeAnimation<ShapeData, Path> abstractC2293a, BaseKeyframeAnimation<Integer, Integer> abstractC2293a2) {
        this.f10226e.set(abstractC2293a.mo8854g());
        this.f10226e.transform(matrix);
        this.f10228g.setAlpha((int) (abstractC2293a2.mo8854g().intValue() * 2.55f));
        canvas.drawPath(this.f10226e, this.f10228g);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m9072b(Canvas canvas, Matrix matrix, Mask c2335g, BaseKeyframeAnimation<ShapeData, Path> abstractC2293a, BaseKeyframeAnimation<Integer, Integer> abstractC2293a2) {
        m9069a(canvas, this.f10233l, this.f10228g, true);
        canvas.drawRect(this.f10233l, this.f10228g);
        this.f10226e.set(abstractC2293a.mo8854g());
        this.f10226e.transform(matrix);
        this.f10228g.setAlpha((int) (abstractC2293a2.mo8854g().intValue() * 2.55f));
        canvas.drawPath(this.f10226e, this.f10230i);
        canvas.restore();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m9074c(Canvas canvas, Matrix matrix, Mask c2335g, BaseKeyframeAnimation<ShapeData, Path> abstractC2293a, BaseKeyframeAnimation<Integer, Integer> abstractC2293a2) {
        this.f10226e.set(abstractC2293a.mo8854g());
        this.f10226e.transform(matrix);
        canvas.drawPath(this.f10226e, this.f10230i);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m9075d(Canvas canvas, Matrix matrix, Mask c2335g, BaseKeyframeAnimation<ShapeData, Path> abstractC2293a, BaseKeyframeAnimation<Integer, Integer> abstractC2293a2) {
        m9069a(canvas, this.f10233l, this.f10230i, true);
        canvas.drawRect(this.f10233l, this.f10228g);
        this.f10230i.setAlpha((int) (abstractC2293a2.mo8854g().intValue() * 2.55f));
        this.f10226e.set(abstractC2293a.mo8854g());
        this.f10226e.transform(matrix);
        canvas.drawPath(this.f10226e, this.f10230i);
        canvas.restore();
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m9076e(Canvas canvas, Matrix matrix, Mask c2335g, BaseKeyframeAnimation<ShapeData, Path> abstractC2293a, BaseKeyframeAnimation<Integer, Integer> abstractC2293a2) {
        m9069a(canvas, this.f10233l, this.f10229h, true);
        this.f10226e.set(abstractC2293a.mo8854g());
        this.f10226e.transform(matrix);
        this.f10228g.setAlpha((int) (abstractC2293a2.mo8854g().intValue() * 2.55f));
        canvas.drawPath(this.f10226e, this.f10228g);
        canvas.restore();
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private void m9078f(Canvas canvas, Matrix matrix, Mask c2335g, BaseKeyframeAnimation<ShapeData, Path> abstractC2293a, BaseKeyframeAnimation<Integer, Integer> abstractC2293a2) {
        m9069a(canvas, this.f10233l, this.f10229h, true);
        canvas.drawRect(this.f10233l, this.f10228g);
        this.f10230i.setAlpha((int) (abstractC2293a2.mo8854g().intValue() * 2.55f));
        this.f10226e.set(abstractC2293a.mo8854g());
        this.f10226e.transform(matrix);
        canvas.drawPath(this.f10226e, this.f10230i);
        canvas.restore();
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    boolean m9090e() {
        MaskKeyframeAnimation c2299g = this.f10239r;
        return (c2299g == null || c2299g.m8867b().isEmpty()) ? false : true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m9084a(boolean z) {
        if (z != this.f10243v) {
            this.f10243v = z;
            m9079g();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void mo9081a(float COUIBaseListPopupWindow_12) {
        this.f10225d.m8880a(COUIBaseListPopupWindow_12);
        if (this.f10239r != null) {
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f10239r.m8867b().size(); OplusGLSurfaceView_13++) {
                this.f10239r.m8867b().get(OplusGLSurfaceView_13).mo8846a(COUIBaseListPopupWindow_12);
            }
        }
        if (this.f10224c.m9094b() != 0.0f) {
            COUIBaseListPopupWindow_12 /= this.f10224c.m9094b();
        }
        BaseLayer abstractC2347a = this.f10240s;
        if (abstractC2347a != null) {
            this.f10240s.mo9081a(abstractC2347a.f10224c.m9094b() * COUIBaseListPopupWindow_12);
        }
        for (int i2 = 0; i2 < this.f10238q.size(); i2++) {
            this.f10238q.get(i2).mo8846a(COUIBaseListPopupWindow_12);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    private void m9080h() {
        if (this.f10242u != null) {
            return;
        }
        if (this.f10241t == null) {
            this.f10242u = Collections.emptyList();
            return;
        }
        this.f10242u = new ArrayList();
        for (BaseLayer abstractC2347a = this.f10241t; abstractC2347a != null; abstractC2347a = abstractC2347a.f10241t) {
            this.f10242u.add(abstractC2347a);
        }
    }

    @Override // com.oplus.anim.p111a.p112a.Content
    /* renamed from: IntrinsicsJvm.kt_4 */
    public String mo8816b() {
        return this.f10224c.m9098f();
    }

    @Override // com.oplus.anim.p115c.KeyPathElement
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo8809a(KeyPath c2357f, int OplusGLSurfaceView_13, List<KeyPath> list, KeyPath c2357f2) {
        if (OplusLog.f10387c) {
            OplusLog.m9286b("BaseLayer::resolveKeyPath()::this = " + mo8816b() + "; keyPath = " + c2357f.toString());
        }
        if (c2357f.m9138a(mo8816b(), OplusGLSurfaceView_13)) {
            if (!"__container".equals(mo8816b())) {
                c2357f2 = c2357f2.m9136a(mo8816b());
                if (c2357f.m9140c(mo8816b(), OplusGLSurfaceView_13)) {
                    if (OplusLog.f10387c) {
                        OplusLog.m9286b("BaseLayer::resolveKeyPath()::name = " + mo8816b());
                    }
                    list.add(c2357f2.m9135a(this));
                }
            }
            if (c2357f.m9141d(mo8816b(), OplusGLSurfaceView_13)) {
                int iM9139b = OplusGLSurfaceView_13 + c2357f.m9139b(mo8816b(), OplusGLSurfaceView_13);
                if (OplusLog.f10387c) {
                    OplusLog.m9286b("BaseLayer::resolveKeyPath()::newDepth = " + iM9139b);
                }
                mo9087b(c2357f, iM9139b, list, c2357f2);
            }
        }
    }

    @Override // com.oplus.anim.p115c.KeyPathElement
    /* renamed from: PlatformImplementations.kt_3 */
    public <T> void mo8810a(T t, EffectiveValueCallback<T> c2412b) {
        this.f10225d.m8883a(t, c2412b);
    }
}
