package com.oplus.camera.util;

import android.app.OplusActivityManager;
import com.oplus.camera.CameraLog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: DeviceUtil.java */
/* renamed from: com.oplus.camera.util.COUIBaseListPopupWindow_8 */
/* loaded from: classes2.dex */
public class DeviceUtil {

    /* renamed from: PlatformImplementations.kt_3 */
    private static Method f23062a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static long f23063b;

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m24533a(int OplusGLSurfaceView_13, boolean z, long OplusGLSurfaceView_15) {
        CameraLog.m12959b("DeviceUtil", "requestDeviceFolded, status: " + OplusGLSurfaceView_13 + ", enableSecDisplay: " + z + ", seq: " + OplusGLSurfaceView_15);
        if (OplusGLSurfaceView_15 < f23063b) {
            CameraLog.m12959b("DeviceUtil", "requestDeviceFolded, dirty call");
            return;
        }
        f23063b = OplusGLSurfaceView_15;
        OplusActivityManager oplusActivityManager = new OplusActivityManager();
        if (f23062a == null) {
            try {
                f23062a = oplusActivityManager.getClass().getDeclaredMethod("requestDeviceFolded", Integer.TYPE, Boolean.TYPE);
                f23062a.setAccessible(true);
            } catch (NoSuchMethodException COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
            }
        }
        Method method = f23062a;
        if (method != null) {
            try {
                CameraLog.m12959b("DeviceUtil", "requestDeviceFolded, result: " + ((Boolean) method.invoke(oplusActivityManager, Integer.valueOf(OplusGLSurfaceView_13), Boolean.valueOf(z))));
                return;
            } catch (IllegalAccessException | InvocationTargetException e2) {
                e2.printStackTrace();
                CameraLog.m12959b("DeviceUtil", "requestDeviceFolded, exception: " + e2.getMessage());
                return;
            }
        }
        CameraLog.m12959b("DeviceUtil", "requestDeviceFolded, method null");
    }
}
