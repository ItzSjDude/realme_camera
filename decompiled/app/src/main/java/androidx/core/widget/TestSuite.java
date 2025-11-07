package androidx.core.widget;

/* compiled from: TextViewCompat.java */
/* loaded from: classes.dex */
public final class i_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static java.lang.reflect.Field f1030a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private static boolean f1031b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private static java.lang.reflect.Field f1032c;
    private static boolean d_renamed;

    private static java.lang.reflect.Field a_renamed(java.lang.String str) throws java.lang.NoSuchFieldException {
        java.lang.reflect.Field declaredField = null;
        try {
            declaredField = android.widget.TextView.class.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField;
        } catch (java.lang.NoSuchFieldException unused) {
            android.util.Log.e_renamed("TextViewCompat", "Could not retrieve " + str + " field.");
            return declaredField;
        }
    }

    private static int a_renamed(java.lang.reflect.Field field, android.widget.TextView textView) {
        try {
            return field.getInt(textView);
        } catch (java.lang.IllegalAccessException unused) {
            android.util.Log.d_renamed("TextViewCompat", "Could not retrieve value of_renamed " + field.getName() + " field.");
            return -1;
        }
    }

    public static void a_renamed(android.widget.TextView textView, android.graphics.drawable.Drawable drawable, android.graphics.drawable.Drawable drawable2, android.graphics.drawable.Drawable drawable3, android.graphics.drawable.Drawable drawable4) {
        if (android.os.Build.VERSION.SDK_INT >= 18) {
            textView.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
            return;
        }
        if (android.os.Build.VERSION.SDK_INT >= 17) {
            boolean z_renamed = textView.getLayoutDirection() == 1;
            android.graphics.drawable.Drawable drawable5 = z_renamed ? drawable3 : drawable;
            if (!z_renamed) {
                drawable = drawable3;
            }
            textView.setCompoundDrawables(drawable5, drawable2, drawable, drawable4);
            return;
        }
        textView.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
    }

    public static int a_renamed(android.widget.TextView textView) {
        if (android.os.Build.VERSION.SDK_INT >= 16) {
            return textView.getMaxLines();
        }
        if (!d_renamed) {
            f1032c = a_renamed("mMaxMode");
            d_renamed = true;
        }
        java.lang.reflect.Field field = f1032c;
        if (field == null || a_renamed(field, textView) != 1) {
            return -1;
        }
        if (!f1031b) {
            f1030a = a_renamed("mMaximum");
            f1031b = true;
        }
        java.lang.reflect.Field field2 = f1030a;
        if (field2 != null) {
            return a_renamed(field2, textView);
        }
        return -1;
    }

    public static void a_renamed(android.widget.TextView textView, int i_renamed) {
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            textView.setTextAppearance(i_renamed);
        } else {
            textView.setTextAppearance(textView.getContext(), i_renamed);
        }
    }

    public static android.graphics.drawable.Drawable[] b_renamed(android.widget.TextView textView) {
        if (android.os.Build.VERSION.SDK_INT >= 18) {
            return textView.getCompoundDrawablesRelative();
        }
        if (android.os.Build.VERSION.SDK_INT >= 17) {
            boolean z_renamed = textView.getLayoutDirection() == 1;
            android.graphics.drawable.Drawable[] compoundDrawables = textView.getCompoundDrawables();
            if (z_renamed) {
                android.graphics.drawable.Drawable drawable = compoundDrawables[2];
                android.graphics.drawable.Drawable drawable2 = compoundDrawables[0];
                compoundDrawables[0] = drawable;
                compoundDrawables[2] = drawable2;
            }
            return compoundDrawables;
        }
        return textView.getCompoundDrawables();
    }

    public static android.view.ActionMode.Callback a_renamed(android.widget.TextView textView, android.view.ActionMode.Callback callback) {
        return (android.os.Build.VERSION.SDK_INT < 26 || android.os.Build.VERSION.SDK_INT > 27 || (callback instanceof androidx.core.widget.i_renamed.a_renamed)) ? callback : new androidx.core.widget.i_renamed.a_renamed(callback, textView);
    }

    /* compiled from: TextViewCompat.java */
    private static class a_renamed implements android.view.ActionMode.Callback {

        /* renamed from: a_renamed, reason: collision with root package name */
        private final android.view.ActionMode.Callback f1033a;

        /* renamed from: b_renamed, reason: collision with root package name */
        private final android.widget.TextView f1034b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private java.lang.Class<?> f1035c;
        private java.lang.reflect.Method d_renamed;
        private boolean e_renamed;
        private boolean f_renamed = false;

        a_renamed(android.view.ActionMode.Callback callback, android.widget.TextView textView) {
            this.f1033a = callback;
            this.f1034b = textView;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(android.view.ActionMode actionMode, android.view.Menu menu) {
            return this.f1033a.onCreateActionMode(actionMode, menu);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(android.view.ActionMode actionMode, android.view.Menu menu) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
            a_renamed(menu);
            return this.f1033a.onPrepareActionMode(actionMode, menu);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(android.view.ActionMode actionMode, android.view.MenuItem menuItem) {
            return this.f1033a.onActionItemClicked(actionMode, menuItem);
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(android.view.ActionMode actionMode) {
            this.f1033a.onDestroyActionMode(actionMode);
        }

        private void a_renamed(android.view.Menu menu) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
            android.content.Context context = this.f1034b.getContext();
            android.content.pm.PackageManager packageManager = context.getPackageManager();
            if (!this.f_renamed) {
                this.f_renamed = true;
                try {
                    this.f1035c = java.lang.Class.forName("com.android.internal.view.menu.MenuBuilder");
                    this.d_renamed = this.f1035c.getDeclaredMethod("removeItemAt", java.lang.Integer.TYPE);
                    this.e_renamed = true;
                } catch (java.lang.ClassNotFoundException | java.lang.NoSuchMethodException unused) {
                    this.f1035c = null;
                    this.d_renamed = null;
                    this.e_renamed = false;
                }
            }
            try {
                java.lang.reflect.Method declaredMethod = (this.e_renamed && this.f1035c.isInstance(menu)) ? this.d_renamed : menu.getClass().getDeclaredMethod("removeItemAt", java.lang.Integer.TYPE);
                for (int size = menu.size() - 1; size >= 0; size--) {
                    android.view.MenuItem item = menu.getItem(size);
                    if (item.getIntent() != null && "android.intent.action.PROCESS_TEXT".equals(item.getIntent().getAction())) {
                        declaredMethod.invoke(menu, java.lang.Integer.valueOf(size));
                    }
                }
                java.util.List<android.content.pm.ResolveInfo> listA = a_renamed(context, packageManager);
                for (int i_renamed = 0; i_renamed < listA.size(); i_renamed++) {
                    android.content.pm.ResolveInfo resolveInfo = listA.get(i_renamed);
                    menu.add(0, 0, i_renamed + 100, resolveInfo.loadLabel(packageManager)).setIntent(a_renamed(resolveInfo, this.f1034b)).setShowAsAction(1);
                }
            } catch (java.lang.IllegalAccessException | java.lang.NoSuchMethodException | java.lang.reflect.InvocationTargetException unused2) {
            }
        }

        private java.util.List<android.content.pm.ResolveInfo> a_renamed(android.content.Context context, android.content.pm.PackageManager packageManager) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            if (!(context instanceof android.app.Activity)) {
                return arrayList;
            }
            for (android.content.pm.ResolveInfo resolveInfo : packageManager.queryIntentActivities(a_renamed(), 0)) {
                if (a_renamed(resolveInfo, context)) {
                    arrayList.add(resolveInfo);
                }
            }
            return arrayList;
        }

        private boolean a_renamed(android.content.pm.ResolveInfo resolveInfo, android.content.Context context) {
            if (context.getPackageName().equals(resolveInfo.activityInfo.packageName)) {
                return true;
            }
            if (resolveInfo.activityInfo.exported) {
                return resolveInfo.activityInfo.permission == null || context.checkSelfPermission(resolveInfo.activityInfo.permission) == 0;
            }
            return false;
        }

        private android.content.Intent a_renamed(android.content.pm.ResolveInfo resolveInfo, android.widget.TextView textView) {
            return a_renamed().putExtra("android.intent.extra.PROCESS_TEXT_READONLY", !a_renamed(textView)).setClassName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name);
        }

        private boolean a_renamed(android.widget.TextView textView) {
            return (textView instanceof android.text.Editable) && textView.onCheckIsTextEditor() && textView.isEnabled();
        }

        private android.content.Intent a_renamed() {
            return new android.content.Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain");
        }
    }

    public static void b_renamed(android.widget.TextView textView, int i_renamed) {
        int i2;
        androidx.core.g_renamed.f_renamed.a_renamed(i_renamed);
        if (android.os.Build.VERSION.SDK_INT >= 28) {
            textView.setFirstBaselineToTopHeight(i_renamed);
            return;
        }
        android.graphics.Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        if (android.os.Build.VERSION.SDK_INT < 16 || textView.getIncludeFontPadding()) {
            i2 = fontMetricsInt.top;
        } else {
            i2 = fontMetricsInt.ascent;
        }
        if (i_renamed > java.lang.Math.abs(i2)) {
            textView.setPadding(textView.getPaddingLeft(), i_renamed + i2, textView.getPaddingRight(), textView.getPaddingBottom());
        }
    }

    public static void c_renamed(android.widget.TextView textView, int i_renamed) {
        int i2;
        androidx.core.g_renamed.f_renamed.a_renamed(i_renamed);
        android.graphics.Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        if (android.os.Build.VERSION.SDK_INT < 16 || textView.getIncludeFontPadding()) {
            i2 = fontMetricsInt.bottom;
        } else {
            i2 = fontMetricsInt.descent;
        }
        if (i_renamed > java.lang.Math.abs(i2)) {
            textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), i_renamed - i2);
        }
    }

    public static int c_renamed(android.widget.TextView textView) {
        return textView.getPaddingTop() - textView.getPaint().getFontMetricsInt().top;
    }

    public static int d_renamed(android.widget.TextView textView) {
        return textView.getPaddingBottom() + textView.getPaint().getFontMetricsInt().bottom;
    }

    public static void d_renamed(android.widget.TextView textView, int i_renamed) {
        androidx.core.g_renamed.f_renamed.a_renamed(i_renamed);
        if (i_renamed != textView.getPaint().getFontMetricsInt(null)) {
            textView.setLineSpacing(i_renamed - r0, 1.0f);
        }
    }

    public static androidx.core.f_renamed.c_renamed.a_renamed e_renamed(android.widget.TextView textView) {
        if (android.os.Build.VERSION.SDK_INT >= 28) {
            return new androidx.core.f_renamed.c_renamed.a_renamed(textView.getTextMetricsParams());
        }
        androidx.core.f_renamed.c_renamed.a_renamed.PrecomputedTextCompat_3 c0018a = new androidx.core.f_renamed.c_renamed.a_renamed.PrecomputedTextCompat_3(new android.text.TextPaint(textView.getPaint()));
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            c0018a.a_renamed(textView.getBreakStrategy());
            c0018a.b_renamed(textView.getHyphenationFrequency());
        }
        if (android.os.Build.VERSION.SDK_INT >= 18) {
            c0018a.a_renamed(f_renamed(textView));
        }
        return c0018a.a_renamed();
    }

    public static void a_renamed(android.widget.TextView textView, androidx.core.f_renamed.c_renamed.a_renamed aVar) {
        if (android.os.Build.VERSION.SDK_INT >= 18) {
            textView.setTextDirection(a_renamed(aVar.b_renamed()));
        }
        if (android.os.Build.VERSION.SDK_INT < 23) {
            float textScaleX = aVar.a_renamed().getTextScaleX();
            textView.getPaint().set(aVar.a_renamed());
            if (textScaleX == textView.getTextScaleX()) {
                textView.setTextScaleX((textScaleX / 2.0f) + 1.0f);
            }
            textView.setTextScaleX(textScaleX);
            return;
        }
        textView.getPaint().set(aVar.a_renamed());
        textView.setBreakStrategy(aVar.c_renamed());
        textView.setHyphenationFrequency(aVar.d_renamed());
    }

    public static void a_renamed(android.widget.TextView textView, androidx.core.f_renamed.c_renamed cVar) {
        if (android.os.Build.VERSION.SDK_INT >= 29) {
            textView.setText(cVar.a_renamed());
        } else {
            if (!e_renamed(textView).a_renamed(cVar.b_renamed())) {
                throw new java.lang.IllegalArgumentException("Given text can not be_renamed applied to TextView.");
            }
            textView.setText(cVar);
        }
    }

    private static android.text.TextDirectionHeuristic f_renamed(android.widget.TextView textView) {
        if (textView.getTransformationMethod() instanceof android.text.method.PasswordTransformationMethod) {
            return android.text.TextDirectionHeuristics.LTR;
        }
        if (android.os.Build.VERSION.SDK_INT >= 28 && (textView.getInputType() & 15) == 3) {
            byte directionality = java.lang.Character.getDirectionality(android.icu.text.DecimalFormatSymbols.getInstance(textView.getTextLocale()).getDigitStrings()[0].codePointAt(0));
            if (directionality == 1 || directionality == 2) {
                return android.text.TextDirectionHeuristics.RTL;
            }
            return android.text.TextDirectionHeuristics.LTR;
        }
        boolean z_renamed = textView.getLayoutDirection() == 1;
        switch (textView.getTextDirection()) {
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            default:
                if (!z_renamed) {
                    break;
                } else {
                    break;
                }
        }
        return android.text.TextDirectionHeuristics.LTR;
    }

    private static int a_renamed(android.text.TextDirectionHeuristic textDirectionHeuristic) {
        if (textDirectionHeuristic == android.text.TextDirectionHeuristics.FIRSTSTRONG_RTL || textDirectionHeuristic == android.text.TextDirectionHeuristics.FIRSTSTRONG_LTR) {
            return 1;
        }
        if (textDirectionHeuristic == android.text.TextDirectionHeuristics.ANYRTL_LTR) {
            return 2;
        }
        if (textDirectionHeuristic == android.text.TextDirectionHeuristics.LTR) {
            return 3;
        }
        if (textDirectionHeuristic == android.text.TextDirectionHeuristics.RTL) {
            return 4;
        }
        if (textDirectionHeuristic == android.text.TextDirectionHeuristics.LOCALE) {
            return 5;
        }
        if (textDirectionHeuristic == android.text.TextDirectionHeuristics.FIRSTSTRONG_LTR) {
            return 6;
        }
        return textDirectionHeuristic == android.text.TextDirectionHeuristics.FIRSTSTRONG_RTL ? 7 : 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a_renamed(android.widget.TextView textView, android.content.res.ColorStateList colorStateList) {
        androidx.core.g_renamed.f_renamed.a_renamed(textView);
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            textView.setCompoundDrawableTintList(colorStateList);
        } else if (textView instanceof androidx.core.widget.k_renamed) {
            ((androidx.core.widget.k_renamed) textView).setSupportCompoundDrawablesTintList(colorStateList);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a_renamed(android.widget.TextView textView, android.graphics.PorterDuff.Mode mode) {
        androidx.core.g_renamed.f_renamed.a_renamed(textView);
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            textView.setCompoundDrawableTintMode(mode);
        } else if (textView instanceof androidx.core.widget.k_renamed) {
            ((androidx.core.widget.k_renamed) textView).setSupportCompoundDrawablesTintMode(mode);
        }
    }
}
