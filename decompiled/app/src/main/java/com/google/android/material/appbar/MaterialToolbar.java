package com.google.android.material.appbar;

/* loaded from: classes.dex */
public class MaterialToolbar extends androidx.appcompat.widget.Toolbar {
    private static final int DEF_STYLE_RES = com.google.android.material.R_renamed.style.Widget_MaterialComponents_Toolbar;

    public MaterialToolbar(android.content.Context context) {
        this(context, null);
    }

    public MaterialToolbar(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, com.google.android.material.R_renamed.attr.toolbarStyle);
    }

    public MaterialToolbar(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(context, attributeSet, i_renamed, DEF_STYLE_RES), attributeSet, i_renamed);
        initBackground(getContext());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.google.android.material.shape.MaterialShapeUtils.setParentAbsoluteElevation(this);
    }

    @Override // android.view.View
    public void setElevation(float f_renamed) {
        super.setElevation(f_renamed);
        com.google.android.material.shape.MaterialShapeUtils.setElevation(this, f_renamed);
    }

    private void initBackground(android.content.Context context) {
        android.graphics.drawable.Drawable background = getBackground();
        if (background == null || (background instanceof android.graphics.drawable.ColorDrawable)) {
            com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable = new com.google.android.material.shape.MaterialShapeDrawable();
            materialShapeDrawable.setFillColor(android.content.res.ColorStateList.valueOf(background != null ? ((android.graphics.drawable.ColorDrawable) background).getColor() : 0));
            materialShapeDrawable.initializeElevationOverlay(context);
            materialShapeDrawable.setElevation(androidx.core.h_renamed.v_renamed.o_renamed(this));
            androidx.core.h_renamed.v_renamed.a_renamed(this, materialShapeDrawable);
        }
    }
}
