package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.widget.CompoundButton;
import java.lang.reflect.Field;

/* compiled from: CompoundButtonCompat.java */
/* renamed from: androidx.core.widget.IntrinsicsJvm.kt_3 */
/* loaded from: classes.dex */
public final class CompoundButtonCompat {

    /* renamed from: PlatformImplementations.kt_3 */
    private static Field f3167a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static boolean f3168b;

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: PlatformImplementations.kt_3 */
    public static void m3031a(CompoundButton compoundButton, ColorStateList colorStateList) {
        if (Build.VERSION.SDK_INT >= 21) {
            compoundButton.setButtonTintList(colorStateList);
        } else if (compoundButton instanceof TintableCompoundButton) {
            ((TintableCompoundButton) compoundButton).setSupportButtonTintList(colorStateList);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: PlatformImplementations.kt_3 */
    public static ColorStateList m3030a(CompoundButton compoundButton) {
        if (Build.VERSION.SDK_INT >= 21) {
            return compoundButton.getButtonTintList();
        }
        if (compoundButton instanceof TintableCompoundButton) {
            return ((TintableCompoundButton) compoundButton).getSupportButtonTintList();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: PlatformImplementations.kt_3 */
    public static void m3032a(CompoundButton compoundButton, PorterDuff.Mode mode) {
        if (Build.VERSION.SDK_INT >= 21) {
            compoundButton.setButtonTintMode(mode);
        } else if (compoundButton instanceof TintableCompoundButton) {
            ((TintableCompoundButton) compoundButton).setSupportButtonTintMode(mode);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static Drawable m3033b(CompoundButton compoundButton) {
        if (Build.VERSION.SDK_INT >= 23) {
            return compoundButton.getButtonDrawable();
        }
        if (!f3168b) {
            try {
                f3167a = CompoundButton.class.getDeclaredField("mButtonDrawable");
                f3167a.setAccessible(true);
            } catch (NoSuchFieldException COUIBaseListPopupWindow_8) {
                Log.OplusGLSurfaceView_13("CompoundButtonCompat", "Failed to retrieve mButtonDrawable field", COUIBaseListPopupWindow_8);
            }
            f3168b = true;
        }
        Field field = f3167a;
        if (field != null) {
            try {
                return (Drawable) field.get(compoundButton);
            } catch (IllegalAccessException e2) {
                Log.OplusGLSurfaceView_13("CompoundButtonCompat", "Failed to get button drawable via reflection", e2);
                f3167a = null;
            }
        }
        return null;
    }
}
