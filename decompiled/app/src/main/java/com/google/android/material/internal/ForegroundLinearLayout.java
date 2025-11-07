package com.google.android.material.internal;

/* loaded from: classes.dex */
public class ForegroundLinearLayout extends androidx.appcompat.widget.LinearLayoutCompat {
    private android.graphics.drawable.Drawable foreground;
    boolean foregroundBoundsChanged;
    private int foregroundGravity;
    protected boolean mForegroundInPadding;
    private final android.graphics.Rect overlayBounds;
    private final android.graphics.Rect selfBounds;

    public ForegroundLinearLayout(android.content.Context context) {
        this(context, null);
    }

    public ForegroundLinearLayout(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ForegroundLinearLayout(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        this.selfBounds = new android.graphics.Rect();
        this.overlayBounds = new android.graphics.Rect();
        this.foregroundGravity = 119;
        this.mForegroundInPadding = true;
        this.foregroundBoundsChanged = false;
        android.content.res.TypedArray typedArrayObtainStyledAttributes = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(context, attributeSet, com.google.android.material.R_renamed.styleable.ForegroundLinearLayout, i_renamed, 0, new int[0]);
        this.foregroundGravity = typedArrayObtainStyledAttributes.getInt(com.google.android.material.R_renamed.styleable.ForegroundLinearLayout_android_foregroundGravity, this.foregroundGravity);
        android.graphics.drawable.Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(com.google.android.material.R_renamed.styleable.ForegroundLinearLayout_android_foreground);
        if (drawable != null) {
            setForeground(drawable);
        }
        this.mForegroundInPadding = typedArrayObtainStyledAttributes.getBoolean(com.google.android.material.R_renamed.styleable.ForegroundLinearLayout_foregroundInsidePadding, true);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public int getForegroundGravity() {
        return this.foregroundGravity;
    }

    @Override // android.view.View
    public void setForegroundGravity(int i_renamed) {
        if (this.foregroundGravity != i_renamed) {
            if ((8388615 & i_renamed) == 0) {
                i_renamed |= 8388611;
            }
            if ((i_renamed & 112) == 0) {
                i_renamed |= 48;
            }
            this.foregroundGravity = i_renamed;
            if (this.foregroundGravity == 119 && this.foreground != null) {
                this.foreground.getPadding(new android.graphics.Rect());
            }
            requestLayout();
        }
    }

    @Override // android.view.View
    protected boolean verifyDrawable(android.graphics.drawable.Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.foreground;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        android.graphics.drawable.Drawable drawable = this.foreground;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        android.graphics.drawable.Drawable drawable = this.foreground;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        this.foreground.setState(getDrawableState());
    }

    @Override // android.view.View
    public void setForeground(android.graphics.drawable.Drawable drawable) {
        android.graphics.drawable.Drawable drawable2 = this.foreground;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
                unscheduleDrawable(this.foreground);
            }
            this.foreground = drawable;
            if (drawable != null) {
                setWillNotDraw(false);
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
                if (this.foregroundGravity == 119) {
                    drawable.getPadding(new android.graphics.Rect());
                }
            } else {
                setWillNotDraw(true);
            }
            requestLayout();
            invalidate();
        }
    }

    @Override // android.view.View
    public android.graphics.drawable.Drawable getForeground() {
        return this.foreground;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z_renamed, int i_renamed, int i2, int i3, int i4) {
        super.onLayout(z_renamed, i_renamed, i2, i3, i4);
        this.foregroundBoundsChanged = z_renamed | this.foregroundBoundsChanged;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i_renamed, int i2, int i3, int i4) {
        super.onSizeChanged(i_renamed, i2, i3, i4);
        this.foregroundBoundsChanged = true;
    }

    @Override // android.view.View
    public void draw(android.graphics.Canvas canvas) {
        super.draw(canvas);
        android.graphics.drawable.Drawable drawable = this.foreground;
        if (drawable != null) {
            if (this.foregroundBoundsChanged) {
                this.foregroundBoundsChanged = false;
                android.graphics.Rect rect = this.selfBounds;
                android.graphics.Rect rect2 = this.overlayBounds;
                int right = getRight() - getLeft();
                int bottom = getBottom() - getTop();
                if (this.mForegroundInPadding) {
                    rect.set(0, 0, right, bottom);
                } else {
                    rect.set(getPaddingLeft(), getPaddingTop(), right - getPaddingRight(), bottom - getPaddingBottom());
                }
                android.view.Gravity.apply(this.foregroundGravity, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), rect, rect2);
                drawable.setBounds(rect2);
            }
            drawable.draw(canvas);
        }
    }

    @Override // android.view.View
    @android.annotation.TargetApi(21)
    public void drawableHotspotChanged(float f_renamed, float f2) {
        super.drawableHotspotChanged(f_renamed, f2);
        android.graphics.drawable.Drawable drawable = this.foreground;
        if (drawable != null) {
            drawable.setHotspot(f_renamed, f2);
        }
    }
}
