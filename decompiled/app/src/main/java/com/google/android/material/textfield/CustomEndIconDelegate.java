package com.google.android.material.textfield;

/* loaded from: classes.dex */
class CustomEndIconDelegate extends com.google.android.material.textfield.EndIconDelegate {
    CustomEndIconDelegate(com.google.android.material.textfield.TextInputLayout textInputLayout) {
        super(textInputLayout);
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    void initialize() {
        this.textInputLayout.setEndIconOnClickListener(null);
        this.textInputLayout.setEndIconOnLongClickListener(null);
    }
}
