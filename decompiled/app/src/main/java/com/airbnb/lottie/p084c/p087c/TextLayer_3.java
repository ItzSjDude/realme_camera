package com.airbnb.lottie.p084c.p087c;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.InterfaceC1205k;
import com.airbnb.lottie.p080a.p081a.ContentGroup_2;
import com.airbnb.lottie.p080a.p082b.BaseKeyframeAnimation_3;
import com.airbnb.lottie.p080a.p082b.TextKeyframeAnimation_2;
import com.airbnb.lottie.p080a.p082b.ValueCallbackKeyframeAnimation_2;
import com.airbnb.lottie.p084c.DocumentData_3;
import com.airbnb.lottie.p084c.Font_2;
import com.airbnb.lottie.p084c.FontCharacter_2;
import com.airbnb.lottie.p084c.p085a.AnimatableTextProperties_2;
import com.airbnb.lottie.p084c.p086b.ShapeGroup_2;
import com.airbnb.lottie.p091f.Utils_4;
import com.airbnb.lottie.p092g.LottieValueCallback;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: TextLayer.java */
/* renamed from: com.airbnb.lottie.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3.COUIBaseListPopupWindow_10 */
/* loaded from: classes.dex */
public class TextLayer_3 extends BaseLayer_3 {

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final StringBuilder f5669e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final RectF f5670f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private final Matrix f5671g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private final Paint f5672h;

    /* renamed from: OplusGLSurfaceView_13 */
    private final Paint f5673i;

    /* renamed from: OplusGLSurfaceView_15 */
    private final Map<FontCharacter_2, List<ContentGroup_2>> f5674j;

    /* renamed from: OplusGLSurfaceView_5 */
    private final LongSparseArray<String> f5675k;

    /* renamed from: OplusGLSurfaceView_14 */
    private final TextKeyframeAnimation_2 f5676l;

    /* renamed from: OplusGLSurfaceView_6 */
    private final LottieDrawable f5677m;

    /* renamed from: OplusGLSurfaceView_11 */
    private final LottieComposition f5678n;

    /* renamed from: o */
    private BaseKeyframeAnimation_3<Integer, Integer> f5679o;

    /* renamed from: p */
    private BaseKeyframeAnimation_3<Integer, Integer> f5680p;

    /* renamed from: q */
    private BaseKeyframeAnimation_3<Integer, Integer> f5681q;

    /* renamed from: r */
    private BaseKeyframeAnimation_3<Integer, Integer> f5682r;

    /* renamed from: s */
    private BaseKeyframeAnimation_3<Float, Float> f5683s;

    /* renamed from: t */
    private BaseKeyframeAnimation_3<Float, Float> f5684t;

    /* renamed from: u */
    private BaseKeyframeAnimation_3<Float, Float> f5685u;

    /* renamed from: v */
    private BaseKeyframeAnimation_3<Float, Float> f5686v;

    /* renamed from: w */
    private BaseKeyframeAnimation_3<Float, Float> f5687w;

    /* renamed from: x */
    private BaseKeyframeAnimation_3<Float, Float> f5688x;

    TextLayer_3(LottieDrawable c1187f, Layer_4 c1125d) {
        super(c1187f, c1125d);
        this.f5669e = new StringBuilder(2);
        this.f5670f = new RectF();
        this.f5671g = new Matrix();
        int OplusGLSurfaceView_13 = 1;
        this.f5672h = new Paint(OplusGLSurfaceView_13) { // from class: com.airbnb.lottie.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3.COUIBaseListPopupWindow_10.1
            {
                setStyle(Paint.Style.FILL);
            }
        };
        this.f5673i = new Paint(OplusGLSurfaceView_13) { // from class: com.airbnb.lottie.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3.COUIBaseListPopupWindow_10.2
            {
                setStyle(Paint.Style.STROKE);
            }
        };
        this.f5674j = new HashMap();
        this.f5675k = new LongSparseArray<>();
        this.f5677m = c1187f;
        this.f5678n = c1125d.m5785a();
        this.f5676l = c1125d.m5804s().mo5647a();
        this.f5676l.m5576a(this);
        m5774a(this.f5676l);
        AnimatableTextProperties_2 c1099kM5805t = c1125d.m5805t();
        if (c1099kM5805t != null && c1099kM5805t.f5482a != null) {
            this.f5679o = c1099kM5805t.f5482a.mo5647a();
            this.f5679o.m5576a(this);
            m5774a(this.f5679o);
        }
        if (c1099kM5805t != null && c1099kM5805t.f5483b != null) {
            this.f5681q = c1099kM5805t.f5483b.mo5647a();
            this.f5681q.m5576a(this);
            m5774a(this.f5681q);
        }
        if (c1099kM5805t != null && c1099kM5805t.f5484c != null) {
            this.f5683s = c1099kM5805t.f5484c.mo5647a();
            this.f5683s.m5576a(this);
            m5774a(this.f5683s);
        }
        if (c1099kM5805t == null || c1099kM5805t.f5485d == null) {
            return;
        }
        this.f5685u = c1099kM5805t.f5485d.mo5647a();
        this.f5685u.m5576a(this);
        m5774a(this.f5685u);
    }

    @Override // com.airbnb.lottie.p084c.p087c.BaseLayer_3, com.airbnb.lottie.p080a.p081a.DrawingContent_2
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo5532a(RectF rectF, Matrix matrix, boolean z) {
        super.mo5532a(rectF, matrix, z);
        rectF.set(0.0f, 0.0f, this.f5678n.m5851d().width(), this.f5678n.m5851d().height());
    }

    @Override // com.airbnb.lottie.p084c.p087c.BaseLayer_3
    /* renamed from: IntrinsicsJvm.kt_4 */
    void mo5777b(Canvas canvas, Matrix matrix, int OplusGLSurfaceView_13) {
        canvas.save();
        if (!this.f5677m.m6078r()) {
            canvas.concat(matrix);
        }
        DocumentData_3 c1103bG = this.f5676l.mo5583g();
        Font_2 c1121c = this.f5678n.m5858k().get(c1103bG.f5497b);
        if (c1121c == null) {
            canvas.restore();
            return;
        }
        BaseKeyframeAnimation_3<Integer, Integer> abstractC1068a = this.f5680p;
        if (abstractC1068a != null) {
            this.f5672h.setColor(abstractC1068a.mo5583g().intValue());
        } else {
            BaseKeyframeAnimation_3<Integer, Integer> abstractC1068a2 = this.f5679o;
            if (abstractC1068a2 != null) {
                this.f5672h.setColor(abstractC1068a2.mo5583g().intValue());
            } else {
                this.f5672h.setColor(c1103bG.f5503h);
            }
        }
        BaseKeyframeAnimation_3<Integer, Integer> abstractC1068a3 = this.f5682r;
        if (abstractC1068a3 != null) {
            this.f5673i.setColor(abstractC1068a3.mo5583g().intValue());
        } else {
            BaseKeyframeAnimation_3<Integer, Integer> abstractC1068a4 = this.f5681q;
            if (abstractC1068a4 != null) {
                this.f5673i.setColor(abstractC1068a4.mo5583g().intValue());
            } else {
                this.f5673i.setColor(c1103bG.f5504i);
            }
        }
        int iIntValue = ((this.f5605d.m5618a() == null ? 100 : this.f5605d.m5618a().mo5583g().intValue()) * 255) / 100;
        this.f5672h.setAlpha(iIntValue);
        this.f5673i.setAlpha(iIntValue);
        BaseKeyframeAnimation_3<Float, Float> abstractC1068a5 = this.f5684t;
        if (abstractC1068a5 != null) {
            this.f5673i.setStrokeWidth(abstractC1068a5.mo5583g().floatValue());
        } else {
            BaseKeyframeAnimation_3<Float, Float> abstractC1068a6 = this.f5683s;
            if (abstractC1068a6 != null) {
                this.f5673i.setStrokeWidth(abstractC1068a6.mo5583g().floatValue());
            } else {
                this.f5673i.setStrokeWidth(c1103bG.f5505j * Utils_4.m6139a() * Utils_4.m6141a(matrix));
            }
        }
        if (this.f5677m.m6078r()) {
            m5814a(c1103bG, matrix, c1121c, canvas);
        } else {
            m5815a(c1103bG, c1121c, matrix, canvas);
        }
        canvas.restore();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m5814a(DocumentData_3 c1103b, Matrix matrix, Font_2 c1121c, Canvas canvas) {
        float fFloatValue;
        BaseKeyframeAnimation_3<Float, Float> abstractC1068a = this.f5688x;
        if (abstractC1068a != null) {
            fFloatValue = abstractC1068a.mo5583g().floatValue();
        } else {
            BaseKeyframeAnimation_3<Float, Float> abstractC1068a2 = this.f5687w;
            if (abstractC1068a2 != null) {
                fFloatValue = abstractC1068a2.mo5583g().floatValue();
            } else {
                fFloatValue = c1103b.f5498c;
            }
        }
        float COUIBaseListPopupWindow_12 = fFloatValue / 100.0f;
        float fM6141a = Utils_4.m6141a(matrix);
        String str = c1103b.f5496a;
        float fM6139a = c1103b.f5501f * Utils_4.m6139a();
        List<String> listM5811a = m5811a(str);
        int size = listM5811a.size();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            String str2 = listM5811a.get(OplusGLSurfaceView_13);
            float fM5808a = m5808a(str2, c1121c, COUIBaseListPopupWindow_12, fM6141a);
            canvas.save();
            m5813a(c1103b.f5499d, canvas, fM5808a);
            canvas.translate(0.0f, (OplusGLSurfaceView_13 * fM6139a) - (((size - 1) * fM6139a) / 2.0f));
            m5820a(str2, c1103b, matrix, c1121c, canvas, fM6141a, COUIBaseListPopupWindow_12);
            canvas.restore();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m5820a(String str, DocumentData_3 c1103b, Matrix matrix, Font_2 c1121c, Canvas canvas, float COUIBaseListPopupWindow_12, float f2) {
        float fFloatValue;
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < str.length(); OplusGLSurfaceView_13++) {
            FontCharacter_2 c1130d = this.f5678n.m5857j().get(FontCharacter_2.m5822a(str.charAt(OplusGLSurfaceView_13), c1121c.m5751a(), c1121c.m5753c()));
            if (c1130d != null) {
                m5816a(c1130d, matrix, f2, c1103b, canvas);
                float fM5824b = ((float) c1130d.m5824b()) * f2 * Utils_4.m6139a() * COUIBaseListPopupWindow_12;
                float f3 = c1103b.f5500e / 10.0f;
                BaseKeyframeAnimation_3<Float, Float> abstractC1068a = this.f5686v;
                if (abstractC1068a != null) {
                    fFloatValue = abstractC1068a.mo5583g().floatValue();
                } else {
                    BaseKeyframeAnimation_3<Float, Float> abstractC1068a2 = this.f5685u;
                    if (abstractC1068a2 != null) {
                        fFloatValue = abstractC1068a2.mo5583g().floatValue();
                    }
                    canvas.translate(fM5824b + (f3 * COUIBaseListPopupWindow_12), 0.0f);
                }
                f3 += fFloatValue;
                canvas.translate(fM5824b + (f3 * COUIBaseListPopupWindow_12), 0.0f);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00a7 A[LOOP:0: B:23:0x00a5->B:24:0x00a7, LOOP_END] */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void m5815a(com.airbnb.lottie.p084c.DocumentData_3 r7, com.airbnb.lottie.p084c.Font_2 r8, android.graphics.Matrix r9, android.graphics.Canvas r10) {
        /*
            r6 = this;
            com.airbnb.lottie.p091f.Utils_4.m6141a(r9)
            com.airbnb.lottie.COUIBaseListPopupWindow_12 r9 = r6.f5677m
            java.lang.String r0 = r8.m5751a()
            java.lang.String r8 = r8.m5753c()
            android.graphics.Typeface r8 = r9.m6031a(r0, r8)
            if (r8 != 0) goto L14
            return
        L14:
            java.lang.String r9 = r7.f5496a
            com.airbnb.lottie.COUIBaseListPopupWindow_12 r0 = r6.f5677m
            com.airbnb.lottie.q r0 = r0.m6077q()
            if (r0 == 0) goto L22
            java.lang.String r9 = r0.m6198a(r9)
        L22:
            android.graphics.Paint r0 = r6.f5672h
            r0.setTypeface(r8)
            com.airbnb.lottie.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3<java.lang.Float, java.lang.Float> r8 = r6.f5688x
            if (r8 == 0) goto L36
            java.lang.Object r8 = r8.mo5583g()
            java.lang.Float r8 = (java.lang.Float) r8
            float r8 = r8.floatValue()
            goto L47
        L36:
            com.airbnb.lottie.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3<java.lang.Float, java.lang.Float> r8 = r6.f5687w
            if (r8 == 0) goto L45
            java.lang.Object r8 = r8.mo5583g()
            java.lang.Float r8 = (java.lang.Float) r8
            float r8 = r8.floatValue()
            goto L47
        L45:
            float r8 = r7.f5498c
        L47:
            android.graphics.Paint r0 = r6.f5672h
            float r1 = com.airbnb.lottie.p091f.Utils_4.m6139a()
            float r1 = r1 * r8
            r0.setTextSize(r1)
            android.graphics.Paint r0 = r6.f5673i
            android.graphics.Paint r1 = r6.f5672h
            android.graphics.Typeface r1 = r1.getTypeface()
            r0.setTypeface(r1)
            android.graphics.Paint r0 = r6.f5673i
            android.graphics.Paint r1 = r6.f5672h
            float r1 = r1.getTextSize()
            r0.setTextSize(r1)
            float r0 = r7.f5501f
            float r1 = com.airbnb.lottie.p091f.Utils_4.m6139a()
            float r0 = r0 * r1
            int r1 = r7.f5500e
            float r1 = (float) r1
            r2 = 1092616192(0x41200000, float:10.0)
            float r1 = r1 / r2
            com.airbnb.lottie.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3<java.lang.Float, java.lang.Float> r2 = r6.f5686v
            if (r2 == 0) goto L84
            java.lang.Object r2 = r2.mo5583g()
            java.lang.Float r2 = (java.lang.Float) r2
            float r2 = r2.floatValue()
        L82:
            float r1 = r1 + r2
            goto L93
        L84:
            com.airbnb.lottie.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3<java.lang.Float, java.lang.Float> r2 = r6.f5685u
            if (r2 == 0) goto L93
            java.lang.Object r2 = r2.mo5583g()
            java.lang.Float r2 = (java.lang.Float) r2
            float r2 = r2.floatValue()
            goto L82
        L93:
            float r2 = com.airbnb.lottie.p091f.Utils_4.m6139a()
            float r1 = r1 * r2
            float r1 = r1 * r8
            r8 = 1120403456(0x42c80000, float:100.0)
            float r1 = r1 / r8
            java.util.List r8 = r6.m5811a(r9)
            int r9 = r8.size()
            r2 = 0
        La5:
            if (r2 >= r9) goto Ldb
            java.lang.Object r3 = r8.get(r2)
            java.lang.String r3 = (java.lang.String) r3
            android.graphics.Paint r4 = r6.f5673i
            float r4 = r4.measureText(r3)
            int r5 = r3.length()
            int r5 = r5 + (-1)
            float r5 = (float) r5
            float r5 = r5 * r1
            float r4 = r4 + r5
            r10.save()
            com.airbnb.lottie.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_4$PlatformImplementations.kt_3 r5 = r7.f5499d
            r6.m5813a(r5, r10, r4)
            int r4 = r9 + (-1)
            float r4 = (float) r4
            float r4 = r4 * r0
            r5 = 1073741824(0x40000000, float:2.0)
            float r4 = r4 / r5
            float r5 = (float) r2
            float r5 = r5 * r0
            float r5 = r5 - r4
            r4 = 0
            r10.translate(r4, r5)
            r6.m5819a(r3, r7, r10, r1)
            r10.restore()
            int r2 = r2 + 1
            goto La5
        Ldb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.p084c.p087c.TextLayer_3.m5815a(com.airbnb.lottie.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_4, com.airbnb.lottie.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3, android.graphics.Matrix, android.graphics.Canvas):void");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private List<String> m5811a(String str) {
        return Arrays.asList(str.replaceAll("\r\OplusGLSurfaceView_11", "\r").replaceAll("\OplusGLSurfaceView_11", "\r").split("\r"));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m5819a(String str, DocumentData_3 c1103b, Canvas canvas, float COUIBaseListPopupWindow_12) {
        int length = 0;
        while (length < str.length()) {
            String strM5809a = m5809a(str, length);
            length += strM5809a.length();
            m5818a(strM5809a, c1103b, canvas);
            canvas.translate(this.f5672h.measureText(strM5809a) + COUIBaseListPopupWindow_12, 0.0f);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private float m5808a(String str, Font_2 c1121c, float COUIBaseListPopupWindow_12, float f2) {
        float fM5824b = 0.0f;
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < str.length(); OplusGLSurfaceView_13++) {
            FontCharacter_2 c1130d = this.f5678n.m5857j().get(FontCharacter_2.m5822a(str.charAt(OplusGLSurfaceView_13), c1121c.m5751a(), c1121c.m5753c()));
            if (c1130d != null) {
                fM5824b = (float) (fM5824b + (c1130d.m5824b() * COUIBaseListPopupWindow_12 * Utils_4.m6139a() * f2));
            }
        }
        return fM5824b;
    }

    /* compiled from: TextLayer.java */
    /* renamed from: com.airbnb.lottie.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3.COUIBaseListPopupWindow_10$3, reason: invalid class name */
    static /* synthetic */ class ZoomSeekBar_4 {

        /* renamed from: PlatformImplementations.kt_3 */
        static final /* synthetic */ int[] f5691a = new int[DocumentData_3.PlatformImplementations.kt_3.values().length];

        static {
            try {
                f5691a[DocumentData_3.PlatformImplementations.kt_3.LEFT_ALIGN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5691a[DocumentData_3.PlatformImplementations.kt_3.RIGHT_ALIGN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5691a[DocumentData_3.PlatformImplementations.kt_3.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m5813a(DocumentData_3.PlatformImplementations.kt_3 aVar, Canvas canvas, float COUIBaseListPopupWindow_12) {
        int OplusGLSurfaceView_13 = ZoomSeekBar_4.f5691a[aVar.ordinal()];
        if (OplusGLSurfaceView_13 != 1) {
            if (OplusGLSurfaceView_13 == 2) {
                canvas.translate(-COUIBaseListPopupWindow_12, 0.0f);
            } else {
                if (OplusGLSurfaceView_13 != 3) {
                    return;
                }
                canvas.translate((-COUIBaseListPopupWindow_12) / 2.0f, 0.0f);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m5816a(FontCharacter_2 c1130d, Matrix matrix, float COUIBaseListPopupWindow_12, DocumentData_3 c1103b, Canvas canvas) {
        List<ContentGroup_2> listM5810a = m5810a(c1130d);
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < listM5810a.size(); OplusGLSurfaceView_13++) {
            Path pathMo5546e = listM5810a.get(OplusGLSurfaceView_13).mo5546e();
            pathMo5546e.computeBounds(this.f5670f, false);
            this.f5671g.set(matrix);
            this.f5671g.preTranslate(0.0f, (-c1103b.f5502g) * Utils_4.m6139a());
            this.f5671g.preScale(COUIBaseListPopupWindow_12, COUIBaseListPopupWindow_12);
            pathMo5546e.transform(this.f5671g);
            if (c1103b.f5506k) {
                m5812a(pathMo5546e, this.f5672h, canvas);
                m5812a(pathMo5546e, this.f5673i, canvas);
            } else {
                m5812a(pathMo5546e, this.f5673i, canvas);
                m5812a(pathMo5546e, this.f5672h, canvas);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m5812a(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawPath(path, paint);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m5818a(String str, DocumentData_3 c1103b, Canvas canvas) {
        if (c1103b.f5506k) {
            m5817a(str, this.f5672h, canvas);
            m5817a(str, this.f5673i, canvas);
        } else {
            m5817a(str, this.f5673i, canvas);
            m5817a(str, this.f5672h, canvas);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m5817a(String str, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawText(str, 0, str.length(), 0.0f, 0.0f, paint);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private List<ContentGroup_2> m5810a(FontCharacter_2 c1130d) {
        if (this.f5674j.containsKey(c1130d)) {
            return this.f5674j.get(c1130d);
        }
        List<ShapeGroup_2> listM5823a = c1130d.m5823a();
        int size = listM5823a.size();
        ArrayList arrayList = new ArrayList(size);
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            arrayList.add(new ContentGroup_2(this.f5677m, this, listM5823a.get(OplusGLSurfaceView_13)));
        }
        this.f5674j.put(c1130d, arrayList);
        return arrayList;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private String m5809a(String str, int OplusGLSurfaceView_13) {
        int iCodePointAt = str.codePointAt(OplusGLSurfaceView_13);
        int iCharCount = Character.charCount(iCodePointAt) + OplusGLSurfaceView_13;
        while (iCharCount < str.length()) {
            int iCodePointAt2 = str.codePointAt(iCharCount);
            if (!m5821a(iCodePointAt2)) {
                break;
            }
            iCharCount += Character.charCount(iCodePointAt2);
            iCodePointAt = (iCodePointAt * 31) + iCodePointAt2;
        }
        long OplusGLSurfaceView_15 = iCodePointAt;
        if (this.f5675k.containsKey(OplusGLSurfaceView_15)) {
            return this.f5675k.get(OplusGLSurfaceView_15);
        }
        this.f5669e.setLength(0);
        while (OplusGLSurfaceView_13 < iCharCount) {
            int iCodePointAt3 = str.codePointAt(OplusGLSurfaceView_13);
            this.f5669e.appendCodePoint(iCodePointAt3);
            OplusGLSurfaceView_13 += Character.charCount(iCodePointAt3);
        }
        String string = this.f5669e.toString();
        this.f5675k.put(OplusGLSurfaceView_15, string);
        return string;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m5821a(int OplusGLSurfaceView_13) {
        return Character.getType(OplusGLSurfaceView_13) == 16 || Character.getType(OplusGLSurfaceView_13) == 27 || Character.getType(OplusGLSurfaceView_13) == 6 || Character.getType(OplusGLSurfaceView_13) == 28 || Character.getType(OplusGLSurfaceView_13) == 19;
    }

    @Override // com.airbnb.lottie.p084c.p087c.BaseLayer_3, com.airbnb.lottie.p084c.KeyPathElement_2
    /* renamed from: PlatformImplementations.kt_3 */
    public <T> void mo5534a(T t, LottieValueCallback<T> c1199c) {
        super.mo5534a((TextLayer_3) t, (LottieValueCallback<TextLayer_3>) c1199c);
        if (t == InterfaceC1205k.f5928a) {
            BaseKeyframeAnimation_3<Integer, Integer> abstractC1068a = this.f5680p;
            if (abstractC1068a != null) {
                m5778b(abstractC1068a);
            }
            if (c1199c == null) {
                this.f5680p = null;
                return;
            }
            this.f5680p = new ValueCallbackKeyframeAnimation_2(c1199c);
            this.f5680p.m5576a(this);
            m5774a(this.f5680p);
            return;
        }
        if (t == InterfaceC1205k.f5929b) {
            BaseKeyframeAnimation_3<Integer, Integer> abstractC1068a2 = this.f5682r;
            if (abstractC1068a2 != null) {
                m5778b(abstractC1068a2);
            }
            if (c1199c == null) {
                this.f5682r = null;
                return;
            }
            this.f5682r = new ValueCallbackKeyframeAnimation_2(c1199c);
            this.f5682r.m5576a(this);
            m5774a(this.f5682r);
            return;
        }
        if (t == InterfaceC1205k.f5944q) {
            BaseKeyframeAnimation_3<Float, Float> abstractC1068a3 = this.f5684t;
            if (abstractC1068a3 != null) {
                m5778b(abstractC1068a3);
            }
            if (c1199c == null) {
                this.f5684t = null;
                return;
            }
            this.f5684t = new ValueCallbackKeyframeAnimation_2(c1199c);
            this.f5684t.m5576a(this);
            m5774a(this.f5684t);
            return;
        }
        if (t == InterfaceC1205k.f5945r) {
            BaseKeyframeAnimation_3<Float, Float> abstractC1068a4 = this.f5686v;
            if (abstractC1068a4 != null) {
                m5778b(abstractC1068a4);
            }
            if (c1199c == null) {
                this.f5686v = null;
                return;
            }
            this.f5686v = new ValueCallbackKeyframeAnimation_2(c1199c);
            this.f5686v.m5576a(this);
            m5774a(this.f5686v);
            return;
        }
        if (t == InterfaceC1205k.f5925D) {
            BaseKeyframeAnimation_3<Float, Float> abstractC1068a5 = this.f5688x;
            if (abstractC1068a5 != null) {
                m5778b(abstractC1068a5);
            }
            if (c1199c == null) {
                this.f5688x = null;
                return;
            }
            this.f5688x = new ValueCallbackKeyframeAnimation_2(c1199c);
            this.f5688x.m5576a(this);
            m5774a(this.f5688x);
        }
    }
}
