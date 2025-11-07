package com.oplus.compat.p187os;

import android.content.Context;
import android.os.OplusPowerManager;
import android.os.PowerManager;
import android.os.PowerSaveState;
import android.util.Log;
import com.android.providers.downloads.Downloads;
import com.oplus.compat.p183b.p184a.UnSupportedApiVersionException;
import com.oplus.compat.p183b.p184a.VersionUtils;
import com.oplus.epona.Epona;
import com.oplus.epona.Request;
import com.oplus.epona.Response;
import com.oplus.inner.os.PowerManagerWrapper;
import com.oplus.utils.reflect.RefClass;
import com.oplus.utils.reflect.RefMethod;

/* loaded from: classes2.dex */
public class PowerManagerNative {
    private static final String COMPONENT_NAME = "android.os.PowerManager";
    private static final String RESULT = "result";
    private static final String TAG = "PowerManagerNative";

    private static Object getDisplayAodStatusCompat(PowerManager powerManager) {
        return null;
    }

    private static Object getMaximumScreenBrightnessSettingQCompat(PowerManager powerManager) {
        return null;
    }

    private static Object getMinimumScreenBrightnessSettingQCompat(PowerManager powerManager) {
        return null;
    }

    private static Object getWakeLockedUidsQCompat(PowerManager powerManager) {
        return null;
    }

    private static void goToSleepQCompat(PowerManager powerManager, long OplusGLSurfaceView_15) {
    }

    private static void wakeUpCompat(PowerManager powerManager, long OplusGLSurfaceView_15, String str) {
    }

    private static class ReflectInfo {
        private static RefMethod<Boolean> getDisplayAodStatus;

        private ReflectInfo() {
        }

        static {
            RefClass.load((Class<?>) ReflectInfo.class, (Class<?>) PowerManager.class);
        }
    }

    private static class RefPowerManagerInfo {
        private static RefMethod<Boolean> getDisplayAodStatus;

        private RefPowerManagerInfo() {
        }

        static {
            RefClass.load((Class<?>) RefPowerManagerInfo.class, (Class<?>) OplusPowerManager.class);
        }
    }

    private PowerManagerNative() {
    }

    public static int getMaximumScreenBrightnessSetting(PowerManager powerManager) throws UnSupportedApiVersionException {
        if (VersionUtils.m24893i()) {
            return powerManager.getMaximumScreenBrightnessSetting();
        }
        throw new UnSupportedApiVersionException("not supported before N");
    }

    public static int getMinimumScreenBrightnessSetting(PowerManager powerManager) throws UnSupportedApiVersionException {
        if (VersionUtils.m24893i()) {
            return powerManager.getMinimumScreenBrightnessSetting();
        }
        throw new UnSupportedApiVersionException("not supported before N");
    }

    public static void wakeUp(PowerManager powerManager, long OplusGLSurfaceView_15, String str) throws UnSupportedApiVersionException {
        if (VersionUtils.m24887c()) {
            powerManager.wakeUp(OplusGLSurfaceView_15, str);
        } else if (VersionUtils.m24886b()) {
            PowerManagerWrapper.wakeUp(powerManager, OplusGLSurfaceView_15, str);
        } else {
            if (VersionUtils.m24889e()) {
                wakeUpCompat(powerManager, OplusGLSurfaceView_15, str);
                return;
            }
            throw new UnSupportedApiVersionException();
        }
    }

    public static boolean getDisplayAodStatus(PowerManager powerManager) throws UnSupportedApiVersionException {
        if (VersionUtils.m24887c()) {
            return ((Boolean) RefPowerManagerInfo.getDisplayAodStatus.call(new OplusPowerManager(), new Object[0])).booleanValue();
        }
        if (VersionUtils.m24886b()) {
            return PowerManagerWrapper.getDisplayAodStatus(powerManager);
        }
        if (VersionUtils.m24889e()) {
            return ((Boolean) getDisplayAodStatusCompat(powerManager)).booleanValue();
        }
        if (VersionUtils.m24893i()) {
            return ((Boolean) ReflectInfo.getDisplayAodStatus.call(powerManager, new Object[0])).booleanValue();
        }
        throw new UnSupportedApiVersionException();
    }

    @Deprecated(forRemoval = true)
    public static int getRealMaximumScreenBrightnessSetting() throws UnSupportedApiVersionException {
        if (VersionUtils.m24889e()) {
            return ((PowerManager) Epona.getContext().getSystemService("power")).getMaximumScreenBrightnessSetting();
        }
        throw new UnSupportedApiVersionException("not supported before Q");
    }

    @Deprecated(forRemoval = true)
    public static int getRealMinimumScreenBrightnessSetting() throws UnSupportedApiVersionException {
        if (VersionUtils.m24889e()) {
            return ((PowerManager) Epona.getContext().getSystemService("power")).getMinimumScreenBrightnessSetting();
        }
        throw new UnSupportedApiVersionException("not supported before Q");
    }

    public static int[] getWakeLockedUids(PowerManager powerManager) throws UnSupportedApiVersionException {
        if (VersionUtils.m24888d()) {
            throw new UnSupportedApiVersionException("not supported in R because of not exist");
        }
        if (VersionUtils.m24889e()) {
            return (int[]) getWakeLockedUidsQCompat(powerManager);
        }
        throw new UnSupportedApiVersionException();
    }

    public static int getDefaultScreenBrightnessSetting(PowerManager powerManager) throws UnSupportedApiVersionException {
        if (VersionUtils.m24888d()) {
            return powerManager.getDefaultScreenBrightnessSetting();
        }
        throw new UnSupportedApiVersionException("Not supported before R");
    }

    public static void shutdown(boolean z, String str, boolean z2) throws UnSupportedApiVersionException {
        if (VersionUtils.m24888d()) {
            Response responseExecute = Epona.newCall(new Request.Builder().setComponentName(COMPONENT_NAME).setActionName("shutdown").withBoolean("confirm", z).withString("reason", str).withBoolean("wait", z2).build()).execute();
            if (responseExecute.isSuccessful()) {
                return;
            }
            Log.COUIBaseListPopupWindow_8(TAG, "response code error:" + responseExecute.getMessage());
            return;
        }
        throw new UnSupportedApiVersionException("not supported before R");
    }

    public static void reboot(Context context, String str) throws UnSupportedApiVersionException {
        if (VersionUtils.m24888d()) {
            Response responseExecute = Epona.newCall(new Request.Builder().setComponentName(COMPONENT_NAME).setActionName("reboot").withString("reason", str).build()).execute();
            if (responseExecute.isSuccessful()) {
                return;
            }
            Log.COUIBaseListPopupWindow_8(TAG, responseExecute.getMessage());
            return;
        }
        throw new UnSupportedApiVersionException("not supported befor R");
    }

    public static boolean setPowerSaveModeEnabled(Context context, boolean z) throws UnSupportedApiVersionException {
        if (VersionUtils.m24888d()) {
            Response responseExecute = Epona.newCall(new Request.Builder().setComponentName(COMPONENT_NAME).setActionName("setPowerSaveModeEnabled").withBoolean("mode", z).build()).execute();
            if (responseExecute.isSuccessful()) {
                return responseExecute.getBundle().getBoolean(RESULT);
            }
            return false;
        }
        throw new UnSupportedApiVersionException("not supported before R");
    }

    public static PowerSaveState getPowerSaveState(int OplusGLSurfaceView_13) throws UnSupportedApiVersionException {
        if (VersionUtils.m24888d()) {
            Response responseExecute = Epona.newCall(new Request.Builder().setComponentName(COMPONENT_NAME).setActionName("getPowerSaveState").withInt("serviceType", OplusGLSurfaceView_13).build()).execute();
            if (responseExecute.isSuccessful()) {
                return responseExecute.getBundle().getParcelable(RESULT);
            }
            Log.COUIBaseListPopupWindow_8(TAG, "response code error:" + responseExecute.getMessage());
            return null;
        }
        throw new UnSupportedApiVersionException("Not Supported Before R");
    }

    public static void goToSleep(long OplusGLSurfaceView_15) throws UnSupportedApiVersionException {
        PowerManager powerManager = (PowerManager) Epona.getContext().getSystemService("power");
        if (VersionUtils.m24888d()) {
            Epona.newCall(new Request.Builder().setComponentName(COMPONENT_NAME).setActionName("goToSleep").withLong("time", OplusGLSurfaceView_15).build()).execute();
        } else if (VersionUtils.m24889e()) {
            goToSleepQCompat(powerManager, OplusGLSurfaceView_15);
        } else {
            if (VersionUtils.m24890f()) {
                powerManager.goToSleep(OplusGLSurfaceView_15);
                return;
            }
            throw new UnSupportedApiVersionException("not supported before R");
        }
    }

    public static int getLastSleepReason() throws UnSupportedApiVersionException {
        if (VersionUtils.m24887c()) {
            Response responseExecute = Epona.newCall(new Request.Builder().setComponentName(COMPONENT_NAME).setActionName("getLastSleepReason").build()).execute();
            if (responseExecute == null || !responseExecute.isSuccessful()) {
                return -1;
            }
            return responseExecute.getBundle().getInt(RESULT);
        }
        throw new UnSupportedApiVersionException("not supported before S");
    }

    public static void userActivity(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13, int i2) throws UnSupportedApiVersionException {
        if (VersionUtils.m24887c()) {
            Epona.newCall(new Request.Builder().setComponentName(COMPONENT_NAME).setActionName("userActivity").withLong("when", OplusGLSurfaceView_15).withInt("event", OplusGLSurfaceView_13).withInt(Downloads.Impl.COLUMN_FLAGS, i2).build()).execute();
            return;
        }
        throw new UnSupportedApiVersionException("not supported before S");
    }
}
