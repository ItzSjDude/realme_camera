package androidx.core.p036h;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Build;
import android.util.Log;
import android.view.MenuItem;
import androidx.core.p029b.p030a.SupportMenuItem;

/* compiled from: MenuItemCompat.java */
/* renamed from: androidx.core.COUIBaseListPopupWindow_10.COUIBaseListPopupWindow_11 */
/* loaded from: classes.dex */
public final class MenuItemCompat {
    /* renamed from: PlatformImplementations.kt_3 */
    public static MenuItem m2787a(MenuItem menuItem, ActionProvider abstractC0491b) {
        if (menuItem instanceof SupportMenuItem) {
            return ((SupportMenuItem) menuItem).mo1097a(abstractC0491b);
        }
        Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
        return menuItem;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m2791a(MenuItem menuItem, CharSequence charSequence) {
        if (menuItem instanceof SupportMenuItem) {
            ((SupportMenuItem) menuItem).mo1098a(charSequence);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setContentDescription(charSequence);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static void m2793b(MenuItem menuItem, CharSequence charSequence) {
        if (menuItem instanceof SupportMenuItem) {
            ((SupportMenuItem) menuItem).mo1101b(charSequence);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setTooltipText(charSequence);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m2788a(MenuItem menuItem, char c2, int OplusGLSurfaceView_13) {
        if (menuItem instanceof SupportMenuItem) {
            ((SupportMenuItem) menuItem).setNumericShortcut(c2, OplusGLSurfaceView_13);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setNumericShortcut(c2, OplusGLSurfaceView_13);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static void m2792b(MenuItem menuItem, char c2, int OplusGLSurfaceView_13) {
        if (menuItem instanceof SupportMenuItem) {
            ((SupportMenuItem) menuItem).setAlphabeticShortcut(c2, OplusGLSurfaceView_13);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setAlphabeticShortcut(c2, OplusGLSurfaceView_13);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m2789a(MenuItem menuItem, ColorStateList colorStateList) {
        if (menuItem instanceof SupportMenuItem) {
            ((SupportMenuItem) menuItem).setIconTintList(colorStateList);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setIconTintList(colorStateList);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m2790a(MenuItem menuItem, PorterDuff.Mode mode) {
        if (menuItem instanceof SupportMenuItem) {
            ((SupportMenuItem) menuItem).setIconTintMode(mode);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setIconTintMode(mode);
        }
    }
}
