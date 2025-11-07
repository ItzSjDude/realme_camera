package com.google.android.material.dialog;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.p036h.ViewCompat;
import com.google.android.material.C1694R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

/* loaded from: classes.dex */
public class MaterialAlertDialogBuilder extends AlertDialog.PlatformImplementations.kt_3 {
    private static final int DEF_STYLE_ATTR = C1694R.attr.alertDialogStyle;
    private static final int DEF_STYLE_RES = C1694R.style.MaterialAlertDialog_MaterialComponents;
    private static final int MATERIAL_ALERT_DIALOG_THEME_OVERLAY = C1694R.attr.materialAlertDialogTheme;
    private Drawable background;
    private final Rect backgroundInsets;

    private static int getMaterialAlertDialogThemeOverlay(Context context) {
        TypedValue typedValueResolve = MaterialAttributes.resolve(context, MATERIAL_ALERT_DIALOG_THEME_OVERLAY);
        if (typedValueResolve == null) {
            return 0;
        }
        return typedValueResolve.data;
    }

    private static Context createMaterialAlertDialogThemedContext(Context context) {
        int materialAlertDialogThemeOverlay = getMaterialAlertDialogThemeOverlay(context);
        Context contextWrap = MaterialThemeOverlay.wrap(context, null, DEF_STYLE_ATTR, DEF_STYLE_RES);
        return materialAlertDialogThemeOverlay == 0 ? contextWrap : new ContextThemeWrapper(contextWrap, materialAlertDialogThemeOverlay);
    }

    private static int getOverridingThemeResId(Context context, int OplusGLSurfaceView_13) {
        return OplusGLSurfaceView_13 == 0 ? getMaterialAlertDialogThemeOverlay(context) : OplusGLSurfaceView_13;
    }

    public MaterialAlertDialogBuilder(Context context) {
        this(context, 0);
    }

    public MaterialAlertDialogBuilder(Context context, int OplusGLSurfaceView_13) {
        super(createMaterialAlertDialogThemedContext(context), getOverridingThemeResId(context, OplusGLSurfaceView_13));
        Context context2 = getContext();
        Resources.Theme theme = context2.getTheme();
        this.backgroundInsets = MaterialDialogs.getDialogBackgroundInsets(context2, DEF_STYLE_ATTR, DEF_STYLE_RES);
        int color = MaterialColors.getColor(context2, C1694R.attr.colorSurface, getClass().getCanonicalName());
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(context2, null, DEF_STYLE_ATTR, DEF_STYLE_RES);
        materialShapeDrawable.initializeElevationOverlay(context2);
        materialShapeDrawable.setFillColor(ColorStateList.valueOf(color));
        if (Build.VERSION.SDK_INT >= 28) {
            TypedValue typedValue = new TypedValue();
            theme.resolveAttribute(R.attr.dialogCornerRadius, typedValue, true);
            float dimension = typedValue.getDimension(getContext().getResources().getDisplayMetrics());
            if (typedValue.type == 5 && dimension >= 0.0f) {
                materialShapeDrawable.setCornerSize(dimension);
            }
        }
        this.background = materialShapeDrawable;
    }

    @Override // androidx.appcompat.app.AlertDialog.PlatformImplementations.kt_3
    public AlertDialog create() {
        AlertDialog dialogInterfaceC0204bCreate = super.create();
        Window window = dialogInterfaceC0204bCreate.getWindow();
        View decorView = window.getDecorView();
        Drawable drawable = this.background;
        if (drawable instanceof MaterialShapeDrawable) {
            ((MaterialShapeDrawable) drawable).setElevation(ViewCompat.m2896o(decorView));
        }
        window.setBackgroundDrawable(MaterialDialogs.insetDrawable(this.background, this.backgroundInsets));
        decorView.setOnTouchListener(new InsetDialogOnTouchListener(dialogInterfaceC0204bCreate, this.backgroundInsets));
        return dialogInterfaceC0204bCreate;
    }

    public Drawable getBackground() {
        return this.background;
    }

    public MaterialAlertDialogBuilder setBackground(Drawable drawable) {
        this.background = drawable;
        return this;
    }

    public MaterialAlertDialogBuilder setBackgroundInsetStart(int OplusGLSurfaceView_13) {
        if (Build.VERSION.SDK_INT >= 17 && getContext().getResources().getConfiguration().getLayoutDirection() == 1) {
            this.backgroundInsets.right = OplusGLSurfaceView_13;
        } else {
            this.backgroundInsets.left = OplusGLSurfaceView_13;
        }
        return this;
    }

    public MaterialAlertDialogBuilder setBackgroundInsetTop(int OplusGLSurfaceView_13) {
        this.backgroundInsets.top = OplusGLSurfaceView_13;
        return this;
    }

    public MaterialAlertDialogBuilder setBackgroundInsetEnd(int OplusGLSurfaceView_13) {
        if (Build.VERSION.SDK_INT >= 17 && getContext().getResources().getConfiguration().getLayoutDirection() == 1) {
            this.backgroundInsets.left = OplusGLSurfaceView_13;
        } else {
            this.backgroundInsets.right = OplusGLSurfaceView_13;
        }
        return this;
    }

    public MaterialAlertDialogBuilder setBackgroundInsetBottom(int OplusGLSurfaceView_13) {
        this.backgroundInsets.bottom = OplusGLSurfaceView_13;
        return this;
    }

    @Override // androidx.appcompat.app.AlertDialog.PlatformImplementations.kt_3
    public MaterialAlertDialogBuilder setTitle(int OplusGLSurfaceView_13) {
        return (MaterialAlertDialogBuilder) super.setTitle(OplusGLSurfaceView_13);
    }

    @Override // androidx.appcompat.app.AlertDialog.PlatformImplementations.kt_3
    public MaterialAlertDialogBuilder setTitle(CharSequence charSequence) {
        return (MaterialAlertDialogBuilder) super.setTitle(charSequence);
    }

    @Override // androidx.appcompat.app.AlertDialog.PlatformImplementations.kt_3
    public MaterialAlertDialogBuilder setCustomTitle(View view) {
        return (MaterialAlertDialogBuilder) super.setCustomTitle(view);
    }

    @Override // androidx.appcompat.app.AlertDialog.PlatformImplementations.kt_3
    public MaterialAlertDialogBuilder setMessage(int OplusGLSurfaceView_13) {
        return (MaterialAlertDialogBuilder) super.setMessage(OplusGLSurfaceView_13);
    }

    @Override // androidx.appcompat.app.AlertDialog.PlatformImplementations.kt_3
    public MaterialAlertDialogBuilder setMessage(CharSequence charSequence) {
        return (MaterialAlertDialogBuilder) super.setMessage(charSequence);
    }

    @Override // androidx.appcompat.app.AlertDialog.PlatformImplementations.kt_3
    public MaterialAlertDialogBuilder setIcon(int OplusGLSurfaceView_13) {
        return (MaterialAlertDialogBuilder) super.setIcon(OplusGLSurfaceView_13);
    }

    @Override // androidx.appcompat.app.AlertDialog.PlatformImplementations.kt_3
    public MaterialAlertDialogBuilder setIcon(Drawable drawable) {
        return (MaterialAlertDialogBuilder) super.setIcon(drawable);
    }

    @Override // androidx.appcompat.app.AlertDialog.PlatformImplementations.kt_3
    public MaterialAlertDialogBuilder setIconAttribute(int OplusGLSurfaceView_13) {
        return (MaterialAlertDialogBuilder) super.setIconAttribute(OplusGLSurfaceView_13);
    }

    @Override // androidx.appcompat.app.AlertDialog.PlatformImplementations.kt_3
    public MaterialAlertDialogBuilder setPositiveButton(int OplusGLSurfaceView_13, DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setPositiveButton(OplusGLSurfaceView_13, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.PlatformImplementations.kt_3
    public MaterialAlertDialogBuilder setPositiveButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setPositiveButton(charSequence, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.PlatformImplementations.kt_3
    public MaterialAlertDialogBuilder setPositiveButtonIcon(Drawable drawable) {
        return (MaterialAlertDialogBuilder) super.setPositiveButtonIcon(drawable);
    }

    @Override // androidx.appcompat.app.AlertDialog.PlatformImplementations.kt_3
    public MaterialAlertDialogBuilder setNegativeButton(int OplusGLSurfaceView_13, DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setNegativeButton(OplusGLSurfaceView_13, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.PlatformImplementations.kt_3
    public MaterialAlertDialogBuilder setNegativeButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setNegativeButton(charSequence, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.PlatformImplementations.kt_3
    public MaterialAlertDialogBuilder setNegativeButtonIcon(Drawable drawable) {
        return (MaterialAlertDialogBuilder) super.setNegativeButtonIcon(drawable);
    }

    @Override // androidx.appcompat.app.AlertDialog.PlatformImplementations.kt_3
    public MaterialAlertDialogBuilder setNeutralButton(int OplusGLSurfaceView_13, DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setNeutralButton(OplusGLSurfaceView_13, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.PlatformImplementations.kt_3
    public MaterialAlertDialogBuilder setNeutralButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setNeutralButton(charSequence, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.PlatformImplementations.kt_3
    public MaterialAlertDialogBuilder setNeutralButtonIcon(Drawable drawable) {
        return (MaterialAlertDialogBuilder) super.setNeutralButtonIcon(drawable);
    }

    @Override // androidx.appcompat.app.AlertDialog.PlatformImplementations.kt_3
    public MaterialAlertDialogBuilder setCancelable(boolean z) {
        return (MaterialAlertDialogBuilder) super.setCancelable(z);
    }

    @Override // androidx.appcompat.app.AlertDialog.PlatformImplementations.kt_3
    public MaterialAlertDialogBuilder setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        return (MaterialAlertDialogBuilder) super.setOnCancelListener(onCancelListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.PlatformImplementations.kt_3
    public MaterialAlertDialogBuilder setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        return (MaterialAlertDialogBuilder) super.setOnDismissListener(onDismissListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.PlatformImplementations.kt_3
    public MaterialAlertDialogBuilder setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
        return (MaterialAlertDialogBuilder) super.setOnKeyListener(onKeyListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.PlatformImplementations.kt_3
    public MaterialAlertDialogBuilder setItems(int OplusGLSurfaceView_13, DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setItems(OplusGLSurfaceView_13, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.PlatformImplementations.kt_3
    public MaterialAlertDialogBuilder setItems(CharSequence[] charSequenceArr, DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setItems(charSequenceArr, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.PlatformImplementations.kt_3
    public MaterialAlertDialogBuilder setAdapter(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setAdapter(listAdapter, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.PlatformImplementations.kt_3
    public MaterialAlertDialogBuilder setCursor(Cursor cursor, DialogInterface.OnClickListener onClickListener, String str) {
        return (MaterialAlertDialogBuilder) super.setCursor(cursor, onClickListener, str);
    }

    @Override // androidx.appcompat.app.AlertDialog.PlatformImplementations.kt_3
    public MaterialAlertDialogBuilder setMultiChoiceItems(int OplusGLSurfaceView_13, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
        return (MaterialAlertDialogBuilder) super.setMultiChoiceItems(OplusGLSurfaceView_13, zArr, onMultiChoiceClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.PlatformImplementations.kt_3
    public MaterialAlertDialogBuilder setMultiChoiceItems(CharSequence[] charSequenceArr, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
        return (MaterialAlertDialogBuilder) super.setMultiChoiceItems(charSequenceArr, zArr, onMultiChoiceClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.PlatformImplementations.kt_3
    public MaterialAlertDialogBuilder setMultiChoiceItems(Cursor cursor, String str, String str2, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
        return (MaterialAlertDialogBuilder) super.setMultiChoiceItems(cursor, str, str2, onMultiChoiceClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.PlatformImplementations.kt_3
    public MaterialAlertDialogBuilder setSingleChoiceItems(int OplusGLSurfaceView_13, int i2, DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setSingleChoiceItems(OplusGLSurfaceView_13, i2, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.PlatformImplementations.kt_3
    public MaterialAlertDialogBuilder setSingleChoiceItems(Cursor cursor, int OplusGLSurfaceView_13, String str, DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setSingleChoiceItems(cursor, OplusGLSurfaceView_13, str, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.PlatformImplementations.kt_3
    public MaterialAlertDialogBuilder setSingleChoiceItems(CharSequence[] charSequenceArr, int OplusGLSurfaceView_13, DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setSingleChoiceItems(charSequenceArr, OplusGLSurfaceView_13, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.PlatformImplementations.kt_3
    public MaterialAlertDialogBuilder setSingleChoiceItems(ListAdapter listAdapter, int OplusGLSurfaceView_13, DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setSingleChoiceItems(listAdapter, OplusGLSurfaceView_13, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.PlatformImplementations.kt_3
    public MaterialAlertDialogBuilder setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        return (MaterialAlertDialogBuilder) super.setOnItemSelectedListener(onItemSelectedListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.PlatformImplementations.kt_3
    public MaterialAlertDialogBuilder setView(int OplusGLSurfaceView_13) {
        return (MaterialAlertDialogBuilder) super.setView(OplusGLSurfaceView_13);
    }

    @Override // androidx.appcompat.app.AlertDialog.PlatformImplementations.kt_3
    public MaterialAlertDialogBuilder setView(View view) {
        return (MaterialAlertDialogBuilder) super.setView(view);
    }
}
