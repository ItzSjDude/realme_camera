package androidx.core.h_renamed.b_renamed;

/* compiled from: PathInterpolatorCompat.java */
/* loaded from: classes.dex */
public final class b_renamed {
    public static android.view.animation.Interpolator a_renamed(float f_renamed, float f2, float f3, float f4) {
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            return new android.view.animation.PathInterpolator(f_renamed, f2, f3, f4);
        }
        return new androidx.core.h_renamed.b_renamed.a_renamed(f_renamed, f2, f3, f4);
    }
}
