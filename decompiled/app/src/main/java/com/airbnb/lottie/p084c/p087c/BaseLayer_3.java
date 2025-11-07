package com.airbnb.lottie.p084c.p087c;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import com.airbnb.lottie.L_2;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.p080a.LPaint_2;
import com.airbnb.lottie.p080a.p081a.Content_2;
import com.airbnb.lottie.p080a.p081a.DrawingContent_2;
import com.airbnb.lottie.p080a.p082b.BaseKeyframeAnimation_3;
import com.airbnb.lottie.p080a.p082b.FloatKeyframeAnimation_2;
import com.airbnb.lottie.p080a.p082b.MaskKeyframeAnimation_2;
import com.airbnb.lottie.p080a.p082b.TransformKeyframeAnimation_2;
import com.airbnb.lottie.p084c.KeyPath_2;
import com.airbnb.lottie.p084c.KeyPathElement_2;
import com.airbnb.lottie.p084c.p086b.Mask_3;
import com.airbnb.lottie.p084c.p086b.ShapeData_2;
import com.airbnb.lottie.p084c.p087c.Layer_4;
import com.airbnb.lottie.p091f.Logger_3;
import com.airbnb.lottie.p091f.Utils_4;
import com.airbnb.lottie.p092g.LottieValueCallback;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: BaseLayer.java */
/* renamed from: com.airbnb.lottie.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3.PlatformImplementations.kt_3 */
/* loaded from: classes.dex */
public abstract class BaseLayer_3 implements DrawingContent_2, BaseKeyframeAnimation_3.PlatformImplementations.kt_3, KeyPathElement_2 {

    /* renamed from: IntrinsicsJvm.kt_4 */
    final LottieDrawable f5603b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    final Layer_4 f5604c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    final TransformKeyframeAnimation_2 f5605d;

    /* renamed from: p */
    private final String f5617p;

    /* renamed from: q */
    private MaskKeyframeAnimation_2 f5618q;

    /* renamed from: r */
    private FloatKeyframeAnimation_2 f5619r;

    /* renamed from: s */
    private BaseLayer_3 f5620s;

    /* renamed from: t */
    private BaseLayer_3 f5621t;

    /* renamed from: u */
    private List<BaseLayer_3> f5622u;

    /* renamed from: x */
    private boolean f5625x;

    /* renamed from: y */
    private Paint f5626y;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final Path f5606e = new Path();

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final Matrix f5607f = new Matrix();

    /* renamed from: COUIBaseListPopupWindow_11 */
    private final Paint f5608g = new LPaint_2(1);

    /* renamed from: COUIBaseListPopupWindow_10 */
    private final Paint f5609h = new LPaint_2(1, PorterDuff.Mode.DST_IN);

    /* renamed from: OplusGLSurfaceView_13 */
    private final Paint f5610i = new LPaint_2(1, PorterDuff.Mode.DST_OUT);

    /* renamed from: OplusGLSurfaceView_15 */
    private final Paint f5611j = new LPaint_2(1);

    /* renamed from: OplusGLSurfaceView_5 */
    private final Paint f5612k = new LPaint_2(PorterDuff.Mode.CLEAR);

    /* renamed from: OplusGLSurfaceView_14 */
    private final RectF f5613l = new RectF();

    /* renamed from: OplusGLSurfaceView_6 */
    private final RectF f5614m = new RectF();

    /* renamed from: OplusGLSurfaceView_11 */
    private final RectF f5615n = new RectF();

    /* renamed from: o */
    private final RectF f5616o = new RectF();

    /* renamed from: PlatformImplementations.kt_3 */
    final Matrix f5602a = new Matrix();

    /* renamed from: v */
    private final List<BaseKeyframeAnimation_3<?, ?>> f5623v = new ArrayList();

    /* renamed from: w */
    private boolean f5624w = true;

    @Override // com.airbnb.lottie.p080a.p081a.Content_2
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo5535a(List<Content_2> list, List<Content_2> list2) {
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    abstract void mo5777b(Canvas canvas, Matrix matrix, int OplusGLSurfaceView_13);

    /* renamed from: IntrinsicsJvm.kt_4 */
    void mo5780b(KeyPath_2 c1131e, int OplusGLSurfaceView_13, List<KeyPath_2> list, KeyPath_2 c1131e2) {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static BaseLayer_3 m5754a(Layer_4 c1125d, LottieDrawable c1187f, LottieComposition c1136d) {
        switch (c1125d.m5796k()) {
            case SHAPE:
                return new ShapeLayer_2(c1187f, c1125d);
            case PRE_COMP:
                return new CompositionLayer_3(c1187f, c1125d, c1136d.m5847b(c1125d.m5792g()), c1136d);
            case SOLID:
                return new SolidLayer_2(c1187f, c1125d);
            case IMAGE:
                return new ImageLayer_2(c1187f, c1125d);
            case NULL:
                return new NullLayer_2(c1187f, c1125d);
            case TEXT:
                return new TextLayer_3(c1187f, c1125d);
            default:
                Logger_3.m6100b("Unknown layer type " + c1125d.m5796k());
                return null;
        }
    }

    BaseLayer_3(LottieDrawable c1187f, Layer_4 c1125d) {
        this.f5603b = c1187f;
        this.f5604c = c1125d;
        this.f5617p = c1125d.m5791f() + "#draw";
        if (c1125d.m5797l() == Layer_4.IntrinsicsJvm.kt_4.INVERT) {
            this.f5611j.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            this.f5611j.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        this.f5605d = c1125d.m5800o().m5661j();
        this.f5605d.m5620a((BaseKeyframeAnimation_3.PlatformImplementations.kt_3) this);
        if (c1125d.m5795j() != null && !c1125d.m5795j().isEmpty()) {
            this.f5618q = new MaskKeyframeAnimation_2(c1125d.m5795j());
            Iterator<BaseKeyframeAnimation_3<ShapeData_2, Path>> it = this.f5618q.m5603b().iterator();
            while (it.hasNext()) {
                it.next().m5576a(this);
            }
            for (BaseKeyframeAnimation_3<Integer, Integer> abstractC1068a : this.f5618q.m5604c()) {
                m5774a(abstractC1068a);
                abstractC1068a.m5576a(this);
            }
        }
        m5768f();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void mo5776a(boolean z) {
        if (z && this.f5626y == null) {
            this.f5626y = new LPaint_2();
        }
        this.f5625x = z;
    }

    @Override // com.airbnb.lottie.p080a.p082b.BaseKeyframeAnimation_3.PlatformImplementations.kt_3
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo5530a() {
        m5770g();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    Layer_4 m5781c() {
        return this.f5604c;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m5775a(BaseLayer_3 abstractC1122a) {
        this.f5620s = abstractC1122a;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    boolean m5782d() {
        return this.f5620s != null;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    void m5779b(BaseLayer_3 abstractC1122a) {
        this.f5621t = abstractC1122a;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private void m5768f() {
        if (!this.f5604c.m5789d().isEmpty()) {
            this.f5619r = new FloatKeyframeAnimation_2(this.f5604c.m5789d());
            this.f5619r.m5574a();
            this.f5619r.m5576a(new BaseKeyframeAnimation_3.PlatformImplementations.kt_3() { // from class: com.airbnb.lottie.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3.PlatformImplementations.kt_3.1
                @Override // com.airbnb.lottie.p080a.p082b.BaseKeyframeAnimation_3.PlatformImplementations.kt_3
                /* renamed from: PlatformImplementations.kt_3 */
                public void mo5530a() {
                    BaseLayer_3 abstractC1122a = BaseLayer_3.this;
                    abstractC1122a.m5763b(abstractC1122a.f5619r.m5597i() == 1.0f);
                }
            });
            m5763b(this.f5619r.mo5583g().floatValue() == 1.0f);
            m5774a(this.f5619r);
            return;
        }
        m5763b(true);
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private void m5770g() {
        this.f5603b.invalidateSelf();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m5774a(BaseKeyframeAnimation_3<?, ?> abstractC1068a) {
        if (abstractC1068a == null) {
            return;
        }
        this.f5623v.add(abstractC1068a);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m5778b(BaseKeyframeAnimation_3<?, ?> abstractC1068a) {
        this.f5623v.remove(abstractC1068a);
    }

    @Override // com.airbnb.lottie.p080a.p081a.DrawingContent_2
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo5532a(RectF rectF, Matrix matrix, boolean z) {
        this.f5613l.set(0.0f, 0.0f, 0.0f, 0.0f);
        m5772i();
        this.f5602a.set(matrix);
        if (z) {
            List<BaseLayer_3> list = this.f5622u;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f5602a.preConcat(this.f5622u.get(size).f5605d.m5626d());
                }
            } else {
                BaseLayer_3 abstractC1122a = this.f5621t;
                if (abstractC1122a != null) {
                    this.f5602a.preConcat(abstractC1122a.f5605d.m5626d());
                }
            }
        }
        this.f5602a.preConcat(this.f5605d.m5626d());
    }

    @Override // com.airbnb.lottie.p080a.p081a.DrawingContent_2
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo5531a(Canvas canvas, Matrix matrix, int OplusGLSurfaceView_13) {
        Paint paint;
        L_2.m5637a(this.f5617p);
        if (!this.f5624w || this.f5604c.m5807v()) {
            L_2.m5638b(this.f5617p);
            return;
        }
        m5772i();
        L_2.m5637a("Layer#parentMatrix");
        this.f5607f.reset();
        this.f5607f.set(matrix);
        for (int size = this.f5622u.size() - 1; size >= 0; size--) {
            this.f5607f.preConcat(this.f5622u.get(size).f5605d.m5626d());
        }
        L_2.m5638b("Layer#parentMatrix");
        int iIntValue = (int) ((((OplusGLSurfaceView_13 / 255.0f) * (this.f5605d.m5618a() == null ? 100 : this.f5605d.m5618a().mo5583g().intValue())) / 100.0f) * 255.0f);
        if (!m5782d() && !m5783e()) {
            this.f5607f.preConcat(this.f5605d.m5626d());
            L_2.m5637a("Layer#drawLayer");
            mo5777b(canvas, this.f5607f, iIntValue);
            L_2.m5638b("Layer#drawLayer");
            m5760b(L_2.m5638b(this.f5617p));
            return;
        }
        L_2.m5637a("Layer#computeBounds");
        mo5532a(this.f5613l, this.f5607f, false);
        m5762b(this.f5613l, matrix);
        this.f5607f.preConcat(this.f5605d.m5626d());
        m5758a(this.f5613l, this.f5607f);
        if (!this.f5613l.intersect(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight())) {
            this.f5613l.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
        L_2.m5638b("Layer#computeBounds");
        if (this.f5613l.width() >= 1.0f && this.f5613l.height() >= 1.0f) {
            L_2.m5637a("Layer#saveLayer");
            this.f5608g.setAlpha(255);
            Utils_4.m6145a(canvas, this.f5613l, this.f5608g);
            L_2.m5638b("Layer#saveLayer");
            m5755a(canvas);
            L_2.m5637a("Layer#drawLayer");
            mo5777b(canvas, this.f5607f, iIntValue);
            L_2.m5638b("Layer#drawLayer");
            if (m5783e()) {
                m5756a(canvas, this.f5607f);
            }
            if (m5782d()) {
                L_2.m5637a("Layer#drawMatte");
                L_2.m5637a("Layer#saveLayer");
                Utils_4.m6146a(canvas, this.f5613l, this.f5611j, 19);
                L_2.m5638b("Layer#saveLayer");
                m5755a(canvas);
                this.f5620s.mo5531a(canvas, matrix, iIntValue);
                L_2.m5637a("Layer#restoreLayer");
                canvas.restore();
                L_2.m5638b("Layer#restoreLayer");
                L_2.m5638b("Layer#drawMatte");
            }
            L_2.m5637a("Layer#restoreLayer");
            canvas.restore();
            L_2.m5638b("Layer#restoreLayer");
        }
        if (this.f5625x && (paint = this.f5626y) != null) {
            paint.setStyle(Paint.Style.STROKE);
            this.f5626y.setColor(-251901);
            this.f5626y.setStrokeWidth(4.0f);
            canvas.drawRect(this.f5613l, this.f5626y);
            this.f5626y.setStyle(Paint.Style.FILL);
            this.f5626y.setColor(1357638635);
            canvas.drawRect(this.f5613l, this.f5626y);
        }
        m5760b(L_2.m5638b(this.f5617p));
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m5760b(float COUIBaseListPopupWindow_12) {
        this.f5603b.m6080t().m5850c().m6193a(this.f5604c.m5791f(), COUIBaseListPopupWindow_12);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m5755a(Canvas canvas) {
        L_2.m5637a("Layer#clearLayer");
        canvas.drawRect(this.f5613l.left - 1.0f, this.f5613l.top - 1.0f, this.f5613l.right + 1.0f, this.f5613l.bottom + 1.0f, this.f5612k);
        L_2.m5638b("Layer#clearLayer");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m5758a(RectF rectF, Matrix matrix) {
        this.f5614m.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (m5783e()) {
            int size = this.f5618q.m5602a().size();
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
                Mask_3 c1110g = this.f5618q.m5602a().get(OplusGLSurfaceView_13);
                this.f5606e.set(this.f5618q.m5603b().get(OplusGLSurfaceView_13).mo5583g());
                this.f5606e.transform(matrix);
                int i2 = XPanMode_2.f5629b[c1110g.m5692a().ordinal()];
                if (i2 == 1 || i2 == 2) {
                    return;
                }
                if ((i2 == 3 || i2 == 4) && c1110g.m5695d()) {
                    return;
                }
                this.f5606e.computeBounds(this.f5616o, false);
                if (OplusGLSurfaceView_13 == 0) {
                    this.f5614m.set(this.f5616o);
                } else {
                    RectF rectF2 = this.f5614m;
                    rectF2.set(Math.min(rectF2.left, this.f5616o.left), Math.min(this.f5614m.top, this.f5616o.top), Math.max(this.f5614m.right, this.f5616o.right), Math.max(this.f5614m.bottom, this.f5616o.bottom));
                }
            }
            if (rectF.intersect(this.f5614m)) {
                return;
            }
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    /* compiled from: BaseLayer.java */
    /* renamed from: com.airbnb.lottie.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3.PlatformImplementations.kt_3$2, reason: invalid class name */
    static /* synthetic */ class XPanMode_2 {

        /* renamed from: IntrinsicsJvm.kt_4 */
        static final /* synthetic */ int[] f5629b = new int[Mask_3.PlatformImplementations.kt_3.values().length];

        static {
            try {
                f5629b[Mask_3.PlatformImplementations.kt_3.MASK_MODE_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5629b[Mask_3.PlatformImplementations.kt_3.MASK_MODE_SUBTRACT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5629b[Mask_3.PlatformImplementations.kt_3.MASK_MODE_INTERSECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f5629b[Mask_3.PlatformImplementations.kt_3.MASK_MODE_ADD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f5628a = new int[Layer_4.PlatformImplementations.kt_3.values().length];
            try {
                f5628a[Layer_4.PlatformImplementations.kt_3.SHAPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f5628a[Layer_4.PlatformImplementations.kt_3.PRE_COMP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f5628a[Layer_4.PlatformImplementations.kt_3.SOLID.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f5628a[Layer_4.PlatformImplementations.kt_3.IMAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f5628a[Layer_4.PlatformImplementations.kt_3.NULL.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f5628a[Layer_4.PlatformImplementations.kt_3.TEXT.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f5628a[Layer_4.PlatformImplementations.kt_3.UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m5762b(RectF rectF, Matrix matrix) {
        if (m5782d() && this.f5604c.m5797l() != Layer_4.IntrinsicsJvm.kt_4.INVERT) {
            this.f5615n.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.f5620s.mo5532a(this.f5615n, matrix, true);
            if (rectF.intersect(this.f5615n)) {
                return;
            }
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m5756a(Canvas canvas, Matrix matrix) {
        L_2.m5637a("Layer#saveLayer");
        Utils_4.m6146a(canvas, this.f5613l, this.f5609h, 19);
        if (Build.VERSION.SDK_INT < 28) {
            m5755a(canvas);
        }
        L_2.m5638b("Layer#saveLayer");
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f5618q.m5602a().size(); OplusGLSurfaceView_13++) {
            Mask_3 c1110g = this.f5618q.m5602a().get(OplusGLSurfaceView_13);
            BaseKeyframeAnimation_3<ShapeData_2, Path> abstractC1068a = this.f5618q.m5603b().get(OplusGLSurfaceView_13);
            BaseKeyframeAnimation_3<Integer, Integer> abstractC1068a2 = this.f5618q.m5604c().get(OplusGLSurfaceView_13);
            int i2 = XPanMode_2.f5629b[c1110g.m5692a().ordinal()];
            if (i2 != 1) {
                if (i2 == 2) {
                    if (OplusGLSurfaceView_13 == 0) {
                        this.f5608g.setColor(-16777216);
                        this.f5608g.setAlpha(255);
                        canvas.drawRect(this.f5613l, this.f5608g);
                    }
                    if (c1110g.m5695d()) {
                        m5766d(canvas, matrix, c1110g, abstractC1068a, abstractC1068a2);
                    } else {
                        m5765c(canvas, matrix, c1110g, abstractC1068a, abstractC1068a2);
                    }
                } else if (i2 != 3) {
                    if (i2 == 4) {
                        if (c1110g.m5695d()) {
                            m5761b(canvas, matrix, c1110g, abstractC1068a, abstractC1068a2);
                        } else {
                            m5757a(canvas, matrix, c1110g, abstractC1068a, abstractC1068a2);
                        }
                    }
                } else if (c1110g.m5695d()) {
                    m5769f(canvas, matrix, c1110g, abstractC1068a, abstractC1068a2);
                } else {
                    m5767e(canvas, matrix, c1110g, abstractC1068a, abstractC1068a2);
                }
            } else if (m5771h()) {
                this.f5608g.setAlpha(255);
                canvas.drawRect(this.f5613l, this.f5608g);
            }
        }
        L_2.m5637a("Layer#restoreLayer");
        canvas.restore();
        L_2.m5638b("Layer#restoreLayer");
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    private boolean m5771h() {
        if (this.f5618q.m5603b().isEmpty()) {
            return false;
        }
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f5618q.m5602a().size(); OplusGLSurfaceView_13++) {
            if (this.f5618q.m5602a().get(OplusGLSurfaceView_13).m5692a() != Mask_3.PlatformImplementations.kt_3.MASK_MODE_NONE) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m5757a(Canvas canvas, Matrix matrix, Mask_3 c1110g, BaseKeyframeAnimation_3<ShapeData_2, Path> abstractC1068a, BaseKeyframeAnimation_3<Integer, Integer> abstractC1068a2) {
        this.f5606e.set(abstractC1068a.mo5583g());
        this.f5606e.transform(matrix);
        this.f5608g.setAlpha((int) (abstractC1068a2.mo5583g().intValue() * 2.55f));
        canvas.drawPath(this.f5606e, this.f5608g);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m5761b(Canvas canvas, Matrix matrix, Mask_3 c1110g, BaseKeyframeAnimation_3<ShapeData_2, Path> abstractC1068a, BaseKeyframeAnimation_3<Integer, Integer> abstractC1068a2) {
        Utils_4.m6145a(canvas, this.f5613l, this.f5608g);
        canvas.drawRect(this.f5613l, this.f5608g);
        this.f5606e.set(abstractC1068a.mo5583g());
        this.f5606e.transform(matrix);
        this.f5608g.setAlpha((int) (abstractC1068a2.mo5583g().intValue() * 2.55f));
        canvas.drawPath(this.f5606e, this.f5610i);
        canvas.restore();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m5765c(Canvas canvas, Matrix matrix, Mask_3 c1110g, BaseKeyframeAnimation_3<ShapeData_2, Path> abstractC1068a, BaseKeyframeAnimation_3<Integer, Integer> abstractC1068a2) {
        this.f5606e.set(abstractC1068a.mo5583g());
        this.f5606e.transform(matrix);
        canvas.drawPath(this.f5606e, this.f5610i);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m5766d(Canvas canvas, Matrix matrix, Mask_3 c1110g, BaseKeyframeAnimation_3<ShapeData_2, Path> abstractC1068a, BaseKeyframeAnimation_3<Integer, Integer> abstractC1068a2) {
        Utils_4.m6145a(canvas, this.f5613l, this.f5610i);
        canvas.drawRect(this.f5613l, this.f5608g);
        this.f5610i.setAlpha((int) (abstractC1068a2.mo5583g().intValue() * 2.55f));
        this.f5606e.set(abstractC1068a.mo5583g());
        this.f5606e.transform(matrix);
        canvas.drawPath(this.f5606e, this.f5610i);
        canvas.restore();
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m5767e(Canvas canvas, Matrix matrix, Mask_3 c1110g, BaseKeyframeAnimation_3<ShapeData_2, Path> abstractC1068a, BaseKeyframeAnimation_3<Integer, Integer> abstractC1068a2) {
        Utils_4.m6145a(canvas, this.f5613l, this.f5609h);
        this.f5606e.set(abstractC1068a.mo5583g());
        this.f5606e.transform(matrix);
        this.f5608g.setAlpha((int) (abstractC1068a2.mo5583g().intValue() * 2.55f));
        canvas.drawPath(this.f5606e, this.f5608g);
        canvas.restore();
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private void m5769f(Canvas canvas, Matrix matrix, Mask_3 c1110g, BaseKeyframeAnimation_3<ShapeData_2, Path> abstractC1068a, BaseKeyframeAnimation_3<Integer, Integer> abstractC1068a2) {
        Utils_4.m6145a(canvas, this.f5613l, this.f5609h);
        canvas.drawRect(this.f5613l, this.f5608g);
        this.f5610i.setAlpha((int) (abstractC1068a2.mo5583g().intValue() * 2.55f));
        this.f5606e.set(abstractC1068a.mo5583g());
        this.f5606e.transform(matrix);
        canvas.drawPath(this.f5606e, this.f5610i);
        canvas.restore();
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    boolean m5783e() {
        MaskKeyframeAnimation_2 c1074g = this.f5618q;
        return (c1074g == null || c1074g.m5603b().isEmpty()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m5763b(boolean z) {
        if (z != this.f5624w) {
            this.f5624w = z;
            m5770g();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void mo5773a(float COUIBaseListPopupWindow_12) {
        this.f5605d.m5619a(COUIBaseListPopupWindow_12);
        if (this.f5618q != null) {
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f5618q.m5603b().size(); OplusGLSurfaceView_13++) {
                this.f5618q.m5603b().get(OplusGLSurfaceView_13).mo5575a(COUIBaseListPopupWindow_12);
            }
        }
        if (this.f5604c.m5787b() != 0.0f) {
            COUIBaseListPopupWindow_12 /= this.f5604c.m5787b();
        }
        FloatKeyframeAnimation_2 c1070c = this.f5619r;
        if (c1070c != null) {
            c1070c.mo5575a(COUIBaseListPopupWindow_12 / this.f5604c.m5787b());
        }
        BaseLayer_3 abstractC1122a = this.f5620s;
        if (abstractC1122a != null) {
            this.f5620s.mo5773a(abstractC1122a.f5604c.m5787b() * COUIBaseListPopupWindow_12);
        }
        for (int i2 = 0; i2 < this.f5623v.size(); i2++) {
            this.f5623v.get(i2).mo5575a(COUIBaseListPopupWindow_12);
        }
    }

    /* renamed from: OplusGLSurfaceView_13 */
    private void m5772i() {
        if (this.f5622u != null) {
            return;
        }
        if (this.f5621t == null) {
            this.f5622u = Collections.emptyList();
            return;
        }
        this.f5622u = new ArrayList();
        for (BaseLayer_3 abstractC1122a = this.f5621t; abstractC1122a != null; abstractC1122a = abstractC1122a.f5621t) {
            this.f5622u.add(abstractC1122a);
        }
    }

    @Override // com.airbnb.lottie.p080a.p081a.Content_2
    /* renamed from: IntrinsicsJvm.kt_4 */
    public String mo5540b() {
        return this.f5604c.m5791f();
    }

    @Override // com.airbnb.lottie.p084c.KeyPathElement_2
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo5533a(KeyPath_2 c1131e, int OplusGLSurfaceView_13, List<KeyPath_2> list, KeyPath_2 c1131e2) {
        BaseLayer_3 abstractC1122a = this.f5620s;
        if (abstractC1122a != null) {
            KeyPath_2 c1131eM5828a = c1131e2.m5828a(abstractC1122a.mo5540b());
            if (c1131e.m5832c(this.f5620s.mo5540b(), OplusGLSurfaceView_13)) {
                list.add(c1131eM5828a.m5827a(this.f5620s));
            }
            if (c1131e.m5833d(mo5540b(), OplusGLSurfaceView_13)) {
                this.f5620s.mo5780b(c1131e, c1131e.m5831b(this.f5620s.mo5540b(), OplusGLSurfaceView_13) + OplusGLSurfaceView_13, list, c1131eM5828a);
            }
        }
        if (c1131e.m5830a(mo5540b(), OplusGLSurfaceView_13)) {
            if (!"__container".equals(mo5540b())) {
                c1131e2 = c1131e2.m5828a(mo5540b());
                if (c1131e.m5832c(mo5540b(), OplusGLSurfaceView_13)) {
                    list.add(c1131e2.m5827a(this));
                }
            }
            if (c1131e.m5833d(mo5540b(), OplusGLSurfaceView_13)) {
                mo5780b(c1131e, OplusGLSurfaceView_13 + c1131e.m5831b(mo5540b(), OplusGLSurfaceView_13), list, c1131e2);
            }
        }
    }

    @Override // com.airbnb.lottie.p084c.KeyPathElement_2
    /* renamed from: PlatformImplementations.kt_3 */
    public <T> void mo5534a(T t, LottieValueCallback<T> c1199c) {
        this.f5605d.m5622a(t, c1199c);
    }
}
