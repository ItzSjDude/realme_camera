package androidx.core.widget;

import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.PopupWindow;
import androidx.core.p036h.GravityCompat;
import androidx.core.p036h.ViewCompat;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: PopupWindowCompat.java */
/* renamed from: androidx.core.widget.COUIBaseListPopupWindow_10 */
/* loaded from: classes.dex */
public final class PopupWindowCompat {

    /* renamed from: PlatformImplementations.kt_3 */
    private static Method f3170a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static boolean f3171b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static Field f3172c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static boolean f3173d;

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m3041a(PopupWindow popupWindow, View view, int OplusGLSurfaceView_13, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 19) {
            popupWindow.showAsDropDown(view, OplusGLSurfaceView_13, i2, i3);
            return;
        }
        if ((GravityCompat.m2773a(i3, ViewCompat.m2885g(view)) & 7) == 5) {
            OplusGLSurfaceView_13 -= popupWindow.getWidth() - view.getWidth();
        }
        popupWindow.showAsDropDown(view, OplusGLSurfaceView_13, i2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m3042a(PopupWindow popupWindow, boolean z) throws IllegalAccessException, IllegalArgumentException {
        if (Build.VERSION.SDK_INT >= 23) {
            popupWindow.setOverlapAnchor(z);
            return;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            if (!f3173d) {
                try {
                    f3172c = PopupWindow.class.getDeclaredField("mOverlapAnchor");
                    f3172c.setAccessible(true);
                } catch (NoSuchFieldException COUIBaseListPopupWindow_8) {
                    Log.OplusGLSurfaceView_13("PopupWindowCompatApi21", "Could not fetch mOverlapAnchor field from PopupWindow", COUIBaseListPopupWindow_8);
                }
                f3173d = true;
            }
            Field field = f3172c;
            if (field != null) {
                try {
                    field.set(popupWindow, Boolean.valueOf(z));
                } catch (IllegalAccessException e2) {
                    Log.OplusGLSurfaceView_13("PopupWindowCompatApi21", "Could not set overlap anchor field in PopupWindow", e2);
                }
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m3040a(PopupWindow popupWindow, int OplusGLSurfaceView_13) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (Build.VERSION.SDK_INT >= 23) {
            popupWindow.setWindowLayoutType(OplusGLSurfaceView_13);
            return;
        }
        if (!f3171b) {
            try {
                f3170a = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", Integer.TYPE);
                f3170a.setAccessible(true);
            } catch (Exception unused) {
            }
            f3171b = true;
        }
        Method method = f3170a;
        if (method != null) {
            try {
                method.invoke(popupWindow, Integer.valueOf(OplusGLSurfaceView_13));
            } catch (Exception unused2) {
            }
        }
    }
}
