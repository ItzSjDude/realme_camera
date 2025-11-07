package com.google.android.material.bottomsheet;

/* loaded from: classes.dex */
public class BottomSheetDialogFragment extends androidx.appcompat.app.g_renamed {
    private boolean waitingForDismissAllowingStateLoss;

    @Override // androidx.appcompat.app.g_renamed, androidx.fragment.app.b_renamed
    public android.app.Dialog onCreateDialog(android.os.Bundle bundle) {
        return new com.google.android.material.bottomsheet.BottomSheetDialog(getContext(), getTheme());
    }

    @Override // androidx.fragment.app.b_renamed
    public void dismiss() {
        if (tryDismissWithAnimation(false)) {
            return;
        }
        super.dismiss();
    }

    @Override // androidx.fragment.app.b_renamed
    public void dismissAllowingStateLoss() {
        if (tryDismissWithAnimation(true)) {
            return;
        }
        super.dismissAllowingStateLoss();
    }

    private boolean tryDismissWithAnimation(boolean z_renamed) {
        android.app.Dialog dialog = getDialog();
        if (!(dialog instanceof com.google.android.material.bottomsheet.BottomSheetDialog)) {
            return false;
        }
        com.google.android.material.bottomsheet.BottomSheetDialog bottomSheetDialog = (com.google.android.material.bottomsheet.BottomSheetDialog) dialog;
        com.google.android.material.bottomsheet.BottomSheetBehavior<android.widget.FrameLayout> behavior = bottomSheetDialog.getBehavior();
        if (!behavior.isHideable() || !bottomSheetDialog.getDismissWithAnimation()) {
            return false;
        }
        dismissWithAnimation(behavior, z_renamed);
        return true;
    }

    private void dismissWithAnimation(com.google.android.material.bottomsheet.BottomSheetBehavior<?> bottomSheetBehavior, boolean z_renamed) {
        this.waitingForDismissAllowingStateLoss = z_renamed;
        if (bottomSheetBehavior.getState() == 5) {
            dismissAfterAnimation();
            return;
        }
        if (getDialog() instanceof com.google.android.material.bottomsheet.BottomSheetDialog) {
            ((com.google.android.material.bottomsheet.BottomSheetDialog) getDialog()).removeDefaultCallback();
        }
        bottomSheetBehavior.addBottomSheetCallback(new com.google.android.material.bottomsheet.BottomSheetDialogFragment.BottomSheetDismissCallback());
        bottomSheetBehavior.setState(5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissAfterAnimation() {
        if (this.waitingForDismissAllowingStateLoss) {
            super.dismissAllowingStateLoss();
        } else {
            super.dismiss();
        }
    }

    private class BottomSheetDismissCallback extends com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback {
        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onSlide(android.view.View view, float f_renamed) {
        }

        private BottomSheetDismissCallback() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onStateChanged(android.view.View view, int i_renamed) {
            if (i_renamed == 5) {
                com.google.android.material.bottomsheet.BottomSheetDialogFragment.this.dismissAfterAnimation();
            }
        }
    }
}
