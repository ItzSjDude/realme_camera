package androidx.cardview.a_renamed;

/* compiled from: RoundRectDrawable.java */
/* loaded from: classes.dex */
class g_renamed extends android.graphics.drawable.Drawable {

    /* renamed from: a_renamed, reason: collision with root package name */
    private float f696a;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final android.graphics.RectF f698c;
    private final android.graphics.Rect d_renamed;
    private float e_renamed;
    private android.content.res.ColorStateList h_renamed;
    private android.graphics.PorterDuffColorFilter i_renamed;
    private android.content.res.ColorStateList j_renamed;
    private boolean f_renamed = false;
    private boolean g_renamed = true;
    private android.graphics.PorterDuff.Mode k_renamed = android.graphics.PorterDuff.Mode.SRC_IN;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final android.graphics.Paint f697b = new android.graphics.Paint(5);

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    g_renamed(android.content.res.ColorStateList colorStateList, float f_renamed) {
        this.f696a = f_renamed;
        b_renamed(colorStateList);
        this.f698c = new android.graphics.RectF();
        this.d_renamed = new android.graphics.Rect();
    }

    private void b_renamed(android.content.res.ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = android.content.res.ColorStateList.valueOf(0);
        }
        this.h_renamed = colorStateList;
        this.f697b.setColor(this.h_renamed.getColorForState(getState(), this.h_renamed.getDefaultColor()));
    }

    void a_renamed(float f_renamed, boolean z_renamed, boolean z2) {
        if (f_renamed == this.e_renamed && this.f_renamed == z_renamed && this.g_renamed == z2) {
            return;
        }
        this.e_renamed = f_renamed;
        this.f_renamed = z_renamed;
        this.g_renamed = z2;
        a_renamed((android.graphics.Rect) null);
        invalidateSelf();
    }

    float a_renamed() {
        return this.e_renamed;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(android.graphics.Canvas canvas) {
        boolean z_renamed;
        android.graphics.Paint paint = this.f697b;
        if (this.i_renamed == null || paint.getColorFilter() != null) {
            z_renamed = false;
        } else {
            paint.setColorFilter(this.i_renamed);
            z_renamed = true;
        }
        android.graphics.RectF rectF = this.f698c;
        float f_renamed = this.f696a;
        canvas.drawRoundRect(rectF, f_renamed, f_renamed, paint);
        if (z_renamed) {
            paint.setColorFilter(null);
        }
    }

    private void a_renamed(android.graphics.Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        this.f698c.set(rect.left, rect.top, rect.right, rect.bottom);
        this.d_renamed.set(rect);
        if (this.f_renamed) {
            this.d_renamed.inset((int) java.lang.Math.ceil(androidx.cardview.a_renamed.h_renamed.b_renamed(this.e_renamed, this.f696a, this.g_renamed)), (int) java.lang.Math.ceil(androidx.cardview.a_renamed.h_renamed.a_renamed(this.e_renamed, this.f696a, this.g_renamed)));
            this.f698c.set(this.d_renamed);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(android.graphics.Rect rect) {
        super.onBoundsChange(rect);
        a_renamed(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(android.graphics.Outline outline) {
        outline.setRoundRect(this.d_renamed, this.f696a);
    }

    void a_renamed(float f_renamed) {
        if (f_renamed == this.f696a) {
            return;
        }
        this.f696a = f_renamed;
        a_renamed((android.graphics.Rect) null);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i_renamed) {
        this.f697b.setAlpha(i_renamed);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(android.graphics.ColorFilter colorFilter) {
        this.f697b.setColorFilter(colorFilter);
    }

    public float b_renamed() {
        return this.f696a;
    }

    public void a_renamed(android.content.res.ColorStateList colorStateList) {
        b_renamed(colorStateList);
        invalidateSelf();
    }

    public android.content.res.ColorStateList c_renamed() {
        return this.h_renamed;
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(android.content.res.ColorStateList colorStateList) {
        this.j_renamed = colorStateList;
        this.i_renamed = a_renamed(this.j_renamed, this.k_renamed);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(android.graphics.PorterDuff.Mode mode) {
        this.k_renamed = mode;
        this.i_renamed = a_renamed(this.j_renamed, this.k_renamed);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        android.graphics.PorterDuff.Mode mode;
        android.content.res.ColorStateList colorStateList = this.h_renamed;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        boolean z_renamed = colorForState != this.f697b.getColor();
        if (z_renamed) {
            this.f697b.setColor(colorForState);
        }
        android.content.res.ColorStateList colorStateList2 = this.j_renamed;
        if (colorStateList2 == null || (mode = this.k_renamed) == null) {
            return z_renamed;
        }
        this.i_renamed = a_renamed(colorStateList2, mode);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        android.content.res.ColorStateList colorStateList;
        android.content.res.ColorStateList colorStateList2 = this.j_renamed;
        return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.h_renamed) != null && colorStateList.isStateful()) || super.isStateful();
    }

    private android.graphics.PorterDuffColorFilter a_renamed(android.content.res.ColorStateList colorStateList, android.graphics.PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new android.graphics.PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }
}
