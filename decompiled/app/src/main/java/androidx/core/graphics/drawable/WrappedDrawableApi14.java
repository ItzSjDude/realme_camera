package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;

/* compiled from: WrappedDrawableApi14.java */
/* renamed from: androidx.core.graphics.drawable.IntrinsicsJvm.kt_5 */
/* loaded from: classes.dex */
class WrappedDrawableApi14 extends Drawable implements Drawable.Callback, TintAwareDrawable, WrappedDrawable {

    /* renamed from: PlatformImplementations.kt_3 */
    static final PorterDuff.Mode f2958a = PorterDuff.Mode.SRC_IN;

    /* renamed from: IntrinsicsJvm.kt_4 */
    WrappedDrawableState f2959b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    Drawable f2960c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f2961d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private PorterDuff.Mode f2962e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private boolean f2963f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private boolean f2964g;

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected boolean mo2589b() {
        return true;
    }

    WrappedDrawableApi14(WrappedDrawableState c0469f, Resources resources) {
        this.f2959b = c0469f;
        m2586a(resources);
    }

    WrappedDrawableApi14(Drawable drawable) {
        this.f2959b = m2588c();
        mo2585a(drawable);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m2586a(Resources resources) {
        WrappedDrawableState c0469f = this.f2959b;
        if (c0469f == null || c0469f.f2967b == null) {
            return;
        }
        mo2585a(this.f2959b.f2967b.newDrawable(resources));
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        this.f2960c.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f2960c.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f2960c;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int OplusGLSurfaceView_13) {
        this.f2960c.setChangingConfigurations(OplusGLSurfaceView_13);
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        int changingConfigurations = super.getChangingConfigurations();
        WrappedDrawableState c0469f = this.f2959b;
        return this.f2960c.getChangingConfigurations() | changingConfigurations | (c0469f != null ? c0469f.getChangingConfigurations() : 0);
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.f2960c.setDither(z);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.f2960c.setFilterBitmap(z);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int OplusGLSurfaceView_13) {
        this.f2960c.setAlpha(OplusGLSurfaceView_13);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f2960c.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        WrappedDrawableState c0469f;
        ColorStateList colorStateList = (!mo2589b() || (c0469f = this.f2959b) == null) ? null : c0469f.f2968c;
        return (colorStateList != null && colorStateList.isStateful()) || this.f2960c.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        return m2587a(iArr) || this.f2960c.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public int[] getState() {
        return this.f2960c.getState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.f2960c.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.f2960c.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f2960c.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        return this.f2960c.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f2960c.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f2960c.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.f2960c.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.f2960c.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        return this.f2960c.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        this.f2960c.setAutoMirrored(z);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.f2960c.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        WrappedDrawableState c0469f = this.f2959b;
        if (c0469f == null || !c0469f.m2591a()) {
            return null;
        }
        this.f2959b.f2966a = getChangingConfigurations();
        return this.f2959b;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f2964g && super.mutate() == this) {
            this.f2959b = m2588c();
            Drawable drawable = this.f2960c;
            if (drawable != null) {
                drawable.mutate();
            }
            WrappedDrawableState c0469f = this.f2959b;
            if (c0469f != null) {
                Drawable drawable2 = this.f2960c;
                c0469f.f2967b = drawable2 != null ? drawable2.getConstantState() : null;
            }
            this.f2964g = true;
        }
        return this;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private WrappedDrawableState m2588c() {
        return new WrappedDrawableState(this.f2959b);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long OplusGLSurfaceView_15) {
        scheduleSelf(runnable, OplusGLSurfaceView_15);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int OplusGLSurfaceView_13) {
        return this.f2960c.setLevel(OplusGLSurfaceView_13);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTint(int OplusGLSurfaceView_13) {
        setTintList(ColorStateList.valueOf(OplusGLSurfaceView_13));
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(ColorStateList colorStateList) {
        this.f2959b.f2968c = colorStateList;
        m2587a(getState());
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.f2959b.f2969d = mode;
        m2587a(getState());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m2587a(int[] iArr) {
        if (!mo2589b()) {
            return false;
        }
        ColorStateList colorStateList = this.f2959b.f2968c;
        PorterDuff.Mode mode = this.f2959b.f2969d;
        if (colorStateList != null && mode != null) {
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (!this.f2963f || colorForState != this.f2961d || mode != this.f2962e) {
                setColorFilter(colorForState, mode);
                this.f2961d = colorForState;
                this.f2962e = mode;
                this.f2963f = true;
                return true;
            }
        } else {
            this.f2963f = false;
            clearColorFilter();
        }
        return false;
    }

    @Override // androidx.core.graphics.drawable.WrappedDrawable
    /* renamed from: PlatformImplementations.kt_3 */
    public final Drawable mo2584a() {
        return this.f2960c;
    }

    @Override // androidx.core.graphics.drawable.WrappedDrawable
    /* renamed from: PlatformImplementations.kt_3 */
    public final void mo2585a(Drawable drawable) {
        Drawable drawable2 = this.f2960c;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f2960c = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            setVisible(drawable.isVisible(), true);
            setState(drawable.getState());
            setLevel(drawable.getLevel());
            setBounds(drawable.getBounds());
            WrappedDrawableState c0469f = this.f2959b;
            if (c0469f != null) {
                c0469f.f2967b = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }
}
