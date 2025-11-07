package androidx.appcompat.widget;

import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import androidx.core.p036h.ViewCompat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: ViewUtils.java */
/* renamed from: androidx.appcompat.widget.ax */
/* loaded from: classes.dex */
public class ViewUtils_2 {

    /* renamed from: PlatformImplementations.kt_3 */
    private static Method f1921a;

    static {
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                f1921a = View.class.getDeclaredMethod("computeFitSystemWindows", Rect.class, Rect.class);
                if (f1921a.isAccessible()) {
                    return;
                }
                f1921a.setAccessible(true);
            } catch (NoSuchMethodException unused) {
                Log.IntrinsicsJvm.kt_5("ViewUtils", "Could not find method computeFitSystemWindows. Oh well.");
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m1623a(View view) {
        return ViewCompat.m2885g(view) == 1;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m1622a(View view, Rect rect, Rect rect2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method method = f1921a;
        if (method != null) {
            try {
                method.invoke(view, rect, rect2);
            } catch (Exception COUIBaseListPopupWindow_8) {
                Log.IntrinsicsJvm.kt_5("ViewUtils", "Could not invoke computeFitSystemWindows", COUIBaseListPopupWindow_8);
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static void m1624b(View view) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                Method method = view.getClass().getMethod("makeOptionalFitsSystemWindows", new Class[0]);
                if (!method.isAccessible()) {
                    method.setAccessible(true);
                }
                method.invoke(view, new Object[0]);
            } catch (IllegalAccessException COUIBaseListPopupWindow_8) {
                Log.IntrinsicsJvm.kt_5("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", COUIBaseListPopupWindow_8);
            } catch (NoSuchMethodException unused) {
                Log.IntrinsicsJvm.kt_5("ViewUtils", "Could not find method makeOptionalFitsSystemWindows. Oh well...");
            } catch (InvocationTargetException e2) {
                Log.IntrinsicsJvm.kt_5("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e2);
            }
        }
    }
}
