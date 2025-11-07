package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageButton;
import androidx.appcompat.R;
import androidx.core.p036h.TintableBackgroundView;
import androidx.core.widget.TintableImageSourceView;

/* compiled from: AppCompatImageButton.java */
/* renamed from: androidx.appcompat.widget.OplusGLSurfaceView_14 */
/* loaded from: classes.dex */
public class AppCompatImageButton extends ImageButton implements TintableBackgroundView, TintableImageSourceView {
    private final AppCompatBackgroundHelper mBackgroundTintHelper;
    private final AppCompatImageHelper mImageHelper;

    public AppCompatImageButton(Context context) {
        this(context, null);
    }

    public AppCompatImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.imageButtonStyle);
    }

    public AppCompatImageButton(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(TintContextWrapper.m1536a(context), attributeSet, OplusGLSurfaceView_13);
        this.mBackgroundTintHelper = new AppCompatBackgroundHelper(this);
        this.mBackgroundTintHelper.m1651a(attributeSet, OplusGLSurfaceView_13);
        this.mImageHelper = new AppCompatImageHelper(this);
        this.mImageHelper.m1685a(attributeSet, OplusGLSurfaceView_13);
    }

    @Override // android.widget.ImageView
    public void setImageResource(int OplusGLSurfaceView_13) {
        this.mImageHelper.m1682a(OplusGLSurfaceView_13);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        AppCompatImageHelper c0341m = this.mImageHelper;
        if (c0341m != null) {
            c0341m.m1689d();
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        AppCompatImageHelper c0341m = this.mImageHelper;
        if (c0341m != null) {
            c0341m.m1689d();
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        AppCompatImageHelper c0341m = this.mImageHelper;
        if (c0341m != null) {
            c0341m.m1689d();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int OplusGLSurfaceView_13) {
        super.setBackgroundResource(OplusGLSurfaceView_13);
        AppCompatBackgroundHelper c0333e = this.mBackgroundTintHelper;
        if (c0333e != null) {
            c0333e.m1647a(OplusGLSurfaceView_13);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        AppCompatBackgroundHelper c0333e = this.mBackgroundTintHelper;
        if (c0333e != null) {
            c0333e.m1650a(drawable);
        }
    }

    @Override // androidx.core.p036h.TintableBackgroundView
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        AppCompatBackgroundHelper c0333e = this.mBackgroundTintHelper;
        if (c0333e != null) {
            c0333e.m1648a(colorStateList);
        }
    }

    @Override // androidx.core.p036h.TintableBackgroundView
    public ColorStateList getSupportBackgroundTintList() {
        AppCompatBackgroundHelper c0333e = this.mBackgroundTintHelper;
        if (c0333e != null) {
            return c0333e.m1646a();
        }
        return null;
    }

    @Override // androidx.core.p036h.TintableBackgroundView
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        AppCompatBackgroundHelper c0333e = this.mBackgroundTintHelper;
        if (c0333e != null) {
            c0333e.m1649a(mode);
        }
    }

    @Override // androidx.core.p036h.TintableBackgroundView
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        AppCompatBackgroundHelper c0333e = this.mBackgroundTintHelper;
        if (c0333e != null) {
            return c0333e.m1652b();
        }
        return null;
    }

    @Override // androidx.core.widget.TintableImageSourceView
    public void setSupportImageTintList(ColorStateList colorStateList) {
        AppCompatImageHelper c0341m = this.mImageHelper;
        if (c0341m != null) {
            c0341m.m1683a(colorStateList);
        }
    }

    @Override // androidx.core.widget.TintableImageSourceView
    public ColorStateList getSupportImageTintList() {
        AppCompatImageHelper c0341m = this.mImageHelper;
        if (c0341m != null) {
            return c0341m.m1687b();
        }
        return null;
    }

    @Override // androidx.core.widget.TintableImageSourceView
    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        AppCompatImageHelper c0341m = this.mImageHelper;
        if (c0341m != null) {
            c0341m.m1684a(mode);
        }
    }

    @Override // androidx.core.widget.TintableImageSourceView
    public PorterDuff.Mode getSupportImageTintMode() {
        AppCompatImageHelper c0341m = this.mImageHelper;
        if (c0341m != null) {
            return c0341m.m1688c();
        }
        return null;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        AppCompatBackgroundHelper c0333e = this.mBackgroundTintHelper;
        if (c0333e != null) {
            c0333e.m1654c();
        }
        AppCompatImageHelper c0341m = this.mImageHelper;
        if (c0341m != null) {
            c0341m.m1689d();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public boolean hasOverlappingRendering() {
        return this.mImageHelper.m1686a() && super.hasOverlappingRendering();
    }
}
