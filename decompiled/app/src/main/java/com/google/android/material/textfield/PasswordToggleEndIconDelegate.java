package com.google.android.material.textfield;

/* loaded from: classes.dex */
class PasswordToggleEndIconDelegate extends com.google.android.material.textfield.EndIconDelegate {
    private final com.google.android.material.textfield.TextInputLayout.OnEditTextAttachedListener onEditTextAttachedListener;
    private final com.google.android.material.textfield.TextInputLayout.OnEndIconChangedListener onEndIconChangedListener;
    private final android.text.TextWatcher textWatcher;

    PasswordToggleEndIconDelegate(com.google.android.material.textfield.TextInputLayout textInputLayout) {
        super(textInputLayout);
        this.textWatcher = new android.text.TextWatcher() { // from class: com.google.android.material.textfield.PasswordToggleEndIconDelegate.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(android.text.Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(java.lang.CharSequence charSequence, int i_renamed, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(java.lang.CharSequence charSequence, int i_renamed, int i2, int i3) {
                com.google.android.material.textfield.PasswordToggleEndIconDelegate.this.endIconView.setChecked(!com.google.android.material.textfield.PasswordToggleEndIconDelegate.this.hasPasswordTransformation());
            }
        };
        this.onEditTextAttachedListener = new com.google.android.material.textfield.TextInputLayout.OnEditTextAttachedListener() { // from class: com.google.android.material.textfield.PasswordToggleEndIconDelegate.2
            @Override // com.google.android.material.textfield.TextInputLayout.OnEditTextAttachedListener
            public void onEditTextAttached(com.google.android.material.textfield.TextInputLayout textInputLayout2) {
                android.widget.EditText editText = textInputLayout2.getEditText();
                textInputLayout2.setEndIconVisible(true);
                com.google.android.material.textfield.PasswordToggleEndIconDelegate.this.endIconView.setChecked(true ^ com.google.android.material.textfield.PasswordToggleEndIconDelegate.this.hasPasswordTransformation());
                editText.removeTextChangedListener(com.google.android.material.textfield.PasswordToggleEndIconDelegate.this.textWatcher);
                editText.addTextChangedListener(com.google.android.material.textfield.PasswordToggleEndIconDelegate.this.textWatcher);
            }
        };
        this.onEndIconChangedListener = new com.google.android.material.textfield.TextInputLayout.OnEndIconChangedListener() { // from class: com.google.android.material.textfield.PasswordToggleEndIconDelegate.3
            @Override // com.google.android.material.textfield.TextInputLayout.OnEndIconChangedListener
            public void onEndIconChanged(com.google.android.material.textfield.TextInputLayout textInputLayout2, int i_renamed) {
                android.widget.EditText editText = textInputLayout2.getEditText();
                if (editText == null || i_renamed != 1) {
                    return;
                }
                editText.setTransformationMethod(android.text.method.PasswordTransformationMethod.getInstance());
            }
        };
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    void initialize() {
        this.textInputLayout.setEndIconDrawable(androidx.appcompat.a_renamed.a_renamed.a_renamed.b_renamed(this.context, com.google.android.material.R_renamed.drawable.design_password_eye));
        this.textInputLayout.setEndIconContentDescription(this.textInputLayout.getResources().getText(com.google.android.material.R_renamed.string.password_toggle_content_description));
        this.textInputLayout.setEndIconOnClickListener(new android.view.View.OnClickListener() { // from class: com.google.android.material.textfield.PasswordToggleEndIconDelegate.4
            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view) {
                android.widget.EditText editText = com.google.android.material.textfield.PasswordToggleEndIconDelegate.this.textInputLayout.getEditText();
                if (editText == null) {
                    return;
                }
                int selectionEnd = editText.getSelectionEnd();
                if (com.google.android.material.textfield.PasswordToggleEndIconDelegate.this.hasPasswordTransformation()) {
                    editText.setTransformationMethod(null);
                } else {
                    editText.setTransformationMethod(android.text.method.PasswordTransformationMethod.getInstance());
                }
                if (selectionEnd >= 0) {
                    editText.setSelection(selectionEnd);
                }
            }
        });
        this.textInputLayout.addOnEditTextAttachedListener(this.onEditTextAttachedListener);
        this.textInputLayout.addOnEndIconChangedListener(this.onEndIconChangedListener);
        android.widget.EditText editText = this.textInputLayout.getEditText();
        if (isInputTypePassword(editText)) {
            editText.setTransformationMethod(android.text.method.PasswordTransformationMethod.getInstance());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hasPasswordTransformation() {
        android.widget.EditText editText = this.textInputLayout.getEditText();
        return editText != null && (editText.getTransformationMethod() instanceof android.text.method.PasswordTransformationMethod);
    }

    private static boolean isInputTypePassword(android.widget.EditText editText) {
        return editText != null && (editText.getInputType() == 16 || editText.getInputType() == 128 || editText.getInputType() == 144 || editText.getInputType() == 224);
    }
}
