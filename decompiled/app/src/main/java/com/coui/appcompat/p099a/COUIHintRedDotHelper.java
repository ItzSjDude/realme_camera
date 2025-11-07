package com.coui.appcompat.p099a;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.AttributeSet;
import coui.support.appcompat.R;

/* compiled from: COUIHintRedDotHelper.java */
/* renamed from: com.coui.appcompat.PlatformImplementations.kt_3.COUIBaseListPopupWindow_11 */
/* loaded from: classes.dex */
public class COUIHintRedDotHelper {

    /* renamed from: PlatformImplementations.kt_3 */
    private int f6317a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f6318b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f6319c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f6320d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f6321e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f6322f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f6323g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f6324h;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f6325i;

    /* renamed from: OplusGLSurfaceView_15 */
    private int f6326j;

    /* renamed from: OplusGLSurfaceView_5 */
    private int f6327k;

    /* renamed from: OplusGLSurfaceView_14 */
    private int f6328l;

    /* renamed from: OplusGLSurfaceView_6 */
    private int f6329m;

    /* renamed from: OplusGLSurfaceView_11 */
    private int f6330n;

    /* renamed from: o */
    private TextPaint f6331o;

    /* renamed from: p */
    private Paint f6332p;

    public COUIHintRedDotHelper(Context context, AttributeSet attributeSet, int[] iArr, int OplusGLSurfaceView_13, int i2) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, OplusGLSurfaceView_13, i2);
        this.f6317a = typedArrayObtainStyledAttributes.getColor(R.styleable.COUIHintRedDot_couiHintRedDotColor, 0);
        this.f6318b = typedArrayObtainStyledAttributes.getColor(R.styleable.COUIHintRedDot_couiHintRedDotTextColor, 0);
        this.f6319c = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.COUIHintRedDot_couiHintTextSize, 0);
        this.f6320d = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.COUIHintRedDot_couiSmallWidth, 0);
        this.f6321e = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.COUIHintRedDot_couiMediumWidth, 0);
        this.f6322f = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.COUIHintRedDot_couiLargeWidth, 0);
        this.f6324h = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.COUIHintRedDot_couiHeight, 0);
        this.f6325i = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.COUIHintRedDot_couiCornerRadius, 0);
        this.f6326j = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.COUIHintRedDot_couiDotDiameter, 0);
        this.f6328l = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.COUIHintRedDot_couiEllipsisDiameter, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.f6327k = context.getResources().getDimensionPixelSize(R.dimen.coui_hint_red_dot_rect_radius);
        this.f6323g = context.getResources().getDimensionPixelSize(R.dimen.coui_hint_red_dot_navi_small_width);
        this.f6329m = context.getResources().getDimensionPixelSize(R.dimen.coui_hint_red_dot_ellipsis_spacing);
        this.f6330n = context.getResources().getDimensionPixelSize(R.dimen.coui_dot_stroke_width);
        this.f6331o = new TextPaint();
        this.f6331o.setAntiAlias(true);
        this.f6331o.setColor(this.f6318b);
        this.f6331o.setTextSize(this.f6319c);
        this.f6331o.setTypeface(Typeface.create("sans-serif-medium", 0));
        this.f6332p = new Paint();
        this.f6332p.setAntiAlias(true);
        this.f6332p.setColor(this.f6317a);
        this.f6332p.setStyle(Paint.Style.FILL);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m6415a(Canvas canvas, int OplusGLSurfaceView_13, int i2, RectF rectF) {
        if (OplusGLSurfaceView_13 != 0) {
            if (OplusGLSurfaceView_13 == 1) {
                m6407a(canvas, rectF);
                return;
            }
            if (OplusGLSurfaceView_13 == 2 || OplusGLSurfaceView_13 == 3) {
                m6406a(canvas, i2, rectF);
            } else {
                if (OplusGLSurfaceView_13 != 4) {
                    return;
                }
                m6409b(canvas, rectF);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m6407a(Canvas canvas, RectF rectF) {
        float COUIBaseListPopupWindow_12 = (rectF.bottom - rectF.top) / 2.0f;
        canvas.drawCircle(rectF.left + COUIBaseListPopupWindow_12, rectF.top + COUIBaseListPopupWindow_12, COUIBaseListPopupWindow_12, this.f6332p);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m6409b(Canvas canvas, RectF rectF) {
        float COUIBaseListPopupWindow_12 = (rectF.bottom - rectF.top) / 2.0f;
        canvas.drawCircle(rectF.left + COUIBaseListPopupWindow_12, rectF.top + COUIBaseListPopupWindow_12, COUIBaseListPopupWindow_12 - this.f6330n, this.f6332p);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m6406a(Canvas canvas, int OplusGLSurfaceView_13, RectF rectF) {
        Path pathM6452a;
        if (OplusGLSurfaceView_13 <= 0) {
            return;
        }
        if (Math.min(rectF.right - rectF.left, rectF.bottom - rectF.top) < this.f6325i * 2) {
            pathM6452a = COUIRoundRectUtil.m6450a().m6452a(rectF, ((int) Math.min(rectF.right - rectF.left, rectF.bottom - rectF.top)) / 2);
        } else {
            pathM6452a = COUIRoundRectUtil.m6450a().m6452a(rectF, this.f6325i);
        }
        canvas.drawPath(pathM6452a, this.f6332p);
        m6408b(canvas, OplusGLSurfaceView_13, 255, rectF);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m6414a(Canvas canvas, int OplusGLSurfaceView_13, int i2, int i3, int i4, RectF rectF) {
        canvas.drawPath(COUIRoundRectUtil.m6450a().m6452a(rectF, this.f6325i), this.f6332p);
        if (i2 > i4) {
            m6408b(canvas, OplusGLSurfaceView_13, i2, rectF);
            m6408b(canvas, i3, i4, rectF);
        } else {
            m6408b(canvas, i3, i4, rectF);
            m6408b(canvas, OplusGLSurfaceView_13, i2, rectF);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m6408b(Canvas canvas, int OplusGLSurfaceView_13, int i2, RectF rectF) {
        if (OplusGLSurfaceView_13 <= 0) {
            return;
        }
        this.f6331o.setAlpha(Math.max(0, Math.min(255, i2)));
        if (OplusGLSurfaceView_13 < 1000) {
            String strValueOf = String.valueOf(OplusGLSurfaceView_13);
            Paint.FontMetricsInt fontMetricsInt = this.f6331o.getFontMetricsInt();
            canvas.drawText(strValueOf, rectF.left + (((rectF.right - rectF.left) - ((int) this.f6331o.measureText(strValueOf))) / 2.0f), (((rectF.top + rectF.bottom) - fontMetricsInt.ascent) - fontMetricsInt.descent) / 2.0f, this.f6331o);
            return;
        }
        float COUIBaseListPopupWindow_12 = (rectF.left + rectF.right) / 2.0f;
        float f2 = (rectF.top + rectF.bottom) / 2.0f;
        for (int i3 = -1; i3 <= 1; i3++) {
            int i4 = this.f6329m;
            canvas.drawCircle(((i4 + r2) * i3) + COUIBaseListPopupWindow_12, f2, this.f6328l / 2.0f, this.f6331o);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int m6413a(int OplusGLSurfaceView_13, int i2) {
        if (OplusGLSurfaceView_13 == 0) {
            return 0;
        }
        if (OplusGLSurfaceView_13 != 1) {
            if (OplusGLSurfaceView_13 == 2) {
                return m6410l(i2);
            }
            if (OplusGLSurfaceView_13 == 3) {
                return m6411m(i2);
            }
            if (OplusGLSurfaceView_13 != 4) {
                return 0;
            }
        }
        return this.f6326j;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int m6412a(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == 0) {
            return 0;
        }
        if (OplusGLSurfaceView_13 != 1) {
            if (OplusGLSurfaceView_13 == 2) {
                return m6405a();
            }
            if (OplusGLSurfaceView_13 == 3) {
                return this.f6321e / 2;
            }
            if (OplusGLSurfaceView_13 != 4) {
                return 0;
            }
        }
        return this.f6326j;
    }

    /* renamed from: OplusGLSurfaceView_14 */
    private int m6410l(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 < 10) {
            return this.f6320d;
        }
        if (OplusGLSurfaceView_13 < 100) {
            return this.f6321e;
        }
        if (OplusGLSurfaceView_13 < 1000) {
            return this.f6322f;
        }
        return this.f6321e;
    }

    /* renamed from: OplusGLSurfaceView_6 */
    private int m6411m(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 < 10) {
            return this.f6323g;
        }
        if (OplusGLSurfaceView_13 < 100) {
            return this.f6320d;
        }
        return this.f6321e;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m6405a() {
        return this.f6324h;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m6416b(int OplusGLSurfaceView_13) {
        this.f6317a = OplusGLSurfaceView_13;
        this.f6332p.setColor(this.f6317a);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m6417c(int OplusGLSurfaceView_13) {
        this.f6318b = OplusGLSurfaceView_13;
        this.f6331o.setColor(this.f6318b);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m6418d(int OplusGLSurfaceView_13) {
        this.f6319c = OplusGLSurfaceView_13;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m6419e(int OplusGLSurfaceView_13) {
        this.f6320d = OplusGLSurfaceView_13;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m6420f(int OplusGLSurfaceView_13) {
        this.f6321e = OplusGLSurfaceView_13;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m6421g(int OplusGLSurfaceView_13) {
        this.f6322f = OplusGLSurfaceView_13;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public void m6422h(int OplusGLSurfaceView_13) {
        this.f6324h = OplusGLSurfaceView_13;
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public void m6423i(int OplusGLSurfaceView_13) {
        this.f6325i = OplusGLSurfaceView_13;
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public void m6424j(int OplusGLSurfaceView_13) {
        this.f6326j = OplusGLSurfaceView_13;
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public void m6425k(int OplusGLSurfaceView_13) {
        this.f6328l = OplusGLSurfaceView_13;
    }
}
