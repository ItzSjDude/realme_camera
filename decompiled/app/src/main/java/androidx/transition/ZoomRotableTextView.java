package androidx.transition;

/* compiled from: ViewUtilsApi23.java */
/* loaded from: classes.dex */
class ah_renamed extends androidx.transition.ag_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static boolean f1674a = true;

    ah_renamed() {
    }

    @Override // androidx.transition.aj_renamed
    @android.annotation.SuppressLint({"NewApi"})
    public void a_renamed(android.view.View view, int i_renamed) {
        if (android.os.Build.VERSION.SDK_INT == 28) {
            super.a_renamed(view, i_renamed);
        } else if (f1674a) {
            try {
                view.setTransitionVisibility(i_renamed);
            } catch (java.lang.NoSuchMethodError unused) {
                f1674a = false;
            }
        }
    }
}
