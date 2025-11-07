package com.google.android.material.theme;

/* loaded from: classes.dex */
public class MaterialComponentsViewInflater extends androidx.appcompat.app.AppCompatViewInflater {
    private static int floatingToolbarItemBackgroundResId = -1;

    @Override // androidx.appcompat.app.AppCompatViewInflater
    protected androidx.appcompat.widget.f_renamed createButton(android.content.Context context, android.util.AttributeSet attributeSet) {
        if (shouldInflateAppCompatButton(context, attributeSet)) {
            return new androidx.appcompat.widget.f_renamed(context, attributeSet);
        }
        return new com.google.android.material.button.MaterialButton(context, attributeSet);
    }

    protected boolean shouldInflateAppCompatButton(android.content.Context context, android.util.AttributeSet attributeSet) {
        if (android.os.Build.VERSION.SDK_INT != 23 && android.os.Build.VERSION.SDK_INT != 24 && android.os.Build.VERSION.SDK_INT != 25) {
            return false;
        }
        if (floatingToolbarItemBackgroundResId == -1) {
            floatingToolbarItemBackgroundResId = context.getResources().getIdentifier("floatingToolbarItemBackgroundDrawable", "^attr-private", "android");
        }
        int i_renamed = floatingToolbarItemBackgroundResId;
        if (i_renamed != 0 && i_renamed != -1) {
            for (int i2 = 0; i2 < attributeSet.getAttributeCount(); i2++) {
                if (attributeSet.getAttributeNameResource(i2) == 16842964) {
                    if (floatingToolbarItemBackgroundResId == attributeSet.getAttributeListValue(i2, null, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // androidx.appcompat.app.AppCompatViewInflater
    protected androidx.appcompat.widget.AppCompatCheckBox createCheckBox(android.content.Context context, android.util.AttributeSet attributeSet) {
        return new com.google.android.material.checkbox.MaterialCheckBox(context, attributeSet);
    }

    @Override // androidx.appcompat.app.AppCompatViewInflater
    protected androidx.appcompat.widget.q_renamed createRadioButton(android.content.Context context, android.util.AttributeSet attributeSet) {
        return new com.google.android.material.radiobutton.MaterialRadioButton(context, attributeSet);
    }

    @Override // androidx.appcompat.app.AppCompatViewInflater
    protected androidx.appcompat.widget.AppCompatTextView createTextView(android.content.Context context, android.util.AttributeSet attributeSet) {
        return new com.google.android.material.textview.MaterialTextView(context, attributeSet);
    }

    @Override // androidx.appcompat.app.AppCompatViewInflater
    protected androidx.appcompat.widget.d_renamed createAutoCompleteTextView(android.content.Context context, android.util.AttributeSet attributeSet) {
        return new com.google.android.material.textfield.MaterialAutoCompleteTextView(context, attributeSet);
    }
}
