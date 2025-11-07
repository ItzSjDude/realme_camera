package androidx.vectordrawable.p055a.p056a;

import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.graphics.drawable.TintAwareDrawable;

/* compiled from: VectorDrawableCommon.java */
/* renamed from: androidx.vectordrawable.PlatformImplementations.kt_3.PlatformImplementations.kt_3.COUIBaseListPopupWindow_10 */
/* loaded from: classes.dex */
abstract class VectorDrawableCommon extends Drawable implements TintAwareDrawable {

    /* renamed from: IntrinsicsJvm.kt_3 */
    Drawable f4706c;

    VectorDrawableCommon() {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(int OplusGLSurfaceView_13, PorterDuff.Mode mode) {
        Drawable drawable = this.f4706c;
        if (drawable != null) {
            drawable.setColorFilter(OplusGLSurfaceView_13, mode);
        } else {
            super.setColorFilter(OplusGLSurfaceView_13, mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int OplusGLSurfaceView_13) {
        Drawable drawable = this.f4706c;
        if (drawable != null) {
            return drawable.setLevel(OplusGLSurfaceView_13);
        }
        return super.onLevelChange(OplusGLSurfaceView_13);
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f4706c;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            super.onBoundsChange(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float COUIBaseListPopupWindow_12, float f2) {
        Drawable drawable = this.f4706c;
        if (drawable != null) {
            DrawableCompat.m2567a(drawable, COUIBaseListPopupWindow_12, f2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        Drawable drawable = this.f4706c;
        if (drawable != null) {
            DrawableCompat.m2569a(drawable, OplusGLSurfaceView_13, i2, i3, i4);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        Drawable drawable = this.f4706c;
        if (drawable != null) {
            drawable.setFilterBitmap(z);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        Drawable drawable = this.f4706c;
        if (drawable != null) {
            DrawableCompat.m2566a(drawable);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.f4706c;
        if (drawable != null) {
            DrawableCompat.m2571a(drawable, theme);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void clearColorFilter() {
        Drawable drawable = this.f4706c;
        if (drawable != null) {
            drawable.clearColorFilter();
        } else {
            super.clearColorFilter();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        Drawable drawable = this.f4706c;
        if (drawable != null) {
            return drawable.getCurrent();
        }
        return super.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        Drawable drawable = this.f4706c;
        if (drawable != null) {
            return drawable.getMinimumWidth();
        }
        return super.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        Drawable drawable = this.f4706c;
        if (drawable != null) {
            return drawable.getMinimumHeight();
        }
        return super.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        Drawable drawable = this.f4706c;
        if (drawable != null) {
            return drawable.getPadding(rect);
        }
        return super.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public int[] getState() {
        Drawable drawable = this.f4706c;
        if (drawable != null) {
            return drawable.getState();
        }
        return super.getState();
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        Drawable drawable = this.f4706c;
        if (drawable != null) {
            return drawable.getTransparentRegion();
        }
        return super.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int OplusGLSurfaceView_13) {
        Drawable drawable = this.f4706c;
        if (drawable != null) {
            drawable.setChangingConfigurations(OplusGLSurfaceView_13);
        } else {
            super.setChangingConfigurations(OplusGLSurfaceView_13);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        Drawable drawable = this.f4706c;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        return super.setState(iArr);
    }
}
