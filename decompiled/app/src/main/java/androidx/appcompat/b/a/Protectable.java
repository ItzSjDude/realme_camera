package androidx.appcompat.b_renamed.a_renamed;

/* compiled from: DrawableWrapper.java */
/* loaded from: classes.dex */
public class c_renamed extends android.graphics.drawable.Drawable implements android.graphics.drawable.Drawable.Callback {
    private android.graphics.drawable.Drawable mDrawable;

    public c_renamed(android.graphics.drawable.Drawable drawable) {
        setWrappedDrawable(drawable);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(android.graphics.Canvas canvas) {
        this.mDrawable.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(android.graphics.Rect rect) {
        this.mDrawable.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int i_renamed) {
        this.mDrawable.setChangingConfigurations(i_renamed);
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return this.mDrawable.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z_renamed) {
        this.mDrawable.setDither(z_renamed);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z_renamed) {
        this.mDrawable.setFilterBitmap(z_renamed);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i_renamed) {
        this.mDrawable.setAlpha(i_renamed);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(android.graphics.ColorFilter colorFilter) {
        this.mDrawable.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.mDrawable.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        return this.mDrawable.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public int[] getState() {
        return this.mDrawable.getState();
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        androidx.core.graphics.drawable.a_renamed.a_renamed(this.mDrawable);
    }

    @Override // android.graphics.drawable.Drawable
    public android.graphics.drawable.Drawable getCurrent() {
        return this.mDrawable.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z_renamed, boolean z2) {
        return super.setVisible(z_renamed, z2) || this.mDrawable.setVisible(z_renamed, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.mDrawable.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public android.graphics.Region getTransparentRegion() {
        return this.mDrawable.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.mDrawable.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.mDrawable.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.mDrawable.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.mDrawable.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(android.graphics.Rect rect) {
        return this.mDrawable.getPadding(rect);
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
        return this.mDrawable.setLevel(i_renamed);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z_renamed) {
        androidx.core.graphics.drawable.a_renamed.a_renamed(this.mDrawable, z_renamed);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return androidx.core.graphics.drawable.a_renamed.b_renamed(this.mDrawable);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i_renamed) {
        androidx.core.graphics.drawable.a_renamed.a_renamed(this.mDrawable, i_renamed);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(android.content.res.ColorStateList colorStateList) {
        androidx.core.graphics.drawable.a_renamed.a_renamed(this.mDrawable, colorStateList);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(android.graphics.PorterDuff.Mode mode) {
        androidx.core.graphics.drawable.a_renamed.a_renamed(this.mDrawable, mode);
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f_renamed, float f2) {
        androidx.core.graphics.drawable.a_renamed.a_renamed(this.mDrawable, f_renamed, f2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i_renamed, int i2, int i3, int i4) {
        androidx.core.graphics.drawable.a_renamed.a_renamed(this.mDrawable, i_renamed, i2, i3, i4);
    }

    public android.graphics.drawable.Drawable getWrappedDrawable() {
        return this.mDrawable;
    }

    public void setWrappedDrawable(android.graphics.drawable.Drawable drawable) {
        android.graphics.drawable.Drawable drawable2 = this.mDrawable;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.mDrawable = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }
}
