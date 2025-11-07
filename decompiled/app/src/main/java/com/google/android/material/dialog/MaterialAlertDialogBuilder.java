package com.google.android.material.dialog;

/* loaded from: classes.dex */
public class MaterialAlertDialogBuilder extends androidx.appcompat.app.b_renamed.a_renamed {
    private static final int DEF_STYLE_ATTR = com.google.android.material.R_renamed.attr.alertDialogStyle;
    private static final int DEF_STYLE_RES = com.google.android.material.R_renamed.style.MaterialAlertDialog_MaterialComponents;
    private static final int MATERIAL_ALERT_DIALOG_THEME_OVERLAY = com.google.android.material.R_renamed.attr.materialAlertDialogTheme;
    private android.graphics.drawable.Drawable background;
    private final android.graphics.Rect backgroundInsets;

    private static int getMaterialAlertDialogThemeOverlay(android.content.Context context) {
        android.util.TypedValue typedValueResolve = com.google.android.material.resources.MaterialAttributes.resolve(context, MATERIAL_ALERT_DIALOG_THEME_OVERLAY);
        if (typedValueResolve == null) {
            return 0;
        }
        return typedValueResolve.data;
    }

    private static android.content.Context createMaterialAlertDialogThemedContext(android.content.Context context) {
        int materialAlertDialogThemeOverlay = getMaterialAlertDialogThemeOverlay(context);
        android.content.Context contextWrap = com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(context, null, DEF_STYLE_ATTR, DEF_STYLE_RES);
        return materialAlertDialogThemeOverlay == 0 ? contextWrap : new androidx.appcompat.view.d_renamed(contextWrap, materialAlertDialogThemeOverlay);
    }

    private static int getOverridingThemeResId(android.content.Context context, int i_renamed) {
        return i_renamed == 0 ? getMaterialAlertDialogThemeOverlay(context) : i_renamed;
    }

    public MaterialAlertDialogBuilder(android.content.Context context) {
        this(context, 0);
    }

    public MaterialAlertDialogBuilder(android.content.Context context, int i_renamed) {
        super(createMaterialAlertDialogThemedContext(context), getOverridingThemeResId(context, i_renamed));
        android.content.Context context2 = getContext();
        android.content.res.Resources.Theme theme = context2.getTheme();
        this.backgroundInsets = com.google.android.material.dialog.MaterialDialogs.getDialogBackgroundInsets(context2, DEF_STYLE_ATTR, DEF_STYLE_RES);
        int color = com.google.android.material.color.MaterialColors.getColor(context2, com.google.android.material.R_renamed.attr.colorSurface, getClass().getCanonicalName());
        com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable = new com.google.android.material.shape.MaterialShapeDrawable(context2, null, DEF_STYLE_ATTR, DEF_STYLE_RES);
        materialShapeDrawable.initializeElevationOverlay(context2);
        materialShapeDrawable.setFillColor(android.content.res.ColorStateList.valueOf(color));
        if (android.os.Build.VERSION.SDK_INT >= 28) {
            android.util.TypedValue typedValue = new android.util.TypedValue();
            theme.resolveAttribute(android.R_renamed.attr.dialogCornerRadius, typedValue, true);
            float dimension = typedValue.getDimension(getContext().getResources().getDisplayMetrics());
            if (typedValue.type == 5 && dimension >= 0.0f) {
                materialShapeDrawable.setCornerSize(dimension);
            }
        }
        this.background = materialShapeDrawable;
    }

    @Override // androidx.appcompat.app.b_renamed.a_renamed
    public androidx.appcompat.app.b_renamed create() {
        androidx.appcompat.app.b_renamed bVarCreate = super.create();
        android.view.Window window = bVarCreate.getWindow();
        android.view.View decorView = window.getDecorView();
        android.graphics.drawable.Drawable drawable = this.background;
        if (drawable instanceof com.google.android.material.shape.MaterialShapeDrawable) {
            ((com.google.android.material.shape.MaterialShapeDrawable) drawable).setElevation(androidx.core.h_renamed.v_renamed.o_renamed(decorView));
        }
        window.setBackgroundDrawable(com.google.android.material.dialog.MaterialDialogs.insetDrawable(this.background, this.backgroundInsets));
        decorView.setOnTouchListener(new com.google.android.material.dialog.InsetDialogOnTouchListener(bVarCreate, this.backgroundInsets));
        return bVarCreate;
    }

    public android.graphics.drawable.Drawable getBackground() {
        return this.background;
    }

    public com.google.android.material.dialog.MaterialAlertDialogBuilder setBackground(android.graphics.drawable.Drawable drawable) {
        this.background = drawable;
        return this;
    }

    public com.google.android.material.dialog.MaterialAlertDialogBuilder setBackgroundInsetStart(int i_renamed) {
        if (android.os.Build.VERSION.SDK_INT >= 17 && getContext().getResources().getConfiguration().getLayoutDirection() == 1) {
            this.backgroundInsets.right = i_renamed;
        } else {
            this.backgroundInsets.left = i_renamed;
        }
        return this;
    }

    public com.google.android.material.dialog.MaterialAlertDialogBuilder setBackgroundInsetTop(int i_renamed) {
        this.backgroundInsets.top = i_renamed;
        return this;
    }

    public com.google.android.material.dialog.MaterialAlertDialogBuilder setBackgroundInsetEnd(int i_renamed) {
        if (android.os.Build.VERSION.SDK_INT >= 17 && getContext().getResources().getConfiguration().getLayoutDirection() == 1) {
            this.backgroundInsets.left = i_renamed;
        } else {
            this.backgroundInsets.right = i_renamed;
        }
        return this;
    }

    public com.google.android.material.dialog.MaterialAlertDialogBuilder setBackgroundInsetBottom(int i_renamed) {
        this.backgroundInsets.bottom = i_renamed;
        return this;
    }

    @Override // androidx.appcompat.app.b_renamed.a_renamed
    public com.google.android.material.dialog.MaterialAlertDialogBuilder setTitle(int i_renamed) {
        return (com.google.android.material.dialog.MaterialAlertDialogBuilder) super.setTitle(i_renamed);
    }

    @Override // androidx.appcompat.app.b_renamed.a_renamed
    public com.google.android.material.dialog.MaterialAlertDialogBuilder setTitle(java.lang.CharSequence charSequence) {
        return (com.google.android.material.dialog.MaterialAlertDialogBuilder) super.setTitle(charSequence);
    }

    @Override // androidx.appcompat.app.b_renamed.a_renamed
    public com.google.android.material.dialog.MaterialAlertDialogBuilder setCustomTitle(android.view.View view) {
        return (com.google.android.material.dialog.MaterialAlertDialogBuilder) super.setCustomTitle(view);
    }

    @Override // androidx.appcompat.app.b_renamed.a_renamed
    public com.google.android.material.dialog.MaterialAlertDialogBuilder setMessage(int i_renamed) {
        return (com.google.android.material.dialog.MaterialAlertDialogBuilder) super.setMessage(i_renamed);
    }

    @Override // androidx.appcompat.app.b_renamed.a_renamed
    public com.google.android.material.dialog.MaterialAlertDialogBuilder setMessage(java.lang.CharSequence charSequence) {
        return (com.google.android.material.dialog.MaterialAlertDialogBuilder) super.setMessage(charSequence);
    }

    @Override // androidx.appcompat.app.b_renamed.a_renamed
    public com.google.android.material.dialog.MaterialAlertDialogBuilder setIcon(int i_renamed) {
        return (com.google.android.material.dialog.MaterialAlertDialogBuilder) super.setIcon(i_renamed);
    }

    @Override // androidx.appcompat.app.b_renamed.a_renamed
    public com.google.android.material.dialog.MaterialAlertDialogBuilder setIcon(android.graphics.drawable.Drawable drawable) {
        return (com.google.android.material.dialog.MaterialAlertDialogBuilder) super.setIcon(drawable);
    }

    @Override // androidx.appcompat.app.b_renamed.a_renamed
    public com.google.android.material.dialog.MaterialAlertDialogBuilder setIconAttribute(int i_renamed) {
        return (com.google.android.material.dialog.MaterialAlertDialogBuilder) super.setIconAttribute(i_renamed);
    }

    @Override // androidx.appcompat.app.b_renamed.a_renamed
    public com.google.android.material.dialog.MaterialAlertDialogBuilder setPositiveButton(int i_renamed, android.content.DialogInterface.OnClickListener onClickListener) {
        return (com.google.android.material.dialog.MaterialAlertDialogBuilder) super.setPositiveButton(i_renamed, onClickListener);
    }

    @Override // androidx.appcompat.app.b_renamed.a_renamed
    public com.google.android.material.dialog.MaterialAlertDialogBuilder setPositiveButton(java.lang.CharSequence charSequence, android.content.DialogInterface.OnClickListener onClickListener) {
        return (com.google.android.material.dialog.MaterialAlertDialogBuilder) super.setPositiveButton(charSequence, onClickListener);
    }

    @Override // androidx.appcompat.app.b_renamed.a_renamed
    public com.google.android.material.dialog.MaterialAlertDialogBuilder setPositiveButtonIcon(android.graphics.drawable.Drawable drawable) {
        return (com.google.android.material.dialog.MaterialAlertDialogBuilder) super.setPositiveButtonIcon(drawable);
    }

    @Override // androidx.appcompat.app.b_renamed.a_renamed
    public com.google.android.material.dialog.MaterialAlertDialogBuilder setNegativeButton(int i_renamed, android.content.DialogInterface.OnClickListener onClickListener) {
        return (com.google.android.material.dialog.MaterialAlertDialogBuilder) super.setNegativeButton(i_renamed, onClickListener);
    }

    @Override // androidx.appcompat.app.b_renamed.a_renamed
    public com.google.android.material.dialog.MaterialAlertDialogBuilder setNegativeButton(java.lang.CharSequence charSequence, android.content.DialogInterface.OnClickListener onClickListener) {
        return (com.google.android.material.dialog.MaterialAlertDialogBuilder) super.setNegativeButton(charSequence, onClickListener);
    }

    @Override // androidx.appcompat.app.b_renamed.a_renamed
    public com.google.android.material.dialog.MaterialAlertDialogBuilder setNegativeButtonIcon(android.graphics.drawable.Drawable drawable) {
        return (com.google.android.material.dialog.MaterialAlertDialogBuilder) super.setNegativeButtonIcon(drawable);
    }

    @Override // androidx.appcompat.app.b_renamed.a_renamed
    public com.google.android.material.dialog.MaterialAlertDialogBuilder setNeutralButton(int i_renamed, android.content.DialogInterface.OnClickListener onClickListener) {
        return (com.google.android.material.dialog.MaterialAlertDialogBuilder) super.setNeutralButton(i_renamed, onClickListener);
    }

    @Override // androidx.appcompat.app.b_renamed.a_renamed
    public com.google.android.material.dialog.MaterialAlertDialogBuilder setNeutralButton(java.lang.CharSequence charSequence, android.content.DialogInterface.OnClickListener onClickListener) {
        return (com.google.android.material.dialog.MaterialAlertDialogBuilder) super.setNeutralButton(charSequence, onClickListener);
    }

    @Override // androidx.appcompat.app.b_renamed.a_renamed
    public com.google.android.material.dialog.MaterialAlertDialogBuilder setNeutralButtonIcon(android.graphics.drawable.Drawable drawable) {
        return (com.google.android.material.dialog.MaterialAlertDialogBuilder) super.setNeutralButtonIcon(drawable);
    }

    @Override // androidx.appcompat.app.b_renamed.a_renamed
    public com.google.android.material.dialog.MaterialAlertDialogBuilder setCancelable(boolean z_renamed) {
        return (com.google.android.material.dialog.MaterialAlertDialogBuilder) super.setCancelable(z_renamed);
    }

    @Override // androidx.appcompat.app.b_renamed.a_renamed
    public com.google.android.material.dialog.MaterialAlertDialogBuilder setOnCancelListener(android.content.DialogInterface.OnCancelListener onCancelListener) {
        return (com.google.android.material.dialog.MaterialAlertDialogBuilder) super.setOnCancelListener(onCancelListener);
    }

    @Override // androidx.appcompat.app.b_renamed.a_renamed
    public com.google.android.material.dialog.MaterialAlertDialogBuilder setOnDismissListener(android.content.DialogInterface.OnDismissListener onDismissListener) {
        return (com.google.android.material.dialog.MaterialAlertDialogBuilder) super.setOnDismissListener(onDismissListener);
    }

    @Override // androidx.appcompat.app.b_renamed.a_renamed
    public com.google.android.material.dialog.MaterialAlertDialogBuilder setOnKeyListener(android.content.DialogInterface.OnKeyListener onKeyListener) {
        return (com.google.android.material.dialog.MaterialAlertDialogBuilder) super.setOnKeyListener(onKeyListener);
    }

    @Override // androidx.appcompat.app.b_renamed.a_renamed
    public com.google.android.material.dialog.MaterialAlertDialogBuilder setItems(int i_renamed, android.content.DialogInterface.OnClickListener onClickListener) {
        return (com.google.android.material.dialog.MaterialAlertDialogBuilder) super.setItems(i_renamed, onClickListener);
    }

    @Override // androidx.appcompat.app.b_renamed.a_renamed
    public com.google.android.material.dialog.MaterialAlertDialogBuilder setItems(java.lang.CharSequence[] charSequenceArr, android.content.DialogInterface.OnClickListener onClickListener) {
        return (com.google.android.material.dialog.MaterialAlertDialogBuilder) super.setItems(charSequenceArr, onClickListener);
    }

    @Override // androidx.appcompat.app.b_renamed.a_renamed
    public com.google.android.material.dialog.MaterialAlertDialogBuilder setAdapter(android.widget.ListAdapter listAdapter, android.content.DialogInterface.OnClickListener onClickListener) {
        return (com.google.android.material.dialog.MaterialAlertDialogBuilder) super.setAdapter(listAdapter, onClickListener);
    }

    @Override // androidx.appcompat.app.b_renamed.a_renamed
    public com.google.android.material.dialog.MaterialAlertDialogBuilder setCursor(android.database.Cursor cursor, android.content.DialogInterface.OnClickListener onClickListener, java.lang.String str) {
        return (com.google.android.material.dialog.MaterialAlertDialogBuilder) super.setCursor(cursor, onClickListener, str);
    }

    @Override // androidx.appcompat.app.b_renamed.a_renamed
    public com.google.android.material.dialog.MaterialAlertDialogBuilder setMultiChoiceItems(int i_renamed, boolean[] zArr, android.content.DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
        return (com.google.android.material.dialog.MaterialAlertDialogBuilder) super.setMultiChoiceItems(i_renamed, zArr, onMultiChoiceClickListener);
    }

    @Override // androidx.appcompat.app.b_renamed.a_renamed
    public com.google.android.material.dialog.MaterialAlertDialogBuilder setMultiChoiceItems(java.lang.CharSequence[] charSequenceArr, boolean[] zArr, android.content.DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
        return (com.google.android.material.dialog.MaterialAlertDialogBuilder) super.setMultiChoiceItems(charSequenceArr, zArr, onMultiChoiceClickListener);
    }

    @Override // androidx.appcompat.app.b_renamed.a_renamed
    public com.google.android.material.dialog.MaterialAlertDialogBuilder setMultiChoiceItems(android.database.Cursor cursor, java.lang.String str, java.lang.String str2, android.content.DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
        return (com.google.android.material.dialog.MaterialAlertDialogBuilder) super.setMultiChoiceItems(cursor, str, str2, onMultiChoiceClickListener);
    }

    @Override // androidx.appcompat.app.b_renamed.a_renamed
    public com.google.android.material.dialog.MaterialAlertDialogBuilder setSingleChoiceItems(int i_renamed, int i2, android.content.DialogInterface.OnClickListener onClickListener) {
        return (com.google.android.material.dialog.MaterialAlertDialogBuilder) super.setSingleChoiceItems(i_renamed, i2, onClickListener);
    }

    @Override // androidx.appcompat.app.b_renamed.a_renamed
    public com.google.android.material.dialog.MaterialAlertDialogBuilder setSingleChoiceItems(android.database.Cursor cursor, int i_renamed, java.lang.String str, android.content.DialogInterface.OnClickListener onClickListener) {
        return (com.google.android.material.dialog.MaterialAlertDialogBuilder) super.setSingleChoiceItems(cursor, i_renamed, str, onClickListener);
    }

    @Override // androidx.appcompat.app.b_renamed.a_renamed
    public com.google.android.material.dialog.MaterialAlertDialogBuilder setSingleChoiceItems(java.lang.CharSequence[] charSequenceArr, int i_renamed, android.content.DialogInterface.OnClickListener onClickListener) {
        return (com.google.android.material.dialog.MaterialAlertDialogBuilder) super.setSingleChoiceItems(charSequenceArr, i_renamed, onClickListener);
    }

    @Override // androidx.appcompat.app.b_renamed.a_renamed
    public com.google.android.material.dialog.MaterialAlertDialogBuilder setSingleChoiceItems(android.widget.ListAdapter listAdapter, int i_renamed, android.content.DialogInterface.OnClickListener onClickListener) {
        return (com.google.android.material.dialog.MaterialAlertDialogBuilder) super.setSingleChoiceItems(listAdapter, i_renamed, onClickListener);
    }

    @Override // androidx.appcompat.app.b_renamed.a_renamed
    public com.google.android.material.dialog.MaterialAlertDialogBuilder setOnItemSelectedListener(android.widget.AdapterView.OnItemSelectedListener onItemSelectedListener) {
        return (com.google.android.material.dialog.MaterialAlertDialogBuilder) super.setOnItemSelectedListener(onItemSelectedListener);
    }

    @Override // androidx.appcompat.app.b_renamed.a_renamed
    public com.google.android.material.dialog.MaterialAlertDialogBuilder setView(int i_renamed) {
        return (com.google.android.material.dialog.MaterialAlertDialogBuilder) super.setView(i_renamed);
    }

    @Override // androidx.appcompat.app.b_renamed.a_renamed
    public com.google.android.material.dialog.MaterialAlertDialogBuilder setView(android.view.View view) {
        return (com.google.android.material.dialog.MaterialAlertDialogBuilder) super.setView(view);
    }
}
