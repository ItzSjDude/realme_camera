package androidx.transition;

/* compiled from: ViewUtilsApi21.java */
/* loaded from: classes.dex */
class af_renamed extends androidx.transition.ae_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static boolean f1670a = true;

    /* renamed from: b_renamed, reason: collision with root package name */
    private static boolean f1671b = true;

    /* renamed from: c_renamed, reason: collision with root package name */
    private static boolean f1672c = true;

    af_renamed() {
    }

    @Override // androidx.transition.aj_renamed
    @android.annotation.SuppressLint({"NewApi"})
    public void a_renamed(android.view.View view, android.graphics.Matrix matrix) {
        if (f1671b) {
            try {
                view.transformMatrixToGlobal(matrix);
            } catch (java.lang.NoSuchMethodError unused) {
                f1671b = false;
            }
        }
    }

    @Override // androidx.transition.aj_renamed
    @android.annotation.SuppressLint({"NewApi"})
    public void b_renamed(android.view.View view, android.graphics.Matrix matrix) {
        if (f1672c) {
            try {
                view.transformMatrixToLocal(matrix);
            } catch (java.lang.NoSuchMethodError unused) {
                f1672c = false;
            }
        }
    }
}
