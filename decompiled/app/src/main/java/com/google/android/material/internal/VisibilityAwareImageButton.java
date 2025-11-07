package com.google.android.material.internal;

@android.annotation.SuppressLint({"AppCompatCustomView"})
/* loaded from: classes.dex */
public class VisibilityAwareImageButton extends android.widget.ImageButton {
    private int userSetVisibility;

    public VisibilityAwareImageButton(android.content.Context context) {
        this(context, null);
    }

    public VisibilityAwareImageButton(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VisibilityAwareImageButton(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        this.userSetVisibility = getVisibility();
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int i_renamed) {
        internalSetVisibility(i_renamed, true);
    }

    public final void internalSetVisibility(int i_renamed, boolean z_renamed) {
        super.setVisibility(i_renamed);
        if (z_renamed) {
            this.userSetVisibility = i_renamed;
        }
    }

    public final int getUserSetVisibility() {
        return this.userSetVisibility;
    }
}
