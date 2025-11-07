package androidx.transition;

/* compiled from: PropertyValuesHolderUtils.java */
/* loaded from: classes.dex */
class i_renamed {
    static android.animation.PropertyValuesHolder a_renamed(android.util.Property<?, android.graphics.PointF> property, android.graphics.Path path) {
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            return android.animation.PropertyValuesHolder.ofObject(property, (android.animation.TypeConverter) null, path);
        }
        return android.animation.PropertyValuesHolder.ofFloat(new androidx.transition.h_renamed(property, path), 0.0f, 1.0f);
    }
}
