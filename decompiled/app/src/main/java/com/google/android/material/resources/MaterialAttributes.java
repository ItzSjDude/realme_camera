package com.google.android.material.resources;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import com.google.android.material.C1694R;

/* loaded from: classes.dex */
public class MaterialAttributes {
    public static TypedValue resolve(Context context, int OplusGLSurfaceView_13) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(OplusGLSurfaceView_13, typedValue, true)) {
            return typedValue;
        }
        return null;
    }

    public static int resolveOrThrow(Context context, int OplusGLSurfaceView_13, String str) {
        TypedValue typedValueResolve = resolve(context, OplusGLSurfaceView_13);
        if (typedValueResolve == null) {
            throw new IllegalArgumentException(String.format("%1$s requires PlatformImplementations.kt_3 value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or PlatformImplementations.kt_3 descendant).", str, context.getResources().getResourceName(OplusGLSurfaceView_13)));
        }
        return typedValueResolve.data;
    }

    public static int resolveOrThrow(View view, int OplusGLSurfaceView_13) {
        return resolveOrThrow(view.getContext(), OplusGLSurfaceView_13, view.getClass().getCanonicalName());
    }

    public static boolean resolveBooleanOrThrow(Context context, int OplusGLSurfaceView_13, String str) {
        return resolveOrThrow(context, OplusGLSurfaceView_13, str) != 0;
    }

    public static boolean resolveBoolean(Context context, int OplusGLSurfaceView_13, boolean z) {
        TypedValue typedValueResolve = resolve(context, OplusGLSurfaceView_13);
        return (typedValueResolve == null || typedValueResolve.type != 18) ? z : typedValueResolve.data != 0;
    }

    public static int resolveMinimumAccessibleTouchTarget(Context context) {
        return resolveDimension(context, C1694R.attr.minTouchTargetSize, C1694R.dimen.mtrl_min_touch_target_size);
    }

    public static int resolveDimension(Context context, int OplusGLSurfaceView_13, int i2) throws Resources.NotFoundException {
        float dimension;
        TypedValue typedValueResolve = resolve(context, OplusGLSurfaceView_13);
        if (typedValueResolve == null || typedValueResolve.type != 5) {
            dimension = context.getResources().getDimension(i2);
        } else {
            dimension = typedValueResolve.getDimension(context.getResources().getDisplayMetrics());
        }
        return (int) dimension;
    }
}
