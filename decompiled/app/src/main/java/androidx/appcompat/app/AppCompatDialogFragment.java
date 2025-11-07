package androidx.appcompat.app;

import android.app.Dialog;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;

/* compiled from: AppCompatDialogFragment.java */
/* renamed from: androidx.appcompat.app.COUIBaseListPopupWindow_11 */
/* loaded from: classes.dex */
public class AppCompatDialogFragment extends DialogFragment {
    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        return new AppCompatDialog(getContext(), getTheme());
    }

    @Override // androidx.fragment.app.DialogFragment
    public void setupDialog(Dialog dialog, int OplusGLSurfaceView_13) {
        if (dialog instanceof AppCompatDialog) {
            AppCompatDialog dialogC0208f = (AppCompatDialog) dialog;
            if (OplusGLSurfaceView_13 != 1 && OplusGLSurfaceView_13 != 2) {
                if (OplusGLSurfaceView_13 != 3) {
                    return;
                } else {
                    dialog.getWindow().addFlags(24);
                }
            }
            dialogC0208f.supportRequestWindowFeature(1);
            return;
        }
        super.setupDialog(dialog, OplusGLSurfaceView_13);
    }
}
