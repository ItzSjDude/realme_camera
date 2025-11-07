package androidx.core.graphics.drawable;

/* compiled from: DrawableCompat.java */
/* loaded from: classes.dex */
public final class a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static java.lang.reflect.Method f928a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private static boolean f929b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private static java.lang.reflect.Method f930c;
    private static boolean d_renamed;

    @java.lang.Deprecated
    public static void a_renamed(android.graphics.drawable.Drawable drawable) {
        drawable.jumpToCurrentState();
    }

    public static void a_renamed(android.graphics.drawable.Drawable drawable, boolean z_renamed) {
        if (android.os.Build.VERSION.SDK_INT >= 19) {
            drawable.setAutoMirrored(z_renamed);
        }
    }

    public static boolean b_renamed(android.graphics.drawable.Drawable drawable) {
        if (android.os.Build.VERSION.SDK_INT >= 19) {
            return drawable.isAutoMirrored();
        }
        return false;
    }

    public static void a_renamed(android.graphics.drawable.Drawable drawable, float f_renamed, float f2) {
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            drawable.setHotspot(f_renamed, f2);
        }
    }

    public static void a_renamed(android.graphics.drawable.Drawable drawable, int i_renamed, int i2, int i3, int i4) {
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            drawable.setHotspotBounds(i_renamed, i2, i3, i4);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a_renamed(android.graphics.drawable.Drawable drawable, int i_renamed) {
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            drawable.setTint(i_renamed);
        } else if (drawable instanceof androidx.core.graphics.drawable.b_renamed) {
            ((androidx.core.graphics.drawable.b_renamed) drawable).setTint(i_renamed);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a_renamed(android.graphics.drawable.Drawable drawable, android.content.res.ColorStateList colorStateList) {
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            drawable.setTintList(colorStateList);
        } else if (drawable instanceof androidx.core.graphics.drawable.b_renamed) {
            ((androidx.core.graphics.drawable.b_renamed) drawable).setTintList(colorStateList);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a_renamed(android.graphics.drawable.Drawable drawable, android.graphics.PorterDuff.Mode mode) {
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            drawable.setTintMode(mode);
        } else if (drawable instanceof androidx.core.graphics.drawable.b_renamed) {
            ((androidx.core.graphics.drawable.b_renamed) drawable).setTintMode(mode);
        }
    }

    public static int c_renamed(android.graphics.drawable.Drawable drawable) {
        if (android.os.Build.VERSION.SDK_INT >= 19) {
            return drawable.getAlpha();
        }
        return 0;
    }

    public static void a_renamed(android.graphics.drawable.Drawable drawable, android.content.res.Resources.Theme theme) {
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            drawable.applyTheme(theme);
        }
    }

    public static boolean d_renamed(android.graphics.drawable.Drawable drawable) {
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            return drawable.canApplyTheme();
        }
        return false;
    }

    public static android.graphics.ColorFilter e_renamed(android.graphics.drawable.Drawable drawable) {
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            return drawable.getColorFilter();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void f_renamed(android.graphics.drawable.Drawable drawable) {
        android.graphics.drawable.DrawableContainer.DrawableContainerState drawableContainerState;
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            drawable.clearColorFilter();
            return;
        }
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            drawable.clearColorFilter();
            if (drawable instanceof android.graphics.drawable.InsetDrawable) {
                f_renamed(((android.graphics.drawable.InsetDrawable) drawable).getDrawable());
                return;
            }
            if (drawable instanceof androidx.core.graphics.drawable.c_renamed) {
                f_renamed(((androidx.core.graphics.drawable.c_renamed) drawable).a_renamed());
                return;
            }
            if (!(drawable instanceof android.graphics.drawable.DrawableContainer) || (drawableContainerState = (android.graphics.drawable.DrawableContainer.DrawableContainerState) ((android.graphics.drawable.DrawableContainer) drawable).getConstantState()) == null) {
                return;
            }
            int childCount = drawableContainerState.getChildCount();
            for (int i_renamed = 0; i_renamed < childCount; i_renamed++) {
                android.graphics.drawable.Drawable child = drawableContainerState.getChild(i_renamed);
                if (child != null) {
                    f_renamed(child);
                }
            }
            return;
        }
        drawable.clearColorFilter();
    }

    public static void a_renamed(android.graphics.drawable.Drawable drawable, android.content.res.Resources resources, org.xmlpull.v1.XmlPullParser xmlPullParser, android.util.AttributeSet attributeSet, android.content.res.Resources.Theme theme) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            drawable.inflate(resources, xmlPullParser, attributeSet, theme);
        } else {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        }
    }

    public static android.graphics.drawable.Drawable g_renamed(android.graphics.drawable.Drawable drawable) {
        return android.os.Build.VERSION.SDK_INT >= 23 ? drawable : android.os.Build.VERSION.SDK_INT >= 21 ? !(drawable instanceof androidx.core.graphics.drawable.b_renamed) ? new androidx.core.graphics.drawable.e_renamed(drawable) : drawable : !(drawable instanceof androidx.core.graphics.drawable.b_renamed) ? new androidx.core.graphics.drawable.d_renamed(drawable) : drawable;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T_renamed extends android.graphics.drawable.Drawable> T_renamed h_renamed(android.graphics.drawable.Drawable drawable) {
        return drawable instanceof androidx.core.graphics.drawable.c_renamed ? (T_renamed) ((androidx.core.graphics.drawable.c_renamed) drawable).a_renamed() : drawable;
    }

    public static boolean b_renamed(android.graphics.drawable.Drawable drawable, int i_renamed) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            return drawable.setLayoutDirection(i_renamed);
        }
        if (android.os.Build.VERSION.SDK_INT >= 17) {
            if (!f929b) {
                try {
                    f928a = android.graphics.drawable.Drawable.class.getDeclaredMethod("setLayoutDirection", java.lang.Integer.TYPE);
                    f928a.setAccessible(true);
                } catch (java.lang.NoSuchMethodException e_renamed) {
                    android.util.Log.i_renamed("DrawableCompat", "Failed to retrieve setLayoutDirection(int) method", e_renamed);
                }
                f929b = true;
            }
            java.lang.reflect.Method method = f928a;
            if (method != null) {
                try {
                    method.invoke(drawable, java.lang.Integer.valueOf(i_renamed));
                    return true;
                } catch (java.lang.Exception e2) {
                    android.util.Log.i_renamed("DrawableCompat", "Failed to invoke setLayoutDirection(int) via reflection", e2);
                    f928a = null;
                }
            }
        }
        return false;
    }

    public static int i_renamed(android.graphics.drawable.Drawable drawable) {
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            return drawable.getLayoutDirection();
        }
        if (android.os.Build.VERSION.SDK_INT >= 17) {
            if (!d_renamed) {
                try {
                    f930c = android.graphics.drawable.Drawable.class.getDeclaredMethod("getLayoutDirection", new java.lang.Class[0]);
                    f930c.setAccessible(true);
                } catch (java.lang.NoSuchMethodException e_renamed) {
                    android.util.Log.i_renamed("DrawableCompat", "Failed to retrieve getLayoutDirection() method", e_renamed);
                }
                d_renamed = true;
            }
            java.lang.reflect.Method method = f930c;
            if (method != null) {
                try {
                    return ((java.lang.Integer) method.invoke(drawable, new java.lang.Object[0])).intValue();
                } catch (java.lang.Exception e2) {
                    android.util.Log.i_renamed("DrawableCompat", "Failed to invoke getLayoutDirection() via reflection", e2);
                    f930c = null;
                }
            }
        }
        return 0;
    }
}
