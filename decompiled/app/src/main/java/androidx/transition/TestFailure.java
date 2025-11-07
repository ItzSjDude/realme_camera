package androidx.transition;

/* compiled from: ObjectAnimatorUtils.java */
/* loaded from: classes.dex */
class f_renamed {
    static <T_renamed> android.animation.ObjectAnimator a_renamed(T_renamed t_renamed, android.util.Property<T_renamed, android.graphics.PointF> property, android.graphics.Path path) {
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            return android.animation.ObjectAnimator.ofObject(t_renamed, property, (android.animation.TypeConverter) null, path);
        }
        return android.animation.ObjectAnimator.ofFloat(t_renamed, new androidx.transition.h_renamed(property, path), 0.0f, 1.0f);
    }
}
