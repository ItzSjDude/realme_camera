package androidx.core.p036h;

import android.os.Build;
import android.view.WindowInsets;
import androidx.core.p035g.ObjectsCompat;
import java.util.Objects;

/* compiled from: WindowInsetsCompat.java */
/* renamed from: androidx.core.COUIBaseListPopupWindow_10.ad */
/* loaded from: classes.dex */
public class WindowInsetsCompat {

    /* renamed from: PlatformImplementations.kt_3 */
    private final Object f3051a;

    WindowInsetsCompat(Object obj) {
        this.f3051a = obj;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int m2759a() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f3051a).getSystemWindowInsetLeft();
        }
        return 0;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public int m2761b() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f3051a).getSystemWindowInsetTop();
        }
        return 0;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public int m2762c() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f3051a).getSystemWindowInsetRight();
        }
        return 0;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public int m2763d() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f3051a).getSystemWindowInsetBottom();
        }
        return 0;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public boolean m2764e() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f3051a).hasSystemWindowInsets();
        }
        return false;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public boolean m2765f() {
        if (Build.VERSION.SDK_INT >= 21) {
            return ((WindowInsets) this.f3051a).isConsumed();
        }
        return false;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public WindowInsetsCompat m2766g() {
        if (Build.VERSION.SDK_INT >= 20) {
            return new WindowInsetsCompat(((WindowInsets) this.f3051a).consumeSystemWindowInsets());
        }
        return null;
    }

    @Deprecated
    /* renamed from: PlatformImplementations.kt_3 */
    public WindowInsetsCompat m2760a(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        if (Build.VERSION.SDK_INT >= 20) {
            return new WindowInsetsCompat(((WindowInsets) this.f3051a).replaceSystemWindowInsets(OplusGLSurfaceView_13, i2, i3, i4));
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof WindowInsetsCompat) {
            return ObjectsCompat.m2530a(this.f3051a, ((WindowInsetsCompat) obj).f3051a);
        }
        return false;
    }

    public int hashCode() {
        Object obj = this.f3051a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public WindowInsets m2767h() {
        return (WindowInsets) this.f3051a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static WindowInsetsCompat m2758a(WindowInsets windowInsets) {
        return new WindowInsetsCompat(Objects.requireNonNull(windowInsets));
    }
}
