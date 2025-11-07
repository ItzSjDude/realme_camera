package androidx.core.p036h;

import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import java.lang.reflect.Field;

/* compiled from: LayoutInflaterCompat.java */
/* renamed from: androidx.core.COUIBaseListPopupWindow_10.COUIBaseListPopupWindow_8 */
/* loaded from: classes.dex */
public final class LayoutInflaterCompat {

    /* renamed from: PlatformImplementations.kt_3 */
    private static Field f3061a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static boolean f3062b;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static void m2782b(LayoutInflater layoutInflater, LayoutInflater.Factory2 factory2) throws IllegalAccessException, IllegalArgumentException {
        if (!f3062b) {
            try {
                f3061a = LayoutInflater.class.getDeclaredField("mFactory2");
                f3061a.setAccessible(true);
            } catch (NoSuchFieldException COUIBaseListPopupWindow_8) {
                Log.COUIBaseListPopupWindow_8("LayoutInflaterCompatHC", "forceSetFactory2 Could not find field 'mFactory2' on class " + LayoutInflater.class.getName() + "; inflation may have unexpected results.", COUIBaseListPopupWindow_8);
            }
            f3062b = true;
        }
        Field field = f3061a;
        if (field != null) {
            try {
                field.set(layoutInflater, factory2);
            } catch (IllegalAccessException e2) {
                Log.COUIBaseListPopupWindow_8("LayoutInflaterCompatHC", "forceSetFactory2 could not set the Factory2 on LayoutInflater " + layoutInflater + "; inflation may have unexpected results.", e2);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m2781a(LayoutInflater layoutInflater, LayoutInflater.Factory2 factory2) throws IllegalAccessException, IllegalArgumentException {
        layoutInflater.setFactory2(factory2);
        if (Build.VERSION.SDK_INT < 21) {
            LayoutInflater.Factory factory = layoutInflater.getFactory();
            if (factory instanceof LayoutInflater.Factory2) {
                m2782b(layoutInflater, (LayoutInflater.Factory2) factory);
            } else {
                m2782b(layoutInflater, factory2);
            }
        }
    }
}
