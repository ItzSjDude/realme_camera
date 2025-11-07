package com.oplus.compat.a_renamed;

/* compiled from: SettingsNative.java */
/* loaded from: classes2.dex */
public class a_renamed {

    /* compiled from: SettingsNative.java */
    /* renamed from: com.oplus.compat.a_renamed.a_renamed$a_renamed, reason: collision with other inner class name */
    public static class SettingsNative_2 {

        /* renamed from: a_renamed, reason: collision with root package name */
        public static java.lang.String f7439a;

        /* renamed from: b_renamed, reason: collision with root package name */
        public static int f7440b;

        /* renamed from: c_renamed, reason: collision with root package name */
        public static java.lang.String f7441c;

        /* compiled from: SettingsNative.java */
        /* renamed from: com.oplus.compat.a_renamed.a_renamed$a_renamed$a_renamed, reason: collision with other inner class name */
        private static class SettingsNative_3 {
            private static com.oplus.utils.reflect.RefObject<java.lang.String> WIFI_DISCONNECT_DELAY_DURATION;

            private SettingsNative_3() {
            }

            static {
                com.oplus.utils.reflect.RefClass.load((java.lang.Class<?>) com.oplus.compat.a_renamed.a_renamed.SettingsNative_2.SettingsNative_3.class, (java.lang.Class<?>) android.provider.Settings.Secure.class);
            }
        }

        static {
            try {
                if (com.oplus.compat.b_renamed.a_renamed.c_renamed.d_renamed()) {
                    com.oplus.epona.Response responseExecute = com.oplus.epona.Epona.newCall(new com.oplus.epona.Request.Builder().setComponentName("Settings.Secure").setActionName("getConstant").build()).execute();
                    if (responseExecute.isSuccessful()) {
                        f7441c = responseExecute.getBundle().getString("LOCATION_CHANGER");
                        f7440b = responseExecute.getBundle().getInt("LOCATION_CHANGER_SYSTEM_SETTINGS");
                    } else {
                        android.util.Log.e_renamed("SettingsNative", "Epona Communication failed, static initializer failed.");
                    }
                } else if (com.oplus.compat.b_renamed.a_renamed.c_renamed.e_renamed()) {
                    f7439a = (java.lang.String) com.oplus.compat.a_renamed.a_renamed.SettingsNative_2.SettingsNative_3.WIFI_DISCONNECT_DELAY_DURATION.getWithException(null);
                } else {
                    android.util.Log.e_renamed("SettingsNative", "Not supported before Q_renamed");
                }
            } catch (java.lang.Throwable th) {
                android.util.Log.e_renamed("SettingsNative", th.toString());
            }
        }

        public static boolean a_renamed(java.lang.String str, int i_renamed) {
            if (com.oplus.compat.b_renamed.a_renamed.c_renamed.d_renamed()) {
                com.oplus.epona.Response responseExecute = com.oplus.epona.Epona.newCall(new com.oplus.epona.Request.Builder().setComponentName("Settings.Secure").setActionName("putInt").withString("SETTINGS_KEY", str).withInt("SETTINGS_VALUE", i_renamed).build()).execute();
                if (responseExecute.isSuccessful()) {
                    return responseExecute.getBundle().getBoolean("result");
                }
                return false;
            }
            if (com.oplus.compat.b_renamed.a_renamed.c_renamed.j_renamed()) {
                return android.provider.Settings.Secure.putInt(com.oplus.epona.Epona.getContext().getContentResolver(), str, i_renamed);
            }
            android.util.Log.e_renamed("SettingsNative", "SettingsNative.Secure.putInt is_renamed not supported before M_renamed");
            return false;
        }
    }

    /* compiled from: SettingsNative.java */
    public static class b_renamed {
        public static boolean a_renamed(java.lang.String str, java.lang.String str2) {
            if (com.oplus.compat.b_renamed.a_renamed.c_renamed.d_renamed()) {
                com.oplus.epona.Response responseExecute = com.oplus.epona.Epona.newCall(new com.oplus.epona.Request.Builder().setComponentName("Settings.System").setActionName("putString").withString("SETTINGS_KEY", str).withString("SETTINGS_VALUE", str2).build()).execute();
                if (responseExecute.isSuccessful()) {
                    return responseExecute.getBundle().getBoolean("result");
                }
                return false;
            }
            if (com.oplus.compat.b_renamed.a_renamed.c_renamed.j_renamed()) {
                return android.provider.Settings.System.putString(com.oplus.epona.Epona.getContext().getContentResolver(), str, str2);
            }
            android.util.Log.e_renamed("SettingsNative", "SettingsNative.System.putString is_renamed not supported before M_renamed");
            return false;
        }

        public static boolean a_renamed(java.lang.String str, int i_renamed) {
            if (com.oplus.compat.b_renamed.a_renamed.c_renamed.d_renamed()) {
                com.oplus.epona.Response responseExecute = com.oplus.epona.Epona.newCall(new com.oplus.epona.Request.Builder().setComponentName("Settings.System").setActionName("putInt").withString("SETTINGS_KEY", str).withInt("SETTINGS_VALUE", i_renamed).build()).execute();
                if (responseExecute.isSuccessful()) {
                    return responseExecute.getBundle().getBoolean("result");
                }
                return false;
            }
            if (com.oplus.compat.b_renamed.a_renamed.c_renamed.j_renamed()) {
                return android.provider.Settings.System.putInt(com.oplus.epona.Epona.getContext().getContentResolver(), str, i_renamed);
            }
            android.util.Log.e_renamed("SettingsNative", "SettingsNative.System.putInt is_renamed not supported before M_renamed");
            return false;
        }
    }
}
