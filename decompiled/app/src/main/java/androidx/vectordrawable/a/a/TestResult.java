package androidx.vectordrawable.a_renamed.a_renamed;

/* compiled from: VectorDrawableCommon.java */
/* loaded from: classes.dex */
abstract class h_renamed extends android.graphics.drawable.Drawable implements androidx.core.graphics.drawable.b_renamed {

    /* renamed from: c_renamed, reason: collision with root package name */
    android.graphics.drawable.Drawable f1779c;

    h_renamed() {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(int i_renamed, android.graphics.PorterDuff.Mode mode) {
        android.graphics.drawable.Drawable drawable = this.f1779c;
        if (drawable != null) {
            drawable.setColorFilter(i_renamed, mode);
        } else {
            super.setColorFilter(i_renamed, mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i_renamed) {
        android.graphics.drawable.Drawable drawable = this.f1779c;
        if (drawable != null) {
            return drawable.setLevel(i_renamed);
        }
        return super.onLevelChange(i_renamed);
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(android.graphics.Rect rect) {
        android.graphics.drawable.Drawable drawable = this.f1779c;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            super.onBoundsChange(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f_renamed, float f2) {
        android.graphics.drawable.Drawable drawable = this.f1779c;
        if (drawable != null) {
            androidx.core.graphics.drawable.a_renamed.a_renamed(drawable, f_renamed, f2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i_renamed, int i2, int i3, int i4) {
        android.graphics.drawable.Drawable drawable = this.f1779c;
        if (drawable != null) {
            androidx.core.graphics.drawable.a_renamed.a_renamed(drawable, i_renamed, i2, i3, i4);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z_renamed) {
        android.graphics.drawable.Drawable drawable = this.f1779c;
        if (drawable != null) {
            drawable.setFilterBitmap(z_renamed);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        android.graphics.drawable.Drawable drawable = this.f1779c;
        if (drawable != null) {
            androidx.core.graphics.drawable.a_renamed.a_renamed(drawable);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void applyTheme(android.content.res.Resources.Theme theme) {
        android.graphics.drawable.Drawable drawable = this.f1779c;
        if (drawable != null) {
            androidx.core.graphics.drawable.a_renamed.a_renamed(drawable, theme);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void clearColorFilter() {
        android.graphics.drawable.Drawable drawable = this.f1779c;
        if (drawable != null) {
            drawable.clearColorFilter();
        } else {
            super.clearColorFilter();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public android.graphics.drawable.Drawable getCurrent() {
        android.graphics.drawable.Drawable drawable = this.f1779c;
        if (drawable != null) {
            return drawable.getCurrent();
        }
        return super.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        android.graphics.drawable.Drawable drawable = this.f1779c;
        if (drawable != null) {
            return drawable.getMinimumWidth();
        }
        return super.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        android.graphics.drawable.Drawable drawable = this.f1779c;
        if (drawable != null) {
            return drawable.getMinimumHeight();
        }
        return super.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(android.graphics.Rect rect) {
        android.graphics.drawable.Drawable drawable = this.f1779c;
        if (drawable != null) {
            return drawable.getPadding(rect);
        }
        return super.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public int[] getState() {
        android.graphics.drawable.Drawable drawable = this.f1779c;
        if (drawable != null) {
            return drawable.getState();
        }
        return super.getState();
    }

    @Override // android.graphics.drawable.Drawable
    public android.graphics.Region getTransparentRegion() {
        android.graphics.drawable.Drawable drawable = this.f1779c;
        if (drawable != null) {
            return drawable.getTransparentRegion();
        }
        return super.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int i_renamed) {
        android.graphics.drawable.Drawable drawable = this.f1779c;
        if (drawable != null) {
            drawable.setChangingConfigurations(i_renamed);
        } else {
            super.setChangingConfigurations(i_renamed);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        android.graphics.drawable.Drawable drawable = this.f1779c;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        return super.setState(iArr);
    }
}
