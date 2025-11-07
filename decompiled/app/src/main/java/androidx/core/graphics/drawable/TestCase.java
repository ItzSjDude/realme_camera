package androidx.core.graphics.drawable;

/* compiled from: WrappedDrawableApi21.java */
/* loaded from: classes.dex */
class e_renamed extends androidx.core.graphics.drawable.d_renamed {
    private static java.lang.reflect.Method d_renamed;

    e_renamed(android.graphics.drawable.Drawable drawable) {
        super(drawable);
        c_renamed();
    }

    e_renamed(androidx.core.graphics.drawable.f_renamed fVar, android.content.res.Resources resources) {
        super(fVar, resources);
        c_renamed();
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f_renamed, float f2) {
        this.f933c.setHotspot(f_renamed, f2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i_renamed, int i2, int i3, int i4) {
        this.f933c.setHotspotBounds(i_renamed, i2, i3, i4);
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(android.graphics.Outline outline) {
        this.f933c.getOutline(outline);
    }

    @Override // android.graphics.drawable.Drawable
    public android.graphics.Rect getDirtyBounds() {
        return this.f933c.getDirtyBounds();
    }

    @Override // androidx.core.graphics.drawable.d_renamed, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b_renamed
    public void setTintList(android.content.res.ColorStateList colorStateList) {
        if (b_renamed()) {
            super.setTintList(colorStateList);
        } else {
            this.f933c.setTintList(colorStateList);
        }
    }

    @Override // androidx.core.graphics.drawable.d_renamed, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b_renamed
    public void setTint(int i_renamed) {
        if (b_renamed()) {
            super.setTint(i_renamed);
        } else {
            this.f933c.setTint(i_renamed);
        }
    }

    @Override // androidx.core.graphics.drawable.d_renamed, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b_renamed
    public void setTintMode(android.graphics.PorterDuff.Mode mode) {
        if (b_renamed()) {
            super.setTintMode(mode);
        } else {
            this.f933c.setTintMode(mode);
        }
    }

    @Override // androidx.core.graphics.drawable.d_renamed, android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        if (!super.setState(iArr)) {
            return false;
        }
        invalidateSelf();
        return true;
    }

    @Override // androidx.core.graphics.drawable.d_renamed
    protected boolean b_renamed() {
        if (android.os.Build.VERSION.SDK_INT != 21) {
            return false;
        }
        android.graphics.drawable.Drawable drawable = this.f933c;
        return (drawable instanceof android.graphics.drawable.GradientDrawable) || (drawable instanceof android.graphics.drawable.DrawableContainer) || (drawable instanceof android.graphics.drawable.InsetDrawable) || (drawable instanceof android.graphics.drawable.RippleDrawable);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isProjected() {
        java.lang.reflect.Method method;
        if (this.f933c != null && (method = d_renamed) != null) {
            try {
                return ((java.lang.Boolean) method.invoke(this.f933c, new java.lang.Object[0])).booleanValue();
            } catch (java.lang.Exception e_renamed) {
                android.util.Log.w_renamed("WrappedDrawableApi21", "Error calling Drawable#isProjected() method", e_renamed);
            }
        }
        return false;
    }

    private void c_renamed() {
        if (d_renamed == null) {
            try {
                d_renamed = android.graphics.drawable.Drawable.class.getDeclaredMethod("isProjected", new java.lang.Class[0]);
            } catch (java.lang.Exception e_renamed) {
                android.util.Log.w_renamed("WrappedDrawableApi21", "Failed to retrieve Drawable#isProjected() method", e_renamed);
            }
        }
    }
}
