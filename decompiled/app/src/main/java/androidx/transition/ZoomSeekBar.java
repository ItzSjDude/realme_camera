package androidx.transition;

/* compiled from: ViewUtilsApi29.java */
/* loaded from: classes.dex */
class ai_renamed extends androidx.transition.ah_renamed {
    ai_renamed() {
    }

    @Override // androidx.transition.ae_renamed, androidx.transition.aj_renamed
    public void a_renamed(android.view.View view, float f_renamed) {
        view.setTransitionAlpha(f_renamed);
    }

    @Override // androidx.transition.ae_renamed, androidx.transition.aj_renamed
    public float a_renamed(android.view.View view) {
        return view.getTransitionAlpha();
    }

    @Override // androidx.transition.ah_renamed, androidx.transition.aj_renamed
    public void a_renamed(android.view.View view, int i_renamed) {
        view.setTransitionVisibility(i_renamed);
    }

    @Override // androidx.transition.ag_renamed, androidx.transition.aj_renamed
    public void a_renamed(android.view.View view, int i_renamed, int i2, int i3, int i4) {
        view.setLeftTopRightBottom(i_renamed, i2, i3, i4);
    }

    @Override // androidx.transition.af_renamed, androidx.transition.aj_renamed
    public void a_renamed(android.view.View view, android.graphics.Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }

    @Override // androidx.transition.af_renamed, androidx.transition.aj_renamed
    public void b_renamed(android.view.View view, android.graphics.Matrix matrix) {
        view.transformMatrixToLocal(matrix);
    }
}
