package androidx.transition;

/* compiled from: ViewUtilsApi19.java */
/* loaded from: classes.dex */
class ae_renamed extends androidx.transition.aj_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static boolean f1669a = true;

    @Override // androidx.transition.aj_renamed
    public void b_renamed(android.view.View view) {
    }

    @Override // androidx.transition.aj_renamed
    public void c_renamed(android.view.View view) {
    }

    ae_renamed() {
    }

    @Override // androidx.transition.aj_renamed
    @android.annotation.SuppressLint({"NewApi"})
    public void a_renamed(android.view.View view, float f_renamed) {
        if (f1669a) {
            try {
                view.setTransitionAlpha(f_renamed);
                return;
            } catch (java.lang.NoSuchMethodError unused) {
                f1669a = false;
            }
        }
        view.setAlpha(f_renamed);
    }

    @Override // androidx.transition.aj_renamed
    @android.annotation.SuppressLint({"NewApi"})
    public float a_renamed(android.view.View view) {
        if (f1669a) {
            try {
                return view.getTransitionAlpha();
            } catch (java.lang.NoSuchMethodError unused) {
                f1669a = false;
            }
        }
        return view.getAlpha();
    }
}
