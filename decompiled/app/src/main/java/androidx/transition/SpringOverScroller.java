package androidx.transition;

/* compiled from: ViewGroupUtils.java */
/* loaded from: classes.dex */
class y_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static boolean f1761a = true;

    static androidx.transition.x_renamed a_renamed(android.view.ViewGroup viewGroup) {
        if (android.os.Build.VERSION.SDK_INT >= 18) {
            return new androidx.transition.w_renamed(viewGroup);
        }
        return androidx.transition.v_renamed.a_renamed(viewGroup);
    }

    static void a_renamed(android.view.ViewGroup viewGroup, boolean z_renamed) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        if (android.os.Build.VERSION.SDK_INT >= 29) {
            viewGroup.suppressLayout(z_renamed);
        } else if (android.os.Build.VERSION.SDK_INT >= 18) {
            b_renamed(viewGroup, z_renamed);
        } else {
            androidx.transition.z_renamed.a_renamed(viewGroup, z_renamed);
        }
    }

    @android.annotation.SuppressLint({"NewApi"})
    private static void b_renamed(android.view.ViewGroup viewGroup, boolean z_renamed) {
        if (f1761a) {
            try {
                viewGroup.suppressLayout(z_renamed);
            } catch (java.lang.NoSuchMethodError unused) {
                f1761a = false;
            }
        }
    }
}
