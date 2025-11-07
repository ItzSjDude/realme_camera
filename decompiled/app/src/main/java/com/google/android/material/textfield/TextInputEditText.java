package com.google.android.material.textfield;

/* loaded from: classes.dex */
public class TextInputEditText extends androidx.appcompat.widget.j_renamed {
    private final android.graphics.Rect parentRect;
    private boolean textInputLayoutFocusedRectEnabled;

    public TextInputEditText(android.content.Context context) {
        this(context, null);
    }

    public TextInputEditText(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, com.google.android.material.R_renamed.attr.editTextStyle);
    }

    public TextInputEditText(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(context, attributeSet, i_renamed, 0), attributeSet, i_renamed);
        this.parentRect = new android.graphics.Rect();
        android.content.res.TypedArray typedArrayObtainStyledAttributes = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(context, attributeSet, com.google.android.material.R_renamed.styleable.TextInputEditText, i_renamed, com.google.android.material.R_renamed.style.Widget_Design_TextInputEditText, new int[0]);
        setTextInputLayoutFocusedRectEnabled(typedArrayObtainStyledAttributes.getBoolean(com.google.android.material.R_renamed.styleable.TextInputEditText_textInputLayoutFocusedRectEnabled, false));
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.google.android.material.textfield.TextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout != null && textInputLayout.isProvidingHint() && super.getHint() == null && com.google.android.material.internal.ManufacturerUtils.isMeizuDevice()) {
            setHint("");
        }
    }

    @Override // android.widget.TextView
    public java.lang.CharSequence getHint() {
        com.google.android.material.textfield.TextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout != null && textInputLayout.isProvidingHint()) {
            return textInputLayout.getHint();
        }
        return super.getHint();
    }

    @Override // androidx.appcompat.widget.j_renamed, android.widget.TextView, android.view.View
    public android.view.inputmethod.InputConnection onCreateInputConnection(android.view.inputmethod.EditorInfo editorInfo) {
        android.view.inputmethod.InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        if (inputConnectionOnCreateInputConnection != null && editorInfo.hintText == null) {
            editorInfo.hintText = getHintFromLayout();
        }
        return inputConnectionOnCreateInputConnection;
    }

    private com.google.android.material.textfield.TextInputLayout getTextInputLayout() {
        for (android.view.ViewParent parent = getParent(); parent instanceof android.view.View; parent = parent.getParent()) {
            if (parent instanceof com.google.android.material.textfield.TextInputLayout) {
                return (com.google.android.material.textfield.TextInputLayout) parent;
            }
        }
        return null;
    }

    private java.lang.CharSequence getHintFromLayout() {
        com.google.android.material.textfield.TextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout != null) {
            return textInputLayout.getHint();
        }
        return null;
    }

    public void setTextInputLayoutFocusedRectEnabled(boolean z_renamed) {
        this.textInputLayoutFocusedRectEnabled = z_renamed;
    }

    public boolean isTextInputLayoutFocusedRectEnabled() {
        return this.textInputLayoutFocusedRectEnabled;
    }

    @Override // android.widget.TextView, android.view.View
    public void getFocusedRect(android.graphics.Rect rect) {
        super.getFocusedRect(rect);
        com.google.android.material.textfield.TextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout == null || !this.textInputLayoutFocusedRectEnabled || rect == null) {
            return;
        }
        textInputLayout.getFocusedRect(this.parentRect);
        rect.bottom = this.parentRect.bottom;
    }

    @Override // android.view.View
    public boolean getGlobalVisibleRect(android.graphics.Rect rect, android.graphics.Point point) {
        boolean globalVisibleRect = super.getGlobalVisibleRect(rect, point);
        com.google.android.material.textfield.TextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout != null && this.textInputLayoutFocusedRectEnabled && rect != null) {
            textInputLayout.getGlobalVisibleRect(this.parentRect, point);
            rect.bottom = this.parentRect.bottom;
        }
        return globalVisibleRect;
    }

    @Override // android.view.View
    public boolean requestRectangleOnScreen(android.graphics.Rect rect) {
        boolean zRequestRectangleOnScreen = super.requestRectangleOnScreen(rect);
        com.google.android.material.textfield.TextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout != null && this.textInputLayoutFocusedRectEnabled) {
            this.parentRect.set(0, textInputLayout.getHeight() - getResources().getDimensionPixelOffset(com.google.android.material.R_renamed.dimen.mtrl_edittext_rectangle_top_offset), textInputLayout.getWidth(), textInputLayout.getHeight());
            textInputLayout.requestRectangleOnScreen(this.parentRect, true);
        }
        return zRequestRectangleOnScreen;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        com.google.android.material.textfield.TextInputLayout textInputLayout = getTextInputLayout();
        if (android.os.Build.VERSION.SDK_INT >= 23 || textInputLayout == null) {
            return;
        }
        accessibilityNodeInfo.setText(getAccessibilityNodeInfoText(textInputLayout));
    }

    private java.lang.String getAccessibilityNodeInfoText(com.google.android.material.textfield.TextInputLayout textInputLayout) {
        android.text.Editable text = getText();
        java.lang.CharSequence hint = textInputLayout.getHint();
        java.lang.CharSequence helperText = textInputLayout.getHelperText();
        java.lang.String error = textInputLayout.getError();
        boolean z_renamed = !android.text.TextUtils.isEmpty(text);
        boolean z2 = !android.text.TextUtils.isEmpty(hint);
        boolean z3 = !android.text.TextUtils.isEmpty(helperText);
        boolean z4 = !android.text.TextUtils.isEmpty(error);
        java.lang.String str = "";
        java.lang.String string = z2 ? hint.toString() : "";
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(string);
        sb.append(((z4 || z3) && !android.text.TextUtils.isEmpty(string)) ? ", " : "");
        java.lang.String string2 = sb.toString();
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        sb2.append(string2);
        if (!z4) {
            error = z3 ? helperText : "";
        }
        sb2.append((java.lang.Object) error);
        java.lang.String string3 = sb2.toString();
        if (!z_renamed) {
            return !android.text.TextUtils.isEmpty(string3) ? string3 : "";
        }
        java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
        sb3.append((java.lang.Object) text);
        if (!android.text.TextUtils.isEmpty(string3)) {
            str = ", " + string3;
        }
        sb3.append(str);
        return sb3.toString();
    }
}
