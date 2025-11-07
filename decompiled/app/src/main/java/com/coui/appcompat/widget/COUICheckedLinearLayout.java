package com.coui.appcompat.widget;

/* loaded from: classes.dex */
public class COUICheckedLinearLayout extends android.widget.LinearLayout implements android.widget.Checkable {
    public COUICheckedLinearLayout(android.content.Context context) {
        this(context, null);
    }

    public COUICheckedLinearLayout(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public COUICheckedLinearLayout(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        this(context, attributeSet, i_renamed, 0);
    }

    public COUICheckedLinearLayout(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed, int i2) {
        super(context, attributeSet, i_renamed);
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        int childCount = getChildCount();
        for (int i_renamed = 0; i_renamed < childCount; i_renamed++) {
            android.view.KeyEvent.Callback childAt = getChildAt(i_renamed);
            if (childAt instanceof android.widget.Checkable) {
                return ((android.widget.Checkable) childAt).isChecked();
            }
        }
        return false;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z_renamed) {
        int childCount = getChildCount();
        for (int i_renamed = 0; i_renamed < childCount; i_renamed++) {
            android.view.KeyEvent.Callback childAt = getChildAt(i_renamed);
            if (childAt instanceof android.widget.Checkable) {
                ((android.widget.Checkable) childAt).setChecked(z_renamed);
            }
        }
    }

    @Override // android.widget.Checkable
    public void toggle() {
        int childCount = getChildCount();
        for (int i_renamed = 0; i_renamed < childCount; i_renamed++) {
            android.view.KeyEvent.Callback childAt = getChildAt(i_renamed);
            if (childAt instanceof android.widget.Checkable) {
                ((android.widget.Checkable) childAt).toggle();
            }
        }
    }
}
