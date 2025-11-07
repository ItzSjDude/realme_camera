package androidx.appcompat.app;

/* compiled from: AppCompatDialogFragment.java */
/* loaded from: classes.dex */
public class g_renamed extends androidx.fragment.app.b_renamed {
    @Override // androidx.fragment.app.b_renamed
    public android.app.Dialog onCreateDialog(android.os.Bundle bundle) {
        return new androidx.appcompat.app.f_renamed(getContext(), getTheme());
    }

    @Override // androidx.fragment.app.b_renamed
    public void setupDialog(android.app.Dialog dialog, int i_renamed) {
        if (dialog instanceof androidx.appcompat.app.f_renamed) {
            androidx.appcompat.app.f_renamed fVar = (androidx.appcompat.app.f_renamed) dialog;
            if (i_renamed != 1 && i_renamed != 2) {
                if (i_renamed != 3) {
                    return;
                } else {
                    dialog.getWindow().addFlags(24);
                }
            }
            fVar.supportRequestWindowFeature(1);
            return;
        }
        super.setupDialog(dialog, i_renamed);
    }
}
