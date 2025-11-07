package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.R;
import androidx.appcompat.p016a.p017a.AppCompatResources;
import androidx.core.widget.ImageViewCompat;

/* compiled from: AppCompatImageHelper.java */
/* renamed from: androidx.appcompat.widget.OplusGLSurfaceView_6 */
/* loaded from: classes.dex */
public class AppCompatImageHelper {

    /* renamed from: PlatformImplementations.kt_3 */
    private final ImageView f1968a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private TintInfo f1969b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private TintInfo f1970c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private TintInfo f1971d;

    public AppCompatImageHelper(ImageView imageView) {
        this.f1968a = imageView;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m1685a(AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        int iM1560g;
        TintTypedArray c0322arM1541a = TintTypedArray.m1541a(this.f1968a.getContext(), attributeSet, R.styleable.AppCompatImageView, OplusGLSurfaceView_13, 0);
        try {
            Drawable drawable = this.f1968a.getDrawable();
            if (drawable == null && (iM1560g = c0322arM1541a.m1560g(R.styleable.AppCompatImageView_srcCompat, -1)) != -1 && (drawable = AppCompatResources.m732b(this.f1968a.getContext(), iM1560g)) != null) {
                this.f1968a.setImageDrawable(drawable);
            }
            if (drawable != null) {
                DrawableUtils.m1396b(drawable);
            }
            if (c0322arM1541a.m1561g(R.styleable.AppCompatImageView_tint)) {
                ImageViewCompat.m3036a(this.f1968a, c0322arM1541a.m1557e(R.styleable.AppCompatImageView_tint));
            }
            if (c0322arM1541a.m1561g(R.styleable.AppCompatImageView_tintMode)) {
                ImageViewCompat.m3037a(this.f1968a, DrawableUtils.m1394a(c0322arM1541a.m1544a(R.styleable.AppCompatImageView_tintMode, -1), null));
            }
        } finally {
            c0322arM1541a.m1551b();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m1682a(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 != 0) {
            Drawable drawableM732b = AppCompatResources.m732b(this.f1968a.getContext(), OplusGLSurfaceView_13);
            if (drawableM732b != null) {
                DrawableUtils.m1396b(drawableM732b);
            }
            this.f1968a.setImageDrawable(drawableM732b);
        } else {
            this.f1968a.setImageDrawable(null);
        }
        m1689d();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    boolean m1686a() {
        return Build.VERSION.SDK_INT < 21 || !(this.f1968a.getBackground() instanceof RippleDrawable);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m1683a(ColorStateList colorStateList) {
        if (this.f1970c == null) {
            this.f1970c = new TintInfo();
        }
        TintInfo c0320ap = this.f1970c;
        c0320ap.f1869a = colorStateList;
        c0320ap.f1872d = true;
        m1689d();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    ColorStateList m1687b() {
        TintInfo c0320ap = this.f1970c;
        if (c0320ap != null) {
            return c0320ap.f1869a;
        }
        return null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m1684a(PorterDuff.Mode mode) {
        if (this.f1970c == null) {
            this.f1970c = new TintInfo();
        }
        TintInfo c0320ap = this.f1970c;
        c0320ap.f1870b = mode;
        c0320ap.f1871c = true;
        m1689d();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    PorterDuff.Mode m1688c() {
        TintInfo c0320ap = this.f1970c;
        if (c0320ap != null) {
            return c0320ap.f1870b;
        }
        return null;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    void m1689d() {
        Drawable drawable = this.f1968a.getDrawable();
        if (drawable != null) {
            DrawableUtils.m1396b(drawable);
        }
        if (drawable != null) {
            if (m1681e() && m1680a(drawable)) {
                return;
            }
            TintInfo c0320ap = this.f1970c;
            if (c0320ap != null) {
                AppCompatDrawableManager.m1665a(drawable, c0320ap, this.f1968a.getDrawableState());
                return;
            }
            TintInfo c0320ap2 = this.f1969b;
            if (c0320ap2 != null) {
                AppCompatDrawableManager.m1665a(drawable, c0320ap2, this.f1968a.getDrawableState());
            }
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private boolean m1681e() {
        int OplusGLSurfaceView_13 = Build.VERSION.SDK_INT;
        return OplusGLSurfaceView_13 > 21 ? this.f1969b != null : OplusGLSurfaceView_13 == 21;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m1680a(Drawable drawable) {
        if (this.f1971d == null) {
            this.f1971d = new TintInfo();
        }
        TintInfo c0320ap = this.f1971d;
        c0320ap.m1538a();
        ColorStateList colorStateListM3035a = ImageViewCompat.m3035a(this.f1968a);
        if (colorStateListM3035a != null) {
            c0320ap.f1872d = true;
            c0320ap.f1869a = colorStateListM3035a;
        }
        PorterDuff.Mode modeM3038b = ImageViewCompat.m3038b(this.f1968a);
        if (modeM3038b != null) {
            c0320ap.f1871c = true;
            c0320ap.f1870b = modeM3038b;
        }
        if (!c0320ap.f1872d && !c0320ap.f1871c) {
            return false;
        }
        AppCompatDrawableManager.m1665a(drawable, c0320ap, this.f1968a.getDrawableState());
        return true;
    }
}
