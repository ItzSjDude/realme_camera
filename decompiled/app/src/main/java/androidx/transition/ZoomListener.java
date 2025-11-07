package androidx.transition;

/* compiled from: ViewUtilsApi22.java */
/* loaded from: classes.dex */
class ag_renamed extends androidx.transition.af_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static boolean f1673a = true;

    ag_renamed() {
    }

    @Override // androidx.transition.aj_renamed
    @android.annotation.SuppressLint({"NewApi"})
    public void a_renamed(android.view.View view, int i_renamed, int i2, int i3, int i4) {
        if (f1673a) {
            try {
                view.setLeftTopRightBottom(i_renamed, i2, i3, i4);
            } catch (java.lang.NoSuchMethodError unused) {
                f1673a = false;
            }
        }
    }
}
