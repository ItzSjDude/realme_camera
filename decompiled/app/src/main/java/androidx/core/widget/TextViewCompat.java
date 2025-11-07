package androidx.core.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.icu.text.DecimalFormatSymbols;
import android.os.Build;
import android.text.Editable;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.core.p034f.PrecomputedTextCompat;
import androidx.core.p035g.Preconditions;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TextViewCompat.java */
/* renamed from: androidx.core.widget.OplusGLSurfaceView_13 */
/* loaded from: classes.dex */
public final class TextViewCompat {

    /* renamed from: PlatformImplementations.kt_3 */
    private static Field f3174a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static boolean f3175b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static Field f3176c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static boolean f3177d;

    /* renamed from: PlatformImplementations.kt_3 */
    private static Field m3047a(String str) throws NoSuchFieldException {
        Field declaredField = null;
        try {
            declaredField = TextView.class.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField;
        } catch (NoSuchFieldException unused) {
            Log.COUIBaseListPopupWindow_8("TextViewCompat", "Could not retrieve " + str + " field.");
            return declaredField;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static int m3045a(Field field, TextView textView) {
        try {
            return field.getInt(textView);
        } catch (IllegalAccessException unused) {
            Log.IntrinsicsJvm.kt_5("TextViewCompat", "Could not retrieve value of " + field.getName() + " field.");
            return -1;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m3051a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (Build.VERSION.SDK_INT >= 18) {
            textView.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
            return;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            boolean z = textView.getLayoutDirection() == 1;
            Drawable drawable5 = z ? drawable3 : drawable;
            if (!z) {
                drawable = drawable3;
            }
            textView.setCompoundDrawables(drawable5, drawable2, drawable, drawable4);
            return;
        }
        textView.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static int m3044a(TextView textView) {
        if (Build.VERSION.SDK_INT >= 16) {
            return textView.getMaxLines();
        }
        if (!f3177d) {
            f3176c = m3047a("mMaxMode");
            f3177d = true;
        }
        Field field = f3176c;
        if (field == null || m3045a(field, textView) != 1) {
            return -1;
        }
        if (!f3175b) {
            f3174a = m3047a("mMaximum");
            f3175b = true;
        }
        Field field2 = f3174a;
        if (field2 != null) {
            return m3045a(field2, textView);
        }
        return -1;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m3048a(TextView textView, int OplusGLSurfaceView_13) {
        if (Build.VERSION.SDK_INT >= 23) {
            textView.setTextAppearance(OplusGLSurfaceView_13);
        } else {
            textView.setTextAppearance(textView.getContext(), OplusGLSurfaceView_13);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static Drawable[] m3055b(TextView textView) {
        if (Build.VERSION.SDK_INT >= 18) {
            return textView.getCompoundDrawablesRelative();
        }
        if (Build.VERSION.SDK_INT >= 17) {
            boolean z = textView.getLayoutDirection() == 1;
            Drawable[] compoundDrawables = textView.getCompoundDrawables();
            if (z) {
                Drawable drawable = compoundDrawables[2];
                Drawable drawable2 = compoundDrawables[0];
                compoundDrawables[0] = drawable;
                compoundDrawables[2] = drawable2;
            }
            return compoundDrawables;
        }
        return textView.getCompoundDrawables();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static ActionMode.Callback m3046a(TextView textView, ActionMode.Callback callback) {
        return (Build.VERSION.SDK_INT < 26 || Build.VERSION.SDK_INT > 27 || (callback instanceof PlatformImplementations.kt_3)) ? callback : new PlatformImplementations.kt_3(callback, textView);
    }

    /* compiled from: TextViewCompat.java */
    /* renamed from: androidx.core.widget.OplusGLSurfaceView_13$PlatformImplementations.kt_3 */
    private static class PlatformImplementations.kt_3 implements ActionMode.Callback {

        /* renamed from: PlatformImplementations.kt_3 */
        private final ActionMode.Callback f3178a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private final TextView f3179b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private Class<?> f3180c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private Method f3181d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        private boolean f3182e;

        /* renamed from: COUIBaseListPopupWindow_12 */
        private boolean f3183f = false;

        PlatformImplementations.kt_3(ActionMode.Callback callback, TextView textView) {
            this.f3178a = callback;
            this.f3179b = textView;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return this.f3178a.onCreateActionMode(actionMode, menu);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            m3065a(menu);
            return this.f3178a.onPrepareActionMode(actionMode, menu);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return this.f3178a.onActionItemClicked(actionMode, menuItem);
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
            this.f3178a.onDestroyActionMode(actionMode);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private void m3065a(Menu menu) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            Context context = this.f3179b.getContext();
            PackageManager packageManager = context.getPackageManager();
            if (!this.f3183f) {
                this.f3183f = true;
                try {
                    this.f3180c = Class.forName("com.android.internal.view.menu.MenuBuilder");
                    this.f3181d = this.f3180c.getDeclaredMethod("removeItemAt", Integer.TYPE);
                    this.f3182e = true;
                } catch (ClassNotFoundException | NoSuchMethodException unused) {
                    this.f3180c = null;
                    this.f3181d = null;
                    this.f3182e = false;
                }
            }
            try {
                Method declaredMethod = (this.f3182e && this.f3180c.isInstance(menu)) ? this.f3181d : menu.getClass().getDeclaredMethod("removeItemAt", Integer.TYPE);
                for (int size = menu.size() - 1; size >= 0; size--) {
                    MenuItem item = menu.getItem(size);
                    if (item.getIntent() != null && "android.intent.action.PROCESS_TEXT".equals(item.getIntent().getAction())) {
                        declaredMethod.invoke(menu, Integer.valueOf(size));
                    }
                }
                List<ResolveInfo> listM3064a = m3064a(context, packageManager);
                for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < listM3064a.size(); OplusGLSurfaceView_13++) {
                    ResolveInfo resolveInfo = listM3064a.get(OplusGLSurfaceView_13);
                    menu.add(0, 0, OplusGLSurfaceView_13 + 100, resolveInfo.loadLabel(packageManager)).setIntent(m3063a(resolveInfo, this.f3179b)).setShowAsAction(1);
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
            }
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private List<ResolveInfo> m3064a(Context context, PackageManager packageManager) {
            ArrayList arrayList = new ArrayList();
            if (!(context instanceof Activity)) {
                return arrayList;
            }
            for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(m3062a(), 0)) {
                if (m3066a(resolveInfo, context)) {
                    arrayList.add(resolveInfo);
                }
            }
            return arrayList;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private boolean m3066a(ResolveInfo resolveInfo, Context context) {
            if (context.getPackageName().equals(resolveInfo.activityInfo.packageName)) {
                return true;
            }
            if (resolveInfo.activityInfo.exported) {
                return resolveInfo.activityInfo.permission == null || context.checkSelfPermission(resolveInfo.activityInfo.permission) == 0;
            }
            return false;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private Intent m3063a(ResolveInfo resolveInfo, TextView textView) {
            return m3062a().putExtra("android.intent.extra.PROCESS_TEXT_READONLY", !m3067a(textView)).setClassName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private boolean m3067a(TextView textView) {
            return (textView instanceof Editable) && textView.onCheckIsTextEditor() && textView.isEnabled();
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private Intent m3062a() {
            return new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain");
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static void m3054b(TextView textView, int OplusGLSurfaceView_13) {
        int i2;
        Preconditions.m2535a(OplusGLSurfaceView_13);
        if (Build.VERSION.SDK_INT >= 28) {
            textView.setFirstBaselineToTopHeight(OplusGLSurfaceView_13);
            return;
        }
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        if (Build.VERSION.SDK_INT < 16 || textView.getIncludeFontPadding()) {
            i2 = fontMetricsInt.top;
        } else {
            i2 = fontMetricsInt.ascent;
        }
        if (OplusGLSurfaceView_13 > Math.abs(i2)) {
            textView.setPadding(textView.getPaddingLeft(), OplusGLSurfaceView_13 + i2, textView.getPaddingRight(), textView.getPaddingBottom());
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static void m3057c(TextView textView, int OplusGLSurfaceView_13) {
        int i2;
        Preconditions.m2535a(OplusGLSurfaceView_13);
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        if (Build.VERSION.SDK_INT < 16 || textView.getIncludeFontPadding()) {
            i2 = fontMetricsInt.bottom;
        } else {
            i2 = fontMetricsInt.descent;
        }
        if (OplusGLSurfaceView_13 > Math.abs(i2)) {
            textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), OplusGLSurfaceView_13 - i2);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static int m3056c(TextView textView) {
        return textView.getPaddingTop() - textView.getPaint().getFontMetricsInt().top;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public static int m3058d(TextView textView) {
        return textView.getPaddingBottom() + textView.getPaint().getFontMetricsInt().bottom;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public static void m3059d(TextView textView, int OplusGLSurfaceView_13) {
        Preconditions.m2535a(OplusGLSurfaceView_13);
        if (OplusGLSurfaceView_13 != textView.getPaint().getFontMetricsInt(null)) {
            textView.setLineSpacing(OplusGLSurfaceView_13 - r0, 1.0f);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public static PrecomputedTextCompat.PlatformImplementations.kt_3 m3060e(TextView textView) {
        if (Build.VERSION.SDK_INT >= 28) {
            return new PrecomputedTextCompat.PlatformImplementations.kt_3(textView.getTextMetricsParams());
        }
        PrecomputedTextCompat.PlatformImplementations.kt_3.PrecomputedTextCompat_3 c4114a = new PrecomputedTextCompat.PlatformImplementations.kt_3.PrecomputedTextCompat_3(new TextPaint(textView.getPaint()));
        if (Build.VERSION.SDK_INT >= 23) {
            c4114a.m2515a(textView.getBreakStrategy());
            c4114a.m2518b(textView.getHyphenationFrequency());
        }
        if (Build.VERSION.SDK_INT >= 18) {
            c4114a.m2516a(m3061f(textView));
        }
        return c4114a.m2517a();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m3052a(TextView textView, PrecomputedTextCompat.PlatformImplementations.kt_3 aVar) {
        if (Build.VERSION.SDK_INT >= 18) {
            textView.setTextDirection(m3043a(aVar.m2512b()));
        }
        if (Build.VERSION.SDK_INT < 23) {
            float textScaleX = aVar.m2510a().getTextScaleX();
            textView.getPaint().set(aVar.m2510a());
            if (textScaleX == textView.getTextScaleX()) {
                textView.setTextScaleX((textScaleX / 2.0f) + 1.0f);
            }
            textView.setTextScaleX(textScaleX);
            return;
        }
        textView.getPaint().set(aVar.m2510a());
        textView.setBreakStrategy(aVar.m2513c());
        textView.setHyphenationFrequency(aVar.m2514d());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m3053a(TextView textView, PrecomputedTextCompat c0450c) {
        if (Build.VERSION.SDK_INT >= 29) {
            textView.setText(c0450c.m2508a());
        } else {
            if (!m3060e(textView).m2511a(c0450c.m2509b())) {
                throw new IllegalArgumentException("Given text can not be applied to TextView.");
            }
            textView.setText(c0450c);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private static TextDirectionHeuristic m3061f(TextView textView) {
        if (textView.getTransformationMethod() instanceof PasswordTransformationMethod) {
            return TextDirectionHeuristics.LTR;
        }
        if (Build.VERSION.SDK_INT >= 28 && (textView.getInputType() & 15) == 3) {
            byte directionality = Character.getDirectionality(DecimalFormatSymbols.getInstance(textView.getTextLocale()).getDigitStrings()[0].codePointAt(0));
            if (directionality == 1 || directionality == 2) {
                return TextDirectionHeuristics.RTL;
            }
            return TextDirectionHeuristics.LTR;
        }
        boolean z = textView.getLayoutDirection() == 1;
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
                if (!z) {
                    break;
                } else {
                    break;
                }
        }
        return TextDirectionHeuristics.LTR;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static int m3043a(TextDirectionHeuristic textDirectionHeuristic) {
        if (textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL || textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR) {
            return 1;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.ANYRTL_LTR) {
            return 2;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.LTR) {
            return 3;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.RTL) {
            return 4;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.LOCALE) {
            return 5;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR) {
            return 6;
        }
        return textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL ? 7 : 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: PlatformImplementations.kt_3 */
    public static void m3049a(TextView textView, ColorStateList colorStateList) {
        Preconditions.m2536a(textView);
        if (Build.VERSION.SDK_INT >= 24) {
            textView.setCompoundDrawableTintList(colorStateList);
        } else if (textView instanceof TintableCompoundDrawablesView) {
            ((TintableCompoundDrawablesView) textView).setSupportCompoundDrawablesTintList(colorStateList);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: PlatformImplementations.kt_3 */
    public static void m3050a(TextView textView, PorterDuff.Mode mode) {
        Preconditions.m2536a(textView);
        if (Build.VERSION.SDK_INT >= 24) {
            textView.setCompoundDrawableTintMode(mode);
        } else if (textView instanceof TintableCompoundDrawablesView) {
            ((TintableCompoundDrawablesView) textView).setSupportCompoundDrawablesTintMode(mode);
        }
    }
}
