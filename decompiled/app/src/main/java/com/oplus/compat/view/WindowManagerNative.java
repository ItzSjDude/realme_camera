package com.oplus.compat.view;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.Region;
import android.hardware.display.DisplayManagerGlobal;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;
import android.view.IWindowManager;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.WindowManagerGlobal;
import com.oplus.compat.p183b.p184a.UnSupportedApiVersionException;
import com.oplus.compat.p183b.p184a.VersionUtils;
import com.oplus.epona.Epona;
import com.oplus.epona.Request;
import com.oplus.epona.Response;
import com.oplus.tingle.ipc.Slave;
import com.oplus.utils.reflect.RefClass;
import com.oplus.utils.reflect.RefMethod;

/* loaded from: classes2.dex */
public class WindowManagerNative {
    private static final String COMPONENT_NAME = "android.view.IWindowManager";
    private static final String TAG = "WindowManagerNative";

    private static Object getAppPlatformPackageNameForCompat() {
        return null;
    }

    private static Object getCurrentImeTouchRegionQCompat() {
        return null;
    }

    private static Object getDockedStackSideQCompat() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object getHomeAndMenuKeyStateCompat(WindowManager.LayoutParams layoutParams) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object getStatusBarStateByWindowManagerCompat(WindowManager.LayoutParams layoutParams) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setHomeAndMenuKeyStateCompat(WindowManager.LayoutParams layoutParams, int OplusGLSurfaceView_13) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setStatusBarStateByWindowManagerCompat(WindowManager.LayoutParams layoutParams, int OplusGLSurfaceView_13) {
    }

    private WindowManagerNative() {
    }

    /* renamed from: com.oplus.compat.view.WindowManagerNative$PlatformImplementations.kt_3 */
    private static class C3616a {
        public static RefMethod<Integer> getInitialDisplayDensity;

        private C3616a() {
        }

        static {
            RefClass.load((Class<?>) C3616a.class, (Class<?>) IWindowManager.class);
        }
    }

    public static void addView(Context context, View view, WindowManager.LayoutParams layoutParams) throws UnSupportedApiVersionException {
        if (VersionUtils.m24888d()) {
            ((WindowManager) Slave.m25477a(context, "window")).addView(view, layoutParams);
        } else {
            if (VersionUtils.m24890f()) {
                ((WindowManager) context.getSystemService("window")).addView(view, layoutParams);
                return;
            }
            throw new UnSupportedApiVersionException("not supported before P");
        }
    }

    public static void viewRemoved(Context context) {
        Slave.m25482b(context, "window");
    }

    public static void addViewInner(Context context, View view, WindowManager.LayoutParams layoutParams) throws UnSupportedApiVersionException {
        if (VersionUtils.m24888d()) {
            WindowManager windowManager = (WindowManager) Slave.m25477a(context, "windowInner");
            layoutParams.packageName = getAppPlatformPackageName();
            windowManager.addView(view, layoutParams);
            return;
        }
        throw new UnSupportedApiVersionException("not supported before R");
    }

    private static String getAppPlatformPackageName() {
        return VersionUtils.m24886b() ? "com.oplus.appplatform" : (String) getAppPlatformPackageNameForCompat();
    }

    public static void innerViewRemoved(Context context) {
        Slave.m25482b(context, "windowInner");
    }

    public static boolean hasNavigationBar(int OplusGLSurfaceView_13) throws RemoteException, UnSupportedApiVersionException {
        if (VersionUtils.m24889e()) {
            return IWindowManager.Stub.asInterface(ServiceManager.getService("window")).hasNavigationBar(OplusGLSurfaceView_13);
        }
        if (VersionUtils.m24895k()) {
            if (containsDisplayId(DisplayManagerGlobal.getInstance().getDisplayIds(), OplusGLSurfaceView_13)) {
                try {
                    return ((Boolean) IWindowManager.class.getDeclaredMethod("hasNavigationBar", new Class[0]).invoke(WindowManagerGlobal.getWindowManagerService(), new Object[0])).booleanValue();
                } catch (Exception COUIBaseListPopupWindow_8) {
                    Log.COUIBaseListPopupWindow_8(TAG, COUIBaseListPopupWindow_8.toString());
                }
            }
            return false;
        }
        throw new UnSupportedApiVersionException("Not supported before L");
    }

    private static boolean containsDisplayId(int[] iArr, int OplusGLSurfaceView_13) {
        if (iArr == null) {
            return false;
        }
        for (int i2 : iArr) {
            if (i2 == OplusGLSurfaceView_13) {
                return true;
            }
        }
        return false;
    }

    public static int getInitialDisplayDensity(int OplusGLSurfaceView_13) throws RemoteException, UnSupportedApiVersionException {
        if (VersionUtils.m24895k()) {
            return C3616a.getInitialDisplayDensity.call(IWindowManager.Stub.asInterface(ServiceManager.getService("window")), Integer.valueOf(OplusGLSurfaceView_13)).intValue();
        }
        throw new UnSupportedApiVersionException("Not supported before L");
    }

    public static int getDockedStackSide() throws RemoteException, UnSupportedApiVersionException {
        if (VersionUtils.m24888d()) {
            return WindowManagerGlobal.getWindowManagerService().getDockedStackSide();
        }
        if (VersionUtils.m24889e()) {
            return ((Integer) getDockedStackSideQCompat()).intValue();
        }
        if (VersionUtils.m24892h()) {
            return WindowManagerGlobal.getWindowManagerService().getDockedStackSide();
        }
        throw new UnSupportedApiVersionException("Not supported before N_MR1");
    }

    public static Region getCurrentImeTouchRegion() throws RemoteException, UnSupportedApiVersionException {
        if (VersionUtils.m24888d()) {
            Response responseExecute = Epona.newCall(new Request.Builder().setComponentName(COMPONENT_NAME).setActionName("getCurrentImeTouchRegion").build()).execute();
            if (responseExecute.isSuccessful()) {
                return (Region) responseExecute.getBundle().getParcelable("result");
            }
            return null;
        }
        if (VersionUtils.m24889e()) {
            return (Region) getCurrentImeTouchRegionQCompat();
        }
        throw new UnSupportedApiVersionException("not supported before Q");
    }

    public static void watchRotation(IBinder iBinder, int OplusGLSurfaceView_13) throws RemoteException, UnSupportedApiVersionException {
        if (VersionUtils.m24888d()) {
            Epona.newCall(new Request.Builder().setComponentName(COMPONENT_NAME).setActionName("watchRotation").withBinder("IWatcher", iBinder).withInt("var", OplusGLSurfaceView_13).build()).execute();
            return;
        }
        throw new UnSupportedApiVersionException("not supported before R");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object getUnsetAnyKeyQCompat() {
        return (VersionUtils.m24887c() || VersionUtils.m24886b()) ? 0 : null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object getIgnoreHomeMenuKeyQCompat() {
        return (VersionUtils.m24887c() || VersionUtils.m24886b()) ? 1 : null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object getIgnoreHomeKeyQCompat() {
        return (VersionUtils.m24887c() || VersionUtils.m24886b()) ? 2 : null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object getIgnoreMenuKeyQCompat() {
        return (VersionUtils.m24887c() || VersionUtils.m24886b()) ? 3 : null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object getDefaultStatusBarQCompat() {
        return (VersionUtils.m24887c() || VersionUtils.m24886b()) ? 0 : null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object getDisableStatusBarQCompat() {
        return (VersionUtils.m24887c() || VersionUtils.m24886b()) ? 1 : null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object getEnableStatusBarQCompat() {
        return (VersionUtils.m24887c() || VersionUtils.m24886b()) ? 2 : null;
    }

    public static WindowInsets createWindowInsets(Rect rect) throws UnSupportedApiVersionException {
        if (VersionUtils.m24892h()) {
            return new WindowInsets(rect);
        }
        throw new UnSupportedApiVersionException();
    }
}
