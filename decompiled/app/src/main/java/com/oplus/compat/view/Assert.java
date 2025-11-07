package com.oplus.compat.view;

/* loaded from: classes2.dex */
public class WindowManagerNative {
    private static final java.lang.String COMPONENT_NAME = "android.view.IWindowManager";
    private static final java.lang.String TAG = "WindowManagerNative";

    private static java.lang.Object getAppPlatformPackageNameForCompat() {
        return null;
    }

    private static java.lang.Object getCurrentImeTouchRegionQCompat() {
        return null;
    }

    private static java.lang.Object getDockedStackSideQCompat() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.lang.Object getHomeAndMenuKeyStateCompat(android.view.WindowManager.LayoutParams layoutParams) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.lang.Object getStatusBarStateByWindowManagerCompat(android.view.WindowManager.LayoutParams layoutParams) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setHomeAndMenuKeyStateCompat(android.view.WindowManager.LayoutParams layoutParams, int i_renamed) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setStatusBarStateByWindowManagerCompat(android.view.WindowManager.LayoutParams layoutParams, int i_renamed) {
    }

    private WindowManagerNative() {
    }

    private static class a_renamed {
        public static com.oplus.utils.reflect.RefMethod<java.lang.Integer> getInitialDisplayDensity;

        private a_renamed() {
        }

        static {
            com.oplus.utils.reflect.RefClass.load((java.lang.Class<?>) com.oplus.compat.view.WindowManagerNative.a_renamed.class, (java.lang.Class<?>) android.view.IWindowManager.class);
        }
    }

    public static void addView(android.content.Context context, android.view.View view, android.view.WindowManager.LayoutParams layoutParams) throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.d_renamed()) {
            ((android.view.WindowManager) com.oplus.tingle.ipc.b_renamed.a_renamed(context, "window")).addView(view, layoutParams);
        } else {
            if (com.oplus.compat.b_renamed.a_renamed.c_renamed.f_renamed()) {
                ((android.view.WindowManager) context.getSystemService("window")).addView(view, layoutParams);
                return;
            }
            throw new com.oplus.compat.b_renamed.a_renamed.b_renamed("not supported before P_renamed");
        }
    }

    public static void viewRemoved(android.content.Context context) {
        com.oplus.tingle.ipc.b_renamed.b_renamed(context, "window");
    }

    public static void addViewInner(android.content.Context context, android.view.View view, android.view.WindowManager.LayoutParams layoutParams) throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.d_renamed()) {
            android.view.WindowManager windowManager = (android.view.WindowManager) com.oplus.tingle.ipc.b_renamed.a_renamed(context, "windowInner");
            layoutParams.packageName = getAppPlatformPackageName();
            windowManager.addView(view, layoutParams);
            return;
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed("not supported before R_renamed");
    }

    private static java.lang.String getAppPlatformPackageName() {
        return com.oplus.compat.b_renamed.a_renamed.c_renamed.b_renamed() ? "com.oplus.appplatform" : (java.lang.String) getAppPlatformPackageNameForCompat();
    }

    public static void innerViewRemoved(android.content.Context context) {
        com.oplus.tingle.ipc.b_renamed.b_renamed(context, "windowInner");
    }

    public static boolean hasNavigationBar(int i_renamed) throws android.os.RemoteException, com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.e_renamed()) {
            return android.view.IWindowManager.Stub.asInterface(android.os.ServiceManager.getService("window")).hasNavigationBar(i_renamed);
        }
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.k_renamed()) {
            if (containsDisplayId(android.hardware.display.DisplayManagerGlobal.getInstance().getDisplayIds(), i_renamed)) {
                try {
                    return ((java.lang.Boolean) android.view.IWindowManager.class.getDeclaredMethod("hasNavigationBar", new java.lang.Class[0]).invoke(android.view.WindowManagerGlobal.getWindowManagerService(), new java.lang.Object[0])).booleanValue();
                } catch (java.lang.Exception e_renamed) {
                    android.util.Log.e_renamed(TAG, e_renamed.toString());
                }
            }
            return false;
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed("Not supported before L_renamed");
    }

    private static boolean containsDisplayId(int[] iArr, int i_renamed) {
        if (iArr == null) {
            return false;
        }
        for (int i2 : iArr) {
            if (i2 == i_renamed) {
                return true;
            }
        }
        return false;
    }

    public static int getInitialDisplayDensity(int i_renamed) throws android.os.RemoteException, com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.k_renamed()) {
            return com.oplus.compat.view.WindowManagerNative.a_renamed.getInitialDisplayDensity.call(android.view.IWindowManager.Stub.asInterface(android.os.ServiceManager.getService("window")), java.lang.Integer.valueOf(i_renamed)).intValue();
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed("Not supported before L_renamed");
    }

    public static int getDockedStackSide() throws android.os.RemoteException, com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.d_renamed()) {
            return android.view.WindowManagerGlobal.getWindowManagerService().getDockedStackSide();
        }
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.e_renamed()) {
            return ((java.lang.Integer) getDockedStackSideQCompat()).intValue();
        }
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.h_renamed()) {
            return android.view.WindowManagerGlobal.getWindowManagerService().getDockedStackSide();
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed("Not supported before N_MR1");
    }

    public static android.graphics.Region getCurrentImeTouchRegion() throws android.os.RemoteException, com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.d_renamed()) {
            com.oplus.epona.Response responseExecute = com.oplus.epona.Epona.newCall(new com.oplus.epona.Request.Builder().setComponentName(COMPONENT_NAME).setActionName("getCurrentImeTouchRegion").build()).execute();
            if (responseExecute.isSuccessful()) {
                return (android.graphics.Region) responseExecute.getBundle().getParcelable("result");
            }
            return null;
        }
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.e_renamed()) {
            return (android.graphics.Region) getCurrentImeTouchRegionQCompat();
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed("not supported before Q_renamed");
    }

    public static void watchRotation(android.os.IBinder iBinder, int i_renamed) throws android.os.RemoteException, com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.d_renamed()) {
            com.oplus.epona.Epona.newCall(new com.oplus.epona.Request.Builder().setComponentName(COMPONENT_NAME).setActionName("watchRotation").withBinder("IWatcher", iBinder).withInt("var", i_renamed).build()).execute();
            return;
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed("not supported before R_renamed");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.lang.Object getUnsetAnyKeyQCompat() {
        return (com.oplus.compat.b_renamed.a_renamed.c_renamed.c_renamed() || com.oplus.compat.b_renamed.a_renamed.c_renamed.b_renamed()) ? 0 : null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.lang.Object getIgnoreHomeMenuKeyQCompat() {
        return (com.oplus.compat.b_renamed.a_renamed.c_renamed.c_renamed() || com.oplus.compat.b_renamed.a_renamed.c_renamed.b_renamed()) ? 1 : null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.lang.Object getIgnoreHomeKeyQCompat() {
        return (com.oplus.compat.b_renamed.a_renamed.c_renamed.c_renamed() || com.oplus.compat.b_renamed.a_renamed.c_renamed.b_renamed()) ? 2 : null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.lang.Object getIgnoreMenuKeyQCompat() {
        return (com.oplus.compat.b_renamed.a_renamed.c_renamed.c_renamed() || com.oplus.compat.b_renamed.a_renamed.c_renamed.b_renamed()) ? 3 : null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.lang.Object getDefaultStatusBarQCompat() {
        return (com.oplus.compat.b_renamed.a_renamed.c_renamed.c_renamed() || com.oplus.compat.b_renamed.a_renamed.c_renamed.b_renamed()) ? 0 : null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.lang.Object getDisableStatusBarQCompat() {
        return (com.oplus.compat.b_renamed.a_renamed.c_renamed.c_renamed() || com.oplus.compat.b_renamed.a_renamed.c_renamed.b_renamed()) ? 1 : null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.lang.Object getEnableStatusBarQCompat() {
        return (com.oplus.compat.b_renamed.a_renamed.c_renamed.c_renamed() || com.oplus.compat.b_renamed.a_renamed.c_renamed.b_renamed()) ? 2 : null;
    }

    public static android.view.WindowInsets createWindowInsets(android.graphics.Rect rect) throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.h_renamed()) {
            return new android.view.WindowInsets(rect);
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed();
    }
}
