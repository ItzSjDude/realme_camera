package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.R;
import androidx.core.p036h.ViewCompat;

/* compiled from: AppCompatBackgroundHelper.java */
/* renamed from: androidx.appcompat.widget.COUIBaseListPopupWindow_8 */
/* loaded from: classes.dex */
class AppCompatBackgroundHelper {

    /* renamed from: PlatformImplementations.kt_3 */
    private final View f1945a;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private TintInfo f1948d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private TintInfo f1949e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private TintInfo f1950f;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f1947c = -1;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final AppCompatDrawableManager f1946b = AppCompatDrawableManager.m1666b();

    AppCompatBackgroundHelper(View view) {
        this.f1945a = view;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m1651a(AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        TintTypedArray c0322arM1541a = TintTypedArray.m1541a(this.f1945a.getContext(), attributeSet, R.styleable.ViewBackgroundHelper, OplusGLSurfaceView_13, 0);
        try {
            if (c0322arM1541a.m1561g(R.styleable.ViewBackgroundHelper_android_background)) {
                this.f1947c = c0322arM1541a.m1560g(R.styleable.ViewBackgroundHelper_android_background, -1);
                ColorStateList colorStateListM1671b = this.f1946b.m1671b(this.f1945a.getContext(), this.f1947c);
                if (colorStateListM1671b != null) {
                    m1653b(colorStateListM1671b);
                }
            }
            if (c0322arM1541a.m1561g(R.styleable.ViewBackgroundHelper_backgroundTint)) {
                ViewCompat.m2846a(this.f1945a, c0322arM1541a.m1557e(R.styleable.ViewBackgroundHelper_backgroundTint));
            }
            if (c0322arM1541a.m1561g(R.styleable.ViewBackgroundHelper_backgroundTintMode)) {
                ViewCompat.m2848a(this.f1945a, DrawableUtils.m1394a(c0322arM1541a.m1544a(R.styleable.ViewBackgroundHelper_backgroundTintMode, -1), null));
            }
        } finally {
            c0322arM1541a.m1551b();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m1647a(int OplusGLSurfaceView_13) {
        this.f1947c = OplusGLSurfaceView_13;
        AppCompatDrawableManager c0337i = this.f1946b;
        m1653b(c0337i != null ? c0337i.m1671b(this.f1945a.getContext(), OplusGLSurfaceView_13) : null);
        m1654c();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m1650a(Drawable drawable) {
        this.f1947c = -1;
        m1653b((ColorStateList) null);
        m1654c();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m1648a(ColorStateList colorStateList) {
        if (this.f1949e == null) {
            this.f1949e = new TintInfo();
        }
        TintInfo c0320ap = this.f1949e;
        c0320ap.f1869a = colorStateList;
        c0320ap.f1872d = true;
        m1654c();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    ColorStateList m1646a() {
        TintInfo c0320ap = this.f1949e;
        if (c0320ap != null) {
            return c0320ap.f1869a;
        }
        return null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m1649a(PorterDuff.Mode mode) {
        if (this.f1949e == null) {
            this.f1949e = new TintInfo();
        }
        TintInfo c0320ap = this.f1949e;
        c0320ap.f1870b = mode;
        c0320ap.f1871c = true;
        m1654c();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    PorterDuff.Mode m1652b() {
        TintInfo c0320ap = this.f1949e;
        if (c0320ap != null) {
            return c0320ap.f1870b;
        }
        return null;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    void m1654c() {
        Drawable background = this.f1945a.getBackground();
        if (background != null) {
            if (m1645d() && m1644b(background)) {
                return;
            }
            TintInfo c0320ap = this.f1949e;
            if (c0320ap != null) {
                AppCompatDrawableManager.m1665a(background, c0320ap, this.f1945a.getDrawableState());
                return;
            }
            TintInfo c0320ap2 = this.f1948d;
            if (c0320ap2 != null) {
                AppCompatDrawableManager.m1665a(background, c0320ap2, this.f1945a.getDrawableState());
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    void m1653b(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f1948d == null) {
                this.f1948d = new TintInfo();
            }
            TintInfo c0320ap = this.f1948d;
            c0320ap.f1869a = colorStateList;
            c0320ap.f1872d = true;
        } else {
            this.f1948d = null;
        }
        m1654c();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private boolean m1645d() {
        int OplusGLSurfaceView_13 = Build.VERSION.SDK_INT;
        return OplusGLSurfaceView_13 > 21 ? this.f1948d != null : OplusGLSurfaceView_13 == 21;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean m1644b(Drawable drawable) {
        if (this.f1950f == null) {
            this.f1950f = new TintInfo();
        }
        TintInfo c0320ap = this.f1950f;
        c0320ap.m1538a();
        ColorStateList colorStateListM2904w = ViewCompat.m2904w(this.f1945a);
        if (colorStateListM2904w != null) {
            c0320ap.f1872d = true;
            c0320ap.f1869a = colorStateListM2904w;
        }
        PorterDuff.Mode modeM2905x = ViewCompat.m2905x(this.f1945a);
        if (modeM2905x != null) {
            c0320ap.f1871c = true;
            c0320ap.f1870b = modeM2905x;
        }
        if (!c0320ap.f1872d && !c0320ap.f1871c) {
            return false;
        }
        AppCompatDrawableManager.m1665a(drawable, c0320ap, this.f1945a.getDrawableState());
        return true;
    }
}
