package androidx.core.h_renamed;

/* compiled from: MenuItemCompat.java */
/* loaded from: classes.dex */
public final class g_renamed {
    public static android.view.MenuItem a_renamed(android.view.MenuItem menuItem, androidx.core.h_renamed.b_renamed bVar) {
        if (menuItem instanceof androidx.core.b_renamed.a_renamed.b_renamed) {
            return ((androidx.core.b_renamed.a_renamed.b_renamed) menuItem).a_renamed(bVar);
        }
        android.util.Log.w_renamed("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
        return menuItem;
    }

    public static void a_renamed(android.view.MenuItem menuItem, java.lang.CharSequence charSequence) {
        if (menuItem instanceof androidx.core.b_renamed.a_renamed.b_renamed) {
            ((androidx.core.b_renamed.a_renamed.b_renamed) menuItem).a_renamed(charSequence);
        } else if (android.os.Build.VERSION.SDK_INT >= 26) {
            menuItem.setContentDescription(charSequence);
        }
    }

    public static void b_renamed(android.view.MenuItem menuItem, java.lang.CharSequence charSequence) {
        if (menuItem instanceof androidx.core.b_renamed.a_renamed.b_renamed) {
            ((androidx.core.b_renamed.a_renamed.b_renamed) menuItem).b_renamed(charSequence);
        } else if (android.os.Build.VERSION.SDK_INT >= 26) {
            menuItem.setTooltipText(charSequence);
        }
    }

    public static void a_renamed(android.view.MenuItem menuItem, char c2, int i_renamed) {
        if (menuItem instanceof androidx.core.b_renamed.a_renamed.b_renamed) {
            ((androidx.core.b_renamed.a_renamed.b_renamed) menuItem).setNumericShortcut(c2, i_renamed);
        } else if (android.os.Build.VERSION.SDK_INT >= 26) {
            menuItem.setNumericShortcut(c2, i_renamed);
        }
    }

    public static void b_renamed(android.view.MenuItem menuItem, char c2, int i_renamed) {
        if (menuItem instanceof androidx.core.b_renamed.a_renamed.b_renamed) {
            ((androidx.core.b_renamed.a_renamed.b_renamed) menuItem).setAlphabeticShortcut(c2, i_renamed);
        } else if (android.os.Build.VERSION.SDK_INT >= 26) {
            menuItem.setAlphabeticShortcut(c2, i_renamed);
        }
    }

    public static void a_renamed(android.view.MenuItem menuItem, android.content.res.ColorStateList colorStateList) {
        if (menuItem instanceof androidx.core.b_renamed.a_renamed.b_renamed) {
            ((androidx.core.b_renamed.a_renamed.b_renamed) menuItem).setIconTintList(colorStateList);
        } else if (android.os.Build.VERSION.SDK_INT >= 26) {
            menuItem.setIconTintList(colorStateList);
        }
    }

    public static void a_renamed(android.view.MenuItem menuItem, android.graphics.PorterDuff.Mode mode) {
        if (menuItem instanceof androidx.core.b_renamed.a_renamed.b_renamed) {
            ((androidx.core.b_renamed.a_renamed.b_renamed) menuItem).setIconTintMode(mode);
        } else if (android.os.Build.VERSION.SDK_INT >= 26) {
            menuItem.setIconTintMode(mode);
        }
    }
}
