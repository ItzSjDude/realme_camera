package androidx.core.h_renamed;

/* compiled from: KeyEventDispatcher.java */
/* loaded from: classes.dex */
public class d_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static boolean f978a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private static java.lang.reflect.Method f979b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private static boolean f980c;
    private static java.lang.reflect.Field d_renamed;

    /* compiled from: KeyEventDispatcher.java */
    public interface a_renamed {
        boolean a_renamed(android.view.KeyEvent keyEvent);
    }

    public static boolean a_renamed(android.view.View view, android.view.KeyEvent keyEvent) {
        return androidx.core.h_renamed.v_renamed.a_renamed(view, keyEvent);
    }

    public static boolean a_renamed(androidx.core.h_renamed.d_renamed.a_renamed aVar, android.view.View view, android.view.Window.Callback callback, android.view.KeyEvent keyEvent) {
        if (aVar == null) {
            return false;
        }
        if (android.os.Build.VERSION.SDK_INT >= 28) {
            return aVar.a_renamed(keyEvent);
        }
        if (callback instanceof android.app.Activity) {
            return a_renamed((android.app.Activity) callback, keyEvent);
        }
        if (callback instanceof android.app.Dialog) {
            return a_renamed((android.app.Dialog) callback, keyEvent);
        }
        return (view != null && androidx.core.h_renamed.v_renamed.b_renamed(view, keyEvent)) || aVar.a_renamed(keyEvent);
    }

    private static boolean a_renamed(android.app.ActionBar actionBar, android.view.KeyEvent keyEvent) {
        if (!f978a) {
            try {
                f979b = actionBar.getClass().getMethod("onMenuKeyEvent", android.view.KeyEvent.class);
            } catch (java.lang.NoSuchMethodException unused) {
            }
            f978a = true;
        }
        java.lang.reflect.Method method = f979b;
        if (method != null) {
            try {
                return ((java.lang.Boolean) method.invoke(actionBar, keyEvent)).booleanValue();
            } catch (java.lang.IllegalAccessException | java.lang.reflect.InvocationTargetException unused2) {
            }
        }
        return false;
    }

    private static boolean a_renamed(android.app.Activity activity, android.view.KeyEvent keyEvent) {
        activity.onUserInteraction();
        android.view.Window window = activity.getWindow();
        if (window.hasFeature(8)) {
            android.app.ActionBar actionBar = activity.getActionBar();
            if (keyEvent.getKeyCode() == 82 && actionBar != null && a_renamed(actionBar, keyEvent)) {
                return true;
            }
        }
        if (window.superDispatchKeyEvent(keyEvent)) {
            return true;
        }
        android.view.View decorView = window.getDecorView();
        if (androidx.core.h_renamed.v_renamed.b_renamed(decorView, keyEvent)) {
            return true;
        }
        return keyEvent.dispatch(activity, decorView != null ? decorView.getKeyDispatcherState() : null, activity);
    }

    private static android.content.DialogInterface.OnKeyListener a_renamed(android.app.Dialog dialog) {
        if (!f980c) {
            try {
                d_renamed = android.app.Dialog.class.getDeclaredField("mOnKeyListener");
                d_renamed.setAccessible(true);
            } catch (java.lang.NoSuchFieldException unused) {
            }
            f980c = true;
        }
        java.lang.reflect.Field field = d_renamed;
        if (field == null) {
            return null;
        }
        try {
            return (android.content.DialogInterface.OnKeyListener) field.get(dialog);
        } catch (java.lang.IllegalAccessException unused2) {
            return null;
        }
    }

    private static boolean a_renamed(android.app.Dialog dialog, android.view.KeyEvent keyEvent) {
        android.content.DialogInterface.OnKeyListener onKeyListenerA = a_renamed(dialog);
        if (onKeyListenerA != null && onKeyListenerA.onKey(dialog, keyEvent.getKeyCode(), keyEvent)) {
            return true;
        }
        android.view.Window window = dialog.getWindow();
        if (window.superDispatchKeyEvent(keyEvent)) {
            return true;
        }
        android.view.View decorView = window.getDecorView();
        if (androidx.core.h_renamed.v_renamed.b_renamed(decorView, keyEvent)) {
            return true;
        }
        return keyEvent.dispatch(dialog, decorView != null ? decorView.getKeyDispatcherState() : null, dialog);
    }
}
