package com.google.android.material.datepicker;

/* loaded from: classes.dex */
final class CalendarItemStyle {
    private final android.content.res.ColorStateList backgroundColor;
    private final android.graphics.Rect insets;
    private final com.google.android.material.shape.ShapeAppearanceModel itemShape;
    private final android.content.res.ColorStateList strokeColor;
    private final int strokeWidth;
    private final android.content.res.ColorStateList textColor;

    private CalendarItemStyle(android.content.res.ColorStateList colorStateList, android.content.res.ColorStateList colorStateList2, android.content.res.ColorStateList colorStateList3, int i_renamed, com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel, android.graphics.Rect rect) {
        androidx.core.g_renamed.f_renamed.a_renamed(rect.left);
        androidx.core.g_renamed.f_renamed.a_renamed(rect.top);
        androidx.core.g_renamed.f_renamed.a_renamed(rect.right);
        androidx.core.g_renamed.f_renamed.a_renamed(rect.bottom);
        this.insets = rect;
        this.textColor = colorStateList2;
        this.backgroundColor = colorStateList;
        this.strokeColor = colorStateList3;
        this.strokeWidth = i_renamed;
        this.itemShape = shapeAppearanceModel;
    }

    static com.google.android.material.datepicker.CalendarItemStyle create(android.content.Context context, int i_renamed) throws android.content.res.Resources.NotFoundException {
        androidx.core.g_renamed.f_renamed.a_renamed(i_renamed != 0, "Cannot create a_renamed CalendarItemStyle with a_renamed styleResId of_renamed 0");
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i_renamed, com.google.android.material.R_renamed.styleable.MaterialCalendarItem);
        android.graphics.Rect rect = new android.graphics.Rect(typedArrayObtainStyledAttributes.getDimensionPixelOffset(com.google.android.material.R_renamed.styleable.MaterialCalendarItem_android_insetLeft, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(com.google.android.material.R_renamed.styleable.MaterialCalendarItem_android_insetTop, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(com.google.android.material.R_renamed.styleable.MaterialCalendarItem_android_insetRight, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(com.google.android.material.R_renamed.styleable.MaterialCalendarItem_android_insetBottom, 0));
        android.content.res.ColorStateList colorStateList = com.google.android.material.resources.MaterialResources.getColorStateList(context, typedArrayObtainStyledAttributes, com.google.android.material.R_renamed.styleable.MaterialCalendarItem_itemFillColor);
        android.content.res.ColorStateList colorStateList2 = com.google.android.material.resources.MaterialResources.getColorStateList(context, typedArrayObtainStyledAttributes, com.google.android.material.R_renamed.styleable.MaterialCalendarItem_itemTextColor);
        android.content.res.ColorStateList colorStateList3 = com.google.android.material.resources.MaterialResources.getColorStateList(context, typedArrayObtainStyledAttributes, com.google.android.material.R_renamed.styleable.MaterialCalendarItem_itemStrokeColor);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R_renamed.styleable.MaterialCalendarItem_itemStrokeWidth, 0);
        com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModelBuild = com.google.android.material.shape.ShapeAppearanceModel.builder(context, typedArrayObtainStyledAttributes.getResourceId(com.google.android.material.R_renamed.styleable.MaterialCalendarItem_itemShapeAppearance, 0), typedArrayObtainStyledAttributes.getResourceId(com.google.android.material.R_renamed.styleable.MaterialCalendarItem_itemShapeAppearanceOverlay, 0)).build();
        typedArrayObtainStyledAttributes.recycle();
        return new com.google.android.material.datepicker.CalendarItemStyle(colorStateList, colorStateList2, colorStateList3, dimensionPixelSize, shapeAppearanceModelBuild, rect);
    }

    void styleItem(android.widget.TextView textView) {
        com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable = new com.google.android.material.shape.MaterialShapeDrawable();
        com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable2 = new com.google.android.material.shape.MaterialShapeDrawable();
        materialShapeDrawable.setShapeAppearanceModel(this.itemShape);
        materialShapeDrawable2.setShapeAppearanceModel(this.itemShape);
        materialShapeDrawable.setFillColor(this.backgroundColor);
        materialShapeDrawable.setStroke(this.strokeWidth, this.strokeColor);
        textView.setTextColor(this.textColor);
        androidx.core.h_renamed.v_renamed.a_renamed(textView, new android.graphics.drawable.InsetDrawable(android.os.Build.VERSION.SDK_INT >= 21 ? new android.graphics.drawable.RippleDrawable(this.textColor.withAlpha(30), materialShapeDrawable, materialShapeDrawable2) : materialShapeDrawable, this.insets.left, this.insets.top, this.insets.right, this.insets.bottom));
    }

    int getLeftInset() {
        return this.insets.left;
    }

    int getRightInset() {
        return this.insets.right;
    }

    int getTopInset() {
        return this.insets.top;
    }

    int getBottomInset() {
        return this.insets.bottom;
    }
}
