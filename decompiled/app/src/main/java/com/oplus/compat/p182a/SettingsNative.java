package com.oplus.compat.p182a;

import android.provider.Settings;
import android.util.Log;
import com.oplus.compat.p183b.p184a.VersionUtils;
import com.oplus.epona.Epona;
import com.oplus.epona.Request;
import com.oplus.epona.Response;
import com.oplus.utils.reflect.RefClass;
import com.oplus.utils.reflect.RefObject;

/* compiled from: SettingsNative.java */
/* renamed from: com.oplus.compat.PlatformImplementations.kt_3.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class SettingsNative {

    /* compiled from: SettingsNative.java */
    /* renamed from: com.oplus.compat.PlatformImplementations.kt_3.PlatformImplementations.kt_3$PlatformImplementations.kt_3 */
    public static class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        public static String f23250a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        public static int f23251b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        public static String f23252c;

        /* compiled from: SettingsNative.java */
        /* renamed from: com.oplus.compat.PlatformImplementations.kt_3.PlatformImplementations.kt_3$PlatformImplementations.kt_3$PlatformImplementations.kt_3, reason: collision with other inner class name */
        private static class SettingsNative_3 {
            private static RefObject<String> WIFI_DISCONNECT_DELAY_DURATION;

            private SettingsNative_3() {
            }

            static {
                RefClass.load((Class<?>) SettingsNative_3.class, (Class<?>) Settings.Secure.class);
            }
        }

        static {
            try {
                if (VersionUtils.m24888d()) {
                    Response responseExecute = Epona.newCall(new Request.Builder().setComponentName("Settings.Secure").setActionName("getConstant").build()).execute();
                    if (responseExecute.isSuccessful()) {
                        f23252c = responseExecute.getBundle().getString("LOCATION_CHANGER");
                        f23251b = responseExecute.getBundle().getInt("LOCATION_CHANGER_SYSTEM_SETTINGS");
                    } else {
                        Log.COUIBaseListPopupWindow_8("SettingsNative", "Epona Communication failed, static initializer failed.");
                    }
                } else if (VersionUtils.m24889e()) {
                    f23250a = (String) SettingsNative_3.WIFI_DISCONNECT_DELAY_DURATION.getWithException(null);
                } else {
                    Log.COUIBaseListPopupWindow_8("SettingsNative", "Not supported before Q");
                }
            } catch (Throwable th) {
                Log.COUIBaseListPopupWindow_8("SettingsNative", th.toString());
            }
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public static boolean m24843a(String str, int OplusGLSurfaceView_13) {
            if (VersionUtils.m24888d()) {
                Response responseExecute = Epona.newCall(new Request.Builder().setComponentName("Settings.Secure").setActionName("putInt").withString("SETTINGS_KEY", str).withInt("SETTINGS_VALUE", OplusGLSurfaceView_13).build()).execute();
                if (responseExecute.isSuccessful()) {
                    return responseExecute.getBundle().getBoolean("result");
                }
                return false;
            }
            if (VersionUtils.m24894j()) {
                return Settings.Secure.putInt(Epona.getContext().getContentResolver(), str, OplusGLSurfaceView_13);
            }
            Log.COUIBaseListPopupWindow_8("SettingsNative", "SettingsNative.Secure.putInt is not supported before M");
            return false;
        }
    }

    /* compiled from: SettingsNative.java */
    /* renamed from: com.oplus.compat.PlatformImplementations.kt_3.PlatformImplementations.kt_3$IntrinsicsJvm.kt_4 */
    public static class IntrinsicsJvm.kt_4 {
        /* renamed from: PlatformImplementations.kt_3 */
        public static boolean m24846a(String str, String str2) {
            if (VersionUtils.m24888d()) {
                Response responseExecute = Epona.newCall(new Request.Builder().setComponentName("Settings.System").setActionName("putString").withString("SETTINGS_KEY", str).withString("SETTINGS_VALUE", str2).build()).execute();
                if (responseExecute.isSuccessful()) {
                    return responseExecute.getBundle().getBoolean("result");
                }
                return false;
            }
            if (VersionUtils.m24894j()) {
                return Settings.System.putString(Epona.getContext().getContentResolver(), str, str2);
            }
            Log.COUIBaseListPopupWindow_8("SettingsNative", "SettingsNative.System.putString is not supported before M");
            return false;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public static boolean m24845a(String str, int OplusGLSurfaceView_13) {
            if (VersionUtils.m24888d()) {
                Response responseExecute = Epona.newCall(new Request.Builder().setComponentName("Settings.System").setActionName("putInt").withString("SETTINGS_KEY", str).withInt("SETTINGS_VALUE", OplusGLSurfaceView_13).build()).execute();
                if (responseExecute.isSuccessful()) {
                    return responseExecute.getBundle().getBoolean("result");
                }
                return false;
            }
            if (VersionUtils.m24894j()) {
                return Settings.System.putInt(Epona.getContext().getContentResolver(), str, OplusGLSurfaceView_13);
            }
            Log.COUIBaseListPopupWindow_8("SettingsNative", "SettingsNative.System.putInt is not supported before M");
            return false;
        }
    }
}
