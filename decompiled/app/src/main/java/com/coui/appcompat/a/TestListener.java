package com.coui.appcompat.a_renamed;

/* compiled from: COUIHintRedDotHelper.java */
/* loaded from: classes.dex */
public class g_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private int f2390a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f2391b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f2392c;
    private int d_renamed;
    private int e_renamed;
    private int f_renamed;
    private int g_renamed;
    private int h_renamed;
    private int i_renamed;
    private int j_renamed;
    private int k_renamed;
    private int l_renamed;
    private int m_renamed;
    private int n_renamed;
    private android.text.TextPaint o_renamed;
    private android.graphics.Paint p_renamed;

    public g_renamed(android.content.Context context, android.util.AttributeSet attributeSet, int[] iArr, int i_renamed, int i2) {
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i_renamed, i2);
        this.f2390a = typedArrayObtainStyledAttributes.getColor(coui.support.appcompat.R_renamed.styleable.COUIHintRedDot_couiHintRedDotColor, 0);
        this.f2391b = typedArrayObtainStyledAttributes.getColor(coui.support.appcompat.R_renamed.styleable.COUIHintRedDot_couiHintRedDotTextColor, 0);
        this.f2392c = typedArrayObtainStyledAttributes.getDimensionPixelSize(coui.support.appcompat.R_renamed.styleable.COUIHintRedDot_couiHintTextSize, 0);
        this.d_renamed = typedArrayObtainStyledAttributes.getDimensionPixelSize(coui.support.appcompat.R_renamed.styleable.COUIHintRedDot_couiSmallWidth, 0);
        this.e_renamed = typedArrayObtainStyledAttributes.getDimensionPixelSize(coui.support.appcompat.R_renamed.styleable.COUIHintRedDot_couiMediumWidth, 0);
        this.f_renamed = typedArrayObtainStyledAttributes.getDimensionPixelSize(coui.support.appcompat.R_renamed.styleable.COUIHintRedDot_couiLargeWidth, 0);
        this.h_renamed = typedArrayObtainStyledAttributes.getDimensionPixelSize(coui.support.appcompat.R_renamed.styleable.COUIHintRedDot_couiHeight, 0);
        this.i_renamed = typedArrayObtainStyledAttributes.getDimensionPixelSize(coui.support.appcompat.R_renamed.styleable.COUIHintRedDot_couiCornerRadius, 0);
        this.j_renamed = typedArrayObtainStyledAttributes.getDimensionPixelSize(coui.support.appcompat.R_renamed.styleable.COUIHintRedDot_couiDotDiameter, 0);
        this.l_renamed = typedArrayObtainStyledAttributes.getDimensionPixelSize(coui.support.appcompat.R_renamed.styleable.COUIHintRedDot_couiEllipsisDiameter, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.k_renamed = context.getResources().getDimensionPixelSize(coui.support.appcompat.R_renamed.dimen.coui_hint_red_dot_rect_radius);
        this.g_renamed = context.getResources().getDimensionPixelSize(coui.support.appcompat.R_renamed.dimen.coui_hint_red_dot_navi_small_width);
        this.m_renamed = context.getResources().getDimensionPixelSize(coui.support.appcompat.R_renamed.dimen.coui_hint_red_dot_ellipsis_spacing);
        this.n_renamed = context.getResources().getDimensionPixelSize(coui.support.appcompat.R_renamed.dimen.coui_dot_stroke_width);
        this.o_renamed = new android.text.TextPaint();
        this.o_renamed.setAntiAlias(true);
        this.o_renamed.setColor(this.f2391b);
        this.o_renamed.setTextSize(this.f2392c);
        this.o_renamed.setTypeface(android.graphics.Typeface.create("sans-serif-medium", 0));
        this.p_renamed = new android.graphics.Paint();
        this.p_renamed.setAntiAlias(true);
        this.p_renamed.setColor(this.f2390a);
        this.p_renamed.setStyle(android.graphics.Paint.Style.FILL);
    }

    public void a_renamed(android.graphics.Canvas canvas, int i_renamed, int i2, android.graphics.RectF rectF) {
        if (i_renamed != 0) {
            if (i_renamed == 1) {
                a_renamed(canvas, rectF);
                return;
            }
            if (i_renamed == 2 || i_renamed == 3) {
                a_renamed(canvas, i2, rectF);
            } else {
                if (i_renamed != 4) {
                    return;
                }
                b_renamed(canvas, rectF);
            }
        }
    }

    private void a_renamed(android.graphics.Canvas canvas, android.graphics.RectF rectF) {
        float f_renamed = (rectF.bottom - rectF.top) / 2.0f;
        canvas.drawCircle(rectF.left + f_renamed, rectF.top + f_renamed, f_renamed, this.p_renamed);
    }

    private void b_renamed(android.graphics.Canvas canvas, android.graphics.RectF rectF) {
        float f_renamed = (rectF.bottom - rectF.top) / 2.0f;
        canvas.drawCircle(rectF.left + f_renamed, rectF.top + f_renamed, f_renamed - this.n_renamed, this.p_renamed);
    }

    private void a_renamed(android.graphics.Canvas canvas, int i_renamed, android.graphics.RectF rectF) {
        android.graphics.Path pathA;
        if (i_renamed <= 0) {
            return;
        }
        if (java.lang.Math.min(rectF.right - rectF.left, rectF.bottom - rectF.top) < this.i_renamed * 2) {
            pathA = com.coui.appcompat.a_renamed.o_renamed.a_renamed().a_renamed(rectF, ((int) java.lang.Math.min(rectF.right - rectF.left, rectF.bottom - rectF.top)) / 2);
        } else {
            pathA = com.coui.appcompat.a_renamed.o_renamed.a_renamed().a_renamed(rectF, this.i_renamed);
        }
        canvas.drawPath(pathA, this.p_renamed);
        b_renamed(canvas, i_renamed, 255, rectF);
    }

    public void a_renamed(android.graphics.Canvas canvas, int i_renamed, int i2, int i3, int i4, android.graphics.RectF rectF) {
        canvas.drawPath(com.coui.appcompat.a_renamed.o_renamed.a_renamed().a_renamed(rectF, this.i_renamed), this.p_renamed);
        if (i2 > i4) {
            b_renamed(canvas, i_renamed, i2, rectF);
            b_renamed(canvas, i3, i4, rectF);
        } else {
            b_renamed(canvas, i3, i4, rectF);
            b_renamed(canvas, i_renamed, i2, rectF);
        }
    }

    private void b_renamed(android.graphics.Canvas canvas, int i_renamed, int i2, android.graphics.RectF rectF) {
        if (i_renamed <= 0) {
            return;
        }
        this.o_renamed.setAlpha(java.lang.Math.max(0, java.lang.Math.min(255, i2)));
        if (i_renamed < 1000) {
            java.lang.String strValueOf = java.lang.String.valueOf(i_renamed);
            android.graphics.Paint.FontMetricsInt fontMetricsInt = this.o_renamed.getFontMetricsInt();
            canvas.drawText(strValueOf, rectF.left + (((rectF.right - rectF.left) - ((int) this.o_renamed.measureText(strValueOf))) / 2.0f), (((rectF.top + rectF.bottom) - fontMetricsInt.ascent) - fontMetricsInt.descent) / 2.0f, this.o_renamed);
            return;
        }
        float f_renamed = (rectF.left + rectF.right) / 2.0f;
        float f2 = (rectF.top + rectF.bottom) / 2.0f;
        for (int i3 = -1; i3 <= 1; i3++) {
            int i4 = this.m_renamed;
            canvas.drawCircle(((i4 + r2) * i3) + f_renamed, f2, this.l_renamed / 2.0f, this.o_renamed);
        }
    }

    public int a_renamed(int i_renamed, int i2) {
        if (i_renamed == 0) {
            return 0;
        }
        if (i_renamed != 1) {
            if (i_renamed == 2) {
                return l_renamed(i2);
            }
            if (i_renamed == 3) {
                return m_renamed(i2);
            }
            if (i_renamed != 4) {
                return 0;
            }
        }
        return this.j_renamed;
    }

    public int a_renamed(int i_renamed) {
        if (i_renamed == 0) {
            return 0;
        }
        if (i_renamed != 1) {
            if (i_renamed == 2) {
                return a_renamed();
            }
            if (i_renamed == 3) {
                return this.e_renamed / 2;
            }
            if (i_renamed != 4) {
                return 0;
            }
        }
        return this.j_renamed;
    }

    private int l_renamed(int i_renamed) {
        if (i_renamed < 10) {
            return this.d_renamed;
        }
        if (i_renamed < 100) {
            return this.e_renamed;
        }
        if (i_renamed < 1000) {
            return this.f_renamed;
        }
        return this.e_renamed;
    }

    private int m_renamed(int i_renamed) {
        if (i_renamed < 10) {
            return this.g_renamed;
        }
        if (i_renamed < 100) {
            return this.d_renamed;
        }
        return this.e_renamed;
    }

    private int a_renamed() {
        return this.h_renamed;
    }

    public void b_renamed(int i_renamed) {
        this.f2390a = i_renamed;
        this.p_renamed.setColor(this.f2390a);
    }

    public void c_renamed(int i_renamed) {
        this.f2391b = i_renamed;
        this.o_renamed.setColor(this.f2391b);
    }

    public void d_renamed(int i_renamed) {
        this.f2392c = i_renamed;
    }

    public void e_renamed(int i_renamed) {
        this.d_renamed = i_renamed;
    }

    public void f_renamed(int i_renamed) {
        this.e_renamed = i_renamed;
    }

    public void g_renamed(int i_renamed) {
        this.f_renamed = i_renamed;
    }

    public void h_renamed(int i_renamed) {
        this.h_renamed = i_renamed;
    }

    public void i_renamed(int i_renamed) {
        this.i_renamed = i_renamed;
    }

    public void j_renamed(int i_renamed) {
        this.j_renamed = i_renamed;
    }

    public void k_renamed(int i_renamed) {
        this.l_renamed = i_renamed;
    }
}
