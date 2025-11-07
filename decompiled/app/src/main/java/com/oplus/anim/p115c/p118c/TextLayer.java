package com.oplus.anim.p115c.p118c;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextUtils;
import com.oplus.anim.EffectiveAnimationComposition;
import com.oplus.anim.EffectiveAnimationDrawable;
import com.oplus.anim.L;
import com.oplus.anim.TextDelegate;
import com.oplus.anim.InterfaceC2361d;
import com.oplus.anim.p111a.p112a.ContentGroup;
import com.oplus.anim.p111a.p113b.BaseKeyframeAnimation;
import com.oplus.anim.p111a.p113b.TextKeyframeAnimation;
import com.oplus.anim.p115c.DocumentData;
import com.oplus.anim.p115c.Font;
import com.oplus.anim.p115c.FontCharacter;
import com.oplus.anim.p115c.p116a.AnimatableTextProperties;
import com.oplus.anim.p115c.p117b.ShapeGroup;
import com.oplus.anim.p121f.Utils_2;
import com.oplus.anim.p122g.EffectiveValueCallback;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: TextLayer.java */
/* renamed from: com.oplus.anim.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3.COUIBaseListPopupWindow_10 */
/* loaded from: classes2.dex */
public class TextLayer extends BaseLayer {

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final char[] f10286e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final RectF f10287f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private final Matrix f10288g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private final Paint f10289h;

    /* renamed from: OplusGLSurfaceView_13 */
    private final Paint f10290i;

    /* renamed from: OplusGLSurfaceView_15 */
    private final Map<FontCharacter, List<ContentGroup>> f10291j;

    /* renamed from: OplusGLSurfaceView_5 */
    private final TextKeyframeAnimation f10292k;

    /* renamed from: OplusGLSurfaceView_14 */
    private final EffectiveAnimationDrawable f10293l;

    /* renamed from: OplusGLSurfaceView_6 */
    private final EffectiveAnimationComposition f10294m;

    /* renamed from: OplusGLSurfaceView_11 */
    private BaseKeyframeAnimation<Integer, Integer> f10295n;

    /* renamed from: o */
    private BaseKeyframeAnimation<Integer, Integer> f10296o;

    /* renamed from: p */
    private BaseKeyframeAnimation<Float, Float> f10297p;

    /* renamed from: q */
    private BaseKeyframeAnimation<Float, Float> f10298q;

    TextLayer(EffectiveAnimationDrawable c2309b, Layer c2350d) {
        super(c2309b, c2350d);
        int OplusGLSurfaceView_13 = 1;
        this.f10286e = new char[1];
        this.f10287f = new RectF();
        this.f10288g = new Matrix();
        this.f10289h = new Paint(OplusGLSurfaceView_13) { // from class: com.oplus.anim.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3.COUIBaseListPopupWindow_10.1
            {
                setStyle(Paint.Style.FILL);
            }
        };
        this.f10290i = new Paint(OplusGLSurfaceView_13) { // from class: com.oplus.anim.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3.COUIBaseListPopupWindow_10.2
            {
                setStyle(Paint.Style.STROKE);
            }
        };
        this.f10291j = new HashMap();
        this.f10293l = c2309b;
        this.f10294m = c2350d.m9092a();
        this.f10292k = c2350d.m9111s().mo8957a();
        this.f10292k.m8847a(this);
        m9082a(this.f10292k);
        AnimatableTextProperties c2324kM9112t = c2350d.m9112t();
        if (c2324kM9112t != null && c2324kM9112t.f10104a != null) {
            this.f10295n = c2324kM9112t.f10104a.mo8957a();
            this.f10295n.m8847a(this);
            m9082a(this.f10295n);
        }
        if (c2324kM9112t != null && c2324kM9112t.f10105b != null) {
            this.f10296o = c2324kM9112t.f10105b.mo8957a();
            this.f10296o.m8847a(this);
            m9082a(this.f10296o);
        }
        if (c2324kM9112t != null && c2324kM9112t.f10106c != null) {
            this.f10297p = c2324kM9112t.f10106c.mo8957a();
            this.f10297p.m8847a(this);
            m9082a(this.f10297p);
        }
        if (c2324kM9112t == null || c2324kM9112t.f10107d == null) {
            return;
        }
        this.f10298q = c2324kM9112t.f10107d.mo8957a();
        this.f10298q.m8847a(this);
        m9082a(this.f10298q);
    }

    @Override // com.oplus.anim.p115c.p118c.BaseLayer, com.oplus.anim.p111a.p112a.DrawingContent
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo8808a(RectF rectF, Matrix matrix, boolean z) {
        super.mo8808a(rectF, matrix, z);
        rectF.set(0.0f, 0.0f, this.f10294m.m8793d().width(), this.f10294m.m8793d().height());
    }

    @Override // com.oplus.anim.p115c.p118c.BaseLayer
    /* renamed from: IntrinsicsJvm.kt_4 */
    void mo9085b(Canvas canvas, Matrix matrix, int OplusGLSurfaceView_13) {
        L.m9349c("TextLayer#draw");
        canvas.save();
        if (!this.f10293l.m8936p()) {
            canvas.setMatrix(matrix);
        }
        DocumentData c2328bG = this.f10292k.mo8854g();
        Font c2355d = this.f10294m.m8800k().get(c2328bG.f10119b);
        if (c2355d == null) {
            canvas.restore();
            return;
        }
        BaseKeyframeAnimation<Integer, Integer> abstractC2293a = this.f10295n;
        if (abstractC2293a != null) {
            this.f10289h.setColor(abstractC2293a.mo8854g().intValue());
        } else {
            this.f10289h.setColor(c2328bG.f10125h);
        }
        BaseKeyframeAnimation<Integer, Integer> abstractC2293a2 = this.f10296o;
        if (abstractC2293a2 != null) {
            this.f10290i.setColor(abstractC2293a2.mo8854g().intValue());
        } else {
            this.f10290i.setColor(c2328bG.f10126i);
        }
        int iIntValue = ((this.f10225d.m8879a() == null ? 100 : this.f10225d.m8879a().mo8854g().intValue()) * 255) / 100;
        this.f10289h.setAlpha(iIntValue);
        this.f10290i.setAlpha(iIntValue);
        BaseKeyframeAnimation<Float, Float> abstractC2293a3 = this.f10297p;
        if (abstractC2293a3 != null) {
            this.f10290i.setStrokeWidth(abstractC2293a3.mo8854g().floatValue());
        } else {
            this.f10290i.setStrokeWidth((float) (c2328bG.f10127j * Utils_2.m9288a() * Utils_2.m9289a(matrix)));
        }
        if (this.f10293l.m8936p()) {
            m9121a(c2328bG, matrix, c2355d, canvas);
        } else {
            m9122a(c2328bG, c2355d, matrix, canvas);
        }
        canvas.restore();
        L.m9350d("TextLayer#draw");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m9121a(DocumentData c2328b, Matrix matrix, Font c2355d, Canvas canvas) {
        float COUIBaseListPopupWindow_12 = ((float) c2328b.f10120c) / 100.0f;
        float fM9289a = Utils_2.m9289a(matrix);
        String str = c2328b.f10118a;
        float fM9288a = ((float) c2328b.f10123f) * Utils_2.m9288a();
        List<String> listM9117a = m9117a(str);
        int size = listM9117a.size();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            String str2 = listM9117a.get(OplusGLSurfaceView_13);
            float fM9115a = m9115a(str2, c2355d, COUIBaseListPopupWindow_12, fM9289a);
            canvas.save();
            m9120a(c2328b.f10121d, canvas, fM9115a);
            canvas.translate(0.0f, (OplusGLSurfaceView_13 * fM9288a) - (((size - 1) * fM9288a) / 2.0f));
            m9125a(str2, c2328b, matrix, c2355d, canvas, fM9289a, COUIBaseListPopupWindow_12);
            canvas.restore();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m9125a(String str, DocumentData c2328b, Matrix matrix, Font c2355d, Canvas canvas, float COUIBaseListPopupWindow_12, float f2) {
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < str.length(); OplusGLSurfaceView_13++) {
            FontCharacter c2356e = this.f10294m.m8799j().get(FontCharacter.m9130a(str.charAt(OplusGLSurfaceView_13), c2355d.m9127a(), c2355d.m9129c()));
            if (c2356e != null) {
                m9123a(c2356e, matrix, f2, c2328b, canvas);
                float fM9132b = ((float) c2356e.m9132b()) * f2 * Utils_2.m9288a() * COUIBaseListPopupWindow_12;
                float fFloatValue = c2328b.f10122e / 10.0f;
                BaseKeyframeAnimation<Float, Float> abstractC2293a = this.f10298q;
                if (abstractC2293a != null) {
                    fFloatValue += abstractC2293a.mo8854g().floatValue();
                }
                canvas.translate(fM9132b + (fFloatValue * COUIBaseListPopupWindow_12), 0.0f);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m9122a(DocumentData c2328b, Font c2355d, Matrix matrix, Canvas canvas) {
        Typeface typefaceM8896a;
        float fM9289a = Utils_2.m9289a(matrix);
        if (!TextUtils.isEmpty(c2355d.m9127a()) && c2355d.m9127a().contains("ColorFont")) {
            typefaceM8896a = Utils_2.m9292a(Typeface.create(Typeface.DEFAULT, 0), c2355d.m9129c());
        } else {
            typefaceM8896a = this.f10293l.m8896a(c2355d.m9127a(), c2355d.m9129c());
        }
        if (typefaceM8896a == null) {
            return;
        }
        String strM9357a = c2328b.f10118a;
        TextDelegate c2424pM8935o = this.f10293l.m8935o();
        if (c2424pM8935o != null) {
            strM9357a = c2424pM8935o.m9357a(strM9357a);
        }
        this.f10289h.setTypeface(typefaceM8896a);
        this.f10289h.setTextSize((float) (c2328b.f10120c * Utils_2.m9288a()));
        this.f10290i.setTypeface(this.f10289h.getTypeface());
        this.f10290i.setTextSize(this.f10289h.getTextSize());
        float fM9288a = ((float) c2328b.f10123f) * Utils_2.m9288a();
        List<String> listM9117a = m9117a(strM9357a);
        int size = listM9117a.size();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            String str = listM9117a.get(OplusGLSurfaceView_13);
            m9120a(c2328b.f10121d, canvas, this.f10290i.measureText(str));
            canvas.translate(0.0f, (OplusGLSurfaceView_13 * fM9288a) - (((size - 1) * fM9288a) / 2.0f));
            m9124a(str, c2328b, canvas, fM9289a);
            canvas.setMatrix(matrix);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private List<String> m9117a(String str) {
        return Arrays.asList(str.replaceAll("\r\OplusGLSurfaceView_11", "\r").replaceAll("\OplusGLSurfaceView_11", "\r").split("\r"));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m9124a(String str, DocumentData c2328b, Canvas canvas, float COUIBaseListPopupWindow_12) {
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < str.length(); OplusGLSurfaceView_13++) {
            char cCharAt = str.charAt(OplusGLSurfaceView_13);
            m9118a(cCharAt, c2328b, canvas);
            char[] cArr = this.f10286e;
            cArr[0] = cCharAt;
            float fMeasureText = this.f10289h.measureText(cArr, 0, 1);
            float fFloatValue = c2328b.f10122e / 10.0f;
            BaseKeyframeAnimation<Float, Float> abstractC2293a = this.f10298q;
            if (abstractC2293a != null) {
                fFloatValue += abstractC2293a.mo8854g().floatValue();
            }
            canvas.translate(fMeasureText + (fFloatValue * COUIBaseListPopupWindow_12), 0.0f);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private float m9115a(String str, Font c2355d, float COUIBaseListPopupWindow_12, float f2) {
        float fM9132b = 0.0f;
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < str.length(); OplusGLSurfaceView_13++) {
            FontCharacter c2356e = this.f10294m.m8799j().get(FontCharacter.m9130a(str.charAt(OplusGLSurfaceView_13), c2355d.m9127a(), c2355d.m9129c()));
            if (c2356e != null) {
                fM9132b = (float) (fM9132b + (c2356e.m9132b() * COUIBaseListPopupWindow_12 * Utils_2.m9288a() * f2));
            }
        }
        return fM9132b;
    }

    /* compiled from: TextLayer.java */
    /* renamed from: com.oplus.anim.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3.COUIBaseListPopupWindow_10$3, reason: invalid class name */
    static /* synthetic */ class ZoomSeekBar_4 {

        /* renamed from: PlatformImplementations.kt_3 */
        static final /* synthetic */ int[] f10301a = new int[DocumentData.PlatformImplementations.kt_3.values().length];

        static {
            try {
                f10301a[DocumentData.PlatformImplementations.kt_3.LEFT_ALIGN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10301a[DocumentData.PlatformImplementations.kt_3.RIGHT_ALIGN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10301a[DocumentData.PlatformImplementations.kt_3.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m9120a(DocumentData.PlatformImplementations.kt_3 aVar, Canvas canvas, float COUIBaseListPopupWindow_12) {
        int OplusGLSurfaceView_13 = ZoomSeekBar_4.f10301a[aVar.ordinal()];
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
    private void m9123a(FontCharacter c2356e, Matrix matrix, float COUIBaseListPopupWindow_12, DocumentData c2328b, Canvas canvas) {
        List<ContentGroup> listM9116a = m9116a(c2356e);
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < listM9116a.size(); OplusGLSurfaceView_13++) {
            Path pathMo8821e = listM9116a.get(OplusGLSurfaceView_13).mo8821e();
            pathMo8821e.computeBounds(this.f10287f, false);
            this.f10288g.set(matrix);
            this.f10288g.preTranslate(0.0f, ((float) (-c2328b.f10124g)) * Utils_2.m9288a());
            this.f10288g.preScale(COUIBaseListPopupWindow_12, COUIBaseListPopupWindow_12);
            pathMo8821e.transform(this.f10288g);
            if (c2328b.f10128k) {
                m9119a(pathMo8821e, this.f10289h, canvas);
                m9119a(pathMo8821e, this.f10290i, canvas);
            } else {
                m9119a(pathMo8821e, this.f10290i, canvas);
                m9119a(pathMo8821e, this.f10289h, canvas);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m9119a(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawPath(path, paint);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m9118a(char c2, DocumentData c2328b, Canvas canvas) {
        this.f10286e[0] = c2;
        if (c2328b.f10128k) {
            m9126a(this.f10286e, this.f10289h, canvas);
            m9126a(this.f10286e, this.f10290i, canvas);
        } else {
            m9126a(this.f10286e, this.f10290i, canvas);
            m9126a(this.f10286e, this.f10289h, canvas);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m9126a(char[] cArr, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawText(cArr, 0, 1, 0.0f, 0.0f, paint);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private List<ContentGroup> m9116a(FontCharacter c2356e) {
        if (this.f10291j.containsKey(c2356e)) {
            return this.f10291j.get(c2356e);
        }
        List<ShapeGroup> listM9131a = c2356e.m9131a();
        int size = listM9131a.size();
        ArrayList arrayList = new ArrayList(size);
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            arrayList.add(new ContentGroup(this.f10293l, this, listM9131a.get(OplusGLSurfaceView_13)));
        }
        this.f10291j.put(c2356e, arrayList);
        return arrayList;
    }

    @Override // com.oplus.anim.p115c.p118c.BaseLayer, com.oplus.anim.p115c.KeyPathElement
    /* renamed from: PlatformImplementations.kt_3 */
    public <T> void mo8810a(T t, EffectiveValueCallback<T> c2412b) {
        BaseKeyframeAnimation<Float, Float> abstractC2293a;
        BaseKeyframeAnimation<Float, Float> abstractC2293a2;
        BaseKeyframeAnimation<Integer, Integer> abstractC2293a3;
        BaseKeyframeAnimation<Integer, Integer> abstractC2293a4;
        super.mo8810a((TextLayer) t, (EffectiveValueCallback<TextLayer>) c2412b);
        if (t == InterfaceC2361d.f10319a && (abstractC2293a4 = this.f10295n) != null) {
            abstractC2293a4.m8848a((EffectiveValueCallback<Integer>) c2412b);
            return;
        }
        if (t == InterfaceC2361d.f10320b && (abstractC2293a3 = this.f10296o) != null) {
            abstractC2293a3.m8848a((EffectiveValueCallback<Integer>) c2412b);
            return;
        }
        if (t == InterfaceC2361d.f10331m && (abstractC2293a2 = this.f10297p) != null) {
            abstractC2293a2.m8848a((EffectiveValueCallback<Float>) c2412b);
        } else {
            if (t != InterfaceC2361d.f10332n || (abstractC2293a = this.f10298q) == null) {
                return;
            }
            abstractC2293a.m8848a((EffectiveValueCallback<Float>) c2412b);
        }
    }
}
