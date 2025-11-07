package com.google.android.material.datepicker;

/* loaded from: classes.dex */
public class MaterialStyledDatePickerDialog extends android.app.DatePickerDialog {
    private static final int DEF_STYLE_ATTR = 16843612;
    private static final int DEF_STYLE_RES = com.google.android.material.R_renamed.style.MaterialAlertDialog_MaterialComponents_Picker_Date_Spinner;
    private final android.graphics.drawable.Drawable background;
    private final android.graphics.Rect backgroundInsets;

    public MaterialStyledDatePickerDialog(android.content.Context context) {
        this(context, 0);
    }

    public MaterialStyledDatePickerDialog(android.content.Context context, int i_renamed) {
        this(context, i_renamed, null, -1, -1, -1);
    }

    public MaterialStyledDatePickerDialog(android.content.Context context, android.app.DatePickerDialog.OnDateSetListener onDateSetListener, int i_renamed, int i2, int i3) {
        this(context, 0, onDateSetListener, i_renamed, i2, i3);
    }

    public MaterialStyledDatePickerDialog(android.content.Context context, int i_renamed, android.app.DatePickerDialog.OnDateSetListener onDateSetListener, int i2, int i3, int i4) {
        super(context, i_renamed, onDateSetListener, i2, i3, i4);
        android.content.Context context2 = getContext();
        int iResolveOrThrow = com.google.android.material.resources.MaterialAttributes.resolveOrThrow(getContext(), com.google.android.material.R_renamed.attr.colorSurface, getClass().getCanonicalName());
        com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable = new com.google.android.material.shape.MaterialShapeDrawable(context2, null, 16843612, DEF_STYLE_RES);
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            materialShapeDrawable.setFillColor(android.content.res.ColorStateList.valueOf(iResolveOrThrow));
        } else {
            materialShapeDrawable.setFillColor(android.content.res.ColorStateList.valueOf(0));
        }
        this.backgroundInsets = com.google.android.material.dialog.MaterialDialogs.getDialogBackgroundInsets(context2, 16843612, DEF_STYLE_RES);
        this.background = com.google.android.material.dialog.MaterialDialogs.insetDrawable(materialShapeDrawable, this.backgroundInsets);
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setBackgroundDrawable(this.background);
        getWindow().getDecorView().setOnTouchListener(new com.google.android.material.dialog.InsetDialogOnTouchListener(this, this.backgroundInsets));
    }
}
