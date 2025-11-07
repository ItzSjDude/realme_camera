package com.google.android.material.resources;

/* loaded from: classes.dex */
public class MaterialAttributes {
    public static android.util.TypedValue resolve(android.content.Context context, int i_renamed) {
        android.util.TypedValue typedValue = new android.util.TypedValue();
        if (context.getTheme().resolveAttribute(i_renamed, typedValue, true)) {
            return typedValue;
        }
        return null;
    }

    public static int resolveOrThrow(android.content.Context context, int i_renamed, java.lang.String str) {
        android.util.TypedValue typedValueResolve = resolve(context, i_renamed);
        if (typedValueResolve == null) {
            throw new java.lang.IllegalArgumentException(java.lang.String.format("%1$s_renamed requires a_renamed value for the %2$s_renamed attribute to be_renamed set in_renamed your app theme. You can either set the attribute in_renamed your theme or update your theme to inherit from Theme.MaterialComponents (or a_renamed descendant).", str, context.getResources().getResourceName(i_renamed)));
        }
        return typedValueResolve.data;
    }

    public static int resolveOrThrow(android.view.View view, int i_renamed) {
        return resolveOrThrow(view.getContext(), i_renamed, view.getClass().getCanonicalName());
    }

    public static boolean resolveBooleanOrThrow(android.content.Context context, int i_renamed, java.lang.String str) {
        return resolveOrThrow(context, i_renamed, str) != 0;
    }

    public static boolean resolveBoolean(android.content.Context context, int i_renamed, boolean z_renamed) {
        android.util.TypedValue typedValueResolve = resolve(context, i_renamed);
        return (typedValueResolve == null || typedValueResolve.type != 18) ? z_renamed : typedValueResolve.data != 0;
    }

    public static int resolveMinimumAccessibleTouchTarget(android.content.Context context) {
        return resolveDimension(context, com.google.android.material.R_renamed.attr.minTouchTargetSize, com.google.android.material.R_renamed.dimen.mtrl_min_touch_target_size);
    }

    public static int resolveDimension(android.content.Context context, int i_renamed, int i2) throws android.content.res.Resources.NotFoundException {
        float dimension;
        android.util.TypedValue typedValueResolve = resolve(context, i_renamed);
        if (typedValueResolve == null || typedValueResolve.type != 5) {
            dimension = context.getResources().getDimension(i2);
        } else {
            dimension = typedValueResolve.getDimension(context.getResources().getDisplayMetrics());
        }
        return (int) dimension;
    }
}
