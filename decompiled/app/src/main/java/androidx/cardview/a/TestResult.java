package androidx.cardview.a_renamed;

/* compiled from: RoundRectDrawableWithShadow.java */
/* loaded from: classes.dex */
class h_renamed extends android.graphics.drawable.Drawable {

    /* renamed from: a_renamed, reason: collision with root package name */
    static androidx.cardview.a_renamed.h_renamed.a_renamed f699a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private static final double f700b = java.lang.Math.cos(java.lang.Math.toRadians(45.0d));

    /* renamed from: c_renamed, reason: collision with root package name */
    private final int f701c;
    private android.graphics.Paint e_renamed;
    private android.graphics.Paint f_renamed;
    private final android.graphics.RectF g_renamed;
    private float h_renamed;
    private android.graphics.Path i_renamed;
    private float j_renamed;
    private float k_renamed;
    private float l_renamed;
    private android.content.res.ColorStateList m_renamed;
    private final int o_renamed;
    private final int p_renamed;
    private boolean n_renamed = true;
    private boolean q_renamed = true;
    private boolean r_renamed = false;
    private android.graphics.Paint d_renamed = new android.graphics.Paint(5);

    /* compiled from: RoundRectDrawableWithShadow.java */
    interface a_renamed {
        void a_renamed(android.graphics.Canvas canvas, android.graphics.RectF rectF, float f_renamed, android.graphics.Paint paint);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    h_renamed(android.content.res.Resources resources, android.content.res.ColorStateList colorStateList, float f_renamed, float f2, float f3) {
        this.o_renamed = resources.getColor(androidx.cardview.R_renamed.color.cardview_shadow_start_color);
        this.p_renamed = resources.getColor(androidx.cardview.R_renamed.color.cardview_shadow_end_color);
        this.f701c = resources.getDimensionPixelSize(androidx.cardview.R_renamed.dimen.cardview_compat_inset_shadow);
        b_renamed(colorStateList);
        this.e_renamed = new android.graphics.Paint(5);
        this.e_renamed.setStyle(android.graphics.Paint.Style.FILL);
        this.h_renamed = (int) (f_renamed + 0.5f);
        this.g_renamed = new android.graphics.RectF();
        this.f_renamed = new android.graphics.Paint(this.e_renamed);
        this.f_renamed.setAntiAlias(false);
        a_renamed(f2, f3);
    }

    private void b_renamed(android.content.res.ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = android.content.res.ColorStateList.valueOf(0);
        }
        this.m_renamed = colorStateList;
        this.d_renamed.setColor(this.m_renamed.getColorForState(getState(), this.m_renamed.getDefaultColor()));
    }

    private int d_renamed(float f_renamed) {
        int i_renamed = (int) (f_renamed + 0.5f);
        return i_renamed % 2 == 1 ? i_renamed - 1 : i_renamed;
    }

    void a_renamed(boolean z_renamed) {
        this.q_renamed = z_renamed;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i_renamed) {
        this.d_renamed.setAlpha(i_renamed);
        this.e_renamed.setAlpha(i_renamed);
        this.f_renamed.setAlpha(i_renamed);
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(android.graphics.Rect rect) {
        super.onBoundsChange(rect);
        this.n_renamed = true;
    }

    private void a_renamed(float f_renamed, float f2) {
        if (f_renamed < 0.0f) {
            throw new java.lang.IllegalArgumentException("Invalid shadow size " + f_renamed + ". Must be_renamed >= 0");
        }
        if (f2 < 0.0f) {
            throw new java.lang.IllegalArgumentException("Invalid max shadow size " + f2 + ". Must be_renamed >= 0");
        }
        float fD_renamed = d_renamed(f_renamed);
        float fD2 = d_renamed(f2);
        if (fD_renamed > fD2) {
            if (!this.r_renamed) {
                this.r_renamed = true;
            }
            fD_renamed = fD2;
        }
        if (this.l_renamed == fD_renamed && this.j_renamed == fD2) {
            return;
        }
        this.l_renamed = fD_renamed;
        this.j_renamed = fD2;
        this.k_renamed = (int) ((fD_renamed * 1.5f) + this.f701c + 0.5f);
        this.n_renamed = true;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(android.graphics.Rect rect) {
        int iCeil = (int) java.lang.Math.ceil(a_renamed(this.j_renamed, this.h_renamed, this.q_renamed));
        int iCeil2 = (int) java.lang.Math.ceil(b_renamed(this.j_renamed, this.h_renamed, this.q_renamed));
        rect.set(iCeil2, iCeil, iCeil2, iCeil);
        return true;
    }

    static float a_renamed(float f_renamed, float f2, boolean z_renamed) {
        return z_renamed ? (float) ((f_renamed * 1.5f) + ((1.0d - f700b) * f2)) : f_renamed * 1.5f;
    }

    static float b_renamed(float f_renamed, float f2, boolean z_renamed) {
        return z_renamed ? (float) (f_renamed + ((1.0d - f700b) * f2)) : f_renamed;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        android.content.res.ColorStateList colorStateList = this.m_renamed;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        if (this.d_renamed.getColor() == colorForState) {
            return false;
        }
        this.d_renamed.setColor(colorForState);
        this.n_renamed = true;
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        android.content.res.ColorStateList colorStateList = this.m_renamed;
        return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(android.graphics.ColorFilter colorFilter) {
        this.d_renamed.setColorFilter(colorFilter);
    }

    void a_renamed(float f_renamed) {
        if (f_renamed < 0.0f) {
            throw new java.lang.IllegalArgumentException("Invalid radius " + f_renamed + ". Must be_renamed >= 0");
        }
        float f2 = (int) (f_renamed + 0.5f);
        if (this.h_renamed == f2) {
            return;
        }
        this.h_renamed = f2;
        this.n_renamed = true;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(android.graphics.Canvas canvas) {
        if (this.n_renamed) {
            b_renamed(getBounds());
            this.n_renamed = false;
        }
        canvas.translate(0.0f, this.l_renamed / 2.0f);
        a_renamed(canvas);
        canvas.translate(0.0f, (-this.l_renamed) / 2.0f);
        f699a.a_renamed(canvas, this.g_renamed, this.h_renamed, this.d_renamed);
    }

    private void a_renamed(android.graphics.Canvas canvas) {
        float f_renamed = this.h_renamed;
        float f2 = (-f_renamed) - this.k_renamed;
        float f3 = f_renamed + this.f701c + (this.l_renamed / 2.0f);
        float f4 = f3 * 2.0f;
        boolean z_renamed = this.g_renamed.width() - f4 > 0.0f;
        boolean z2 = this.g_renamed.height() - f4 > 0.0f;
        int iSave = canvas.save();
        canvas.translate(this.g_renamed.left + f3, this.g_renamed.top + f3);
        canvas.drawPath(this.i_renamed, this.e_renamed);
        if (z_renamed) {
            canvas.drawRect(0.0f, f2, this.g_renamed.width() - f4, -this.h_renamed, this.f_renamed);
        }
        canvas.restoreToCount(iSave);
        int iSave2 = canvas.save();
        canvas.translate(this.g_renamed.right - f3, this.g_renamed.bottom - f3);
        canvas.rotate(180.0f);
        canvas.drawPath(this.i_renamed, this.e_renamed);
        if (z_renamed) {
            canvas.drawRect(0.0f, f2, this.g_renamed.width() - f4, (-this.h_renamed) + this.k_renamed, this.f_renamed);
        }
        canvas.restoreToCount(iSave2);
        int iSave3 = canvas.save();
        canvas.translate(this.g_renamed.left + f3, this.g_renamed.bottom - f3);
        canvas.rotate(270.0f);
        canvas.drawPath(this.i_renamed, this.e_renamed);
        if (z2) {
            canvas.drawRect(0.0f, f2, this.g_renamed.height() - f4, -this.h_renamed, this.f_renamed);
        }
        canvas.restoreToCount(iSave3);
        int iSave4 = canvas.save();
        canvas.translate(this.g_renamed.right - f3, this.g_renamed.top + f3);
        canvas.rotate(90.0f);
        canvas.drawPath(this.i_renamed, this.e_renamed);
        if (z2) {
            canvas.drawRect(0.0f, f2, this.g_renamed.height() - f4, -this.h_renamed, this.f_renamed);
        }
        canvas.restoreToCount(iSave4);
    }

    private void g_renamed() {
        float f_renamed = this.h_renamed;
        android.graphics.RectF rectF = new android.graphics.RectF(-f_renamed, -f_renamed, f_renamed, f_renamed);
        android.graphics.RectF rectF2 = new android.graphics.RectF(rectF);
        float f2 = this.k_renamed;
        rectF2.inset(-f2, -f2);
        android.graphics.Path path = this.i_renamed;
        if (path == null) {
            this.i_renamed = new android.graphics.Path();
        } else {
            path.reset();
        }
        this.i_renamed.setFillType(android.graphics.Path.FillType.EVEN_ODD);
        this.i_renamed.moveTo(-this.h_renamed, 0.0f);
        this.i_renamed.rLineTo(-this.k_renamed, 0.0f);
        this.i_renamed.arcTo(rectF2, 180.0f, 90.0f, false);
        this.i_renamed.arcTo(rectF, 270.0f, -90.0f, false);
        this.i_renamed.close();
        float f3 = this.h_renamed;
        float f4 = this.k_renamed;
        float f5 = f3 / (f3 + f4);
        android.graphics.Paint paint = this.e_renamed;
        float f6 = f3 + f4;
        int i_renamed = this.o_renamed;
        paint.setShader(new android.graphics.RadialGradient(0.0f, 0.0f, f6, new int[]{i_renamed, i_renamed, this.p_renamed}, new float[]{0.0f, f5, 1.0f}, android.graphics.Shader.TileMode.CLAMP));
        android.graphics.Paint paint2 = this.f_renamed;
        float f7 = this.h_renamed;
        float f8 = this.k_renamed;
        int i2 = this.o_renamed;
        paint2.setShader(new android.graphics.LinearGradient(0.0f, (-f7) + f8, 0.0f, (-f7) - f8, new int[]{i2, i2, this.p_renamed}, new float[]{0.0f, 0.5f, 1.0f}, android.graphics.Shader.TileMode.CLAMP));
        this.f_renamed.setAntiAlias(false);
    }

    private void b_renamed(android.graphics.Rect rect) {
        float f_renamed = this.j_renamed * 1.5f;
        this.g_renamed.set(rect.left + this.j_renamed, rect.top + f_renamed, rect.right - this.j_renamed, rect.bottom - f_renamed);
        g_renamed();
    }

    float a_renamed() {
        return this.h_renamed;
    }

    void a_renamed(android.graphics.Rect rect) {
        getPadding(rect);
    }

    void b_renamed(float f_renamed) {
        a_renamed(f_renamed, this.j_renamed);
    }

    void c_renamed(float f_renamed) {
        a_renamed(this.l_renamed, f_renamed);
    }

    float b_renamed() {
        return this.l_renamed;
    }

    float c_renamed() {
        return this.j_renamed;
    }

    float d_renamed() {
        float f_renamed = this.j_renamed;
        return (java.lang.Math.max(f_renamed, this.h_renamed + this.f701c + (f_renamed / 2.0f)) * 2.0f) + ((this.j_renamed + this.f701c) * 2.0f);
    }

    float e_renamed() {
        float f_renamed = this.j_renamed;
        return (java.lang.Math.max(f_renamed, this.h_renamed + this.f701c + ((f_renamed * 1.5f) / 2.0f)) * 2.0f) + (((this.j_renamed * 1.5f) + this.f701c) * 2.0f);
    }

    void a_renamed(android.content.res.ColorStateList colorStateList) {
        b_renamed(colorStateList);
        invalidateSelf();
    }

    android.content.res.ColorStateList f_renamed() {
        return this.m_renamed;
    }
}
