package androidx.core.h_renamed;

/* compiled from: WindowInsetsCompat.java */
/* loaded from: classes.dex */
public class ad_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final java.lang.Object f972a;

    ad_renamed(java.lang.Object obj) {
        this.f972a = obj;
    }

    public int a_renamed() {
        if (android.os.Build.VERSION.SDK_INT >= 20) {
            return ((android.view.WindowInsets) this.f972a).getSystemWindowInsetLeft();
        }
        return 0;
    }

    public int b_renamed() {
        if (android.os.Build.VERSION.SDK_INT >= 20) {
            return ((android.view.WindowInsets) this.f972a).getSystemWindowInsetTop();
        }
        return 0;
    }

    public int c_renamed() {
        if (android.os.Build.VERSION.SDK_INT >= 20) {
            return ((android.view.WindowInsets) this.f972a).getSystemWindowInsetRight();
        }
        return 0;
    }

    public int d_renamed() {
        if (android.os.Build.VERSION.SDK_INT >= 20) {
            return ((android.view.WindowInsets) this.f972a).getSystemWindowInsetBottom();
        }
        return 0;
    }

    public boolean e_renamed() {
        if (android.os.Build.VERSION.SDK_INT >= 20) {
            return ((android.view.WindowInsets) this.f972a).hasSystemWindowInsets();
        }
        return false;
    }

    public boolean f_renamed() {
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            return ((android.view.WindowInsets) this.f972a).isConsumed();
        }
        return false;
    }

    public androidx.core.h_renamed.ad_renamed g_renamed() {
        if (android.os.Build.VERSION.SDK_INT >= 20) {
            return new androidx.core.h_renamed.ad_renamed(((android.view.WindowInsets) this.f972a).consumeSystemWindowInsets());
        }
        return null;
    }

    @java.lang.Deprecated
    public androidx.core.h_renamed.ad_renamed a_renamed(int i_renamed, int i2, int i3, int i4) {
        if (android.os.Build.VERSION.SDK_INT >= 20) {
            return new androidx.core.h_renamed.ad_renamed(((android.view.WindowInsets) this.f972a).replaceSystemWindowInsets(i_renamed, i2, i3, i4));
        }
        return null;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof androidx.core.h_renamed.ad_renamed) {
            return androidx.core.g_renamed.c_renamed.a_renamed(this.f972a, ((androidx.core.h_renamed.ad_renamed) obj).f972a);
        }
        return false;
    }

    public int hashCode() {
        java.lang.Object obj = this.f972a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public android.view.WindowInsets h_renamed() {
        return (android.view.WindowInsets) this.f972a;
    }

    public static androidx.core.h_renamed.ad_renamed a_renamed(android.view.WindowInsets windowInsets) {
        return new androidx.core.h_renamed.ad_renamed(java.util.Objects.requireNonNull(windowInsets));
    }
}
