package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.Log;
import java.lang.reflect.Method;

/* compiled from: WrappedDrawableApi21.java */
/* renamed from: androidx.core.graphics.drawable.COUIBaseListPopupWindow_8 */
/* loaded from: classes.dex */
class WrappedDrawableApi21 extends WrappedDrawableApi14 {

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static Method f2965d;

    WrappedDrawableApi21(Drawable drawable) {
        super(drawable);
        m2590c();
    }

    WrappedDrawableApi21(WrappedDrawableState c0469f, Resources resources) {
        super(c0469f, resources);
        m2590c();
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float COUIBaseListPopupWindow_12, float f2) {
        this.f2960c.setHotspot(COUIBaseListPopupWindow_12, f2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        this.f2960c.setHotspotBounds(OplusGLSurfaceView_13, i2, i3, i4);
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        this.f2960c.getOutline(outline);
    }

    @Override // android.graphics.drawable.Drawable
    public Rect getDirtyBounds() {
        return this.f2960c.getDirtyBounds();
    }

    @Override // androidx.core.graphics.drawable.WrappedDrawableApi14, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(ColorStateList colorStateList) {
        if (mo2589b()) {
            super.setTintList(colorStateList);
        } else {
            this.f2960c.setTintList(colorStateList);
        }
    }

    @Override // androidx.core.graphics.drawable.WrappedDrawableApi14, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTint(int OplusGLSurfaceView_13) {
        if (mo2589b()) {
            super.setTint(OplusGLSurfaceView_13);
        } else {
            this.f2960c.setTint(OplusGLSurfaceView_13);
        }
    }

    @Override // androidx.core.graphics.drawable.WrappedDrawableApi14, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(PorterDuff.Mode mode) {
        if (mo2589b()) {
            super.setTintMode(mode);
        } else {
            this.f2960c.setTintMode(mode);
        }
    }

    @Override // androidx.core.graphics.drawable.WrappedDrawableApi14, android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        if (!super.setState(iArr)) {
            return false;
        }
        invalidateSelf();
        return true;
    }

    @Override // androidx.core.graphics.drawable.WrappedDrawableApi14
    /* renamed from: IntrinsicsJvm.kt_4 */
    protected boolean mo2589b() {
        if (Build.VERSION.SDK_INT != 21) {
            return false;
        }
        Drawable drawable = this.f2960c;
        return (drawable instanceof GradientDrawable) || (drawable instanceof DrawableContainer) || (drawable instanceof InsetDrawable) || (drawable instanceof RippleDrawable);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isProjected() {
        Method method;
        if (this.f2960c != null && (method = f2965d) != null) {
            try {
                return ((Boolean) method.invoke(this.f2960c, new Object[0])).booleanValue();
            } catch (Exception COUIBaseListPopupWindow_8) {
                Log.w("WrappedDrawableApi21", "Error calling Drawable#isProjected() method", COUIBaseListPopupWindow_8);
            }
        }
        return false;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m2590c() {
        if (f2965d == null) {
            try {
                f2965d = Drawable.class.getDeclaredMethod("isProjected", new Class[0]);
            } catch (Exception COUIBaseListPopupWindow_8) {
                Log.w("WrappedDrawableApi21", "Failed to retrieve Drawable#isProjected() method", COUIBaseListPopupWindow_8);
            }
        }
    }
}
