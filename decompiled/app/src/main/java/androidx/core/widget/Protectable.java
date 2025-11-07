package androidx.core.widget;

/* compiled from: CompoundButtonCompat.java */
/* loaded from: classes.dex */
public final class c_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static java.lang.reflect.Field f1025a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private static boolean f1026b;

    /* JADX WARN: Multi-variable type inference failed */
    public static void a_renamed(android.widget.CompoundButton compoundButton, android.content.res.ColorStateList colorStateList) {
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            compoundButton.setButtonTintList(colorStateList);
        } else if (compoundButton instanceof androidx.core.widget.j_renamed) {
            ((androidx.core.widget.j_renamed) compoundButton).setSupportButtonTintList(colorStateList);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static android.content.res.ColorStateList a_renamed(android.widget.CompoundButton compoundButton) {
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            return compoundButton.getButtonTintList();
        }
        if (compoundButton instanceof androidx.core.widget.j_renamed) {
            return ((androidx.core.widget.j_renamed) compoundButton).getSupportButtonTintList();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a_renamed(android.widget.CompoundButton compoundButton, android.graphics.PorterDuff.Mode mode) {
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            compoundButton.setButtonTintMode(mode);
        } else if (compoundButton instanceof androidx.core.widget.j_renamed) {
            ((androidx.core.widget.j_renamed) compoundButton).setSupportButtonTintMode(mode);
        }
    }

    public static android.graphics.drawable.Drawable b_renamed(android.widget.CompoundButton compoundButton) {
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            return compoundButton.getButtonDrawable();
        }
        if (!f1026b) {
            try {
                f1025a = android.widget.CompoundButton.class.getDeclaredField("mButtonDrawable");
                f1025a.setAccessible(true);
            } catch (java.lang.NoSuchFieldException e_renamed) {
                android.util.Log.i_renamed("CompoundButtonCompat", "Failed to retrieve mButtonDrawable field", e_renamed);
            }
            f1026b = true;
        }
        java.lang.reflect.Field field = f1025a;
        if (field != null) {
            try {
                return (android.graphics.drawable.Drawable) field.get(compoundButton);
            } catch (java.lang.IllegalAccessException e2) {
                android.util.Log.i_renamed("CompoundButtonCompat", "Failed to get button drawable via reflection", e2);
                f1025a = null;
            }
        }
        return null;
    }
}
