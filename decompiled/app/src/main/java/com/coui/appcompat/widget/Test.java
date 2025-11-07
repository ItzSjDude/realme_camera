package com.coui.appcompat.widget;

/* compiled from: COUICutoutDrawable.java */
/* loaded from: classes.dex */
public class d_renamed extends android.graphics.drawable.GradientDrawable {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final android.graphics.Paint f2890a = new android.graphics.Paint(1);

    /* renamed from: b_renamed, reason: collision with root package name */
    private final android.graphics.RectF f2891b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f2892c;

    public d_renamed() {
        d_renamed();
        this.f2891b = new android.graphics.RectF();
    }

    private void d_renamed() {
        this.f2890a.setStyle(android.graphics.Paint.Style.FILL_AND_STROKE);
        this.f2890a.setColor(-1);
        this.f2890a.setXfermode(new android.graphics.PorterDuffXfermode(android.graphics.PorterDuff.Mode.DST_OUT));
    }

    public boolean a_renamed() {
        return !this.f2891b.isEmpty();
    }

    public android.graphics.RectF b_renamed() {
        return this.f2891b;
    }

    public void a_renamed(float f_renamed, float f2, float f3, float f4) {
        if (f_renamed == this.f2891b.left && f2 == this.f2891b.top && f3 == this.f2891b.right && f4 == this.f2891b.bottom) {
            return;
        }
        this.f2891b.set(f_renamed, f2, f3, f4);
        invalidateSelf();
    }

    public void a_renamed(android.graphics.RectF rectF) {
        a_renamed(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }

    public void c_renamed() {
        a_renamed(0.0f, 0.0f, 0.0f, 0.0f);
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public void draw(android.graphics.Canvas canvas) {
        a_renamed(canvas);
        super.draw(canvas);
        canvas.drawRect(this.f2891b, this.f2890a);
        c_renamed(canvas);
    }

    private void a_renamed(android.graphics.Canvas canvas) {
        android.graphics.drawable.Drawable.Callback callback = getCallback();
        if (a_renamed(callback)) {
            ((android.view.View) callback).setLayerType(2, null);
        } else {
            b_renamed(canvas);
        }
    }

    private void b_renamed(android.graphics.Canvas canvas) {
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            this.f2892c = canvas.saveLayer(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), null);
        } else {
            this.f2892c = canvas.saveLayer(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), null, 31);
        }
    }

    private void c_renamed(android.graphics.Canvas canvas) {
        if (a_renamed(getCallback())) {
            return;
        }
        canvas.restoreToCount(this.f2892c);
    }

    private boolean a_renamed(android.graphics.drawable.Drawable.Callback callback) {
        return callback instanceof android.view.View;
    }

    /* compiled from: COUICutoutDrawable.java */
    public static final class a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        private static final boolean f2893a;

        /* renamed from: b_renamed, reason: collision with root package name */
        private static final android.graphics.Paint f2894b;
        private float A_renamed;
        private float B_renamed;
        private float C_renamed;
        private float D_renamed;
        private int[] E_renamed;
        private boolean F_renamed;
        private android.view.animation.Interpolator I_renamed;
        private android.view.animation.Interpolator J_renamed;

        /* renamed from: c_renamed, reason: collision with root package name */
        private final android.view.View f2895c;
        private boolean d_renamed;
        private float e_renamed;
        private android.content.res.ColorStateList m_renamed;
        private android.content.res.ColorStateList n_renamed;
        private float o_renamed;
        private float p_renamed;
        private float q_renamed;
        private float r_renamed;
        private float s_renamed;
        private float t_renamed;
        private java.lang.CharSequence u_renamed;
        private java.lang.CharSequence v_renamed;
        private boolean w_renamed;
        private boolean x_renamed;
        private android.graphics.Bitmap y_renamed;
        private android.graphics.Paint z_renamed;
        private int i_renamed = 16;
        private int j_renamed = 16;
        private float k_renamed = 30.0f;
        private float l_renamed = 30.0f;
        private final android.text.TextPaint G_renamed = new android.text.TextPaint(129);
        private final android.text.TextPaint H_renamed = new android.text.TextPaint(this.G_renamed);
        private final android.graphics.Rect g_renamed = new android.graphics.Rect();
        private final android.graphics.Rect f_renamed = new android.graphics.Rect();
        private final android.graphics.RectF h_renamed = new android.graphics.RectF();

        private float a_renamed(float f_renamed, float f2, float f3) {
            return f_renamed < f2 ? f2 : f_renamed > f3 ? f3 : f_renamed;
        }

        private static float b_renamed(float f_renamed, float f2, float f3) {
            return f_renamed + (f3 * (f2 - f_renamed));
        }

        static {
            f2893a = android.os.Build.VERSION.SDK_INT < 18;
            f2894b = null;
            android.graphics.Paint paint = f2894b;
            if (paint != null) {
                paint.setAntiAlias(true);
                f2894b.setColor(-65281);
            }
        }

        public a_renamed(android.view.View view) {
            this.f2895c = view;
        }

        public void a_renamed(android.view.animation.Interpolator interpolator) {
            this.J_renamed = interpolator;
            m_renamed();
        }

        public void b_renamed(android.view.animation.Interpolator interpolator) {
            this.I_renamed = interpolator;
            m_renamed();
        }

        public void a_renamed(float f_renamed) {
            if (this.k_renamed != f_renamed) {
                this.k_renamed = f_renamed;
                m_renamed();
            }
        }

        public void a_renamed(android.content.res.ColorStateList colorStateList) {
            if (this.n_renamed != colorStateList) {
                this.n_renamed = colorStateList;
                m_renamed();
            }
        }

        public void b_renamed(android.content.res.ColorStateList colorStateList) {
            if (this.m_renamed != colorStateList) {
                this.m_renamed = colorStateList;
                m_renamed();
            }
        }

        public android.graphics.Rect a_renamed() {
            return this.f_renamed;
        }

        public void a_renamed(int i_renamed, int i2, int i3, int i4) {
            if (a_renamed(this.f_renamed, i_renamed, i2, i3, i4)) {
                return;
            }
            this.f_renamed.set(i_renamed, i2, i3, i4);
            this.F_renamed = true;
            q_renamed();
            android.util.Log.d_renamed("COUICollapseTextHelper", "setExpandedBounds: " + this.f_renamed);
        }

        public android.graphics.Rect b_renamed() {
            return this.g_renamed;
        }

        public void b_renamed(int i_renamed, int i2, int i3, int i4) {
            if (a_renamed(this.g_renamed, i_renamed, i2, i3, i4)) {
                return;
            }
            this.g_renamed.set(i_renamed, i2, i3, i4);
            this.F_renamed = true;
            q_renamed();
            android.util.Log.d_renamed("COUICollapseTextHelper", "setCollapsedBounds: " + this.g_renamed);
        }

        public float c_renamed() {
            if (this.u_renamed == null) {
                return 0.0f;
            }
            a_renamed(this.H_renamed);
            android.text.TextPaint textPaint = this.H_renamed;
            java.lang.CharSequence charSequence = this.u_renamed;
            return textPaint.measureText(charSequence, 0, charSequence.length());
        }

        public float d_renamed() {
            a_renamed(this.H_renamed);
            if (java.util.Locale.getDefault().getLanguage().equals("my")) {
                return (-this.H_renamed.ascent()) * 1.3f;
            }
            return -this.H_renamed.ascent();
        }

        public float e_renamed() {
            a_renamed(this.H_renamed);
            float fDescent = this.H_renamed.descent() - this.H_renamed.ascent();
            return java.util.Locale.getDefault().getLanguage().equals("my") ? fDescent * 1.3f : fDescent;
        }

        public void a_renamed(android.graphics.RectF rectF) {
            float fC_renamed;
            boolean zB = b_renamed(this.u_renamed);
            if (!zB) {
                fC_renamed = this.g_renamed.left;
            } else {
                fC_renamed = this.g_renamed.right - c_renamed();
            }
            rectF.left = fC_renamed;
            rectF.top = this.g_renamed.top;
            rectF.right = !zB ? rectF.left + c_renamed() : this.g_renamed.right;
            rectF.bottom = this.g_renamed.top + d_renamed();
        }

        private void a_renamed(android.text.TextPaint textPaint) {
            textPaint.setTextSize(this.l_renamed);
        }

        private void q_renamed() {
            this.d_renamed = this.g_renamed.width() > 0 && this.g_renamed.height() > 0 && this.f_renamed.width() > 0 && this.f_renamed.height() > 0;
        }

        public int f_renamed() {
            return this.i_renamed;
        }

        public void a_renamed(int i_renamed) {
            if (this.i_renamed != i_renamed) {
                this.i_renamed = i_renamed;
                m_renamed();
            }
        }

        public int g_renamed() {
            return this.j_renamed;
        }

        public void b_renamed(int i_renamed) {
            if (this.j_renamed != i_renamed) {
                this.j_renamed = i_renamed;
                m_renamed();
            }
        }

        public void a_renamed(int i_renamed, android.content.res.ColorStateList colorStateList) {
            this.n_renamed = colorStateList;
            this.l_renamed = i_renamed;
            m_renamed();
        }

        public void a_renamed(android.graphics.Typeface typeface) {
            com.coui.appcompat.a_renamed.a_renamed.a_renamed((android.graphics.Paint) this.G_renamed, true);
            com.coui.appcompat.a_renamed.a_renamed.a_renamed((android.graphics.Paint) this.H_renamed, true);
            m_renamed();
        }

        public float h_renamed() {
            return this.e_renamed;
        }

        public void b_renamed(float f_renamed) {
            float fA_renamed = a_renamed(f_renamed, 0.0f, 1.0f);
            if (fA_renamed != this.e_renamed) {
                this.e_renamed = fA_renamed;
                r_renamed();
            }
        }

        public final boolean a_renamed(int[] iArr) {
            this.E_renamed = iArr;
            if (!i_renamed()) {
                return false;
            }
            m_renamed();
            return true;
        }

        final boolean i_renamed() {
            android.content.res.ColorStateList colorStateList;
            android.content.res.ColorStateList colorStateList2 = this.n_renamed;
            return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.m_renamed) != null && colorStateList.isStateful());
        }

        public float j_renamed() {
            return this.e_renamed;
        }

        float k_renamed() {
            return this.k_renamed;
        }

        private void r_renamed() {
            c_renamed(this.e_renamed);
        }

        private void c_renamed(float f_renamed) {
            d_renamed(f_renamed);
            this.s_renamed = a_renamed(this.q_renamed, this.r_renamed, f_renamed, this.I_renamed);
            this.t_renamed = a_renamed(this.o_renamed, this.p_renamed, f_renamed, this.I_renamed);
            e_renamed(a_renamed(this.k_renamed, this.l_renamed, f_renamed, this.J_renamed));
            if (this.n_renamed != this.m_renamed) {
                this.G_renamed.setColor(a_renamed(s_renamed(), l_renamed(), f_renamed));
            } else {
                this.G_renamed.setColor(l_renamed());
            }
            this.f2895c.postInvalidate();
        }

        private int s_renamed() {
            int[] iArr = this.E_renamed;
            if (iArr != null) {
                return this.m_renamed.getColorForState(iArr, 0);
            }
            return this.m_renamed.getDefaultColor();
        }

        public int l_renamed() {
            int[] iArr = this.E_renamed;
            if (iArr != null) {
                return this.n_renamed.getColorForState(iArr, 0);
            }
            return this.n_renamed.getDefaultColor();
        }

        private void t_renamed() {
            float f_renamed = this.D_renamed;
            f_renamed(this.l_renamed);
            java.lang.CharSequence charSequence = this.v_renamed;
            float fMeasureText = charSequence != null ? this.G_renamed.measureText(charSequence, 0, charSequence.length()) : 0.0f;
            int iA = androidx.core.h_renamed.c_renamed.a_renamed(this.j_renamed, this.w_renamed ? 1 : 0);
            int i_renamed = iA & 112;
            if (i_renamed != 48) {
                if (i_renamed == 80) {
                    this.p_renamed = this.g_renamed.bottom;
                } else {
                    this.p_renamed = this.g_renamed.centerY() + (((this.G_renamed.descent() - this.G_renamed.ascent()) / 2.0f) - this.G_renamed.descent());
                }
            } else if (java.util.Locale.getDefault().getLanguage().equals("my")) {
                this.p_renamed = this.g_renamed.top - (this.G_renamed.ascent() * 1.3f);
            } else {
                this.p_renamed = this.g_renamed.top - this.G_renamed.ascent();
            }
            int i2 = iA & 8388615;
            if (i2 == 1) {
                this.r_renamed = this.g_renamed.centerX() - (fMeasureText / 2.0f);
            } else if (i2 == 5) {
                this.r_renamed = this.g_renamed.right - fMeasureText;
            } else {
                this.r_renamed = this.g_renamed.left;
            }
            f_renamed(this.k_renamed);
            java.lang.CharSequence charSequence2 = this.v_renamed;
            float fMeasureText2 = charSequence2 != null ? this.G_renamed.measureText(charSequence2, 0, charSequence2.length()) : 0.0f;
            int iA2 = androidx.core.h_renamed.c_renamed.a_renamed(this.i_renamed, this.w_renamed ? 1 : 0);
            int i3 = iA2 & 112;
            if (i3 == 48) {
                this.o_renamed = this.f_renamed.top - this.G_renamed.ascent();
            } else if (i3 == 80) {
                this.o_renamed = this.f_renamed.bottom;
            } else {
                this.o_renamed = this.f_renamed.centerY() + (((this.G_renamed.getFontMetrics().bottom - this.G_renamed.getFontMetrics().top) / 2.0f) - this.G_renamed.getFontMetrics().bottom);
            }
            int i4 = iA2 & 8388615;
            if (i4 == 1) {
                this.q_renamed = this.f_renamed.centerX() - (fMeasureText2 / 2.0f);
            } else if (i4 == 5) {
                this.q_renamed = this.f_renamed.right - fMeasureText2;
            } else {
                this.q_renamed = this.f_renamed.left;
            }
            v_renamed();
            e_renamed(f_renamed);
        }

        private void d_renamed(float f_renamed) {
            this.h_renamed.left = a_renamed(this.f_renamed.left, this.g_renamed.left, f_renamed, this.I_renamed);
            this.h_renamed.top = a_renamed(this.o_renamed, this.p_renamed, f_renamed, this.I_renamed);
            this.h_renamed.right = a_renamed(this.f_renamed.right, this.g_renamed.right, f_renamed, this.I_renamed);
            this.h_renamed.bottom = a_renamed(this.f_renamed.bottom, this.g_renamed.bottom, f_renamed, this.I_renamed);
        }

        public void a_renamed(android.graphics.Canvas canvas) {
            float fAscent;
            int iSave = canvas.save();
            if (this.v_renamed != null && this.d_renamed) {
                float f_renamed = this.s_renamed;
                float f2 = this.t_renamed;
                boolean z_renamed = this.x_renamed && this.y_renamed != null;
                if (z_renamed) {
                    fAscent = this.A_renamed * this.C_renamed;
                    float f3 = this.B_renamed;
                } else {
                    fAscent = this.G_renamed.ascent() * this.C_renamed;
                    this.G_renamed.descent();
                    float f4 = this.C_renamed;
                }
                if (z_renamed) {
                    f2 += fAscent;
                }
                float f5 = f2;
                float f6 = this.C_renamed;
                if (f6 != 1.0f) {
                    canvas.scale(f6, f6, f_renamed, f5);
                }
                if (z_renamed) {
                    canvas.drawBitmap(this.y_renamed, f_renamed, f5, this.z_renamed);
                } else {
                    java.lang.CharSequence charSequence = this.v_renamed;
                    canvas.drawText(charSequence, 0, charSequence.length(), f_renamed, f5, this.G_renamed);
                }
            } else {
                canvas.drawText(" ", 0.0f, 0.0f, this.G_renamed);
            }
            canvas.restoreToCount(iSave);
        }

        private boolean b_renamed(java.lang.CharSequence charSequence) {
            return w_renamed();
        }

        private void e_renamed(float f_renamed) {
            f_renamed(f_renamed);
            this.x_renamed = f2893a && this.C_renamed != 1.0f;
            if (this.x_renamed) {
                u_renamed();
            }
            this.f2895c.postInvalidate();
        }

        private void f_renamed(float f_renamed) {
            float f2;
            boolean z_renamed;
            if (this.u_renamed == null) {
                return;
            }
            float fWidth = this.g_renamed.width();
            float fWidth2 = this.f_renamed.width();
            if (a_renamed(f_renamed, this.l_renamed)) {
                float f3 = this.l_renamed;
                this.C_renamed = 1.0f;
                f2 = f3;
            } else {
                f2 = this.k_renamed;
                if (a_renamed(f_renamed, f2)) {
                    this.C_renamed = 1.0f;
                } else {
                    this.C_renamed = f_renamed / this.k_renamed;
                }
                float f4 = this.l_renamed / this.k_renamed;
                fWidth = fWidth2 * f4 > fWidth ? java.lang.Math.min(fWidth / f4, fWidth2) : fWidth2;
            }
            if (fWidth > 0.0f) {
                z_renamed = this.D_renamed != f2 || this.F_renamed;
                this.D_renamed = f2;
                this.F_renamed = false;
            } else {
                z_renamed = false;
            }
            if (this.v_renamed == null || z_renamed) {
                this.G_renamed.setTextSize(this.D_renamed);
                this.G_renamed.setLinearText(this.C_renamed != 1.0f);
                java.lang.CharSequence charSequenceEllipsize = android.text.TextUtils.ellipsize(this.u_renamed, this.G_renamed, fWidth, android.text.TextUtils.TruncateAt.END);
                if (!android.text.TextUtils.equals(charSequenceEllipsize, this.v_renamed)) {
                    this.v_renamed = charSequenceEllipsize;
                }
            }
            this.w_renamed = w_renamed();
        }

        private void u_renamed() {
            if (this.y_renamed != null || this.f_renamed.isEmpty() || android.text.TextUtils.isEmpty(this.v_renamed)) {
                return;
            }
            c_renamed(0.0f);
            this.A_renamed = this.G_renamed.ascent();
            this.B_renamed = this.G_renamed.descent();
            android.text.TextPaint textPaint = this.G_renamed;
            java.lang.CharSequence charSequence = this.v_renamed;
            int iRound = java.lang.Math.round(textPaint.measureText(charSequence, 0, charSequence.length()));
            int iRound2 = java.lang.Math.round(this.B_renamed - this.A_renamed);
            if (iRound <= 0 || iRound2 <= 0) {
                return;
            }
            this.y_renamed = android.graphics.Bitmap.createBitmap(iRound, iRound2, android.graphics.Bitmap.Config.ARGB_8888);
            android.graphics.Canvas canvas = new android.graphics.Canvas(this.y_renamed);
            java.lang.CharSequence charSequence2 = this.v_renamed;
            canvas.drawText(charSequence2, 0, charSequence2.length(), 0.0f, iRound2 - this.G_renamed.descent(), this.G_renamed);
            if (this.z_renamed == null) {
                this.z_renamed = new android.graphics.Paint(3);
            }
        }

        public void m_renamed() {
            if (this.f2895c.getHeight() <= 0 || this.f2895c.getWidth() <= 0) {
                return;
            }
            t_renamed();
            r_renamed();
        }

        public void a_renamed(java.lang.CharSequence charSequence) {
            if (charSequence == null || !charSequence.equals(this.u_renamed)) {
                this.u_renamed = charSequence;
                this.v_renamed = null;
                v_renamed();
                m_renamed();
            }
        }

        java.lang.CharSequence n_renamed() {
            return this.u_renamed;
        }

        private void v_renamed() {
            android.graphics.Bitmap bitmap = this.y_renamed;
            if (bitmap != null) {
                bitmap.recycle();
                this.y_renamed = null;
            }
        }

        private static boolean a_renamed(float f_renamed, float f2) {
            return java.lang.Math.abs(f_renamed - f2) < 0.001f;
        }

        android.content.res.ColorStateList o_renamed() {
            return this.m_renamed;
        }

        public android.content.res.ColorStateList p_renamed() {
            return this.n_renamed;
        }

        private static int a_renamed(int i_renamed, int i2, float f_renamed) {
            float f2 = 1.0f - f_renamed;
            return android.graphics.Color.argb((int) ((android.graphics.Color.alpha(i_renamed) * f2) + (android.graphics.Color.alpha(i2) * f_renamed)), (int) ((android.graphics.Color.red(i_renamed) * f2) + (android.graphics.Color.red(i2) * f_renamed)), (int) ((android.graphics.Color.green(i_renamed) * f2) + (android.graphics.Color.green(i2) * f_renamed)), (int) ((android.graphics.Color.blue(i_renamed) * f2) + (android.graphics.Color.blue(i2) * f_renamed)));
        }

        private static float a_renamed(float f_renamed, float f2, float f3, android.view.animation.Interpolator interpolator) {
            if (interpolator != null) {
                f3 = interpolator.getInterpolation(f3);
            }
            return b_renamed(f_renamed, f2, f3);
        }

        private static boolean a_renamed(android.graphics.Rect rect, int i_renamed, int i2, int i3, int i4) {
            return rect.left == i_renamed && rect.top == i2 && rect.right == i3 && rect.bottom == i4;
        }

        private boolean w_renamed() {
            return android.os.Build.VERSION.SDK_INT > 16 && this.f2895c.getLayoutDirection() == 1;
        }
    }
}
