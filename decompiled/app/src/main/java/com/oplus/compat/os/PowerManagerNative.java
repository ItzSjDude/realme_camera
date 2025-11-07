package com.oplus.compat.os;

/* loaded from: classes2.dex */
public class PowerManagerNative {
    private static final java.lang.String COMPONENT_NAME = "android.os.PowerManager";
    private static final java.lang.String RESULT = "result";
    private static final java.lang.String TAG = "PowerManagerNative";

    private static java.lang.Object getDisplayAodStatusCompat(android.os.PowerManager powerManager) {
        return null;
    }

    private static java.lang.Object getMaximumScreenBrightnessSettingQCompat(android.os.PowerManager powerManager) {
        return null;
    }

    private static java.lang.Object getMinimumScreenBrightnessSettingQCompat(android.os.PowerManager powerManager) {
        return null;
    }

    private static java.lang.Object getWakeLockedUidsQCompat(android.os.PowerManager powerManager) {
        return null;
    }

    private static void goToSleepQCompat(android.os.PowerManager powerManager, long j_renamed) {
    }

    private static void wakeUpCompat(android.os.PowerManager powerManager, long j_renamed, java.lang.String str) {
    }

    private static class ReflectInfo {
        private static com.oplus.utils.reflect.RefMethod<java.lang.Boolean> getDisplayAodStatus;

        private ReflectInfo() {
        }

        static {
            com.oplus.utils.reflect.RefClass.load((java.lang.Class<?>) com.oplus.compat.os.PowerManagerNative.ReflectInfo.class, (java.lang.Class<?>) android.os.PowerManager.class);
        }
    }

    private static class RefPowerManagerInfo {
        private static com.oplus.utils.reflect.RefMethod<java.lang.Boolean> getDisplayAodStatus;

        private RefPowerManagerInfo() {
        }

        static {
            com.oplus.utils.reflect.RefClass.load((java.lang.Class<?>) com.oplus.compat.os.PowerManagerNative.RefPowerManagerInfo.class, (java.lang.Class<?>) android.os.OplusPowerManager.class);
        }
    }

    private PowerManagerNative() {
    }

    public static int getMaximumScreenBrightnessSetting(android.os.PowerManager powerManager) throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.i_renamed()) {
            return powerManager.getMaximumScreenBrightnessSetting();
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed("not supported before N_renamed");
    }

    public static int getMinimumScreenBrightnessSetting(android.os.PowerManager powerManager) throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.i_renamed()) {
            return powerManager.getMinimumScreenBrightnessSetting();
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed("not supported before N_renamed");
    }

    public static void wakeUp(android.os.PowerManager powerManager, long j_renamed, java.lang.String str) throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.c_renamed()) {
            powerManager.wakeUp(j_renamed, str);
        } else if (com.oplus.compat.b_renamed.a_renamed.c_renamed.b_renamed()) {
            com.oplus.inner.os.PowerManagerWrapper.wakeUp(powerManager, j_renamed, str);
        } else {
            if (com.oplus.compat.b_renamed.a_renamed.c_renamed.e_renamed()) {
                wakeUpCompat(powerManager, j_renamed, str);
                return;
            }
            throw new com.oplus.compat.b_renamed.a_renamed.b_renamed();
        }
    }

    public static boolean getDisplayAodStatus(android.os.PowerManager powerManager) throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.c_renamed()) {
            return ((java.lang.Boolean) com.oplus.compat.os.PowerManagerNative.RefPowerManagerInfo.getDisplayAodStatus.call(new android.os.OplusPowerManager(), new java.lang.Object[0])).booleanValue();
        }
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.b_renamed()) {
            return com.oplus.inner.os.PowerManagerWrapper.getDisplayAodStatus(powerManager);
        }
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.e_renamed()) {
            return ((java.lang.Boolean) getDisplayAodStatusCompat(powerManager)).booleanValue();
        }
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.i_renamed()) {
            return ((java.lang.Boolean) com.oplus.compat.os.PowerManagerNative.ReflectInfo.getDisplayAodStatus.call(powerManager, new java.lang.Object[0])).booleanValue();
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed();
    }

    @java.lang.Deprecated(forRemoval = true)
    public static int getRealMaximumScreenBrightnessSetting() throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.e_renamed()) {
            return ((android.os.PowerManager) com.oplus.epona.Epona.getContext().getSystemService("power")).getMaximumScreenBrightnessSetting();
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed("not supported before Q_renamed");
    }

    @java.lang.Deprecated(forRemoval = true)
    public static int getRealMinimumScreenBrightnessSetting() throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.e_renamed()) {
            return ((android.os.PowerManager) com.oplus.epona.Epona.getContext().getSystemService("power")).getMinimumScreenBrightnessSetting();
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed("not supported before Q_renamed");
    }

    public static int[] getWakeLockedUids(android.os.PowerManager powerManager) throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.d_renamed()) {
            throw new com.oplus.compat.b_renamed.a_renamed.b_renamed("not supported in_renamed R_renamed because of_renamed not exist");
        }
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.e_renamed()) {
            return (int[]) getWakeLockedUidsQCompat(powerManager);
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed();
    }

    public static int getDefaultScreenBrightnessSetting(android.os.PowerManager powerManager) throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.d_renamed()) {
            return powerManager.getDefaultScreenBrightnessSetting();
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed("Not supported before R_renamed");
    }

    public static void shutdown(boolean z_renamed, java.lang.String str, boolean z2) throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.d_renamed()) {
            com.oplus.epona.Response responseExecute = com.oplus.epona.Epona.newCall(new com.oplus.epona.Request.Builder().setComponentName(COMPONENT_NAME).setActionName("shutdown").withBoolean("confirm", z_renamed).withString("reason", str).withBoolean("wait", z2).build()).execute();
            if (responseExecute.isSuccessful()) {
                return;
            }
            android.util.Log.e_renamed(TAG, "response code error:" + responseExecute.getMessage());
            return;
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed("not supported before R_renamed");
    }

    public static void reboot(android.content.Context context, java.lang.String str) throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.d_renamed()) {
            com.oplus.epona.Response responseExecute = com.oplus.epona.Epona.newCall(new com.oplus.epona.Request.Builder().setComponentName(COMPONENT_NAME).setActionName("reboot").withString("reason", str).build()).execute();
            if (responseExecute.isSuccessful()) {
                return;
            }
            android.util.Log.e_renamed(TAG, responseExecute.getMessage());
            return;
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed("not supported befor R_renamed");
    }

    public static boolean setPowerSaveModeEnabled(android.content.Context context, boolean z_renamed) throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.d_renamed()) {
            com.oplus.epona.Response responseExecute = com.oplus.epona.Epona.newCall(new com.oplus.epona.Request.Builder().setComponentName(COMPONENT_NAME).setActionName("setPowerSaveModeEnabled").withBoolean("mode", z_renamed).build()).execute();
            if (responseExecute.isSuccessful()) {
                return responseExecute.getBundle().getBoolean(RESULT);
            }
            return false;
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed("not supported before R_renamed");
    }

    public static android.os.PowerSaveState getPowerSaveState(int i_renamed) throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.d_renamed()) {
            com.oplus.epona.Response responseExecute = com.oplus.epona.Epona.newCall(new com.oplus.epona.Request.Builder().setComponentName(COMPONENT_NAME).setActionName("getPowerSaveState").withInt("serviceType", i_renamed).build()).execute();
            if (responseExecute.isSuccessful()) {
                return responseExecute.getBundle().getParcelable(RESULT);
            }
            android.util.Log.e_renamed(TAG, "response code error:" + responseExecute.getMessage());
            return null;
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed("Not Supported Before R_renamed");
    }

    public static void goToSleep(long j_renamed) throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        android.os.PowerManager powerManager = (android.os.PowerManager) com.oplus.epona.Epona.getContext().getSystemService("power");
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.d_renamed()) {
            com.oplus.epona.Epona.newCall(new com.oplus.epona.Request.Builder().setComponentName(COMPONENT_NAME).setActionName("goToSleep").withLong("time", j_renamed).build()).execute();
        } else if (com.oplus.compat.b_renamed.a_renamed.c_renamed.e_renamed()) {
            goToSleepQCompat(powerManager, j_renamed);
        } else {
            if (com.oplus.compat.b_renamed.a_renamed.c_renamed.f_renamed()) {
                powerManager.goToSleep(j_renamed);
                return;
            }
            throw new com.oplus.compat.b_renamed.a_renamed.b_renamed("not supported before R_renamed");
        }
    }

    public static int getLastSleepReason() throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.c_renamed()) {
            com.oplus.epona.Response responseExecute = com.oplus.epona.Epona.newCall(new com.oplus.epona.Request.Builder().setComponentName(COMPONENT_NAME).setActionName("getLastSleepReason").build()).execute();
            if (responseExecute == null || !responseExecute.isSuccessful()) {
                return -1;
            }
            return responseExecute.getBundle().getInt(RESULT);
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed("not supported before S_renamed");
    }

    public static void userActivity(long j_renamed, int i_renamed, int i2) throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.c_renamed()) {
            com.oplus.epona.Epona.newCall(new com.oplus.epona.Request.Builder().setComponentName(COMPONENT_NAME).setActionName("userActivity").withLong("when", j_renamed).withInt("event", i_renamed).withInt(com.android.providers.downloads.Downloads.Impl.COLUMN_FLAGS, i2).build()).execute();
            return;
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed("not supported before S_renamed");
    }
}
