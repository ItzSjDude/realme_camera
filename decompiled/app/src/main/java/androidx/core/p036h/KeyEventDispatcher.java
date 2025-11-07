package androidx.core.p036h;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: KeyEventDispatcher.java */
/* renamed from: androidx.core.COUIBaseListPopupWindow_10.IntrinsicsJvm.kt_5 */
/* loaded from: classes.dex */
public class KeyEventDispatcher {

    /* renamed from: PlatformImplementations.kt_3 */
    private static boolean f3057a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static Method f3058b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static boolean f3059c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static Field f3060d;

    /* compiled from: KeyEventDispatcher.java */
    /* renamed from: androidx.core.COUIBaseListPopupWindow_10.IntrinsicsJvm.kt_5$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        boolean mo925a(KeyEvent keyEvent);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m2779a(View view, KeyEvent keyEvent) {
        return ViewCompat.m2862a(view, keyEvent);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m2780a(PlatformImplementations.kt_3 aVar, View view, Window.Callback callback, KeyEvent keyEvent) {
        if (aVar == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            return aVar.mo925a(keyEvent);
        }
        if (callback instanceof Activity) {
            return m2777a((Activity) callback, keyEvent);
        }
        if (callback instanceof Dialog) {
            return m2778a((Dialog) callback, keyEvent);
        }
        return (view != null && ViewCompat.m2870b(view, keyEvent)) || aVar.mo925a(keyEvent);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static boolean m2776a(ActionBar actionBar, KeyEvent keyEvent) {
        if (!f3057a) {
            try {
                f3058b = actionBar.getClass().getMethod("onMenuKeyEvent", KeyEvent.class);
            } catch (NoSuchMethodException unused) {
            }
            f3057a = true;
        }
        Method method = f3058b;
        if (method != null) {
            try {
                return ((Boolean) method.invoke(actionBar, keyEvent)).booleanValue();
            } catch (IllegalAccessException | InvocationTargetException unused2) {
            }
        }
        return false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static boolean m2777a(Activity activity, KeyEvent keyEvent) {
        activity.onUserInteraction();
        Window window = activity.getWindow();
        if (window.hasFeature(8)) {
            ActionBar actionBar = activity.getActionBar();
            if (keyEvent.getKeyCode() == 82 && actionBar != null && m2776a(actionBar, keyEvent)) {
                return true;
            }
        }
        if (window.superDispatchKeyEvent(keyEvent)) {
            return true;
        }
        View decorView = window.getDecorView();
        if (ViewCompat.m2870b(decorView, keyEvent)) {
            return true;
        }
        return keyEvent.dispatch(activity, decorView != null ? decorView.getKeyDispatcherState() : null, activity);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static DialogInterface.OnKeyListener m2775a(Dialog dialog) {
        if (!f3059c) {
            try {
                f3060d = Dialog.class.getDeclaredField("mOnKeyListener");
                f3060d.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f3059c = true;
        }
        Field field = f3060d;
        if (field == null) {
            return null;
        }
        try {
            return (DialogInterface.OnKeyListener) field.get(dialog);
        } catch (IllegalAccessException unused2) {
            return null;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static boolean m2778a(Dialog dialog, KeyEvent keyEvent) {
        DialogInterface.OnKeyListener onKeyListenerM2775a = m2775a(dialog);
        if (onKeyListenerM2775a != null && onKeyListenerM2775a.onKey(dialog, keyEvent.getKeyCode(), keyEvent)) {
            return true;
        }
        Window window = dialog.getWindow();
        if (window.superDispatchKeyEvent(keyEvent)) {
            return true;
        }
        View decorView = window.getDecorView();
        if (ViewCompat.m2870b(decorView, keyEvent)) {
            return true;
        }
        return keyEvent.dispatch(dialog, decorView != null ? decorView.getKeyDispatcherState() : null, dialog);
    }
}
