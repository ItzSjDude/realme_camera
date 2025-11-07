package androidx.core.graphics.drawable;

/* compiled from: WrappedDrawableApi14.java */
/* loaded from: classes.dex */
class d_renamed extends android.graphics.drawable.Drawable implements android.graphics.drawable.Drawable.Callback, androidx.core.graphics.drawable.b_renamed, androidx.core.graphics.drawable.c_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    static final android.graphics.PorterDuff.Mode f931a = android.graphics.PorterDuff.Mode.SRC_IN;

    /* renamed from: b_renamed, reason: collision with root package name */
    androidx.core.graphics.drawable.f_renamed f932b;

    /* renamed from: c_renamed, reason: collision with root package name */
    android.graphics.drawable.Drawable f933c;
    private int d_renamed;
    private android.graphics.PorterDuff.Mode e_renamed;
    private boolean f_renamed;
    private boolean g_renamed;

    protected boolean b_renamed() {
        return true;
    }

    d_renamed(androidx.core.graphics.drawable.f_renamed fVar, android.content.res.Resources resources) {
        this.f932b = fVar;
        a_renamed(resources);
    }

    d_renamed(android.graphics.drawable.Drawable drawable) {
        this.f932b = c_renamed();
        a_renamed(drawable);
    }

    private void a_renamed(android.content.res.Resources resources) {
        androidx.core.graphics.drawable.f_renamed fVar = this.f932b;
        if (fVar == null || fVar.f935b == null) {
            return;
        }
        a_renamed(this.f932b.f935b.newDrawable(resources));
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        this.f933c.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(android.graphics.Canvas canvas) {
        this.f933c.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(android.graphics.Rect rect) {
        android.graphics.drawable.Drawable drawable = this.f933c;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int i_renamed) {
        this.f933c.setChangingConfigurations(i_renamed);
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        int changingConfigurations = super.getChangingConfigurations();
        androidx.core.graphics.drawable.f_renamed fVar = this.f932b;
        return this.f933c.getChangingConfigurations() | changingConfigurations | (fVar != null ? fVar.getChangingConfigurations() : 0);
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z_renamed) {
        this.f933c.setDither(z_renamed);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z_renamed) {
        this.f933c.setFilterBitmap(z_renamed);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i_renamed) {
        this.f933c.setAlpha(i_renamed);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(android.graphics.ColorFilter colorFilter) {
        this.f933c.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        androidx.core.graphics.drawable.f_renamed fVar;
        android.content.res.ColorStateList colorStateList = (!b_renamed() || (fVar = this.f932b) == null) ? null : fVar.f936c;
        return (colorStateList != null && colorStateList.isStateful()) || this.f933c.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        return a_renamed(iArr) || this.f933c.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public int[] getState() {
        return this.f933c.getState();
    }

    @Override // android.graphics.drawable.Drawable
    public android.graphics.drawable.Drawable getCurrent() {
        return this.f933c.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z_renamed, boolean z2) {
        return super.setVisible(z_renamed, z2) || this.f933c.setVisible(z_renamed, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f933c.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public android.graphics.Region getTransparentRegion() {
        return this.f933c.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f933c.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f933c.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.f933c.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.f933c.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(android.graphics.Rect rect) {
        return this.f933c.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z_renamed) {
        this.f933c.setAutoMirrored(z_renamed);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.f933c.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Drawable
    public android.graphics.drawable.Drawable.ConstantState getConstantState() {
        androidx.core.graphics.drawable.f_renamed fVar = this.f932b;
        if (fVar == null || !fVar.a_renamed()) {
            return null;
        }
        this.f932b.f934a = getChangingConfigurations();
        return this.f932b;
    }

    @Override // android.graphics.drawable.Drawable
    public android.graphics.drawable.Drawable mutate() {
        if (!this.g_renamed && super.mutate() == this) {
            this.f932b = c_renamed();
            android.graphics.drawable.Drawable drawable = this.f933c;
            if (drawable != null) {
                drawable.mutate();
            }
            androidx.core.graphics.drawable.f_renamed fVar = this.f932b;
            if (fVar != null) {
                android.graphics.drawable.Drawable drawable2 = this.f933c;
                fVar.f935b = drawable2 != null ? drawable2.getConstantState() : null;
            }
            this.g_renamed = true;
        }
        return this;
    }

    private androidx.core.graphics.drawable.f_renamed c_renamed() {
        return new androidx.core.graphics.drawable.f_renamed(this.f932b);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(android.graphics.drawable.Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(android.graphics.drawable.Drawable drawable, java.lang.Runnable runnable, long j_renamed) {
        scheduleSelf(runnable, j_renamed);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(android.graphics.drawable.Drawable drawable, java.lang.Runnable runnable) {
        unscheduleSelf(runnable);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i_renamed) {
        return this.f933c.setLevel(i_renamed);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b_renamed
    public void setTint(int i_renamed) {
        setTintList(android.content.res.ColorStateList.valueOf(i_renamed));
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b_renamed
    public void setTintList(android.content.res.ColorStateList colorStateList) {
        this.f932b.f936c = colorStateList;
        a_renamed(getState());
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b_renamed
    public void setTintMode(android.graphics.PorterDuff.Mode mode) {
        this.f932b.d_renamed = mode;
        a_renamed(getState());
    }

    private boolean a_renamed(int[] iArr) {
        if (!b_renamed()) {
            return false;
        }
        android.content.res.ColorStateList colorStateList = this.f932b.f936c;
        android.graphics.PorterDuff.Mode mode = this.f932b.d_renamed;
        if (colorStateList != null && mode != null) {
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (!this.f_renamed || colorForState != this.d_renamed || mode != this.e_renamed) {
                setColorFilter(colorForState, mode);
                this.d_renamed = colorForState;
                this.e_renamed = mode;
                this.f_renamed = true;
                return true;
            }
        } else {
            this.f_renamed = false;
            clearColorFilter();
        }
        return false;
    }

    @Override // androidx.core.graphics.drawable.c_renamed
    public final android.graphics.drawable.Drawable a_renamed() {
        return this.f933c;
    }

    @Override // androidx.core.graphics.drawable.c_renamed
    public final void a_renamed(android.graphics.drawable.Drawable drawable) {
        android.graphics.drawable.Drawable drawable2 = this.f933c;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f933c = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            setVisible(drawable.isVisible(), true);
            setState(drawable.getState());
            setLevel(drawable.getLevel());
            setBounds(drawable.getBounds());
            androidx.core.graphics.drawable.f_renamed fVar = this.f932b;
            if (fVar != null) {
                fVar.f935b = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }
}
