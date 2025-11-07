package com.google.android.material.textfield;

/* loaded from: classes.dex */
abstract class EndIconDelegate {
    android.content.Context context;
    com.google.android.material.internal.CheckableImageButton endIconView;
    com.google.android.material.textfield.TextInputLayout textInputLayout;

    abstract void initialize();

    boolean isBoxBackgroundModeSupported(int i_renamed) {
        return true;
    }

    void onSuffixVisibilityChanged(boolean z_renamed) {
    }

    boolean shouldTintIconOnError() {
        return false;
    }

    EndIconDelegate(com.google.android.material.textfield.TextInputLayout textInputLayout) {
        this.textInputLayout = textInputLayout;
        this.context = textInputLayout.getContext();
        this.endIconView = textInputLayout.getEndIconView();
    }
}
