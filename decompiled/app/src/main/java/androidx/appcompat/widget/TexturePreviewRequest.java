package androidx.appcompat.widget;

/* compiled from: DrawableUtils.java */
@android.annotation.SuppressLint({"RestrictedAPI"})
/* loaded from: classes.dex */
public class aa_renamed {
    private static java.lang.Class<?> d_renamed;

    /* renamed from: b_renamed, reason: collision with root package name */
    private static final int[] f521b = {android.R_renamed.attr.state_checked};

    /* renamed from: c_renamed, reason: collision with root package name */
    private static final int[] f522c = new int[0];

    /* renamed from: a_renamed, reason: collision with root package name */
    public static final android.graphics.Rect f520a = new android.graphics.Rect();

    static {
        if (android.os.Build.VERSION.SDK_INT >= 18) {
            try {
                d_renamed = java.lang.Class.forName("android.graphics.Insets");
            } catch (java.lang.ClassNotFoundException unused) {
            }
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as_renamed a_renamed decompilation issue */
    public static android.graphics.Rect a_renamed(android.graphics.drawable.Drawable drawable) throws java.lang.IllegalAccessException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        if (android.os.Build.VERSION.SDK_INT >= 29) {
            android.graphics.Insets opticalInsets = drawable.getOpticalInsets();
            android.graphics.Rect rect = new android.graphics.Rect();
            rect.left = opticalInsets.left;
            rect.right = opticalInsets.right;
            rect.top = opticalInsets.top;
            rect.bottom = opticalInsets.bottom;
            return rect;
        }
        if (d_renamed != null) {
            try {
                android.graphics.drawable.Drawable drawableH = androidx.core.graphics.drawable.a_renamed.h_renamed(drawable);
                java.lang.Object objInvoke = drawableH.getClass().getMethod("getOpticalInsets", new java.lang.Class[0]).invoke(drawableH, new java.lang.Object[0]);
                if (objInvoke != null) {
                    android.graphics.Rect rect2 = new android.graphics.Rect();
                    for (java.lang.reflect.Field field : d_renamed.getFields()) {
                        java.lang.String name = field.getName();
                        char c2 = 65535;
                        switch (name.hashCode()) {
                            case -1383228885:
                                if (name.equals("bottom")) {
                                    c2 = 3;
                                    break;
                                }
                                break;
                            case 115029:
                                if (name.equals("top")) {
                                    c2 = 1;
                                    break;
                                }
                                break;
                            case 3317767:
                                if (name.equals(com.google.android.exoplayer2.text.ttml.TtmlNode.LEFT)) {
                                    c2 = 0;
                                    break;
                                }
                                break;
                            case 108511772:
                                if (name.equals(com.google.android.exoplayer2.text.ttml.TtmlNode.RIGHT)) {
                                    c2 = 2;
                                    break;
                                }
                                break;
                        }
                        if (c2 == 0) {
                            rect2.left = field.getInt(objInvoke);
                        } else if (c2 == 1) {
                            rect2.top = field.getInt(objInvoke);
                        } else if (c2 == 2) {
                            rect2.right = field.getInt(objInvoke);
                        } else if (c2 == 3) {
                            rect2.bottom = field.getInt(objInvoke);
                        }
                    }
                    return rect2;
                }
            } catch (java.lang.Exception unused) {
                android.util.Log.e_renamed("DrawableUtils", "Couldn't_renamed obtain the optical insets. Ignoring.");
            }
        }
        return f520a;
    }

    static void b_renamed(android.graphics.drawable.Drawable drawable) {
        if (android.os.Build.VERSION.SDK_INT == 21 && "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName())) {
            d_renamed(drawable);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean c_renamed(android.graphics.drawable.Drawable drawable) {
        if (android.os.Build.VERSION.SDK_INT < 15 && (drawable instanceof android.graphics.drawable.InsetDrawable)) {
            return false;
        }
        if (android.os.Build.VERSION.SDK_INT < 15 && (drawable instanceof android.graphics.drawable.GradientDrawable)) {
            return false;
        }
        if (android.os.Build.VERSION.SDK_INT < 17 && (drawable instanceof android.graphics.drawable.LayerDrawable)) {
            return false;
        }
        if (drawable instanceof android.graphics.drawable.DrawableContainer) {
            android.graphics.drawable.Drawable.ConstantState constantState = drawable.getConstantState();
            if (!(constantState instanceof android.graphics.drawable.DrawableContainer.DrawableContainerState)) {
                return true;
            }
            for (android.graphics.drawable.Drawable drawable2 : ((android.graphics.drawable.DrawableContainer.DrawableContainerState) constantState).getChildren()) {
                if (!c_renamed(drawable2)) {
                    return false;
                }
            }
            return true;
        }
        if (drawable instanceof androidx.core.graphics.drawable.c_renamed) {
            return c_renamed(((androidx.core.graphics.drawable.c_renamed) drawable).a_renamed());
        }
        if (drawable instanceof androidx.appcompat.b_renamed.a_renamed.c_renamed) {
            return c_renamed(((androidx.appcompat.b_renamed.a_renamed.c_renamed) drawable).getWrappedDrawable());
        }
        if (drawable instanceof android.graphics.drawable.ScaleDrawable) {
            return c_renamed(((android.graphics.drawable.ScaleDrawable) drawable).getDrawable());
        }
        return true;
    }

    private static void d_renamed(android.graphics.drawable.Drawable drawable) {
        int[] state = drawable.getState();
        if (state == null || state.length == 0) {
            drawable.setState(f521b);
        } else {
            drawable.setState(f522c);
        }
        drawable.setState(state);
    }

    public static android.graphics.PorterDuff.Mode a_renamed(int i_renamed, android.graphics.PorterDuff.Mode mode) {
        if (i_renamed == 3) {
            return android.graphics.PorterDuff.Mode.SRC_OVER;
        }
        if (i_renamed == 5) {
            return android.graphics.PorterDuff.Mode.SRC_IN;
        }
        if (i_renamed == 9) {
            return android.graphics.PorterDuff.Mode.SRC_ATOP;
        }
        switch (i_renamed) {
            case 14:
                return android.graphics.PorterDuff.Mode.MULTIPLY;
            case 15:
                return android.graphics.PorterDuff.Mode.SCREEN;
            case 16:
                return android.graphics.PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }
}
